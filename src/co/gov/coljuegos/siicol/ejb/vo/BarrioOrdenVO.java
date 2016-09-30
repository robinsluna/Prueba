package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrden;

import java.util.ArrayList;
import java.util.List;

/**
 * Value Object que gestiona los barrios de las órdenes de trabajo de visita
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class BarrioOrdenVO {
    private String borActivo;
    private Long borCodigo;
    private String borNombre;
    private UbicacionVO ubicacionMunicipioVO;
    private OrdenTrabajoVisitaVO ordenTrabajoVisitaVO;
    //Datos para grilla
    private List<BarrioOrdenInfVerVO> listBarrioOrdenInfVerVo;
    private List<DenuncOrdTraInfVerVO> listDenuncOrdTraInfVerVo;

    /**
     * Constructor.
     */
    public BarrioOrdenVO() {
        super();
        listBarrioOrdenInfVerVo = new ArrayList();
    }

    /**
     * Constructor.
     * @param siiBarrioOrden
     */
    public BarrioOrdenVO(SiiBarrioOrden siiBarrioOrden) {
        super();
        this.borActivo = siiBarrioOrden.getBorActivo();
        this.borCodigo = siiBarrioOrden.getBorCodigo();
        this.borNombre = siiBarrioOrden.getBorNombre();
        
        if (siiBarrioOrden.getSiiUbicacionMunicipio()!=null)
            this.ubicacionMunicipioVO = new UbicacionVO(siiBarrioOrden.getSiiUbicacionMunicipio());
        
        if (siiBarrioOrden.getSiiOrdenTrabajoVisita()!=null)
            this.ordenTrabajoVisitaVO = new OrdenTrabajoVisitaVO(siiBarrioOrden.getSiiOrdenTrabajoVisita());
        
    }

    public String getBorActivo() {
        return borActivo;
    }

    public Long getBorCodigo() {
        return borCodigo;
    }

    public String getBorNombre() {
        return borNombre;
    }

    public UbicacionVO getUbicacionMunicipioVO() {
        return ubicacionMunicipioVO;
    }

    public OrdenTrabajoVisitaVO getOrdenTrabajoVisitaVO() {
        return ordenTrabajoVisitaVO;
    }

    public void setBorActivo(String borActivo) {
        this.borActivo = borActivo;
    }

    public void setBorCodigo(Long borCodigo) {
        this.borCodigo = borCodigo;
    }

    public void setBorNombre(String borNombre) {
        this.borNombre = borNombre;
    }

    public void setUbicacionMunicipioVO(UbicacionVO ubicacionMunicipioVO) {
        this.ubicacionMunicipioVO = ubicacionMunicipioVO;
    }

    public void setOrdenTrabajoVisitaVO(OrdenTrabajoVisitaVO ordenTrabajoVisitaVO) {
        this.ordenTrabajoVisitaVO = ordenTrabajoVisitaVO;
    }

    public void setListBarrioOrdenInfVerVo(List<BarrioOrdenInfVerVO> listBarrioOrdenInfVerVo){
        this.listBarrioOrdenInfVerVo = listBarrioOrdenInfVerVo;
    }

    public List<BarrioOrdenInfVerVO> getListBarrioOrdenInfVerVo(){
        return listBarrioOrdenInfVerVo;
    }

    public void setListDenuncOrdTraInfVerVo(List<DenuncOrdTraInfVerVO> listDenuncOrdTraInfVerVo){
        this.listDenuncOrdTraInfVerVo = listDenuncOrdTraInfVerVo;
    }

    public List<DenuncOrdTraInfVerVO> getListDenuncOrdTraInfVerVo(){
        return listDenuncOrdTraInfVerVo;
    }
}
