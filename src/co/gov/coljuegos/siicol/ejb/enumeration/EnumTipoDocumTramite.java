package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumTipoDocumTramite {
    ACTA_DE_SUSPENSION_AUDIENCIA_PROCESO_INCUMPLIMIENTO(7L),
    AUTO_DE_ARCHIVO_PROCESO_INCUMPLIMIENTO(9L),
    CITACION_AUDIENCIA_PROCESO_INCUMPLIMIENTO(10L),
    CONSTANCIA_EJECUTORIA_PROCESO_INCUMPLIMIENTO(6L),
    OFICIO_APROBACION_POLIZA_CONTRATO_CONCESION(2L),
    OFICIO_DE_CITACION_A_AUDIENCIA_PROCESO_INCUMPLIMIENTO(4L),
    OFICIO_REQUERIMIENTO_POLIZA_CONTRATO_CONCESION(3L),
    RESOLUCION_AUTORIZACION_LOCALIZADOS(1L),
    RESOLUCION_INCUMPLIMIENTO_PROCESO_INCUMPLIMIENTO(8L),
    RESOLUCION_SIN_SANCION_PROCESO_INCUMPLIMIENTO(5L);

    private Long id;

    EnumTipoDocumTramite(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
