package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.util.Date;
import java.util.List;

public class UsuarioVO {
    private Long usuCodigo;
    private String usuContrasena;
    private String usuEmail;
    private Date usuFechaCreacion;
    private Date usuFechaUltimoLogin;
    private String usuNombreUsuario;
    private String usuSalt;
    private PersonaVO personaVo;
    private List<FirmaDocumentoVO> firmaDocumentoVOList;
    private List<SolicitudEstMercadoVO> solicitudEstMercadoVoList;
    private EstadoUsuarioVO estadoUsuarioVo;
    private FuncionVO funcionVo;  
    private List<UsuarioRolVO> usuarioRolVoList;
    private List<ApropiacionInicialVO> apropiacionInicialVoList;
    private List<ApropiacionInicialVO> apropiacionInicialVoList1;
    private List<ApropiacionInicialVO> apropiacionInicialVoList2;
    private AreaColjuegosVO areaColjuegosVo;
    //private List<EstudioPrevioVO> estudioPrevioListVo;
    private String usuUsuSistema;
    /////////////private List<InvitacionProcesoVO> siiInvitacionProcesoList1;
    private Long idEstadoAnterior;
    
    public UsuarioVO() {
    }

    public UsuarioVO(SiiUsuario siiUsuario) { 
        this.usuCodigo = siiUsuario.getUsuCodigo();
        this.usuContrasena = siiUsuario.getUsuContrasena();
        this.usuEmail = siiUsuario.getUsuEmail();
        this.usuFechaUltimoLogin = siiUsuario.getUsuFechaUltimoLogin();
        this.usuNombreUsuario = siiUsuario.getUsuNombreUsuario();
        this.usuSalt = siiUsuario.getUsuSalt();
        this.usuFechaCreacion = siiUsuario.getUsuFechaCreacion();
        this.usuUsuSistema = siiUsuario.getUsuUsuSistema();
        //padres:
        if(siiUsuario.getSiiAreaColjuegos1()!=null){
            this.areaColjuegosVo = new AreaColjuegosVO(siiUsuario.getSiiAreaColjuegos1());
        }
        
        //Estado
        if(siiUsuario.getSiiEstadoUsuario()!=null){
            this.estadoUsuarioVo= new EstadoUsuarioVO(siiUsuario.getSiiEstadoUsuario());
            this.idEstadoAnterior = siiUsuario.getSiiEstadoUsuario().getEusCodigo();
        }
        if(siiUsuario.getSiiFuncion1()!=null){
            this.funcionVo = new FuncionVO(siiUsuario.getSiiFuncion1());
        }        
        if(siiUsuario.getSiiPersona() != null){
            this.personaVo = new PersonaVO(siiUsuario.getSiiPersona());
        }
    }

    public void setApropiacionInicialVoList(List<ApropiacionInicialVO> apropiacionInicialVoList) {
        this.apropiacionInicialVoList = apropiacionInicialVoList;
    }

    public List<ApropiacionInicialVO> getApropiacionInicialVoList() {
        return apropiacionInicialVoList;
    }

    public void setApropiacionInicialVoList1(List<ApropiacionInicialVO> apropiacionInicialVoList1) {
        this.apropiacionInicialVoList1 = apropiacionInicialVoList1;
    }

    public List<ApropiacionInicialVO> getApropiacionInicialVoList1() {
        return apropiacionInicialVoList1;
    }

    public void setApropiacionInicialVoList2(List<ApropiacionInicialVO> apropiacionInicialVoList2) {
        this.apropiacionInicialVoList2 = apropiacionInicialVoList2;
    }

    public List<ApropiacionInicialVO> getApropiacionInicialVoList2() {
        return apropiacionInicialVoList2;
    }

    public void setSolicitudEstMercadoVoList(List<SolicitudEstMercadoVO> solicitudEstMercadoVoList) {
        this.solicitudEstMercadoVoList = solicitudEstMercadoVoList;
    }

    public List<SolicitudEstMercadoVO> getSolicitudEstMercadoVoList() {
        return solicitudEstMercadoVoList;
    }

    public void setFirmaDocumentoVOList(List<FirmaDocumentoVO> firmaDocumentoVOList) {
        this.firmaDocumentoVOList = firmaDocumentoVOList;
    }

    public List<FirmaDocumentoVO> getFirmaDocumentoVOList() {
        return firmaDocumentoVOList;
    }


    public void setEstadoUsuarioVo(EstadoUsuarioVO estadoUsuarioVo) {
        this.estadoUsuarioVo = estadoUsuarioVo;
    }

    public EstadoUsuarioVO getEstadoUsuarioVo() {
        return estadoUsuarioVo;
    }

    public void setFuncionVo(FuncionVO funcionVo) {
        this.funcionVo = funcionVo;
    }

    public FuncionVO getFuncionVo() {
        return funcionVo;
    }

    public void setAreaColjuegosVo(AreaColjuegosVO areaColjuegosVo) {
        this.areaColjuegosVo = areaColjuegosVo;
    }

    public AreaColjuegosVO getAreaColjuegosVo() {
        return areaColjuegosVo;
    }

    public void setUsuCodigo(Long usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public Long getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuFechaUltimoLogin(Date usuFechaUltimoLogin) {
        this.usuFechaUltimoLogin = usuFechaUltimoLogin;
    }

    public Date getUsuFechaUltimoLogin() {
        return usuFechaUltimoLogin;
    }

    public void setUsuNombreUsuario(String usuNombreUsuario) {
        this.usuNombreUsuario = usuNombreUsuario;
    }

    public String getUsuNombreUsuario() {
        return usuNombreUsuario;
    }

    public void setUsuSalt(String usuSalt) {
        this.usuSalt = usuSalt;
    }

    public String getUsuSalt() {
        return usuSalt;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setActivo(boolean activo) {
        estadoUsuarioVo.setEusCodigo(activo?1L:2L);
    }

    public boolean isActivo() {
        return estadoUsuarioVo.getEusCodigo()==1L?true:false;
    }

    public void setUsuFechaCreacion(Date usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }

    public Date getUsuFechaCreacion() {
        return usuFechaCreacion;
    }


    public void setUsuarioRolVoList(List<UsuarioRolVO> usuarioRolVoList) {
        this.usuarioRolVoList = usuarioRolVoList;
    }

    public List<UsuarioRolVO> getUsuarioRolVoList() {
        return usuarioRolVoList;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public void setUsuUsuSistema(String usuUsuSistema) {
        this.usuUsuSistema = usuUsuSistema;
    }

    public String getUsuUsuSistema() {
        return usuUsuSistema;
    }
    
    public String toString(){
        StringBuffer cadena = new StringBuffer();
        cadena.append("usuCodigo = " + this.usuCodigo);
        if(this.getAreaColjuegosVo() != null){
            cadena.append(" - areaColjuegos = " + this.getAreaColjuegosVo().getAcoCodigo());
        }
        if(this.getEstadoUsuarioVo() != null){
            cadena.append(" - Estado = " + this.getEstadoUsuarioVo().getEusCodigo());
        }
        if(this.getFuncionVo() != null){
            cadena.append(" - Función = " + this.getFuncionVo().getFunCodigo());
        }        
        if(this.getPersonaVo() != null){
            cadena.append(" - Persona = " + this.getPersonaVo().getPerCodigo());
        }
        return cadena.toString();
    }
}
