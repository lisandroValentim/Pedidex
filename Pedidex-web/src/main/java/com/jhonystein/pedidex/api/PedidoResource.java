package com.jhonystein.pedidex.api;

import com.jhonystein.pedidex.model.Pedido;
import com.jhonystein.pedidex.service.AbstractCrudService;
import com.jhonystein.pedidex.service.PedidoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("pedidos")
public class PedidoResource extends AbstractCrudResource<Pedido> {

    @Inject
    private PedidoService service;

    @Override
    protected AbstractCrudService<Pedido> getService() {
        return service;
    }
    
}
