package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecSuspension;

public class EstablecSuspensionVO {
    private Long esuCodigo;
    private SuspensionContrVO suspensionContrVo;
    private EstablecimientoVO establecimientoVo;

    public EstablecSuspensionVO(){
        
    }
    public EstablecSuspensionVO(SiiEstablecSuspension establecimietoSuspension) {
        this.esuCodigo = establecimietoSuspension.getEsuCodigo();
        //Padres:
        if (establecimietoSuspension.getSiiEstablecimiento()!=null) {
            this.establecimientoVo = new EstablecimientoVO(establecimietoSuspension.getSiiEstablecimiento());
        }
        if (establecimietoSuspension.getSiiSuspensionContr()!=null) {
            this.suspensionContrVo = new SuspensionContrVO(establecimietoSuspension.getSiiSuspensionContr());
        }
        
    }

    public void setEsuCodigo(Long esuCodigo) {
        this.esuCodigo = esuCodigo;
    }

    public Long getEsuCodigo() {
        return esuCodigo;
    }

    public void setSuspensionContrVo(SuspensionContrVO suspensionContrVo) {
        this.suspensionContrVo = suspensionContrVo;
    }

    public SuspensionContrVO getSuspensionContrVo() {
        return suspensionContrVo;
    }

    public void setEstablecimientoVo(EstablecimientoVO establecimientoVo) {
        this.establecimientoVo = establecimientoVo;
    }

    public EstablecimientoVO getEstablecimientoVo() {
        return establecimientoVo;
    }

}
