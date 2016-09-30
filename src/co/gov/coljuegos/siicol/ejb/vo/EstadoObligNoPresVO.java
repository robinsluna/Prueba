package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoObligNoPres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionNoPresup;

import java.util.List;

public class EstadoObligNoPresVO {
    private Long eonCodigo;
    private String eonNombre;
    private List<ObligacionNoPresupVO> obligacionNoPresupListVo;
   
    public EstadoObligNoPresVO(SiiEstadoObligNoPres siiEstadoObligNoPres) {
       this.eonCodigo = siiEstadoObligNoPres.getEonCodigo();
       this.eonNombre = siiEstadoObligNoPres.getEonNombre();
    }
    public EstadoObligNoPresVO() {
    }

    public void setEonCodigo(Long eonCodigo) {
        this.eonCodigo = eonCodigo;
    }

    public Long getEonCodigo() {
        return eonCodigo;
    }

    public void setEonNombre(String eonNombre) {
        this.eonNombre = eonNombre;
    }

    public String getEonNombre() {
        return eonNombre;
    }

    public void setObligacionNoPresupListVo(List<ObligacionNoPresupVO> obligacionNoPresupListVo) {
        this.obligacionNoPresupListVo = obligacionNoPresupListVo;
    }

    public List<ObligacionNoPresupVO> getObligacionNoPresupListVo() {
        return obligacionNoPresupListVo;
    }
}
