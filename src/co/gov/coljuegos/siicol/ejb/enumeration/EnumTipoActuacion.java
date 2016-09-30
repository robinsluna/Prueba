/*
 * SISTEMA	: SIICOL
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 01-02-2016
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de actuaci�n para sustanciadores auditores / fiscalizadores
 * @author PAOLA ANDREA RUEDA LE�N
 */

public enum EnumTipoActuacion {
    VISITA(1L),
    FISCALIZACION_DOCUMENTAL(2L),
    PROCESO_INCUMPLIMIENTO(3L),
    PROCESO_FISCALIZACION(4L),
    VERIFICACION_EN_CAMPO(5L),
    PROCESO_SANCIONATORIO_ILEGALIDAD(6L),
    ACCION_DE_CONTROL(7L);


    /** C�digo del tipo de actuaci�n*/
    private Long tacCodigo;


    /**
     * Constructor.
     * @param tacCodigo
     */

    EnumTipoActuacion(Long tacCodigo) {
        this.tacCodigo = tacCodigo;
    }


    /**
     * Obtiene el c�digo del tipo de actuaci�n
     * @return tacCodigo
     */
    public Long getTacCodigo() {
        return tacCodigo;
    }

}
