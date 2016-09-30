/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Mónica Pabón
 * FECHA	: 18-08-2015
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificaVentasMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReporteVentas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiVentasMet;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class ReporteVentasVO {
    private Long rveCodigo;
    private Date rveFecha;
    private BigDecimal rveInteresDe;
    private BigDecimal rveInteresGa;
    private Long rveMovimiento;
    private Integer rveNumRegistros;
    private String rveTipoReporte;
    private BigDecimal rveValorDe;
    private BigDecimal rveValorGa;
    private BigDecimal rveValorTotVentas;
    private Integer rveVigencia;
    private List<VentasMetVO> ventasMetListVo;
    private List<ModificaVentasMetVO> modificaVentasMetListVo;
    private MesVO mesVo;
    private ContratoVO contratoVo;
    private List<LiquidacionMesVO> liquidacionMesListVo;
    
   
    public ReporteVentasVO(SiiReporteVentas siiReporteVentas) {
       this.rveCodigo = siiReporteVentas.getRveCodigo();
       this.rveFecha = siiReporteVentas.getRveFecha();
       this.rveInteresDe = siiReporteVentas.getRveInteresDe();
       this.rveInteresGa = siiReporteVentas.getRveInteresGa();
       this.rveMovimiento = siiReporteVentas.getRveMovimiento();
       this.rveNumRegistros = siiReporteVentas.getRveNumRegistros();
       this.rveTipoReporte = siiReporteVentas.getRveTipoReporte();
       this.rveValorDe = siiReporteVentas.getRveValorDe();
       this.rveValorGa = siiReporteVentas.getRveValorGa();
       this.rveValorTotVentas = siiReporteVentas.getRveValorTotVentas();
       this.rveVigencia = siiReporteVentas.getRveVigencia();
       if(siiReporteVentas.getSiiMes()!= null){
           this.mesVo = new MesVO(siiReporteVentas.getSiiMes());
        }
       if(siiReporteVentas.getSiiContrato()!= null){
           this.contratoVo = new ContratoVO(siiReporteVentas.getSiiContrato());
        }
    }
   
    public ReporteVentasVO() {       
    }


    public void setRveCodigo(Long rveCodigo) {
        this.rveCodigo = rveCodigo;
    }

    public Long getRveCodigo() {
        return rveCodigo;
    }

    public void setRveFecha(Date rveFecha) {
        this.rveFecha = rveFecha;
    }

    public Date getRveFecha() {
        return rveFecha;
    }

    public void setRveInteresDe(BigDecimal rveInteresDe) {
        this.rveInteresDe = rveInteresDe;
    }

    public BigDecimal getRveInteresDe() {
        return rveInteresDe;
    }

    public void setRveInteresGa(BigDecimal rveInteresGa) {
        this.rveInteresGa = rveInteresGa;
    }

    public BigDecimal getRveInteresGa() {
        return rveInteresGa;
    }

    public void setRveMovimiento(Long rveMovimiento) {
        this.rveMovimiento = rveMovimiento;
    }

    public Long getRveMovimiento() {
        return rveMovimiento;
    }

    public void setRveNumRegistros(Integer rveNumRegistros) {
        this.rveNumRegistros = rveNumRegistros;
    }

    public Integer getRveNumRegistros() {
        return rveNumRegistros;
    }

    public void setRveTipoReporte(String rveTipoReporte) {
        this.rveTipoReporte = rveTipoReporte;
    }

    public String getRveTipoReporte() {
        return rveTipoReporte;
    }

    public void setRveValorDe(BigDecimal rveValorDe) {
        this.rveValorDe = rveValorDe;
    }

    public BigDecimal getRveValorDe() {
        return rveValorDe;
    }

    public void setRveValorGa(BigDecimal rveValorGa) {
        this.rveValorGa = rveValorGa;
    }

    public BigDecimal getRveValorGa() {
        return rveValorGa;
    }

    public void setRveValorTotVentas(BigDecimal rveValorTotVentas) {
        this.rveValorTotVentas = rveValorTotVentas;
    }

    public BigDecimal getRveValorTotVentas() {
        return rveValorTotVentas;
    }

    public void setRveVigencia(Integer rveVigencia) {
        this.rveVigencia = rveVigencia;
    }

    public Integer getRveVigencia() {
        return rveVigencia;
    }

    public void setVentasMetListVo(List<VentasMetVO> ventasMetListVo) {
        this.ventasMetListVo = ventasMetListVo;
    }

    public List<VentasMetVO> getVentasMetListVo() {
        return ventasMetListVo;
    }

    public void setModificaVentasMetListVo(List<ModificaVentasMetVO> modificaVentasMetListVo) {
        this.modificaVentasMetListVo = modificaVentasMetListVo;
    }

    public List<ModificaVentasMetVO> getModificaVentasMetListVo() {
        return modificaVentasMetListVo;
    }

    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setContratoVo(ContratoVO contratoVo) {
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo() {
        return contratoVo;
    }


    public void setLiquidacionMesListVo(List<LiquidacionMesVO> liquidacionMesListVo) {
        this.liquidacionMesListVo = liquidacionMesListVo;
    }

    public List<LiquidacionMesVO> getLiquidacionMesListVo() {
        return liquidacionMesListVo;
    }

}
