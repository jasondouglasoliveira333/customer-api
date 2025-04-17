package br.sp.prodesp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sp.prodesp.entity.Todo;
import br.sp.prodesp.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> list() {
		return todoRepository.findAll();
	}

	public Todo get(Integer id) {
		return todoRepository.findById(id).get();
	}

	public void save(Todo todo) {
		todoRepository.save(todo);
	}
	
	public void delete(Integer todoId) {
		todoRepository.deleteById(todoId);
	}
	
}
