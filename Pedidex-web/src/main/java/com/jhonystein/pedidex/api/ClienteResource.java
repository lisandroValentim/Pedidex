package com.jhonystein.pedidex.api;

import com.jhonystein.pedidex.model.Cliente;
import com.jhonystein.pedidex.service.AbstractCrudService;
import com.jhonystein.pedidex.service.ClienteService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("clientes")
public class ClienteResource extends AbstractCrudResource<Cliente> {

    @Inject
    private ClienteService service;

    @Override
    protected AbstractCrudService<Cliente> getService() {
        return service;
    }

}
