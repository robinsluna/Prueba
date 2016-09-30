/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Glenis Reyes
 * FECHA	: 28-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificPfcAnual;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicPfcmDetalle;

import java.math.BigDecimal;

public class ModificPfcAnualVO {
    
    private String mpaActivo;
    private Long mpaCodigo;
    private String mpaJustificacion;
    private String mpaTipoModif;
    private BigDecimal mpaValor;
    private DistribucionPfcVO distribucionPfcVo;
    private String cadena;
    private SolicPfcmDetalleVO solicPfcmDetalleVo;
    private MesVO mesVo;
    private String vigencia;
    
    public ModificPfcAnualVO(SiiModificPfcAnual siiModificPfcAnual) {
        this.mpaActivo = siiModificPfcAnual.getMpaActivo();
        this.mpaCodigo = siiModificPfcAnual.getMpaCodigo();
        this.mpaJustificacion = siiModificPfcAnual.getMpaJustificacion();
        this.mpaTipoModif = siiModificPfcAnual.getMpaTipoModif();
        this.mpaValor = siiModificPfcAnual.getMpaValor();
        this.distribucionPfcVo = new DistribucionPfcVO(siiModificPfcAnual.getSiiDistribucionPfc());
        this.solicPfcmDetalleVo = new SolicPfcmDetalleVO(siiModificPfcAnual.getSiiSolicPfcmDetalle());
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public void setSolicPfcmDetalleVo(SolicPfcmDetalleVO solicPfcmDetalleVo) {
        this.solicPfcmDetalleVo = solicPfcmDetalleVo;
    }

    public SolicPfcmDetalleVO getSolicPfcmDetalleVo() {
        return solicPfcmDetalleVo;
    }

    public ModificPfcAnualVO() {
    }

    public void setMpaActivo(String mpaActivo) {
        this.mpaActivo = mpaActivo;
    }

    public String getMpaActivo() {
        return mpaActivo;
    }

    public void setMpaCodigo(Long mpaCodigo) {
        this.mpaCodigo = mpaCodigo;
    }

    public Long getMpaCodigo() {
        return mpaCodigo;
    }

    public void setMpaJustificacion(String mpaJustificacion) {
        this.mpaJustificacion = mpaJustificacion;
    }

    public String getMpaJustificacion() {
        return mpaJustificacion;
    }

    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setMpaTipoModif(String mpaTipoModif) {
        this.mpaTipoModif = mpaTipoModif;
    }

    public String getMpaTipoModif() {
        return mpaTipoModif;
    }

    public void setMpaValor(BigDecimal mpaValor) {
        this.mpaValor = mpaValor;
    }

    public BigDecimal getMpaValor() {
        return mpaValor;
    }

    public void setDistribucionPfcVo(DistribucionPfcVO distribucionPfcVo) {
        this.distribucionPfcVo = distribucionPfcVo;
    }

    public DistribucionPfcVO getDistribucionPfcVo() {
        return distribucionPfcVo;
    }

   

}
