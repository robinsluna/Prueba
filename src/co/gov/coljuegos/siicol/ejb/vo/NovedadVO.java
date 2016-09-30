/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y Transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 29-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOtrosi;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoNovedad;

import java.util.Date;
import java.util.List;

public class NovedadVO {

    private Long novCodigo;
    private Date novFecha;;
    private ContratoVO contratoVO;
    private TipoNovedadVO tipoNovedad;
    private OtroSiVO otroSiVo;
    private List<InventarioVO> inventarioVoList;    
    private SolicitudAutorizaVO solicitudAutorizaVO;  

    
    public NovedadVO(SiiNovedad siiNovedad){
        this.novCodigo = siiNovedad.getNovCodigo();
        this.novFecha = siiNovedad.getNovFecha();
        //Padres:
        if(siiNovedad.getSiiContrato() != null){
            this.contratoVO = new ContratoVO (siiNovedad.getSiiContrato());
        }
        if(siiNovedad.getSiiTipoNovedad()!= null){
            this.tipoNovedad = new TipoNovedadVO(siiNovedad.getSiiTipoNovedad());
        }
        if (siiNovedad.getSiiSolicitudAutoriza() != null) {
            this.solicitudAutorizaVO = new SolicitudAutorizaVO(siiNovedad.getSiiSolicitudAutoriza());
        }
        if (siiNovedad.getSiiOtrosi() != null) {
            this.otroSiVo = new OtroSiVO(siiNovedad.getSiiOtrosi());
        }
    }
    
    public NovedadVO() {
    }

    public void setNovCodigo(Long novCodigo) {
        this.novCodigo = novCodigo;
    }

    public Long getNovCodigo() {
        return novCodigo;
    }

    public void setNovFecha(Date novFecha) {
        this.novFecha = novFecha;
    }

    public Date getNovFecha() {
        return novFecha;
    }


    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    public void setTipoNovedad(TipoNovedadVO tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
    }

    public TipoNovedadVO getTipoNovedad() {
        return tipoNovedad;
    }

    public void setInventarioVoList(List<InventarioVO> inventarioVoList) {
        this.inventarioVoList = inventarioVoList;
    }

    public List<InventarioVO> getInventarioVoList() {
        return inventarioVoList;
    }

    public void setSolicitudAutorizaVO(SolicitudAutorizaVO solicitudAutorizaVO) {
        this.solicitudAutorizaVO = solicitudAutorizaVO;
    }

    public SolicitudAutorizaVO getSolicitudAutorizaVO() {
        return solicitudAutorizaVO;
    }
    public void setOtroSiVo(OtroSiVO otroSiVo) {
        this.otroSiVo = otroSiVo;
    }

    public OtroSiVO getOtroSiVo() {
        return otroSiVo;
    }

}
