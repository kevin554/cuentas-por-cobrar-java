package dao.mySQL;

import conexion.Conexion;
import dto.CuentasPorCobrar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 * La implementacion DAO para MySQL para las Cuentas por 
 * Cobrar
 * 
 * @author Nico
 */
public class CuentasPorCobrarDAO extends dao.CuentaPorCobrarDAO {

    @Override
    public ArrayList<CuentasPorCobrar> seleccionarCuentasPorCobrar(Object obj) 
            throws Exception {
        ArrayList<CuentasPorCobrar> lista = new ArrayList<>();

        String consulta = "call cuentas_por_cobrar(?, ?)";
        
        Conexion con = Conexion.getOrCreate();
        PreparedStatement ps = con.invocarProcedimiento(consulta);
        
        if (obj instanceof Integer) {
            ps.setInt(1, (int) obj);
            ps.setString(2, "");
        }
        
        if (obj instanceof String) {
            ps.setInt(1, 0);
            ps.setString(2, (String) obj);
        }
        
        ResultSet rs = con.ejecutar(ps);

        if (rs == null) {
            throw new Exception("Error al traer datos");
        }

        while (rs.next()) {
            int codigoID = rs.getInt("codigo_id");
            String factura = rs.getString("sfactura");
            String nombre = rs.getString("snombre");
            String apellido = rs.getString("sapellido");
            String nombreProducto = rs.getString("snombre_producto");
            double precio = rs.getDouble("nprecio");
            double montoRestante = rs.getDouble("nmonto_restante");
            Date fechaAdquisicion = rs.getDate("dtfecha_adquisicion");
            Date fechaFinalizacion = rs.getDate("dtfecha_finalizacion");

            lista.add(new CuentasPorCobrar(codigoID, factura, nombre, apellido, 
                    nombreProducto, precio, montoRestante, fechaAdquisicion, 
                    fechaFinalizacion));
        }

        return lista;
    }
    
}
