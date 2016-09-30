/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 16-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinancContab;

import java.util.List;


/**
 * Value Object para la Fuente de Financiaci&oacute;n Contable.
 * @author Camilo Miranda
 */
public class FuenteFinancContabVO implements Cloneable 
{
    private String fccNombre;
    private String ffcCodigo;
    
    private List<DetalleRubroVO> detalleRubroList;
    private List<ObligacionConceptoVO> obligacionConceptoList;
    private List<OrdenPagoVO> ordenPagoList;
    
    
    
    /**
     * Constructor.
     */
    public FuenteFinancContabVO() { }
    
    
    /**
     * Constructor.
     * @param siiFuenteFinancContab
     */
    public FuenteFinancContabVO(SiiFuenteFinancContab siiFuenteFinancContab) {
        if (siiFuenteFinancContab!=null) {
            this.fccNombre = siiFuenteFinancContab.getFccNombre();
            this.ffcCodigo = siiFuenteFinancContab.getFfcCodigo();
        }
    }
    
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) {
        boolean igual = false;
        if (o instanceof FuenteFinancContabVO) {
            FuenteFinancContabVO ffcVo = (FuenteFinancContabVO) o;
            if (ffcVo!=null) {
                    igual =
                        ((ffcVo.fccNombre != null && ffcVo.fccNombre.equals(this.fccNombre)) || (ffcVo.fccNombre == null && this.fccNombre == null)) && 
                        ((ffcVo.ffcCodigo != null && ffcVo.ffcCodigo.equals(this.ffcCodigo)) || (ffcVo.ffcCodigo == null && this.ffcCodigo == null)); 
            }
        }
        
        return (igual);
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode () {
        int hashcode = 0;
        if (this.ffcCodigo!=null) {
            // acumula c/u de los valores enteros correspondientes a cada caracter del codigo de fuente de financiacion
            StringBuilder intValueStr = new StringBuilder();
            // recorrer cada caracter del codigo de fuente de financiacion para obtener su representacion entera
            for (int i=0; i<ffcCodigo.length(); i++) {
                int num = ffcCodigo.charAt(i);
                intValueStr.append(num);
            }
            
            if (intValueStr.length()>0) {
                hashcode = Integer.parseInt(intValueStr.toString());
            }
        }
        return (hashcode);
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public FuenteFinancContabVO clone () 
    {
        FuenteFinancContabVO fuenteFinancContabVo = new FuenteFinancContabVO();
        fuenteFinancContabVo.fccNombre = this.fccNombre;
        fuenteFinancContabVo.ffcCodigo = this.ffcCodigo;
        
        return (fuenteFinancContabVo);
    }
    
    
    
    public void setFccNombre(String fccNombre) {
        this.fccNombre = fccNombre;
    }

    public String getFccNombre() {
        return fccNombre;
    }

    public void setFfcCodigo(String ffcCodigo) {
        this.ffcCodigo = ffcCodigo;
    }

    public String getFfcCodigo() {
        return ffcCodigo;
    }

    public void setDetalleRubroList(List<DetalleRubroVO> detalleRubroList) {
        this.detalleRubroList = detalleRubroList;
    }

    public List<DetalleRubroVO> getDetalleRubroList() {
        return detalleRubroList;
    }


    public void setObligacionConceptoList(List<ObligacionConceptoVO> obligacionConceptoList) {
        this.obligacionConceptoList = obligacionConceptoList;
    }

    public List<ObligacionConceptoVO> getObligacionConceptoList() {
        return obligacionConceptoList;
    }

    public void setOrdenPagoList(List<OrdenPagoVO> ordenPagoList) {
        this.ordenPagoList = ordenPagoList;
    }

    public List<OrdenPagoVO> getOrdenPagoList() {
        return ordenPagoList;
    }
}
