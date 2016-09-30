package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


public class SolicitudAutorizaVO {

    //private BigDecimal valorContrato;
    private Long sauCodigo;
    private Date sauFecha;
    private String sauRadicado;
    private String sauNumeroSiito;
    private Integer sauMovimientoSiito;
    private String sauNit;
    private Integer sauTiempoContr;
    private String sauLinkOrfeo;
    private BigDecimal sauValorProrroga;
    private BigDecimal sauValorEstimado;
    private EstadoSolicAutorizVO estadoSolicAutoriz;
    private ExpedienteFisicoVO expedienteFisicoVo;
    private TipoSolicAutorizaVO tipoSolicAutorizaVo;
    private List<NovedadVO> novedadListVo;
    private List<ResolucionAutorizVO> resolucionAutorizListVo;
    private List<OficioLiquidacionVO> oficioLiquidacionListVo;
    private List<DetalleFinancVO> detalleFinancListVo;
    private Long idEstadoAnterior;
    private ExpedienteDocumVO expedienteDocum;
    private PersonaVO personaRifaPromVo;
    private UsuarioVO usuarioVo;
    private Integer sauAmpliacion;
    private PersonaVO personaResDesLocVo;
    private String sauNitCesionario;
    // Campos adicionados que no pertenecen a la entidad o tabla en la base de datos
    private NovedadVO ultimaNovedadVo; 
    private OperadorVO operadorVo; 
    private OperadorVO operadorCesVo;


    public SolicitudAutorizaVO(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        this.sauCodigo = siiSolicitudAutoriza.getSauCodigo();
        this.sauFecha = siiSolicitudAutoriza.getSauFecha();
        this.sauNit = siiSolicitudAutoriza.getSauNit();
        this.sauMovimientoSiito = siiSolicitudAutoriza.getSauMovimientoSiito();
        this.sauTiempoContr = siiSolicitudAutoriza.getSauTiempoContr();
        this.sauAmpliacion = siiSolicitudAutoriza.getSauAmpliacion();
        this.sauNitCesionario = siiSolicitudAutoriza.getSauNitCesionario();

        if (siiSolicitudAutoriza.getSauValorProrroga() != null) {
            this.sauValorProrroga = siiSolicitudAutoriza.getSauValorProrroga();
        }
        if (siiSolicitudAutoriza.getSauValorEstimado() != null) {
            this.sauValorEstimado = siiSolicitudAutoriza.getSauValorEstimado();
        }

        if (siiSolicitudAutoriza.getSauMovimientoSiito() != null) {
            this.sauMovimientoSiito = siiSolicitudAutoriza.getSauMovimientoSiito();
        }
        //Padres:
        //Tipo Solicitud Autoriza
        if (siiSolicitudAutoriza.getSiiTipoSolicAutoriza() != null) {
            this.tipoSolicAutorizaVo = new TipoSolicAutorizaVO(siiSolicitudAutoriza.getSiiTipoSolicAutoriza());
        }
        //Estado Solicitud Autoriza
        if (siiSolicitudAutoriza.getSiiEstadoSolicAutoriz() != null) {
            this.estadoSolicAutoriz = new EstadoSolicAutorizVO(siiSolicitudAutoriza.getSiiEstadoSolicAutoriz());
            this.idEstadoAnterior = siiSolicitudAutoriza.getSiiEstadoSolicAutoriz().getEsaCodigo();
        }
        //Expediente fisica
        if (siiSolicitudAutoriza.getSiiExpedienteFisico() != null) {
            this.expedienteFisicoVo = new ExpedienteFisicoVO(siiSolicitudAutoriza.getSiiExpedienteFisico());
        }
        if(siiSolicitudAutoriza.getSiiExpedienteDocum() != null){
            this.expedienteDocum = new ExpedienteDocumVO(siiSolicitudAutoriza.getSiiExpedienteDocum());
        }
        if(siiSolicitudAutoriza.getSiiPersonaRifaProm()!= null){
            this.personaRifaPromVo = new PersonaVO(siiSolicitudAutoriza.getSiiPersonaRifaProm());
        }
        if(siiSolicitudAutoriza.getSiiUsuario()!= null){
            this.usuarioVo= new UsuarioVO(siiSolicitudAutoriza.getSiiUsuario());
        }

    }

    public void setPersonaResDesLocVo(PersonaVO personaResDesLocVo) {
        this.personaResDesLocVo = personaResDesLocVo;
    }

    public PersonaVO getPersonaResDesLocVo() {
        return personaResDesLocVo;
    }

    public SolicitudAutorizaVO() {
    }

    public void setSauNit(String sauNit) {
        this.sauNit = sauNit;
    }

    public String getSauNit() {
        return sauNit;
    }

    public void setSauTiempoContr(Integer sauTiempoContr) {
        this.sauTiempoContr = sauTiempoContr;
    }

    public Integer getSauTiempoContr() {
        return sauTiempoContr;
    }

    public void setSauNumeroSiito(String sauNumeroSiito) {
        this.sauNumeroSiito = sauNumeroSiito;
    }

    public String getSauNumeroSiito() {
        return sauNumeroSiito;
    }

    public void setSauCodigo(Long sauCodigo) {
        this.sauCodigo = sauCodigo;
    }

    public Long getSauCodigo() {
        return sauCodigo;
    }

    public void setSauFecha(Date sauFecha) {
        this.sauFecha = sauFecha;
    }

    public Date getSauFecha() {
        return sauFecha;
    }

    public void setSauRadicado(String sauRadicado) {
        this.sauRadicado = sauRadicado;
    }

    public String getSauRadicado() {
        return sauRadicado;
    }

    public void setTipoSolicAutorizaVo(TipoSolicAutorizaVO tipoSolicAutorizaVo) {
        this.tipoSolicAutorizaVo = tipoSolicAutorizaVo;
    }

    public TipoSolicAutorizaVO getTipoSolicAutorizaVo() {
        return tipoSolicAutorizaVo;
    }

    public void setEstadoSolicAutoriz(EstadoSolicAutorizVO estadoSolicAutoriz) {
        this.estadoSolicAutoriz = estadoSolicAutoriz;
    }

    public EstadoSolicAutorizVO getEstadoSolicAutoriz() {
        return estadoSolicAutoriz;
    }

    public void setSauMovimientoSiito(Integer sauMovimientoSiito) {
        this.sauMovimientoSiito = sauMovimientoSiito;
    }

    public Integer getSauMovimientoSiito() {
        return sauMovimientoSiito;
    }

    public void setResolucionAutorizListVo(List<ResolucionAutorizVO> resolucionAutorizListVo) {
        this.resolucionAutorizListVo = resolucionAutorizListVo;
    }

    public List<ResolucionAutorizVO> getResolucionAutorizListVo() {
        return resolucionAutorizListVo;
    }

    public void setOficioLiquidacionListVo(List<OficioLiquidacionVO> oficioLiquidacionListVo) {
        this.oficioLiquidacionListVo = oficioLiquidacionListVo;
    }

    public List<OficioLiquidacionVO> getOficioLiquidacionListVo() {
        return oficioLiquidacionListVo;
    }

    public void setNovedadListVo(List<NovedadVO> novedadListVo) {
        this.novedadListVo = novedadListVo;
    }

    public List<NovedadVO> getNovedadListVo() {
        return novedadListVo;
    }

    public void setUltimaNovedadVo(NovedadVO ultimaNovedadVo) {
        this.ultimaNovedadVo = ultimaNovedadVo;
    }

    public NovedadVO getUltimaNovedadVo() {
        return ultimaNovedadVo;
    }

    public void setOperadorVo(OperadorVO operadorVo) {
        this.operadorVo = operadorVo;
    }

    public OperadorVO getOperadorVo() {
        return operadorVo;
    }


    public void setSauValorProrroga(BigDecimal sauValorProrroga) {
        this.sauValorProrroga = sauValorProrroga;
    }

    public BigDecimal getSauValorProrroga() {
        return sauValorProrroga;
    }

    public void setSauValorEstimado(BigDecimal sauValorEstimado) {
        this.sauValorEstimado = sauValorEstimado;
    }

    public BigDecimal getSauValorEstimado() {
        return sauValorEstimado;
    }

    public void setSauLinkOrfeo(String sauLinkOrfeo) {
        this.sauLinkOrfeo = sauLinkOrfeo;
    }

    public String getSauLinkOrfeo() {
        return sauLinkOrfeo;
    }

    public void setExpedienteFisicoVo(ExpedienteFisicoVO expedienteFisicoVo) {
        this.expedienteFisicoVo = expedienteFisicoVo;
    }

    public ExpedienteFisicoVO getExpedienteFisicoVo() {
        return expedienteFisicoVo;
    }

    public void setDetalleFinancListVo(List<DetalleFinancVO> detalleFinancListVo) {
        this.detalleFinancListVo = detalleFinancListVo;
    }

    public List<DetalleFinancVO> getDetalleFinancListVo() {
        return detalleFinancListVo;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }


    public void setExpedienteDocum(ExpedienteDocumVO expedienteDocum) {
        this.expedienteDocum = expedienteDocum;
    }

    public ExpedienteDocumVO getExpedienteDocum() {
        return expedienteDocum;
    }

    public void setPersonaRifaPromVo(PersonaVO personaRifaPromVo) {
        this.personaRifaPromVo = personaRifaPromVo;
    }

    public PersonaVO getPersonaRifaPromVo() {
        return personaRifaPromVo;
    }


    public void setUsuarioVo(UsuarioVO usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioVO getUsuarioVo() {
        return usuarioVo;
    }

    public void setSauAmpliacion(Integer sauAmpliacion) {
        this.sauAmpliacion = sauAmpliacion;
    }

    public Integer getSauAmpliacion() {
        return sauAmpliacion;
    }
    
    
    /**
     * Obtiene el valor total correspondiente a los derechos de explotaci&oacute;n y los gastos de administraci&oacute;n de cada Oficio de Liquidaci&oacue;n.
     * @return Valor Total.
     */
    public BigDecimal getTotalOficioLiquidacion () 
    {
        BigDecimal total = new BigDecimal(0);
        
        if (oficioLiquidacionListVo!=null && !oficioLiquidacionListVo.isEmpty()) {
            for (OficioLiquidacionVO oficio: oficioLiquidacionListVo) {
                if (oficio!=null) {
                    if (oficio.getOliValorDerExpl()!=null)
                        total = total.add(oficio.getOliValorDerExpl());
                    
                    if (oficio.getOliValorGastAdm()!=null)
                        total = total.add(oficio.getOliValorGastAdm());
                }
                
                /*
                if (oficio!=null && oficio.getOficLiqTipoApuestaListVo()!=null) {
                    // se suman los derechos de explotacion y los gastos de administracion por cada detalle del Oficio de Liquidacion.
                    BigDecimal derechosExplotacion = new BigDecimal(0);
                    BigDecimal gastosAdmin = new BigDecimal(0);
                    
                    for (OficLiqTipoApuestaVO oltaVo: oficio.getOficLiqTipoApuestaListVo()) {
                        if (oltaVo!=null) {
                            if (oltaVo.getOtaDerExplMes()!=null)
                                derechosExplotacion = derechosExplotacion.add(oltaVo.getOtaDerExplMes());
                            
                            if (oltaVo.getOtaGasAdmin()!=null)
                                gastosAdmin = gastosAdmin.add(oltaVo.getOtaGasAdmin());
                        }
                    }
                    
                    total = total.add(derechosExplotacion);
                    total = total.add(gastosAdmin);
                }
                */
            }
        }
        
        return (total);
    }

    public void setSauNitCesionario(String sauNitCesionario) {
        this.sauNitCesionario = sauNitCesionario;
    }

    public String getSauNitCesionario() {
        return sauNitCesionario;
    }

    public void setOperadorCesVo(OperadorVO operadorCesVo) {
        this.operadorCesVo = operadorCesVo;
    }

    public OperadorVO getOperadorCesVo() {
        return operadorCesVo;
    }
}
