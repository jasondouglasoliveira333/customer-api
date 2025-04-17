package br.sp.prodesp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.prodesp.entity.Todo;
import br.sp.prodesp.service.TodoService;

@CrossOrigin
@RestController
@RequestMapping("todos")
public class TodoController {
	
	private Logger log = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired
	private TodoService todoService; 

	
	@GetMapping
	public ResponseEntity<?> list(){
		log.info("In TodoController.list");
		try {
			List<Todo> todos = todoService.list();
			return ResponseEntity.ok().body(todos);
		}catch (Exception e) {
			log.error("Error obtendo a definicao da tabela", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable("id") Integer id){
		log.info("In TodoController.get");
		try {
			Todo todo = todoService.get(id);
			return ResponseEntity.ok().body(todo);
		}catch (Exception e) {
			log.error("Error obtendo a definicao da tabela", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> save(@RequestBody Todo todo){
		log.info("In TodoController.save:"  + todo);
		try {
			todoService.save(todo);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			log.error("Erro salvando o todo", e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		try {
			todoService.delete(id);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			log.error("Erro excluindo o todo", e);
			return ResponseEntity.badRequest().build();
		}
	}
	
			
}
