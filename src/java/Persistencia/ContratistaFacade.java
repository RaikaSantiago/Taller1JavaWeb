/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Contratista;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ALEJANDRA
 */
@Stateless
public class ContratistaFacade extends AbstractFacade<Contratista> implements ContratistaFacadeLocal {

    @PersistenceContext(unitName = "DemoIngresoWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratistaFacade() {
        super(Contratista.class);
    }

    @Override
    public Contratista findNit(Long nit) {
        String consulta = "select c from Contratista c where c.nitcontratista=" + nit;
        try {
            Query query = em.createQuery(consulta);
            return (Contratista) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

    }

}
