package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionCdp;

import java.util.Date;
import java.util.List;


public class ModificacionCdpVO implements Comparable<ModificacionCdpVO> {
    private Long mcdCodigo;
    private Date mcdFechaSolic;
    private Long mcdNumero;
    private String mcdTipoMod;
    private EstadoModifCdpVO estadoModifCdpVo;
    private List<ModifCdpDetRubCdpVO> modifCdpDetRubCdpVoList;
    private CdpVO cdpVo;
    private ArchivoFisicoVO archivoFisicoVo;
    private Long idEstadoAnterior;
    

    
    public ModificacionCdpVO(SiiModificacionCdp siiModificacionCdp) {
        this.mcdCodigo = siiModificacionCdp.getMcdCodigo();
        this.mcdFechaSolic = siiModificacionCdp.getMcdFechaSolic();
        this.mcdNumero = siiModificacionCdp.getMcdNumero();
        this.mcdTipoMod = siiModificacionCdp.getMcdTipoMod();
        //Padres:
        if (siiModificacionCdp.getSiiEstadoModifCdp() != null ) {
            this.estadoModifCdpVo = new EstadoModifCdpVO(siiModificacionCdp.getSiiEstadoModifCdp());
            this.idEstadoAnterior = siiModificacionCdp.getSiiEstadoModifCdp().getEmcCodigo();
        }
        
        if (siiModificacionCdp.getSiiCdp() != null ) {
            this.cdpVo = new CdpVO(siiModificacionCdp.getSiiCdp());
        }
        
        if (siiModificacionCdp.getSiiArchivoFisico() != null) {
            this.archivoFisicoVo = new ArchivoFisicoVO(siiModificacionCdp.getSiiArchivoFisico());
        }
                
    }

    public ModificacionCdpVO() {
    }


    public void setMcdCodigo(Long mcdCodigo) {
        this.mcdCodigo = mcdCodigo;
    }

    public Long getMcdCodigo() {
        return mcdCodigo;
    }

    public void setMcdTipoMod(String mcdTipoMod) {
        this.mcdTipoMod = mcdTipoMod;
    }

    public String getMcdTipoMod() {
        return mcdTipoMod;
    }

    public void setEstadoModifCdpVo(EstadoModifCdpVO estadoModifCdpVo) {
        this.estadoModifCdpVo = estadoModifCdpVo;
    }

    public EstadoModifCdpVO getEstadoModifCdpVo() {
        return estadoModifCdpVo;
    }

    public void setCdpVo(CdpVO cdpVo) {
        this.cdpVo = cdpVo;
    }

    public CdpVO getCdpVo() {
        return cdpVo;
    }

    public void setModifCdpDetRubCdpVoList(List<ModifCdpDetRubCdpVO> modifCdpDetRubCdpVoList) {
        this.modifCdpDetRubCdpVoList = modifCdpDetRubCdpVoList;
    }

    public List<ModifCdpDetRubCdpVO> getModifCdpDetRubCdpVoList() {
        return modifCdpDetRubCdpVoList;
    }

    public void setMcdFechaSolic(Date mcdFechaSolic) {
        this.mcdFechaSolic = mcdFechaSolic;
    }

    public Date getMcdFechaSolic() {
        return mcdFechaSolic;
    }

    public void setMcdNumero(Long mcdNumero) {
        this.mcdNumero = mcdNumero;
    }

    public Long getMcdNumero() {
        return mcdNumero;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }
    
    public int compareTo(ModificacionCdpVO compareModificacionCdpVo) {


        //descending order
        if (compareModificacionCdpVo.getMcdNumero() != null && this.mcdNumero != null)
            return compareModificacionCdpVo.getMcdNumero().compareTo(this.mcdNumero);
        else if (compareModificacionCdpVo.getMcdNumero() != null)
            return 1;
        else if (this.mcdNumero != null)
            return -1;
        else
            return 0;

    }

}
