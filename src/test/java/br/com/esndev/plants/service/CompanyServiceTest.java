package br.com.esndev.plants.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.esndev.plants.PlantsApplication;
import br.com.esndev.plants.constant.NamingTestConstant;
import br.com.esndev.plants.constant.NumericTestConstant;
import br.com.esndev.plants.entity.Company;
import br.com.esndev.plants.filter.CompanyFilter;
import br.com.esndev.plants.repository.CompanyRepository;
import br.com.esndev.plants.service.impl.CompanyServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlantsApplication.class)
public class CompanyServiceTest {

	CompanyServiceImpl companyService;

	@Mock
	CompanyRepository companyRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.companyService = new CompanyServiceImpl(companyRepository);
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testSaveWithValidEntity() throws Exception {
		Company entity = new Company(NamingTestConstant.CANNABIS_COMPANY_TEST_NAME);
		entity.setId(NumericTestConstant.LONG_UNRECHEABLE_SEQ);
		when(companyService.save(entity)).thenReturn(entity);
		assertNotNull(companyService.save(entity).getId());
		verify(companyRepository, times(1)).save(entity);
	}

	@Test
	public void testFindByFilterWithValidFilter() throws Exception {

		CompanyFilter filter = new CompanyFilter(NamingTestConstant.CANNABIS_COMPANY_TEST_NAME);
		Pageable pageable = Mockito.mock(Pageable.class);
		Page<Company> mockedCompanies = Mockito.mock(Page.class);

		when(companyService.findByFilter(filter, pageable)).thenReturn(mockedCompanies);

		Page<Company> pages = companyService.findByFilter(filter, pageable);

		when(pages.getTotalElements()).thenReturn(NumericTestConstant.LONG_ONE);

		assertEquals(pages.getTotalElements(), NumericTestConstant.LONG_ONE);
		verify(companyRepository, times(1)).findByFilter(filter, pageable);
	}

}
