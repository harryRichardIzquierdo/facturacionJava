/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bago.models;

import com.bago.entitys.TipoProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author desarrollo
 */
@Stateless
public class TipoProductoFacade extends AbstractFacade<TipoProducto> {
    @PersistenceContext(unitName = "BagoFacturaProyecto1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProductoFacade() {
        super(TipoProducto.class);
    }
    
}
