
package Vista;

import Logica.EmpleadoLogica;
import Logica.EmpleadoLogicaLocal;
import Modelo.Empleado;
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
public class empleadoVista {

    @EJB
    private EmpleadoLogicaLocal empleadoLogica;
    
    private List<Empleado> listaEmpleado;
    private InputText txtcedulaEmpleado;
    private InputText txtNombreEmpleado;
    private InputText txtApellidoEmpleado;
    private InputText txtTelefonoEmpleado;
    private InputText txtCargoEmpleado;
    private SelectOneMenu cmbEstadoEmpleado;
    private CommandButton btnRegistrar; 
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;
    private CommandButton btnEliminar;
    private Empleado selectedEmpleado;

 
    public void setEmpleadoLogica(EmpleadoLogica empleadoLogica) {
        this.empleadoLogica = empleadoLogica;
    }

    public InputText getTxtcedulaEmpleado() {
        return txtcedulaEmpleado;
    }

    public void setTxtcedulaEmpleado(InputText txtcedulaEmpleado) {
        this.txtcedulaEmpleado = txtcedulaEmpleado;
    }

    public InputText getTxtNombreEmpleado() {
        return txtNombreEmpleado;
    }

    public void setTxtNombreEmpleado(InputText txtNombreEmpleado) {
        this.txtNombreEmpleado = txtNombreEmpleado;
    }

    public InputText getTxtApellidoEmpleado() {
        return txtApellidoEmpleado;
    }

    public void setTxtApellidoEmpleado(InputText txtApellidoEmpleado) {
        this.txtApellidoEmpleado = txtApellidoEmpleado;
    }

    public InputText getTxtTelefonoEmpleado() {
        return txtTelefonoEmpleado;
    }

    public void setTxtTelefonoEmpleado(InputText txtTelefonoEmpleado) {
        this.txtTelefonoEmpleado = txtTelefonoEmpleado;
    }

    public InputText getTxtCargoEmpleado() {
        return txtCargoEmpleado;
    }

    public void setTxtCargoEmpleado(InputText txtCargoEmpleado) {
        this.txtCargoEmpleado = txtCargoEmpleado;
    }

    public SelectOneMenu getCmbEstadoEmpleado() {
        return cmbEstadoEmpleado;
    }

    public void setCmbEstadoEmpleado(SelectOneMenu cmbEstadoEmpleado) {
        this.cmbEstadoEmpleado = cmbEstadoEmpleado;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public Empleado getSelectedEmpleado() {
        return selectedEmpleado;
    }

    public void setSelectedEmpleado(Empleado selectedEmpleado) {
        this.selectedEmpleado = selectedEmpleado;
    }
    
    public void seleccionarEmpleado (SelectEvent e){
     selectedEmpleado = (Empleado) e.getObject();
     txtcedulaEmpleado.setValue(selectedEmpleado.getCedulaempleado());
     txtNombreEmpleado.setValue(selectedEmpleado.getNombreempleado());
     txtApellidoEmpleado.setValue(selectedEmpleado.getApellidoempleado());
     txtTelefonoEmpleado.setValue(selectedEmpleado.getTelefonoempleado());
//     txtCargoEmpleado.setValue(selectedEmpleado.getCargoempleado());
     cmbEstadoEmpleado.setValue(selectedEmpleado.getEstadoempleado());
    }
    public empleadoVista() {
    }

    public List<Empleado> getListaEmpleado() {
        listaEmpleado = empleadoLogica.consultaEmpleados();
        return listaEmpleado;
    }
    
    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

     public void registrarEmpleado() {
      try {
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setCedulaempleado(
                Long.parseLong(txtcedulaEmpleado.getValue().toString())
        );
        nuevoEmpleado.setNombreempleado(
                (txtNombreEmpleado.getValue().toString())
        );
        nuevoEmpleado.setApellidoempleado(
                (txtApellidoEmpleado.getValue().toString())
        );
        nuevoEmpleado.setTelefonoempleado(
                (txtTelefonoEmpleado.getValue().toString())
        );
//        nuevoEmpleado.setCargoempleado(
//                (txtCargoEmpleado.getValue().toString())
//        );
        nuevoEmpleado.setEstadoempleado(
                (cmbEstadoEmpleado.getValue().toString())
        );
        empleadoLogica.registrarEmpleado(nuevoEmpleado);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "Empleado registrado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(empleadoVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }    
    
  public void modificarEmpleado() {
      try {
        Empleado nuevoEmpleado = selectedEmpleado;
        nuevoEmpleado.setCedulaempleado(
                Long.parseLong(txtcedulaEmpleado.getValue().toString())
        );
        nuevoEmpleado.setNombreempleado(
                (txtNombreEmpleado.getValue().toString())
        );
        nuevoEmpleado.setApellidoempleado(
                (txtApellidoEmpleado.getValue().toString())
        );
        nuevoEmpleado.setTelefonoempleado(
                (txtTelefonoEmpleado.getValue().toString())
        );
//        nuevoEmpleado.setCargoempleado(
//                (txtCargoEmpleado.getValue().toString())
//        );
        nuevoEmpleado.setEstadoempleado(
                (cmbEstadoEmpleado.getValue().toString())
        );
        empleadoLogica.modificarEmpleado(nuevoEmpleado);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "Empleado modificado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(empleadoVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
   
  public void eliminarEmpleado() {
      try {
       
        empleadoLogica.eliminarEmpleado(selectedEmpleado);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "Empleado eliminado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(empleadoVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }    
}
