package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Pasos del Tr&aacute;mite del Auto que Decreta Pruebas / Niega Pruebas / Traslado Alegatos.
 * @author Camilo Miranda
 */
public enum EnumPasoTramiteAutoPrueTras 
{
    SOLICITUD_NUMERACION_AUTO_DECRETA_PRUEBAS("S", EnumTipoAutoProcSancIleg.DECRETA_PRUEBAS.getId(), "SOLICITUD DE NUMERACIÓN AUTO", "AUTO QUE DECRETA PRUEBAS EN NUMERACIÓN"),
    COMUNICACION_AUTO_DECRETA_PRUEBAS("C", EnumTipoAutoProcSancIleg.DECRETA_PRUEBAS.getId(), "COMUNICACIÓN", "AUTO QUE DECRETA PRUEBAS COMUNICADO"),
    NUMERACION_AUTO_DECRETA_PRUEBAS("N", EnumTipoAutoProcSancIleg.DECRETA_PRUEBAS.getId(), "NUMERACIÓN", "AUTO QUE DECRETA PRUEBAS NUMERADO"),
    SOLICITUD_NUMERACION_AUTO_NIEGA_PRUEBAS("S", EnumTipoAutoProcSancIleg.NIEGA_PRUEBAS.getId(), "SOLICITUD DE NUMERACIÓN AUTO", "AUTO QUE NIEGA PRUEBAS Y CORRE TRASLADO ALEGATOS EN NUMERACIÓN"),
    COMUNICACION_AUTO_NIEGA_PRUEBAS("C", EnumTipoAutoProcSancIleg.NIEGA_PRUEBAS.getId(), "COMUNICACIÓN", "AUTO QUE NIEGA PRUEBAS Y CORRE TRASLADO ALEGATOS COMUNICADO"),
    NUMERACION_AUTO_NIEGA_PRUEBAS("N", EnumTipoAutoProcSancIleg.NIEGA_PRUEBAS.getId(), "NUMERACIÓN", "AUTO QUE NIEGA PRUEBAS Y CORRE TRASLADO ALEGATOS NUMERADO"),
    SOLICITUD_NUMERACION_AUTO_TRASLADO_ALEGATOS("S", EnumTipoAutoProcSancIleg.TRASLADO_ALEGATOS.getId(), "SOLICITUD DE NUMERACIÓN AUTO", "AUTO TRASLADO ALEGATOS EN NUMERACIÓN"),
    COMUNICACION_AUTO_TRASLADO_ALEGATOS("C", EnumTipoAutoProcSancIleg.TRASLADO_ALEGATOS.getId(), "COMUNICACIÓN", "AUTO TRASLADO ALEGATOS COMUNICADO"),
    NUMERACION_AUTO_TRASLADO_ALEGATOS("N", EnumTipoAutoProcSancIleg.TRASLADO_ALEGATOS.getId(), "NUMERACIÓN", "AUTO TRASLADO ALEGATOS NUMERADO");
    
    
    private String idPaso;
    private String tipoAuto;
    private String nombrePaso;
    private String nombreEstado;

    
    /**
     * Constructor.
     * @param idPaso
     * @param nombrePaso
     * @param nombreEstado
     */
    EnumPasoTramiteAutoPrueTras (String idPaso, String tipoAuto, String nombrePaso, String nombreEstado) 
    {
        this.idPaso = idPaso;
        this.tipoAuto = tipoAuto;
        this.nombrePaso = nombrePaso;
        this.nombreEstado = nombreEstado;
    }
    
    
    public String getIdPaso() {
        return idPaso;
    }

    public String getTipoAuto() {
        return tipoAuto;
    }

    public String getNombrePaso() {
        return nombrePaso;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }
    
    
    

    /**
     * Obtiene el nombre del Estado del Enumerado a partir del Paso y el Tipo de Auto.
     * @param idPaso
     * @param tipoAuto
     * @return enum.nombreEstado
     */
    public static String getNombreEstadoByPaso (String idPaso, String tipoAuto) 
    {
        String nombre = null;
        
        EnumPasoTramiteAutoPrueTras[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getIdPaso().equals(idPaso) && enums[i].getTipoAuto().equals(tipoAuto))
                nombre = enums[i].getNombreEstado();
            i++;
        }
        
        return (nombre);
    }
}
