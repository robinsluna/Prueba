/*
 * SISTEMA	: SIICOL
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 01-02-2016
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de actuación para sustanciadores auditores / fiscalizadores
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public enum EnumTipoActuacion {
    VISITA(1L),
    FISCALIZACION_DOCUMENTAL(2L),
    PROCESO_INCUMPLIMIENTO(3L),
    PROCESO_FISCALIZACION(4L),
    VERIFICACION_EN_CAMPO(5L),
    PROCESO_SANCIONATORIO_ILEGALIDAD(6L),
    ACCION_DE_CONTROL(7L);


    /** Código del tipo de actuación*/
    private Long tacCodigo;


    /**
     * Constructor.
     * @param tacCodigo
     */

    EnumTipoActuacion(Long tacCodigo) {
        this.tacCodigo = tacCodigo;
    }


    /**
     * Obtiene el código del tipo de actuación
     * @return tacCodigo
     */
    public Long getTacCodigo() {
        return tacCodigo;
    }

}
