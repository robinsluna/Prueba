package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionPersona;

public class DireccionPersonaVO {
    private Long dpeCodigo;
    private PersonaVO personaVo;
    private DireccionVO direccionVo;
    private UsuarioVO usuarioConecVo;
    private UbicacionVO ubicacionMunicipioVo;
    
    public DireccionPersonaVO(){
        
    }
    
    public DireccionPersonaVO(SiiDireccionPersona direccionPersona) {
        this.dpeCodigo = direccionPersona.getDpeCodigo();
        //Padres
        if(direccionPersona.getSiiDireccion()!=null) {
            this.direccionVo = new DireccionVO(direccionPersona.getSiiDireccion());
        }
        if (direccionPersona.getSiiPersona()!=null) {
            this.personaVo = new PersonaVO(direccionPersona.getSiiPersona());
        }
        if (direccionPersona.getSiiUbicacionMunicipio()!=null) {
            this.ubicacionMunicipioVo = new UbicacionVO(direccionPersona.getSiiUbicacionMunicipio());
        }
        if (direccionPersona.getSiiUsuarioConec()!=null) {
            this.usuarioConecVo = new UsuarioVO(direccionPersona.getSiiUsuarioConec());
        }
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof DireccionPersonaVO)) {
            return false;
        }
        final DireccionPersonaVO other = (DireccionPersonaVO) object;
        if(!(dpeCodigo == null ? other.dpeCodigo == null : dpeCodigo.equals(other.dpeCodigo))) {
            return false;
        }
        if(!(personaVo == null ? other.personaVo == null : personaVo.equals(other.personaVo))) {
            return false;
        }
        if(!(direccionVo == null ? other.direccionVo == null : direccionVo.equals(other.direccionVo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((dpeCodigo == null) ? 0 : dpeCodigo.hashCode());
        result = PRIME * result + ((personaVo == null) ? 0 : personaVo.hashCode());
        result = PRIME * result + ((direccionVo == null) ? 0 : direccionVo.hashCode());
        return result;
    }

    public void setDpeCodigo(Long dpeCodigo) {
        this.dpeCodigo = dpeCodigo;
    }

    public Long getDpeCodigo() {
        return dpeCodigo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setDireccionVo(DireccionVO direccionVo) {
        this.direccionVo = direccionVo;
    }

    public DireccionVO getDireccionVo() {
        return direccionVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setUbicacionMunicipioVo(UbicacionVO ubicacionMunicipioVo) {
        this.ubicacionMunicipioVo = ubicacionMunicipioVo;
    }

    public UbicacionVO getUbicacionMunicipioVo() {
        return ubicacionMunicipioVo;
    }
}
