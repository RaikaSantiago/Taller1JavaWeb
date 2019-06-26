/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Contratista;
import Persistencia.ContratistaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ALEJANDRA
 */
@Stateless
public class ContratistaLogica implements ContratistaLogicaLocal {

    @EJB
    public ContratistaFacadeLocal contratistaDAO;

    @Override
    public ContratistaLogicaLocal consultarCodigo(Integer codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
@Override
    public void registrarContratista(Contratista c) throws Exception {
        if (c == null) {
            throw new Exception("El contratista no tiene información");
        }
        if (c.getNitcontratista()==0) {
             throw new Exception ("El nit es Obligatorio perro");  
        }
        if (c.getNombrecontratista().equals("")){
          throw new Exception ("El nombre es obligatorio");
        }
        Contratista objContratista = contratistaDAO.findNit(c.getNitcontratista());
        if (objContratista != null){
          throw new Exception ("El contratista ya existe!");
        }
        contratistaDAO.create((Contratista) c);
    }

    @Override
    public List<Contratista> consultasContratista() {
        return contratistaDAO.findAll();//To change body of generated methods, choose Tools | Templates.
    }

    public void modificarContratista(Contratista c) throws Exception {
        if(c==null){
            throw new Exception("El Nit hacido modificado");
        }
        if(c.getNitcontratista()==0){
            throw new Exception("El Nit hacido modificado");
        }
        if(c.getNombrecontratista().equals("")){
            throw new Exception("El nombre de contratista");
        }
        Contratista objContratista = contratistaDAO.findNit(c.getNitcontratista());
        if(objContratista == null){
            throw new Exception("El usuario hacido Borrado");
        }
        contratistaDAO.edit(c);
    }

    @Override
    public void eliminarContratista(Contratista c) throws Exception {
       if(c==null){
           throw new Exception("El contratista no tiene información");
       }
       Contratista objBorrar = contratistaDAO.find(c.getCodigocontratista());
       if(objBorrar==null){
         throw new Exception("El contratista no existe");  
       }
       if(objBorrar.getContratosList().size()>0 || objBorrar.getIngresoList().size()>0 ){
         throw new Exception("El contratista tiene ingresos o contratos asociados");
       }
       contratistaDAO.remove(objBorrar);
    }
  
}
