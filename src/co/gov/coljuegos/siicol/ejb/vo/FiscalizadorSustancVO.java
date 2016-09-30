package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFiscalizadorSustanc;

import java.util.Date;
import java.util.List;

public class FiscalizadorSustancVO {
   
    private Long fsuCodigo;
    private String fsuRol;
    private PersonaVO personaVo;
    private TipoActuacionVO tipoActuacionVo;

    private List<HistEstadoFiscalizVO> histEstadoFiscalizListVo;
    private List<GrupoFiscalizacionVO> grupoFiscalizacionPincipalListVo;
    private List<GrupoFiscalizacionVO> grupoFiscalizacionAcompListVo;
    private List<RepartoFiscalizadorVO> repartoFiscalizadorListVo;    


    //campos adicionados
    private String fsuGrupoAsigVis;
    private String tipoIntegrante;
    private String cargo;
    private String estadoActual;
    private Date fechaActivo;
    
    public FiscalizadorSustancVO() {
        
    }
    
    public FiscalizadorSustancVO (SiiFiscalizadorSustanc siiFiscalizadorSustanc) {
        this.fsuCodigo = siiFiscalizadorSustanc.getFsuCodigo();
        this.fsuRol = siiFiscalizadorSustanc.getFsuRol();
        // padres
        if (siiFiscalizadorSustanc.getSiiPersona()!=null) {
            this.personaVo = new PersonaVO(siiFiscalizadorSustanc.getSiiPersona());
        }
        if (siiFiscalizadorSustanc.getSiiTipoActuacion()!=null) {
            this.tipoActuacionVo = new TipoActuacionVO(siiFiscalizadorSustanc.getSiiTipoActuacion());
        }
    }

    public void setFsuCodigo(Long fsuCodigo) {
        this.fsuCodigo = fsuCodigo;
    }

    public Long getFsuCodigo() {
        return fsuCodigo;
    }

    public void setFsuRol(String fsuRol) {
        this.fsuRol = fsuRol;
    }

    public String getFsuRol() {
        return fsuRol;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setTipoActuacionVo(TipoActuacionVO tipoActuacionVo) {
        this.tipoActuacionVo = tipoActuacionVo;
    }

    public TipoActuacionVO getTipoActuacionVo() {
        return tipoActuacionVo;
    }

    public void setHistEstadoFiscalizListVo(List<HistEstadoFiscalizVO> histEstadoFiscalizListVo) {
        this.histEstadoFiscalizListVo = histEstadoFiscalizListVo;
    }

    public List<HistEstadoFiscalizVO> getHistEstadoFiscalizListVo() {
        return histEstadoFiscalizListVo;
    }

    public void setGrupoFiscalizacionPincipalListVo(List<GrupoFiscalizacionVO> grupoFiscalizacionPincipalListVo) {
        this.grupoFiscalizacionPincipalListVo = grupoFiscalizacionPincipalListVo;
    }

    public List<GrupoFiscalizacionVO> getGrupoFiscalizacionPincipalListVo() {
        return grupoFiscalizacionPincipalListVo;
    }

    public void setGrupoFiscalizacionAcompListVo(List<GrupoFiscalizacionVO> grupoFiscalizacionAcompListVo) {
        this.grupoFiscalizacionAcompListVo = grupoFiscalizacionAcompListVo;
    }

    public List<GrupoFiscalizacionVO> getGrupoFiscalizacionAcompListVo() {
        return grupoFiscalizacionAcompListVo;
    }

    public void setRepartoFiscalizadorListVo(List<RepartoFiscalizadorVO> repartoFiscalizadorListVo) {
        this.repartoFiscalizadorListVo = repartoFiscalizadorListVo;
    }

    public List<RepartoFiscalizadorVO> getRepartoFiscalizadorListVo() {
        return repartoFiscalizadorListVo;
    }

    public void setTipoIntegrante(String tipoIntegrante) {
        this.tipoIntegrante = tipoIntegrante;
    }

    public String getTipoIntegrante() {
        return tipoIntegrante;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setFsuGrupoAsigVis(String fsuGrupoAsigVis) {
        this.fsuGrupoAsigVis = fsuGrupoAsigVis;
    }

    public String getFsuGrupoAsigVis() {
        return fsuGrupoAsigVis;
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
}
