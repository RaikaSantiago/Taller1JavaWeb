
package Logica;

import Modelo.Empleado;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.EJB;

/**
 *
 * @author SISTEMAS
 */
@Local
public interface EmpleadoLogicaLocal {
    public void registrarEmpleado(Empleado e) throws Exception;
    public Empleado consultarEmpleado(Integer cedula) throws Exception;
    public List<Empleado> consultaEmpleados();
    public void modificarEmpleado(Empleado e) throws Exception;
    public void eliminarEmpleado(Empleado e) throws Exception;
}
