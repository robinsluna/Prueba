package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CuotaOperadorVO {
    private Long copCodigo;
    private Integer copNumerocuota;
    private String copTipoDocSoporte;
    private Integer copVigencia;
    private Date copFechaLimitepago;
    private BigDecimal copValor;
    private String copCancelada;
    private String copTipoCartera;
    private BigDecimal copAbonoIni;
    private BigDecimal copAbonoIniInt;
    private BigDecimal copValorIncApa;
    private BigDecimal copValorIncIntApa;
    private Integer mesCodigo;
    
    
    
    private BigDecimal valoTotalDetalleCuota;//Calculo temporal de la suma de los detalles por Id cuota 
    
    private OperadorVO operadorVo;
    private ConceptoCuotaVO conceptoCuotaVo;
    private LiquidacionMesVO liquidacionMesVo;
    private AcuerdoPagoVO acuerdoPagoVo;
    private IncumplimientoContrVO incumplimientoContrVo;
    private ProcesoSancionatorioVO procesoSancionatorioVo;
    private ProcesoSancIlegalidadVO procesoSancIlegalidadVo;
    
    private List<InteresCuotaVO> interesCuotaList;
    
    
    private BigDecimal saldoInteres;
    
    public CuotaOperadorVO() {
      
    }
    
    public CuotaOperadorVO(SiiCuotaOperador siiCuotaOperador) {
        this.copCodigo = siiCuotaOperador.getCopCodigo();
        this.copNumerocuota = siiCuotaOperador.getCopNumCuota();
        this.copTipoDocSoporte = siiCuotaOperador.getCopTipoDocSopor();
        this.copVigencia = siiCuotaOperador.getCopVigencia();
        this.copFechaLimitepago = siiCuotaOperador.getCopFechaLimPag();
        this.copValor = siiCuotaOperador.getCopValor();
        this.copCancelada = siiCuotaOperador.getCopCancelada();
        this.copTipoCartera = siiCuotaOperador.getCopTipoCartera();
        this.copAbonoIni = siiCuotaOperador.getCopAbonoIni();
        this.copAbonoIniInt = siiCuotaOperador.getCopAbonoIniInt();
        this.copValorIncApa = siiCuotaOperador.getCopValorIncApa();
        this.copValorIncIntApa = siiCuotaOperador.getCopValorIncIntApa();
        this.mesCodigo = siiCuotaOperador.getMesCodigo();
        
        
        //padres
        if(siiCuotaOperador.getSiiOperador()!=null){
            this.operadorVo = new OperadorVO(siiCuotaOperador.getSiiOperador());
        }
        if(siiCuotaOperador.getSiiConceptoCuota() != null){
            this.conceptoCuotaVo = new ConceptoCuotaVO(siiCuotaOperador.getSiiConceptoCuota());
        }
        if(siiCuotaOperador.getSiiLiquidacionMes()!=null){
            this.liquidacionMesVo= new LiquidacionMesVO(siiCuotaOperador.getSiiLiquidacionMes());
        }
        if(siiCuotaOperador.getSiiAcuerdoPago()!= null){
            this.acuerdoPagoVo = new AcuerdoPagoVO(siiCuotaOperador.getSiiAcuerdoPago());
        }
        if (siiCuotaOperador.getSiiIncumplimientoContr()!=null) {
            this.incumplimientoContrVo = new IncumplimientoContrVO(siiCuotaOperador.getSiiIncumplimientoContr());
        }
        if (siiCuotaOperador.getSiiProcesoSancionatorio()!=null) {
            this.procesoSancionatorioVo = new ProcesoSancionatorioVO(siiCuotaOperador.getSiiProcesoSancionatorio());
        }
        if (siiCuotaOperador.getSiiProcesoSancIlegalidad()!=null) {
            this.procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO(siiCuotaOperador.getSiiProcesoSancIlegalidad());
        }
        
    }
    
    
    
    /**
     * Adiciona un nuevo registro de Inter&eacute;s Cuota a la Cuota Operador.
     * @param interesCuotaVo
     * @return Elemento adicionado?
     */
    public boolean addInteresCuota (InteresCuotaVO interesCuotaVo) {
        boolean adicionado = false;
        if (interesCuotaVo!=null) {
            if (interesCuotaList==null)
                this.interesCuotaList = new ArrayList<InteresCuotaVO>();
            
            adicionado = interesCuotaList.add(interesCuotaVo);
            
            if (adicionado)
                interesCuotaVo.setCuotaOperadorVo(this);
        }
        
        return (adicionado);
    }
    
    
    /**
     * Elimina un registro de Inter&eacute;s Cuota de la Cuota Operador.
     * @param interesCuotaVo
     * @return Elemento eliminado?
     */
    public boolean removeInteresCuota (InteresCuotaVO interesCuotaVo) {
        boolean eliminado = false;
        
        if (interesCuotaVo!=null) {
            if (interesCuotaList!=null) {
                eliminado = interesCuotaList.remove(interesCuotaVo);
                
                if (eliminado)
                    interesCuotaVo.setCuotaOperadorVo(null);
            }
        }
        
        return (eliminado);
    }
    
    
    
    public void setCopCodigo(Long copCodigo) {
        this.copCodigo = copCodigo;
    }

    public Long getCopCodigo() {
        return copCodigo;
    }

    public void setCopNumerocuota(Integer copNumerocuota) {
        this.copNumerocuota = copNumerocuota;
    }

    public Integer getCopNumerocuota() {
        return copNumerocuota;
    }

    public void setCopTipoDocSoporte(String copTipoDocSoporte) {
        this.copTipoDocSoporte = copTipoDocSoporte;
    }

    public String getCopTipoDocSoporte() {
        return copTipoDocSoporte;
    }

    public void setCopVigencia(Integer copVigencia) {
        this.copVigencia = copVigencia;
    }

    public Integer getCopVigencia() {
        return copVigencia;
    }

    public void setCopFechaLimitepago(Date copFechaLimitepago) {
        this.copFechaLimitepago = copFechaLimitepago;
    }

    public Date getCopFechaLimitepago() {
        return copFechaLimitepago;
    }

    public void setCopValor(BigDecimal copValor) {
        this.copValor = copValor;
    }

    public BigDecimal getCopValor() {
        return copValor;
    }

    public void setCopCancelada(String copCancelada) {
        this.copCancelada = copCancelada;
    }

    public String getCopCancelada() {
        return copCancelada;
    }

    public void setValoTotalDetalleCuota(BigDecimal valoTotalDetalleCuota) {
        this.valoTotalDetalleCuota = valoTotalDetalleCuota;
    }

    public BigDecimal getValoTotalDetalleCuota() {
        return valoTotalDetalleCuota;
    }

    public void setOperadorVo(OperadorVO operadorVo) {
        this.operadorVo = operadorVo;
    }

    public OperadorVO getOperadorVo() {
        return operadorVo;
    }

    public void setConceptoCuotaVo(ConceptoCuotaVO conceptoCuotaVo) {
        this.conceptoCuotaVo = conceptoCuotaVo;
    }

    public ConceptoCuotaVO getConceptoCuotaVo() {
        return conceptoCuotaVo;
    }

    public void setLiquidacionMesVo(LiquidacionMesVO liquidacionMesVo) {
        this.liquidacionMesVo = liquidacionMesVo;
    }

    public LiquidacionMesVO getLiquidacionMesVo() {
        return liquidacionMesVo;
    }

    public void setCopTipoCartera(String copTipoCartera) {
        this.copTipoCartera = copTipoCartera;
    }

    public String getCopTipoCartera() {
        return copTipoCartera;
    }

    public void setCopAbonoIni(BigDecimal copAbonoIni) {
        this.copAbonoIni = copAbonoIni;
    }

    public BigDecimal getCopAbonoIni() {
        return copAbonoIni;
    }

    public void setCopAbonoIniInt(BigDecimal copAbonoIniInt) {
        this.copAbonoIniInt = copAbonoIniInt;
    }

    public BigDecimal getCopAbonoIniInt() {
        return copAbonoIniInt;
    }

    public void setCopValorIncApa(BigDecimal copValorIncApa) {
        this.copValorIncApa = copValorIncApa;
    }

    public BigDecimal getCopValorIncApa() {
        return copValorIncApa;
    }

    public void setCopValorIncIntApa(BigDecimal copValorIncIntApa) {
        this.copValorIncIntApa = copValorIncIntApa;
    }

    public BigDecimal getCopValorIncIntApa() {
        return copValorIncIntApa;
    }

    public void setMesCodigo(Integer mesCodigo) {
        this.mesCodigo = mesCodigo;
    }

    public Integer getMesCodigo() {
        return mesCodigo;
    }

    public void setSaldoInteres(BigDecimal saldoInteres) {
        this.saldoInteres = saldoInteres;
    }

    public BigDecimal getSaldoInteres() {
        return saldoInteres;
    }

    public void setAcuerdoPagoVo(AcuerdoPagoVO acuerdoPagoVo) {
        this.acuerdoPagoVo = acuerdoPagoVo;
    }

    public AcuerdoPagoVO getAcuerdoPagoVo() {
        return acuerdoPagoVo;
    }

    public void setIncumplimientoContrVo(IncumplimientoContrVO incumplimientoContrVo) {
        this.incumplimientoContrVo = incumplimientoContrVo;
    }

    public IncumplimientoContrVO getIncumplimientoContrVo() {
        return incumplimientoContrVo;
    }

    public void setInteresCuotaList(List<InteresCuotaVO> interesCuotaList) {
        this.interesCuotaList = interesCuotaList;
    }

    public List<InteresCuotaVO> getInteresCuotaList() {
        return interesCuotaList;
    }

    public void setProcesoSancionatorioVo(ProcesoSancionatorioVO procesoSancionatorioVo) {
        this.procesoSancionatorioVo = procesoSancionatorioVo;
    }

    public ProcesoSancionatorioVO getProcesoSancionatorioVo() {
        return procesoSancionatorioVo;
    }

    public void setProcesoSancIlegalidadVo(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) {
        this.procesoSancIlegalidadVo = procesoSancIlegalidadVo;
    }

    public ProcesoSancIlegalidadVO getProcesoSancIlegalidadVo() {
        return procesoSancIlegalidadVo;
    }
}
