package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionPersonaAtien;

public class DireccionPersonaAtienVO {
    private String dpaActivo;
    private Long dpaCodigo;
    private String dpaDireccion;
    private UsuarioVO usuarioConectVo;
    private UbicacionVO ubicacionMunicVo;
    private PersonaAtiendeAccVO personaAtiendeAccVo;

    
    public DireccionPersonaAtienVO() {
        
    }
    
    public DireccionPersonaAtienVO(SiiDireccionPersonaAtien direccion) {
        this.dpaActivo = direccion.getDpaActivo();
        this.dpaCodigo = direccion.getDpaCodigo();
        this.dpaDireccion = direccion.getDpaDireccion();
        //Padres:
        this.personaAtiendeAccVo = direccion.getSiiPersonaAtiendeAcc()!=null ? new PersonaAtiendeAccVO(direccion.getSiiPersonaAtiendeAcc()) : new PersonaAtiendeAccVO();
        this.ubicacionMunicVo = direccion.getSiiUbicacionMunic() != null ? new UbicacionVO(direccion.getSiiUbicacionMunic()): new UbicacionVO();
        this.usuarioConectVo = direccion.getSiiUsuarioConect() != null ? new UsuarioVO(direccion.getSiiUsuarioConect()): new UsuarioVO();
    }

    public void setDpaActivo(String dpaActivo) {
        this.dpaActivo = dpaActivo;
    }

    public String getDpaActivo() {
        return dpaActivo;
    }

    public void setDpaCodigo(Long dpaCodigo) {
        this.dpaCodigo = dpaCodigo;
    }

    public Long getDpaCodigo() {
        return dpaCodigo;
    }

    public void setDpaDireccion(String dpaDireccion) {
        this.dpaDireccion = dpaDireccion;
    }

    public String getDpaDireccion() {
        return dpaDireccion;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }

    public void setUbicacionMunicVo(UbicacionVO ubicacionMunicVo) {
        this.ubicacionMunicVo = ubicacionMunicVo;
    }

    public UbicacionVO getUbicacionMunicVo() {
        return ubicacionMunicVo;
    }

    public void setPersonaAtiendeAccVo(PersonaAtiendeAccVO personaAtiendeAccVo) {
        this.personaAtiendeAccVo = personaAtiendeAccVo;
    }

    public PersonaAtiendeAccVO getPersonaAtiendeAccVo() {
        return personaAtiendeAccVo;
    }
}
