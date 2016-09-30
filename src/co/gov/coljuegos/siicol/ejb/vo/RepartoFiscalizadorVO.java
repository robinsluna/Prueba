package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRepartoFiscalizador;

import java.util.Date;

public class RepartoFiscalizadorVO {

    private String rfsActivo;
    private Long rfsCodigo;
    private Date rfsFecha;
    private IncumplimientoContrVO incumplimientoContrVo;
    private FiscalizadorSustancVO fiscalizadorSustancVo;
    private ProcesoSancionatorioVO procesoSancionatorioVo;
    //
    private Integer numeroProceso;

    public RepartoFiscalizadorVO() {

    }

    public RepartoFiscalizadorVO(SiiRepartoFiscalizador repartoFiscalizador) {
        this.rfsActivo = repartoFiscalizador.getRfsActivo();
        this.rfsCodigo = repartoFiscalizador.getRfsCodigo();
        this.rfsFecha = repartoFiscalizador.getRfsFecha();
        //Padres:
        if(repartoFiscalizador.getSiiFiscalizadorSustanc() != null) {
            this.fiscalizadorSustancVo = new FiscalizadorSustancVO(repartoFiscalizador.getSiiFiscalizadorSustanc());
        }
        if(repartoFiscalizador.getSiiIncumplimientoContr() != null) {
            this.incumplimientoContrVo = new IncumplimientoContrVO(repartoFiscalizador.getSiiIncumplimientoContr());
        }
        if(repartoFiscalizador.getSiiProcesoSancionatorio() != null) {
            this.procesoSancionatorioVo = new ProcesoSancionatorioVO(repartoFiscalizador.getSiiProcesoSancionatorio());
        }

    }

    public void setRfsActivo(String rfsActivo) {
        this.rfsActivo = rfsActivo;
    }

    public String getRfsActivo() {
        return rfsActivo;
    }

    public void setRfsCodigo(Long rfsCodigo) {
        this.rfsCodigo = rfsCodigo;
    }

    public Long getRfsCodigo() {
        return rfsCodigo;
    }

    public void setRfsFecha(Date rfsFecha) {
        this.rfsFecha = rfsFecha;
    }

    public Date getRfsFecha() {
        return rfsFecha;
    }

    public void setIncumplimientoContrVo(IncumplimientoContrVO incumplimientoContrVo) {
        this.incumplimientoContrVo = incumplimientoContrVo;
    }

    public IncumplimientoContrVO getIncumplimientoContrVo() {
        return incumplimientoContrVo;
    }

    public void setFiscalizadorSustancVo(FiscalizadorSustancVO fiscalizadorSustancVo) {
        this.fiscalizadorSustancVo = fiscalizadorSustancVo;
    }

    public FiscalizadorSustancVO getFiscalizadorSustancVo() {
        return fiscalizadorSustancVo;
    }

    public void setProcesoSancionatorioVo(ProcesoSancionatorioVO procesoSancionatorioVo) {
        this.procesoSancionatorioVo = procesoSancionatorioVo;
    }

    public ProcesoSancionatorioVO getProcesoSancionatorioVo() {
        return procesoSancionatorioVo;
    }


    public void setNumeroProceso(Integer numeroProceso) {
        this.numeroProceso = this.getNumeroProceso();
    }

    public Integer getNumeroProceso() {
        if(this.incumplimientoContrVo != null && this.procesoSancionatorioVo != null) {
            return null;
        }
        else if(this.incumplimientoContrVo != null) {
            return this.getIncumplimientoContrVo().getIcnConsecutivo();
        }
        else if(this.procesoSancionatorioVo != null) {
            return this.getProcesoSancionatorioVo().getPsaConsecutivo();
        }
        else
            return null;
    }

}
