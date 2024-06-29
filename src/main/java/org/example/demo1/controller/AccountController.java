package org.example.demo1.controller;

import org.example.demo1.dto.AccountGetDto;
import org.example.demo1.dto.BalanceChange;
import org.example.demo1.dto.CreateAccountDto;
import org.example.demo1.entity.Account;
import org.example.demo1.service.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/account")
public class AccountController {

    private final AccountService accountService = new AccountService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateAccountDto createAccountDto) throws Exception {
        System.out.println("---------TEST Controller----------------------");
        accountService.create(createAccountDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@PathParam("id") Long id){
        List<AccountGetDto> accounts = accountService.findAll(id);
        return Response.ok(accounts).build();

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response changeBalance(BalanceChange balanceChange) throws Exception {
        accountService.update(balanceChange);
        return Response.ok().build();

    }


}
