package grafica;

import dao.DetalleDePagosMensualesDAO;
import dao.FactoryDAO;
import dao.ProductoDAO;
import dto.Cliente;
import dto.DetalleDePagosMensuales;
import dto.PlanDePago;
import dto.Producto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Factura extends javax.swing.JDialog {

    private Cliente objCliente;
    private PlanDePago objPlanDePagos;

    public Factura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void cargarDatos() {
        lbNombreCliente.setText(objCliente.getNombre());

        FactoryDAO factory = FactoryDAO.getOrCreate();

        Producto objProducto = null;

        try {
            ProductoDAO productoDAO = factory.newProductoDAO();
            objProducto = (Producto) productoDAO.
                    seleccionar(objPlanDePagos.getProductoID());
        } catch (Exception ex) {

        }

        if (objProducto == null) {
            return;
        }

        lbDescripcion.setText(objProducto.getDescripcion());

        ArrayList<DetalleDePagosMensuales> lista = null;

        try {
            DetalleDePagosMensualesDAO dao = factory.newDetalleDePagosMensualesDAO();
            lista = dao.seleccionarTodos(objPlanDePagos);
        } catch (Exception ex) {

        }

        if (lista == null) {
            return;
        }

        DetalleDePagosMensuales objDetallePagosMensual = lista.get(lista.size() - 1);

        lbNumero.setText(objDetallePagosMensual.getCuota() + "");
        lbMonto.setText(objDetallePagosMensual.getMonto() + "");
        Date fecha = objDetallePagosMensual.getFechaPago();

        lbFechaDia.setText(new SimpleDateFormat("d").format(fecha));
//        lbFechaDia.setSize(lbFechaDia.getPreferredSize());

        lbFechaMes.setText(new SimpleDateFormat("MMMM").format(fecha));
//        lbFechaMes.setSize(lbFechaMes.getPreferredSize());

        lbFechaYear.setText(new SimpleDateFormat("YYYY").format(fecha));
//        lbFechaYear.setSize(lbFechaYear.getPreferredSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelContenedor = new javax.swing.JPanel();
        lbNombreCliente = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JLabel();
        lbMonto = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        lbFechaDia = new javax.swing.JLabel();
        lbFechaMes = new javax.swing.JLabel();
        lbFechaYear = new javax.swing.JLabel();
        lbImagenFactura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelContenedor.setLayout(new java.awt.GridBagLayout());

        lbNombreCliente.setText("[Nombre Cliente]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 239;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 70, 0, 0);
        panelContenedor.add(lbNombreCliente, gridBagConstraints);

        lbDescripcion.setText("[Descripcion]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 228;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(86, 140, 0, 0);
        panelContenedor.add(lbDescripcion, gridBagConstraints);

        lbMonto.setText("[Monto]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 72;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 80, 0, 0);
        panelContenedor.add(lbMonto, gridBagConstraints);

        lbNumero.setText("[Numero]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 180, 0, 0);
        panelContenedor.add(lbNumero, gridBagConstraints);

        lbFechaDia.setText("[Dia]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 200, 0, 0);
        panelContenedor.add(lbFechaDia, gridBagConstraints);

        lbFechaMes.setText("[Mes]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 20, 0, 0);
        panelContenedor.add(lbFechaMes, gridBagConstraints);

        lbFechaYear.setText("[Año]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 0, 0, 0);
        panelContenedor.add(lbFechaYear, gridBagConstraints);

        lbImagenFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Recibo.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 14, 0);
        panelContenedor.add(lbImagenFactura, gridBagConstraints);

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbFechaDia;
    private javax.swing.JLabel lbFechaMes;
    private javax.swing.JLabel lbFechaYear;
    private javax.swing.JLabel lbImagenFactura;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbNombreCliente;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    
    public Cliente getCliente() {
        return objCliente;
    }

    public void setCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }

    public PlanDePago getPlanDePagos() {
        return objPlanDePagos;
    }

    public void setPlanDePagos(PlanDePago objPlanDePagos) {
        this.objPlanDePagos = objPlanDePagos;
    }

    public JLabel getLbDescripcion() {
        return lbDescripcion;
    }

    public void setLbDescripcion(JLabel lbDescripcion) {
        this.lbDescripcion = lbDescripcion;
    }

    public JLabel getLbFechaDia() {
        return lbFechaDia;
    }

    public void setLbFechaDia(JLabel lbFechaDia) {
        this.lbFechaDia = lbFechaDia;
    }

    public JLabel getLbFechaMes() {
        return lbFechaMes;
    }

    public void setLbFechaMes(JLabel lbFechaMes) {
        this.lbFechaMes = lbFechaMes;
    }

    public JLabel getLbFechaYear() {
        return lbFechaYear;
    }

    public void setLbFechaYear(JLabel lbFechaYear) {
        this.lbFechaYear = lbFechaYear;
    }

    public JLabel getLbImagenFactura() {
        return lbImagenFactura;
    }

    public void setLbImagenFactura(JLabel lbImagenFactura) {
        this.lbImagenFactura = lbImagenFactura;
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

    public JLabel getLbNumero() {
        return lbNumero;
    }

    public void setLbNumero(JLabel lbNumero) {
        this.lbNumero = lbNumero;
    }

    public JPanel getPanelContenedor() {
        return panelContenedor;
    }

    public void setPanelContenedor(JPanel panelContenedor) {
        this.panelContenedor = panelContenedor;
    }

    // </editor-fold>
    
}
