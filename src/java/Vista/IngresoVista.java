/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.IngresoLogica;
import Modelo.Ingreso;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author SISTEMAS
 */
@ManagedBean
@RequestScoped
public class IngresoVista {
    
    @EJB
    private IngresoLogica ingresoLogica;
    
    private List<Ingreso> listaIngreso;
    
    public IngresoVista() {
    }
   
    public void setListaIngreso(List<Ingreso> listaIngreso) {
        this.listaIngreso = listaIngreso;
    }

    public List<Ingreso> getListaIngreso() {
        listaIngreso = ingresoLogica.consultarIngreso();
        return listaIngreso;
    }
    
    
    
}
