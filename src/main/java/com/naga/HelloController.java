package com.naga;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    public static final String HELLO_TEMPLATE = "Hello %s!";
    private final String sourceId = UUID.randomUUID().toString();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public HelloMessage sayHello(@RequestParam(name = "name", defaultValue = "World") String name) {
        return new HelloMessage(counter.incrementAndGet(), HELLO_TEMPLATE.formatted(name), sourceId);
    }

}
