/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 01-12-2013
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Estado del Proceso de Contrataci&oacute;n.
 * Obtenidos de la tabla SII_ESTADO_PROC_CONTRAT.
 * @author Camilo Miranda
 */
public enum EnumEstadoProcContrat 
{
    SOLICITUD_EM(1L),
    ESTUDIO_MERCADO(2L),
    ESTUDIOS_PREVIOS(3L),
    SOLICITUD_CDP(4L),
    CDP(5L),
    TDR(6L),
    SOLICITUD_RP(7L),
    RP(8L),
    PERFECCIONADO(9L),
    LEGALIZADO(10L),
    PROYECTO_DE_TERMINOS_DE_REFERENCIA_PUBLICADO(31L),
    OBSERVACIONES_Y_RESPUESTAS_AL_PROYECTO_DE_TERMINOS_DE_REFERENCIA_APROBADAS(32L),
    OBSERVACIONES_Y_RESPUESTAS_AL_PROYECTO_DE_TERMINOS_DE_REFERENCIA_PUBLICADAS(33L),
    TERMINOS_DE_REFERENCIA_DEFINITIVOS_APROBADOS(34L),
    TERMINOS_DE_REFERENCIA_DEFINITIVOS_PUBLICADOS(35L),
    ACTA_DE_AUDIENCIA_ACLARACIONES_APROBADA(36L),
    ACTA_DE_AUDIENCIA_ACLARACIONES_PUBLICADA(37L),
    OBSERVACIONES_Y_RESPUESTAS_A_LOS_TERMINOS_DE_REFERENCIA_APROBADAS(38L),
    OBSERVACIONES_Y_RESPUESTAS_A_LOS_TERMINOS_DE_REFERENCIA_PUBLICADAS(39L),
    PROYECTO_DE_TERMINOS_DE_REFERENCIA_APROBADO(40L),
    ADENDA_APROBADA(41L),
    ADENDA_PUBLICADA(42L),
    ALCANCE_INVITACION_DIRECTA(61L),
    ALCANCE_INVITACION_CERRADA(62L),
    INVITACION_DIRECTA(63L),
    INVITACION_CERRADA(64L),
    RECEPCION_PROPUESTAS(111L),
    EVALUACION(11L),
    ADJUDICACION(12L);


    private Long epcCodigo;


    /**
     * Constructor.
     * @param epcCodigo
     */
    EnumEstadoProcContrat (Long epcCodigo) 
    {
        this.epcCodigo = epcCodigo;
    }
    
    
    /**
     * Retorna el C&oacute;digo asociado al enumerado seleccionado.
     * @return epcCodigo
     */
    public Long getEpcCodigo () 
    {
        return epcCodigo;   
    }
    
}
