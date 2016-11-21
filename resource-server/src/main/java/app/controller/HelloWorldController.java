package app.controller;

import app.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by GrahamH on 11/08/2016.
 */
@RestController
public class HelloWorldController {

    private static String template = "Hello, %s!";
    private AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Greeting sayHello(@PathVariable("name") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/throwError")
    public void throwError() throws Exception {
        throw new Exception("This is an exception");
    }
}
