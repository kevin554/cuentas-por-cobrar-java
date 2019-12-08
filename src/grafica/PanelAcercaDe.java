package grafica;

import javax.swing.JLabel;

public class PanelAcercaDe extends javax.swing.JPanel {

    public PanelAcercaDe() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbCopyRight = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new java.awt.GridLayout(3, 1));

        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Cuentas por Cobrar");
        add(lbTitulo);

        lbNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lbNombre);

        lbCopyRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCopyRight.setText("Copyright 2017");
        add(lbCopyRight);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbCopyRight;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    
    public JLabel getLbCopyRight() {
        return lbCopyRight;
    }

    public void setLbCopyRight(JLabel lbCopyRight) {
        this.lbCopyRight = lbCopyRight;
    }

    public JLabel getLbNombre() {
        return lbNombre;
    }

    public void setLbNombre(JLabel lbNombre) {
        this.lbNombre = lbNombre;
    }

    public JLabel getLbTitulo() {
        return lbTitulo;
    }

    public void setLbTitulo(JLabel lbTitulo) {
        this.lbTitulo = lbTitulo;
    }

    // </editor-fold>
    
}
