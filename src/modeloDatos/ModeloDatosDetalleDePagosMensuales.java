package modeloDatos;

import dao.DetalleDePagosMensualesDAO;
import dao.FactoryDAO;
import dto.DetalleDePagosMensuales;
import dto.PlanDePago;
import java.util.ArrayList;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;

public class ModeloDatosDetalleDePagosMensuales extends AbstractTableModel {

    private ArrayList<DetalleDePagosMensuales> lista;
    private PlanDePago objPlanDePagos;
    private final static Logger logger = Logger.getRootLogger();
    
    public ModeloDatosDetalleDePagosMensuales() {
        super();
        
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "cuota";
                
            case 1:
                return "monto";
                
            case 2:
                return "fecha de pago";
                
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleDePagosMensuales obj = lista.get(rowIndex);
        
        return obj.obtenerColumna(columnIndex);
    }

    public void cargar(PlanDePago objPlanDePagos) {
        this.objPlanDePagos = objPlanDePagos;
        cargar();
    }

    public void cargar() {
        new LoadWorker().execute();
    }
    
    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    
    public ArrayList<DetalleDePagosMensuales> getLista() {
        return lista;
    }

    public void setLista(ArrayList<DetalleDePagosMensuales> lista) {
        this.lista = lista;
    }

    public PlanDePago getPlanDePagos() {
        return objPlanDePagos;
    }
    
    public void setPlanDePagos(PlanDePago objPlanDePagos) {
        this.objPlanDePagos = objPlanDePagos;
        cargar();
    }
    
    // </editor-fold>
    
    private class LoadWorker extends SwingWorker<Boolean, Boolean> {

        @Override
        protected Boolean doInBackground() throws Exception {
            FactoryDAO factory = FactoryDAO.getOrCreate();
            DetalleDePagosMensualesDAO dao = factory.newDetalleDePagosMensualesDAO();
            
            try {
                lista = dao.seleccionarTodos(objPlanDePagos);
            } catch (Exception ex) {
                logger.error("Hubo un error al traer los datos para la tabla "
                        + "de detalle de pagos mensuales " + ex.getMessage());
            }
            
            return true;
        }

        @Override
        protected void done() {
            fireTableDataChanged();
        }
        
    }
    
}