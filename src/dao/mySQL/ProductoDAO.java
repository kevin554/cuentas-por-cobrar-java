package dao.mySQL;

import conexion.Conexion;
import dto.ObjectDTO;
import dto.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * La implementacion DAO para MySQL de la tabla Productos
 *
 * @author Nico
 */
public class ProductoDAO extends dao.ProductoDAO {

    @Override
    public ArrayList<Producto> seleccionarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ObjectDTO seleccionar(Object llave) throws Exception {
        Conexion conexion = Conexion.getOrCreate();
        String consulta;
        PreparedStatement ps = null;
        
        if (llave instanceof Integer) {
            consulta = "call producto_por_codigo(?)";
            ps = conexion.invocarProcedimiento(consulta);
            ps.setInt(1, (int) llave);
        } else if (llave instanceof String) {
            consulta = "call producto_por_nombre(?)";
            ps = conexion.invocarProcedimiento(consulta);
            ps.setString(1, (String) llave);
        }

        ResultSet rs = conexion.ejecutar(ps);

        if (rs == null) {
            throw new Exception("Error al traer datos");
        }

        if (!rs.next()) {
            throw new Exception("No se encontro objeto Producto");
        }

        int ID = rs.getInt("codigo_id");
        String nombre = rs.getString("snombre");
        String descripcion = rs.getString("sdescripcion");
        int precio = rs.getInt("nprecio");

        return new Producto(ID, nombre, descripcion, precio);
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

    @Override
    public Producto seleccionarProductoPorNombre(Object nombre) throws Exception {
        return (Producto) seleccionar(nombre);
    }

}
