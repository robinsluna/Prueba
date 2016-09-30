package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoIncumplContract;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiIncumplimientoContr;

import java.util.List;

public class EstadoIncumplContractVO {
    private Long eicCodigo;
    private String eicNombre;
    private List<SiiIncumplimientoContr> siiIncumplimientoContrList;

    public EstadoIncumplContractVO(){
        
    }
    public EstadoIncumplContractVO(SiiEstadoIncumplContract siiEstadoIncumplContract){
        this.eicCodigo = siiEstadoIncumplContract.getEicCodigo();
        this.eicNombre = siiEstadoIncumplContract.getEicNombre();
    }

    public void setEicCodigo(Long eicCodigo) {
        this.eicCodigo = eicCodigo;
    }

    public Long getEicCodigo() {
        return eicCodigo;
    }

    public void setEicNombre(String eicNombre) {
        this.eicNombre = eicNombre;
    }

    public String getEicNombre() {
        return eicNombre;
    }

    public void setSiiIncumplimientoContrList(List<SiiIncumplimientoContr> siiIncumplimientoContrList) {
        this.siiIncumplimientoContrList = siiIncumplimientoContrList;
    }

    public List<SiiIncumplimientoContr> getSiiIncumplimientoContrList() {
        return siiIncumplimientoContrList;
    }
}
