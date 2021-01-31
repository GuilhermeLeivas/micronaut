package br.com.leivas.resource;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Produces;

@Controller("/hello")
public class HelloWorldResource {

    @Get("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloFromMicronaut(@PathVariable String name) {
        StringBuilder sb = new StringBuilder("Hello from Micronaut ");
        return sb.append(name).append("!").toString();
    }
}
