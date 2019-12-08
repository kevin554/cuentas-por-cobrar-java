package dao;

import dto.CuentasPorCobrar;
import java.util.ArrayList;

public abstract class CuentaPorCobrarDAO {

    /** 
     * Devuelve una lista con todas las Cuentas por Cobrar
     * @param obj
     * @return
     * @throws Exception 
     */
    public abstract ArrayList<CuentasPorCobrar> seleccionarCuentasPorCobrar
        (Object obj) throws Exception;
        
}