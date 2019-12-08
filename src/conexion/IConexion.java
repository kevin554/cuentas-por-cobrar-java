package conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IConexion {

    public void conectar();
    
    public void desconectar();
    
    /**
     * Verifica si el programa se encuentra conectado a la base
     * de datos
     * @return 
     */
    public boolean estaConectado();
  
    /**
     * Deshabilita el commit para comenzar una transaccion en
     * la base de datos
     */
    public void comenzarTransaccion();
    
    /**
     * Termina y guarda los cambios en la base de datos
     */
    public void terminarTransaccion();
    
    /**
     * 
     * @param procedimiento El procedimiento a invocar
     * @return 
     */
    public PreparedStatement invocarProcedimiento(String procedimiento);
    
    /**
     * Ejecuta un procedimiento almacenado en la base de datos
     * @param procedimiento
     * @return 
     */
    public ResultSet ejecutar(PreparedStatement procedimiento);
    
    /**
     * Ejecuta un procedimiento almacenado en la base de datos
     * @param procedimiento
     * @return La cantidad de registros afectados
     */
    public int ejecutarSimple(PreparedStatement procedimiento);
    
}