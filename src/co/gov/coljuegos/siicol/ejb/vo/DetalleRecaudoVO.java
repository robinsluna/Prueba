
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRecaudo;

import java.math.BigDecimal;

public class DetalleRecaudoVO {
    
    private Long dreCodigo;
    private String dreRefPago;
    private BigDecimal dreValor;
    private ProcedenciaPagoVO procedenciaPagoVo;
    private MedioPagoVO medioPagoVo;
    private Long dreNumeroOperacion;
    private Long dreNumeroAutorizacion;
    private String dreEntidadFinanciera;
    private String dreSucursal;
    private Long dreSecuencia;
    private PagoOperadoresVO pagoOperadoresVo;
    private BancoVO bancoVo;
    private String dreEstado;
    
    public DetalleRecaudoVO(SiiDetalleRecaudo siiDetalleRecaudo) {
        this.setDreCodigo(dreCodigo);
        if(siiDetalleRecaudo.getDreNumAutoriza()!= null)
            this.setDreNumeroAutorizacion((siiDetalleRecaudo.getDreNumAutoriza()).longValue());
        if(siiDetalleRecaudo.getDreNumOperac()!= null)
            this.setDreNumeroOperacion( (siiDetalleRecaudo.getDreNumOperac()).longValue());
        this.setDreRefPago(siiDetalleRecaudo.getDreRefPago());
        if(siiDetalleRecaudo.getDreSecuencia() != null)
            this.setDreSecuencia((siiDetalleRecaudo.getDreSecuencia().longValue()));
        if (siiDetalleRecaudo.getDreSucursal()!= null)
             this.setDreSucursal(siiDetalleRecaudo.getDreSucursal());
        this.setDreValor(siiDetalleRecaudo.getDreValor());
        this.setDreEstado(siiDetalleRecaudo.getDreEstado());
        
       //padres
       if(siiDetalleRecaudo.getSiiMedioPago()!=null)
           this.medioPagoVo= new MedioPagoVO(siiDetalleRecaudo.getSiiMedioPago());
       if(siiDetalleRecaudo.getSiiProcedenciaPago()!=null)
           this.procedenciaPagoVo= new ProcedenciaPagoVO(siiDetalleRecaudo.getSiiProcedenciaPago()); 
       if(siiDetalleRecaudo.getSiiRecaudoBanco() != null)
           this.pagoOperadoresVo= new PagoOperadoresVO (siiDetalleRecaudo.getSiiRecaudoBanco());
       if(siiDetalleRecaudo.getSiiBanco()!=null)
           this.bancoVo= new BancoVO(siiDetalleRecaudo.getSiiBanco());

    }
    
    public DetalleRecaudoVO() {
       
       
    }


    public void setBancoVo(BancoVO bancoVo) {
        this.bancoVo = bancoVo;
    }

    public BancoVO getBancoVo() {
        return bancoVo;
    }

    public void setDreEstado(String dreEstado) {
        this.dreEstado = dreEstado;
    }

    public String getDreEstado() {
        return dreEstado;
    }

    public void setDreCodigo(Long dreCodigo) {
        this.dreCodigo = dreCodigo;
    }

    public Long getDreCodigo() {
        return dreCodigo;
    }

    public void setDreRefPago(String dreRefPago) {
        this.dreRefPago = dreRefPago;
    }

    public String getDreRefPago() {
        return dreRefPago;
    }

    public void setDreValor(BigDecimal dreValor) {
        this.dreValor = dreValor;
    }

    public BigDecimal getDreValor() {
        return dreValor;
    }

    public void setProcedenciaPagoVo(ProcedenciaPagoVO procedenciaPagoVo) {
        this.procedenciaPagoVo = procedenciaPagoVo;
    }

    public ProcedenciaPagoVO getProcedenciaPagoVo() {
        return procedenciaPagoVo;
    }

    public void setMedioPagoVo(MedioPagoVO medioPagoVo) {
        this.medioPagoVo = medioPagoVo;
    }

    public MedioPagoVO getMedioPagoVo() {
        return medioPagoVo;
    }

    public void setDreNumeroOperacion(Long dreNumeroOperacion) {
        this.dreNumeroOperacion = dreNumeroOperacion;
    }

    public Long getDreNumeroOperacion() {
        return dreNumeroOperacion;
    }

    public void setDreNumeroAutorizacion(Long dreNumeroAutorizacion) {
        this.dreNumeroAutorizacion = dreNumeroAutorizacion;
    }

    public Long getDreNumeroAutorizacion() {
        return dreNumeroAutorizacion;
    }

    public void setDreEntidadFinanciera(String dreEntidadFinanciera) {
        this.dreEntidadFinanciera = dreEntidadFinanciera;
    }

    public String getDreEntidadFinanciera() {
        return dreEntidadFinanciera;
    }

    public void setDreSucursal(String dreSucursal) {
        this.dreSucursal = dreSucursal;
    }

    public String getDreSucursal() {
        return dreSucursal;
    }

    public void setDreSecuencia(Long dreSecuencia) {
        this.dreSecuencia = dreSecuencia;
    }

    public Long getDreSecuencia() {
        return dreSecuencia;
    }

    public void setPagoOperadoresVo(PagoOperadoresVO pagoOperadoresVo) {
        this.pagoOperadoresVo = pagoOperadoresVo;
    }

    public PagoOperadoresVO getPagoOperadoresVo() {
        return pagoOperadoresVo;
    }

}
