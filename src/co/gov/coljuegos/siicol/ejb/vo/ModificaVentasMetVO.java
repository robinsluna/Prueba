/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Mónica Pabón
 * FECHA	: 18-08-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificaVentasMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReporteVentas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiVentasMet;

import java.math.BigDecimal;

import java.util.Date;

public class ModificaVentasMetVO {
    private Long mvmCodigo;
    private Date mvmFecha;
    private BigDecimal mvmValorVentas;
    private ReporteVentasVO reporteVentasVo;
    private VentasMetVO ventasMetVo;
    
    public ModificaVentasMetVO(SiiModificaVentasMet siiModificaVentasMet) {        
        this.mvmCodigo = siiModificaVentasMet.getMvmCodigo();
        this.mvmFecha = siiModificaVentasMet.getMvmFecha();
        this.mvmValorVentas = siiModificaVentasMet.getMvmValorVentas();
        if(siiModificaVentasMet.getSiiReporteVentas()!= null){
            this.reporteVentasVo= new ReporteVentasVO(siiModificaVentasMet.getSiiReporteVentas());
        }
        if(siiModificaVentasMet.getSiiVentasMet()!= null){
            this.ventasMetVo = new VentasMetVO(siiModificaVentasMet.getSiiVentasMet());
        }
    }
    public ModificaVentasMetVO() {        
    }


    public void setMvmCodigo(Long mvmCodigo) {
        this.mvmCodigo = mvmCodigo;
    }

    public Long getMvmCodigo() {
        return mvmCodigo;
    }

    public void setMvmFecha(Date mvmFecha) {
        this.mvmFecha = mvmFecha;
    }

    public Date getMvmFecha() {
        return mvmFecha;
    }

    public void setMvmValorVentas(BigDecimal mvmValorVentas) {
        this.mvmValorVentas = mvmValorVentas;
    }

    public BigDecimal getMvmValorVentas() {
        return mvmValorVentas;
    }

    public void setReporteVentasVo(ReporteVentasVO reporteVentasVo) {
        this.reporteVentasVo = reporteVentasVo;
    }

    public ReporteVentasVO getReporteVentasVo() {
        return reporteVentasVo;
    }

    public void setVentasMetVo(VentasMetVO ventasMetVo) {
        this.ventasMetVo = ventasMetVo;
    }

    public VentasMetVO getVentasMetVo() {
        return ventasMetVo;
    }
}
