package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumRol {
    ADMINISTRADOR(1L),
    AREA_USUARIO_CONTRATACIÓN_ADM(2L),
    AREA_USUARIO_TESORERÍA(3L),
    ADMINISTRADOR_SESIONES(4L),
    CN_ANALISTA_GNA(5L),
    CN_EVALUADOR_FINANCIERO(6L),
    CN_EVALUADOR_GCT(7L),
    CN_EVALUADOR_CCO(8L),
    CN_ABOGADO_REVISOR(9L),
    CN_CANAL_DE_DISTRIBUCIÓN(10L),
    CN_NOTIFICACIONES_SAC(11L),
    AREA_USUARIO_GESTION_CONTABLE(21L),
    AREA_USUARIO_CARTERA(22L),
    AUXILIAR_GESTION_CONTABLE_I(23L),
    AUXILIAR_GESTION_CONTABLE_II(24L),
    AREA_USUARIO_PRESUPUESTO(41L),
    SOL_SOLECITO(47L),
    HOY_Y_MAÑANA(48L),
    LUNA_LUNEIRA(49L),
    ROLSEIÑO(52L),
    ROLERO(53L),
    ÁREA_USUARIO_GCT(61L),
    ÁREA_USUARIO_DME_GNA(62L),
    ANALISTA_PÓLIZA_LOCALIZADOS(82L),
    CN_ADMINISTRADOR(83L),
    AUDITOR_GCT(121L),
    FUNCIONARIO_1_GPCOI(141L),
    FUNCIONARIO_2_GPCOI(142L),
    FUNCIONARIO_3_GPCOI(143L),
    FUNCIONARIO_4_GPCOI(144L),
    REASIGNADOR_DE_REPARTO(361L)
;
    
    /** ID del Estado */
    private Long id;

    /**
     * Constructor.
     * @param id
     */
    EnumRol(Long id) {
        this.id = id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
