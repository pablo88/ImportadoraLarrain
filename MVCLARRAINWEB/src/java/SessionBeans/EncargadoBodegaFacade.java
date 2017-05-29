/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Models.EncargadoBodega;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author P_Silva
 */
@Stateless
public class EncargadoBodegaFacade extends AbstractFacade<EncargadoBodega> {

    @PersistenceContext(unitName = "MVCLARRAINWEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncargadoBodegaFacade() {
        super(EncargadoBodega.class);
    }
    
}
