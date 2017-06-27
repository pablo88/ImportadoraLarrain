/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Models.Cliente;
import Models.Compra;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author P_Silva
 */
@Stateless
public class CompraFacade extends AbstractFacade<Compra> {

    @PersistenceContext(unitName = "MVCLARRAINWEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Compra> allDatosCompra(Cliente idCliente) {
        try {
            return em.createNamedQuery("Compra.allDatosCompra").setParameter("idCliente",
                    idCliente).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public CompraFacade() {
        super(Compra.class);
    }

}
