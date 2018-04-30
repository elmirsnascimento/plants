package br.com.esndev.plants.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Log;
import br.com.esndev.plants.enumerator.Stage;
import br.com.esndev.plants.exception.impl.ServiceException;
import br.com.esndev.plants.filter.LogFilter;
import br.com.esndev.plants.repository.LogRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;
import lombok.Getter;
import lombok.Setter;

@Service
public class LogServiceImpl extends BaseServiceImpl<Log, LogFilter, LogRepository> {

	@Autowired
	private @Getter @Setter PlantServiceImpl plantService;

	@Autowired
	private @Getter @Setter WateringServiceImpl wateringService;

	public List<Log> replicate(Log log) throws ServiceException {
		List<Log> logs = new ArrayList<Log>();
		logs.addAll(this.generateReplicas(log, plantService.getDaysToFlowering(log.getPlant().getId()),
				Stage.VEGETATIVE, log.getPlant().getVegetativeDate()));
		logs.addAll(this.generateReplicas(log, plantService.getDaysToHarvest(log.getPlant().getId()), Stage.FLOWERING,
				log.getPlant().getFloweringDate()));
		return logs;
	}

	private List<Log> generateReplicas(Log cloneableLog, int amoutOfTimesToReplicate, Stage stage, Date lastLogDate)
			throws ServiceException {
		List<Log> logs = new ArrayList<Log>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lastLogDate);
		try {
			int wateringFrequencyAmout = 1;
			for (int amout = 1; amout <= amoutOfTimesToReplicate; amout++) {
				if (wateringFrequencyAmout == cloneableLog.getWateringFrequency()) {
					Log log = (Log) cloneableLog.clone();

					log.setLogDate(calendar.getTime());
					log.setWatering(wateringService.generateWateringForLog(log));
					logs.add(log);
					wateringFrequencyAmout = 0;
				}
				calendar.add(Calendar.DATE, 1);
				wateringFrequencyAmout++;
			}
		} catch (CloneNotSupportedException e) {
			throw new ServiceException("Impossible to replicate " + stage.getDescription());
		}
		return logs;
	}

}
