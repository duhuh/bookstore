package com.nccjava.bookstore.resource;

import com.nccjava.bookstore.application.AccountApplicationService;
import com.nccjava.bookstore.domain.account.Account;
import com.nccjava.bookstore.infrastructure.jaxrs.CommonResponse;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accounts")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    private AccountApplicationService service;

    @POST
    public Response createUser(@Valid Account account){
        return CommonResponse.op(() -> service.createAccount(account));
    }

    @GET
    public Iterable<Account> getAll(){
        return service.getAllAccounts();
    }

}
