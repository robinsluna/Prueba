/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTrasladoBancario;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class TrasladoCuentasBancariasVO {

    private Long tbaCodigo;
    private Date tbaFecha;
    private BigDecimal tbaValor;
    private String tbaDescripcion;
    private Integer tbaConsecutivo;
    private EstadoTrasladoBancarioVO estadoTrasladoBancarioVo;
    private CuentaBancariaVO cuentaBancariaOrigenVo;
    private CuentaBancariaVO cuentaBancariaDestinoVo;
    private BigDecimal tbaSaldoCuenta;
    private Long idEstadoAnterior;
    private List<SolicitudPromocionalesVO> listaSolicitudPromocionalesVo;

    public TrasladoCuentasBancariasVO() {

    }

    public TrasladoCuentasBancariasVO(SiiTrasladoBancario siiTrasladoBancario) {
        this.tbaCodigo = siiTrasladoBancario.getTbaCodigo();
        this.tbaFecha = siiTrasladoBancario.getTbaFecha();
        this.tbaValor = siiTrasladoBancario.getTbaValor();
        this.tbaDescripcion = siiTrasladoBancario.getTbaDescripcion();
        this.tbaConsecutivo = siiTrasladoBancario.getTbaConsecutivo();

        //Estado
        if (siiTrasladoBancario.getSiiEstadoTraslBancario() != null) {
            this.estadoTrasladoBancarioVo =
                new EstadoTrasladoBancarioVO(siiTrasladoBancario.getSiiEstadoTraslBancario());
            this.idEstadoAnterior = siiTrasladoBancario.getSiiEstadoTraslBancario().getEtbCodigo();
        }

        if (siiTrasladoBancario.getSiiCuentaBancariaOri() != null)
            this.cuentaBancariaOrigenVo = new CuentaBancariaVO(siiTrasladoBancario.getSiiCuentaBancariaOri());
        if (siiTrasladoBancario.getSiiCuentaBancariaDest() != null)
            this.cuentaBancariaDestinoVo = new CuentaBancariaVO(siiTrasladoBancario.getSiiCuentaBancariaDest());

    }


    public void setTbaCodigo(Long tbaCodigo) {
        this.tbaCodigo = tbaCodigo;
    }

    public Long getTbaCodigo() {
        return tbaCodigo;
    }

    public void setTbaFecha(Date tbaFecha) {
        this.tbaFecha = tbaFecha;
    }

    public Date getTbaFecha() {
        return tbaFecha;
    }


    public void setTbaValor(BigDecimal tbaValor) {
        this.tbaValor = tbaValor;
    }

    public BigDecimal getTbaValor() {
        return tbaValor;
    }

    public void setTbaDescripcion(String tbaDescripcion) {
        this.tbaDescripcion = tbaDescripcion;
    }

    public String getTbaDescripcion() {
        return tbaDescripcion;
    }

    public void setTbaConsecutivo(Integer tbaConsecutivo) {
        this.tbaConsecutivo = tbaConsecutivo;
    }

    public Integer getTbaConsecutivo() {
        return tbaConsecutivo;
    }

    public void setEstadoTrasladoBancarioVo(EstadoTrasladoBancarioVO estadoTrasladoBancarioVo) {
        this.estadoTrasladoBancarioVo = estadoTrasladoBancarioVo;
    }

    public EstadoTrasladoBancarioVO getEstadoTrasladoBancarioVo() {
        return estadoTrasladoBancarioVo;
    }

    public void setCuentaBancariaOrigenVo(CuentaBancariaVO cuentaBancariaOrigenVo) {
        this.cuentaBancariaOrigenVo = cuentaBancariaOrigenVo;
    }

    public CuentaBancariaVO getCuentaBancariaOrigenVo() {
        return cuentaBancariaOrigenVo;
    }

    public void setCuentaBancariaDestinoVo(CuentaBancariaVO cuentaBancariaDestinoVo) {
        this.cuentaBancariaDestinoVo = cuentaBancariaDestinoVo;
    }

    public CuentaBancariaVO getCuentaBancariaDestinoVo() {
        return cuentaBancariaDestinoVo;
    }

    public void setTbaSaldoCuenta(BigDecimal tbaSaldoCuenta) {
        this.tbaSaldoCuenta = tbaSaldoCuenta;
    }

    public BigDecimal getTbaSaldoCuenta() {
        return tbaSaldoCuenta;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public void setListaSolicitudPromocionalesVo(List<SolicitudPromocionalesVO> listaSolicitudPromocionalesVo) {
        this.listaSolicitudPromocionalesVo = listaSolicitudPromocionalesVo;
    }

    public List<SolicitudPromocionalesVO> getListaSolicitudPromocionalesVo() {
        return listaSolicitudPromocionalesVo;
    }

}
