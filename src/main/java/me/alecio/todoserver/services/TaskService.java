package me.alecio.todoserver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alecio.todoserver.models.Task;
import me.alecio.todoserver.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository repository;
	
	public Task create(Task task) {
		return this.repository.save(task);
	}
	public List<Task> research() {
		return this.repository.findAll();
	}
	public Optional<Task> research(String id) {
		return this.repository.findById(id);
	}
	public Task update(Task task, String id) {
		task.setId(id);
		return this.repository.save(task);
	}
	
	public void delete(String id) {
		this.repository.deleteById(id);
	}
}