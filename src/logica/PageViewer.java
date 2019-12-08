package logica;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

public class PageViewer extends CardLayout {

    @Override
    public Dimension preferredLayoutSize(Container contenedor) {
        Component componenteActual = ubicarPanelActual(contenedor);
        
        if (componenteActual != null) {
            Insets recuadro = contenedor.getInsets();
            Dimension tamanio = componenteActual.getPreferredSize();
            
            tamanio.width += recuadro.left + recuadro.right;
            tamanio.height += recuadro.top + recuadro.bottom;
            
            return tamanio;
        }
        
        return super.preferredLayoutSize(contenedor);
    }

    private Component ubicarPanelActual(Container parent) {
        for (Component componente : parent.getComponents()) {
            if (componente.isVisible()) {
                return componente;
            }
        }
        
        return null;
    }
    
}