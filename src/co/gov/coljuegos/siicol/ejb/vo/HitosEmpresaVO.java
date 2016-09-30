package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHitosEmpresa;

import java.util.Date;

/**
 * VO Hitos Empresa
 * author Giovanni
 */
public class HitosEmpresaVO {

    private Long hemCodigo;
    private String hemConsideraciones;
    private PersonaVO personaVO;
    private Date hemFecha;

    public HitosEmpresaVO() {
        personaVO = new PersonaVO();
    }

    public HitosEmpresaVO(SiiHitosEmpresa siiHitosEmpresa) {
        this.hemCodigo = siiHitosEmpresa.getHemCodigo();
        this.hemConsideraciones = siiHitosEmpresa.getHemConsideraciones();
        this.hemFecha = siiHitosEmpresa.getHemFecha();

        //Persona
        if (siiHitosEmpresa.getSiiPersona() != null && siiHitosEmpresa.getSiiPersona().getPerCodigo() != null &&
            siiHitosEmpresa.getSiiPersona().getPerCodigo() > 0) {
            this.personaVO = new PersonaVO();
            this.personaVO.setPerCodigo(siiHitosEmpresa.getSiiPersona().getPerCodigo());
        }
    }

    public Long getHemCodigo() {
        return hemCodigo;
    }

    public void setHemCodigo(Long hemCodigo) {
        this.hemCodigo = hemCodigo;
    }

    public String getHemConsideraciones() {
        return hemConsideraciones;
    }

    public void setHemConsideraciones(String hemConsideraciones) {
        this.hemConsideraciones = hemConsideraciones;
    }

    public PersonaVO getPersonaVO() {
        return personaVO;
    }

    public void setPersonaVO(PersonaVO personaVO) {
        this.personaVO = personaVO;
    }

    public Date getHemFecha() {
        return hemFecha;
    }

    public void setHemFecha(Date hemFecha) {
        this.hemFecha = hemFecha;
    }
}
