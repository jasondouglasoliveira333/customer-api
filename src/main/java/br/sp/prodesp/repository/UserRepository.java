package br.sp.prodesp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.sp.prodesp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String username);

	@Query("update User u set u.name = :name where u.id = :id")
	@Modifying
	void updateName(@Param("name") String name, @Param("id") Integer id);

}
