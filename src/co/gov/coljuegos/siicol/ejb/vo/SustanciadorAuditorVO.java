package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSustanciadorAuditor;

import java.util.Date;
import java.util.List;

/**
 * Constructor
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class SustanciadorAuditorVO {

    private Long suaCodigo;
    private String suaRol;
    private TipoActuacionVO tipoActuacionVo;
    private String suaGrupoAsigVis;
    private PersonaVO personaVo;
    private List<AuditorOrdenTrabVO> auditorOrdenTrabListVo;
    private List<GrupoAccionControlVO> grupoAccionControlPpalListVo;
    private List<GrupoAccionControlVO> grupoAccionControlAcompListVo;
    private List<HistEstadoSustanVO> histEstadoSustanListVo;

    // Datos que no pertencen a la entity
    private String estadoActual;
    private Date fechaActivo;
    private String nombreCompleto;
    private String perNumIdentificacion;

    /**
     * Constructor
     */
    public SustanciadorAuditorVO() {
        super();
    }

    /**
     *Constructor
     * @param siiSustanciadorAuditor
     */
    public SustanciadorAuditorVO(SiiSustanciadorAuditor siiSustanciadorAuditor) {
        this.suaCodigo = siiSustanciadorAuditor.getSuaCodigo();
        this.suaRol = siiSustanciadorAuditor.getSuaRol();

        if(siiSustanciadorAuditor.getSiiTipoActuacion() != null)
            this.tipoActuacionVo = new TipoActuacionVO(siiSustanciadorAuditor.getSiiTipoActuacion());

        if(siiSustanciadorAuditor.getSiiPersona() != null)
            this.personaVo = new PersonaVO(siiSustanciadorAuditor.getSiiPersona());

    }

    public void setSuaCodigo(Long suaCodigo) {
        this.suaCodigo = suaCodigo;
    }

    public Long getSuaCodigo() {
        return suaCodigo;
    }

    public void setSuaRol(String suaRol) {
        this.suaRol = suaRol;
    }

    public String getSuaRol() {
        return suaRol;
    }

    public void setTipoActuacionVo(TipoActuacionVO tipoActuacionVo) {
        this.tipoActuacionVo = tipoActuacionVo;
    }

    public TipoActuacionVO getTipoActuacionVo() {
        return tipoActuacionVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setAuditorOrdenTrabListVo(List<AuditorOrdenTrabVO> auditorOrdenTrabListVo) {
        this.auditorOrdenTrabListVo = auditorOrdenTrabListVo;
    }

    public List<AuditorOrdenTrabVO> getAuditorOrdenTrabListVo() {
        return auditorOrdenTrabListVo;
    }

    public void setGrupoAccionControlPpalListVo(List<GrupoAccionControlVO> grupoAccionControlPpalListVo) {
        this.grupoAccionControlPpalListVo = grupoAccionControlPpalListVo;
    }

    public List<GrupoAccionControlVO> getGrupoAccionControlPpalListVo() {
        return grupoAccionControlPpalListVo;
    }

    public void setGrupoAccionControlAcompListVo(List<GrupoAccionControlVO> grupoAccionControlAcompListVo) {
        this.grupoAccionControlAcompListVo = grupoAccionControlAcompListVo;
    }

    public List<GrupoAccionControlVO> getGrupoAccionControlAcompListVo() {
        return grupoAccionControlAcompListVo;
    }

    public void setHistEstadoSustanListVo(List<HistEstadoSustanVO> histEstadoSustanListVo) {
        this.histEstadoSustanListVo = histEstadoSustanListVo;
    }

    public List<HistEstadoSustanVO> getHistEstadoSustanListVo() {
        return histEstadoSustanListVo;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setFechaActivo(Date fechaActivo) {
        this.fechaActivo = fechaActivo;
    }

    public Date getFechaActivo() {
        return fechaActivo;
    }

    public void setSuaGrupoAsigVis(String suaGrupoAsigVis){
        this.suaGrupoAsigVis = suaGrupoAsigVis;
    }

    public String getSuaGrupoAsigVis(){
        return suaGrupoAsigVis;
    }

    public void setNombreCompleto(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public void setPerNumIdentificacion(String perNumIdentificacion){
        this.perNumIdentificacion = perNumIdentificacion;
    }

    public String getPerNumIdentificacion(){
        return perNumIdentificacion;
    }
}
