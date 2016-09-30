package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacion;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ObligacionVO {
    
    private Long oblCodigo;
    private Date oblFecha;
    private Integer oblNumero;
    private BigDecimal oblSubtotal;
    private BigDecimal oblIva;
    private String oblMotivoAnula;
    
    private EstadoObligacionVO estadoObligacionVo;
    private SolicitudPagoVO solicitudPagoVo;
    private UsuarioVO usuarioRegVo;
    private UsuarioVO usuarioAprVo;
    private TipoDocContableVO tipoDocContableVo;
    private CargaNominaVO cargaNominaVo;
    private RpVO rpVo;
    private DistribucionMesVO distribucionMesVo;
    private PersonaVO personaBenefic;
    private DetalleDistribVO detalleDistribVo;
    private ConsolidadoDistVO consolidadoDistVo;
    
    private List<ObligacionConceptoVO> obligacionConceptoListVo;
    private List<DocumentoContableVO> documentoContableList;
    private List<OrdenPagoVO> ordenPagoList;
    private List<OblConcRpDetRubCdpVO> oblConcRpDetRubCdpList;
    private List<DetalleContNominaVO> detalleContNominaList;
    private List<NotaCreditoVO> notaCreditoList;
    
    // Manejo de cambio de estados
    private Long idEstadoAnterior;
    
    
    
    /**
     * Constructor.
     */
    public ObligacionVO() { }
    
    
    /**
     * Constructor.
     * @param siiObligacion
     */
    public ObligacionVO(SiiObligacion siiObligacion) {
        
        if (siiObligacion!=null) {
            this.oblCodigo = siiObligacion.getOblCodigo();
            this.oblFecha = siiObligacion.getOblFecha();
            this.oblNumero = siiObligacion.getOblNumero();
            this.oblSubtotal = siiObligacion.getOblSubtotal();
            this.oblIva = siiObligacion.getOblIva();
            this.oblMotivoAnula = siiObligacion.getOblMotivoAnula();
            
            if(siiObligacion.getSiiSolicitudPago() != null){
                this.solicitudPagoVo =  new SolicitudPagoVO(siiObligacion.getSiiSolicitudPago());
            }
            if(siiObligacion.getSiiUsuarioReg() != null){
                this.usuarioRegVo =  new UsuarioVO(siiObligacion.getSiiUsuarioReg());
            }
            if(siiObligacion.getSiiUsuarioApr() != null){
                this.usuarioAprVo =  new UsuarioVO(siiObligacion.getSiiUsuarioApr());
            }
            if(siiObligacion.getSiiEstadoObligacion() != null){
                this.estadoObligacionVo = new EstadoObligacionVO(siiObligacion.getSiiEstadoObligacion());
                this.idEstadoAnterior = siiObligacion.getSiiEstadoObligacion().getEobCodigo();
            }
            if (siiObligacion.getSiiTipoDocContable() != null) {
                this.tipoDocContableVo = new TipoDocContableVO(siiObligacion.getSiiTipoDocContable());
            }
            if (siiObligacion.getSiiCargaNomina() != null) {
                this.cargaNominaVo = new CargaNominaVO(siiObligacion.getSiiCargaNomina());
            }
            if (siiObligacion.getSiiRp() != null) {
                this.rpVo = new RpVO(siiObligacion.getSiiRp());
            }
            if (siiObligacion.getSiiDistribucionMes() != null) {
                this.distribucionMesVo = new DistribucionMesVO(siiObligacion.getSiiDistribucionMes());
            }
            if (siiObligacion.getSiiPersonaBenefic() != null) {
                this.personaBenefic = new PersonaVO(siiObligacion.getSiiPersonaBenefic());
            }
            if (siiObligacion.getSiiDetalleDistrib() != null) {
                this.detalleDistribVo = new DetalleDistribVO(siiObligacion.getSiiDetalleDistrib());
            }
            if (siiObligacion.getSiiConsolidadoDist() != null) {
                this.consolidadoDistVo = new ConsolidadoDistVO(siiObligacion.getSiiConsolidadoDist());
            }
        }
    }


    public void setEstadoObligacionVo(EstadoObligacionVO estadoObligacionVo) {
        this.estadoObligacionVo = estadoObligacionVo;
    }

    public EstadoObligacionVO getEstadoObligacionVo() {
        return estadoObligacionVo;
    }

    public void setOblCodigo(Long oblCodigo) {
        this.oblCodigo = oblCodigo;
    }

    public Long getOblCodigo() {
        return oblCodigo;
    }

    public void setOblFecha(Date oblFecha) {
        this.oblFecha = oblFecha;
    }

    public Date getOblFecha() {
        return oblFecha;
    }

    public void setOblNumero(Integer oblNumero) {
        this.oblNumero = oblNumero;
    }

    public Integer getOblNumero() {
        return oblNumero;
    }


    public void setOblSubtotal(BigDecimal oblSubtotal) {
        this.oblSubtotal = oblSubtotal;
    }

    public BigDecimal getOblSubtotal() {
        return oblSubtotal;
    }

    public void setTipoDocContableVo(TipoDocContableVO tipoDocContableVo) {
        this.tipoDocContableVo = tipoDocContableVo;
    }

    public TipoDocContableVO getTipoDocContableVo() {
        return tipoDocContableVo;
    }

    public void setSiiSolicitudPago(SolicitudPagoVO siiSolicitudPago) {
        this.solicitudPagoVo = siiSolicitudPago;
    }

    public SolicitudPagoVO getSiiSolicitudPago() {
        return solicitudPagoVo;
    }

    public void setSiiUsuarioReg(UsuarioVO siiUsuarioReg) {
        this.usuarioRegVo = siiUsuarioReg;
    }

    public UsuarioVO getSiiUsuarioReg() {
        return usuarioRegVo;
    }

    public void setSiiObligacionConceptoList(List<ObligacionConceptoVO> siiObligacionConceptoList) {
        this.obligacionConceptoListVo = siiObligacionConceptoList;
    }

    public List<ObligacionConceptoVO> getSiiObligacionConceptoList() {
        return obligacionConceptoListVo;
    }

    public void setSiiUsuarioApr(UsuarioVO siiUsuarioApr) {
        this.usuarioAprVo = siiUsuarioApr;
    }

    public UsuarioVO getSiiUsuarioApr() {
        return usuarioAprVo;
    }

    public void setOblIva(BigDecimal oblIva) {
        this.oblIva = oblIva;
    }

    public BigDecimal getOblIva() {
        return oblIva;
    }


    public void setDocumentoContableList(List<DocumentoContableVO> documentoContableList) {
        this.documentoContableList = documentoContableList;
    }

    public List<DocumentoContableVO> getDocumentoContableList() {
        return documentoContableList;
    }
    
    
    /**
     * Obtiene el Documento Contable.
     * (En la pr&aacute;ctica, s&oacute;lamente existe un (1) Documento Contable por Obligaci&oacute;n)
     * @return documentoContableList.first
     */
    public DocumentoContableVO getDocumentoContable () {
        return ( documentoContableList!=null && !documentoContableList.isEmpty()?documentoContableList.get(0):null );
    }
    
    
    /**
     * Establece el Documento Contable.
     * (En la pr&aacute;ctica, s&oacute;lamente existe un (1) Documento Contable por Obligaci&oacute;n)
     * @param documentoContableVO
     */
    public void setDocumentoContable (DocumentoContableVO documentoContableVO) {
        if (documentoContableList==null)
            documentoContableList = new ArrayList<DocumentoContableVO>();
        else
            documentoContableList.clear();
        
        if (documentoContableVO!=null) {
            documentoContableVO.setObligacionVo(this);
            documentoContableList.add(documentoContableVO);
        }
    }
    

    public void setOrdenPagoList(List<OrdenPagoVO> ordenPagoList) {
        this.ordenPagoList = ordenPagoList;
    }

    public List<OrdenPagoVO> getOrdenPagoList() {
        return ordenPagoList;
    }

    public void setCargaNominaVo(CargaNominaVO cargaNominaVo) {
        this.cargaNominaVo = cargaNominaVo;
    }

    public CargaNominaVO getCargaNominaVo() {
        return cargaNominaVo;
    }

    public void setDetalleContNominaList(List<DetalleContNominaVO> detalleContNominaList) {
        this.detalleContNominaList = detalleContNominaList;
    }

    public List<DetalleContNominaVO> getDetalleContNominaList() {
        return detalleContNominaList;
    }

    public void setOblMotivoAnula(String oblMotivoAnula) {
        this.oblMotivoAnula = oblMotivoAnula;
    }

    public String getOblMotivoAnula() {
        return oblMotivoAnula;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setRpVo(RpVO rpVo) {
        this.rpVo = rpVo;
    }

    public RpVO getRpVo() {
        return rpVo;
    }

    public void setDistribucionMesVo(DistribucionMesVO distribucionMesVo) {
        this.distribucionMesVo = distribucionMesVo;
    }

    public DistribucionMesVO getDistribucionMesVo() {
        return distribucionMesVo;
    }

    public void setPersonaBenefic(PersonaVO personaBenefic) {
        this.personaBenefic = personaBenefic;
    }

    public PersonaVO getPersonaBenefic() {
        return personaBenefic;
    }

    public void setConsolidadoDistVo(ConsolidadoDistVO consolidadoDistVo) {
        this.consolidadoDistVo = consolidadoDistVo;
    }

    public ConsolidadoDistVO getConsolidadoDistVo() {
        return consolidadoDistVo;
    }

    public void setNotaCreditoList(List<NotaCreditoVO> notaCreditoList) {
        this.notaCreditoList = notaCreditoList;
    }

    public List<NotaCreditoVO> getNotaCreditoList() {
        return notaCreditoList;
    }
    
    


    /**
     * Adiciona un registro al listado de DetalleContNominaVO.
     * @param detalleContNominaVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addDetalleContNomina (DetalleContNominaVO detalleContNominaVo) 
    {
        boolean exitoso = false;
        
        if (detalleContNominaList==null)
            detalleContNominaList = new ArrayList<DetalleContNominaVO>();
        
        exitoso = detalleContNominaList.add(detalleContNominaVo);
        
        if (exitoso)
            detalleContNominaVo.setObligacionVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado DetalleContNominaVO.
     * @param detalleContNominaVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeDetalleContNomina (DetalleContNominaVO detalleContNominaVo) {
        boolean exitoso = false;
        
        if (detalleContNominaList!=null) {
            exitoso = detalleContNominaList.remove(detalleContNominaVo);
            
            if (exitoso)
                detalleContNominaVo.setObligacionVo(null);
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * Totaliza la sumatoria de los totales de c/u de los Conceptos que conforman la Obligaci&oacute;n.
     * @return Sumatoria de Valores Totales de Conceptos.
     */
    public BigDecimal getValorTotal() {
        BigDecimal total = new BigDecimal(0);
        if (obligacionConceptoListVo!=null) {
            for (ObligacionConceptoVO concepto: obligacionConceptoListVo) {
                BigDecimal ocoSubtotal = concepto.getOcoSubtotal() != null ? concepto.getOcoSubtotal() : new BigDecimal(0);
                BigDecimal ocoIva = concepto.getOcoIva() !=null ? concepto.getOcoIva() : new BigDecimal(0);
                BigDecimal subtotal = ocoSubtotal.add(ocoIva);
                total = total.add(subtotal);
            }
        }
        return (total);
    }
    
    
    
    /**
     * Realiza la suma de los Subtotales de c/u de los Conceptos que conforman la Obligaci&oacute;n.
     * @return Sumatoria de Subtotales de Conceptos.
     */
    public BigDecimal getSubtotal() {
        BigDecimal resultado = new BigDecimal(0);
        if (obligacionConceptoListVo!=null) {
            for (ObligacionConceptoVO concepto: obligacionConceptoListVo) {
                BigDecimal ocoSubtotal = concepto.getOcoSubtotal() != null ? concepto.getOcoSubtotal() : new BigDecimal(0);
                resultado = resultado.add(ocoSubtotal);
            }
        }
        return (resultado);
    }
    
    
    
    public void setOblConcRpDetRubCdpList(List<OblConcRpDetRubCdpVO> oblConcRpDetRubCdpList) {
        this.oblConcRpDetRubCdpList = oblConcRpDetRubCdpList;
    }

    public List<OblConcRpDetRubCdpVO> getOblConcRpDetRubCdpList() {
        return oblConcRpDetRubCdpList;
    }
    
    
    /**
     * Adiciona un registro al listado de OblConcRpDetRubCdpVO.
     * @param oblConcRpDetRubCdpVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addOblConcRpDetRubCdp (OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) 
    {
        boolean exitoso = false;
        
        if (oblConcRpDetRubCdpList==null)
            oblConcRpDetRubCdpList = new ArrayList<OblConcRpDetRubCdpVO>();
        
        exitoso = oblConcRpDetRubCdpList.add(oblConcRpDetRubCdpVo);
        
        if (exitoso)
            oblConcRpDetRubCdpVo.setObligacionVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado OblConcRpDetRubCdpVO.
     * @param oblConcRpDetRubCdpVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeOblConcRpDetRubCdp (OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) {
        boolean exitoso = false;
        
        if (oblConcRpDetRubCdpList!=null) {
            exitoso = oblConcRpDetRubCdpList.remove(oblConcRpDetRubCdpVo);
            
            if (exitoso)
                oblConcRpDetRubCdpVo.setObligacionVo(null);
        }
        
        return (exitoso);
    }

    
    /**
     * @deprecated Usar co.gov.coljuegos.siicol.ejb.vo.ObligacionVO.setConsolidadoDistVo(co.gov.coljuegos.siicol.ejb.vo.ConsolidadoDistVO)
     */
    public void setDetalleDistribVo(DetalleDistribVO detalleDistribVo) {
        this.detalleDistribVo = detalleDistribVo;
    }
    
    /**
     * @deprecated Usar co.gov.coljuegos.siicol.ejb.vo.ObligacionVO.getConsolidadoDistVo()
     */
    public DetalleDistribVO getDetalleDistribVo() {
        return detalleDistribVo;
    }
    
    
    


    ///////////////////////////////////////////////////////
    // Metodos para la Obligacion de Funcionarios Planta //
    ///////////////////////////////////////////////////////
    
    /**
     * Obtiene el Beneficiario a partir del registro del Detalle de N&oacute;mina cuyo concepto sea el <i>Total a Pagar (999)</i>.
     * @return detalleContNominaVo[999].personaVo
     */
    public PersonaVO getBeneficiarioTotalAPagar() {
        PersonaVO personaVo = null;
        if (detalleContNominaList!=null && !detalleContNominaList.isEmpty()) {
            Iterator<DetalleContNominaVO> it = detalleContNominaList.iterator();
            while (it.hasNext() && personaVo==null) {
                DetalleContNominaVO detalle = it.next();
                if (detalle!=null) {
                    // obtener el registro asociado al concepto 999, para obtener el beneficiario
                    ConceptoNominaVO conceptoNominaVo = detalle.getConceptoNominaVo();
                    if (conceptoNominaVo!=null && conceptoNominaVo.getCnoCodigo()!=null && 
                        DetalleContNominaVO.CONCEPTO_TOTAL_A_PAGAR.equals(conceptoNominaVo.getCnoCodigo())) 
                    {
                        personaVo = detalle.getPersonaVo();
                    }
                }
            }
        }
        return (personaVo);
    }
    
    
    /**
     * Obtiene el Beneficiario a partir del primer registro del Detalle de N&oacute;mina.
     * @return detalleContNominaList(0).rpVo
     */
    public RpVO getRpDetalleContNomina() {
        RpVO rpVo = null;
        if (detalleContNominaList!=null && !detalleContNominaList.isEmpty()) {
            // obtener el primer registro, ya que el RP es el mismo dentro de c/u de los detalles
            DetalleContNominaVO detalle = detalleContNominaList.get(0);
            if (detalle!=null) {
                rpVo = detalle.getRpVo();
            }
        }
        return (rpVo);
    }
    
    
    /**
     * Obtiene el Mes de la N&oacute;mina a partir del primer registro del Detalle de N&oacute;mina.
     * @return detalleContNominaList(0).dcmReferencia1
     */
    public String getMesNomina() {
        String mes = null;
        if (detalleContNominaList!=null && !detalleContNominaList.isEmpty()) {
            // obtener el primer registro, ya que el beneficiario es el mismo dentro de c/u de los detalles
            DetalleContNominaVO detalle = detalleContNominaList.get(0);
            if (detalle!=null) {
                mes = detalle.getDcmReferencia1();
            }
        }
        return (mes);
    }
    
    
    
    /**
     * Obtiene el valor total resultante de la sumatoria de los valores en c/u de los Detalles de N&oacute;mina.
     * @return Sumatoria de valores relacionados con la Obligacion.
     */
    public BigDecimal getValorDetallesNomina () {
        BigDecimal total = new BigDecimal(0);
        // sumatoria de los valores de los detalles que se encuentren asociados a RPs (valores positivos), a excepcion del concepto 999
        BigDecimal sumatoria = new BigDecimal(0);
        
        if (detalleContNominaList!=null && !detalleContNominaList.isEmpty()) {
            boolean encontrado = false;
            Iterator<DetalleContNominaVO> it = detalleContNominaList.iterator();
            while (it.hasNext() && !encontrado) {
                DetalleContNominaVO detalleContNominaVo = it.next();
                if (detalleContNominaVo!=null && detalleContNominaVo.getDcmValor()!=null) {
                    // si el concepto corresponde al Total a Pagar, se toma el valor de dicho detalle como el total de la obligacion
                    ConceptoNominaVO conceptoNominaVo = detalleContNominaVo.getConceptoNominaVo();
                    if (conceptoNominaVo!=null && conceptoNominaVo.getCnoCodigo()!=null) {
                        if (DetalleContNominaVO.CONCEPTO_TOTAL_A_PAGAR.equals(conceptoNominaVo.getCnoCodigo())) {
                            total = detalleContNominaVo.getDcmValor();
                            encontrado = true;
                        }
                        else {
                            // si el detalle se encuentra asociado a un RP, corresponde a un valor positivo que se debe sumar
                            if (detalleContNominaVo.getRpVo()!=null) {
                                sumatoria = sumatoria.add(detalleContNominaVo.getDcmValor());
                            }
                        }
                    }
                }
            }
            
            if (!encontrado) {
                total = sumatoria;
            }
        }
        return (total);
    }
    
    
    
    /**
     * Obtiene el valor total resultante de la sumatoria de los valores en c/u de los Detalles de N&oacute;mina que pertenezcan a la Fuente de Financiaci&oacute;n Contable especificada.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return Sumatoria de valores relacionados con la Obligacion.
     */
    public BigDecimal getValorDetallesNomina (String ffcCodigo) {
        BigDecimal total = new BigDecimal(0);
        // sumatoria de los valores de los detalles que se encuentren asociados a RPs (valores positivos), a excepcion del concepto 999
        BigDecimal sumatoria = new BigDecimal(0);
        
        if (ffcCodigo!=null && detalleContNominaList!=null && !detalleContNominaList.isEmpty()) {
            boolean encontrado = false;
            Iterator<DetalleContNominaVO> it = detalleContNominaList.iterator();
            while (it.hasNext() && !encontrado) {
                DetalleContNominaVO detalleContNominaVo = it.next();
                
                // solamente acumula los valores pertenecientes a la fuente de financiacion contable especificada
                if (detalleContNominaVo!=null && detalleContNominaVo.getDcmValor()!=null && 
                    detalleContNominaVo.getFuenteFinancContabVo()!=null && ffcCodigo.equals(detalleContNominaVo.getFuenteFinancContabVo().getFfcCodigo())) 
                {
                    ConceptoNominaVO conceptoNominaVo = detalleContNominaVo.getConceptoNominaVo();
                    if (conceptoNominaVo!=null && conceptoNominaVo.getCnoCodigo()!=null) {
                        if (DetalleContNominaVO.CONCEPTO_TOTAL_A_PAGAR.equals(conceptoNominaVo.getCnoCodigo())) {
                            total = detalleContNominaVo.getDcmValor();
                            encontrado = true;
                        }
                        else {
                            // si el detalle se encuentra asociado a un RP, corresponde a un valor positivo que se debe sumar
                            if (detalleContNominaVo.getRpVo()!=null) {
                                sumatoria = sumatoria.add(detalleContNominaVo.getDcmValor());
                            }
                        }
                    }
                }
            }
            
            if (!encontrado) {
                total = sumatoria;
            }
        }
        return (total);
    }
    
    
    
    /**
     * Obtiene el Detalle Contable de N&oacute;mina asociado al concepto de <b>Total a Pagar</b> (999).
     * @return Instancia de DetalleContNominaVO
     */
    public DetalleContNominaVO getDetalleContNominaTotalAPagar() 
    {
        if (detalleContNominaList!=null && !detalleContNominaList.isEmpty()) {
            for (DetalleContNominaVO detalle: detalleContNominaList) {
                if (detalle!=null) {
                    ConceptoNominaVO conceptoNominaVo = detalle.getConceptoNominaVo();
                    if (conceptoNominaVo!=null && conceptoNominaVo.getCnoCodigo()!=null) {
                        if (conceptoNominaVo.getCnoCodigo().equals(DetalleContNominaVO.CONCEPTO_TOTAL_A_PAGAR)) 
                        {
                            return (detalle);
                        }
                    }
                }
            }
        }
        
        return (null);
    }
    
    
    
    
    
    
    /**
     * Obtiene el listado de Fuentes de Financiaci&oacute;n Contable asociados a los Detalles de N&oacute;mina de la Obligaci&oacute;n.
     * @return Listado de FuenteFinancContabVO.
     */
    public List<FuenteFinancContabVO> getFuentesFinancContabDetallesNomina() 
    {
        List<FuenteFinancContabVO> resultado = null;
        
        if (detalleContNominaList!=null && !detalleContNominaList.isEmpty()) {
            resultado = new ArrayList<FuenteFinancContabVO>();
            
            
            // obtener inicialmente la fuente de Financiacion Contable a partir del concepto "Total a Pagar"
            DetalleContNominaVO detalleTotalAPagar = this.getDetalleContNominaTotalAPagar();
            if (detalleTotalAPagar!=null && detalleTotalAPagar.getFuenteFinancContabVo()!=null) {
                resultado.add(detalleTotalAPagar.getFuenteFinancContabVo());
            }
            else {
                // obtener c/u de las fuentes de financiacion contable asociadas en los detalles de nomina
                Map<String, FuenteFinancContabVO> fuentesFC = new HashMap<String, FuenteFinancContabVO>();
                
                for (DetalleContNominaVO detalle: detalleContNominaList) {
                    if (detalle!=null && detalle.getFuenteFinancContabVo()!=null && detalle.getFuenteFinancContabVo().getFfcCodigo()!=null) 
                    {
                        if (!fuentesFC.containsKey(detalle.getFuenteFinancContabVo().getFfcCodigo())) {
                            // adicionar fuente de financiacion sin registros duplicados
                            fuentesFC.put(detalle.getFuenteFinancContabVo().getFfcCodigo(), detalle.getFuenteFinancContabVo());
                        }
                    }
                }
                
                if (fuentesFC!=null && !fuentesFC.isEmpty()) {
                    Collection<FuenteFinancContabVO> collectionFuentesFC = fuentesFC.values();
                    for (FuenteFinancContabVO ffcVo: collectionFuentesFC) {
                        resultado.add(ffcVo);
                    }
                }
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Genera una cadena que contiene los nombres de las Fuentes de Financiaci&oacute;n Contable asociadas en los Detalles de N&oacute;mina de la Obligaci&oacute;n.
     * @return Cadena de nombres de Fuentes de Financiaci&oacute;n Contable.
     */
    public String getNombresFuenteFinancContab() {
        String resultado = null;
        List<FuenteFinancContabVO> listaFFC = this.getFuentesFinancContabDetallesNomina();
        if (listaFFC!=null) {
            StringBuilder nombres = new StringBuilder();
            Iterator<FuenteFinancContabVO> it = listaFFC.iterator();
            while (it.hasNext()) {
                FuenteFinancContabVO ffcVo = it.next();
                if (ffcVo!=null && ffcVo.getFccNombre()!=null) {
                    nombres.append(ffcVo.getFccNombre());
                    
                    if (it.hasNext())
                        nombres.append(", ");
                }
            }
            
            resultado = nombres.toString();
        }
        return (resultado);
    }
    
    
    
    
    /**
     * Obtiene el Valor a Pagar a partir del Detalle de Distribuci&oacute;n asociado a la Obligaci&oacute;n.
     * @return Valor a Pagar.
     */
    public BigDecimal getTotalTransferir() 
    {
        BigDecimal totalTransferir = new BigDecimal(0);
        
        if (this.oblSubtotal!=null)
            totalTransferir = totalTransferir.add(this.oblSubtotal);
        
        if (this.oblIva!=null)
            totalTransferir = totalTransferir.add(this.oblIva);
        
        return (totalTransferir);
    }
    
    
    /**
     * Suma del valor a girar de los conceptos asociados a la Obligaci&oacute;n, que pertenezcan a la Fuente de financiaci&oacute;n especificada.
     * @param ffcCodigo - Fuente de financiaci&oacute;n.
     * @return Valor a Girar.
     */
    public BigDecimal getValorAGirar (String ffcCodigo) {
        BigDecimal valorGirar = new BigDecimal(0);
        if (ffcCodigo!=null && this.obligacionConceptoListVo!=null) {
            for (ObligacionConceptoVO ocoVo: this.obligacionConceptoListVo) {
                if (ocoVo!=null && ocoVo.getValorAGirar()!=null && ocoVo.getFuenteFinancContabVo()!=null && ffcCodigo.equals(ocoVo.getFuenteFinancContabVo().getFfcCodigo()))
                    valorGirar = valorGirar.add(ocoVo.getValorAGirar());
            }
        }
        return (valorGirar);
    }
    
    
    /**
     * Suma del Valor a Descontar de los conceptos de las Notas cr&eacute;dito asociadas a la Obligaci&oacute;n seleccionada, que tengan Fuente de Financiaci&oacute;n especificada.
     * @param ffcCodigo - Fuente de Financiaci&oacute;n.
     * @return Valor de Notas de Cr&eacute;dito.
     */
    public BigDecimal getValorDescontarNotasCredito (String ffcCodigo) {
        BigDecimal valorNotasCred = new BigDecimal(0);
        if (ffcCodigo!=null && this.notaCreditoList!=null) {
            for (NotaCreditoVO ncrVo: this.notaCreditoList) {
                if (ncrVo!=null && ncrVo.getNotaCredOblConceptoList()!=null && ncrVo.getFuenteFinancContabVo()!=null && ffcCodigo.equals(ncrVo.getFuenteFinancContabVo().getFfcCodigo())) {
                    // recorrer cada concepto de nota de credito
                    for (NotaCredOblConceptoVO ncocoVo: ncrVo.getNotaCredOblConceptoList()) {
                        if (ncocoVo!=null && ncocoVo.getValorADescontar()!=null)
                            valorNotasCred = valorNotasCred.add(ncocoVo.getValorADescontar());
                    }
                }
            }
        }
        return (valorNotasCred);
    }
    
    
    /**
     * Obtiene el valor de los gastos obtenidos de los conceptos y notas de cr&eacute;dito de la Obligaci&oacute;n, necesarios para la generaci&oacute;n de la Orden de Pago correspondiente, de acuerdo a la Fuente de Financiaci&oacute;n especificada.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return Valor a Girar de las Obligaciones - Valor a Descontar de Notas de Cr&eacute;dito.
     */
    public BigDecimal getValorGastosOrdenPago (String ffcCodigo) 
    {
        BigDecimal valorGastos = new BigDecimal(0);
        if (ffcCodigo!=null) {
            BigDecimal valorGirarObligaciones = this.getValorAGirar(ffcCodigo);
            BigDecimal valorDescontarNotasCredito = this.getValorDescontarNotasCredito(ffcCodigo);
            if (valorGirarObligaciones!=null)
                valorGastos = valorGastos.add(valorGirarObligaciones);
            if (valorDescontarNotasCredito!=null)
                valorGastos = valorGastos.subtract(valorDescontarNotasCredito);
        }
        return (valorGastos);
    }
}
