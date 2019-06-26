/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelo.Empleado;
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
public class EmpleadoFacade extends AbstractFacade<Empleado> implements EmpleadoFacadeLocal {
    @PersistenceContext(unitName = "DemoIngresoWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    @Override
    public Empleado findCedula(Long cedula) {
        String Consulta = "select e from Empleado e where e.cedulaempleado ="+cedula;
         try {
            Query query = em.createQuery(Consulta);
            return (Empleado) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
