package grafica;

import com.toedter.calendar.JDateChooser;
import dao.ClienteDAO;
import dao.CuotaDAO;
import dao.FactoryDAO;
import dao.PlanDePagoDAO;
import dao.ProductoDAO;
import dto.Cliente;
import dto.PlanDePago;
import dto.Producto;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

public class FormularioCobrar extends javax.swing.JDialog {

    private PanelEstadosDeCuentas padre;
    private Factura factura;
    private PlanDePago objPlanDePago;
    private final Logger logger = Logger.getRootLogger();

    public FormularioCobrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }
    
    private void init() {
        factura = new Factura(null, true);
    }

    private void ofrecerFactura() {
        int seleccion = JOptionPane.showConfirmDialog(null, "¿Desea generar un "
                + "recibo?");

        if (seleccion == JOptionPane.YES_OPTION) {
            Cliente objCliente = obtenerClientePorID(objPlanDePago.getClienteID());

            if (objCliente != null) {
                objCliente.setFactura(tfFactura.getText().trim());
            }

            factura.setCliente(objCliente);
            factura.setPlanDePagos(objPlanDePago);
            factura.cargarDatos();
            factura.setLocationRelativeTo(this);
            factura.setVisible(true);
        }

        // Actualizamos la tabla por el pago de la cuota
        padre.actualizarTabla();
        this.dispose();
    }

    private Cliente obtenerClientePorID(int clienteId) {
        FactoryDAO factory = FactoryDAO.getOrCreate();
        ClienteDAO dao = factory.newClienteDAO();

        try {
            return (Cliente) dao.seleccionar(clienteId);
        } catch (Exception ex) {
            logger.error("hubo un error al obtener un Cliente por su ID "
                    + ex.getMessage());
            return null;
        }
    }

    public void cargarDatos() {
        calendario.setDate(new Date());
        tfIdCliente.setText(Integer.toString(objPlanDePago.getClienteID()));

        FactoryDAO factory = FactoryDAO.getOrCreate();
        
        Cliente objCliente = obtenerClientePorID(objPlanDePago.getClienteID());
        Producto objProducto = null;

        if (objCliente != null) {
            tfNombreCliente.setText(objCliente.getNombre());
            tfFactura.setText(objCliente.getFactura());
        }

        try {
            ProductoDAO dao = factory.newProductoDAO();
            objProducto = (Producto) dao.
                    seleccionar(objPlanDePago.getProductoID());
        } catch (Exception ex) {
            logger.error("hubo un error al obtener un Producto con el "
                    + "productoID del Plan de Pagos " + ex.getMessage());
        }

        if (objProducto != null) {
            tfNombreProducto.setText(objProducto.getNombre());
        }

        try {
            PlanDePagoDAO dao = factory.newPlanDePagoDAO();
            tfMonto.setText(dao.montoAPagar(objPlanDePago.getCodigoID()) + "");
        } catch (Exception ex) {
            logger.error("hubo un error al intentar colocar el monto en el "
                    + "campo de texto " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        lbIdCliente = new javax.swing.JLabel();
        lbNombreCliente = new javax.swing.JLabel();
        lbNombreProducto = new javax.swing.JLabel();
        lbFactura = new javax.swing.JLabel();
        tfNombreProducto = new javax.swing.JTextField();
        tfNombreCliente = new javax.swing.JTextField();
        tfIdCliente = new javax.swing.JTextField();
        tfFactura = new javax.swing.JTextField();
        lbFecha = new javax.swing.JLabel();
        lbMonto = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();
        tfMonto = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbIdCliente.setText("ID cliente:");

        lbNombreCliente.setText("Cliente:");

        lbNombreProducto.setText("Producto:");

        lbFactura.setText("Factura:");

        tfNombreProducto.setEditable(false);
        tfNombreProducto.setText("[Nombre Producto]");
        tfNombreProducto.setBorder(null);

        tfNombreCliente.setEditable(false);
        tfNombreCliente.setText("[Nombre Cliente]");
        tfNombreCliente.setBorder(null);

        tfIdCliente.setEditable(false);
        tfIdCliente.setText("[ID Cliente]");
        tfIdCliente.setBorder(null);

        tfFactura.setText("[Factura]");

        lbFecha.setText("Fecha:");

        lbMonto.setText("Monto:");

        tfMonto.setText("[Monto Abonado]");
        tfMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                teclaPresionada(evt);
            }
        });

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efectuarTransaccion(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNombreCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNombreProducto)
                            .addComponent(lbFactura, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNombreCliente)
                            .addComponent(tfNombreProducto)
                            .addComponent(tfFactura)))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(lbIdCliente)
                        .addGap(18, 18, 18)
                        .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbMonto)
                        .addGap(18, 18, 18)
                        .addComponent(tfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(btnPagar)
                                .addGap(10, 10, 10))
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(lbFecha)
                                .addGap(18, 18, 18)
                                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMonto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPagar))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIdCliente)
                            .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFecha))
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombreCliente)
                            .addComponent(tfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombreProducto)
                            .addComponent(tfNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFactura)
                            .addComponent(tfFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void teclaPresionada(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teclaPresionada
        char letra = evt.getKeyChar();

        if (Character.isLetter(letra)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_teclaPresionada

    private void efectuarTransaccion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efectuarTransaccion
        FactoryDAO factory = FactoryDAO.getOrCreate();

        double montoAbonado;

        try {
            montoAbonado = Double.parseDouble(tfMonto.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El monto ingresado no es "
                    + "valido");
            return;
        }

        double saldoRestante = 0;
        double montoAPagar = 0;

        try {
            PlanDePagoDAO dao = factory.newPlanDePagoDAO();
            
            saldoRestante = dao.montoRestante(objPlanDePago.getCodigoID());
            montoAPagar = dao.montoAPagar(objPlanDePago.getCodigoID());
        } catch (Exception ex) {
            logger.error("hubo un error al obtener el saldo restante y el "
                    + "monto a pagar " + ex.getMessage());
        }

        if (montoAbonado > saldoRestante) {
            JOptionPane.showMessageDialog(this, "No puede abonar mas de su "
                    + "deuda");
            return;
        }

        if (montoAbonado < montoAPagar) {
            JOptionPane.showMessageDialog(this, "No puede pagar menos de lo "
                    + "que deberia pagar mensualmente");
            return;
        }

        try {
            Integer.parseInt(tfFactura.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una factura "
                    + "valida");
        }

        int cuotasPagadas = 0;

        try {
            CuotaDAO dao = factory.newCuotaDAO();
            
            cuotasPagadas = dao.pagarCuota(calendario.getDate(), montoAbonado, 
                    objPlanDePago.getCodigoID());
        } catch (Exception ex) {
            
        }

        if (cuotasPagadas > 0) {
            ofrecerFactura();
        }
    }//GEN-LAST:event_efectuarTransaccion

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JLabel lbFactura;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbIdCliente;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbNombreCliente;
    private javax.swing.JLabel lbNombreProducto;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JTextField tfFactura;
    private javax.swing.JTextField tfIdCliente;
    private javax.swing.JTextField tfMonto;
    private javax.swing.JTextField tfNombreCliente;
    private javax.swing.JTextField tfNombreProducto;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    
    public PanelEstadosDeCuentas getPadre() {
        return padre;
    }

    public void setPadre(PanelEstadosDeCuentas padre) {
        this.padre = padre;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public PlanDePago getPlanDePago() {
        return objPlanDePago;
    }

    public void setPlanDePago(PlanDePago objPlanDePago) {
        this.objPlanDePago = objPlanDePago;
        cargarDatos();
    }

    public JButton getBtnPagar() {
        return btnPagar;
    }

    public void setBtnPagar(JButton btnPagar) {
        this.btnPagar = btnPagar;
    }

    public JDateChooser getCalendario() {
        return calendario;
    }

    public void setCalendario(JDateChooser calendario) {
        this.calendario = calendario;
    }

    public JLabel getLbFactura() {
        return lbFactura;
    }

    public void setLbFactura(JLabel lbFactura) {
        this.lbFactura = lbFactura;
    }

    public JLabel getLbFecha() {
        return lbFecha;
    }

    public void setLbFecha(JLabel lbFecha) {
        this.lbFecha = lbFecha;
    }

    public JLabel getLbIdCliente() {
        return lbIdCliente;
    }

    public void setLbIdCliente(JLabel lbIdCliente) {
        this.lbIdCliente = lbIdCliente;
    }

    public JLabel getLbMonto() {
        return lbMonto;
    }

    public void setLbMonto(JLabel lbMonto) {
        this.lbMonto = lbMonto;
    }

    public JLabel getLbNombreCliente() {
        return lbNombreCliente;
    }

    public void setLbNombreCliente(JLabel lbNombreCliente) {
        this.lbNombreCliente = lbNombreCliente;
    }

    public JLabel getLbNombreProducto() {
        return lbNombreProducto;
    }

    public void setLbNombreProducto(JLabel lbNombreProducto) {
        this.lbNombreProducto = lbNombreProducto;
    }

    public JPanel getPanelContenedor() {
        return panelContenedor;
    }

    public void setPanelContenedor(JPanel panelContenedor) {
        this.panelContenedor = panelContenedor;
    }

    public JTextField getTfFactura() {
        return tfFactura;
    }

    public void setTfFactura(JTextField tfFactura) {
        this.tfFactura = tfFactura;
    }

    public JTextField getTfIdCliente() {
        return tfIdCliente;
    }

    public void setTfIdCliente(JTextField tfIdCliente) {
        this.tfIdCliente = tfIdCliente;
    }

    public JTextField getTfMonto() {
        return tfMonto;
    }

    public void setTfMonto(JTextField tfMonto) {
        this.tfMonto = tfMonto;
    }

    public JTextField getTfNombreCliente() {
        return tfNombreCliente;
    }

    public void setTfNombreCliente(JTextField tfNombreCliente) {
        this.tfNombreCliente = tfNombreCliente;
    }

    public JTextField getTfNombreProducto() {
        return tfNombreProducto;
    }

    public void setTfNombreProducto(JTextField tfNombreProducto) {
        this.tfNombreProducto = tfNombreProducto;
    }

    // </editor-fold>
    
}
