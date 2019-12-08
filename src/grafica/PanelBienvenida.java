package grafica;

import javax.swing.JLabel;

public class PanelBienvenida extends javax.swing.JPanel {

    public PanelBienvenida() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLogotipo = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        lbLogotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logotipo.png"))); // NOI18N
        add(lbLogotipo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbLogotipo;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    
    public JLabel getLbLogotipo() {
        return lbLogotipo;
    }

    public void setLbLogotipo(JLabel lbLogotipo) {
        this.lbLogotipo = lbLogotipo;
    }

    // </editor-fold>
    
}
