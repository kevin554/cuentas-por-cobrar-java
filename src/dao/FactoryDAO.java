package dao;

/**
 * La idea es que a la hora de migrar a otro SGBD (a futuro) no
 * se modifique ninguna linea de codigo de la aplicacion, sino,
 * simplemente agregar la conexion al nuevo SGBD, su respectiva
 * implementacion DAO y modificar la instancia que esta clase 
 * devuelve
 * 
 * @author Nico
 */
public abstract class FactoryDAO {

    protected static FactoryDAO instancia = null;
    
    public static FactoryDAO getOrCreate() {
        if (instancia == null) {
            instancia = dao.mySQL.FactoryDAO.getOrCreate();
        }
        
        return instancia;
    }
    
    public abstract ClienteDAO newClienteDAO();
    
    public abstract ProductoDAO newProductoDAO();
    
    public abstract PlanDePagoDAO newPlanDePagoDAO();
    
    public abstract CuotaDAO newCuotaDAO();
    
    public abstract CuentaPorCobrarDAO newCuentaPorCobrarDAO();
    
    public abstract DetalleDePagosMensualesDAO newDetalleDePagosMensualesDAO();
    
}