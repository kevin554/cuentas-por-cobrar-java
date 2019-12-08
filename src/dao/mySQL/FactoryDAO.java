package dao.mySQL;

import dao.ClienteDAO;
import dao.CuentaPorCobrarDAO;
import dao.CuotaDAO;
import dao.DetalleDePagosMensualesDAO;
import dao.PlanDePagoDAO;
import dao.ProductoDAO;

/**
 * Devuelve implementaciones DAO para el SGBD MySQL
 * 
 * @author Nico
 */
public class FactoryDAO extends dao.FactoryDAO {
    
    public static FactoryDAO getOrCreate() {
        if (instancia == null) {
            instancia = new FactoryDAO();
        }
        
        return (FactoryDAO) instancia;
    }

    @Override
    public ClienteDAO newClienteDAO() {
        return new dao.mySQL.ClienteDAO();
    }

    @Override
    public ProductoDAO newProductoDAO() {
        return new dao.mySQL.ProductoDAO();
    }

    @Override
    public PlanDePagoDAO newPlanDePagoDAO() {
        return new dao.mySQL.PlanDePagoDAO();
    }

    @Override
    public CuotaDAO newCuotaDAO() {
        return new dao.mySQL.CuotaDAO();
    }

    @Override
    public CuentaPorCobrarDAO newCuentaPorCobrarDAO() {
        return new dao.mySQL.CuentasPorCobrarDAO();
    }

    @Override
    public DetalleDePagosMensualesDAO newDetalleDePagosMensualesDAO() {
        return new dao.mySQL.DetalleDePagosMensualesDAO();
    }
    
}