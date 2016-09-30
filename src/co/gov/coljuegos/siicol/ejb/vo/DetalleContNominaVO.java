/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 19-06-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleContNomina;

import java.math.BigDecimal;

import java.util.List;


/**
 * Value Object para el Detalle de Cargue de Archivos de N&oacute;mina.
 * @author Camilo Miranda
 */
public class DetalleContNominaVO 
{
    /** Concepto asociado al Valor Total a Pagar */
    public final static String CONCEPTO_TOTAL_A_PAGAR = "999";
    
    
    private Long dcmCodigo;
    private String dcmContrato;
    private String dcmReferencia1;
    private Integer dcmTipoRetencion;
    private BigDecimal dcmValor;
    
    private FuenteFinancContabVO fuenteFinancContabVo;
    private PersonaVO personaVo;
    private AreaColjuegosVO areaColjuegosVo;
    private ObligacionVO obligacionVo;
    private RpVO rpVo;
    private ConceptoNominaVO conceptoNominaVo;
    private CargaNominaVO cargaNominaVo;
    
    private List<NotaCredOblConceptoVO> notaCredOblConceptoList;
    
    
    
    /**
     * Constructor.
     */
    public DetalleContNominaVO() { }
    
    
    /**
     * Constructor.
     * @param siiDetalleContNomina - Entity.
     */
    public DetalleContNominaVO (SiiDetalleContNomina siiDetalleContNomina) 
    {
        if (siiDetalleContNomina!=null) {
            this.dcmCodigo = siiDetalleContNomina.getDcmCodigo();
            this.dcmContrato = siiDetalleContNomina.getDcmContrato();
            this.dcmReferencia1 = siiDetalleContNomina.getDcmReferencia1();
            this.dcmTipoRetencion = siiDetalleContNomina.getDcmTipoRetencion();
            this.dcmValor = siiDetalleContNomina.getDcmValor();
            
            
            if (siiDetalleContNomina.getSiiFuenteFinancContab()!=null) {
                this.fuenteFinancContabVo = new FuenteFinancContabVO(siiDetalleContNomina.getSiiFuenteFinancContab());
            }
            
            if (siiDetalleContNomina.getSiiPersona()!=null) {
                this.personaVo = new PersonaVO(siiDetalleContNomina.getSiiPersona());
            }
            
            if (siiDetalleContNomina.getSiiAreaColjuegos()!=null) {
                this.areaColjuegosVo = new AreaColjuegosVO(siiDetalleContNomina.getSiiAreaColjuegos());
            }
            
            if (siiDetalleContNomina.getSiiObligacion()!=null) {
                this.obligacionVo = new ObligacionVO(siiDetalleContNomina.getSiiObligacion());
            }
            
            if (siiDetalleContNomina.getSiiRp()!=null) {
                this.rpVo = new RpVO(siiDetalleContNomina.getSiiRp());
            }
            
            if (siiDetalleContNomina.getSiiConceptoNomina()!=null) {
                this.conceptoNominaVo = new ConceptoNominaVO(siiDetalleContNomina.getSiiConceptoNomina());
            }
            
            if (siiDetalleContNomina.getSiiCargaNomina()!=null) {
                this.cargaNominaVo = new CargaNominaVO(siiDetalleContNomina.getSiiCargaNomina());
            }
        }
    }


    public void setDcmCodigo(Long dcmCodigo) {
        this.dcmCodigo = dcmCodigo;
    }

    public Long getDcmCodigo() {
        return dcmCodigo;
    }

    public void setDcmReferencia1(String dcmReferencia1) {
        this.dcmReferencia1 = dcmReferencia1;
    }

    public String getDcmReferencia1() {
        return dcmReferencia1;
    }

    public void setDcmTipoRetencion(Integer dcmTipoRetencion) {
        this.dcmTipoRetencion = dcmTipoRetencion;
    }

    public Integer getDcmTipoRetencion() {
        return dcmTipoRetencion;
    }

    public void setDcmValor(BigDecimal dcmValor) {
        this.dcmValor = dcmValor;
    }

    public BigDecimal getDcmValor() {
        return dcmValor;
    }

    public void setFuenteFinancContabVo(FuenteFinancContabVO fuenteFinancContabVo) {
        this.fuenteFinancContabVo = fuenteFinancContabVo;
    }

    public FuenteFinancContabVO getFuenteFinancContabVo() {
        return fuenteFinancContabVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setAreaColjuegosVo(AreaColjuegosVO areaColjuegosVo) {
        this.areaColjuegosVo = areaColjuegosVo;
    }

    public AreaColjuegosVO getAreaColjuegosVo() {
        return areaColjuegosVo;
    }

    public void setObligacionVo(ObligacionVO obligacionVo) {
        this.obligacionVo = obligacionVo;
    }

    public ObligacionVO getObligacionVo() {
        return obligacionVo;
    }

    public void setRpVo(RpVO rpVo) {
        this.rpVo = rpVo;
    }

    public RpVO getRpVo() {
        return rpVo;
    }

    public void setConceptoNominaVo(ConceptoNominaVO conceptoNominaVo) {
        this.conceptoNominaVo = conceptoNominaVo;
    }

    public ConceptoNominaVO getConceptoNominaVo() {
        return conceptoNominaVo;
    }

    public void setDcmContrato(String dcmContrato) {
        this.dcmContrato = dcmContrato;
    }

    public String getDcmContrato() {
        return dcmContrato;
    }

    public void setCargaNominaVo(CargaNominaVO cargaNominaVo) {
        this.cargaNominaVo = cargaNominaVo;
    }

    public CargaNominaVO getCargaNominaVo() {
        return cargaNominaVo;
    }

    public void setNotaCredOblConceptoList(List<NotaCredOblConceptoVO> notaCredOblConceptoList) {
        this.notaCredOblConceptoList = notaCredOblConceptoList;
    }

    public List<NotaCredOblConceptoVO> getNotaCredOblConceptoList() {
        return notaCredOblConceptoList;
    }
}
