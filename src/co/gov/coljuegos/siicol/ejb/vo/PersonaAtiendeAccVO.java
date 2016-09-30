package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaAtiendeAcc;

import java.util.List;

public class PersonaAtiendeAccVO implements Cloneable {
    private String peaActivo;
    private Long peaCodigo;
    private String peaEmail;
    private String peaNumeroIden;
    private String peaPrimerApell;
    private String peaPrimerNombre;
    private String peaSegundoApell;
    private String peaSegundoNomb;
    private String peaTelefonos;
    private TipoIdentificacionVO tipoIdentificacionVo;
    private UsuarioVO usuarioConectVo;
    private AccionControlVO accionControlVo;
    private List<DireccionPersonaAtienVO> direccionPersonaAtienListVo;

    //Adicional a los de la entidad
    private List<TipoIdentificacionVO> tiposIdentificacionVo;

    public PersonaAtiendeAccVO() {

    }

    public PersonaAtiendeAccVO(SiiPersonaAtiendeAcc persona) {
        this.peaActivo = persona.getPeaActivo();
        this.peaCodigo = persona.getPeaCodigo();
        this.peaEmail = persona.getPeaEmail();
        this.peaNumeroIden = persona.getPeaNumeroIden();
        this.peaPrimerApell = persona.getPeaPrimerApell();
        this.peaPrimerNombre = persona.getPeaPrimerNombre();
        this.peaSegundoApell = persona.getPeaSegundoApell();
        this.peaSegundoNomb = persona.getPeaSegundoNomb();
        this.peaTelefonos = persona.getPeaTelefonos();
        //padres:
        this.accionControlVo = persona.getSiiAccionControl() != null ? new AccionControlVO(persona.getSiiAccionControl()) : new AccionControlVO();
        this.tipoIdentificacionVo = persona.getSiiTipoIdentificacion() != null ? new TipoIdentificacionVO(persona.getSiiTipoIdentificacion()) : new TipoIdentificacionVO();
        this.usuarioConectVo = persona.getSiiUsuarioConect() != null ? new UsuarioVO(persona.getSiiUsuarioConect()) : new UsuarioVO();


    }


    @Override
    public Object clone() {
        PersonaAtiendeAccVO persona = new PersonaAtiendeAccVO();

        persona.peaActivo = peaActivo;
        persona.peaCodigo = peaCodigo;
        persona.peaEmail = peaEmail;
        persona.peaNumeroIden = peaNumeroIden;
        persona.peaPrimerApell = peaPrimerApell;
        persona.peaPrimerNombre = peaPrimerNombre;
        persona.peaSegundoApell = peaSegundoApell;
        persona.peaSegundoNomb = peaSegundoNomb;
        persona.peaTelefonos = peaTelefonos;
        persona.tipoIdentificacionVo = tipoIdentificacionVo != null ? (TipoIdentificacionVO) tipoIdentificacionVo.clone() : null;
        persona.usuarioConectVo = usuarioConectVo;
        persona.accionControlVo = accionControlVo;

        return persona;
    }


    public void setPeaActivo(String peaActivo) {
        this.peaActivo = peaActivo;
    }

    public String getPeaActivo() {
        return peaActivo;
    }

    public void setPeaCodigo(Long peaCodigo) {
        this.peaCodigo = peaCodigo;
    }

    public Long getPeaCodigo() {
        return peaCodigo;
    }

    public void setPeaEmail(String peaEmail) {
        this.peaEmail = peaEmail;
    }

    public String getPeaEmail() {
        return peaEmail;
    }

    public void setPeaNumeroIden(String peaNumeroIden) {
        this.peaNumeroIden = peaNumeroIden;
    }

    public String getPeaNumeroIden() {
        return peaNumeroIden;
    }

    public void setPeaPrimerApell(String peaPrimerApell) {
        this.peaPrimerApell = peaPrimerApell;
    }

    public String getPeaPrimerApell() {
        return peaPrimerApell;
    }

    public void setPeaPrimerNombre(String peaPrimerNombre) {
        this.peaPrimerNombre = peaPrimerNombre;
    }

    public String getPeaPrimerNombre() {
        return peaPrimerNombre;
    }

    public void setPeaSegundoApell(String peaSegundoApell) {
        this.peaSegundoApell = peaSegundoApell;
    }

    public String getPeaSegundoApell() {
        return peaSegundoApell;
    }

    public void setPeaSegundoNomb(String peaSegundoNomb) {
        this.peaSegundoNomb = peaSegundoNomb;
    }

    public String getPeaSegundoNomb() {
        return peaSegundoNomb;
    }

    public void setPeaTelefonos(String peaTelefonos) {
        this.peaTelefonos = peaTelefonos;
    }

    public String getPeaTelefonos() {
        return peaTelefonos;
    }

    public void setTipoIdentificacionVo(TipoIdentificacionVO tipoIdentificacionVo) {
        this.tipoIdentificacionVo = tipoIdentificacionVo;
    }

    public TipoIdentificacionVO getTipoIdentificacionVo() {
        return tipoIdentificacionVo;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }

    public void setAccionControlVo(AccionControlVO accionControlVo) {
        this.accionControlVo = accionControlVo;
    }

    public AccionControlVO getAccionControlVo() {
        return accionControlVo;
    }

    public void setDireccionPersonaAtienListVo(List<DireccionPersonaAtienVO> direccionPersonaAtienListVo) {
        this.direccionPersonaAtienListVo = direccionPersonaAtienListVo;
    }

    public List<DireccionPersonaAtienVO> getDireccionPersonaAtienListVo() {
        return direccionPersonaAtienListVo;
    }

    public DireccionPersonaAtienVO getDireccionPersonaAtienVo() {
        return new DireccionPersonaAtienVO();
    }

    public void setTiposIdentificacionVo(List<TipoIdentificacionVO> tiposIdentificacionVo) {
        this.tiposIdentificacionVo = tiposIdentificacionVo;
    }

    public List<TipoIdentificacionVO> getTiposIdentificacionVo() {
        return tiposIdentificacionVo;
    }
}
