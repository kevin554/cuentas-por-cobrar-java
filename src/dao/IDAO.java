package dao;

import dto.ObjectDTO;


/**
 * Una interfaz generica con las operaciones basicas (Insertar,
 * Actualizar, Eliminar, Seleccionar) en una base de datos.
 * 
 * Los objetos que necesiten usar esta interfaz, deben extender
 * de la clase abstracta ObjectDTO
 * 
 * @author Nico
 */
public interface IDAO {

    /**
     * Selecciona un registro de la base de datos
     * @param llave El ID (llave primaria) del registro
     * @return
     * @throws Exception 
     */
    public ObjectDTO seleccionar(Object llave) throws Exception;
    
    /**
     * Inserta un registro a la base de datos
     * @param obj El objeto a insertar
     * @throws Exception 
     */
    public void insertar(ObjectDTO obj) throws Exception;
    
    /**
     * Actualiza un registro de la base de datos
     * @param obj El objeto a actualizar
     * @throws Exception 
     */
    public void actualizar(ObjectDTO obj) throws Exception;
    
    /**
     * Elimina un registro de la base de datos
     * @param obj El objeto a eliminar
     * @throws Exception 
     */
    public void eliminar(ObjectDTO obj) throws Exception;
    
}