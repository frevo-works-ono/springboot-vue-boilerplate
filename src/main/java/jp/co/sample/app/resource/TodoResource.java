package jp.co.sample.app.resource;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sample.domain.dto.LoginUser;
import jp.co.sample.domain.dto.Result;
import jp.co.sample.domain.model.Todo;
import jp.co.sample.domain.model.User;
import jp.co.sample.domain.service.TodoService;

@RestController
@RequestMapping("api/todos")
public class TodoResource {

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public Response get(@AuthenticationPrincipal LoginUser loginUser) {
        Result result = new Result();

        List<Todo> todos = todoService.findByUserId(loginUser.getUserId());

        result.setData(todos);

        return Response.ok(todos).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Response get(@PathVariable int id, @AuthenticationPrincipal LoginUser loginUser) {
        Result result = new Result();

        Todo todo = todoService.findByTodoId(id);

        if (todo == null || !loginUser.getUserId().equals(todo.getUser().getUserId())) {
            // NotFound
        }

        result.setData(todo);

        return Response.ok(result).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Response post(@Validated @RequestBody Todo entry,
            @AuthenticationPrincipal LoginUser loginUser) {
        Result result = new Result();

        entry.setUser(new User(loginUser.getUserId()));

        Todo todo = todoService.save(entry);

        result.setData(todo);

        return Response.ok(result).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Response put(@PathVariable int id, @Validated @RequestBody Todo entry,
            @AuthenticationPrincipal LoginUser loginUser) {
        Result result = new Result();

        Todo todo = todoService.findByTodoId(id);

        if (todo == null || !loginUser.getUserId().equals(todo.getUser().getUserId())) {
            // NotFound
        }

        todo = todoService.save(entry);

        result.setData(todo);

        return Response.ok(result).build();
    }
}
