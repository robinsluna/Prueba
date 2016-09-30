package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistPersonalEmp;

import java.math.BigDecimal;

import java.util.Date;

public class HistPersonalEmpVO {

    private String hpmActivo;
    private Long hpmCodigo;
    private Date hpmFechaInactivac;
    private Date hpmFechaRegistro;
    private BigDecimal hpmPorcentajePart;
    private HistPersonaVO histPersonaEmpresaVO;
    private TipoPersonalVO tipoPersonalVO;
    private HistPersonaVO histPersonaPersonaVO;

    public HistPersonalEmpVO() {

    }

    public HistPersonalEmpVO(SiiHistPersonalEmp siiHistPersonalEmp) {

        this.hpmActivo = siiHistPersonalEmp.getHpmActivo();
        this.hpmCodigo = siiHistPersonalEmp.getHpmCodigo();
        this.hpmFechaInactivac = siiHistPersonalEmp.getHpmFechaInactivac();
        this.hpmFechaRegistro = siiHistPersonalEmp.getHpmFechaRegistro();
        this.hpmPorcentajePart = siiHistPersonalEmp.getHpmPorcentajePart();

        if (siiHistPersonalEmp.getSiiHistPersonaEmpresa() != null &&
            siiHistPersonalEmp.getSiiHistPersonaEmpresa().getHpeCodigo() > 0) {
            this.histPersonaEmpresaVO = new HistPersonaVO();
            this.histPersonaEmpresaVO.setHpeCodigo(siiHistPersonalEmp.getSiiHistPersonaEmpresa().getHpeCodigo());
        }

        if (siiHistPersonalEmp.getSiiTipoPersonal() != null &&
            siiHistPersonalEmp.getSiiTipoPersonal().getTpeCodigo() > 0) {
            this.tipoPersonalVO = new TipoPersonalVO();
            this.tipoPersonalVO.setTpeCodigo(siiHistPersonalEmp.getSiiTipoPersonal().getTpeCodigo());
        }

        if (siiHistPersonalEmp.getSiiHistPersonaPersona() != null &&
            siiHistPersonalEmp.getSiiHistPersonaPersona().getHpeCodigo() > 0) {
            this.histPersonaPersonaVO = new HistPersonaVO();
            this.histPersonaPersonaVO.setHpeCodigo(siiHistPersonalEmp.getSiiHistPersonaPersona().getHpeCodigo());
        }

    }


    public String getHpmActivo() {
        return hpmActivo;
    }

    public void setHpmActivo(String hpmActivo) {
        this.hpmActivo = hpmActivo;
    }

    public Long getHpmCodigo() {
        return hpmCodigo;
    }

    public void setHpmCodigo(Long hpmCodigo) {
        this.hpmCodigo = hpmCodigo;
    }

    public Date getHpmFechaInactivac() {
        return hpmFechaInactivac;
    }

    public void setHpmFechaInactivac(Date hpmFechaInactivac) {
        this.hpmFechaInactivac = hpmFechaInactivac;
    }

    public Date getHpmFechaRegistro() {
        return hpmFechaRegistro;
    }

    public void setHpmFechaRegistro(Date hpmFechaRegistro) {
        this.hpmFechaRegistro = hpmFechaRegistro;
    }

    public BigDecimal getHpmPorcentajePart() {
        return hpmPorcentajePart;
    }

    public void setHpmPorcentajePart(BigDecimal hpmPorcentajePart) {
        this.hpmPorcentajePart = hpmPorcentajePart;
    }

    public HistPersonaVO getHistPersonaEmpresaVO() {
        return histPersonaEmpresaVO;
    }

    public void setHistPersonaEmpresaVO(HistPersonaVO histPersonaEmpresaVO) {
        this.histPersonaEmpresaVO = histPersonaEmpresaVO;
    }

    public TipoPersonalVO getTipoPersonalVO() {
        return tipoPersonalVO;
    }

    public void setTipoPersonalVO(TipoPersonalVO tipoPersonalVO) {
        this.tipoPersonalVO = tipoPersonalVO;
    }

    public HistPersonaVO getHistPersonaPersonaVO() {
        return histPersonaPersonaVO;
    }

    public void setHistPersonaPersonaVO(HistPersonaVO histPersonaPersonaVO) {
        this.histPersonaPersonaVO = histPersonaPersonaVO;
    }
}
