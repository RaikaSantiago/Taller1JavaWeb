/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Ingreso;
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
public class IngresoFacade extends AbstractFacade<Ingreso> implements IngresoFacadeLocal {
    @PersistenceContext(unitName = "DemoIngresoWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoFacade() {
        super(Ingreso.class);
    }

    @Override
    public Ingreso findIngreso(Long ni) {
       String Consulta = "SELECT i FROM Ingreso i WHERE i.numeroingreso ="+ni;
         try {
            Query query = em.createQuery(Consulta);
            return (Ingreso) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
