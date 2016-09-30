package co.gov.coljuegos.siicol.ejb.util;

import java.util.Properties;

public class Recursos {
    
    private Properties properties;
    
    public Recursos() {
    }
    
    public String obtenerRecurso(String propiedad, String archivo) {
        Properties domPropiedades = cargarPropiedades(archivo);
        String valorId = domPropiedades.getProperty(propiedad);
        return valorId;
    }
    
    public Properties cargarPropiedades(String nombreArchivo) {
        if (properties == null) {
            properties = new Properties();
        }
        try {
            properties.load(Recursos.class.getResourceAsStream(nombreArchivo + ".properties"));

        } catch (java.io.IOException exc) {
            System.out.println("Error cargando archivo de propiedades" + exc.getMessage());
        }
        return properties;
    }
}
