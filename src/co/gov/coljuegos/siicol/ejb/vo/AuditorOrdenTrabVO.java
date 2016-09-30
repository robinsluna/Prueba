package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAuditorOrdenTrab;

/**
 * Value Object encargado de gestionar los auditores de la orden de trabajo
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class AuditorOrdenTrabVO {
    
    private String aotActivo;
    private Long aotCodigo;
    private SustanciadorAuditorVO sustanciadorAuditorVO;
    private OrdenTrabajoVisitaVO ordenTrabajoVisitaVO;

    /**
     * Constructor
     */
    public AuditorOrdenTrabVO() {
        super();
    }
    
    /**
     *Constructor
     * @param siiAuditorOrdenTrab
     */
    public AuditorOrdenTrabVO(SiiAuditorOrdenTrab siiAuditorOrdenTrab) {
        this.aotActivo = siiAuditorOrdenTrab.getAotActivo();
        this.aotCodigo = siiAuditorOrdenTrab.getAotCodigo();
        
        if (siiAuditorOrdenTrab.getSiiSustanciadorAuditor() != null)
            this.sustanciadorAuditorVO = new SustanciadorAuditorVO(siiAuditorOrdenTrab.getSiiSustanciadorAuditor());
        
        if(siiAuditorOrdenTrab.getSiiOrdenTrabajoVisita() != null)
            this.ordenTrabajoVisitaVO = new OrdenTrabajoVisitaVO(siiAuditorOrdenTrab.getSiiOrdenTrabajoVisita());
    }

    public String getAotActivo() {
        return aotActivo;
    }

    public Long getAotCodigo() {
        return aotCodigo;
    }

    public SustanciadorAuditorVO getSustanciadorAuditorVO() {
        return sustanciadorAuditorVO;
    }

    public OrdenTrabajoVisitaVO getOrdenTrabajoVisitaVO() {
        return ordenTrabajoVisitaVO;
    }

    public void setAotActivo(String aotActivo) {
        this.aotActivo = aotActivo;
    }

    public void setAotCodigo(Long aotCodigo) {
        this.aotCodigo = aotCodigo;
    }

    public void setSustanciadorAuditorVO(SustanciadorAuditorVO sustanciadorAuditorVO) {
        this.sustanciadorAuditorVO = sustanciadorAuditorVO;
    }

    public void setOrdenTrabajoVisitaVO(OrdenTrabajoVisitaVO ordenTrabajoVisitaVO) {
        this.ordenTrabajoVisitaVO = ordenTrabajoVisitaVO;
    }

}
