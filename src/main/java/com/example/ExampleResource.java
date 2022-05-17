package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
@ApplicationScoped
public class ExampleResource {

    @Inject
    UserRepository userRepository;

    @GET
    @Path("/{id}")
    public Uni<RandomDto> get(@PathParam(value = "id") Long id) {
        return userRepository.findById(id).map(e -> new RandomDto(e.getName()));
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