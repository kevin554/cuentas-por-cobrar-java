package dao.mySQL;

import conexion.Conexion;
import dto.Cliente;
import dto.ObjectDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * La implementacion DAO para MySQL de la tabla Clientes
 * 
 * @author Nico
 */
public class ClienteDAO extends dao.ClienteDAO {

    @Override
    public ArrayList<Cliente> seleccionarTodos() throws Exception {
        return null;
    }

    @Override
    public ObjectDTO seleccionar(Object llave) throws Exception {
        if (!(llave instanceof Integer)) {
            throw new Exception("La llave debe ser un entero");
        }
        
        int ID = (int) llave;
        if (ID <= 0) {
            throw new Exception("El ID debe ser un entero positivo, era " + ID);
        }
        
        String consulta = "call cliente_por_codigo(?)";
        
        Conexion conexion = Conexion.getOrCreate();
        PreparedStatement ps = conexion.invocarProcedimiento(consulta);
        ps.setInt(1, ID);
        
        ResultSet rs = conexion.ejecutar(ps);
        
        if (rs == null) {
            throw new Exception("Error al traer datos");
        }
        
        if (!rs.next()) {
            throw new Exception("No se encontro objeto Cliente con ID " + ID);
        }
        
        String nombre = rs.getString("snombre");
        String apellido = rs.getString("sapellido");
        String factura = rs.getString("sfactura");
        String estado = rs.getString("sestado");
        
        return new Cliente(ID, nombre, apellido, factura, estado);
    }

    @Override
    public void insertar(ObjectDTO obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(ObjectDTO obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminar(ObjectDTO obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}