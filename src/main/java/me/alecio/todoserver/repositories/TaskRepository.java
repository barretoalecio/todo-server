package me.alecio.todoserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.alecio.todoserver.models.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{

}
