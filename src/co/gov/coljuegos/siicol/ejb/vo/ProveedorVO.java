package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedor;

import java.util.List;


public class ProveedorVO {
    private PersonaVO personaVo;
    private Long proCodigo;
    private String proEjecutivoCuenta;
    private List<CotizacionEstudioVO> CotizacionEstudioListVO;
    private List<ProveedorInvitacionVO> proveedorInvitacionList;
    private List<PropuestaRecibVO> propuestaRecibList;
    private List<OficioAdjudicaVO> oficioAdjudicaList;
    private List<RpVO> rpList;
    
    
    public ProveedorVO() {
        
    }

    public ProveedorVO(SiiProveedor proveedor) {
        this.proCodigo = proveedor.getProCodigo();
        this.proEjecutivoCuenta = proveedor.getProEjecutivoCuenta();
        //Padres:
        if (proveedor.getSiiPersona()!=null) {
            this.personaVo = new PersonaVO(proveedor.getSiiPersona());
        }
        
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setProCodigo(Long proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Long getProCodigo() {
        return proCodigo;
    }

    public void setProEjecutivoCuenta(String proEjecutivoCuenta) {
        this.proEjecutivoCuenta = proEjecutivoCuenta;
    }

    public String getProEjecutivoCuenta() {
        return proEjecutivoCuenta;
    }


    public void setCotizacionEstudioListVO(List<CotizacionEstudioVO> CotizacionEstudioListVO) {
        this.CotizacionEstudioListVO = CotizacionEstudioListVO;
    }

    public List<CotizacionEstudioVO> getCotizacionEstudioListVO() {
        return CotizacionEstudioListVO;
    }


    public void setPropuestaRecibList(List<PropuestaRecibVO> propuestaRecibList) {
        this.propuestaRecibList = propuestaRecibList;
    }

    public List<PropuestaRecibVO> getPropuestaRecibList() {
        return propuestaRecibList;
    }

    public void setOficioAdjudicaList(List<OficioAdjudicaVO> oficioAdjudicaList) {
        this.oficioAdjudicaList = oficioAdjudicaList;
    }


    public void setProveedorInvitacionList(List<ProveedorInvitacionVO> proveedorInvitacionList) {
        this.proveedorInvitacionList = proveedorInvitacionList;
    }

    public List<ProveedorInvitacionVO> getProveedorInvitacionList() {
        return proveedorInvitacionList;
    }

    public List<OficioAdjudicaVO> getOficioAdjudicaList() {
        return oficioAdjudicaList;
    }

    public void setRpList(List<RpVO> rpList) {
        this.rpList = rpList;
    }

    public List<RpVO> getRpList() {
        return rpList;
    }
    
    
    /**
     * Obtiene el tipo de Retenci&oacute;n de Rentas asociado a la Persona.
     * @return personaVo->tipoRetencion
     */
    public TipoRetencionVO getTipoRetencionRentas () {
        return (personaVo!=null?personaVo.getTipoRetencionRentasVo():null);
    }
    
    
    /**
     * Obtiene el tipo de Retenci&oacute;n de Ventas asociado a la Persona.
     * @return personaVo->tipoRetencion
     */
    public TipoRetencionVO getTipoRetencionVentas () {
        return (personaVo!=null?personaVo.getTipoRetencionVentasVo():null);
    }
    
    
    /**
     * Obtiene la Actividad ICA principal asociada a la Persona.
     * @return personaVo->actividadIcaPers->actividadIca
     */
    public ActividadIcaVO getActividadIcaPrincipal () {
        return (personaVo!=null && personaVo.getActividadIcaPersPrincipal()!=null ? personaVo.getActividadIcaPersPrincipal().getActividadIcaVo():null);
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) 
    {
        boolean igual = false;
        if (o instanceof ProveedorVO) {
            ProveedorVO pVO = (ProveedorVO) o;
            if (pVO!=null) {
                igual = ( (pVO.proCodigo!=null && pVO.proCodigo.equals(this.proCodigo)) || (pVO.proCodigo==null && this.proCodigo==null) ) && 
                        ( (pVO.proEjecutivoCuenta!=null && pVO.proEjecutivoCuenta.equals(this.proEjecutivoCuenta)) || (pVO.proEjecutivoCuenta==null && this.proEjecutivoCuenta==null) ) &&
                        ( (pVO.personaVo!=null && pVO.personaVo.equals(this.personaVo)) || (pVO.personaVo==null && this.personaVo==null) );
            }
        }
        return (igual);
    }
}

