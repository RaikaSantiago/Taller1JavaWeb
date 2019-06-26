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
         if (i == null) {
            throw new Exception("El empleado  no tiene ingreso");
        }
        if (i.getHoraentradaingreso()==null) {
             throw new Exception ("La hora de entrada es Obligatoria");  
        }
        if (i.getHorasalidaingreso()==null) {
             throw new Exception ("La hora de salida es Obligatoria");  
        }
        if (i.getAutorizadoingreso()==null) {
             throw new Exception ("Falta la autorización del ingreso");  
        }
        if (i.getEmpleadoingreso()==null) {
             throw new Exception ("Falta el codigo del empleado");  
        }
        if (i.getContratistaingreso()==null) {
             throw new Exception ("Falta el codigo del contratista");  
        }
        if (i.getFechaingreso().equals("")){
          throw new Exception ("Ingresar la fecha");
        }
        ingresoDAO.create(i);
    }

    @Override
    public List<Ingreso> consultarIngreso() {
        return ingresoDAO.findAll();
    }

    @Override
    public Ingreso consultarIngreso(Integer ingreso) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarIngreso(Ingreso e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarIngreso(Ingreso e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
