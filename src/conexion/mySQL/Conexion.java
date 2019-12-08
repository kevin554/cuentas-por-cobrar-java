package conexion.mySQL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Conexion al SGBD MySQL
 * 
 * @author Nico
 */
public class Conexion extends conexion.Conexion {

    public static conexion.mySQL.Conexion getOrCreate() {
        if (instancia == null) {
            instancia = new conexion.mySQL.Conexion();
        }
        
        return (conexion.mySQL.Conexion) instancia;
    }
    
    private Conexion() {
        this.host = "localhost";
        this.baseDeDatos = "cuentasporcobrar";
        this.puerto = 3306;
        this.usuario = "root";
        this.password = "root";
    }

    @Override
    public void conectar() {
        if (this.estaConectado()) {
            return;
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException ex) {
            logger.error("Error al cagar el driver" + ex.getMessage());
        }
        
        String URL = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos
                + "?useSSL=false";
        
        try {
            con = DriverManager.getConnection(URL, usuario, password);
        } catch (SQLException ex) {
            logger.error("Error al crear la conexion" + ex.getMessage());
        }
    }

    @Override
    public void desconectar() {
        try {
            if (this.estaConectado()) {
                this.con.close();
            }
        } catch (SQLException ex) {
            logger.error("Error al cerrar la conexion" + ex.getMessage());
        }
    }

    @Override
    public boolean estaConectado() {
        if (this.con == null) {
            return false;
        }
        
        try {
            if (this.con.isClosed()) {
                return false;
            }
        } catch (SQLException ex) {
            this.con = null;
            logger.error("Hubo un error al verificar si existia una conexion" +
                    ex.getMessage());
            
            return false;
        }
        
        return true;
    }

    @Override
    public void comenzarTransaccion() {
        if (!this.estaConectado()) {
            this.conectar();
        }
        
        try {
            con.setAutoCommit(false);
        } catch (SQLException ex) {
            logger.error("Hubo un error al comenzar una transaccion"
                    + ex.getMessage());
        }
    }

    @Override
    public void terminarTransaccion() {
        try {
            con.commit();
        } catch (SQLException ex) {
            logger.error("Hubo un error al terminar una transaccion"
                    + ex.getMessage());
        }
    }

    @Override
    public PreparedStatement invocarProcedimiento(String procedimiento) {
        try {
            return con.prepareStatement(procedimiento);
        } catch (SQLException ex) {
            logger.error("Hubo un error al invocar un procedimiento "
                    + ex.getMessage());
            
            return null;
        }
    }

    @Override
    public ResultSet ejecutar(PreparedStatement procedimiento) {
        try {
            return procedimiento.executeQuery();
        } catch (SQLException ex) {
            logger.error("Error al ejecutar consulta con un Procedimiento "
                    + "Almacenado" + ex.getMessage());
            
            return null;
        }
    }

    @Override
    public int ejecutarSimple(PreparedStatement ps) {
        try {
            int nb = ps.executeUpdate();
            
            return nb;
        } catch (SQLException ex) {
            logger.error("Error al ejecutar sentencia con un Procedimiento "
                    + "Almacenado" + ex.getMessage());
            
            return 0;
        }
    }
    
}