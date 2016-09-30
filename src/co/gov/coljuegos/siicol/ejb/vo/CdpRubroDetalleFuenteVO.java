/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 28-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class CdpRubroDetalleFuenteVO {
    
    private Long consecutivo;
    private String tipoDocSop;
    private String numDocSop;
    private String desRubro;
    private String desFuente;
    private String dtlleFuente;
    private BigDecimal saldo;
    private BigDecimal valorRp;
    private BigDecimal saldoRubCdp;
    private Long idCdp;
    private Long idRubro;
    private Long idRp;
    private Long idDetRubCdp;
    private Long idRpDetRubroCdp;
    private BigDecimal saldoAnterior;
    private Long idFuente;
    private String cadena;
    private Integer vigencia;
    
        
    public CdpRubroDetalleFuenteVO() {
    }

    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Long getConsecutivo() {
        return consecutivo;
    }

    public void setTipoDocSop(String tipoDocSop) {
        this.tipoDocSop = tipoDocSop;
    }

    public String getTipoDocSop() {
        return tipoDocSop;
    }

    public void setNumDocSop(String numDocSop) {
        this.numDocSop = numDocSop;
    }

    public String getNumDocSop() {
        return numDocSop;
    }

    public void setDesRubro(String desRubro) {
        this.desRubro = desRubro;
    }

    public String getDesRubro() {
        return desRubro;
    }

    public void setDesFuente(String desFuente) {
        this.desFuente = desFuente;
    }

    public String getDesFuente() {
        return desFuente;
    }

    public void setDtlleFuente(String dtlleFuente) {
        this.dtlleFuente = dtlleFuente;
    }

    public String getDtlleFuente() {
        return dtlleFuente;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setIdCdp(Long idCdp) {
        this.idCdp = idCdp;
    }

    public Long getIdCdp() {
        return idCdp;
    }

    public void setIdRubro(Long idRubro) {
        this.idRubro = idRubro;
    }

    public Long getIdRubro() {
        return idRubro;
    }

    public void setIdRp(Long idRp) {
        this.idRp = idRp;
    }

    public Long getIdRp() {
        return idRp;
    }

    public void setValorRp(BigDecimal valorRp) {
        this.valorRp = valorRp;
    }

    public BigDecimal getValorRp() {
        return valorRp;
    }

    public void setSaldoRubCdp(BigDecimal saldoRubCdp) {
        this.saldoRubCdp = saldoRubCdp;
    }

    public BigDecimal getSaldoRubCdp() {
        return saldoRubCdp;
    }

    public void setIdDetRubCdp(Long idDetRubCdp) {
        this.idDetRubCdp = idDetRubCdp;
    }

    public Long getIdDetRubCdp() {
        return idDetRubCdp;
    }

    public void setIdRpDetRubroCdp(Long idRpDetRubroCdp) {
        this.idRpDetRubroCdp = idRpDetRubroCdp;
    }

    public Long getIdRpDetRubroCdp() {
        return idRpDetRubroCdp;
    }


    public void setSaldoAnterior(BigDecimal saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setIdFuente(Long idFuente) {
        this.idFuente = idFuente;
    }

    public Long getIdFuente() {
        return idFuente;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals()
     */
    @Override
    public boolean equals (Object o) {
        boolean igual = false;
        if (o instanceof CdpRubroDetalleFuenteVO) {
            CdpRubroDetalleFuenteVO crdfVO = (CdpRubroDetalleFuenteVO) o;
            if (crdfVO!=null) {
                igual = ( (crdfVO.consecutivo!=null && crdfVO.consecutivo.equals(this.consecutivo)) || (crdfVO.consecutivo==null && this.consecutivo==null) ) && 
                        ( (crdfVO.tipoDocSop!=null && crdfVO.tipoDocSop.equals(this.tipoDocSop)) || (crdfVO.tipoDocSop==null && this.tipoDocSop==null) ) &&
                        ( (crdfVO.numDocSop!=null && crdfVO.numDocSop.equals(this.numDocSop)) || (crdfVO.numDocSop==null && this.numDocSop==null) ) && 
                        ( (crdfVO.desRubro!=null && crdfVO.desRubro.equals(this.desRubro)) || (crdfVO.desRubro==null && this.desRubro==null) ) && 
                        ( (crdfVO.desFuente!=null && crdfVO.desFuente.equals(this.desFuente)) || (crdfVO.desFuente==null && this.desFuente==null) ) && 
                        ( (crdfVO.dtlleFuente!=null && crdfVO.dtlleFuente.equals(this.dtlleFuente)) || (crdfVO.dtlleFuente==null && this.dtlleFuente==null) ) && 
                        ( (crdfVO.saldo!=null && crdfVO.saldo.equals(this.saldo)) || (crdfVO.saldo==null && this.saldo==null) ) && 
                        ( (crdfVO.valorRp!=null && crdfVO.valorRp.equals(this.valorRp)) || (crdfVO.valorRp==null && this.valorRp==null) ) && 
                        ( (crdfVO.saldoRubCdp!=null && crdfVO.saldoRubCdp.equals(this.saldoRubCdp)) || (crdfVO.saldoRubCdp==null && this.saldoRubCdp==null) ) && 
                        ( (crdfVO.idCdp!=null && crdfVO.idCdp.equals(this.idCdp)) || (crdfVO.idCdp==null && this.idCdp==null) ) && 
                        ( (crdfVO.idRubro!=null && crdfVO.idRubro.equals(this.idRubro)) || (crdfVO.idRubro==null && this.idRubro==null) ) && 
                        ( (crdfVO.idRp!=null && crdfVO.idRp.equals(this.idRp)) || (crdfVO.idRp==null && this.idRp==null) ) && 
                        ( (crdfVO.idDetRubCdp!=null && crdfVO.idDetRubCdp.equals(this.idDetRubCdp)) || (crdfVO.idDetRubCdp==null && this.idDetRubCdp==null) ) && 
                        ( (crdfVO.idRpDetRubroCdp!=null && crdfVO.idRpDetRubroCdp.equals(this.idRpDetRubroCdp)) || (crdfVO.idRpDetRubroCdp==null && this.idRpDetRubroCdp==null) ) && 
                        ( (crdfVO.saldoAnterior!=null && crdfVO.saldoAnterior.equals(this.saldoAnterior)) || (crdfVO.saldoAnterior==null && this.saldoAnterior==null) ) && 
                        ( (crdfVO.idFuente!=null && crdfVO.idFuente.equals(this.idFuente)) || (crdfVO.idFuente==null && this.idFuente==null) ) && 
                        ( (crdfVO.cadena!=null && crdfVO.cadena.equals(this.cadena)) || (crdfVO.cadena==null && this.cadena==null) ) && 
                        ( (crdfVO.vigencia!=null && crdfVO.vigencia.equals(this.vigencia)) || (crdfVO.vigencia==null && this.vigencia==null) );
            }
        }
        return (igual);
    }
}
