package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoGasto;

import java.util.List;

public class ConceptoGastoVO {
    
    private Long cgaCodigo;
    private String cgaCodigoSiicol;
    private String cgaModulo;
    private String cgaNombre;
    private List<ObligacionConceptoVO> obligacionConceptoList;
    
    private ComprobAsociadoVO comprobAsociado;
    private CuentasContablesVO cuentasContablesDeb;
    private CuentasContablesVO cuentasContablesCred;
    
    public ConceptoGastoVO() {
        super();
    }

    public ConceptoGastoVO(SiiConceptoGasto siiConceptoGasto) {

        this.cgaCodigo = siiConceptoGasto.getCgaCodigo();
        this.cgaCodigoSiicol = siiConceptoGasto.getCgaCodigoSiicol();
        this.cgaModulo = siiConceptoGasto.getCgaModulo();
        this.cgaNombre = siiConceptoGasto.getCgaNombre();
        
        if (siiConceptoGasto.getSiiComprobAsociado() != null)
            this.comprobAsociado = new ComprobAsociadoVO(siiConceptoGasto.getSiiComprobAsociado());
        
        if (siiConceptoGasto.getSiiCuentasContablesDeb() != null)
            this.cuentasContablesDeb = new CuentasContablesVO(siiConceptoGasto.getSiiCuentasContablesDeb());
        
        if (siiConceptoGasto.getSiiCuentasContablesCred() != null)
            this.cuentasContablesCred = new CuentasContablesVO(siiConceptoGasto.getSiiCuentasContablesCred());
    }



    public void setCgaCodigo(Long cgaCodigo) {
        this.cgaCodigo = cgaCodigo;
    }

    public Long getCgaCodigo() {
        return cgaCodigo;
    }

    public void setCgaCodigoSiicol(String cgaCodigoSiicol) {
        this.cgaCodigoSiicol = cgaCodigoSiicol;
    }

    public String getCgaCodigoSiicol() {
        return cgaCodigoSiicol;
    }


    public void setCgaModulo(String cgaModulo) {
        this.cgaModulo = cgaModulo;
    }

    public String getCgaModulo() {
        return cgaModulo;
    }

    public void setCgaNombre(String cgaNombre) {
        this.cgaNombre = cgaNombre;
    }

    public String getCgaNombre() {
        return cgaNombre;
    }


    public void setComprobAsociado(ComprobAsociadoVO comprobAsociado) {
        this.comprobAsociado = comprobAsociado;
    }

    public ComprobAsociadoVO getComprobAsociado() {
        return comprobAsociado;
    }

    public void setObligacionConceptoList(List<ObligacionConceptoVO> obligacionConceptoList) {
        this.obligacionConceptoList = obligacionConceptoList;
    }

    public List<ObligacionConceptoVO> getObligacionConceptoList() {
        return obligacionConceptoList;
    }


    public void setCuentasContablesDeb(CuentasContablesVO cuentasContablesDeb) {
        this.cuentasContablesDeb = cuentasContablesDeb;
    }

    public CuentasContablesVO getCuentasContablesDeb() {
        return cuentasContablesDeb;
    }

    public void setCuentasContablesCred(CuentasContablesVO cuentasContablesCred) {
        this.cuentasContablesCred = cuentasContablesCred;
    }

    public CuentasContablesVO getCuentasContablesCred() {
        return cuentasContablesCred;
    }
}
