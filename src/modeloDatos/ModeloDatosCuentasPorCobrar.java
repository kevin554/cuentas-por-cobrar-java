package modeloDatos;

import dao.CuentaPorCobrarDAO;
import dao.FactoryDAO;
import dto.CuentasPorCobrar;
import java.util.ArrayList;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;

public class ModeloDatosCuentasPorCobrar extends AbstractTableModel {

    private ArrayList<CuentasPorCobrar> lista;
    private Object filtro;
    private final static Logger logger = Logger.getRootLogger();

    public ModeloDatosCuentasPorCobrar() {
        super();
        
        filtro = "";
        lista = new ArrayList();
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "codigo";
                
            case 1:
                return "factura";
                
            case 2:
                return "nombre";
                
            case 3:
                return "apellido";
                
            case 4:
                return "producto";
                
            case 5:
                return "precio";
                
            case 6:
                return "monto restante";
                
            case 7:
                return "fecha adquisicion";
                
            case 8:
                return "fecha finalizacion";
                
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CuentasPorCobrar obj = lista.get(rowIndex);
        
        return obj.obtenerColumna(columnIndex);
    }
    
    public void cargar() {
        new LoadWorker().execute();
    }

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    
    public Object getFiltro() {
        return filtro;
    }

    public void setFiltro(Object filtro) {
        this.filtro = filtro;
        cargar();
    }

    public ArrayList<CuentasPorCobrar> getLista() {
        return lista;
    }

    public void setLista(ArrayList<CuentasPorCobrar> lista) {
        this.lista = lista;
    }
    
    // </editor-fold>
    
    private class LoadWorker extends SwingWorker<Boolean, Boolean> {

        @Override
        protected Boolean doInBackground() throws Exception {
            FactoryDAO factory = FactoryDAO.getOrCreate();
            CuentaPorCobrarDAO dao = factory.newCuentaPorCobrarDAO();
            
            try {
                lista = dao.seleccionarCuentasPorCobrar(filtro);
            } catch (Exception ex) {
                logger.error("Hubo un error al traer datos para la tabla de "
                        + "cuentas por cobrar ", ex);
            }
            
            return true;
        }

        @Override
        protected void done() {
            fireTableDataChanged();
        }
        
    }
    
}