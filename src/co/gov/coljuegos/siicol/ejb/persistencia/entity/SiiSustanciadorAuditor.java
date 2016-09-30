package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_SUSTANCIADOR_AUDITOR")
public class SiiSustanciadorAuditor implements Serializable {
    private static final long serialVersionUID = -8762594147919573173L;
    private Long suaCodigo;
    private String suaRol;
    private List<SiiAuditorOrdenTrab> siiAuditorOrdenTrabList;
    private SiiTipoActuacion siiTipoActuacion;
    private SiiPersona siiPersona;
    private List<SiiGrupoAccionControl> siiGrupoAccionControlPpalList;
    private List<SiiGrupoAccionControl> siiGrupoAccionControlAcompList;
    private List<SiiHistEstadoSustan> siiHistEstadoSustanList;

    public SiiSustanciadorAuditor() {
    }

    public SiiSustanciadorAuditor(SiiPersona siiPersona, Long suaCodigo, String suaRol,
                                  SiiTipoActuacion siiTipoActuacion) {
        this.siiPersona = siiPersona;
        this.suaCodigo = suaCodigo;
        this.suaRol = suaRol;
        this.siiTipoActuacion = siiTipoActuacion;
    }


    @Id
    @Column(name = "SUA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SUSTANCIA_AUDIT_COD")
    @SequenceGenerator(name = "SEQ_SUSTANCIA_AUDIT_COD", sequenceName = "SEQ_SUSTANCIA_AUDIT_COD",allocationSize=1)
    public Long getSuaCodigo() {
        return suaCodigo;
    }

    public void setSuaCodigo(Long suaCodigo) {
        this.suaCodigo = suaCodigo;
    }

    @Column(name = "SUA_ROL", nullable = false, length = 1)
    public String getSuaRol() {
        return suaRol;
    }

    public void setSuaRol(String suaRol) {
        this.suaRol = suaRol;
    }


    @OneToMany(mappedBy = "siiSustanciadorAuditor")
    public List<SiiAuditorOrdenTrab> getSiiAuditorOrdenTrabList() {
        return siiAuditorOrdenTrabList;
    }

    public void setSiiAuditorOrdenTrabList(List<SiiAuditorOrdenTrab> siiAuditorOrdenTrabList) {
        this.siiAuditorOrdenTrabList = siiAuditorOrdenTrabList;
    }

    public SiiAuditorOrdenTrab addSiiAuditorOrdenTrab(SiiAuditorOrdenTrab siiAuditorOrdenTrab) {
        getSiiAuditorOrdenTrabList().add(siiAuditorOrdenTrab);
        siiAuditorOrdenTrab.setSiiSustanciadorAuditor(this);
        return siiAuditorOrdenTrab;
    }

    public SiiAuditorOrdenTrab removeSiiAuditorOrdenTrab(SiiAuditorOrdenTrab siiAuditorOrdenTrab) {
        getSiiAuditorOrdenTrabList().remove(siiAuditorOrdenTrab);
        siiAuditorOrdenTrab.setSiiSustanciadorAuditor(null);
        return siiAuditorOrdenTrab;
    }

    @ManyToOne
    @JoinColumn(name = "TAC_CODIGO")
    public SiiTipoActuacion getSiiTipoActuacion() {
        return siiTipoActuacion;
    }

    public void setSiiTipoActuacion(SiiTipoActuacion siiTipoActuacion) {
        this.siiTipoActuacion = siiTipoActuacion;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @OneToMany(mappedBy = "siiSustanciadorAuditorPpal")
    public List<SiiGrupoAccionControl> getSiiGrupoAccionControlPpalList(){
        return siiGrupoAccionControlPpalList;
    }

    public void setSiiGrupoAccionControlPpalList(List<SiiGrupoAccionControl> siiGrupoAccionControlPpalList){
        this.siiGrupoAccionControlPpalList = siiGrupoAccionControlPpalList;
    }

    public SiiGrupoAccionControl addSiiGrupoAccionControl(SiiGrupoAccionControl siiGrupoAccionControl){
        getSiiGrupoAccionControlPpalList().add(siiGrupoAccionControl);
        siiGrupoAccionControl.setSiiSustanciadorAuditorPpal(this);
        return siiGrupoAccionControl;
    }

    public SiiGrupoAccionControl removeSiiGrupoAccionControl(SiiGrupoAccionControl siiGrupoAccionControl){
        getSiiGrupoAccionControlPpalList().remove(siiGrupoAccionControl);
        siiGrupoAccionControl.setSiiSustanciadorAuditorPpal(null);
        return siiGrupoAccionControl;
    }

    @OneToMany(mappedBy = "siiSustanciadorAuditorAcomp")
    public List<SiiGrupoAccionControl> getSiiGrupoAccionControlAcompList(){
        return siiGrupoAccionControlAcompList;
    }

    public void setSiiGrupoAccionControlAcompList(List<SiiGrupoAccionControl> siiGrupoAccionControlAcompList){
        this.siiGrupoAccionControlAcompList = siiGrupoAccionControlAcompList;
    }

    @OneToMany(mappedBy = "siiSustanciadorAuditor")
    public List<SiiHistEstadoSustan> getSiiHistEstadoSustanList() {
        return siiHistEstadoSustanList;
    }

    public void setSiiHistEstadoSustanList(List<SiiHistEstadoSustan> siiHistEstadoSustanList) {
        this.siiHistEstadoSustanList = siiHistEstadoSustanList;
    }

    public SiiHistEstadoSustan addSiiHistEstadoSustan(SiiHistEstadoSustan siiHistEstadoSustan) {
        getSiiHistEstadoSustanList().add(siiHistEstadoSustan);
        siiHistEstadoSustan.setSiiSustanciadorAuditor(this);
        return siiHistEstadoSustan;
    }

    public SiiHistEstadoSustan removeSiiHistEstadoSustan(SiiHistEstadoSustan siiHistEstadoSustan) {
        getSiiHistEstadoSustanList().remove(siiHistEstadoSustan);
        siiHistEstadoSustan.setSiiSustanciadorAuditor(null);
        return siiHistEstadoSustan;
    }

}
