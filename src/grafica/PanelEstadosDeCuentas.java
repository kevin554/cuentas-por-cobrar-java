package grafica;

import dao.FactoryDAO;
import dao.PlanDePagoDAO;
import dao.ProductoDAO;
import dto.PlanDePago;
import dto.Producto;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import modeloDatos.ModeloDatosCuentasPorCobrar;
import org.apache.log4j.Logger;

public class PanelEstadosDeCuentas extends javax.swing.JPanel {

    private VentanaPrincipal ventana;
    private FormularioCobrar formularioCobrar;
    private final Logger logger = Logger.getRootLogger();

    public PanelEstadosDeCuentas() {
        initComponents();
        init();
    }

    private void init() {
        formularioCobrar = new FormularioCobrar(null, true);
        formularioCobrar.setPadre(this);
        
        modeloDatos.cargar();
        personalizarTabla();
    }

    private void personalizarTabla() {
        // personalizando la cabecera
        JTableHeader cabeceras = tablaCuentasPorCobrar.getTableHeader();
        cabeceras.setBackground(new Color(45, 190, 96));
        cabeceras.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        // centrando las columnas
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(SwingUtilities.CENTER);
        
        TableColumnModel columnas = tablaCuentasPorCobrar.getColumnModel();
        for (int i = 0; i < columnas.getColumnCount(); i++) {
            columnas.getColumn(i).setCellRenderer(centrar);
        }
    }
    
    private PlanDePago obtenerPlanDePagos() {
        int fila = tablaCuentasPorCobrar.getSelectedRow();

        String clienteID = tablaCuentasPorCobrar.getValueAt(fila, 0).toString();
        String nombreProducto = tablaCuentasPorCobrar.
                getValueAt(fila, 4).toString();
        Date fechaAdquisicion = (Date) tablaCuentasPorCobrar.getValueAt(fila, 7);

        FactoryDAO factory = FactoryDAO.getOrCreate();
        Producto objProducto = null;

        try {
            ProductoDAO dao = factory.newProductoDAO();
            objProducto = dao.seleccionarProductoPorNombre(nombreProducto);
        } catch (Exception ex) {
            logger.error("hubo un error al obtener un producto por nombre ("
                    + nombreProducto + ") " + ex.getMessage());
        }

        if (objProducto == null) {
            return null;
        }

        PlanDePago objPlanDePagos = null;

        try {
            PlanDePagoDAO dao = factory.newPlanDePagoDAO();
            objPlanDePagos = (PlanDePago) dao
                    .seleccionarPlanDePagosPorClienteProductoFecha(
                            Integer.parseInt(clienteID),
                            objProducto.getCodigoID(), fechaAdquisicion);
        } catch (Exception ex) {
            logger.error("hubo un error al obtener un Plan de Pagos "
                    + ex.getMessage());
        }

        if (objPlanDePagos == null) {
            return null;
        }

        return objPlanDePagos;
    }

    public void actualizarTabla() {
        actualizarTabla(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clicDerecho = new javax.swing.JPopupMenu();
        itmPanelDetalleDePagos = new javax.swing.JMenuItem();
        modeloDatos = new modeloDatos.ModeloDatosCuentasPorCobrar();
        panelSuperior = new javax.swing.JPanel();
        btnAbonar = new javax.swing.JButton();
        tfBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        scrollTablaCuentasPorCobrar = new javax.swing.JScrollPane();
        tablaCuentasPorCobrar = new javax.swing.JTable();

        itmPanelDetalleDePagos.setText("Detalle de Pagos Mensuales");
        itmPanelDetalleDePagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarDetalleDePagoMensuales(evt);
            }
        });
        clicDerecho.add(itmPanelDetalleDePagos);

        setPreferredSize(new java.awt.Dimension(860, 480));
        setLayout(new java.awt.BorderLayout());

        panelSuperior.setLayout(new java.awt.BorderLayout(40, 0));

        btnAbonar.setText("Abonar");
        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abonar(evt);
            }
        });
        panelSuperior.add(btnAbonar, java.awt.BorderLayout.LINE_START);

        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                teclaPresionada(evt);
            }
        });
        panelSuperior.add(tfBuscar, java.awt.BorderLayout.CENTER);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar.png"))); // NOI18N
        btnBuscar.setPreferredSize(new java.awt.Dimension(30, 30));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarTabla(evt);
            }
        });
        panelSuperior.add(btnBuscar, java.awt.BorderLayout.LINE_END);

        add(panelSuperior, java.awt.BorderLayout.PAGE_START);

        tablaCuentasPorCobrar.setAutoCreateRowSorter(true);
        tablaCuentasPorCobrar.setModel(modeloDatos);
        tablaCuentasPorCobrar.setComponentPopupMenu(clicDerecho);
        tablaCuentasPorCobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaCuentasPorCobrarMousePressed(evt);
            }
        });
        scrollTablaCuentasPorCobrar.setViewportView(tablaCuentasPorCobrar);

        add(scrollTablaCuentasPorCobrar, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarTabla(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarTabla
        try {
            modeloDatos.setFiltro(Integer.parseInt(tfBuscar.getText().trim()));
        } catch (NumberFormatException ex) {
            modeloDatos.setFiltro(tfBuscar.getText().trim());
        }
    }//GEN-LAST:event_actualizarTabla

    private void generarDetalleDePagoMensuales(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarDetalleDePagoMensuales
        PlanDePago objPlanDePago = obtenerPlanDePagos();

        if (objPlanDePago != null) {
            ventana.mostrarDetalleDePagoMensuales(objPlanDePago);
        }
    }//GEN-LAST:event_generarDetalleDePagoMensuales

    private void abonar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abonar
        if (tablaCuentasPorCobrar.getSelectedRow() != -1) {
            PlanDePago objPlanDePago = obtenerPlanDePagos();

            if (objPlanDePago != null) {
                formularioCobrar.setPlanDePago(objPlanDePago);
                formularioCobrar.pack();
                formularioCobrar.setLocationRelativeTo(this);
                formularioCobrar.setVisible(true);
            }
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_abonar

    private void teclaPresionada(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teclaPresionada
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            actualizarTabla(null);
        }
    }//GEN-LAST:event_teclaPresionada

    private void tablaCuentasPorCobrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCuentasPorCobrarMousePressed
        if (SwingUtilities.isRightMouseButton(evt)) {
            int fila = tablaCuentasPorCobrar.rowAtPoint(evt.getPoint());
            tablaCuentasPorCobrar.setRowSelectionInterval(fila, fila);
        }
    }//GEN-LAST:event_tablaCuentasPorCobrarMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPopupMenu clicDerecho;
    private javax.swing.JMenuItem itmPanelDetalleDePagos;
    private modeloDatos.ModeloDatosCuentasPorCobrar modeloDatos;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JScrollPane scrollTablaCuentasPorCobrar;
    private javax.swing.JTable tablaCuentasPorCobrar;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    
    public VentanaPrincipal getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    public ModeloDatosCuentasPorCobrar getModeloDatos() {
        return modeloDatos;
    }

    public void setModeloDatos(ModeloDatosCuentasPorCobrar modeloDatos) {
        this.modeloDatos = modeloDatos;
    }

    public FormularioCobrar getFormularioCobrar() {
        return formularioCobrar;
    }

    public void setFormularioCobrar(FormularioCobrar formularioCobrar) {
        this.formularioCobrar = formularioCobrar;
    }

    public JButton getBtnAbonar() {
        return btnAbonar;
    }

    public void setBtnAbonar(JButton btnAbonar) {
        this.btnAbonar = btnAbonar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JPopupMenu getClicDerecho() {
        return clicDerecho;
    }

    public void setClicDerecho(JPopupMenu clicDerecho) {
        this.clicDerecho = clicDerecho;
    }

    public JMenuItem getItmPanelDetalleDePagos() {
        return itmPanelDetalleDePagos;
    }

    public void setItmPanelDetalleDePagos(JMenuItem itmPanelDetalleDePagos) {
        this.itmPanelDetalleDePagos = itmPanelDetalleDePagos;
    }

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public JScrollPane getScrollTablaCuentasPorCobrar() {
        return scrollTablaCuentasPorCobrar;
    }

    public void setScrollTablaCuentasPorCobrar(JScrollPane scrollTablaCuentasPorCobrar) {
        this.scrollTablaCuentasPorCobrar = scrollTablaCuentasPorCobrar;
    }

    public JTable getTablaCuentasPorCobrar() {
        return tablaCuentasPorCobrar;
    }

    public void setTablaCuentasPorCobrar(JTable tablaCuentasPorCobrar) {
        this.tablaCuentasPorCobrar = tablaCuentasPorCobrar;
    }

    public JTextField getTfBuscar() {
        return tfBuscar;
    }

    public void setTfBuscar(JTextField tfBuscar) {
        this.tfBuscar = tfBuscar;
    }

    // </editor-fold>
    
}
