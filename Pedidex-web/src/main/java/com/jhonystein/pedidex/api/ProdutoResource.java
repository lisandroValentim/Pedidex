package com.jhonystein.pedidex.api;

import com.jhonystein.pedidex.model.Produto;
import com.jhonystein.pedidex.service.AbstractCrudService;
import com.jhonystein.pedidex.service.ProdutoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("produtos")
public class ProdutoResource extends AbstractCrudResource<Produto> {
    
    @Inject
    private ProdutoService service;
    
    @Override
    protected AbstractCrudService<Produto> getService() {
        return service;
    }
    
}
