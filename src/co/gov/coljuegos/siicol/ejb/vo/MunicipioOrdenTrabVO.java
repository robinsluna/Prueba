package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicipioOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenTrabajoVisita;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;

import java.util.List;

/**
 * Value Object encargado de gestionar los municipios de una orden de trabajo
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class MunicipioOrdenTrabVO {
    private String motActivo;
    private Long motCodigo;
    private UbicacionVO ubicacionMunicipioVO;
    private OrdenTrabajoVisitaVO ordenTrabajoVisitaVO;
    private List<MunicOrdTraInfVerifVO> listMunicOrdTraInfVerifVo;
   

    /**
     * Constructor.
     */
    public MunicipioOrdenTrabVO() {
        super();
    }
    /**
     *Constructor.
     * @param siiMunicipioOrdenTrab
     */
    public MunicipioOrdenTrabVO(SiiMunicipioOrdenTrab siiMunicipioOrdenTrab) {
        this.motActivo = siiMunicipioOrdenTrab.getMotActivo();
        this.motCodigo = siiMunicipioOrdenTrab.getMotCodigo();
        
        if (siiMunicipioOrdenTrab.getSiiUbicacionMunicipio()!=null)
            this.ubicacionMunicipioVO = new UbicacionVO(siiMunicipioOrdenTrab.getSiiUbicacionMunicipio());
        
        if (siiMunicipioOrdenTrab.getSiiOrdenTrabajoVisita()!=null)
            this.ordenTrabajoVisitaVO = new OrdenTrabajoVisitaVO(siiMunicipioOrdenTrab.getSiiOrdenTrabajoVisita());

    }

    public String getMotActivo() {
        return motActivo;
    }

    public Long getMotCodigo() {
        return motCodigo;
    }

    public UbicacionVO getUbicacionMunicipioVO() {
        return ubicacionMunicipioVO;
    }

    public OrdenTrabajoVisitaVO getOrdenTrabajoVisitaVO() {
        return ordenTrabajoVisitaVO;
    }

    public void setMotActivo(String motActivo) {
        this.motActivo = motActivo;
    }

    public void setMotCodigo(Long motCodigo) {
        this.motCodigo = motCodigo;
    }

    public void setUbicacionMunicipioVO(UbicacionVO ubicacionMunicipioVO) {
        this.ubicacionMunicipioVO = ubicacionMunicipioVO;
    }

    public void setOrdenTrabajoVisitaVO(OrdenTrabajoVisitaVO ordenTrabajoVisitaVO) {
        this.ordenTrabajoVisitaVO = ordenTrabajoVisitaVO;
    }

    public void setListMunicOrdTraInfVerifVo(List<MunicOrdTraInfVerifVO> listMunicOrdTraInfVerifVo){
        this.listMunicOrdTraInfVerifVo = listMunicOrdTraInfVerifVo;
    }

    public List<MunicOrdTraInfVerifVO> getListMunicOrdTraInfVerifVo(){
        return listMunicOrdTraInfVerifVo;
    }
    
    
}
