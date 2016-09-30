package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonalEmpresa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPersonal;

import java.util.Date;

public class PersonalEmpresaVO {
    
    private String pemActivo;
    private Long pemCodigo;
    private Date pemFechaRegistro;
    private Date pemFechaInactivac;
    private TipoPersonalVO tipoPersonalVo;
    private PersonaVO personaEmpresaVo; //Empresa
    private PersonaVO personaVo; //contacto
    
    
    public PersonalEmpresaVO(SiiPersonalEmpresa siiPersonalEmpresa) {
        this.pemActivo = siiPersonalEmpresa.getPemActivo();
        this.pemCodigo = siiPersonalEmpresa.getPemCodigo();
        this.pemFechaRegistro = siiPersonalEmpresa.getPemFechaRegistro();
        this.pemFechaInactivac = siiPersonalEmpresa.getPemFechaInactivac();
        //Padres:
        if(siiPersonalEmpresa.getSiiTipoPersonal() != null){
            this.tipoPersonalVo = new TipoPersonalVO(siiPersonalEmpresa.getSiiTipoPersonal());
        }
        if(siiPersonalEmpresa.getSiiPersona() != null){
            this.personaEmpresaVo = new PersonaVO(siiPersonalEmpresa.getSiiPersona());
        }
        if(siiPersonalEmpresa.getSiiPersona3() != null){
            this.personaVo = new PersonaVO(siiPersonalEmpresa.getSiiPersona3());
        }
    }
    
    public PersonalEmpresaVO() {
    }

    public void setPemFechaInactivac(Date pemFechaInactivac) {
        this.pemFechaInactivac = pemFechaInactivac;
    }

    public Date getPemFechaInactivac() {
        return pemFechaInactivac;
    }

    public void setPemActivo(String pemActivo) {
        this.pemActivo = pemActivo;
    }

    public String getPemActivo() {
        return pemActivo;
    }

    public void setPemCodigo(Long pemCodigo) {
        this.pemCodigo = pemCodigo;
    }

    public Long getPemCodigo() {
        return pemCodigo;
    }

    public void setPemFechaRegistro(Date pemFechaRegistro) {
        this.pemFechaRegistro = pemFechaRegistro;
    }

    public Date getPemFechaRegistro() {
        return pemFechaRegistro;
    }

    public void setTipoPersonalVo(TipoPersonalVO tipoPersonalVo) {
        this.tipoPersonalVo = tipoPersonalVo;
    }

    public TipoPersonalVO getTipoPersonalVo() {
        return tipoPersonalVo;
    }

    public void setPersonaEmpresaVo(PersonaVO personaEmpresaVo) {
        this.personaEmpresaVo = personaEmpresaVo;
    }

    public PersonaVO getPersonaEmpresaVo() {
        return personaEmpresaVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }
}
