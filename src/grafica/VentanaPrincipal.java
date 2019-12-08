package grafica;

import conexion.Conexion;
import dto.PlanDePago;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import org.apache.log4j.Logger;

public class VentanaPrincipal extends javax.swing.JFrame {

    private CardLayout cardLayout;
    
    public VentanaPrincipal() {
        initComponents();
        init();
    }
    
    private void init() {
        panelEstadosDeCuentas.setVentana(this);
        cardLayout = ((CardLayout) panelPrincipal.getLayout());
        
        comenzarPresentacion();
    }

    public void comenzarPresentacion() {
        cardLayout.show(panelPrincipal, "Bienvenida");
        
        Thread animacion = new Thread(this::presentacion);
        animacion.start();
    }
    
    private void presentacion() {
        try {
            Thread.sleep(1300);
        } catch (InterruptedException ex) {
            Logger.getRootLogger().error("Hubo un error con la animacion de "
                    + "bienvenida " + ex.getMessage());
        }
        
        mostrarEstadosDeCuenta(null);
    }
 
    public void mostrarDetalleDePagoMensuales(PlanDePago objPlanDePago) {
        panelDetalleDePagosMensuales.setPlanDePagos(objPlanDePago);
        cardLayout.show(panelPrincipal, "Detalle Mensualidades");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelEstadosDeCuentas = new grafica.PanelEstadosDeCuentas();
        panelDetalleDePagosMensuales = new grafica.PanelDetalleDePagosMensuales();
        panelBienvenida = new grafica.PanelBienvenida();
        barra = new javax.swing.JMenuBar();
        mnArchivo = new javax.swing.JMenu();
        itmEstadosDeCuentas = new javax.swing.JMenuItem();
        separador = new javax.swing.JPopupMenu.Separator();
        itmSalir = new javax.swing.JMenuItem();
        mnAyuda = new javax.swing.JMenu();
        itmAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

		cardLayout = new logica.PageViewer();
        panelPrincipal.setLayout(cardLayout);
        panelPrincipal.add(panelEstadosDeCuentas, "Estados de Cuentas");
        panelPrincipal.add(panelDetalleDePagosMensuales, "Detalle Mensualidades");
        panelPrincipal.add(panelBienvenida, "Bienvenida");

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        mnArchivo.setText("Archivo");

        itmEstadosDeCuentas.setText("Estados de Cuentas");
        itmEstadosDeCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarEstadosDeCuenta(evt);
            }
        });
        mnArchivo.add(itmEstadosDeCuentas);
        mnArchivo.add(separador);

        itmSalir.setText("Salir");
        itmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });
        mnArchivo.add(itmSalir);

        barra.add(mnArchivo);

        mnAyuda.setText("Ayuda");

        itmAcercaDe.setText("Acerca de");
        itmAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarInformacionPrograma(evt);
            }
        });
        mnAyuda.add(itmAcercaDe);

        barra.add(mnAyuda);

        setJMenuBar(barra);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarEstadosDeCuenta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarEstadosDeCuenta
        cardLayout.show(panelPrincipal, "Estados de Cuentas");
    }//GEN-LAST:event_mostrarEstadosDeCuenta

    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        int seleccion = JOptionPane.showConfirmDialog(null, 
                "Está seguro que desea salir?", "Salir", 
                JOptionPane.YES_NO_OPTION);
        
        if (seleccion == JOptionPane.YES_OPTION) {
            Conexion.getOrCreate().desconectar();
            System.exit(0);
        } else {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_salir

    private void mostrarInformacionPrograma(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarInformacionPrograma
        JOptionPane.showMessageDialog(this, new PanelAcercaDe(), "Acerca de", 
                JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_mostrarInformacionPrograma

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir(null);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barra;
    private javax.swing.JMenuItem itmAcercaDe;
    private javax.swing.JMenuItem itmEstadosDeCuentas;
    private javax.swing.JMenuItem itmSalir;
    private javax.swing.JMenu mnArchivo;
    private javax.swing.JMenu mnAyuda;
    private grafica.PanelBienvenida panelBienvenida;
    private grafica.PanelDetalleDePagosMensuales panelDetalleDePagosMensuales;
    private grafica.PanelEstadosDeCuentas panelEstadosDeCuentas;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPopupMenu.Separator separador;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout layout) {
        this.cardLayout = layout;
    }

    public JMenuBar getBarra() {
        return barra;
    }

    public void setBarra(JMenuBar barra) {
        this.barra = barra;
    }

    public JMenuItem getItmAcercaDe() {
        return itmAcercaDe;
    }

    public void setItmAcercaDe(JMenuItem itmAcercaDe) {
        this.itmAcercaDe = itmAcercaDe;
    }

    public JMenuItem getItmEstadosDeCuentas() {
        return itmEstadosDeCuentas;
    }

    public void setItmEstadosDeCuentas(JMenuItem itmEstadosDeCuentas) {
        this.itmEstadosDeCuentas = itmEstadosDeCuentas;
    }

    public JMenuItem getItmSalir() {
        return itmSalir;
    }

    public void setItmSalir(JMenuItem itmSalir) {
        this.itmSalir = itmSalir;
    }

    public JMenu getMnArchivo() {
        return mnArchivo;
    }

    public void setMnArchivo(JMenu mnArchivo) {
        this.mnArchivo = mnArchivo;
    }

    public JMenu getMnAyuda() {
        return mnAyuda;
    }

    public void setMnAyuda(JMenu mnAyuda) {
        this.mnAyuda = mnAyuda;
    }

    public PanelBienvenida getPanelBienvenida() {
        return panelBienvenida;
    }

    public void setPanelBienvenida(PanelBienvenida panelBienvenida) {
        this.panelBienvenida = panelBienvenida;
    }

    public PanelDetalleDePagosMensuales getPanelDetalleDePagosMensuales() {
        return panelDetalleDePagosMensuales;
    }

    public void setPanelDetalleDePagosMensuales(PanelDetalleDePagosMensuales panelDetalleDePagosMensuales) {
        this.panelDetalleDePagosMensuales = panelDetalleDePagosMensuales;
    }

    public PanelEstadosDeCuentas getPanelEstadosDeCuentas() {
        return panelEstadosDeCuentas;
    }

    public void setPanelEstadosDeCuentas(PanelEstadosDeCuentas panelEstadosDeCuentas) {
        this.panelEstadosDeCuentas = panelEstadosDeCuentas;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JPopupMenu.Separator getSeparador() {
        return separador;
    }

    public void setSeparador(JPopupMenu.Separator separador) {
        this.separador = separador;
    }

    // </editor-fold>
    
}
