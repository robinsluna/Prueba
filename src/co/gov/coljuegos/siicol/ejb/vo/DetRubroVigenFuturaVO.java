/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-12-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetRubroVigenFutura;

import java.math.BigDecimal;


/**
 * Value Object para el manejo de la relaci&oacute;n entre Detalles Rubro y Vigencias Futuras.
 * @author Camilo Miranda
 */
public class DetRubroVigenFuturaVO 
{
    private Long drvCodigo;
    private String drvEstado;
    private BigDecimal drvValor;
    private Integer drvVigencia;
    
    private VigenciaFuturaVO vigenciaFuturaVo;
    private DetalleRubroVO detalleRubroVo;
    
    
    /**
     * Constructor.
     */
    public DetRubroVigenFuturaVO() { }
    
    
    /**
     * Constructor.
     * @param siiDetRubroVigenFutura - Entity.
     */
    public DetRubroVigenFuturaVO (SiiDetRubroVigenFutura siiDetRubroVigenFutura) 
    {
        if (siiDetRubroVigenFutura!=null) {
            this.drvCodigo = siiDetRubroVigenFutura.getDrvCodigo();
            this.drvEstado = siiDetRubroVigenFutura.getDrvEstado();
            this.drvValor = siiDetRubroVigenFutura.getDrvValor();
            this.drvVigencia = siiDetRubroVigenFutura.getDrvVigencia();
            
            if (siiDetRubroVigenFutura.getSiiDetalleRubro()!=null) {
                this.detalleRubroVo = new DetalleRubroVO(siiDetRubroVigenFutura.getSiiDetalleRubro());
            }
            
            if (siiDetRubroVigenFutura.getSiiVigenciaFutura()!=null) {
                this.vigenciaFuturaVo = new VigenciaFuturaVO(siiDetRubroVigenFutura.getSiiVigenciaFutura());
            }
        }
    }


    public void setDrvCodigo(Long drvCodigo) {
        this.drvCodigo = drvCodigo;
    }

    public Long getDrvCodigo() {
        return drvCodigo;
    }

    public void setDrvEstado(String drvEstado) {
        this.drvEstado = drvEstado;
    }

    public String getDrvEstado() {
        return drvEstado;
    }

    public void setDrvValor(BigDecimal drvValor) {
        this.drvValor = drvValor;
    }

    public BigDecimal getDrvValor() {
        return drvValor;
    }

    public void setDrvVigencia(Integer drvVigencia) {
        this.drvVigencia = drvVigencia;
    }

    public Integer getDrvVigencia() {
        return drvVigencia;
    }

    public void setVigenciaFuturaVo(VigenciaFuturaVO vigenciaFuturaVo) {
        this.vigenciaFuturaVo = vigenciaFuturaVo;
    }

    public VigenciaFuturaVO getVigenciaFuturaVo() {
        return vigenciaFuturaVo;
    }

    public void setDetalleRubroVo(DetalleRubroVO detalleRubroVo) {
        this.detalleRubroVo = detalleRubroVo;
    }

    public DetalleRubroVO getDetalleRubroVo() {
        return detalleRubroVo;
    }
}
