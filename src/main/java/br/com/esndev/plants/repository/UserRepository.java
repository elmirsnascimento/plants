package br.com.esndev.plants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.User;
import br.com.esndev.plants.filter.UserFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User, UserFilter> {

	@Query("select new User(u.id, u.name, u.email) from User u where "
			+ " (:#{#filter.name} is null or UPPER(u.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%'))) "
			+ " and (:#{#filter.email} is null or UPPER(u.email) = UPPER(:#{#filter.email}) )")
	List<User> findByFilter(@Param("filter") UserFilter filter);

	@Query("select u.profilePicture from User u where u.id = :#{#idUser}  ")
	byte[] getUserProfilePicture(@Param("idUser") Long idUser);

}