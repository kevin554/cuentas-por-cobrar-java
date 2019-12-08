package grafica;

import dao.ClienteDAO;
import dao.FactoryDAO;
import dto.Cliente;
import dto.PlanDePago;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import modeloDatos.ModeloDatosDetalleDePagosMensuales;
import org.apache.log4j.Logger;

public class PanelDetalleDePagosMensuales extends javax.swing.JPanel {

    private PlanDePago objPlanDePagos;
    private final Logger logger = Logger.getRootLogger();
    
    public PanelDetalleDePagosMensuales() {
        initComponents();
        personalizarTabla();
    }
    
    private void personalizarTabla() {
        // personalizando la cabecera
        JTableHeader modeloCabecera = tablaPagosMensuales.getTableHeader();
        modeloCabecera.setBackground(new Color(45, 190, 96));
        modeloCabecera.setFont(new Font("Dialog", Font.BOLD, 12));
        
        // centrando las columnas
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(SwingUtilities.CENTER);
        
        TableColumnModel modeloColumnas = tablaPagosMensuales.getColumnModel();
        for (int i = 0; i < modeloColumnas.getColumnCount(); i++) {
            modeloColumnas.getColumn(i).setCellRenderer(centrar);
        }
    }

    public void cargarDatos() {
        modeloTabla.cargar(objPlanDePagos);
        
        FactoryDAO factory = FactoryDAO.getOrCreate();
        ClienteDAO dao = factory.newClienteDAO();
        Cliente objCliente = null;
        
        try {
            objCliente = (Cliente) dao.seleccionar(
                    objPlanDePagos.getClienteID());
        } catch (Exception ex) {
            logger.error("Hubo un error al colocar el nombre del Cliente en el "
                    + "Detalle de Pagos Mensuales " + ex.getMessage());
        }
        
        if (objCliente != null) {
            lbNombreCliente.setText(objCliente.getNombre() + " "
                    +objCliente.getApellido());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeloTabla = new modeloDatos.ModeloDatosDetalleDePagosMensuales();
        scrollTablaPagosMensuales = new javax.swing.JScrollPane();
        tablaPagosMensuales = new javax.swing.JTable();
        panelSuperior = new javax.swing.JPanel();
        lbNombreCliente = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        tablaPagosMensuales.setAutoCreateRowSorter(true);
        tablaPagosMensuales.setModel(modeloTabla);
        scrollTablaPagosMensuales.setViewportView(tablaPagosMensuales);

        add(scrollTablaPagosMensuales, java.awt.BorderLayout.CENTER);

        panelSuperior.setLayout(new java.awt.BorderLayout());

        lbNombreCliente.setFont(new java.awt.Font("Segoe Print", 0, 16)); // NOI18N
        lbNombreCliente.setText("[Nombre Cliente]");
        panelSuperior.add(lbNombreCliente, java.awt.BorderLayout.CENTER);

        add(panelSuperior, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbNombreCliente;
    private modeloDatos.ModeloDatosDetalleDePagosMensuales modeloTabla;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JScrollPane scrollTablaPagosMensuales;
    private javax.swing.JTable tablaPagosMensuales;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    
    public PlanDePago getPlanDePagos() {
        return objPlanDePagos;
    }

    public void setPlanDePagos(PlanDePago objPlanDePagos) {
        this.objPlanDePagos = objPlanDePagos;
        cargarDatos();
    }

    public ModeloDatosDetalleDePagosMensuales getModelo() {
        return modeloTabla;
    }

    public void setModelo(ModeloDatosDetalleDePagosMensuales modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JLabel getLbNombreCliente() {
        return lbNombreCliente;
    }

    public void setLbNombreCliente(JLabel lbNombreCliente) {
        this.lbNombreCliente = lbNombreCliente;
    }

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public JScrollPane getScrollTablaPagosMensuales() {
        return scrollTablaPagosMensuales;
    }

    public void setScrollTablaPagosMensuales(JScrollPane scrollTablaPagosMensuales) {
        this.scrollTablaPagosMensuales = scrollTablaPagosMensuales;
    }

    public JTable getTablaPagosMensuales() {
        return tablaPagosMensuales;
    }

    public void setTablaPagosMensuales(JTable tablaPagosMensuales) {
        this.tablaPagosMensuales = tablaPagosMensuales;
    }

    // </editor-fold>
    
}
