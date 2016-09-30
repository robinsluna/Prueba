package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para el manejo de Motivos de Incumplimiento.
 * @author Camilo Miranda
 */
public enum EnumMotivoIncumplimiento 
{
    OPERADOR_EN_MORA(1L),
    NO_PRESENTACION_DE_POLIZA(2L),
    INCUMPLIMIENTO_SIPLAFT(3L),
    REPORTE_VISITA_DE_FISCALIZACION(4L),
    INCUMPLIMIENTO_TRANSMISION_EN_LINEA(5L),
    ESTADOS_FINANCIEROS(6L),
    OMISION(7L),
    INEXACTITUD(8L),
    TRASLADO_ELEMENTOS_SIN_AUTORIZACION(9L);
    
    
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumMotivoIncumplimiento(Long id) 
    {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
