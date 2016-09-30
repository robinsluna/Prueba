package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_GRUPO_ACCION_CONTROL")
public class SiiGrupoAccionControl implements Serializable{
    private static final long serialVersionUID = -5583854741425252463L;
    private Long gacCodigo;
    private Date gacFecha;
    private Integer gacNumero;
    private SiiSustanciadorAuditor siiSustanciadorAuditorPpal;
    private SiiSustanciadorAuditor siiSustanciadorAuditorAcomp;
    private List<SiiAutoComisorioAccCon> siiAutoComisorioAccConList;

    public SiiGrupoAccionControl(){
    }

    public SiiGrupoAccionControl(Long gacCodigo, Date gacFecha, Integer gacNumero, SiiSustanciadorAuditor siiSustanciadorAuditorAcomp, SiiSustanciadorAuditor siiSustanciadorAuditorPpal){
        this.gacCodigo = gacCodigo;
        this.gacFecha = gacFecha;
        this.gacNumero = gacNumero;
        this.siiSustanciadorAuditorAcomp = siiSustanciadorAuditorAcomp;
        this.siiSustanciadorAuditorPpal = siiSustanciadorAuditorPpal;
    }

    @Id
    @Column(name = "GAC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GRUPO_ACCION_CONTROL_COD")
    @SequenceGenerator(name = "SEQ_GRUPO_ACCION_CONTROL_COD", sequenceName = "SEQ_GRUPO_ACCION_CONTROL_COD",allocationSize=1)
    public Long getGacCodigo(){
        return gacCodigo;
    }

    public void setGacCodigo(Long gacCodigo){
        this.gacCodigo = gacCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GAC_FECHA", nullable = false)
    public Date getGacFecha(){
        return gacFecha;
    }

    public void setGacFecha(Date gacFecha){
        this.gacFecha = gacFecha;
    }

    @Column(name = "GAC_NUMERO", nullable = false)
    public Integer getGacNumero(){
        return gacNumero;
    }

    public void setGacNumero(Integer gacNumero){
        this.gacNumero = gacNumero;
    }


    @ManyToOne
    @JoinColumn(name = "SUA_CODIGO_PPAL")
    public SiiSustanciadorAuditor getSiiSustanciadorAuditorPpal(){
        return siiSustanciadorAuditorPpal;
    }

    public void setSiiSustanciadorAuditorPpal(SiiSustanciadorAuditor siiSustanciadorAuditorPpal){
        this.siiSustanciadorAuditorPpal = siiSustanciadorAuditorPpal;
    }

    @ManyToOne
    @JoinColumn(name = "SUA_CODIGO_ACOMP")
    public SiiSustanciadorAuditor getSiiSustanciadorAuditorAcomp(){
        return siiSustanciadorAuditorAcomp;
    }

    public void setSiiSustanciadorAuditorAcomp(SiiSustanciadorAuditor siiSustanciadorAuditorAcomp){
        this.siiSustanciadorAuditorAcomp = siiSustanciadorAuditorAcomp;
    }

    @OneToMany(mappedBy = "siiGrupoAccionControl")
    public List<SiiAutoComisorioAccCon> getSiiAutoComisorioAccConList(){
        return siiAutoComisorioAccConList;
    }

    public void setSiiAutoComisorioAccConList(List<SiiAutoComisorioAccCon> siiAutoComisorioAccConList){
        this.siiAutoComisorioAccConList = siiAutoComisorioAccConList;
    }

    public SiiAutoComisorioAccCon addSiiAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon){
        getSiiAutoComisorioAccConList().add(siiAutoComisorioAccCon);
        siiAutoComisorioAccCon.setSiiGrupoAccionControl(this);
        return siiAutoComisorioAccCon;
    }

    public SiiAutoComisorioAccCon removeSiiAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon){
        getSiiAutoComisorioAccConList().remove(siiAutoComisorioAccCon);
        siiAutoComisorioAccCon.setSiiGrupoAccionControl(null);
        return siiAutoComisorioAccCon;
    }
}
