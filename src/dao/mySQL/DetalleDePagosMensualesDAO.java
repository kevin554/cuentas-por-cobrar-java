package dao.mySQL;

import conexion.Conexion;
import dto.DetalleDePagosMensuales;
import dto.ObjectDTO;
import dto.PlanDePago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 * La implementacion DAO para MySQL de la vista Detalle de Pagos
 * Mensuales
 * 
 * @author Nico
 */
public class DetalleDePagosMensualesDAO extends dao.DetalleDePagosMensualesDAO {

    @Override
    public ArrayList<DetalleDePagosMensuales> seleccionarTodos(ObjectDTO obj) 
            throws Exception {
        PlanDePago objPlanDePagos = (PlanDePago) obj;
        ArrayList<DetalleDePagosMensuales> lista = new ArrayList<>();

        String consulta = "call detalle_de_pagos_mensuales(?)";
        
        Conexion conexion = Conexion.getOrCreate();
        PreparedStatement ps = conexion.invocarProcedimiento(consulta);
        ps.setInt(1, objPlanDePagos.getCodigoID());

        ResultSet rs = conexion.ejecutar(ps);

        if (rs == null) {
            throw new Exception("Error al traer datos");
        }

        while (rs.next()) {
            int cuota = rs.getInt("icuota");
            int monto = rs.getInt("nmonto");
            Date fechaPago = rs.getDate("dtfecha_pago");

            lista.add(new DetalleDePagosMensuales(cuota, monto, fechaPago));
        }

        return lista;
    }
    
}
