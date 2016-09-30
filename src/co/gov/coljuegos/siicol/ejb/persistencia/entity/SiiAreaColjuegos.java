package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_AREA_COLJUEGOS")
public class SiiAreaColjuegos implements Serializable {
    private static final long serialVersionUID = -6768945059203949212L;
    private Long acoCodigo;
    private Long acoCodigoPadre;
    private String acoNombre;
    private String acoAbreviatura;
    private List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList5;
    private List<SiiUsuario> siiUsuarioList3;
    private List<SiiCdp> siiCdpList3;
    private List<SiiItemPlanContratac> siiItemPlanContratacList;
    private List<SiiImputacionContable> siiImputacionContableList;
    private List<SiiCuentaContTipoDocCont> siiCuentaContTipoDocContList;
    private List<SiiDetalleContNomina> siiDetalleContNominaList;
    private String acoActivo;
    private String acoDescripcion;
    private List<SiiDenuncia> siiDenunciaList;
    
    public SiiAreaColjuegos() {
    }

    public SiiAreaColjuegos(String acoAbreviatura, Long acoCodigo, Long acoCodigoPadre, String acoNombre) {
        this.acoCodigo = acoCodigo;
        this.acoCodigoPadre = acoCodigoPadre;
        this.acoNombre = acoNombre;
        this.acoAbreviatura = acoAbreviatura;
    }

    @Column(name = "ACO_ABREVIATURA", nullable = false, length = 5)
    public String getAcoAbreviatura() {
        return acoAbreviatura;
    }

    public void setAcoAbreviatura(String acoAbreviatura) {
        this.acoAbreviatura = acoAbreviatura;
    }
    
    @Id
    @Column(name = "ACO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AREA_COLJUEGOS_COD")
    @SequenceGenerator(name = "SEQ_AREA_COLJUEGOS_COD", sequenceName = "SEQ_AREA_COLJUEGOS_COD",allocationSize=1)
    public Long getAcoCodigo() {
        return acoCodigo;
    }

    public void setAcoCodigo(Long acoCodigo) {
        this.acoCodigo = acoCodigo;
    }

    @Column(name = "ACO_CODIGO_PADRE")
    public Long getAcoCodigoPadre() {
        return acoCodigoPadre;
    }

    public void setAcoCodigoPadre(Long acoCodigoPadre) {
        this.acoCodigoPadre = acoCodigoPadre;
    }


    @Column(name = "ACO_NOMBRE", nullable = false, length = 50)
    public String getAcoNombre() {
        return acoNombre;
    }

    public void setAcoNombre(String acoNombre) {
        this.acoNombre = acoNombre;
    }
    

    @OneToMany(mappedBy = "siiAreaColjuegos")
    public List<SiiSolicitudEstMercado> getSiiSolicitudEstMercadoList5() {
        return siiSolicitudEstMercadoList5;
    }

    public void setSiiSolicitudEstMercadoList5(List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList5) {
        this.siiSolicitudEstMercadoList5 = siiSolicitudEstMercadoList5;
    }

    public SiiSolicitudEstMercado addSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList5().add(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiAreaColjuegos(this);
        return siiSolicitudEstMercado;
    }

    public SiiSolicitudEstMercado removeSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList5().remove(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiAreaColjuegos(null);
        return siiSolicitudEstMercado;
    }

    @OneToMany(mappedBy = "siiAreaColjuegos1")
    public List<SiiUsuario> getSiiUsuarioList3() {
        return siiUsuarioList3;
    }

    public void setSiiUsuarioList3(List<SiiUsuario> siiUsuarioList3) {
        this.siiUsuarioList3 = siiUsuarioList3;
    }

    public SiiUsuario addSiiUsuario(SiiUsuario siiUsuario) {
        getSiiUsuarioList3().add(siiUsuario);
        siiUsuario.setSiiAreaColjuegos1(this);
        return siiUsuario;
    }

    public SiiUsuario removeSiiUsuario(SiiUsuario siiUsuario) {
        getSiiUsuarioList3().remove(siiUsuario);
        siiUsuario.setSiiAreaColjuegos1(null);
        return siiUsuario;
    }

    @OneToMany(mappedBy = "siiAreaColjuegos")
    public List<SiiCdp> getSiiCdpList3() {
        return siiCdpList3;
    }

    public void setSiiCdpList3(List<SiiCdp> siiCdpList3) {
        this.siiCdpList3 = siiCdpList3;
    }

    public SiiCdp addSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList3().add(siiCdp);
        siiCdp.setSiiAreaColjuegos(this);
        return siiCdp;
    }

    public SiiCdp removeSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList3().remove(siiCdp);
        siiCdp.setSiiAreaColjuegos(null);
        return siiCdp;
    }

    @OneToMany(mappedBy = "siiAreaColjuegos")
    public List<SiiItemPlanContratac> getSiiItemPlanContratacList() {
        return siiItemPlanContratacList;
    }

    public void setSiiItemPlanContratacList(List<SiiItemPlanContratac> siiItemPlanContratacList) {
        this.siiItemPlanContratacList = siiItemPlanContratacList;
    }

    public SiiItemPlanContratac addSiiItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) {
        getSiiItemPlanContratacList().add(siiItemPlanContratac);
        siiItemPlanContratac.setSiiAreaColjuegos(this);
        return siiItemPlanContratac;
    }

    public SiiItemPlanContratac removeSiiItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) {
        getSiiItemPlanContratacList().remove(siiItemPlanContratac);
        siiItemPlanContratac.setSiiAreaColjuegos(null);
        return siiItemPlanContratac;
    }

    @OneToMany(mappedBy = "siiAreaColjuegos")
    public List<SiiImputacionContable> getSiiImputacionContableList() {
        return siiImputacionContableList;
    }

    public void setSiiImputacionContableList(List<SiiImputacionContable> siiImputacionContableList) {
        this.siiImputacionContableList = siiImputacionContableList;
    }

    public SiiImputacionContable addSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().add(siiImputacionContable);
        siiImputacionContable.setSiiAreaColjuegos(this);
        return siiImputacionContable;
    }

    public SiiImputacionContable removeSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().remove(siiImputacionContable);
        siiImputacionContable.setSiiAreaColjuegos(null);
        return siiImputacionContable;
    }

    @OneToMany(mappedBy = "siiAreaColjuegos")
    public List<SiiCuentaContTipoDocCont> getSiiCuentaContTipoDocContList() {
        return siiCuentaContTipoDocContList;
    }

    public void setSiiCuentaContTipoDocContList(List<SiiCuentaContTipoDocCont> siiCuentaContTipoDocContList) {
        this.siiCuentaContTipoDocContList = siiCuentaContTipoDocContList;
    }

    public SiiCuentaContTipoDocCont addSiiCuentaContTipoDocCont(SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) {
        getSiiCuentaContTipoDocContList().add(siiCuentaContTipoDocCont);
        siiCuentaContTipoDocCont.setSiiAreaColjuegos(this);
        return siiCuentaContTipoDocCont;
    }

    public SiiCuentaContTipoDocCont removeSiiCuentaContTipoDocCont(SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) {
        getSiiCuentaContTipoDocContList().remove(siiCuentaContTipoDocCont);
        siiCuentaContTipoDocCont.setSiiAreaColjuegos(null);
        return siiCuentaContTipoDocCont;
    }

    @OneToMany(mappedBy = "siiAreaColjuegos")
    public List<SiiDetalleContNomina> getSiiDetalleContNominaList() {
        return siiDetalleContNominaList;
    }

    public void setSiiDetalleContNominaList(List<SiiDetalleContNomina> siiDetalleContNominaList) {
        this.siiDetalleContNominaList = siiDetalleContNominaList;
    }

    public SiiDetalleContNomina addSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().add(siiDetalleContNomina);
        siiDetalleContNomina.setSiiAreaColjuegos(this);
        return siiDetalleContNomina;
    }

    public SiiDetalleContNomina removeSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().remove(siiDetalleContNomina);
        siiDetalleContNomina.setSiiAreaColjuegos(null);
        return siiDetalleContNomina;
    }

    @Column(name = "ACO_ACTIVO", nullable = false, length = 20)
    public String getAcoActivo() {
        return acoActivo;
    }

    public void setAcoActivo(String acoActivo) {
        this.acoActivo = acoActivo;
    }
    
    @Column(name = "ACO_DESCRIPCION", nullable = false, length = 50)
    public String getAcoDescripcion() {
        return acoDescripcion;
    }
    
    public void setAcoDescripcion(String acoDescripcion) {
        this.acoDescripcion = acoDescripcion;
    }
    
    @OneToMany(mappedBy = "siiAreaColjuegos")
    public List<SiiDenuncia> getSiiDenunciaList() {
        return siiDenunciaList;
    }

    public void setSiiDenunciaList(List<SiiDenuncia> siiDenunciaList) {
        this.siiDenunciaList = siiDenunciaList;
    }

    public SiiDenuncia addSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaList().add(siiDenuncia);
        siiDenuncia.setSiiAreaColjuegos(this);
        return siiDenuncia;
    }

    public SiiDenuncia removeSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaList().remove(siiDenuncia);
        siiDenuncia.setSiiAreaColjuegos(null);
        return siiDenuncia;
    }

}
