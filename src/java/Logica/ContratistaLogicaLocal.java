/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Contratista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALEJANDRA
 */
@Local
public interface ContratistaLogicaLocal {
    public ContratistaLogicaLocal consultarCodigo(Integer codigo) throws Exception;
    public void registrarContratista(Contratista c) throws Exception;
    public List<Contratista> consultasContratista();
    public void modificarContratista(Contratista c) throws Exception;
    public void eliminarContratista(Contratista c) throws Exception;
}
