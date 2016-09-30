package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_DETALLE_RUBRO")
public class SiiDetalleRubro implements Serializable {
    private static final long serialVersionUID = 2773984277455826949L;
    private Long druCodigo;
    private Long druValor;
    private Long interno;
    private Integer vigencia;
    private List<SiiDistribucionPfc> siiDistribucionPfcList;
    private SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion;
    private List<SiiEstPrevDetRubro> siiEstPrevDetRubroList;
    private List<SiiItemPlanContDetRub> siiItemPlanContDetRubList;
    private List<SiiModPresDetRubro> siiModPresDetRubroOriList;
    private List<SiiModPresDetRubro> siiModPresDetRubroDestList;
    private List<SiiSolPfcMensDetRub> siiSolPfcMensDetRubList;
    private SiiFuenteFinancContab siiFuenteFinancContab;
    private List<SiiDetRubroVigenFutura> siiDetRubroVigenFuturaList;

    public SiiDetalleRubro() {
    }

    public SiiDetalleRubro(SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion, Long druCodigo, Long druValor,
                           Long interno, Integer vigencia, SiiFuenteFinancContab siiFuenteFinancContab) {
        this.siiDtlleFuenteFinanciacion = siiDtlleFuenteFinanciacion;
        this.druCodigo = druCodigo;
        this.druValor = druValor;
        this.siiFuenteFinancContab = siiFuenteFinancContab;
        this.interno = interno;
        this.vigencia = vigencia;
    }


    @Id
    @Column(name = "DRU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DETALLE_RUBRO_CODIGO")
    @SequenceGenerator(name = "SEQ_DETALLE_RUBRO_CODIGO", sequenceName = "SEQ_DETALLE_RUBRO_CODIGO",allocationSize=1)
    public Long getDruCodigo() {
        return druCodigo;
    }

    public void setDruCodigo(Long druCodigo) {
        this.druCodigo = druCodigo;
    }

    @Column(name = "DRU_VALOR")
    public Long getDruValor() {
        return druValor;
    }

    public void setDruValor(Long druValor) {
        this.druValor = druValor;
    }

    @Column(nullable = false)
    public Long getInterno() {
        return interno;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    @Column(nullable = false)
    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    @OneToMany(mappedBy = "siiDetalleRubro")
    public List<SiiDistribucionPfc> getSiiDistribucionPfcList() {
        return siiDistribucionPfcList;
    }

    public void setSiiDistribucionPfcList(List<SiiDistribucionPfc> siiDistribucionPfcList) {
        this.siiDistribucionPfcList = siiDistribucionPfcList;
    }

    public SiiDistribucionPfc addSiiDistribucionPfc(SiiDistribucionPfc siiDistribucionPfc) {
        getSiiDistribucionPfcList().add(siiDistribucionPfc);
        siiDistribucionPfc.setSiiDetalleRubro(this);
        return siiDistribucionPfc;
    }

    public SiiDistribucionPfc removeSiiDistribucionPfc(SiiDistribucionPfc siiDistribucionPfc) {
        getSiiDistribucionPfcList().remove(siiDistribucionPfc);
        siiDistribucionPfc.setSiiDetalleRubro(null);
        return siiDistribucionPfc;
    }

    @ManyToOne
    @JoinColumn(name = "DFF_CODIGO")
    public SiiDtlleFuenteFinanciacion getSiiDtlleFuenteFinanciacion() {
        return siiDtlleFuenteFinanciacion;
    }

    public void setSiiDtlleFuenteFinanciacion(SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion) {
        this.siiDtlleFuenteFinanciacion = siiDtlleFuenteFinanciacion;
    }

    @OneToMany(mappedBy = "siiDetalleRubro")
    public List<SiiEstPrevDetRubro> getSiiEstPrevDetRubroList() {
        return siiEstPrevDetRubroList;
    }

    public void setSiiEstPrevDetRubroList(List<SiiEstPrevDetRubro> siiEstPrevDetRubroList) {
        this.siiEstPrevDetRubroList = siiEstPrevDetRubroList;
    }

    public SiiEstPrevDetRubro addSiiEstPrevDetRubro(SiiEstPrevDetRubro siiEstPrevDetRubro) {
        getSiiEstPrevDetRubroList().add(siiEstPrevDetRubro);
        siiEstPrevDetRubro.setSiiDetalleRubro(this);
        return siiEstPrevDetRubro;
    }

    public SiiEstPrevDetRubro removeSiiEstPrevDetRubro(SiiEstPrevDetRubro siiEstPrevDetRubro) {
        getSiiEstPrevDetRubroList().remove(siiEstPrevDetRubro);
        siiEstPrevDetRubro.setSiiDetalleRubro(null);
        return siiEstPrevDetRubro;
    }

    @OneToMany(mappedBy = "siiDetalleRubro")
    public List<SiiItemPlanContDetRub> getSiiItemPlanContDetRubList() {
        return siiItemPlanContDetRubList;
    }

    public void setSiiItemPlanContDetRubList(List<SiiItemPlanContDetRub> siiItemPlanContDetRubList) {
        this.siiItemPlanContDetRubList = siiItemPlanContDetRubList;
    }

    public SiiItemPlanContDetRub addSiiItemPlanContDetRub(SiiItemPlanContDetRub siiItemPlanContDetRub) {
        getSiiItemPlanContDetRubList().add(siiItemPlanContDetRub);
        siiItemPlanContDetRub.setSiiDetalleRubro(this);
        return siiItemPlanContDetRub;
    }

    public SiiItemPlanContDetRub removeSiiItemPlanContDetRub(SiiItemPlanContDetRub siiItemPlanContDetRub) {
        getSiiItemPlanContDetRubList().remove(siiItemPlanContDetRub);
        siiItemPlanContDetRub.setSiiDetalleRubro(null);
        return siiItemPlanContDetRub;
    }

    @OneToMany(mappedBy = "siiDetalleRubroOri")
    public List<SiiModPresDetRubro> getSiiModPresDetRubroOriList() {
        return siiModPresDetRubroOriList;
    }

    public void setSiiModPresDetRubroOriList(List<SiiModPresDetRubro> siiModPresDetRubroOriList) {
        this.siiModPresDetRubroOriList = siiModPresDetRubroOriList;
    }

    public SiiModPresDetRubro addSiiModPresDetRubroOri(SiiModPresDetRubro siiModPresDetRubroOri) {
        getSiiModPresDetRubroOriList().add(siiModPresDetRubroOri);
        siiModPresDetRubroOri.setSiiDetalleRubroOri(this);
        return siiModPresDetRubroOri;
    }

    public SiiModPresDetRubro removeSiiModPresDetRubroOri(SiiModPresDetRubro siiModPresDetRubroOri) {
        getSiiModPresDetRubroOriList().remove(siiModPresDetRubroOri);
        siiModPresDetRubroOri.setSiiDetalleRubroOri(null);
        return siiModPresDetRubroOri;
    }

    @OneToMany(mappedBy = "siiDetalleRubroDest")
    public List<SiiModPresDetRubro> getSiiModPresDetRubroDestList() {
        return siiModPresDetRubroDestList;
    }

    public void setSiiModPresDetRubroDestList(List<SiiModPresDetRubro> siiModPresDetRubroDestList) {
        this.siiModPresDetRubroDestList = siiModPresDetRubroDestList;
    }
    
    public SiiModPresDetRubro addSiiModPresDetRubroDest(SiiModPresDetRubro siiModPresDetRubroDest) {
        getSiiModPresDetRubroDestList().add(siiModPresDetRubroDest);
        siiModPresDetRubroDest.setSiiDetalleRubroDest(this);
        return siiModPresDetRubroDest;
    }

    public SiiModPresDetRubro removeSiiModPresDetRubroDest(SiiModPresDetRubro siiModPresDetRubroDest) {
        getSiiModPresDetRubroDestList().remove(siiModPresDetRubroDest);
        siiModPresDetRubroDest.setSiiDetalleRubroDest(null);
        return siiModPresDetRubroDest;
    }

    @OneToMany(mappedBy = "siiDetalleRubro")
    public List<SiiSolPfcMensDetRub> getSiiSolPfcMensDetRubList() {
        return siiSolPfcMensDetRubList;
    }

    public void setSiiSolPfcMensDetRubList(List<SiiSolPfcMensDetRub> siiSolPfcMensDetRubList) {
        this.siiSolPfcMensDetRubList = siiSolPfcMensDetRubList;
    }

    public SiiSolPfcMensDetRub addSiiSolPfcMensDetRub(SiiSolPfcMensDetRub siiSolPfcMensDetRub) {
        getSiiSolPfcMensDetRubList().add(siiSolPfcMensDetRub);
        siiSolPfcMensDetRub.setSiiDetalleRubro(this);
        return siiSolPfcMensDetRub;
    }

    public SiiSolPfcMensDetRub removeSiiSolPfcMensDetRub(SiiSolPfcMensDetRub siiSolPfcMensDetRub) {
        getSiiSolPfcMensDetRubList().remove(siiSolPfcMensDetRub);
        siiSolPfcMensDetRub.setSiiDetalleRubro(null);
        return siiSolPfcMensDetRub;
    }

    @ManyToOne
    @JoinColumn(name = "FFC_CODIGO")
    public SiiFuenteFinancContab getSiiFuenteFinancContab() {
        return siiFuenteFinancContab;
    }

    public void setSiiFuenteFinancContab(SiiFuenteFinancContab siiFuenteFinancContab) {
        this.siiFuenteFinancContab = siiFuenteFinancContab;
    }

    @OneToMany(mappedBy = "siiDetalleRubro")
    public List<SiiDetRubroVigenFutura> getSiiDetRubroVigenFuturaList() {
        return siiDetRubroVigenFuturaList;
    }

    public void setSiiDetRubroVigenFuturaList(List<SiiDetRubroVigenFutura> siiDetRubroVigenFuturaList) {
        this.siiDetRubroVigenFuturaList = siiDetRubroVigenFuturaList;
    }

    public SiiDetRubroVigenFutura addSiiDetRubroVigenFutura(SiiDetRubroVigenFutura siiDetRubroVigenFutura) {
        getSiiDetRubroVigenFuturaList().add(siiDetRubroVigenFutura);
        siiDetRubroVigenFutura.setSiiDetalleRubro(this);
        return siiDetRubroVigenFutura;
    }

    public SiiDetRubroVigenFutura removeSiiDetRubroVigenFutura(SiiDetRubroVigenFutura siiDetRubroVigenFutura) {
        getSiiDetRubroVigenFuturaList().remove(siiDetRubroVigenFutura);
        siiDetRubroVigenFutura.setSiiDetalleRubro(null);
        return siiDetRubroVigenFutura;
    }
}
