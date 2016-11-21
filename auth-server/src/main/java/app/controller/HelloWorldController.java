package app.controller;

import app..model.Greeting;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by GrahamH on 11/08/2016.
 */
@RestController
public class HelloWorldController {

    private static String template = "Hello, %s!";
    private AtomicLong counter = new AtomicLong();

    @PreAuthorize(value = "hasRole('USER')")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Greeting sayHello(@PathVariable("name") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
