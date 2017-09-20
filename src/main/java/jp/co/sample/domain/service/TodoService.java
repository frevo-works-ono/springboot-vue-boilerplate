package jp.co.sample.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sample.domain.model.Todo;
import jp.co.sample.domain.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findByUserId(int userId) {
        return todoRepository.findByUserId(userId);
    }

    public Todo save(Todo entry) {
        return todoRepository.save(entry);
    }
}
