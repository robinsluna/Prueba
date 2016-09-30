package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PersonaVO {
    
    private Long perCodigo;
    private Integer perDigitoVerif;
    private Long perCodigoRepresentante; //No usar. Se debe usar personaRepresentanteVo
    private String perDireccion;
    private String perEmail;
    private String perFax;
    private String perJurNombreCorto;
    private String perJurNombreLargo;
    private String perNumIdentificacion;
    private String perPrimerApellido;
    private String perPrimerNombre;
    private String perSegundoApellido;
    private String perSegundoNombre;
    private String perTelefono;
    private String perTelefono2;
    private String perTipoPersona;
    private String perTipoProveedor;
    private String perCelular;
    private String perOrigen;
    private String perCiudadExt;
    private String perProdServ;
    private String perObservProd;
    private String perPaginaWeb;
    private String perRifaPromo;
    private String perEstampUnal;
    private Integer perPlazo;
    private String perCargaLiqActAdm; 

    private TipoIdentificacionVO tipoIdentificacionVo;
    private UbicacionVO ubicacionVo;
    private PersonaVO personaRepresentanteVo; //VO padre, representante legal
    private TipoRetencionVO tipoRetencionVentasVo;
    private TipoRetencionVO tipoRetencionRentasVo;

    private List<UsuarioVO> usuarioVoList;
    private List<PersonalEmpresaVO> listaPersonalEmpresaVo; // hay dos listas, falta crear la segunda lista
    private List<PersonaVO> personaListVo;
    private List<ProveedorVO> ProveedorListVo;
    private List<OperadorVO> operadorListVo;
    private List<DetalleFinancVO> detalleFinancListVo;
    private List<AseguradoraVO> AseguradoraListVo;
    private List<ResponDianPersonaVO> responDianPersonaList;
    private List<ActividadIcaPersVO> actividadIcaPersList;
    private List<ImputacionContableVO> imputacionContableList;
    private List<CuentaContTipoDocContVO> cuentaContTipoDocContList;
    private List<PersonaCtaBancoVO> personaCtaBancoList;    private List<ConsolidadoDistVO> consolidadoDistList;
    private List<FiscalizadorSustancVO> fiscalizadorSustancListVo;
    private List<InhabilidadPersonaVO> inhabilidadPersonaListVo;
    private List<DireccionPersonaVO> direccionPersonaListVo;
    
    /*
     * Booleano para la seleccion de la persona para el modulo de innovacion personal
     */
    private boolean seleccion;

    // Tipo de empresa
    private String tipoEmpresa;
    //Tipo sociedad
    private TipoSociedadVO tipoSociedadVO;

    //Numero tarjeta profesional
    private String perNumTarjetaProfesional;

    
    /**
     * Constructor.
     * @param siiPersona - Entity.
     */
    public PersonaVO(SiiPersona siiPersona) {
        if (siiPersona != null) {
            this.perCodigo = siiPersona.getPerCodigo();
            this.perCelular = siiPersona.getPerCelular();
            this.perDireccion = siiPersona.getPerDireccion();
            this.perEmail = siiPersona.getPerEmail();
            this.perFax = siiPersona.getPerFax();
            this.perJurNombreCorto = siiPersona.getPerJurNombreCorto();
            this.perJurNombreLargo = siiPersona.getPerJurNombreLargo();
            this.perNumIdentificacion = siiPersona.getPerNumIdentificacion();
            this.perPrimerApellido = siiPersona.getPerPrimerApellido();
            this.perSegundoApellido = siiPersona.getPerSegundoApellido();
            this.perPrimerNombre = siiPersona.getPerPrimerNombre();
            this.perSegundoNombre = siiPersona.getPerSegundoNombre();
            this.perTelefono = siiPersona.getPerTelefono();
            this.perTipoPersona = siiPersona.getPerTipoPersona();
            this.perTipoProveedor = siiPersona.getPerTipoProveedor();
            this.perDigitoVerif = siiPersona.getPerDigitoVerif();
            this.perTelefono2 = siiPersona.getPerTelefono2();
            this.perOrigen = siiPersona.getPerOrigen();
            this.perCiudadExt = siiPersona.getPerCiudadExt();
            this.perProdServ = siiPersona.getPerProdServ();
            this.perObservProd = siiPersona.getPerObservProd();
            this.perPaginaWeb = siiPersona.getPerPaginaWeb();
            this.perNumTarjetaProfesional = siiPersona.getPerTarjetaPro();
            this.perRifaPromo=siiPersona.getPerRifaPromo();
            this.perEstampUnal = siiPersona.getPerEstampUnal();
            this.perPlazo = siiPersona.getPerPlazo();
            this.perCargaLiqActAdm = siiPersona.getPerCargaLiqActAdm();

            //Padres:
            if (siiPersona.getSiiTipoIdentificacion1() != null) {
                this.tipoIdentificacionVo = new TipoIdentificacionVO(siiPersona.getSiiTipoIdentificacion1());
            }

            if (siiPersona.getSiiUbicacion1() != null) {
                this.ubicacionVo = new UbicacionVO(siiPersona.getSiiUbicacion1());
            }

            if (siiPersona.getSiiTipoRetencionRentas() != null) {
                this.tipoRetencionRentasVo = new TipoRetencionVO(siiPersona.getSiiTipoRetencionRentas());
            }

            if (siiPersona.getSiiTipoRetencionVentas() != null) {
                this.tipoRetencionVentasVo = new TipoRetencionVO(siiPersona.getSiiTipoRetencionVentas());
            }

            if (siiPersona.getSiiPersona() != null) {
                this.personaRepresentanteVo = new PersonaVO(siiPersona.getSiiPersona());
            }

            if (siiPersona.getSiiTipoSociedad() != null) {
                this.tipoSociedadVO = new TipoSociedadVO(siiPersona.getSiiTipoSociedad());
            }

        }
    }

    public PersonaVO() {

    }

    public void setListaPersonalEmpresaVo(List<PersonalEmpresaVO> listaPersonalEmpresaVo) {
        this.listaPersonalEmpresaVo = listaPersonalEmpresaVo;
    }

    public List<PersonalEmpresaVO> getListaPersonalEmpresaVo() {
        return listaPersonalEmpresaVo;
    }

    public void setPersonaRepresentanteVo(PersonaVO personaRepresentanteVo) {
        this.personaRepresentanteVo = personaRepresentanteVo;
    }

    public PersonaVO getPersonaRepresentanteVo() {
        return personaRepresentanteVo;
    }

    public void setPerDigitoVerif(Integer perDigitoVerif) {
        this.perDigitoVerif = perDigitoVerif;
    }

    public Integer getPerDigitoVerif() {
        return perDigitoVerif;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigoRepresentante(Long perCodigoRepresentante) {
        this.perCodigoRepresentante = perCodigoRepresentante;
    }

    public Long getPerCodigoRepresentante() {
        return perCodigoRepresentante;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerFax(String perFax) {
        this.perFax = perFax;
    }

    public String getPerFax() {
        return perFax;
    }

    public void setPerJurNombreCorto(String perJurNombreCorto) {
        this.perJurNombreCorto = perJurNombreCorto;
    }

    public String getPerJurNombreCorto() {
        return perJurNombreCorto;
    }

    public void setPerJurNombreLargo(String perJurNombreLargo) {
        this.perJurNombreLargo = perJurNombreLargo;
    }

    public String getPerJurNombreLargo() {
        return perJurNombreLargo;
    }

    public void setPerNumIdentificacion(String perNumIdentificacion) {
        this.perNumIdentificacion = perNumIdentificacion;
    }

    public String getPerNumIdentificacion() {
        return perNumIdentificacion;
    }

    public void setPerPrimerApellido(String perPrimerApellido) {
        this.perPrimerApellido = perPrimerApellido;
    }

    public String getPerPrimerApellido() {
        return perPrimerApellido;
    }

    public void setPerPrimerNombre(String perPrimerNombre) {
        this.perPrimerNombre = perPrimerNombre;
    }

    public String getPerPrimerNombre() {
        return perPrimerNombre;
    }

    public void setPerSegundoApellido(String perSegundoApellido) {
        this.perSegundoApellido = perSegundoApellido;
    }

    public String getPerSegundoApellido() {
        return perSegundoApellido;
    }

    public void setPerSegundoNombre(String perSegundoNombre) {
        this.perSegundoNombre = perSegundoNombre;
    }

    public String getPerSegundoNombre() {
        return perSegundoNombre;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTipoPersona(String perTipoPersona) {
        this.perTipoPersona = perTipoPersona;
    }

    public String getPerTipoPersona() {
        return perTipoPersona;
    }


    public void setUsuarioVoList(List<UsuarioVO> usuarioVoList) {
        this.usuarioVoList = usuarioVoList;
    }

    public List<UsuarioVO> getUsuarioVoList() {
        return usuarioVoList;
    }

    public void setTipoIdentificacionVo(TipoIdentificacionVO tipoIdentificacionVo) {
        this.tipoIdentificacionVo = tipoIdentificacionVo;
    }

    public TipoIdentificacionVO getTipoIdentificacionVo() {
        return tipoIdentificacionVo;
    }


    public void setUbicacionVo(UbicacionVO ubicacionVo) {
        this.ubicacionVo = ubicacionVo;
    }

    public UbicacionVO getUbicacionVo() {
        return ubicacionVo;
    }

    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }

    public String getPerCelular() {
        return perCelular;
    }


    public void setPerTelefono2(String perTelefono2) {
        this.perTelefono2 = perTelefono2;
    }

    public String getPerTelefono2() {
        return perTelefono2;
    }

    public void setPerOrigen(String perOrigen) {
        this.perOrigen = perOrigen;
    }

    public String getPerOrigen() {
        return perOrigen;
    }

    public void setPersonaListVo(List<PersonaVO> personaListVo) {
        this.personaListVo = personaListVo;
    }

    public List<PersonaVO> getPersonaListVo() {
        return personaListVo;
    }

    public void setProveedorListVo(List<ProveedorVO> ProveedorListVo) {
        this.ProveedorListVo = ProveedorListVo;
    }

    public List<ProveedorVO> getProveedorListVo() {
        return ProveedorListVo;
    }

    public void setOperadorListVo(List<OperadorVO> operadorListVo) {
        this.operadorListVo = operadorListVo;
    }

    public List<OperadorVO> getOperadorListVo() {
        return operadorListVo;
    }

    public void setDetalleFinancListVo(List<DetalleFinancVO> detalleFinancListVo) {
        this.detalleFinancListVo = detalleFinancListVo;
    }

    public List<DetalleFinancVO> getDetalleFinancListVo() {
        return detalleFinancListVo;
    }

    public void setAseguradoraListVo(List<AseguradoraVO> AseguradoraListVo) {
        this.AseguradoraListVo = AseguradoraListVo;
    }

    public List<AseguradoraVO> getAseguradoraListVo() {
        return AseguradoraListVo;
    }


    public void setTipoRetencionVentasVo(TipoRetencionVO tipoRetencionVentasVo) {
        this.tipoRetencionVentasVo = tipoRetencionVentasVo;
    }

    public TipoRetencionVO getTipoRetencionVentasVo() {
        return tipoRetencionVentasVo;
    }

    public void setTipoRetencionRentasVo(TipoRetencionVO tipoRetencionRentasVo) {
        this.tipoRetencionRentasVo = tipoRetencionRentasVo;
    }

    public TipoRetencionVO getTipoRetencionRentasVo() {
        return tipoRetencionRentasVo;
    }

    public void setResponDianPersonaList(List<ResponDianPersonaVO> responDianPersonaList) {
        this.responDianPersonaList = responDianPersonaList;
    }

    public List<ResponDianPersonaVO> getResponDianPersonaList() {
        return responDianPersonaList;
    }

    public void setActividadIcaPersList(List<ActividadIcaPersVO> actividadIcaPersList) {
        this.actividadIcaPersList = actividadIcaPersList;
    }

    public List<ActividadIcaPersVO> getActividadIcaPersList() {
        return actividadIcaPersList;
    }

    public void setImputacionContableList(List<ImputacionContableVO> imputacionContableList) {
        this.imputacionContableList = imputacionContableList;
    }

    public List<ImputacionContableVO> getImputacionContableList() {
        return imputacionContableList;
    }

    public void setCuentaContTipoDocContList(List<CuentaContTipoDocContVO> cuentaContTipoDocContList) {
        this.cuentaContTipoDocContList = cuentaContTipoDocContList;
    }

    public List<CuentaContTipoDocContVO> getCuentaContTipoDocContList() {
        return cuentaContTipoDocContList;
    }


    public void setPerTipoProveedor(String perTipoProveedor) {
        this.perTipoProveedor = perTipoProveedor;
    }

    public String getPerTipoProveedor() {
        return perTipoProveedor;
    }

    public void setPersonaCtaBancoList(List<PersonaCtaBancoVO> personaCtaBancoList) {
        this.personaCtaBancoList = personaCtaBancoList;
    }

    public List<PersonaCtaBancoVO> getPersonaCtaBancoList() {
        return personaCtaBancoList;
    }


    /**
     * Obtiene la Actividad ICA PRINCIPAL asociada a la Persona.
     * @return
     */
    public ActividadIcaPersVO getActividadIcaPersPrincipal() {
        ActividadIcaPersVO principal = null;
        if (actividadIcaPersList != null) {
            Iterator<ActividadIcaPersVO> it = actividadIcaPersList.iterator();
            while (it.hasNext() && principal == null) {
                ActividadIcaPersVO actICA = it.next();
                if (EnumDecision.SI.getId().equals(actICA.getAipActivPrinc()))
                    principal = actICA;
            }
        }
        return (principal);
    }


    /**
     * Obtiene el nombre corto del tipo de indentificaci&oacute;n correspondiente.
     * @return tipoIdentificacionVo.tidNombreCorto
     */
    public String getTipoIdentificacionNombreCorto() {
        String tidNombreCorto = tipoIdentificacionVo != null ? tipoIdentificacionVo.getTidNombreCorto() : null;

        return (tidNombreCorto);
    }


    /**
     * Obtiene el nombre completo del tipo de indentificaci&oacute;n correspondiente.
     * @return tipoIdentificacionVo.tidNombre
     */
    public String getTipoIdentificacionNombreCompleto() {
        String tidNombreCorto = tipoIdentificacionVo != null ? tipoIdentificacionVo.getTidNombre() : null;

        return (tidNombreCorto);
    }


    /**
     * Obtiene el nombre completo de la persona a trav&eacute;s de cada palabra que lo compone.
     * @return perPrimerApellido_perSegundoApellido_perPrimerNombre_perSegundoNombre
     */
    public String getNombreCompleto() {
        String nombreCompleto = null;


        if (tipoIdentificacionVo != null && tipoIdentificacionVo.getTidCodigo() != null &&
            EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId().equals(tipoIdentificacionVo.getTidCodigo())) {
            nombreCompleto =
                perJurNombreLargo != null && !perJurNombreLargo.trim().isEmpty() ? perJurNombreLargo :
                perJurNombreCorto;
        } else {
            nombreCompleto = perPrimerNombre!=null ? perPrimerNombre.trim() : null;
            if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
                if (perSegundoNombre != null && !perSegundoNombre.trim().isEmpty())
                    nombreCompleto += " " + perSegundoNombre;
                if (perPrimerApellido != null && !perPrimerApellido.trim().isEmpty())
                    nombreCompleto += " " + perPrimerApellido;
                if (perSegundoApellido != null && !perSegundoApellido.trim().isEmpty())
                    nombreCompleto += " " + perSegundoApellido;
            } else {
                nombreCompleto =
                    perJurNombreLargo != null && !perJurNombreLargo.trim().isEmpty() ? perJurNombreLargo :
                    perJurNombreCorto;
            }
        }

        return (nombreCompleto);
    }


    public String getNombreCompletoPrimeroNombres() {
        String nombreCompleto = perPrimerNombre;
        if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
            if (perSegundoNombre != null && !perSegundoNombre.trim().isEmpty())
                nombreCompleto += " " + perSegundoNombre;
            if (perPrimerApellido != null && !perPrimerApellido.trim().isEmpty())
                nombreCompleto += " " + perPrimerApellido;
            if (perSegundoApellido != null && !perSegundoApellido.trim().isEmpty())
                nombreCompleto += " " + perSegundoApellido;
        } else {
            nombreCompleto =
                perJurNombreLargo != null && !perJurNombreLargo.trim().isEmpty() ? perJurNombreLargo :
                perJurNombreCorto;
        }
        return (nombreCompleto);
    }


    /**
     * Obtiene la cadena resultante del Tipo y N&uacute;mero de Identificaci&oacute;n.
     * @return tipoIdentificacion.nombreCorto + numeroIdentificacion
     */
    public String getIdentificacionCompleta() {
        String identificacion = "";

        String tipoId = this.getTipoIdentificacionNombreCorto();
        if (tipoId != null && !tipoId.isEmpty())
            identificacion += tipoId;

        if (perNumIdentificacion != null && !perNumIdentificacion.isEmpty())
            identificacion += " " + perNumIdentificacion;

        if (identificacion != null && identificacion.isEmpty())
            identificacion = null;

        return (identificacion);
    }
    
    
    
    /**
     * Obtiene el listado de Responsabilidades DIAN asociadas a la Persona, por medio de una Cadena separada por comas.
     * @return Cadena con items de responDianPersonaList.
     */
    public String getCadenaResponsabilidadesDIAN () 
    {
        String resultado = null;
        
        if (responDianPersonaList!=null && !responDianPersonaList.isEmpty()) {
            // listado de responsabilidades dian sin repetidos
            List<Long> rdiCodigoList = new ArrayList<Long>();
            for (ResponDianPersonaVO responDianPersonaVo : responDianPersonaList) {
                if (responDianPersonaVo != null) {
                    ResponsabilidadDianVO responsabilidadDianVo = responDianPersonaVo.getResponsabilidadDianVo();
                    if (responsabilidadDianVo != null && responsabilidadDianVo.getRdiCodigo() != null) {
                        if (!rdiCodigoList.contains(responsabilidadDianVo.getRdiCodigo())) {
                            rdiCodigoList.add(responsabilidadDianVo.getRdiCodigo());
                        }
                    }
                }
            }
            
            
            if (rdiCodigoList!=null && !rdiCodigoList.isEmpty()) {
                // ordena la lista
                Collections.sort(rdiCodigoList);
                
                // conformar listado de codigos de Responsabilidad DIAN.
                StringBuilder grupoResponsabilidadesSB = new StringBuilder();
                Iterator<Long> it = rdiCodigoList.iterator();
                while (it.hasNext()) {
                    Long rdiCodigo = it.next();
                    grupoResponsabilidadesSB.append(rdiCodigo+"");
                    
                    if (it.hasNext())
                        grupoResponsabilidadesSB.append(",");
                }
                
                resultado = grupoResponsabilidadesSB.toString();
            }
        }
        
        return (resultado);
    }
    
    

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        boolean igual = false;
        if (o instanceof PersonaVO) {
            PersonaVO pVO = (PersonaVO) o;
            if (pVO != null) {
                igual =
                    ((pVO.perCodigo != null && pVO.perCodigo.equals(this.perCodigo)) ||
                     (pVO.perCodigo == null && this.perCodigo == null)) &&
                    ((pVO.perDigitoVerif != null && pVO.perDigitoVerif.equals(this.perDigitoVerif)) ||
                     (pVO.perDigitoVerif == null && this.perDigitoVerif == null)) &&
                    ((pVO.perCodigoRepresentante != null &&
                      pVO.perCodigoRepresentante.equals(this.perCodigoRepresentante)) ||
                     (pVO.perCodigoRepresentante == null && this.perCodigoRepresentante == null)) &&
                    ((pVO.perDireccion != null && pVO.perDireccion.equals(this.perDireccion)) ||
                     (pVO.perDireccion == null && this.perDireccion == null)) &&
                    ((pVO.perEmail != null && pVO.perEmail.equals(this.perEmail)) ||
                     (pVO.perEmail == null && this.perEmail == null)) &&
                    ((pVO.perFax != null && pVO.perFax.equals(this.perFax)) ||
                     (pVO.perFax == null && this.perFax == null)) &&
                    ((pVO.perJurNombreCorto != null && pVO.perJurNombreCorto.equals(this.perJurNombreCorto)) ||
                     (pVO.perJurNombreCorto == null && this.perJurNombreCorto == null)) &&
                    ((pVO.perJurNombreLargo != null && pVO.perJurNombreLargo.equals(this.perJurNombreLargo)) ||
                     (pVO.perJurNombreLargo == null && this.perJurNombreLargo == null)) &&
                    ((pVO.perNumIdentificacion != null && pVO.perNumIdentificacion.equals(this.perNumIdentificacion)) ||
                     (pVO.perNumIdentificacion == null && this.perNumIdentificacion == null)) &&
                    ((pVO.perPrimerApellido != null && pVO.perPrimerApellido.equals(this.perPrimerApellido)) ||
                     (pVO.perPrimerApellido == null && this.perPrimerApellido == null)) &&
                    ((pVO.perPrimerNombre != null && pVO.perPrimerNombre.equals(this.perPrimerNombre)) ||
                     (pVO.perPrimerNombre == null && this.perPrimerNombre == null)) &&
                    ((pVO.perSegundoApellido != null && pVO.perSegundoApellido.equals(this.perSegundoApellido)) ||
                     (pVO.perSegundoApellido == null && this.perSegundoApellido == null)) &&
                    ((pVO.perSegundoNombre != null && pVO.perSegundoNombre.equals(this.perSegundoNombre)) ||
                     (pVO.perSegundoNombre == null && this.perSegundoNombre == null)) &&
                    ((pVO.perTelefono != null && pVO.perTelefono.equals(this.perTelefono)) ||
                     (pVO.perTelefono == null && this.perTelefono == null)) &&
                    ((pVO.perTelefono2 != null && pVO.perTelefono2.equals(this.perTelefono2)) ||
                     (pVO.perTelefono2 == null && this.perTelefono2 == null)) &&
                    ((pVO.perTipoPersona != null && pVO.perTipoPersona.equals(this.perTipoPersona)) ||
                     (pVO.perTipoPersona == null && this.perTipoPersona == null)) &&
                    ((pVO.perCelular != null && pVO.perCelular.equals(this.perCelular)) ||
                     (pVO.perCelular == null && this.perCelular == null)) &&
                    ((pVO.tipoIdentificacionVo != null && pVO.tipoIdentificacionVo.equals(this.tipoIdentificacionVo)) ||
                     (pVO.tipoIdentificacionVo == null && this.tipoIdentificacionVo == null)) &&
                    ((pVO.ubicacionVo != null && pVO.ubicacionVo.equals(this.ubicacionVo)) ||
                     (pVO.ubicacionVo == null && this.ubicacionVo == null)) && 
                    ((pVO.perEstampUnal != null && pVO.perEstampUnal.equals(this.perEstampUnal)) ||
                     (pVO.perEstampUnal == null && this.perEstampUnal == null));
            }
        }
        return (igual);
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hashcode = 0;
        String identificacion = "";
        
        if (tipoIdentificacionVo!=null && tipoIdentificacionVo.getTidNombreCorto()!=null)
            identificacion = tipoIdentificacionVo.getTidNombreCorto()+" ";
        
        if (perNumIdentificacion!=null) {
            identificacion += perNumIdentificacion;
            hashcode = identificacion.hashCode();
        }
        
        return (hashcode);
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString () 
    {
        String resultado = "";
        if (perCodigo!=null) resultado+=perCodigo+" ";
        if (this.getTipoIdentificacionNombreCorto()!=null) resultado+=this.getTipoIdentificacionNombreCorto()+"_";
        if (perNumIdentificacion!=null) resultado+=perNumIdentificacion+" ";
        if (this.getNombreCompleto()!=null) resultado+=this.getNombreCompleto();
        
        return (resultado.trim());
    }
    
    

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getPerCiudadExt() {
        return perCiudadExt;
    }

    public void setPerCiudadExt(String perCiudadExt) {
        this.perCiudadExt = perCiudadExt;
    }

    public String getPerProdServ() {
        return perProdServ;
    }

    public void setPerProdServ(String perProdServ) {
        this.perProdServ = perProdServ;
    }

    public String getPerObservProd() {
        return perObservProd;
    }

    public void setPerObservProd(String perObservProd) {
        this.perObservProd = perObservProd;
    }

    public String getPerPaginaWeb() {
        return perPaginaWeb;
    }

    public void setPerPaginaWeb(String perPaginaWeb) {
        this.perPaginaWeb = perPaginaWeb;
    }


    public TipoSociedadVO getTipoSociedadVO() {
        return tipoSociedadVO;
    }

    public void setTipoSociedadVO(TipoSociedadVO tipoSociedadVO) {
        this.tipoSociedadVO = tipoSociedadVO;
    }


    public String getPerNumTarjetaProfesional() {
        return perNumTarjetaProfesional;
    }

    public void setPerNumTarjetaProfesional(String perNumTarjetaProfesional) {
        this.perNumTarjetaProfesional = perNumTarjetaProfesional;
    }

    public void setPerRifaPromo(String perRifaPromo) {
        this.perRifaPromo = perRifaPromo;
    }

    public String getPerRifaPromo() {
        return perRifaPromo;
    }

    public void setPerEstampUnal(String perEstampUnal) {
        this.perEstampUnal = perEstampUnal;
    }

    public String getPerEstampUnal() {
        return perEstampUnal;
    }
    public void setConsolidadoDistList(List<ConsolidadoDistVO> consolidadoDistList) {
        this.consolidadoDistList = consolidadoDistList;
    }


    public List<ConsolidadoDistVO> getConsolidadoDistList() {
        return consolidadoDistList;
    }
    public void setFiscalizadorSustancListVo(List<FiscalizadorSustancVO> fiscalizadorSustancListVo) {
        this.fiscalizadorSustancListVo = fiscalizadorSustancListVo;
    }

    public List<FiscalizadorSustancVO> getFiscalizadorSustancListVo() {
        return fiscalizadorSustancListVo;
    }

    public void setPerPlazo(Integer perPlazo) {
        this.perPlazo = perPlazo;
    }

    public Integer getPerPlazo() {
        return perPlazo;
    }

    public void setInhabilidadPersonaListVo(List<InhabilidadPersonaVO> inhabilidadPersonaListVo) {
        this.inhabilidadPersonaListVo = inhabilidadPersonaListVo;
    }

    public List<InhabilidadPersonaVO> getInhabilidadPersonaListVo() {
        return inhabilidadPersonaListVo;
    }

    public void setDireccionPersonaListVo(List<DireccionPersonaVO> direccionPersonaListVo) {
        this.direccionPersonaListVo = direccionPersonaListVo;
    }

    public List<DireccionPersonaVO> getDireccionPersonaListVo() {
        return direccionPersonaListVo;
    }

    public void setPerCargaLiqActAdm(String perCargaLiqActAdm){
        this.perCargaLiqActAdm = perCargaLiqActAdm;
    }

    public String getPerCargaLiqActAdm(){
        return perCargaLiqActAdm;
    }

     @Override
    public PersonaVO clone () 
    {
        PersonaVO personaVo = new PersonaVO();
        personaVo.setPerCodigo(perCodigo); 
        
        return (personaVo);
    }
 
}
