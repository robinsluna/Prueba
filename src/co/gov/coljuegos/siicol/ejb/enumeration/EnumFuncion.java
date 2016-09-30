package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumFuncion {
    VICEPRESIDENTE_DE_DESARROLLO_ORGANIZACIONAL(1L),
    JEFE_DE_OFICINA_ASESORA_DE_PLANEACION(2L),
    FUNCIONARIO_TESORERIA(3L),
    DESARROLLADOR_SIICOL(4L),
    ARQUITECTO_SIICOL(5L),
    JEFE_DE_OFICINA_ASESORA_JURIDICA(6L),
    GERENTE_DE_CAPITAL_HUMANO(7L),
    ASESOR_GERENCIA_ADMINISTRATIVA_Y_FINANCIERA(8L),
    PRESIDENTE(9L),
    ASESOR(10L),
    ASESOR_COMUNICACIONES(11L),
    ASISTENTE_1_ADMINISTRATIVA_Y_FINANCIERA(12L),
    ASISTENTE_2_VICEPRESIDENCIA_DESARROLLO_ORGANIZACIONAL(13L),
    ASISTENTE_DE_LA_VICEPRESIDENCIA_DE_INNOVACION_DE_JUEGOS(14L),
    ASISTENTE_DE_VICEPRESIDENCIA_DE_GESTION_CONTRACTUAL(15L),
    ASISTENTE_PRESIDENCIA(16L),
    CONDUCTOR_ASISTENTE_2(17L),
    GERENTE_PROCESO_SERVICIO_AL_CLIENTE(18L),
    GERENTE_PROCESO_ADMINISTRATIVO_Y_FINANCIERO(19L),
    GERENTE_PROCESO_CAPITAL_HUMANO(20L),
    GERENTE_PROCESO_CONTROL_A_LAS_OPERACIONES_ILEGALES(22L),
    GERENTE_PROCESO_DE_NUEVOS_NEGOCIOS(23L),
    GERENTE_PROCESO_SECRETARIA_TECNICA_DEL_CNJSA(24L),
    JEFE_DE_CONTROL_INTERNO(25L),
    JEFE_DE_LA_OFICINA_ASESORA_JURIDICA(26L),
    PROFESIONAL_1_ADMINISTRATIVA_Y_FINANCIERA(28L),
    PROFESIONAL_1_CONTROL_A_LAS_OPERACIONES_ILEGALES(29L),
    PROFESIONAL_1_DESARROLLO_DE_MERCADOS(30L),
    PROFESIONAL_1_FISCALIZACION(31L),
    PROFESIONAL_1_SECRETARIA_TECNICA_DEL_CNJSA(32L),
    PROFESIONAL_1_TICS(33L),
    PROFESIONAL_2_SECRETARIA_T�CNICA_DEL_CNJSA(35L),
    PROFESIONAL_2_ADMINISTRATIVA_Y_FINANCIERA(36L),
    PROFESIONAL_2_CAPITAL_HUMANO(37L),
    PROFESIONAL_2_FISCALIZACION(38L),
    PROFESIONAL_2_NUEVOS_NEGOCIOS(39L),
    PROFESIONAL_2_OFICINA_PLANEACION(40L),
    PROFESIONAL_2_SECRETARIA_TECNICA_DEL_CNJSA(41L),
    PROFESIONAL_ESPECIALIZADO_1_PRESIDENCIA(42L),
    PROFESIONAL_ESPECIALIZADO_1_ADMINISTRATIVA_Y_FINANCIERA(43L),
    PROFESIONAL_ESPECIALIZADO_1_CONTROL_A_LAS_OPERACIONES_ILEGALES(44L),
    PROFESIONAL_ESPECIALIZADO_1_CONTROL_INTERNO(45L),
    PROFESIONAL_ESPECIALIZADO_1_JURIDICA(46L),
    PROFESIONAL_ESPECIALIZADO_1_TICS(47L),
    PROFESIONAL_ESPECIALIZADO_3(48L),
    PROFESIONAL_ESPECIALIZADO_3_OFICINA_JURIDICA(49L),
    PROFESIONAL_ESPECIALIZADO_3_SECRETARIA_TECNICA_DEL_CNJSA(50L),
    PROFESIONAL_ESPECIALZADO_2_FISCALIZACION(51L),
    TECNICO_1_ADMINISTRATIVA_Y_FINANCIERA(52L),
    TECNICO_2_CONTROL_A_LAS_OPERACIONES_ILEGALES(53L),
    TECNICO_2_ADMINISTRATIVA_Y_FINANCIERA(54L),
    VICEPRESIDENTE_DESARROLLO_DE_MERCADOS(55L),
    VICEPRESIDENTE_DE_GESTION_CONTRACTUAL(56L),
    FUNCIONARIO_EN_VACACIONES(101L),
    ITRC_AUDITOR(102L),
    CGR_AUDITOR(103L);


    /** ID del Estado del RP. */
    private Long id;

    /**
     * Constructor.
     * @param id
     */
    EnumFuncion(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
