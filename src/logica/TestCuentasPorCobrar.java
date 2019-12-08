package logica;

import grafica.VentanaPrincipal;
import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestCuentasPorCobrar {
    
    private static final Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        String ubicacion = "/logica/auditoria.properties";
        URL configFileResource = TestCuentasPorCobrar.class.getResource(ubicacion);
        PropertyConfigurator.configure(configFileResource);
        
        VentanaPrincipal v = new VentanaPrincipal();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }
    
}