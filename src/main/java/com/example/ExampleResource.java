package com.example;

import com.example.model.User;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
@ApplicationScoped
public class ExampleResource {


    @GET
    public Uni<List<User>> get() {
        User user = new User();
        user.persist();
        return User.listAll(Sort.by("name"));
    }
}