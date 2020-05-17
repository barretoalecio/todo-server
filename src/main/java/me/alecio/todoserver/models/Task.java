package me.alecio.todoserver.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TASKS")
public class Task {
	
	@Id
	private String id;
	
	private String title;
	private String description;
	private Boolean complete;
	
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}
	
	public Boolean isComplete() {
		return this.complete;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
}
