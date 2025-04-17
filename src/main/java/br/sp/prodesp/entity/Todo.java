package br.sp.prodesp.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.sp.prodesp.enums.TodoType;


@Entity
public class Todo {

	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	@Enumerated(EnumType.STRING)
	private TodoType status; 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TodoType getStatus() {
		return status;
	}

	public void setStatus(TodoType status) {
		this.status = status;
	}

}
