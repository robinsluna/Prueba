package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeSupervision;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InformeSupervisionVO implements Comparable<InformeSupervisionVO> {

    private Long isuCodigo;
    private String isuEstado;
    private Date isuFechaRadicacion;
    private String isuRadicado;
    private ContratoVO contratoVo;
    private ArchivoFisicoVO archivoFisicoVo;
    private UsuarioVO usuarioVo;
    private TipoActuacionVO tipoActuacionVo;
    private List<MotivoIncuInfSupervVO> motivoIncuInfSupervListVo;
    private List<IncumplimientoContrVO> incumplimientoContrListVo;
    private List<ProcesoSancionatorioVO> procesoSancionatorioListVo;


    //campos que no corresponden a la entity:

    private String motivo;
    private BigDecimal valorInicialContrato;
    private List<PolizaContratVO> polizasVo;
    private List<OtroSiVO> listaOtroSiVo;
    private String indicadorEstadoCuenta;


    public InformeSupervisionVO() {

    }

    public InformeSupervisionVO(SiiInformeSupervision informeSupervision) {
        this.isuCodigo = informeSupervision.getIsuCodigo();

        this.isuEstado = informeSupervision.getIsuEstado();
        this.isuFechaRadicacion = informeSupervision.getIsuFechaRadicacion();
        this.isuRadicado = informeSupervision.getIsuRadicado();
        //Padres:
        if(informeSupervision.getSiiArchivoFisico() != null) {
            this.archivoFisicoVo = new ArchivoFisicoVO(informeSupervision.getSiiArchivoFisico());
        }
        if(informeSupervision.getSiiContrato() != null) {
            this.contratoVo = new ContratoVO(informeSupervision.getSiiContrato());
        }
        if(informeSupervision.getSiiUsuario() != null) {
            this.usuarioVo = new UsuarioVO(informeSupervision.getSiiUsuario());
        }
        if(informeSupervision.getSiiTipoActuacion() != null) {
            this.tipoActuacionVo = new TipoActuacionVO(informeSupervision.getSiiTipoActuacion());
        }
    }

    public void setIsuCodigo(Long isuCodigo) {
        this.isuCodigo = isuCodigo;
    }

    public Long getIsuCodigo() {
        return isuCodigo;
    }

    public void setIsuEstado(String isuEstado) {
        this.isuEstado = isuEstado;
    }

    public String getIsuEstado() {
        return isuEstado;
    }

    public void setIsuFechaRadicacion(Date isuFechaRadicacion) {
        this.isuFechaRadicacion = isuFechaRadicacion;
    }

    public Date getIsuFechaRadicacion() {
        return isuFechaRadicacion;
    }

    public void setIsuRadicado(String isuRadicado) {
        this.isuRadicado = isuRadicado;
    }

    public String getIsuRadicado() {
        return isuRadicado;
    }

    public void setContratoVo(ContratoVO contratoVo) {
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo() {
        return contratoVo;
    }

    public void setIncumplimientoContrListVo(List<IncumplimientoContrVO> incumplimientoContrListVo) {
        this.incumplimientoContrListVo = incumplimientoContrListVo;
    }

    public List<IncumplimientoContrVO> getIncumplimientoContrListVo() {
        return incumplimientoContrListVo;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setUsuarioVo(UsuarioVO usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public UsuarioVO getUsuarioVo() {
        return usuarioVo;
    }

    public void setPolizasVo(List<PolizaContratVO> polizasVo) {
        this.polizasVo = polizasVo;
    }

    public List<PolizaContratVO> getPolizasVo() {
        return polizasVo;
    }

    public void setListaOtroSiVo(List<OtroSiVO> listaOtroSiVo) {
        this.listaOtroSiVo = listaOtroSiVo;
    }

    public List<OtroSiVO> getListaOtroSiVo() {
        return listaOtroSiVo;
    }

    public void setValorInicialContrato(BigDecimal valorInicialContrato) {
        this.valorInicialContrato = valorInicialContrato;
    }

    public BigDecimal getValorInicialContrato() {
        return valorInicialContrato;
    }

    public void setMotivoIncuInfSupervListVo(List<MotivoIncuInfSupervVO> motivoIncuInfSupervListVo) {
        this.motivoIncuInfSupervListVo = motivoIncuInfSupervListVo;
    }

    public List<MotivoIncuInfSupervVO> getMotivoIncuInfSupervListVo() {
        return motivoIncuInfSupervListVo;
    }

    public void setIndicadorEstadoCuenta(String indicadorEstadoCuenta) {
        this.indicadorEstadoCuenta = indicadorEstadoCuenta;
    }

    public String getIndicadorEstadoCuenta() {
        return indicadorEstadoCuenta;
    }

    public void setIncumplimientoContrVo(IncumplimientoContrVO incumplimientoContrVo) {
        this.incumplimientoContrListVo = new ArrayList<IncumplimientoContrVO>();
        this.incumplimientoContrListVo.add(incumplimientoContrVo);
    }

    public IncumplimientoContrVO getIncumplimientoContrVo() {
        if(incumplimientoContrListVo != null && incumplimientoContrListVo.size() > 0 && incumplimientoContrListVo.get(0) != null) {
            return incumplimientoContrListVo.get(0);
        }
        else {
            return new IncumplimientoContrVO();
        }

    }

    public void setTipoActuacionVo(TipoActuacionVO tipoActuacionVo) {
        this.tipoActuacionVo = tipoActuacionVo;
    }

    public TipoActuacionVO getTipoActuacionVo() {
        return tipoActuacionVo;
    }

    public void setProcesoSancionatorioListVo(List<ProcesoSancionatorioVO> procesoSancionatorioListVo) {
        this.procesoSancionatorioListVo = procesoSancionatorioListVo;
    }

    public List<ProcesoSancionatorioVO> getProcesoSancionatorioListVo() {
        return procesoSancionatorioListVo;
    }

    public void setProcesoSancionatorioVo(ProcesoSancionatorioVO procesoSancionatorioVo) {
        this.procesoSancionatorioListVo = new ArrayList<ProcesoSancionatorioVO>();
        this.procesoSancionatorioListVo.add(procesoSancionatorioVo);
    }

    public ProcesoSancionatorioVO getProcesoSancionatorioVo() {
        if(procesoSancionatorioListVo != null && procesoSancionatorioListVo.size() > 0 && procesoSancionatorioListVo.get(0) != null) {
            return procesoSancionatorioListVo.get(0);
        }
        else {
            return new ProcesoSancionatorioVO();
        }

    }

    public String getEstadoProceso() {
        if("Proceso Fiscalización".equals(this.getTipoActuacionVo().getTacNombre()) && getProcesoSancionatorioVo().getEstadoProcesoSancVo() != null) {
            return this.getProcesoSancionatorioVo().getEstadoProcesoSancVo().getEpsNombre();
        }
        else if("Proceso Incumplimiento".equals(this.getTipoActuacionVo().getTacNombre()) && getIncumplimientoContrVo().getEstadoIncumplContractVo() != null) {
            return this.getIncumplimientoContrVo().getEstadoIncumplContractVo().getEicNombre();
        }
        return null;
    }

    public Integer getConsecutivo() {
        if("Proceso Fiscalización".equals(this.getTipoActuacionVo().getTacNombre()) && getProcesoSancionatorioVo().getEstadoProcesoSancVo() != null) {
            return this.getProcesoSancionatorioVo().getPsaConsecutivo();
        }
        else if("Proceso Incumplimiento".equals(this.getTipoActuacionVo().getTacNombre()) && getIncumplimientoContrVo().getEstadoIncumplContractVo() != null) {
            return this.getIncumplimientoContrVo().getIcnConsecutivo();
        }
        return null;
    }


    /**
     * Obtiene una cadena que contiene todos los Motivos de Incumplimiento ACTIVOS del Informe de Supervisi&oacute;n.
     * @return Representaci&oacute;n String de motivoIncuInfSupervListVo.
     */
    public String getCadenaMotivosIncumplimiento() {
        StringBuilder motivos = new StringBuilder();

        if(motivoIncuInfSupervListVo != null && !motivoIncuInfSupervListVo.isEmpty()) {
            Iterator<MotivoIncuInfSupervVO> itMii = motivoIncuInfSupervListVo.iterator();
            while(itMii.hasNext()) {
                MotivoIncuInfSupervVO miiVo = itMii.next();
                if(miiVo != null && EnumDecision.SI.getId().equals(miiVo.getMiiActivo())) {
                    MotivoIncumplimientoVO motivo = miiVo.getMotivoIncumplimientoVo();
                    if(motivo != null && motivo.getMinNombre() != null) {
                        motivos.append(motivo.getMinNombre());

                        if(itMii.hasNext())
                            motivos.append(", ");
                    }
                }
            }
        }
        else
            return null;

        return (motivos.toString());
    }


    /**
     * Obtiene el primer registro de Motivo de Incumplimiento ACTIVO.
     * (Para los procesos de Fiscalizaci&oacute;n e Incumplimiento, s&oacute;lamente deber&iacute;a existir un &uacute;nico motivo).
     * @return motivoIncuInfSupervListVo.motivoIncumplimientoVo ACTIVO.
     */
    public MotivoIncumplimientoVO getMotivoIncumplimiento() {
        MotivoIncumplimientoVO motivoIncumplimientoVo = null;

        if(motivoIncuInfSupervListVo != null && !motivoIncuInfSupervListVo.isEmpty()) {
            Iterator<MotivoIncuInfSupervVO> itMii = motivoIncuInfSupervListVo.iterator();
            while(itMii.hasNext() && motivoIncumplimientoVo == null) {
                MotivoIncuInfSupervVO miiVo = itMii.next();
                if(miiVo != null && EnumDecision.SI.getId().equals(miiVo.getMiiActivo()))
                    motivoIncumplimientoVo = miiVo.getMotivoIncumplimientoVo();
            }
        }

        return (motivoIncumplimientoVo);
    }


    /**
     * Obtiene el listado de Motivos de Incumplimiento ACTIVOS.
     * @return Lista de motivoIncuInfSupervListVo.motivoIncumplimientoVo ACTIVOS.
     */
    public List<MotivoIncumplimientoVO> getListaMotivosIncumplimientoActivos() {
        List<MotivoIncumplimientoVO> resultado = null;

        if(motivoIncuInfSupervListVo != null && !motivoIncuInfSupervListVo.isEmpty()) {
            resultado = new ArrayList<MotivoIncumplimientoVO>();
            Iterator<MotivoIncuInfSupervVO> itMii = motivoIncuInfSupervListVo.iterator();
            while(itMii.hasNext()) {
                MotivoIncuInfSupervVO miiVo = itMii.next();
                if(miiVo != null && EnumDecision.SI.getId().equals(miiVo.getMiiActivo())) {
                    MotivoIncumplimientoVO motivoIncumplimientoVo = miiVo.getMotivoIncumplimientoVo();
                    if(motivoIncumplimientoVo != null)
                        resultado.add(motivoIncumplimientoVo);
                }
            }
        }

        return (resultado);
    }

    @Override
    public int compareTo(InformeSupervisionVO compareInformeSupervisionVO) {
        if(compareInformeSupervisionVO != null && compareInformeSupervisionVO.getIsuCodigo() != null)
            return compareInformeSupervisionVO.getIsuCodigo().compareTo(this.getIsuCodigo());
        else if(compareInformeSupervisionVO.getIsuCodigo() != null)
            return 1;
        else if(this.getIsuCodigo() != null)
            return -1;
        else
            return 0;

    }

}
