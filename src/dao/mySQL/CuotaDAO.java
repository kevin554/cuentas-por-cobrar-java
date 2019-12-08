package dao.mySQL;

import conexion.Conexion;
import dto.Cuota;
import dto.ObjectDTO;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

/**
 * La implementacion DAO para MySQL de la tabla Cuotas
 * 
 * @author Nico
 */
public class CuotaDAO extends dao.CuotaDAO {

    @Override
    public ArrayList<Cuota> seleccionarTodas() throws Exception {
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
    public int pagarCuota(Object fecha, Object monto, Object planDePagos) 
            throws Exception {
        if (!(fecha instanceof Date)) {
            throw new Exception("la fecha debe ser valida");
        }
        
        Date fechaPago = (Date) fecha;
        
        if (!(monto instanceof Double)) {
            throw new Exception("El monto debe ser un entero");
        }
        
        double montoAbonado = (double) monto;
        
        if (!(planDePagos instanceof Integer)) {
            throw new Exception("El codigo del Plan de Pagos debe ser un entero");
        }
        
        int planDePagosId = (int) planDePagos;
        if (planDePagosId <= 0) {
            throw new Exception("El ID Plan de Pagos debe ser un entero "
                    + "positivo, era " + planDePagosId);
        }
        
        String sentencia = "call pr_pagar_cuota(?, ?, ?)";
        
        Conexion conexion = Conexion.getOrCreate();
        PreparedStatement ps = conexion.invocarProcedimiento(sentencia);
        ps.setDate(1, new java.sql.Date(fechaPago.getTime()));
        ps.setObject(2, montoAbonado, Types.DECIMAL);
        ps.setInt(3, planDePagosId);
        
        int nb = conexion.ejecutarSimple(ps);
        
        if (nb == 0) {
            throw new Exception("Error: No se pudo pagar la cuota");
        }
        
        return nb;
    }
    
}