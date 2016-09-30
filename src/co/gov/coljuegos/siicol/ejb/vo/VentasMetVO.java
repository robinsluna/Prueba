package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificaVentasMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReporteVentas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiVentasMet;

import java.math.BigDecimal;

import java.util.List;

/**
 * author Modifica Giovanni
 */
public class VentasMetVO {    
    
    private Long vmeCodigo;
    private Integer vmeDiasRepor;
    private BigDecimal vmeValorCorrec;
    private BigDecimal vmeValorInicial;
    private BigDecimal vmeValorModif;
    private Integer vmeVigencia;
    private ReporteVentasVO reporteVentasVo;
    private InventarioVO inventarioVo;
    private MetVO metVo;
    private MesVO mesVo;
    private List<ModificaVentasMetVO> modificaVentasMetListVo;
    
    
    
    public VentasMetVO(SiiVentasMet siiVentasMet) {        
        this.vmeCodigo = siiVentasMet.getVmeCodigo();
        this.vmeDiasRepor = siiVentasMet.getVmeDiasRepor();
        this.vmeValorCorrec = siiVentasMet.getVmeValorCorrec();
        this.vmeValorInicial = siiVentasMet.getVmeValorInicial();
        this.vmeValorModif = siiVentasMet.getVmeValorModif();
        this.vmeVigencia = siiVentasMet.getVmeVigencia();
        
        if(siiVentasMet.getSiiReporteVentas()!= null){
            this.reporteVentasVo = new ReporteVentasVO (siiVentasMet.getSiiReporteVentas());
        }
        if(siiVentasMet.getSiiInventario()!= null){
            this.inventarioVo = new InventarioVO(siiVentasMet.getSiiInventario());
        }
        
        if(siiVentasMet.getSiiMet()!= null){
            this.metVo = new MetVO(siiVentasMet.getSiiMet());
        }
        
       
    }
    
    public VentasMetVO() {        
    }
  

    public void setVmeCodigo(Long vmeCodigo) {
        this.vmeCodigo = vmeCodigo;
    }

    public Long getVmeCodigo() {
        return vmeCodigo;
    }

    public void setVmeDiasRepor(Integer vmeDiasRepor) {
        this.vmeDiasRepor = vmeDiasRepor;
    }

    public Integer getVmeDiasRepor() {
        return vmeDiasRepor;
    }

    public void setVmeValorCorrec(BigDecimal vmeValorCorrec) {
        this.vmeValorCorrec = vmeValorCorrec;
    }

    public BigDecimal getVmeValorCorrec() {
        return vmeValorCorrec;
    }

    public void setVmeValorInicial(BigDecimal vmeValorInicial) {
        this.vmeValorInicial = vmeValorInicial;
    }

    public BigDecimal getVmeValorInicial() {
        return vmeValorInicial;
    }

    public void setVmeValorModif(BigDecimal vmeValorModif) {
        this.vmeValorModif = vmeValorModif;
    }

    public BigDecimal getVmeValorModif() {
        return vmeValorModif;
    }

    public void setVmeVigencia(Integer vmeVigencia) {
        this.vmeVigencia = vmeVigencia;
    }

    public Integer getVmeVigencia() {
        return vmeVigencia;
    }

    public void setReporteVentasVo(ReporteVentasVO reporteVentasVo) {
        this.reporteVentasVo = reporteVentasVo;
    }

    public ReporteVentasVO getReporteVentasVo() {
        return reporteVentasVo;
    }

    public void setInventarioVo(InventarioVO inventarioVo) {
        this.inventarioVo = inventarioVo;
    }

    public InventarioVO getInventarioVo() {
        return inventarioVo;
    }

    public void setMetVo(MetVO metVo) {
        this.metVo = metVo;
    }

    public MetVO getMetVo() {
        return metVo;
    }

    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setModificaVentasMetListVo(List<ModificaVentasMetVO> modificaVentasMetListVo) {
        this.modificaVentasMetListVo = modificaVentasMetListVo;
    }

    public List<ModificaVentasMetVO> getModificaVentasMetListVo() {
        return modificaVentasMetListVo;
    }
}
