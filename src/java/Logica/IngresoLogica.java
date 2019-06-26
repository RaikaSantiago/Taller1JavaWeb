/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Ingreso;
import Persistencia.IngresoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author SISTEMAS
 */
@Stateless
public class IngresoLogica implements IngresoLogicaLocal {
    
    @EJB
    public IngresoFacadeLocal ingresoDAO;

    @Override
    public void registarIngreso(Ingreso i) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ingreso> consultarIngreso() {
        return ingresoDAO.findAll();
    }

    @Override
    public Ingreso consultarIngreso(Integer ingreso) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
