/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.ContratistaLogicaLocal;
import Modelo.Contratista;
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
 * @author ALEJANDRA
 */
@ManagedBean
@RequestScoped
public class ContratistaVista {

    @EJB
    private ContratistaLogicaLocal contratistaLogica;

    private List<Contratista> listaContratista;
    private InputText txtNitContratista;
    private InputText txtNombreContratista;
    private SelectOneMenu cmbEstadoContratista;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;
    private CommandButton btnEliminar;
    private Contratista selectedContratista;

    public ContratistaVista() {
    }

    public void setListaContratista(List<Contratista> listaContratista) {
        this.listaContratista = listaContratista;
    }

    public InputText getTxtNitContratista() {
        return txtNitContratista;
    }

    public void setTxtNitContratista(InputText txtNitContratista) {
        this.txtNitContratista = txtNitContratista;
    }

    public InputText getTxtNombreContratista() {
        return txtNombreContratista;
    }

    public void setTxtNombreContratista(InputText txtNombreContratista) {
        this.txtNombreContratista = txtNombreContratista;
    }

    public SelectOneMenu getCmbEstadoContratista() {
        return cmbEstadoContratista;
    }

    public void setCmbEstadoContratista(SelectOneMenu cmbEstadoContratista) {
        this.cmbEstadoContratista = cmbEstadoContratista;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public List<Contratista> getListaContratista() {
        listaContratista = contratistaLogica.consultasContratista();
        return listaContratista;
    }

    public void registrarContratista() {
      try {
        Contratista nuevoContratista = new Contratista();
        nuevoContratista.setNitcontratista(
                Long.parseLong(txtNitContratista.getValue().toString())
        );
        nuevoContratista.setNombrecontratista(
                (txtNombreContratista.getValue().toString())
        );
        nuevoContratista.setEstadocontratista(
                (cmbEstadoContratista.getValue().toString())
        );
        contratistaLogica.registrarContratista(nuevoContratista);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "Contratista registrado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(ContratistaVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
    
    public void seleccionarContratista(SelectEvent e){
        selectedContratista = (Contratista)e.getObject();
        txtNitContratista.setValue(selectedContratista.getNitcontratista());
        txtNombreContratista.setValue(selectedContratista.getNombrecontratista());
        cmbEstadoContratista.setValue(selectedContratista.getEstadocontratista());
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public Contratista getSelectedContratista() {
        return selectedContratista;
    }

    public void setSelectedContratista(Contratista selectedContratista) {
        this.selectedContratista = selectedContratista;
    }

    public void modificarContratista() {
      try {
        Contratista nuevoContratista = selectedContratista;
        nuevoContratista.setNitcontratista(
                Long.parseLong(txtNitContratista.getValue().toString())
        );
        nuevoContratista.setNombrecontratista(
                (txtNombreContratista.getValue().toString())
        );
        nuevoContratista.setEstadocontratista(
                (cmbEstadoContratista.getValue().toString())
        );
        contratistaLogica.modificarContratista(nuevoContratista);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "Contratista modificado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(ContratistaVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
    
    public void eliminarContratista(){
       
          try {
              contratistaLogica.eliminarContratista(selectedContratista);
               FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "Contratista Eliminado Satisfactoriamente"));
          } catch (Exception ex) {
               FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 ex.getMessage()));
              Logger.getLogger(ContratistaVista.class.getName()).log(Level.SEVERE, null, ex);
          }
      
    }

}
