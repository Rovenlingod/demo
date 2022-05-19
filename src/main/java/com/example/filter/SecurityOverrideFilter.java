package com.example.filter;

import com.example.model.User;
import com.example.repository.UserRepository;
//import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;
import io.vertx.pgclient.PgPool;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Principal;
import java.util.concurrent.atomic.AtomicReference;

@Provider
@PreMatching
public class SecurityOverrideFilter implements ContainerRequestFilter {

    @Inject
    UserRepository userRepository;
    @Inject
    PgPool pgPool;
    @Override
    @Transactional
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String user = requestContext.getHeaders().getFirst("token");
        AtomicReference<String> name = new AtomicReference<>("");
        System.out.println("in filter");
        pgPool.
//        pgPool.preparedQuery("SELECT * FROM users WHERE name = ?1")
//                .execute(Tuple.of(user))
//                .map(m -> {
//                    User usr = m.iterator().hasNext() ? User.from(m.iterator().next()) : null;
//                    name.set(usr.getName());
//                    return usr;
//                })
//                .map(e -> {
//                    System.out.println(e.getClass());
//                    if (user != null ) {
//                        requestContext.setSecurityContext(new SecurityContext() {
//                            @Override
//                            public Principal getUserPrincipal() {
//                                return () -> user;
//                            }
//
//                            @Override
//                            public boolean isUserInRole(String r) {
//                                return r.equals(user);
//                            }
//
//                            @Override
//                            public boolean isSecure() {
//                                return false;
//                            }
//
//                            @Override
//                            public String getAuthenticationScheme() {
//                                return "basic";
//                            }
//                        });
//                    }
//                    return e;
//                })
//                .convert().toCompletionStage();
//                .onSubscription()
//                .invoke(e -> {
//                    System.out.println(e.getClass());
//                    if (user != null ) {
//                        requestContext.setSecurityContext(new SecurityContext() {
//                            @Override
//                            public Principal getUserPrincipal() {
//                                return () -> user;
//                            }
//
//                            @Override
//                            public boolean isUserInRole(String r) {
//                                System.out.println(name.toString());
//                                return r.equals(name.toString());
//                            }
//
//                            @Override
//                            public boolean isSecure() {
//                                return false;
//                            }
//
//                            @Override
//                            public String getAuthenticationScheme() {
//                                return "basic";
//                            }
//                        });
//                    }
//                })
//                .subscribe()
//                .asCompletionStage();

                //.emitOn(Infrastructure.getDefaultExecutor())
                //.await().indefinitely();
//                .onSubscription().call()
//                .invoke(e -> {
//                    System.out.println(e.getClass());
//                    if (user != null ) {
//                        requestContext.setSecurityContext(new SecurityContext() {
//                            @Override
//                            public Principal getUserPrincipal() {
//                                return () -> user;
//                            }
//
//                            @Override
//                            public boolean isUserInRole(String r) {
//                                return r.equals(user);
//                            }
//
//                            @Override
//                            public boolean isSecure() {
//                                return false;
//                            }
//
//                            @Override
//                            public String getAuthenticationScheme() {
//                                return "basic";
//                            }
//                        });
//                    }
//                })
//                .subscribe()
//                .asCompletionStage();


    }
}
