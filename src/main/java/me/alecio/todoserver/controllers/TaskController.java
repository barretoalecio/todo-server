package me.alecio.todoserver.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.alecio.todoserver.models.Task;
import me.alecio.todoserver.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
	@Autowired
	private TaskService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Task> store(@RequestBody Task task) {
		return ResponseEntity.ok().body(this.service.create(task));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Task>> index() {
		return ResponseEntity.ok().body(this.service.research());
	}
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Optional<Task>> show(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok().body(this.service.research(id));
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<Task> update(@RequestBody Task task, @PathVariable(name = "id") String id) {
		return ResponseEntity.ok().body(this.service.update(task, id));
	}
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<String> destroy(@PathVariable(name = "id") String id) {
		this.service.delete(id);
		return ResponseEntity.ok("Success");
	}
}
