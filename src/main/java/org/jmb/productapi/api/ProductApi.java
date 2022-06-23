package org.jmb.productapi.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jmb.productapi.core.ValidationException;
import org.jmb.productapi.data.Product;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProductApi {
    
    @GET List<Product> listAll();
    @POST Product create(Product product) throws ValidationException;

    @GET
    @Path("/{id}")
    Product listOne(@PathParam("id") String id);

    @PUT
    @Path("/{id}")
    void update(@PathParam("id") String id, Product product);

    @DELETE
    @Path("/{id}")
    void delete(@PathParam("id") String id);
}
