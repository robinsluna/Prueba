/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoMovimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;

import java.math.BigDecimal;


/**
 * Value Object para la Imputaci&oacute;n Contable.
 * @author Camilo Miranda
 */
public class ImputacionContableVO 
{
    private Long imcCodigo;
    private String imcConcepto;
    private String imcDescrOperacion;
    private String imcReferencia1;
    private String imcReferencia2;
    private String imcTipoMovim;
    private BigDecimal imcValor;
    private String imcEstado;
    private BigDecimal imcBase;
    private Integer imcAgrupacion;
    
    private DocumentoContableVO documentoContableVo;
    private FuenteFinancContabVO fuenteFinancContabVo;
    private AreaColjuegosVO areaColjuegosVo;
    private ConcepInfExogenaVO concepInfExogenaVo;
    private CuentasContablesVO cuentasContablesVo;
    private PersonaVO personaVo;
    private TipoRetencionVO tipoRetencionVenta;
    private TipoRetencionVO tipoRetencionRenta;
    
    
    
    
    /**
     * Constructor.
     */
    public ImputacionContableVO() { }
    
    
    /**
     * Constructor.
     * @param siiImputacionContable
     */
    public ImputacionContableVO (SiiImputacionContable siiImputacionContable) {
        if (siiImputacionContable!=null) {
            this.imcCodigo = siiImputacionContable.getImcCodigo();
            this.imcConcepto = siiImputacionContable.getImcConcepto();
            this.imcDescrOperacion = siiImputacionContable.getImcDescrOperacion();
            this.imcReferencia1 = siiImputacionContable.getImcReferencia1();
            this.imcReferencia2 = siiImputacionContable.getImcReferencia2();
            this.imcTipoMovim = siiImputacionContable.getImcTipoMovim();
            this.imcValor = siiImputacionContable.getImcValor();
            this.imcEstado = siiImputacionContable.getImcEstado();
            this.imcBase = siiImputacionContable.getImcBase();
            this.imcAgrupacion = siiImputacionContable.getImcAgrupacion();
            
            if (siiImputacionContable.getSiiAreaColjuegos()!=null) {
                this.areaColjuegosVo = new AreaColjuegosVO(siiImputacionContable.getSiiAreaColjuegos());
            }
            
            if (siiImputacionContable.getSiiConcepInfExogena()!=null) {
                this.concepInfExogenaVo = new ConcepInfExogenaVO(siiImputacionContable.getSiiConcepInfExogena());
            }
            
            if (siiImputacionContable.getSiiCuentasContables()!=null) {
                this.cuentasContablesVo = new CuentasContablesVO(siiImputacionContable.getSiiCuentasContables());
            }
            
            if (siiImputacionContable.getSiiDocumentoContable()!=null) {
                this.documentoContableVo = new DocumentoContableVO(siiImputacionContable.getSiiDocumentoContable());
            }
            
            if (siiImputacionContable.getSiiFuenteFinancContab()!=null) {
                this.fuenteFinancContabVo = new FuenteFinancContabVO(siiImputacionContable.getSiiFuenteFinancContab());
            }
            
            if (siiImputacionContable.getSiiPersona()!=null) {
                this.personaVo = new PersonaVO(siiImputacionContable.getSiiPersona());
            }
            
            if (siiImputacionContable.getSiiTipoRetencionRenta() != null) {
                this.tipoRetencionRenta = new TipoRetencionVO(siiImputacionContable.getSiiTipoRetencionRenta());
            }
            
            if (siiImputacionContable.getSiiTipoRetencionVenta() != null) {
                this.tipoRetencionVenta = new TipoRetencionVO(siiImputacionContable.getSiiTipoRetencionVenta());
            }
        }
    }


    public void setImcCodigo(Long imcCodigo) {
        this.imcCodigo = imcCodigo;
    }

    public Long getImcCodigo() {
        return imcCodigo;
    }

    public void setImcConcepto(String imcConcepto) {
        this.imcConcepto = imcConcepto;
    }

    public String getImcConcepto() {
        return imcConcepto;
    }

    public void setImcDescrOperacion(String imcDescrOperacion) {
        this.imcDescrOperacion = imcDescrOperacion;
    }

    public String getImcDescrOperacion() {
        return imcDescrOperacion;
    }

    public void setImcReferencia1(String imcReferencia1) {
        this.imcReferencia1 = imcReferencia1;
    }

    public String getImcReferencia1() {
        return imcReferencia1;
    }

    public void setImcReferencia2(String imcReferencia2) {
        this.imcReferencia2 = imcReferencia2;
    }

    public String getImcReferencia2() {
        return imcReferencia2;
    }

    public void setImcTipoMovim(String imcTipoMovim) {
        this.imcTipoMovim = imcTipoMovim;
    }

    public String getImcTipoMovim() {
        return imcTipoMovim;
    }
    
    /**
     * Obtiene el nombre del Tipo de Movimiento asociado a la Imputaci&oacute;n Contable.
     * @return imcTipoMovim->nombre
     */
    public String getNombreTipoMovimiento () {
        return ( EnumTipoMovimiento.getNombreById(imcTipoMovim) );
    }
    
    
    public void setImcValor(BigDecimal imcValor) {
        this.imcValor = imcValor;
    }

    public BigDecimal getImcValor() {
        return imcValor;
    }

    public void setImcEstado(String imcEstado) {
        this.imcEstado = imcEstado;
    }

    public String getImcEstado() {
        return imcEstado;
    }

    public void setImcBase(BigDecimal imcBase) {
        this.imcBase = imcBase;
    }

    public BigDecimal getImcBase() {
        return imcBase;
    }

    public void setImcAgrupacion(Integer imcAgrupacion) {
        this.imcAgrupacion = imcAgrupacion;
    }

    public Integer getImcAgrupacion() {
        return imcAgrupacion;
    }

    public void setTipoRetencionVenta(TipoRetencionVO tipoRetencionVenta) {
        this.tipoRetencionVenta = tipoRetencionVenta;
    }

    public TipoRetencionVO getTipoRetencionVenta() {
        return tipoRetencionVenta;
    }

    public void setTipoRetencionRenta(TipoRetencionVO tipoRetencionRenta) {
        this.tipoRetencionRenta = tipoRetencionRenta;
    }

    public TipoRetencionVO getTipoRetencionRenta() {
        return tipoRetencionRenta;
    }

    public void setDocumentoContableVo(DocumentoContableVO documentoContableVo) {
        this.documentoContableVo = documentoContableVo;
    }

    public DocumentoContableVO getDocumentoContableVo() {
        return documentoContableVo;
    }

    public void setFuenteFinancContabVo(FuenteFinancContabVO fuenteFinancContabVo) {
        this.fuenteFinancContabVo = fuenteFinancContabVo;
    }

    public FuenteFinancContabVO getFuenteFinancContabVo() {
        return fuenteFinancContabVo;
    }

    public void setAreaColjuegosVo(AreaColjuegosVO areaColjuegosVo) {
        this.areaColjuegosVo = areaColjuegosVo;
    }

    public AreaColjuegosVO getAreaColjuegosVo() {
        return areaColjuegosVo;
    }


    public void setConcepInfExogenaVo(ConcepInfExogenaVO concepInfExogenaVo) {
        this.concepInfExogenaVo = concepInfExogenaVo;
    }

    public ConcepInfExogenaVO getConcepInfExogenaVo() {
        return concepInfExogenaVo;
    }

    public void setCuentasContablesVo(CuentasContablesVO cuentasContablesVo) {
        this.cuentasContablesVo = cuentasContablesVo;
    }

    public CuentasContablesVO getCuentasContablesVo() {
        return cuentasContablesVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }
}
