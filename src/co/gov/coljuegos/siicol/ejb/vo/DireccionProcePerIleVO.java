package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionProcePerIle;

public class DireccionProcePerIleVO {
    private Long dipCodigo;
    private UbicacionVO ubicacionVo;
    private PersonaInvestProIleVO personaInvestProIleVo;
    private DireccionVO direccionVo;
    private UsuarioVO usuarioConecVo;

    public DireccionProcePerIleVO() {
        
    }
    public DireccionProcePerIleVO(SiiDireccionProcePerIle direccionProcePerIle){
        this.dipCodigo = direccionProcePerIle.getDipCodigo();
        //Padres
        if(direccionProcePerIle.getSiiDireccion() != null) {
            this.direccionVo = new DireccionVO(direccionProcePerIle.getSiiDireccion());
        }
        if (direccionProcePerIle.getSiiPersonaInvestProIle()!=null){
            this.personaInvestProIleVo = new PersonaInvestProIleVO(direccionProcePerIle.getSiiPersonaInvestProIle());
        }
        if (direccionProcePerIle.getSiiUbicacion()!=null) {
            this.ubicacionVo = new UbicacionVO(direccionProcePerIle.getSiiUbicacion());
        }
        if (direccionProcePerIle.getSiiUsuarioConec()!=null) {
            this.usuarioConecVo = new UsuarioVO(direccionProcePerIle.getSiiUsuarioConec());
        }
    }

    public void setDipCodigo(Long dipCodigo) {
        this.dipCodigo = dipCodigo;
    }

    public Long getDipCodigo() {
        return dipCodigo;
    }

    public void setUbicacionVo(UbicacionVO ubicacionVo) {
        this.ubicacionVo = ubicacionVo;
    }

    public UbicacionVO getUbicacionVo() {
        return ubicacionVo;
    }

    public void setPersonaInvestProIleVo(PersonaInvestProIleVO personaInvestProIleVo) {
        this.personaInvestProIleVo = personaInvestProIleVo;
    }

    public PersonaInvestProIleVO getPersonaInvestProIleVo() {
        return personaInvestProIleVo;
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
}
