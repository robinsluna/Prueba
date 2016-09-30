package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenunciaOrdenTrab;

import java.util.List;

/**
 * Value Objecto para gestionar las denuncias con sus órdenes de trabajo de visita.
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class DenunciaOrdenTrabVO {
    
    private String dotActivo;
    private Long dotCodigo;
    private OrdenTrabajoVisitaVO ordenTrabajoVisitaVO;
    private DenunciaVO denunciaVO;
    
    //datos para grilla
    private List<DenuncOrdTraInfVerVO> ListDenuncOrdTraInfVerVo;
    
    /**
     * Constructor.
     */
 

    public DenunciaOrdenTrabVO() {
        super();
    }
    
    /**
     * Constructor
     * @param denunciaVo
     */
    
    public DenunciaOrdenTrabVO(DenunciaVO denunciaVo) {
        this.setDenunciaVO(denunciaVo);
    }
    
    /**
     * Constructor
     * @param siiDenunciaOrdenTrab
     */
    public DenunciaOrdenTrabVO(SiiDenunciaOrdenTrab siiDenunciaOrdenTrab) {
        super();
        this.dotActivo = siiDenunciaOrdenTrab.getDotActivo();
        this.dotCodigo = siiDenunciaOrdenTrab.getDotCodigo();
        
        if (siiDenunciaOrdenTrab.getSiiOrdenTrabajoVisita()!=null)
            this.ordenTrabajoVisitaVO = new OrdenTrabajoVisitaVO(siiDenunciaOrdenTrab.getSiiOrdenTrabajoVisita());
        
        if (siiDenunciaOrdenTrab.getSiiDenuncia()!=null)
            this.denunciaVO = new DenunciaVO(siiDenunciaOrdenTrab.getSiiDenuncia());
    }

    public String getDotActivo() {
        return dotActivo;
    }

    public Long getDotCodigo() {
        return dotCodigo;
    }

    public OrdenTrabajoVisitaVO getOrdenTrabajoVisitaVO() {
        return ordenTrabajoVisitaVO;
    }

    public DenunciaVO getDenunciaVO() {
        return denunciaVO;
    }

    public void setDotActivo(String dotActivo) {
        this.dotActivo = dotActivo;
    }

    public void setDotCodigo(Long dotCodigo) {
        this.dotCodigo = dotCodigo;
    }

    public void setOrdenTrabajoVisitaVO(OrdenTrabajoVisitaVO ordenTrabajoVisitaVO) {
        this.ordenTrabajoVisitaVO = ordenTrabajoVisitaVO;
    }

    public void setDenunciaVO(DenunciaVO denunciaVO) {
        this.denunciaVO = denunciaVO;
    }


    public void setListDenuncOrdTraInfVerVo(List<DenuncOrdTraInfVerVO> ListDenuncOrdTraInfVerVo){
        this.ListDenuncOrdTraInfVerVo = ListDenuncOrdTraInfVerVo;
    }

    public List<DenuncOrdTraInfVerVO> getListDenuncOrdTraInfVerVo(){
        return ListDenuncOrdTraInfVerVo;
    }
}
