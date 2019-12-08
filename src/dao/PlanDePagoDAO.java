package dao;

import dto.ObjectDTO;
import dto.PlanDePago;
import java.util.ArrayList;

public abstract class PlanDePagoDAO implements IDAO {

    /**
     * Devuelve una lista con todos los registros de la tabla
     * Planes de Pago
     * @return
     * @throws Exception 
     */
    public abstract ArrayList<PlanDePago> seleccionarTodos() throws Exception;
    
    /**
     * Devuelve el plan de pagos correspondiente a la combinacion
     * (unica) del cliente, producto y la fecha de adquisicion de este ultimo
     * @param cliente El codigo (llave primaria) del cliente
     * @param producto El codigo (llave primaria) del producto
     * @param fecha La fecha de adquisicion
     * @return
     * @throws Exception 
     */
    public abstract ObjectDTO seleccionarPlanDePagosPorClienteProductoFecha(
            Object cliente, Object producto, Object fecha) throws Exception;
    
    /**
     * Devuelve el monto mensual correspondiente que toca pagar
     * de un Plan de Pagos
     * @param llave El codigo (llave primaria) del Plan de Pagos
     * @return
     * @throws Exception 
     */
    public abstract double montoAPagar(Object llave) throws Exception;
    
    /**
     * Devuelve el monto restante que queda por pagar de un
     * Plan de Pagos
     * @param llave El codigo (llave primaria) del Plan de Pagos
     * @return
     * @throws Exception 
     */
    public abstract double montoRestante(Object llave) throws Exception;
    
}