package jp.co.sample.app.resource;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sample.domain.dto.Result;
import jp.co.sample.domain.model.Todo;
import jp.co.sample.domain.model.User;
import jp.co.sample.domain.service.TodoService;
import jp.co.sample.domain.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserResource {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "{id}/todos", method = RequestMethod.GET)
    public Response getTodosByUserId(@PathVariable int id) {
        Result result = new Result();
        List<Todo> todos = todoService.findByUserId(id);

        result.setData(todos);

        return Response.ok(result).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Response get(@PathVariable int id) {
        Result result = new Result();

        User user = userService.findByUserId(id);

        result.setData(user);

        return Response.ok(result).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Response post(@Validated @RequestBody User entry) {
        Result result = new Result();

        User todo = userService.save(entry);

        result.setData(todo);

        return Response.ok(result).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Response put(@PathVariable int id, @Validated @RequestBody User entry) {
        Result result = new Result();

        User todo = userService.save(entry);

        result.setData(todo);

        return Response.ok(result).build();
    }
}
