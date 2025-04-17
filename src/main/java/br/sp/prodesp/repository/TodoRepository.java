package br.sp.prodesp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sp.prodesp.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
