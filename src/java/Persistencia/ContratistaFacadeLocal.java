/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Contratista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALEJANDRA
 */
@Local
public interface ContratistaFacadeLocal {

    void create(Contratista contratista);

    void edit(Contratista contratista);

    void remove(Contratista contratista);

    Contratista find(Object id);

    List<Contratista> findAll();
    
    Contratista findNit(Long nit);

    List<Contratista> findRange(int[] range);

    int count();
    
}
