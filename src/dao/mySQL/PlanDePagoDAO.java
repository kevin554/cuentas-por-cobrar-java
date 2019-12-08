package dao.mySQL;

import conexion.Conexion;
import dto.ObjectDTO;
import dto.PlanDePago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 * La implementacion DAO para MySQL de la tabla Plan de Pagos
 * 
 * @author Nico
 */
public class PlanDePagoDAO extends dao.PlanDePagoDAO {

    @Override
    public ArrayList<PlanDePago> seleccionarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ObjectDTO seleccionar(Object llave) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public ObjectDTO seleccionarPlanDePagosPorClienteProductoFecha(
            Object cliente, Object producto, Object fecha) throws Exception {
        if (!(cliente instanceof Integer)) {
            throw new Exception("El codigo del Cliente debe ser un entero");
        }
        
        int clienteID = (int) cliente;
        if (clienteID <= 0) {
            throw new Exception("El ID cliente debe ser un entero positivo, "
                    + "era " + clienteID);
        }
        
        if (!(producto instanceof Integer)) {
            throw new Exception("El codigo del Producto debe ser un entero");
        }
        
        int productoID = (int) producto;
        if (productoID <= 0) {
            throw new Exception("El ID producto debe ser un entero positivo, "
                    + "era " + productoID);
        }
        
        if (!(fecha instanceof Date)) {
            throw new Exception("La fecha debe ser valida");
        }
        
        Date fechaAdquisicion = (Date) fecha;
        
        String consulta = "call planes_de_pago_por_cliente_producto_fecha_"
                + "adquisicion(?, ?, ?)";
        
        Conexion conexion = Conexion.getOrCreate();
        PreparedStatement ps = conexion.invocarProcedimiento(consulta);
        ps.setInt(1, clienteID);
        ps.setInt(2, productoID);
        ps.setDate(3, new java.sql.Date(fechaAdquisicion.getTime()));
        
        ResultSet rs = conexion.ejecutar(ps);
        
        if (rs == null) {
            throw new Exception("Error al traer datos");
        }
        
        if (!rs.next()) {
            throw new Exception("No se encontro Plan de Pagos");
        }
        
        int codigoID = rs.getInt("codigo_id");
        int cantidadCuotas = rs.getInt("icantidad_cuotas");
        
        return new PlanDePago(codigoID, clienteID, productoID, 
                fechaAdquisicion, cantidadCuotas);
    }

    @Override
    public double montoAPagar(Object llave) throws Exception {
        if (!(llave instanceof Integer)) {
            throw new Exception("La llave debe ser un entero");
        }
        
        int planDePagosID = (int) llave;
        if (planDePagosID <= 0) {
            throw new Exception("El ID Plan de Pagos debe ser un entero "
                    + "positivo, era " + planDePagosID);
        }
        
        String consulta = "select fn_monto_a_pagar(?) as ipago";
        
        Conexion conexion = Conexion.getOrCreate();
        PreparedStatement ps = conexion.invocarProcedimiento(consulta);
        ps.setInt(1, planDePagosID);
        
        ResultSet rs = conexion.ejecutar(ps);
        
        if (rs == null) {
            throw new Exception("Error al traer datos");
        }
        
        if (!rs.next()) {
            throw new Exception("Error al calcular el monto a pagar");
        }
        
        return rs.getDouble("ipago");
    }

    @Override
    public double montoRestante(Object llave) throws Exception {
        if (!(llave instanceof Integer)) {
            throw new Exception("La llave debe ser un entero");
        }
        
        int planDePagosID = (int) llave;
        if (planDePagosID <= 0) {
            throw new Exception("El ID Plan de Pagos debe ser un entero "
                    + "positivo, era " + planDePagosID);
        }
        
        String consulta = "select fn_monto_restante(?) as imonto_restante";
        
        Conexion conexion = Conexion.getOrCreate();
        PreparedStatement ps = conexion.invocarProcedimiento(consulta);
        ps.setInt(1, planDePagosID);
        
        ResultSet rs = conexion.ejecutar(ps);
        
        if (rs == null) {
            throw new Exception("Error al traer datos");
        }
        
        if (!rs.next()) {
            throw new Exception("Error al calcular el monto restante");
        }
        
        return rs.getDouble("imonto_restante");
    }
    
}