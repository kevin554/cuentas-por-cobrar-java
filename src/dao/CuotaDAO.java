package dao;

import dto.Cuota;
import java.util.ArrayList;

public abstract class CuotaDAO implements IDAO {

    /**
     * Devuelve una lista con todos los registros de la tabla
     * Cuotas
     * @return
     * @throws Exception 
     */
    public abstract ArrayList<Cuota> seleccionarTodas() throws Exception;
    
    /**
     * 
     * @param fecha La fecha de pago
     * @param monto El monto pagado
     * @param planDePagos El codigo del Plan de Pagos al que pertenece
     * @return
     * @throws Exception 
     */
    public abstract int pagarCuota(Object fecha, Object monto,
            Object planDePagos) throws Exception;
    
}