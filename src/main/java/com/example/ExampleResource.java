package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.xml.transform.Result;
import java.util.List;

@Path("/hello")
@ApplicationScoped
public class ExampleResource {

    @Inject
    UserRepository userRepository;


    @GET
    @RolesAllowed("Cherry")
    public Uni<Response> get(@Context SecurityContext securityContext, @PathParam(value = "id") Long id) {
        System.out.println(securityContext.getUserPrincipal().getName());
        return userRepository.findAll().list()
                .map(e -> Response.ok(e).build());
    }

    public class RandomDto {
        private String kek;

        public RandomDto(String kek) {
            this.kek = kek;
        }

        public String getKek() {
            return kek;
        }

        public void setKek(String kek) {
            this.kek = kek;
        }
    }
}