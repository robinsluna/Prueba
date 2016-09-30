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
@Table(name = "SII_AUTO_DECRETA_PRUE_PRO_ILE")
public class SiiAutoDecretaPrueProIle implements Serializable {
    private static final long serialVersionUID = -5734801251488737318L;
    private Long atpCodigo;
    private String atpDecretaPru;
    private Integer atpDias;
    private SiiProcesoSancIlegalidad siiProcesoSancIlegalidad;
    private List<SiiTramiteAutoPrueTras> siiTramiteAutoPrueTrasList;
    private SiiUsuario siiUsuarioConec;
    private List<SiiPruebaAutoDecrPru> siiPruebaAutoDecrPruList;
    private String atpRadicado;
    private Date atpFechaRad;
    private List<SiiPerInvesProIleAutoPru> siiPerInvesProIleAutoPruList;
    private String atpTipoAuto;
    private String atpNumero;
    private Date atpFecha;
    

    public SiiAutoDecretaPrueProIle() {
    }

    public SiiAutoDecretaPrueProIle(Long atpCodigo, String atpDecretaPru, Integer atpDias, SiiProcesoSancIlegalidad siiProcesoSancIlegalidad, SiiUsuario siiUsuarioConec) {
        this.atpCodigo = atpCodigo;
        this.atpDecretaPru = atpDecretaPru;
        this.atpDias = atpDias;
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Id
    @Column(name = "ATP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AUTO_PRU_TRA_PRO_IL_COD")
    @SequenceGenerator(name = "SEQ_AUTO_PRU_TRA_PRO_IL_COD", sequenceName = "SEQ_AUTO_PRU_TRA_PRO_IL_COD",allocationSize=1)
    public Long getAtpCodigo() {
        return atpCodigo;
    }

    public void setAtpCodigo(Long atpCodigo) {
        this.atpCodigo = atpCodigo;
    }

    @Column(name = "ATP_DECRETA_PRU", length = 1)
    public String getAtpDecretaPru() {
        return atpDecretaPru;
    }

    public void setAtpDecretaPru(String atpDecretaPru) {
        this.atpDecretaPru = atpDecretaPru;
    }

    @Column(name = "ATP_DIAS")
    public Integer getAtpDias() {
        return atpDias;
    }

    public void setAtpDias(Integer atpDias) {
        this.atpDias = atpDias;
    }


    @ManyToOne
    @JoinColumn(name = "PRS_CODIGO")
    public SiiProcesoSancIlegalidad getSiiProcesoSancIlegalidad() {
        return siiProcesoSancIlegalidad;
    }

    public void setSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
    }

    @OneToMany(mappedBy = "siiAutoDecretaPrueProIle", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    public List<SiiTramiteAutoPrueTras> getSiiTramiteAutoPrueTrasList() {
        return siiTramiteAutoPrueTrasList;
    }

    public void setSiiTramiteAutoPrueTrasList(List<SiiTramiteAutoPrueTras> siiTramiteAutoPrueTrasList) {
        this.siiTramiteAutoPrueTrasList = siiTramiteAutoPrueTrasList;
    }

    public SiiTramiteAutoPrueTras addSiiTramiteAutoPrueTras(SiiTramiteAutoPrueTras siiTramiteAutoPrueTras) {
        getSiiTramiteAutoPrueTrasList().add(siiTramiteAutoPrueTras);
        siiTramiteAutoPrueTras.setSiiAutoDecretaPrueProIle(this);
        return siiTramiteAutoPrueTras;
    }

    public SiiTramiteAutoPrueTras removeSiiTramiteAutoPrueTras(SiiTramiteAutoPrueTras siiTramiteAutoPrueTras) {
        getSiiTramiteAutoPrueTrasList().remove(siiTramiteAutoPrueTras);
        siiTramiteAutoPrueTras.setSiiAutoDecretaPrueProIle(null);
        return siiTramiteAutoPrueTras;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @OneToMany(mappedBy = "siiAutoDecretaPrueProIle", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    public List<SiiPruebaAutoDecrPru> getSiiPruebaAutoDecrPruList() {
        return siiPruebaAutoDecrPruList;
    }

    public void setSiiPruebaAutoDecrPruList(List<SiiPruebaAutoDecrPru> siiPruebaAutoDecrPruList) {
        this.siiPruebaAutoDecrPruList = siiPruebaAutoDecrPruList;
    }

    public SiiPruebaAutoDecrPru addSiiPruebaAutoDecrPru(SiiPruebaAutoDecrPru siiPruebaAutoDecrPru) {
        getSiiPruebaAutoDecrPruList().add(siiPruebaAutoDecrPru);
        siiPruebaAutoDecrPru.setSiiAutoDecretaPrueProIle(this);
        return siiPruebaAutoDecrPru;
    }

    public SiiPruebaAutoDecrPru removeSiiPruebaAutoDecrPru(SiiPruebaAutoDecrPru siiPruebaAutoDecrPru) {
        getSiiPruebaAutoDecrPruList().remove(siiPruebaAutoDecrPru);
        siiPruebaAutoDecrPru.setSiiAutoDecretaPrueProIle(null);
        return siiPruebaAutoDecrPru;
    }
    @Column(name = "ATP_TIPO_AUTO", length = 1)
    public String getAtpTipoAuto() {
        return atpTipoAuto;
    }
    
    public void setAtpTipoAuto(String atpTipoAuto) {
        this.atpTipoAuto = atpTipoAuto;
    }

    @Column(name = "ATP_RADICADO", length = 30)
    public String getAtpRadicado() {
        return atpRadicado;
    }
    
    public void setAtpRadicado(String atpRadicado) {
        this.atpRadicado = atpRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ATP_FECHA_RAD")
    public Date getAtpFechaRad() {
        return atpFechaRad;
    }
    
    public void setAtpFechaRad(Date atpFechaRad) {
        this.atpFechaRad = atpFechaRad;
    }
    
    @OneToMany(mappedBy = "siiAutoDecretaPrueProIle")
    public List<SiiPerInvesProIleAutoPru> getSiiPerInvesProIleAutoPruList() {
        return siiPerInvesProIleAutoPruList;
    }

    public void setSiiPerInvesProIleAutoPruList(List<SiiPerInvesProIleAutoPru> siiPerInvesProIleAutoPruList) {
        this.siiPerInvesProIleAutoPruList = siiPerInvesProIleAutoPruList;
    }

    public SiiPerInvesProIleAutoPru addSiiPerInvesProIleAutoPru(SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru) {
        getSiiPerInvesProIleAutoPruList().add(siiPerInvesProIleAutoPru);
        siiPerInvesProIleAutoPru.setSiiAutoDecretaPrueProIle(this);
        return siiPerInvesProIleAutoPru;
    }

    public SiiPerInvesProIleAutoPru removeSiiPerInvesProIleAutoPru(SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru) {
        getSiiPerInvesProIleAutoPruList().remove(siiPerInvesProIleAutoPru);
        siiPerInvesProIleAutoPru.setSiiAutoDecretaPrueProIle(null);
        return siiPerInvesProIleAutoPru;
    }

    @Column(name = "ATP_NUMERO", length = 20)
    public String getAtpNumero() {
        return atpNumero;
    }
    
    public void setAtpNumero(String atpNumero) {
        this.atpNumero = atpNumero;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ATP_FECHA")
    public Date getAtpFecha() {
        return atpFecha;
    }
    
    public void setAtpFecha(Date atpFecha) {
        this.atpFecha = atpFecha;
    }
}
