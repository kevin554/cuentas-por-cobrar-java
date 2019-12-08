package dao;

import dto.Cliente;
import java.util.ArrayList;

public abstract class ClienteDAO implements IDAO{

    /**
     * Devuelve una lista con todas los registros de la tabla
     * Clientes
     * @return
     * @throws Exception 
     */
    public abstract ArrayList<Cliente> seleccionarTodos() throws Exception;
    
}