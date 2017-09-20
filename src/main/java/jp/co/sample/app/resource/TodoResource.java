package jp.co.sample.app.resource;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sample.domain.dto.Result;
import jp.co.sample.domain.service.TodoService;

@RestController
@RequestMapping("api/todos")
public class TodoResource {
    @SuppressWarnings("unused")
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Result get(@PathVariable int id) {
        Result result = new Result();

        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Response post() {
        Result result = new Result();
        return Response.status(201).entity(result).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Response put(@PathVariable int id) {
        Result result = new Result();

        return Response.ok(result).build();
    }
}
