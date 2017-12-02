package com.jhonystein.pedidex.api;

import com.jhonystein.pedidex.model.Entidade;
import com.jhonystein.pedidex.service.AbstractCrudService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class AbstractCrudResource<T extends Entidade> {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> findAll() {
        return getService().findAll();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public T findById(@PathParam("id") Long id) {
        return getService().findById(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(T entity) {
        return Response.status(Response.Status.CREATED)
                .entity(getService().insert(entity))
                .build();
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(T entity, @PathParam("id") Long id) {
        if (!id.equals(entity.getId())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("ID do objeto difere do ID da URL")
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(getService().update(entity))
                .build();
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        getService().remove(id);
        return Response.status(Response.Status.NO_CONTENT)
                .build();
    }
    
    protected abstract AbstractCrudService<T> getService();
}
