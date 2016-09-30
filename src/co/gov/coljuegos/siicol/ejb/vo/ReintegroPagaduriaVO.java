package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReintegroIngresoPag;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class ReintegroPagaduriaVO {
    
    private Long ripCodigo;
    private String ripConcepto;
    private String ripEstado;
    private BigDecimal ripValor;
    private CuentaBancariaVO cuentaBancariaVo;
    private NotaCreditoVO  notaCreditoVo;
    private Date ripFecha;
    private Integer ripNumero;
    private String motivoAnulacion;
    private List<RubroFuenteDetalleFuenteRpVO> listRubroFuenteDetalleFuenteRpVo ;
    private UsuarioVO usuarioConectadoVo;
    
    public  ReintegroPagaduriaVO() {
    
      
    }
    
    public ReintegroPagaduriaVO(SiiReintegroIngresoPag siiReintegroIngresoPag ) {
        
        this.setRipCodigo(siiReintegroIngresoPag.getRipCodigo());
        this.setRipConcepto(siiReintegroIngresoPag.getRipConcepto());
        this.setRipEstado(siiReintegroIngresoPag.getRipEstado());
        this.setRipFecha(siiReintegroIngresoPag.getRipFecha());
        this.setRipNumero(siiReintegroIngresoPag.getRipNumero());
        this.setRipValor(siiReintegroIngresoPag.getRipValor());
        this.setMotivoAnulacion(siiReintegroIngresoPag.getRipMotivoAnula());
        
        if(siiReintegroIngresoPag.getSiiCuentaBancaria()!= null )
            this.cuentaBancariaVo= new CuentaBancariaVO(siiReintegroIngresoPag.getSiiCuentaBancaria());
        if(siiReintegroIngresoPag.getSiiNotaCredito()!= null )
            this.notaCreditoVo= new NotaCreditoVO(siiReintegroIngresoPag.getSiiNotaCredito());
       
    }
    

    public void setRipCodigo(Long ripCodigo) {
        this.ripCodigo = ripCodigo;
    }

    public Long getRipCodigo() {
        return ripCodigo;
    }

    public void setRipConcepto(String ripConcepto) {
        this.ripConcepto = ripConcepto;
    }

    public String getRipConcepto() {
        return ripConcepto;
    }

    public void setRipValor(BigDecimal ripValor) {
        this.ripValor = ripValor;
    }

    public BigDecimal getRipValor() {
        return ripValor;
    }

    public void setCuentaBancariaVo(CuentaBancariaVO cuentaBancariaVo) {
        this.cuentaBancariaVo = cuentaBancariaVo;
    }

    public CuentaBancariaVO getCuentaBancariaVo() {
        return cuentaBancariaVo;
    }

    public void setNotaCreditoVo(NotaCreditoVO notaCreditoVo) {
        this.notaCreditoVo = notaCreditoVo;
    }

    public NotaCreditoVO getNotaCreditoVo() {
        return notaCreditoVo;
    }

    public void setRipFecha(Date ripFecha) {
        this.ripFecha = ripFecha;
    }

    public Date getRipFecha() {
        return ripFecha;
    }

    public void setRipNumero(Integer ripNumero) {
        this.ripNumero = ripNumero;
    }

    public Integer getRipNumero() {
        return ripNumero;
    }

    public void setRipEstado(String ripEstado) {
        this.ripEstado = ripEstado;
    }

    public String getRipEstado() {
        return ripEstado;
    }

    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }

    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }

    public void setListRubroFuenteDetalleFuenteRpVo(List<RubroFuenteDetalleFuenteRpVO> listRubroFuenteDetalleFuenteRpVo){
        this.listRubroFuenteDetalleFuenteRpVo = listRubroFuenteDetalleFuenteRpVo;
    }

    public List<RubroFuenteDetalleFuenteRpVO> getListRubroFuenteDetalleFuenteRpVo(){
        return listRubroFuenteDetalleFuenteRpVo;
    }

    public void setUsuarioConectadoVo(UsuarioVO usuarioConectadoVo) {
        this.usuarioConectadoVo = usuarioConectadoVo;
    }

    public UsuarioVO getUsuarioConectadoVo() {
        return usuarioConectadoVo;
    }

}
