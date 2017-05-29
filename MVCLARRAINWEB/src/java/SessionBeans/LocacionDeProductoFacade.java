/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Models.LocacionDeProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Home
 */
@Stateless
public class LocacionDeProductoFacade extends AbstractFacade<LocacionDeProducto> {

    @PersistenceContext(unitName = "MVCLARRAINWEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocacionDeProductoFacade() {
        super(LocacionDeProducto.class);
    }
    
}
