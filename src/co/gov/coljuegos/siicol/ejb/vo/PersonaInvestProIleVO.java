package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaInvestProIle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonaInvestProIleVO {
    private String pipActivo;
    private Long pipCodigo;
    private Date pipComIniFechaRad;
    private String pipComIniRadicado;
    private Date pipResEnvFecha;
    private String pipResEnvIndResp;
    private String pipResEnvNumGuia;
    private String pipCreada;
    private String pipSancionada;
    private String pipInvestigada;
    private String pipAutorEnvEmail;

    private ProcesoSancIlegalidadVO procesoSancIlegalidadVo;
    private UsuarioVO usuarioConecVo;
    private PersonaVO personaVo;

    private List<ComunicResolPersIleVO> comunicResolPersIleListVo;
    private List<PersonaInvProIleAutoVO> personaInvProIleAutoListVo;
    private List<DireccionProcePerIleVO> direccionProcePerIleListVo;
    private List<PerInvesProIleAutoPruVO> perInvesProIleAutoPruList;
    
    /**
     * Constructor.
     */
    public PersonaInvestProIleVO() { }
    
    
    /**
     * Constructor.
     * @param personaInvestProIle - Entity.
     */

    public PersonaInvestProIleVO(SiiPersonaInvestProIle personaInvestProIle) {
        this.pipCodigo = personaInvestProIle.getPipCodigo();
        this.pipActivo = personaInvestProIle.getPipActivo();
        this.pipComIniFechaRad = personaInvestProIle.getPipComIniFechaRad();
        this.pipComIniRadicado = personaInvestProIle.getPipComIniRadicado();
        this.pipResEnvFecha = personaInvestProIle.getPipResEnvFecha();
        this.pipResEnvIndResp = personaInvestProIle.getPipResEnvIndResp();
        this.pipResEnvNumGuia = personaInvestProIle.getPipResEnvNumGuia();
        this.pipCreada = personaInvestProIle.getPipCreada();
        this.pipSancionada = personaInvestProIle.getPipSancionada();
        this.pipInvestigada = personaInvestProIle.getPipInvestigada();
        this.pipAutorEnvEmail = personaInvestProIle.getPipAutorEnvEmail();

        //Padres
        if(personaInvestProIle.getSiiPersona() != null) {
            this.personaVo = new PersonaVO(personaInvestProIle.getSiiPersona());
        }
        if(personaInvestProIle.getSiiProcesoSancIlegalidad() != null) {
            this.procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO(personaInvestProIle.getSiiProcesoSancIlegalidad());
        }
        if(personaInvestProIle.getSiiUsuarioConec() != null) {
            this.usuarioConecVo = new UsuarioVO(personaInvestProIle.getSiiUsuarioConec());
        }
    }

    public void setPipActivo(String pipActivo) {
        this.pipActivo = pipActivo;
    }

    public String getPipActivo() {
        return pipActivo;
    }

    public void setPipCodigo(Long pipCodigo) {
        this.pipCodigo = pipCodigo;
    }

    public Long getPipCodigo() {
        return pipCodigo;
    }

    public void setPipComIniFechaRad(Date pipComIniFechaRad) {
        this.pipComIniFechaRad = pipComIniFechaRad;
    }

    public Date getPipComIniFechaRad() {
        return pipComIniFechaRad;
    }

    public void setPipComIniRadicado(String pipComIniRadicado) {
        this.pipComIniRadicado = pipComIniRadicado;
    }

    public String getPipComIniRadicado() {
        return pipComIniRadicado;
    }

    public void setPipResEnvFecha(Date pipResEnvFecha) {
        this.pipResEnvFecha = pipResEnvFecha;
    }

    public Date getPipResEnvFecha() {
        return pipResEnvFecha;
    }

    public void setPipResEnvIndResp(String pipResEnvIndResp) {
        this.pipResEnvIndResp = pipResEnvIndResp;
    }

    public String getPipResEnvIndResp() {
        return pipResEnvIndResp;
    }

    public void setPipResEnvNumGuia(String pipResEnvNumGuia) {
        this.pipResEnvNumGuia = pipResEnvNumGuia;
    }

    public String getPipResEnvNumGuia() {
        return pipResEnvNumGuia;
    }

    public void setProcesoSancIlegalidadVo(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) {
        this.procesoSancIlegalidadVo = procesoSancIlegalidadVo;
    }

    public ProcesoSancIlegalidadVO getProcesoSancIlegalidadVo() {
        return procesoSancIlegalidadVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setComunicResolPersIleListVo(List<ComunicResolPersIleVO> comunicResolPersIleListVo) {
        this.comunicResolPersIleListVo = comunicResolPersIleListVo;
    }

    public List<ComunicResolPersIleVO> getComunicResolPersIleListVo() {
        return comunicResolPersIleListVo;
    }

    public void setPersonaInvProIleAutoListVo(List<PersonaInvProIleAutoVO> personaInvProIleAutoListVo) {
        this.personaInvProIleAutoListVo = personaInvProIleAutoListVo;
    }

    public List<PersonaInvProIleAutoVO> getPersonaInvProIleAutoListVo() {
        return personaInvProIleAutoListVo;
    }

    public void setDireccionProcePerIleListVo(List<DireccionProcePerIleVO> direccionProcePerIleListVo) {
        this.direccionProcePerIleListVo = direccionProcePerIleListVo;
    }

    public List<DireccionProcePerIleVO> getDireccionProcePerIleListVo() {
        return direccionProcePerIleListVo;
    }

    public void setPerInvesProIleAutoPruList(List<PerInvesProIleAutoPruVO> perInvesProIleAutoPruList) {
        this.perInvesProIleAutoPruList = perInvesProIleAutoPruList;
    }

    public List<PerInvesProIleAutoPruVO> getPerInvesProIleAutoPruList() {
        return perInvesProIleAutoPruList;
    }

    public void setPipCreada(String pipCreada) {
        this.pipCreada = pipCreada;
    }

    public String getPipCreada() {
        return pipCreada;
    }

    public void setPipSancionada(String pipSancionada) {
        this.pipSancionada = pipSancionada;
    }

    public String getPipSancionada() {
        return pipSancionada;
    }

    public void setPipInvestigada(String pipInvestigada) {
        this.pipInvestigada = pipInvestigada;
    }

    public String getPipInvestigada() {
        return pipInvestigada;
    }

    public void setPipAutorEnvEmail(String pipAutorEnvEmail) {
        this.pipAutorEnvEmail = pipAutorEnvEmail;
    }

    public String getPipAutorEnvEmail() {
        return pipAutorEnvEmail;
    }
    
    
    /**
     * Obtiene el nombre correspondiente al valor de <i>pipSancionada</i>.
     * @return pipSancionada->nombre
     */
    public String getSancionada () {
        String resultado = null;
        
        if (this.pipSancionada!=null)
            resultado = EnumDecision.getNombreById(this.pipSancionada);
        
        return (resultado);
    }
}
