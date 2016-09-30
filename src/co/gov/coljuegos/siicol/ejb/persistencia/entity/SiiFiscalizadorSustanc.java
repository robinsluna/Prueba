package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

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
@Table(name = "SII_FISCALIZADOR_SUSTANC")
public class SiiFiscalizadorSustanc implements Serializable {
    private static final long serialVersionUID = 3149730406982045352L;
    private Long fsuCodigo;
    private String fsuRol;
    private List<SiiHistEstadoFiscaliz> siiHistEstadoFiscalizList;
    private SiiPersona siiPersona;
    private SiiTipoActuacion siiTipoActuacion;
    private List<SiiGrupoFiscalizacion> siiGrupoFiscalizacionPincipalList;
    private List<SiiGrupoFiscalizacion> siiGrupoFiscalizacionAcompList;
    private List<SiiRepartoFiscalizador> siiRepartoFiscalizadorList;

    public SiiFiscalizadorSustanc() {
    }

    public SiiFiscalizadorSustanc(Long fsuCodigo, String fsuRol,
                                  SiiPersona siiPersona, SiiTipoActuacion siiTipoActuacion) {
        this.fsuCodigo = fsuCodigo;
        this.fsuRol = fsuRol;
        this.siiPersona = siiPersona;
        this.siiTipoActuacion = siiTipoActuacion;
    }

    @Id
    @Column(name = "FSU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_FISCALIZADOR_SUSTANC_COD")
    @SequenceGenerator(name = "SEQ_FISCALIZADOR_SUSTANC_COD", sequenceName = "SEQ_FISCALIZADOR_SUSTANC_COD",allocationSize=1)
    public Long getFsuCodigo() {
        return fsuCodigo;
    }

    public void setFsuCodigo(Long fsuCodigo) {
        this.fsuCodigo = fsuCodigo;
    }

    @Column(name = "FSU_ROL", nullable = false, length = 1)
    public String getFsuRol() {
        return fsuRol;
    }

    public void setFsuRol(String fsuRol) {
        this.fsuRol = fsuRol;
    }


    @OneToMany(mappedBy = "siiFiscalizadorSustanc")
    public List<SiiHistEstadoFiscaliz> getSiiHistEstadoFiscalizList() {
        return siiHistEstadoFiscalizList;
    }

    public void setSiiHistEstadoFiscalizList(List<SiiHistEstadoFiscaliz> siiHistEstadoFiscalizList) {
        this.siiHistEstadoFiscalizList = siiHistEstadoFiscalizList;
    }

    public SiiHistEstadoFiscaliz addSiiHistEstadoFiscaliz(SiiHistEstadoFiscaliz siiHistEstadoFiscaliz) {
        getSiiHistEstadoFiscalizList().add(siiHistEstadoFiscaliz);
        siiHistEstadoFiscaliz.setSiiFiscalizadorSustanc(this);
        return siiHistEstadoFiscaliz;
    }

    public SiiHistEstadoFiscaliz removeSiiHistEstadoFiscaliz(SiiHistEstadoFiscaliz siiHistEstadoFiscaliz) {
        getSiiHistEstadoFiscalizList().remove(siiHistEstadoFiscaliz);
        siiHistEstadoFiscaliz.setSiiFiscalizadorSustanc(null);
        return siiHistEstadoFiscaliz;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "TAC_CODIGO")
    public SiiTipoActuacion getSiiTipoActuacion() {
        return siiTipoActuacion;
    }

    public void setSiiTipoActuacion(SiiTipoActuacion siiTipoActuacion) {
        this.siiTipoActuacion = siiTipoActuacion;
    }
    
    
    @OneToMany(mappedBy = "siiFiscalizadorSustanc")
    public List<SiiRepartoFiscalizador> getSiiRepartoFiscalizadorList() {
        return siiRepartoFiscalizadorList;
    }

    public void setSiiRepartoFiscalizadorList(List<SiiRepartoFiscalizador> siiRepartoFiscalizadorList) {
        this.siiRepartoFiscalizadorList = siiRepartoFiscalizadorList;
    }

    public SiiRepartoFiscalizador addSiiRepartoFiscalizador(SiiRepartoFiscalizador siiRepartoFiscalizador) {
        getSiiRepartoFiscalizadorList().add(siiRepartoFiscalizador);
        siiRepartoFiscalizador.setSiiFiscalizadorSustanc(this);
        return siiRepartoFiscalizador;
    }

    public SiiRepartoFiscalizador removeSiiRepartoFiscalizador(SiiRepartoFiscalizador siiRepartoFiscalizador) {
        getSiiRepartoFiscalizadorList().remove(siiRepartoFiscalizador);
        siiRepartoFiscalizador.setSiiFiscalizadorSustanc(null);
        return siiRepartoFiscalizador;
    }

    @OneToMany(mappedBy = "siiFiscalizadorSustancPrincipal")
    public List<SiiGrupoFiscalizacion> getSiiGrupoFiscalizacionPincipalList() {
        return siiGrupoFiscalizacionPincipalList;
    }

    public void setSiiGrupoFiscalizacionPincipalList(List<SiiGrupoFiscalizacion> siiGrupoFiscalizacionPincipalList) {
        this.siiGrupoFiscalizacionPincipalList = siiGrupoFiscalizacionPincipalList;
    }

    public SiiGrupoFiscalizacion addSiiGrupoFiscalizacion(SiiGrupoFiscalizacion siiGrupoFiscalizacion) {
        getSiiGrupoFiscalizacionPincipalList().add(siiGrupoFiscalizacion);
        siiGrupoFiscalizacion.setSiiFiscalizadorSustancPrincipal(this);
        return siiGrupoFiscalizacion;
    }

    public SiiGrupoFiscalizacion removeSiiGrupoFiscalizacion(SiiGrupoFiscalizacion siiGrupoFiscalizacion) {
        getSiiGrupoFiscalizacionPincipalList().remove(siiGrupoFiscalizacion);
        siiGrupoFiscalizacion.setSiiFiscalizadorSustancPrincipal(null);
        return siiGrupoFiscalizacion;
    }

    @OneToMany(mappedBy = "siiFiscalizadorSustancAcomp")
    public List<SiiGrupoFiscalizacion> getSiiGrupoFiscalizacionAcompList() {
        return siiGrupoFiscalizacionAcompList;
    }

    public void setSiiGrupoFiscalizacionAcompList(List<SiiGrupoFiscalizacion> siiGrupoFiscalizacionAcompList) {
        this.siiGrupoFiscalizacionAcompList = siiGrupoFiscalizacionAcompList;
    }

}
