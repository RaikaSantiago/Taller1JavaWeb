/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Contratista;
import Modelo.Empleado;
import Persistencia.EmpleadoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author SISTEMAS
 */
@Stateless
public class EmpleadoLogica implements EmpleadoLogicaLocal {
    
    @EJB
    public EmpleadoFacadeLocal empleadoDAO;
    
    @Override
    public void registrarEmpleado(Empleado e) throws Exception {
         if (e == null) {
            throw new Exception("El empleado no tiene información");
        }
        if (e.getCedulaempleado()==0) {
             throw new Exception ("La Cedula es Obligatorio");  
        }
        if (e.getNombreempleado().equals("")){
          throw new Exception ("El nombre es obligatorio");
        }
        Empleado objEmpleado = empleadoDAO.findCedula(e.getCedulaempleado());
        if (objEmpleado != null){
          throw new Exception ("El empleado ya existe!");
        }
        empleadoDAO.create(e);
    }
    


    @Override
    public Empleado consultarEmpleado(Integer cedula) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
    public void modificarEmpleado(Empleado e) throws Exception {
         if (e == null) {
            throw new Exception("El empleado no tiene información");
        }
        if (e.getCedulaempleado()==0) {
             throw new Exception ("La Cedula es Obligatorio");  
        }
        if (e.getNombreempleado().equals("")){
          throw new Exception ("El nombre es obligatorio");
        }
        Empleado objEmpleado = empleadoDAO.findCedula(e.getCedulaempleado());
        if (objEmpleado == null){
          throw new Exception ("El empleado ya existe!");
        }
        empleadoDAO.edit(e);
    }
   
    @Override
    public void eliminarEmpleado(Empleado e) throws Exception {
         if (e == null) {
            throw new Exception("El empleado no tiene información");
        }
        if (e.getCedulaempleado()==0) {
             throw new Exception ("La Cedula es Obligatorio");  
        }

        Empleado objBorrar = empleadoDAO.find(e.getCodigoempleado());
        if (objBorrar == null){
          throw new Exception ("El empleado no existe!");
        }
        if(objBorrar.getContratosList().size()>0 || objBorrar.getIngresoList().size()>0 ){
         throw new Exception("El Empleado tiene ingresos o contratos asociados");
       }
        empleadoDAO.remove(e);
    }

    @Override
    public List<Empleado> consultaEmpleados() {
         return empleadoDAO.findAll();
    }
}
