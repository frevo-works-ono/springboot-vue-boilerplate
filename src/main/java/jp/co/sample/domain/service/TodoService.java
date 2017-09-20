package jp.co.sample.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.model.Todo;
import jp.co.sample.domain.repository.TodoRepository;

@Service
@Transactional
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo findByTodoId(int todoId) {
        return todoRepository.findByTodoId(todoId);
    }

    public List<Todo> findByUserId(int userId) {
        return todoRepository.findByUserId(userId);
    }

    public Todo save(Todo entry) {
        return todoRepository.save(entry);
    }
}
