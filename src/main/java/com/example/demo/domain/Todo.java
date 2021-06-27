package com.example.demo.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity 
public class Todo {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	private String title;
	private String targetdate;
	private String status;
	public Todo() {
		super();
	}
	public Todo(Long id, String title, String targetdate, String status) {
		super();
		this.id = id;
		this.title = title;
		this.targetdate = targetdate;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTargetdate() {
		return targetdate;
	}
	public void setTargetdate(String targetdate) {
		this.targetdate = targetdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
