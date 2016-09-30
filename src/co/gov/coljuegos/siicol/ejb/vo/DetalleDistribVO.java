package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCategoriaDistrib;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDistrib;

import java.math.BigDecimal;

import java.util.List;

public class DetalleDistribVO {
    
    private Long ddiCodigo;
    private BigDecimal ddiValorDetod;
    private BigDecimal ddiValorProp;
    private BigDecimal ddiValorRec;
    private BigDecimal ddiValorTodos;    
    private DistribucionMesVO distribucionMesVo;
    private EnteTerritorialVO enteTerritorialVo;
    private String ddiEsInteres;
    private BigDecimal ddiPorcentParticip;
    private BigDecimal ddiSubtotalTranf;
    private BigDecimal ddiValColciencias;
    private BigDecimal ddiValRendimFinanc;
    private BigDecimal ddiValTotMunicipios;
    private BigDecimal ddiValTotSaypFosiga;
    private BigDecimal ddiValTotalControl;
    private BigDecimal ddiValTotalTranfer;
    private CategoriaDistribVO categoriaDistribVo;
    
    private List<ObligacionVO> obligacionVoList;
    
    
    public DetalleDistribVO(SiiDetalleDistrib siiDetalleDistrib) {
        this.ddiCodigo = siiDetalleDistrib.getDdiCodigo();
        this.ddiValorDetod = siiDetalleDistrib.getDdiValorDetod();
        this.ddiValorProp = siiDetalleDistrib.getDdiValorProp();
        this.ddiValorRec = siiDetalleDistrib.getDdiValorRec();
        this.ddiValorTodos = siiDetalleDistrib.getDdiValorTodos();
        this.ddiEsInteres = siiDetalleDistrib.getDdiEsInteres();
        this.ddiPorcentParticip = siiDetalleDistrib.getDdiPorcentParticip();
        this.ddiSubtotalTranf = siiDetalleDistrib.getDdiSubtotalTranf();
        this.ddiValColciencias = siiDetalleDistrib.getDdiValColciencias();
        this.ddiValRendimFinanc = siiDetalleDistrib.getDdiValRendimFinanc();
        this.ddiValTotMunicipios = siiDetalleDistrib.getDdiValTotMunicipios();
        this.ddiValTotSaypFosiga = siiDetalleDistrib.getDdiValTotSaypFosiga();
        this.ddiValTotalControl = siiDetalleDistrib.getDdiValTotalControl();
        this.ddiValTotalTranfer = siiDetalleDistrib.getDdiValTotalTranfer();                
        
        if(siiDetalleDistrib.getSiiCategoriaDistrib()!= null){
            this.categoriaDistribVo = new CategoriaDistribVO(siiDetalleDistrib.getSiiCategoriaDistrib());
        }
        if(siiDetalleDistrib.getSiiDistribucionMes()!= null){            
            this.distribucionMesVo =  new DistribucionMesVO(siiDetalleDistrib.getSiiDistribucionMes());
        }
        
        if(siiDetalleDistrib.getSiiEnteTerritorial() != null){
            this.enteTerritorialVo =  new EnteTerritorialVO(siiDetalleDistrib.getSiiEnteTerritorial());
        }
        
    }
    
    public DetalleDistribVO() {
        
    }

    public void setDdiCodigo(Long ddiCodigo) {
        this.ddiCodigo = ddiCodigo;
    }

    public Long getDdiCodigo() {
        return ddiCodigo;
    }

    public void setDdiValorDetod(BigDecimal ddiValorDetod) {
        this.ddiValorDetod = ddiValorDetod;
    }

    public BigDecimal getDdiValorDetod() {
        return ddiValorDetod;
    }

    public void setDdiValorProp(BigDecimal ddiValorProp) {
        this.ddiValorProp = ddiValorProp;
    }

    public BigDecimal getDdiValorProp() {
        return ddiValorProp;
    }

    public void setDdiValorRec(BigDecimal ddiValorRec) {
        this.ddiValorRec = ddiValorRec;
    }

    public BigDecimal getDdiValorRec() {
        return ddiValorRec;
    }

    public void setDdiValorTodos(BigDecimal ddiValorTodos) {
        this.ddiValorTodos = ddiValorTodos;
    }

    public BigDecimal getDdiValorTodos() {
        return ddiValorTodos;
    }

    public void setDistribucionMesVo(DistribucionMesVO distribucionMesVo) {
        this.distribucionMesVo = distribucionMesVo;
    }

    public DistribucionMesVO getDistribucionMesVo() {
        return distribucionMesVo;
    }

    public void setEnteTerritorialVo(EnteTerritorialVO enteTerritorialVo) {
        this.enteTerritorialVo = enteTerritorialVo;
    }

    public EnteTerritorialVO getEnteTerritorialVo() {
        return enteTerritorialVo;
    }   

    public void setObligacionVoList(List<ObligacionVO> obligacionVoList) {
        this.obligacionVoList = obligacionVoList;
    }

    public List<ObligacionVO> getObligacionVoList() {
        return obligacionVoList;
    }

    public void setDdiEsInteres(String ddiEsInteres) {
        this.ddiEsInteres = ddiEsInteres;
    }

    public String getDdiEsInteres() {
        return ddiEsInteres;
    }


    public void setCategoriaDistribVo(CategoriaDistribVO categoriaDistribVo) {
        this.categoriaDistribVo = categoriaDistribVo;
    }

    public CategoriaDistribVO getCategoriaDistribVo() {
        return categoriaDistribVo;
    }

    public void setDdiPorcentParticip(BigDecimal ddiPorcentParticip) {
        this.ddiPorcentParticip = ddiPorcentParticip;
    }

    public BigDecimal getDdiPorcentParticip() {
        return ddiPorcentParticip;
    }

    public void setDdiSubtotalTranf(BigDecimal ddiSubtotalTranf) {
        this.ddiSubtotalTranf = ddiSubtotalTranf;
    }

    public BigDecimal getDdiSubtotalTranf() {
        return ddiSubtotalTranf;
    }

    public void setDdiValColciencias(BigDecimal ddiValColciencias) {
        this.ddiValColciencias = ddiValColciencias;
    }

    public BigDecimal getDdiValColciencias() {
        return ddiValColciencias;
    }

    public void setDdiValRendimFinanc(BigDecimal ddiValRendimFinanc) {
        this.ddiValRendimFinanc = ddiValRendimFinanc;
    }

    public BigDecimal getDdiValRendimFinanc() {
        return ddiValRendimFinanc;
    }

    public void setDdiValTotMunicipios(BigDecimal ddiValTotMunicipios) {
        this.ddiValTotMunicipios = ddiValTotMunicipios;
    }

    public BigDecimal getDdiValTotMunicipios() {
        return ddiValTotMunicipios;
    }

    public void setDdiValTotSaypFosiga(BigDecimal ddiValTotSaypFosiga) {
        this.ddiValTotSaypFosiga = ddiValTotSaypFosiga;
    }

    public BigDecimal getDdiValTotSaypFosiga() {
        return ddiValTotSaypFosiga;
    }

    public void setDdiValTotalControl(BigDecimal ddiValTotalControl) {
        this.ddiValTotalControl = ddiValTotalControl;
    }

    public BigDecimal getDdiValTotalControl() {
        return ddiValTotalControl;
    }

    public void setDdiValTotalTranfer(BigDecimal ddiValTotalTranfer) {
        this.ddiValTotalTranfer = ddiValTotalTranfer;
    }

    public BigDecimal getDdiValTotalTranfer() {
        return ddiValTotalTranfer;
    }
}
