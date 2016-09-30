package co.gov.coljuegos.siicol.ejb.vo.siito;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedorTecn;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;

/**
 * VO proveedores de tecnologia 
 * author Giovanni  
 */
public class ProveedorTecnVO {
    
    private Long pteCodigo;
    private PersonaVO personaVO;
    
    public ProveedorTecnVO() {
        personaVO = new PersonaVO();
    }
    
    public ProveedorTecnVO(SiiProveedorTecn siiProveedorTecn) {
        this.pteCodigo = siiProveedorTecn.getPteCodigo();
        
        //Persona
        if (siiProveedorTecn.getSiiPersona() != null && siiProveedorTecn.getSiiPersona().getPerCodigo() > 0) {
            this.personaVO = new PersonaVO();
            this.personaVO.setPerCodigo(siiProveedorTecn.getSiiPersona().getPerCodigo());
        }
    }

    public Long getPteCodigo() {
        return pteCodigo;
    }

    public void setPteCodigo(Long pteCodigo) {
        this.pteCodigo = pteCodigo;
    }

    public PersonaVO getPersonaVO() {
        return personaVO;
    }

    public void setPersonaVO(PersonaVO personaVO) {
        this.personaVO = personaVO;
    }
}
