/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 13-05-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUvt;

import java.math.BigDecimal;

import java.util.Date;


/**
 * Value Object para el <b>UVT</b> (Unidad de Valor Tributario).
 * @au
 * 
 * thor Camilo Miranda
 */
public class UvtVO {
    
    private Date uvtFecha;
    private BigDecimal uvtValor;
    private Integer uvtVigencia;
    
    
    /**
     * Constructor.
     */
    public UvtVO() { }
    
    
    /**
     * Constructor.
     * @param siiUvt - Entity.
     */
    public UvtVO (SiiUvt siiUvt) {
        if (siiUvt!=null) {
            this.uvtFecha = siiUvt.getUvtFecha();
            this.uvtValor = siiUvt.getUvtValor();
            this.uvtVigencia = siiUvt.getUvtVigencia();
        }
    }


    public void setUvtFecha(Date uvtFecha) {
        this.uvtFecha = uvtFecha;
    }

    public Date getUvtFecha() {
        return uvtFecha;
    }

    public void setUvtValor(BigDecimal uvtValor) {
        this.uvtValor = uvtValor;
    }

    public BigDecimal getUvtValor() {
        return uvtValor;
    }

    public void setUvtVigencia(Integer uvtVigencia) {
        this.uvtVigencia = uvtVigencia;
    }

    public Integer getUvtVigencia() {
        return uvtVigencia;
    }
}
