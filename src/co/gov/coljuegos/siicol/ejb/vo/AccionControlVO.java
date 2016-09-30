package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAccionControl;

import java.util.Date;
import java.util.List;

public class AccionControlVO implements Comparable {
    private String accBarrio;
    private String accBodega;
    private Long accCodigo;
    private String accDireccion;
    private String accEstado;
    private String accEstadoEstabl;
    private Date accFechaActa;
    private String accLocalidad;
    private String accNomEstabl;
    private Integer accNumElemEncon;
    private Integer accNumElemRetir;
    private String accNumeroActa;
    private String accObservaciones;
    private String accSucursal;
    private String accTipoAccion;
    private MotivoAnulaAccContVO motivoAnulaAccContVo;
    private UsuarioVO usuarioConectVo;
    private UbicacionVO ubicacionMunicVo;
    private AutoComisorioAccConVO autoComisorioAccConVo;
    private List<PersonaAtiendeAccVO> personaAtiendeAccListVo;
    private List<ElementoRetiradoAccVO> elementoRetiradoAccListVo;
    private ResolucionDecomDestVO resolucionDecomDestVo;
    private ResolucionDecomDestVO resolucionDecomDestResuelveVo;
    
    //Atributos que no pertenecen a la entidad
    private String nombreDepartamentoUbicacionMunicVo;
    private String nombreCiudadubicacionMunicVo;

    public AccionControlVO() {

    }
     /**
     * Constructor.
     * @param accionControl
     */   
     public AccionControlVO(SiiAccionControl accionControl) {
        this.accCodigo = accionControl.getAccCodigo();
        this.accBarrio = accionControl.getAccBarrio();
        this.accBodega = accionControl.getAccBodega();
        this.accDireccion = accionControl.getAccDireccion();
        this.accEstado = accionControl.getAccEstado();
        this.accEstadoEstabl = accionControl.getAccEstadoEstabl();
        this.accFechaActa = accionControl.getAccFechaActa();
        this.accLocalidad = accionControl.getAccLocalidad();
        this.accNomEstabl = accionControl.getAccNomEstabl();
        this.accNumElemEncon = accionControl.getAccNumElemEncon();
        this.accNumElemRetir = accionControl.getAccNumElemRetir();
        this.accNumeroActa = accionControl.getAccNumeroActa();
        this.accObservaciones = accionControl.getAccObservaciones();
        this.accSucursal = accionControl.getAccSucursal();
        this.accTipoAccion = accionControl.getAccTipoAccion();

        //Padres
        if(accionControl.getSiiAutoComisorioAccCon() != null) {
            this.autoComisorioAccConVo = new AutoComisorioAccConVO(accionControl.getSiiAutoComisorioAccCon());
        }
        this.motivoAnulaAccContVo = accionControl.getSiiMotivoAnulaAccCont() != null ? new MotivoAnulaAccContVO(accionControl.getSiiMotivoAnulaAccCont()) : new MotivoAnulaAccContVO();

        if(accionControl.getSiiUbicacionMunic() != null) {
            this.ubicacionMunicVo = new UbicacionVO(accionControl.getSiiUbicacionMunic());
        }
        else {
            this.ubicacionMunicVo = new UbicacionVO();
            this.ubicacionMunicVo.setUbicacionPadreVo(new UbicacionVO());
        }

        if(accionControl.getSiiUsuarioConect() != null) {
            this.usuarioConectVo = new UsuarioVO(accionControl.getSiiUsuarioConect());
        }

        if (accionControl.getSiiResolucionDecomDest() != null) {
            this.resolucionDecomDestVo = new ResolucionDecomDestVO(accionControl.getSiiResolucionDecomDest());
    }

        if (accionControl.getSiiResolucionDecomDestResuelve() != null) {
            this.resolucionDecomDestResuelveVo =
                new ResolucionDecomDestVO(accionControl.getSiiResolucionDecomDestResuelve());
        }

    }

    public void setAccBarrio(String accBarrio) {
        this.accBarrio = accBarrio;
    }

    public String getAccBarrio() {
        return accBarrio;
    }

    public void setAccBodega(String accBodega) {
        this.accBodega = accBodega;
    }

    public String getAccBodega() {
        return accBodega;
    }

    public void setAccCodigo(Long accCodigo) {
        this.accCodigo = accCodigo;
    }

    public Long getAccCodigo() {
        return accCodigo;
    }

    public void setAccDireccion(String accDireccion) {
        this.accDireccion = accDireccion;
    }

    public String getAccDireccion() {
        return accDireccion;
    }

    public void setAccEstado(String accEstado) {
        this.accEstado = accEstado;
    }

    public String getAccEstado() {
        return accEstado;
    }

    public void setAccEstadoEstabl(String accEstadoEstabl) {
        this.accEstadoEstabl = accEstadoEstabl;
    }

    public String getAccEstadoEstabl() {
        return accEstadoEstabl;
    }

    public void setAccFechaActa(Date accFechaActa) {
        this.accFechaActa = accFechaActa;
    }

    public Date getAccFechaActa() {
        return accFechaActa;
    }

    public void setAccLocalidad(String accLocalidad) {
        this.accLocalidad = accLocalidad;
    }

    public String getAccLocalidad() {
        return accLocalidad;
    }

    public void setAccNomEstabl(String accNomEstabl) {
        this.accNomEstabl = accNomEstabl;
    }

    public String getAccNomEstabl() {
        return accNomEstabl;
    }

    public void setAccNumElemEncon(Integer accNumElemEncon) {
        this.accNumElemEncon = accNumElemEncon;
    }

    public Integer getAccNumElemEncon() {
        return accNumElemEncon;
    }

    public void setAccNumElemRetir(Integer accNumElemRetir) {
        this.accNumElemRetir = accNumElemRetir;
    }

    public Integer getAccNumElemRetir() {
        return accNumElemRetir;
    }

    public void setAccNumeroActa(String accNumeroActa) {
        this.accNumeroActa = accNumeroActa;
    }

    public String getAccNumeroActa() {
        return accNumeroActa;
    }

    public void setAccObservaciones(String accObservaciones) {
        this.accObservaciones = accObservaciones;
    }

    public String getAccObservaciones() {
        return accObservaciones;
    }

    public void setAccSucursal(String accSucursal) {
        this.accSucursal = accSucursal;
    }

    public String getAccSucursal() {
        return accSucursal;
    }

    public void setAccTipoAccion(String accTipoAccion) {
        this.accTipoAccion = accTipoAccion;
    }

    public String getAccTipoAccion() {
        return accTipoAccion;
    }

    public void setMotivoAnulaAccContVo(MotivoAnulaAccContVO motivoAnulaAccContVo) {
        this.motivoAnulaAccContVo = motivoAnulaAccContVo;
    }

    public MotivoAnulaAccContVO getMotivoAnulaAccContVo() {
        return motivoAnulaAccContVo;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }

    public void setUbicacionMunicVo(UbicacionVO ubicacionMunicVo) {
        this.ubicacionMunicVo = ubicacionMunicVo;
    }

    public UbicacionVO getUbicacionMunicVo() {
        if(ubicacionMunicVo == null) {
            UbicacionVO u = new UbicacionVO();
            u.setUbicacionPadreVo(new UbicacionVO());
            return u;
        }
        else {
            return ubicacionMunicVo;
        }
    }

    public void setNombreDepartamentoUbicacionMunicVo(String nombreDepartamentoUbicacionMunicVo) {
        this.nombreDepartamentoUbicacionMunicVo = nombreDepartamentoUbicacionMunicVo;
    }

    public String getNombreDepartamentoUbicacionMunicVo() {
        return nombreDepartamentoUbicacionMunicVo;
    }

    public void setNombreCiudadubicacionMunicVo(String nombreCiudadubicacionMunicVo) {
        this.nombreCiudadubicacionMunicVo = nombreCiudadubicacionMunicVo;
    }

    public String getNombreCiudadubicacionMunicVo() {
        return nombreCiudadubicacionMunicVo;
    }

    public void setAutoComisorioAccConVo(AutoComisorioAccConVO autoComisorioAccConVo) {
        this.autoComisorioAccConVo = autoComisorioAccConVo;
    }

    public AutoComisorioAccConVO getAutoComisorioAccConVo() {
        return autoComisorioAccConVo;
    }

    public void setPersonaAtiendeAccListVo(List<PersonaAtiendeAccVO> personaAtiendeAccListVo) {
        this.personaAtiendeAccListVo = personaAtiendeAccListVo;
    }

    public List<PersonaAtiendeAccVO> getPersonaAtiendeAccListVo() {
        return personaAtiendeAccListVo;
    }

    public void setElementoRetiradoAccListVo(List<ElementoRetiradoAccVO> elementoRetiradoAccListVo) {
        this.elementoRetiradoAccListVo = elementoRetiradoAccListVo;
    }

    public List<ElementoRetiradoAccVO> getElementoRetiradoAccListVo() {
        return elementoRetiradoAccListVo;
    }

    public PersonaAtiendeAccVO getPersonaAtiendeAccVo() {
        return new PersonaAtiendeAccVO();
    }

    public void setPersonaAtiendeAccVo(PersonaAtiendeAccVO persona) {
        if (persona==null) {
            persona = new PersonaAtiendeAccVO();
        }
        if (personaAtiendeAccListVo!=null && personaAtiendeAccListVo.size()!=0) {
            personaAtiendeAccListVo.add(persona);
        }
        
    }

    public void setResolucionDecomDestVo(ResolucionDecomDestVO resolucionDecomDestVo) {
        this.resolucionDecomDestVo = resolucionDecomDestVo;
}

    public ResolucionDecomDestVO getResolucionDecomDestVo() {
        return resolucionDecomDestVo;
    }

    public void setResolucionDecomDestResuelveVo(ResolucionDecomDestVO resolucionDecomDestResuelveVo) {
        this.resolucionDecomDestResuelveVo = resolucionDecomDestResuelveVo;
    }

    public ResolucionDecomDestVO getResolucionDecomDestResuelveVo() {
        return resolucionDecomDestResuelveVo;
    }

    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof AccionControlVO) {
            AccionControlVO ac = (AccionControlVO) o;
            if (ac!=null && this.accNumeroActa!=null && ac.accNumeroActa!=null)
                resultado = this.accNumeroActa.compareTo(ac.accNumeroActa);
        }
        return resultado;
    }
}
