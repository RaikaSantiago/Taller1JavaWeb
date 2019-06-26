/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Ingreso;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.EJB;

/**
 *
 * @author SISTEMAS
 */
@Local
public interface IngresoLogicaLocal {
    public void registarIngreso(Ingreso i) throws Exception;
    public List<Ingreso> consultarIngreso();
    public Ingreso consultarIngreso(Integer ingreso) throws Exception;
     public void modificarIngreso(Ingreso e) throws Exception;
    public void eliminarIngreso(Ingreso e) throws Exception;
}
