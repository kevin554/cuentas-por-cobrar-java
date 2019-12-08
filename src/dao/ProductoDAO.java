package dao;

import dto.Producto;
import java.util.ArrayList;

public abstract class ProductoDAO implements IDAO {

    /**
     * Devuelve una lista con todos los registros de la tabla
     * Productos
     * @return
     * @throws Exception 
     */
    public abstract ArrayList<Producto> seleccionarTodos() throws Exception;
    
    /**
     * Devuelve un producto en base al nombre (unico)
     * @param nombre El nombre del producto
     * @return
     * @throws Exception 
     */
    public abstract Producto seleccionarProductoPorNombre(Object nombre) 
            throws Exception;
    
}