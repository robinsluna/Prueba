package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_PERSONA")
public class SiiPersona implements Serializable {
    private static final long serialVersionUID = 244893145368558408L;
    private Long perCodigo;
    private Integer perDigitoVerif;
    private String perDireccion;
    private String perEmail;
    private String perFax;
    private String perJurNombreCorto;
    private String perJurNombreLargo;
    private String perNumIdentificacion;
    private String perOrigen;
    private String perPrimerApellido;
    private String perPrimerNombre;
    private String perSegundoApellido;
    private String perSegundoNombre;
    private String perTelefono;
    private String perCelular;
    private String perTipoPersona;
    private List<SiiUsuario> siiUsuarioList;
    private SiiTipoIdentificacion siiTipoIdentificacion1;
    private SiiPersona siiPersona; //Este campo es el representante legal y es entidad padre
    private List<SiiPersona> siiPersonaList;
    private List<SiiProveedor> siiProveedorList;
    private List<SiiOperador> siiOperadorList;
    private SiiUbicacion siiUbicacion1;
    private List<SiiDetalleFinanc> siiDetalleFinancList;
    private List<SiiPersonalEmpresa> siiPersonalEmpresaList1;
    private List<SiiPersonalEmpresa> siiPersonalEmpresaList2;
    private String perTelefono2;
    private List<SiiAseguradora> siiAseguradoraList;
    private SiiTipoRetencion siiTipoRetencionVentas;
    private SiiTipoRetencion siiTipoRetencionRentas;
    private List<SiiResponDianPersona> siiResponDianPersonaList;
    private List<SiiEnteTerritorial> siiEnteTerritorialList;
    private List<SiiActividadIcaPers> siiActividadIcaPersList;
    private List<SiiImputacionContable> siiImputacionContableList;
    private List<SiiCuentaContTipoDocCont> siiCuentaContTipoDocContList;
    private List<SiiPersonaCtaBanco> siiPersonaCtaBancoList;
    private List<SiiObligacionNoPresup> siiObligacionNoPresupList;
    private String perTipoProveedor;
    private List<SiiHistPersona> siiHistPersonaList;
    private List<SiiBanco> siiBancoList;
    private String perCiudadExt;
    private String perPaginaWeb;
    private String perProdServ;
    private String perObservProd;
    private List<SiiProveedorTecn> siiProveedorTecnList;
    private SiiTipoSociedad siiTipoSociedad;
    private List<SiiHitosEmpresa> siiHitosEmpresaList;
    private List<SiiDetalleContNomina> siiDetalleContNominaList;
    private String perTarjetaPro;
    private List<SiiObligacion> siiObligacionBeneficList;
    private List<SiiDocumentoRadicado> siiDocumentoRadicadoList;
    private List<SiiBeneficiarioEnte> siiBeneficiarioEnteList;
    private List<SiiSolicitudAutoriza> siiSolicitudAutorizaList;
    private String perRifaPromo;
    private Date perFechaCrea;
    private String perEstampUnal;
    private List<SiiObligacionConcepto> siiObligacionConceptoBenefAfpList;
    private List<SiiObligacionConcepto> siiObligacionConceptoBenefAfcList;
    private List<SiiFiscalizadorSustanc> siiFiscalizadorSustancList;
    private List<SiiConsolidadoDist> siiConsolidadoDistList;
    private List<SiiSustanciadorAuditor> siiSustanciadorAuditorList;
    private Integer perPlazo;
    private List<SiiEmpresaDestruye> siiEmpresaDestruyeList;
    private List<SiiOrdenPago> siiOrdenPagoEndosoList;
    private List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmList;
    private List<SiiDireccionPersona> siiDireccionPersonaList;
    private List<SiiPersonaInvestProIle> siiPersonaInvestProIleList;
    private List<SiiInhabilidadPersona> siiInhabilidadPersonaList;
    private String perCargaLiqActAdm;
    private List<SiiCuentasContables> siiCuentasContablesList;
    private String perActivo;

    public SiiPersona() {
    }

    public SiiPersona(String perCelular, Long perCodigo, String perDireccion, String perEmail, String perFax,
                      String perJurNombreCorto, String perJurNombreLargo, String perNumIdentificacion,
                      String perPrimerApellido, String perPrimerNombre, String perSegundoApellido,
                      String perSegundoNombre, String perTelefono, String perTipoPersona,
                      SiiTipoIdentificacion siiTipoIdentificacion1, Integer perDigitoVerif,
					  SiiUbicacion siiUbicacion1, String perOrigen, String perTelefono2) {
        this.perCelular = perCelular;
        this.perCodigo = perCodigo;
        this.perDireccion = perDireccion;
        this.perEmail = perEmail;
        this.perFax = perFax;
        this.perJurNombreCorto = perJurNombreCorto;
        this.perJurNombreLargo = perJurNombreLargo;
        this.perNumIdentificacion = perNumIdentificacion;
        this.perOrigen = perOrigen;
        this.perPrimerApellido = perPrimerApellido;
        this.perPrimerNombre = perPrimerNombre;
        this.perSegundoApellido = perSegundoApellido;
        this.perSegundoNombre = perSegundoNombre;
        this.perTelefono = perTelefono;
        this.perTelefono2 = perTelefono2;
        this.perTipoPersona = perTipoPersona;
        this.siiTipoIdentificacion1 = siiTipoIdentificacion1;
        this.perDigitoVerif = perDigitoVerif;
        this.siiUbicacion1 = siiUbicacion1;

    }

    @Column(name = "PER_CELULAR", length = 50)
    public String getPerCelular() {
        return perCelular;
    }

    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }

    @Column(name = "PER_CIUDAD_EXT", length = 200)
    public String getPerCiudadExt() {
        return perCiudadExt;
    }

    public void setPerCiudadExt(String perCiudadExt) {
        this.perCiudadExt = perCiudadExt;
    }

    @Id
    @Column(name = "PER_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PERSONA_CODIGO")
    @SequenceGenerator(name = "SEQ_PERSONA_CODIGO", sequenceName = "SEQ_PERSONA_CODIGO",allocationSize=1)
    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }


    @Column(name = "PER_DIGITO_VERIF")
    public Integer getPerDigitoVerif() {
        return perDigitoVerif;
    }

    public void setPerDigitoVerif(Integer perDigitoVerif) {
        this.perDigitoVerif = perDigitoVerif;
    }

    @Column(name = "PER_DIRECCION", length = 100)
    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    @Column(name = "PER_EMAIL", length = 50)
    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    @Column(name = "PER_FAX", length = 20)
    public String getPerFax() {
        return perFax;
    }

    public void setPerFax(String perFax) {
        this.perFax = perFax;
    }

    @Column(name = "PER_JUR_NOMBRE_CORTO", length = 50)
    public String getPerJurNombreCorto() {
        return perJurNombreCorto;
    }

    public void setPerJurNombreCorto(String perJurNombreCorto) {
        this.perJurNombreCorto = perJurNombreCorto;
    }

    @Column(name = "PER_JUR_NOMBRE_LARGO", length = 100)
    public String getPerJurNombreLargo() {
        return perJurNombreLargo;
    }

    public void setPerJurNombreLargo(String perJurNombreLargo) {
        this.perJurNombreLargo = perJurNombreLargo;
    }

    @Column(name = "PER_NUM_IDENTIFICACION", nullable = false, length = 20)
    public String getPerNumIdentificacion() {
        return perNumIdentificacion;
    }

    public void setPerNumIdentificacion(String perNumIdentificacion) {
        this.perNumIdentificacion = perNumIdentificacion;
    }

    @Column(name = "PER_OBSERV_PROD", length = 1000)
    public String getPerObservProd() {
        return perObservProd;
    }

    public void setPerObservProd(String perObservProd) {
        this.perObservProd = perObservProd;
    }

    @Column(name = "PER_ORIGEN", length = 1)
    public String getPerOrigen() {
        return perOrigen;
    }

    public void setPerOrigen(String perOrigen) {
        this.perOrigen = perOrigen;
    }

    @Column(name = "PER_PAGINA_WEB", length = 100)
    public String getPerPaginaWeb() {
        return perPaginaWeb;
    }

    public void setPerPaginaWeb(String perPaginaWeb) {
        this.perPaginaWeb = perPaginaWeb;
    }

    @Column(name = "PER_PRIMER_APELLIDO", length = 20)
    public String getPerPrimerApellido() {
        return perPrimerApellido;
    }

    public void setPerPrimerApellido(String perPrimerApellido) {
        this.perPrimerApellido = perPrimerApellido;
    }

    @Column(name = "PER_PRIMER_NOMBRE", length = 20)
    public String getPerPrimerNombre() {
        return perPrimerNombre;
    }

    public void setPerPrimerNombre(String perPrimerNombre) {
        this.perPrimerNombre = perPrimerNombre;
    }

    @Column(name = "PER_PROD_SERV", length = 100)
    public String getPerProdServ() {
        return perProdServ;
    }

    public void setPerProdServ(String perProdServ) {
        this.perProdServ = perProdServ;
    }

    @Column(name = "PER_SEGUNDO_APELLIDO", length = 20)
    public String getPerSegundoApellido() {
        return perSegundoApellido;
    }

    public void setPerSegundoApellido(String perSegundoApellido) {
        this.perSegundoApellido = perSegundoApellido;
    }

    @Column(name = "PER_SEGUNDO_NOMBRE", length = 20)
    public String getPerSegundoNombre() {
        return perSegundoNombre;
    }

    public void setPerSegundoNombre(String perSegundoNombre) {
        this.perSegundoNombre = perSegundoNombre;
    }

    @Column(name = "PER_TELEFONO", length = 20)
    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    @Column(name = "PER_TELEFONO2", length = 20)
    public String getPerTelefono2() {
        return perTelefono2;
    }

    public void setPerTelefono2(String perTelefono2) {
        this.perTelefono2 = perTelefono2;
    }

    @Column(name = "PER_TIPO_PERSONA", nullable = false, length = 1)
    public String getPerTipoPersona() {
        return perTipoPersona;
    }

    public void setPerTipoPersona(String perTipoPersona) {
        this.perTipoPersona = perTipoPersona;
    }


    @OneToMany(mappedBy = "siiPersona")
    public List<SiiUsuario> getSiiUsuarioList() {
        return siiUsuarioList;
    }

    public void setSiiUsuarioList(List<SiiUsuario> siiUsuarioList) {
        this.siiUsuarioList = siiUsuarioList;
    }

    public SiiUsuario addSiiUsuario(SiiUsuario siiUsuario) {
        getSiiUsuarioList().add(siiUsuario);
        siiUsuario.setSiiPersona(this);
        return siiUsuario;
    }

    public SiiUsuario removeSiiUsuario(SiiUsuario siiUsuario) {
        getSiiUsuarioList().remove(siiUsuario);
        siiUsuario.setSiiPersona(null);
        return siiUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "TID_CODIGO")
    public SiiTipoIdentificacion getSiiTipoIdentificacion1() {
        return siiTipoIdentificacion1;
    }

    public void setSiiTipoIdentificacion1(SiiTipoIdentificacion siiTipoIdentificacion1) {
        this.siiTipoIdentificacion1 = siiTipoIdentificacion1;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO_REPRESENTANTE")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiPersona> getSiiPersonaList() {
        return siiPersonaList;
    }

    public void setSiiPersonaList(List<SiiPersona> siiPersonaList) {
        this.siiPersonaList = siiPersonaList;
    }

    public SiiPersona addSiiPersona(SiiPersona siiPersona) {
        getSiiPersonaList().add(siiPersona);
        siiPersona.setSiiPersona(this);
        return siiPersona;
    }

    public SiiPersona removeSiiPersona(SiiPersona siiPersona) {
        getSiiPersonaList().remove(siiPersona);
        siiPersona.setSiiPersona(null);
        return siiPersona;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiProveedor> getSiiProveedorList() {
        return siiProveedorList;
    }

    public void setSiiProveedorList(List<SiiProveedor> siiProveedorList) {
        this.siiProveedorList = siiProveedorList;
    }

	public SiiProveedor addSiiProveedor(SiiProveedor siiProveedor) {
        getSiiProveedorList().add(siiProveedor);
        siiProveedor.setSiiPersona(this);
        return siiProveedor;
    }

    public SiiProveedor removeSiiProveedor(SiiProveedor siiProveedor) {
        getSiiProveedorList().remove(siiProveedor);
        siiProveedor.setSiiPersona(null);
        return siiProveedor;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiOperador> getSiiOperadorList() {
        return siiOperadorList;
    }

    public void setSiiOperadorList(List<SiiOperador> siiOperadorList) {
        this.siiOperadorList = siiOperadorList;
    }

    public SiiOperador addSiiOperador(SiiOperador siiOperador) {
        getSiiOperadorList().add(siiOperador);
        siiOperador.setSiiPersona(this);
        return siiOperador;
    }

    public SiiOperador removeSiiOperador(SiiOperador siiOperador) {
        getSiiOperadorList().remove(siiOperador);
        siiOperador.setSiiPersona(null);
        return siiOperador;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO")
    public SiiUbicacion getSiiUbicacion1() {
        return siiUbicacion1;
    }

    public void setSiiUbicacion1(SiiUbicacion siiUbicacion1) {
        this.siiUbicacion1 = siiUbicacion1;
    }

    @OneToMany(mappedBy = "siiPersona2")
    public List<SiiDetalleFinanc> getSiiDetalleFinancList() {
        return siiDetalleFinancList;
    }

    public void setSiiDetalleFinancList(List<SiiDetalleFinanc> siiDetalleFinancList) {
        this.siiDetalleFinancList = siiDetalleFinancList;
    }

    public SiiDetalleFinanc addSiiDetalleFinanc(SiiDetalleFinanc siiDetalleFinanc) {
        getSiiDetalleFinancList().add(siiDetalleFinanc);
        siiDetalleFinanc.setSiiPersona2(this);
        return siiDetalleFinanc;
    }

    public SiiDetalleFinanc removeSiiDetalleFinanc(SiiDetalleFinanc siiDetalleFinanc) {
        getSiiDetalleFinancList().remove(siiDetalleFinanc);
        siiDetalleFinanc.setSiiPersona2(null);
        return siiDetalleFinanc;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiPersonalEmpresa> getSiiPersonalEmpresaList1() {
        return siiPersonalEmpresaList1;
    }

    public void setSiiPersonalEmpresaList1(List<SiiPersonalEmpresa> siiPersonalEmpresaList1) {
        this.siiPersonalEmpresaList1 = siiPersonalEmpresaList1;
    }

    public SiiPersonalEmpresa addSiiPersonalEmpresa(SiiPersonalEmpresa siiPersonalEmpresa) {
        getSiiPersonalEmpresaList1().add(siiPersonalEmpresa);
        siiPersonalEmpresa.setSiiPersona(this);
        return siiPersonalEmpresa;
    }

    public SiiPersonalEmpresa removeSiiPersonalEmpresa(SiiPersonalEmpresa siiPersonalEmpresa) {
        getSiiPersonalEmpresaList1().remove(siiPersonalEmpresa);
        siiPersonalEmpresa.setSiiPersona(null);
        return siiPersonalEmpresa;
    }

    @OneToMany(mappedBy = "siiPersona3")
    public List<SiiPersonalEmpresa> getSiiPersonalEmpresaList2() {
        return siiPersonalEmpresaList2;
    }

    public void setSiiPersonalEmpresaList2(List<SiiPersonalEmpresa> siiPersonalEmpresaList2) {
        this.siiPersonalEmpresaList2 = siiPersonalEmpresaList2;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiAseguradora> getSiiAseguradoraList() {
        return siiAseguradoraList;
    }

    public void setSiiAseguradoraList(List<SiiAseguradora> siiAseguradoraList) {
        this.siiAseguradoraList = siiAseguradoraList;
    }

    public SiiAseguradora addSiiAseguradora(SiiAseguradora siiAseguradora) {
        getSiiAseguradoraList().add(siiAseguradora);
        siiAseguradora.setSiiPersona(this);
        return siiAseguradora;
    }

    public SiiAseguradora removeSiiAseguradora(SiiAseguradora siiAseguradora) {
        getSiiAseguradoraList().remove(siiAseguradora);
        siiAseguradora.setSiiPersona(null);
        return siiAseguradora;
    }


    @OneToMany(mappedBy = "siiPersona")
    public List<SiiResponDianPersona> getSiiResponDianPersonaList() {
        return siiResponDianPersonaList;
    }

    public void setSiiResponDianPersonaList(List<SiiResponDianPersona> siiResponDianPersonaList) {
        this.siiResponDianPersonaList = siiResponDianPersonaList;
    }

    public SiiResponDianPersona addSiiResponDianPersona(SiiResponDianPersona siiResponDianPersona) {
        getSiiResponDianPersonaList().add(siiResponDianPersona);
        siiResponDianPersona.setSiiPersona(this);
        return siiResponDianPersona;
    }

    public SiiResponDianPersona removeSiiResponDianPersona(SiiResponDianPersona siiResponDianPersona) {
        getSiiResponDianPersonaList().remove(siiResponDianPersona);
        siiResponDianPersona.setSiiPersona(null);
        return siiResponDianPersona;
    }

    @ManyToOne
    @JoinColumn(name = "TRE_CODIGO_VENTAS")
    public SiiTipoRetencion getSiiTipoRetencionVentas() {
        return siiTipoRetencionVentas;
    }

    public void setSiiTipoRetencionVentas(SiiTipoRetencion siiTipoRetencionVentas) {
        this.siiTipoRetencionVentas = siiTipoRetencionVentas;
    }

    @ManyToOne
    @JoinColumn(name = "TRE_CODIGO_RENTA")
    public SiiTipoRetencion getSiiTipoRetencionRentas() {
        return siiTipoRetencionRentas;
    }

    public void setSiiTipoRetencionRentas(SiiTipoRetencion siiTipoRetencionRentas) {
        this.siiTipoRetencionRentas = siiTipoRetencionRentas;
    }


    @OneToMany(mappedBy = "siiPersona")
    public List<SiiEnteTerritorial> getSiiEnteTerritorialList() {
        return siiEnteTerritorialList;
    }

    public void setSiiEnteTerritorialList(List<SiiEnteTerritorial> siiEnteTerritorialList) {
        this.siiEnteTerritorialList = siiEnteTerritorialList;
    }

    public SiiEnteTerritorial addSiiEnteTerritorial(SiiEnteTerritorial siiEnteTerritorial) {
        getSiiEnteTerritorialList().add(siiEnteTerritorial);
        siiEnteTerritorial.setSiiPersona(this);
        return siiEnteTerritorial;
    }

    public SiiEnteTerritorial removeSiiEnteTerritorial(SiiEnteTerritorial siiEnteTerritorial) {
        getSiiEnteTerritorialList().remove(siiEnteTerritorial);
        siiEnteTerritorial.setSiiPersona(null);
        return siiEnteTerritorial;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiActividadIcaPers> getSiiActividadIcaPersList() {
        return siiActividadIcaPersList;
    }

    public void setSiiActividadIcaPersList(List<SiiActividadIcaPers> siiActividadIcaPersList) {
        this.siiActividadIcaPersList = siiActividadIcaPersList;
    }

    public SiiActividadIcaPers addSiiActividadIcaPers(SiiActividadIcaPers siiActividadIcaPers) {
        getSiiActividadIcaPersList().add(siiActividadIcaPers);
        siiActividadIcaPers.setSiiPersona(this);
        return siiActividadIcaPers;
    }

    public SiiActividadIcaPers removeSiiActividadIcaPers(SiiActividadIcaPers siiActividadIcaPers) {
        getSiiActividadIcaPersList().remove(siiActividadIcaPers);
        siiActividadIcaPers.setSiiPersona(null);
        return siiActividadIcaPers;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiImputacionContable> getSiiImputacionContableList() {
        return siiImputacionContableList;
    }

    public void setSiiImputacionContableList(List<SiiImputacionContable> siiImputacionContableList) {
        this.siiImputacionContableList = siiImputacionContableList;
    }

    public SiiImputacionContable addSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().add(siiImputacionContable);
        siiImputacionContable.setSiiPersona(this);
        return siiImputacionContable;
    }

    public SiiImputacionContable removeSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().remove(siiImputacionContable);
        siiImputacionContable.setSiiPersona(null);
        return siiImputacionContable;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiCuentaContTipoDocCont> getSiiCuentaContTipoDocContList() {
        return siiCuentaContTipoDocContList;
    }

    public void setSiiCuentaContTipoDocContList(List<SiiCuentaContTipoDocCont> siiCuentaContTipoDocContList) {
        this.siiCuentaContTipoDocContList = siiCuentaContTipoDocContList;
    }

    public SiiCuentaContTipoDocCont addSiiCuentaContTipoDocCont(SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) {
        getSiiCuentaContTipoDocContList().add(siiCuentaContTipoDocCont);
        siiCuentaContTipoDocCont.setSiiPersona(this);
        return siiCuentaContTipoDocCont;
    }

    public SiiCuentaContTipoDocCont removeSiiCuentaContTipoDocCont(SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) {
        getSiiCuentaContTipoDocContList().remove(siiCuentaContTipoDocCont);
        siiCuentaContTipoDocCont.setSiiPersona(null);
        return siiCuentaContTipoDocCont;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiPersonaCtaBanco> getSiiPersonaCtaBancoList() {
        return siiPersonaCtaBancoList;
    }

    public void setSiiPersonaCtaBancoList(List<SiiPersonaCtaBanco> siiPersonaCtaBancoList) {
        this.siiPersonaCtaBancoList = siiPersonaCtaBancoList;
    }

    public SiiPersonaCtaBanco addSiiPersonaCtaBanco(SiiPersonaCtaBanco siiPersonaCtaBanco) {
        getSiiPersonaCtaBancoList().add(siiPersonaCtaBanco);
        siiPersonaCtaBanco.setSiiPersona(this);
        return siiPersonaCtaBanco;
    }

    public SiiPersonaCtaBanco removeSiiPersonaCtaBanco(SiiPersonaCtaBanco siiPersonaCtaBanco) {
        getSiiPersonaCtaBancoList().remove(siiPersonaCtaBanco);
        siiPersonaCtaBanco.setSiiPersona(null);
        return siiPersonaCtaBanco;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiObligacionNoPresup> getSiiObligacionNoPresupList() {
        return siiObligacionNoPresupList;
    }

    public void setSiiObligacionNoPresupList(List<SiiObligacionNoPresup> siiObligacionNoPresupList) {
        this.siiObligacionNoPresupList = siiObligacionNoPresupList;
    }

    public SiiObligacionNoPresup addSiiObligacionNoPresup(SiiObligacionNoPresup siiObligacionNoPresup) {
        getSiiObligacionNoPresupList().add(siiObligacionNoPresup);
        siiObligacionNoPresup.setSiiPersona(this);
        return siiObligacionNoPresup;
    }

    public SiiObligacionNoPresup removeSiiObligacionNoPresup(SiiObligacionNoPresup siiObligacionNoPresup) {
        getSiiObligacionNoPresupList().remove(siiObligacionNoPresup);
        siiObligacionNoPresup.setSiiPersona(null);
        return siiObligacionNoPresup;
    }

    @Column(name = "PER_TIPO_PROVEEDOR", length = 1)
    public String getPerTipoProveedor() {
        return perTipoProveedor;
    }

    public void setPerTipoProveedor(String perTipoProveedor) {
        this.perTipoProveedor = perTipoProveedor;
    }

    @OneToMany(mappedBy = "siiPersonaOrigen")
    public List<SiiHistPersona> getSiiHistPersonaList() {
        return siiHistPersonaList;
    }

    public void setSiiHistPersonaList(List<SiiHistPersona> siiHistPersonaList) {
        this.siiHistPersonaList = siiHistPersonaList;
    }

    public SiiHistPersona addSiiHistPersona(SiiHistPersona siiHistPersona) {
        getSiiHistPersonaList().add(siiHistPersona);
        siiHistPersona.setSiiPersonaOrigen(this);
        return siiHistPersona;
    }

    public SiiHistPersona removeSiiHistPersona(SiiHistPersona siiHistPersona) {
        getSiiHistPersonaList().remove(siiHistPersona);
        siiHistPersona.setSiiPersonaOrigen(null);
        return siiHistPersona;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiBanco> getSiiBancoList() {
        return siiBancoList;
    }

    public void setSiiBancoList(List<SiiBanco> siiBancoList) {
        this.siiBancoList = siiBancoList;
    }

    public SiiBanco addSiiBanco(SiiBanco siiBanco) {
        getSiiBancoList().add(siiBanco);
        siiBanco.setSiiPersona(this);
        return siiBanco;
    }

    public SiiBanco removeSiiBanco(SiiBanco siiBanco) {
        getSiiBancoList().remove(siiBanco);
        siiBanco.setSiiPersona(null);
        return siiBanco;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiProveedorTecn> getSiiProveedorTecnList() {
        return siiProveedorTecnList;
    }

    public void setSiiProveedorTecnList(List<SiiProveedorTecn> siiProveedorTecnList) {
        this.siiProveedorTecnList = siiProveedorTecnList;
    }

    public SiiProveedorTecn addSiiProveedorTecn(SiiProveedorTecn siiProveedorTecn) {
        getSiiProveedorTecnList().add(siiProveedorTecn);
        siiProveedorTecn.setSiiPersona(this);
        return siiProveedorTecn;
    }

    public SiiProveedorTecn removeSiiProveedorTecn(SiiProveedorTecn siiProveedorTecn) {
        getSiiProveedorTecnList().remove(siiProveedorTecn);
        siiProveedorTecn.setSiiPersona(null);
        return siiProveedorTecn;
    }

    @ManyToOne
    @JoinColumn(name = "TSO_CODIGO")
    public SiiTipoSociedad getSiiTipoSociedad() {
        return siiTipoSociedad;
    }

    public void setSiiTipoSociedad(SiiTipoSociedad siiTipoSociedad) {
        this.siiTipoSociedad = siiTipoSociedad;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiHitosEmpresa> getSiiHitosEmpresaList() {
        return siiHitosEmpresaList;
    }

    public void setSiiHitosEmpresaList(List<SiiHitosEmpresa> siiHitosEmpresaList) {
        this.siiHitosEmpresaList = siiHitosEmpresaList;
    }

    public SiiHitosEmpresa addSiiHitosEmpresa(SiiHitosEmpresa siiHitosEmpresa) {
        getSiiHitosEmpresaList().add(siiHitosEmpresa);
        siiHitosEmpresa.setSiiPersona(this);
        return siiHitosEmpresa;
    }

    public SiiHitosEmpresa removeSiiHitosEmpresa(SiiHitosEmpresa siiHitosEmpresa) {
        getSiiHitosEmpresaList().remove(siiHitosEmpresa);
        siiHitosEmpresa.setSiiPersona(null);
        return siiHitosEmpresa;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiDetalleContNomina> getSiiDetalleContNominaList() {
        return siiDetalleContNominaList;
    }

    public void setSiiDetalleContNominaList(List<SiiDetalleContNomina> siiDetalleContNominaList) {
        this.siiDetalleContNominaList = siiDetalleContNominaList;
    }

    public SiiDetalleContNomina addSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().add(siiDetalleContNomina);
        siiDetalleContNomina.setSiiPersona(this);
        return siiDetalleContNomina;
    }

    public SiiDetalleContNomina removeSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().remove(siiDetalleContNomina);
        siiDetalleContNomina.setSiiPersona(null);
        return siiDetalleContNomina;
    }

    @Column(name = "PER_TARJETA_PRO", length = 20)
    public String getPerTarjetaPro() {
        return perTarjetaPro;
    }

    public void setPerTarjetaPro(String perTarjetaPro) {
        this.perTarjetaPro = perTarjetaPro;
    }

    @OneToMany(mappedBy = "siiPersonaBenefic")
    public List<SiiObligacion> getSiiObligacionBeneficList() {
        return siiObligacionBeneficList;
    }

    public void setSiiObligacionBeneficList(List<SiiObligacion> siiObligacionBeneficList) {
        this.siiObligacionBeneficList = siiObligacionBeneficList;
    }

    public SiiObligacion addSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionBeneficList().add(siiObligacion);
        siiObligacion.setSiiPersonaBenefic(this);
        return siiObligacion;
    }

    public SiiObligacion removeSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionBeneficList().remove(siiObligacion);
        siiObligacion.setSiiPersonaBenefic(null);
        return siiObligacion;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiDocumentoRadicado> getSiiDocumentoRadicadoList() {
        return siiDocumentoRadicadoList;
    }

    public void setSiiDocumentoRadicadoList(List<SiiDocumentoRadicado> siiDocumentoRadicadoList) {
        this.siiDocumentoRadicadoList = siiDocumentoRadicadoList;
    }

    public SiiDocumentoRadicado addSiiDocumentoRadicado(SiiDocumentoRadicado siiDocumentoRadicado) {
        getSiiDocumentoRadicadoList().add(siiDocumentoRadicado);
        siiDocumentoRadicado.setSiiPersona(this);
        return siiDocumentoRadicado;
    }

    public SiiDocumentoRadicado removeSiiDocumentoRadicado(SiiDocumentoRadicado siiDocumentoRadicado) {
        getSiiDocumentoRadicadoList().remove(siiDocumentoRadicado);
        siiDocumentoRadicado.setSiiPersona(null);
        return siiDocumentoRadicado;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiBeneficiarioEnte> getSiiBeneficiarioEnteList() {
        return siiBeneficiarioEnteList;
    }

    public void setSiiBeneficiarioEnteList(List<SiiBeneficiarioEnte> siiBeneficiarioEnteList) {
        this.siiBeneficiarioEnteList = siiBeneficiarioEnteList;
    }

    public SiiBeneficiarioEnte addSiiBeneficiarioEnte(SiiBeneficiarioEnte siiBeneficiarioEnte) {
        getSiiBeneficiarioEnteList().add(siiBeneficiarioEnte);
        siiBeneficiarioEnte.setSiiPersona(this);
        return siiBeneficiarioEnte;
    }

    public SiiBeneficiarioEnte removeSiiBeneficiarioEnte(SiiBeneficiarioEnte siiBeneficiarioEnte) {
        getSiiBeneficiarioEnteList().remove(siiBeneficiarioEnte);
        siiBeneficiarioEnte.setSiiPersona(null);
        return siiBeneficiarioEnte;
    }

    @OneToMany(mappedBy = "siiPersonaRifaProm")
    public List<SiiSolicitudAutoriza> getSiiSolicitudAutorizaList() {
        return siiSolicitudAutorizaList;
    }

    public void setSiiSolicitudAutorizaList(List<SiiSolicitudAutoriza> siiSolicitudAutorizaList) {
        this.siiSolicitudAutorizaList = siiSolicitudAutorizaList;
    }

    public SiiSolicitudAutoriza addSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().add(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiPersonaRifaProm(this);
        return siiSolicitudAutoriza;
    }

    public SiiSolicitudAutoriza removeSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().remove(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiPersonaRifaProm(null);
        return siiSolicitudAutoriza;
    }

    @Column(name = "PER_RIFA_PROMO", length = 1)
    public String getPerRifaPromo() {
        return perRifaPromo;
    }

    public void setPerRifaPromo(String perRifaPromo) {
        this.perRifaPromo = perRifaPromo;
    }

    @Column(name = "PER_CARGA_LIQ_ACT_ADM", length = 1)
    public String getPerCargaLiqActAdm() {
        return perCargaLiqActAdm;
    }
    
    public void setPerCargaLiqActAdm(String perCargaLiqActAdm) {
        this.perCargaLiqActAdm = perCargaLiqActAdm;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PER_FECHA_CREA", nullable = false)
    public Date getPerFechaCrea() {
        return perFechaCrea;
    }

    public void setPerFechaCrea(Date perFechaCrea) {
        this.perFechaCrea = perFechaCrea;
    }
    
    @Column(name = "PER_ESTAMP_UNAL", length = 1)
    public String getPerEstampUnal() {
        return perEstampUnal;
    }

    public void setPerEstampUnal(String perEstampUnal) {
        this.perEstampUnal = perEstampUnal;
    }

    @OneToMany(mappedBy = "siiPersonaBenefAfp")
    public List<SiiObligacionConcepto> getSiiObligacionConceptoBenefAfpList() {
        return siiObligacionConceptoBenefAfpList;
    }

    public void setSiiObligacionConceptoBenefAfpList(List<SiiObligacionConcepto> siiObligacionConceptoBenefAfpList) {
        this.siiObligacionConceptoBenefAfpList = siiObligacionConceptoBenefAfpList;
    }

    public SiiObligacionConcepto addSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoBenefAfpList().add(siiObligacionConcepto);
        siiObligacionConcepto.setSiiPersonaBenefAfp(this);
        return siiObligacionConcepto;
    }

    public SiiObligacionConcepto removeSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoBenefAfpList().remove(siiObligacionConcepto);
        siiObligacionConcepto.setSiiPersonaBenefAfp(null);
        return siiObligacionConcepto;
    }

    @OneToMany(mappedBy = "siiPersonaBenefAfc")
    public List<SiiObligacionConcepto> getSiiObligacionConceptoBenefAfcList() {
        return siiObligacionConceptoBenefAfcList;
    }

    public void setSiiObligacionConceptoBenefAfcList(List<SiiObligacionConcepto> siiObligacionConceptoBenefAfcList) {
        this.siiObligacionConceptoBenefAfcList = siiObligacionConceptoBenefAfcList;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiFiscalizadorSustanc> getSiiFiscalizadorSustancList() {
        return siiFiscalizadorSustancList;
    }

    public void setSiiFiscalizadorSustancList(List<SiiFiscalizadorSustanc> siiFiscalizadorSustancList) {
        this.siiFiscalizadorSustancList = siiFiscalizadorSustancList;
    }

    public SiiFiscalizadorSustanc addSiiFiscalizadorSustanc(SiiFiscalizadorSustanc siiFiscalizadorSustanc) {
        getSiiFiscalizadorSustancList().add(siiFiscalizadorSustanc);
        siiFiscalizadorSustanc.setSiiPersona(this);
        return siiFiscalizadorSustanc;
    }

    public SiiFiscalizadorSustanc removeSiiFiscalizadorSustanc(SiiFiscalizadorSustanc siiFiscalizadorSustanc) {
        getSiiFiscalizadorSustancList().remove(siiFiscalizadorSustanc);
        siiFiscalizadorSustanc.setSiiPersona(null);
        return siiFiscalizadorSustanc;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiConsolidadoDist> getSiiConsolidadoDistList() {
        return siiConsolidadoDistList;
    }

    public void setSiiConsolidadoDistList(List<SiiConsolidadoDist> siiConsolidadoDistList) {
        this.siiConsolidadoDistList = siiConsolidadoDistList;
    }

    public SiiConsolidadoDist addSiiConsolidadoDist(SiiConsolidadoDist siiConsolidadoDist) {
        getSiiConsolidadoDistList().add(siiConsolidadoDist);
        siiConsolidadoDist.setSiiPersona(this);
        return siiConsolidadoDist;
    }

    public SiiConsolidadoDist removeSiiConsolidadoDist(SiiConsolidadoDist siiConsolidadoDist) {
        getSiiConsolidadoDistList().remove(siiConsolidadoDist);
        siiConsolidadoDist.setSiiPersona(null);
        return siiConsolidadoDist;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiSustanciadorAuditor> getSiiSustanciadorAuditorList() {
        return siiSustanciadorAuditorList;
    }

    public void setSiiSustanciadorAuditorList(List<SiiSustanciadorAuditor> siiSustanciadorAuditorList) {
        this.siiSustanciadorAuditorList = siiSustanciadorAuditorList;
    }

    public SiiSustanciadorAuditor addSiiSustanciadorAuditor(SiiSustanciadorAuditor siiSustanciadorAuditor) {
        getSiiSustanciadorAuditorList().add(siiSustanciadorAuditor);
        siiSustanciadorAuditor.setSiiPersona(this);
        return siiSustanciadorAuditor;
    }

    public SiiSustanciadorAuditor removeSiiSustanciadorAuditor(SiiSustanciadorAuditor siiSustanciadorAuditor) {
        getSiiSustanciadorAuditorList().remove(siiSustanciadorAuditor);
        siiSustanciadorAuditor.setSiiPersona(null);
        return siiSustanciadorAuditor;
    }

    @Column(name = "PER_PLAZO")
    public Integer getPerPlazo() {
        return perPlazo;
    }

    public void setPerPlazo(Integer perPlazo) {
        this.perPlazo = perPlazo;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiEmpresaDestruye> getSiiEmpresaDestruyeList(){
        return siiEmpresaDestruyeList;
    }

    public void setSiiEmpresaDestruyeList(List<SiiEmpresaDestruye> siiEmpresaDestruyeList){
        this.siiEmpresaDestruyeList = siiEmpresaDestruyeList;
    }

    public SiiEmpresaDestruye addSiiEmpresaDestruye(SiiEmpresaDestruye siiEmpresaDestruye){
        getSiiEmpresaDestruyeList().add(siiEmpresaDestruye);
        siiEmpresaDestruye.setSiiPersona(this);
        return siiEmpresaDestruye;
    }

    public SiiEmpresaDestruye removeSiiEmpresaDestruye(SiiEmpresaDestruye siiEmpresaDestruye){
        getSiiEmpresaDestruyeList().remove(siiEmpresaDestruye);
        siiEmpresaDestruye.setSiiPersona(null);
        return siiEmpresaDestruye;
    }

    @OneToMany(mappedBy = "siiPersonaEndoso")
    public List<SiiOrdenPago> getSiiOrdenPagoEndosoList() {
        return siiOrdenPagoEndosoList;
    }

    public void setSiiOrdenPagoEndosoList(List<SiiOrdenPago> siiOrdenPagoEndosoList) {
        this.siiOrdenPagoEndosoList = siiOrdenPagoEndosoList;
    }

    public SiiOrdenPago addSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoEndosoList().add(siiOrdenPago);
        siiOrdenPago.setSiiPersonaEndoso(this);
        return siiOrdenPago;
    }

    public SiiOrdenPago removeSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoEndosoList().remove(siiOrdenPago);
        siiOrdenPago.setSiiPersonaEndoso(null);
        return siiOrdenPago;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiCargaActuacionesAdm> getSiiCargaActuacionesAdmList() {
        return siiCargaActuacionesAdmList;
    }

    public void setSiiCargaActuacionesAdmList(List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmList) {
        this.siiCargaActuacionesAdmList = siiCargaActuacionesAdmList;
    }

    public SiiCargaActuacionesAdm addSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmList().add(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiPersona(this);
        return siiCargaActuacionesAdm;
    }

    public SiiCargaActuacionesAdm removeSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmList().remove(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiPersona(null);
        return siiCargaActuacionesAdm;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiDireccionPersona> getSiiDireccionPersonaList() {
        return siiDireccionPersonaList;
    }

    public void setSiiDireccionPersonaList(List<SiiDireccionPersona> siiDireccionPersonaList) {
        this.siiDireccionPersonaList = siiDireccionPersonaList;
    }

    public SiiDireccionPersona addSiiDireccionPersona(SiiDireccionPersona siiDireccionPersona) {
        getSiiDireccionPersonaList().add(siiDireccionPersona);
        siiDireccionPersona.setSiiPersona(this);
        return siiDireccionPersona;
    }

    public SiiDireccionPersona removeSiiDireccionPersona(SiiDireccionPersona siiDireccionPersona) {
        getSiiDireccionPersonaList().remove(siiDireccionPersona);
        siiDireccionPersona.setSiiPersona(null);
        return siiDireccionPersona;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiPersonaInvestProIle> getSiiPersonaInvestProIleList() {
        return siiPersonaInvestProIleList;
    }

    public void setSiiPersonaInvestProIleList(List<SiiPersonaInvestProIle> siiPersonaInvestProIleList) {
        this.siiPersonaInvestProIleList = siiPersonaInvestProIleList;
    }

    public SiiPersonaInvestProIle addSiiPersonaInvestProIle(SiiPersonaInvestProIle siiPersonaInvestProIle) {
        getSiiPersonaInvestProIleList().add(siiPersonaInvestProIle);
        siiPersonaInvestProIle.setSiiPersona(this);
        return siiPersonaInvestProIle;
    }

    public SiiPersonaInvestProIle removeSiiPersonaInvestProIle(SiiPersonaInvestProIle siiPersonaInvestProIle) {
        getSiiPersonaInvestProIleList().remove(siiPersonaInvestProIle);
        siiPersonaInvestProIle.setSiiPersona(null);
        return siiPersonaInvestProIle;
    }

    @OneToMany(mappedBy = "siiPersona")
    public List<SiiInhabilidadPersona> getSiiInhabilidadPersonaList() {
        return siiInhabilidadPersonaList;
    }

    public void setSiiInhabilidadPersonaList(List<SiiInhabilidadPersona> siiInhabilidadPersonaList) {
        this.siiInhabilidadPersonaList = siiInhabilidadPersonaList;
    }

    public SiiInhabilidadPersona addSiiInhabilidadPersona(SiiInhabilidadPersona siiInhabilidadPersona) {
        getSiiInhabilidadPersonaList().add(siiInhabilidadPersona);
        siiInhabilidadPersona.setSiiPersona(this);
        return siiInhabilidadPersona;
    }

    public SiiInhabilidadPersona removeSiiInhabilidadPersona(SiiInhabilidadPersona siiInhabilidadPersona) {
        getSiiInhabilidadPersonaList().remove(siiInhabilidadPersona);
        siiInhabilidadPersona.setSiiPersona(null);
        return siiInhabilidadPersona;
    }

    @OneToMany(mappedBy = "siiPersonaCancSaldo")
    public List<SiiCuentasContables> getSiiCuentasContablesList() {
        return siiCuentasContablesList;
    }

    public void setSiiCuentasContablesList(List<SiiCuentasContables> siiCuentasContablesList) {
        this.siiCuentasContablesList = siiCuentasContablesList;
    }

    public SiiCuentasContables addSiiCuentasContables(SiiCuentasContables siiCuentasContables) {
        getSiiCuentasContablesList().add(siiCuentasContables);
        siiCuentasContables.setSiiPersonaCancSaldo(this);
        return siiCuentasContables;
    }

    public SiiCuentasContables removeSiiCuentasContables(SiiCuentasContables siiCuentasContables) {
        getSiiCuentasContablesList().remove(siiCuentasContables);
        siiCuentasContables.setSiiPersonaCancSaldo(null);
        return siiCuentasContables;
    }

    @Column(name = "PER_ACTIVO", length = 1)
    public String getPerActivo() {
        return perActivo;
    }
    
    public void setPerActivo(String perActivo) {
        this.perActivo = perActivo;
    }

    
}
