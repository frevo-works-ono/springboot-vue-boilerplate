package jp.co.sample.app.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sample.domain.dto.Result;
import jp.co.sample.domain.model.Todo;
import jp.co.sample.domain.service.TodoService;

@RestController
@RequestMapping("api/users")
public class UserResource {
    @SuppressWarnings("unused")
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "{id}/todos", method = RequestMethod.GET)
    public Result getTodosByUserId(@PathVariable int id) {
        Result result = new Result();
        List<Todo> todos = todoService.findByUserId(id);

        return result;
    }
}
