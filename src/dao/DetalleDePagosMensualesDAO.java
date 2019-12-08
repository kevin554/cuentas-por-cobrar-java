package dao;

import dto.DetalleDePagosMensuales;
import dto.ObjectDTO;
import java.util.ArrayList;

public abstract class DetalleDePagosMensualesDAO {

    /**
     * Devuelve una lista con los pagos mensuales de un cliente
     * @param obj El codigo (llave primaria) del Plan de Pagos
     * @return
     * @throws Exception 
     */
    public abstract ArrayList<DetalleDePagosMensuales> seleccionarTodos
        (ObjectDTO obj) throws Exception;
        
}