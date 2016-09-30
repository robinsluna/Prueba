/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 16-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;

import java.math.BigDecimal;

import java.util.List;

public class DetalleRubroCdpVO {
    
    private Long drcCodigo;
    private BigDecimal druValor;
    private CdpVO cdpVO;
    private DetalleRubroVO detalleRubroVO;
    private List<ObligDetRubroCdpVO> obligDetRubroCdpList1VO;
    private List<RpDetRubroCdpVO> rpDetRubroCdpListVO;
    private List<ModifCdpDetRubCdpVO> modifCdpDetRubCdpVoList1;
    private BigDecimal drcSaldoAnterior;
    private String drcAplicaGmf;
    private GravamenMovFinancVO gravamenMovFinancVo;

    public DetalleRubroCdpVO(SiiDetalleRubroCdp siiDetalleRubroCdp){
        if (siiDetalleRubroCdp != null) {
            this.drcCodigo = siiDetalleRubroCdp.getDrcCodigo();
            this.druValor = siiDetalleRubroCdp.getDruValor();
            this.drcSaldoAnterior = siiDetalleRubroCdp.getDrcSaldoAnterior();
            this.drcAplicaGmf = siiDetalleRubroCdp.getDrcAplicaGmf();
            
            //Padres
            if (siiDetalleRubroCdp.getSiiCdp() != null){
                this.cdpVO = new CdpVO(siiDetalleRubroCdp.getSiiCdp());
            }
            if(siiDetalleRubroCdp.getSiiDetalleRubro() != null){
                this.detalleRubroVO = new DetalleRubroVO(siiDetalleRubroCdp.getSiiDetalleRubro());        
            }
            if (siiDetalleRubroCdp.getSiiGravamenMovFinanc() != null){
                this.gravamenMovFinancVo = new GravamenMovFinancVO(siiDetalleRubroCdp.getSiiGravamenMovFinanc());
            }
        }
        
    }
    
    public DetalleRubroCdpVO(){
    }
    
    public void setDrcCodigo(Long drcCodigo) {
        this.drcCodigo = drcCodigo;
    }

    public Long getDrcCodigo() {
        return drcCodigo;
    }

    public void setDruValor(BigDecimal druValor) {
        this.druValor = druValor;
    }

    public BigDecimal getDruValor() {
        return druValor;
    }

    public void setCdpVO(CdpVO cdpVO) {
        this.cdpVO = cdpVO;
    }

    public CdpVO getCdpVO() {
        return cdpVO;
    }

    public void setDetalleRubroVO(DetalleRubroVO detalleRubroVO) {
        this.detalleRubroVO = detalleRubroVO;
    }

    public DetalleRubroVO getDetalleRubroVO() {
        return detalleRubroVO;
    }

    public void setObligDetRubroCdpList1VO(List<ObligDetRubroCdpVO> obligDetRubroCdpList1VO) {
        this.obligDetRubroCdpList1VO = obligDetRubroCdpList1VO;
    }

    public List<ObligDetRubroCdpVO> getObligDetRubroCdpList1VO() {
        return obligDetRubroCdpList1VO;
    }

    public void setRpDetRubroCdpListVO(List<RpDetRubroCdpVO> rpDetRubroCdpListVO) {
        this.rpDetRubroCdpListVO = rpDetRubroCdpListVO;
    }

    public List<RpDetRubroCdpVO> getRpDetRubroCdpListVO() {
        return rpDetRubroCdpListVO;
    }

    public void setModifCdpDetRubCdpVoList1(List<ModifCdpDetRubCdpVO> modifCdpDetRubCdpVoList1) {
        this.modifCdpDetRubCdpVoList1 = modifCdpDetRubCdpVoList1;
    }

    public List<ModifCdpDetRubCdpVO> getModifCdpDetRubCdpVoList1() {
        return modifCdpDetRubCdpVoList1;
    }

    public void setDrcSaldoAnterior(BigDecimal drcSaldoAnterior) {
        this.drcSaldoAnterior = drcSaldoAnterior;
    }

    public BigDecimal getDrcSaldoAnterior() {
        return drcSaldoAnterior;
    }

    public void setDrcAplicaGmf(String drcAplicaGmf) {
        this.drcAplicaGmf = drcAplicaGmf;
    }

    public String getDrcAplicaGmf() {
        return drcAplicaGmf;
    }

    public void setGravamenMovFinancVo(GravamenMovFinancVO gravamenMovFinancVo) {
        this.gravamenMovFinancVo = gravamenMovFinancVo;
    }

    public GravamenMovFinancVO getGravamenMovFinancVo() {
        return gravamenMovFinancVo;
    }
}


