package org.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
@Path("/chairs")
//@Consumes("application/json")
@Consumes(MediaType.APPLICATION_JSON)
@Produces("application/json")
public class ChairResource {
    static List<Chair> chairs =new ArrayList(List.of(
            new Chair(12, 1, "red"),
            new Chair(11, 2, "blue"),
            new Chair(22, 3, "green"),
            new Chair(33, 4, "yellow"),
            new Chair(44, 5, "vlt")
    ));

    @GET
    public List<Chair> getchairs() {

        return chairs;

    }

    @GET
    @Path("/{code}")
    public Chair getchair(@PathParam("code") int size) {
        Chair chair = chairs.stream().filter(e->e.getSize()==size).findFirst().get();
        return chair;
    }

    @POST
    public Chair addchair(Chair chr) {
        chairs.add(chr);
        return chr;
    }

    @PUT
    @Path("/{code}")
    public Chair updatedchair(@PathParam("code") int code,Chair updatedchair) {
        Chair chr = chairs.stream().filter(e->e.getCode()==code).findFirst().get();
        chr.setColor(updatedchair.getColor());
        chr.setSize(updatedchair.getSize());

        return updatedchair;
    }

    @DELETE
    @Path("/{code}")
    public Chair deletechair(@PathParam("code") int code) {
        Chair employee = chairs.stream().filter(e->e.getSize()==code).findFirst().get();
        chairs.remove(employee);
        return employee;
    }


}
