package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Pasos del Tr&aacute;mite de Auto de Formulaci&oacute;n de Cargos del Proceso Sancionatorio de Ilegalidad.
 * - Obtenidos de la columna <i>SII_TRAMITE_AUTO_FOR_CAR_ILE</i>.<i>TAF_PASO</i>.
 * @author Camilo Miranda
 */
public enum EnumPasoTramiteAutoForCarIle 
{
    SOLICITUD_NUMERACION("S", "SOLICITUD DE NUMERACIÓN AUTO", "AUTO FORMULACIÓN DE CARGOS EN NUMERACIÓN"),
    COMUNICACION("C", "COMUNICACIÓN", "AUTO FORMULACIÓN DE CARGOS COMUNICADO"),
    NUMERACION("N", "NUMERACIÓN", "AUTO FORMULACIÓN DE CARGOS NUMERADO"),
    NOTIFICACION("O", "NOTIFICACIÓN", "AUTO FORMULACIÓN DE CARGOS NOTIFICADO");
    
    
    private String idPaso;
    private String nombrePaso;
    private String nombreEstado;
    
    
    /**
     * Constructor.
     * @param idPaso
     * @param nombrePaso
     * @param nombreEstado
     */
    EnumPasoTramiteAutoForCarIle(String idPaso, String nombrePaso, String nombreEstado) 
    {
        this.idPaso = idPaso;
        this.nombrePaso = nombrePaso;
        this.nombreEstado = nombreEstado;
    }


    public String getIdPaso() {
        return idPaso;
    }

    public String getNombrePaso() {
        return nombrePaso;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }
    
    
    
    /**
     * Obtiene el nombre del Estado del Enumerado a partir del Paso.
     * @param idPaso
     * @return enum.nombreEstado
     */
    public static String getNombreEstadoByPaso (String idPaso) 
    {
        String nombre = null;
        
        EnumPasoTramiteAutoForCarIle[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getIdPaso().equals(idPaso))
                nombre = enums[i].getNombreEstado();
            i++;
        }
        
        return (nombre);
    }
}
