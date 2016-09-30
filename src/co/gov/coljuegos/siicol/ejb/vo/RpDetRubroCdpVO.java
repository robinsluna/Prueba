/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 18-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifRpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOblConcRpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubroCdp;

import java.math.BigDecimal;

import java.util.List;


public class RpDetRubroCdpVO {

    private Long rdrCodigo;
    private BigDecimal rdrValor;
    private DetalleRubroCdpVO detalleRubroCdpVo;
    private RpVO rpVo;
    private List<ModifRpDetRubCdpVO> modifRpDetRubCdpListVo;
    private BigDecimal rdrSaldoAnterior;
    private List<ObligDetRubroCdpVO> obligDetRubroCdpListVo;
    private List<OblConcRpDetRubCdpVO> oblConcRpDetRubCdpListVo;


    public RpDetRubroCdpVO(SiiRpDetRubroCdp siiRpDetRubroCdp) {
        this.rdrCodigo = siiRpDetRubroCdp.getRdrCodigo();
        this.rdrValor = siiRpDetRubroCdp.getRdrValor();
        this.detalleRubroCdpVo = new DetalleRubroCdpVO(siiRpDetRubroCdp.getSiiDetalleRubroCdp());
        this.rpVo = new RpVO(siiRpDetRubroCdp.getSiiRp());
    }

    public RpDetRubroCdpVO() {
    }

    public void setRdrCodigo(Long rdrCodigo) {
        this.rdrCodigo = rdrCodigo;
    }

    public Long getRdrCodigo() {
        return rdrCodigo;
    }

    public void setRdrValor(BigDecimal rdrValor) {
        this.rdrValor = rdrValor;
    }

    public BigDecimal getRdrValor() {
        return rdrValor;
    }

    public void setDetalleRubroCdpVo(DetalleRubroCdpVO detalleRubroCdpVo) {
        this.detalleRubroCdpVo = detalleRubroCdpVo;
    }

    public DetalleRubroCdpVO getDetalleRubroCdpVo() {
        return detalleRubroCdpVo;
    }

    public void setRpVo(RpVO rpVo) {
        this.rpVo = rpVo;
    }

    public RpVO getRpVo() {
        return rpVo;
    }

    public void setModifRpDetRubCdpListVo(List<ModifRpDetRubCdpVO> modifRpDetRubCdpListVo) {
        this.modifRpDetRubCdpListVo = modifRpDetRubCdpListVo;
    }

    public List<ModifRpDetRubCdpVO> getModifRpDetRubCdpListVo() {
        return modifRpDetRubCdpListVo;
    }

    public void setRdrSaldoAnterior(BigDecimal rdrSaldoAnterior) {
        this.rdrSaldoAnterior = rdrSaldoAnterior;
    }

    public BigDecimal getRdrSaldoAnterior() {
        return rdrSaldoAnterior;
    }

    public void setObligDetRubroCdpListVo(List<ObligDetRubroCdpVO> obligDetRubroCdpListVo) {
        this.obligDetRubroCdpListVo = obligDetRubroCdpListVo;
    }

    public List<ObligDetRubroCdpVO> getObligDetRubroCdpListVo() {
        return obligDetRubroCdpListVo;
    }

    public void setOblConcRpDetRubCdpListVo(List<OblConcRpDetRubCdpVO> oblConcRpDetRubCdpListVo) {
        this.oblConcRpDetRubCdpListVo = oblConcRpDetRubCdpListVo;
    }

    public List<OblConcRpDetRubCdpVO> getOblConcRpDetRubCdpListVo() {
        return oblConcRpDetRubCdpListVo;
    }
}
