package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoCuentaBancaria;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancaria;

public class CuentaBancariaVO {
    private String cbaActivo;
    private Long cbaCodigo;
    private String cbaComentario;
    private String cbaNumero;
    private String cbaTipo;
    private CuentasContablesVO  cuentasContablesVo;
    private BancoVO siiBanco;
    private String cbaAplicaGmf;
    private String estadoSaldo;
    
    
    
    /**
     * Constructor.
     */
    public CuentaBancariaVO() { }
    
    
    /**
     * Constructor.
     * @param siiCuentaBancaria
     */
    public CuentaBancariaVO (SiiCuentaBancaria siiCuentaBancaria) {
        if (siiCuentaBancaria!=null) {
            this.cbaActivo = siiCuentaBancaria.getCbaActivo();
            this.cbaCodigo = siiCuentaBancaria.getCbaCodigo();
            this.cbaComentario = siiCuentaBancaria.getCbaComentario();
            this.cbaNumero = siiCuentaBancaria.getCbaNumero();
            this.cbaTipo = siiCuentaBancaria.getCbaTipo();

            this.cbaAplicaGmf=siiCuentaBancaria.getCboAplicaGmf();
            if(siiCuentaBancaria.getSiiBanco() != null){
                this.siiBanco = new BancoVO(siiCuentaBancaria.getSiiBanco());
            }
            if(siiCuentaBancaria.getSiiCuentasContables() != null){
                this.cuentasContablesVo = new CuentasContablesVO(siiCuentaBancaria.getSiiCuentasContables());
            }
            
        }
    }


    public void setCbaActivo(String cbaActivo) {
        this.cbaActivo = cbaActivo;
    }

    public String getCbaActivo() {
        return cbaActivo;
    }

    public void setCbaCodigo(Long cbaCodigo) {
        this.cbaCodigo = cbaCodigo;
    }

    public void setCbaAplicaGmf(String cbaAplicaGmf) {
        this.cbaAplicaGmf = cbaAplicaGmf;
    }

    public String getCbaAplicaGmf() {
        return cbaAplicaGmf;
    }

    public void setEstadoSaldo(String estadoSaldo) {
        this.estadoSaldo = estadoSaldo;
    }

    public String getEstadoSaldo() {
        return estadoSaldo;
    }

    public Long getCbaCodigo() {
        return cbaCodigo;
    }

    public void setCbaComentario(String cbaComentario) {
        this.cbaComentario = cbaComentario;
    }

    public String getCbaComentario() {
        return cbaComentario;
    }

    public void setCbaNumero(String cbaNumero) {
        this.cbaNumero = cbaNumero;
    }

    public String getCbaNumero() {
        return cbaNumero;
    }

    public void setCbaTipo(String cbaTipo) {
        this.cbaTipo = cbaTipo;
    }

    public String getCbaTipo() {
        return cbaTipo;
    }

    public void setSiiBanco(BancoVO siiBanco) {
        this.siiBanco = siiBanco;
    }

    public BancoVO getSiiBanco() {
        return siiBanco;
    }

    public void setCuentasContablesVo(CuentasContablesVO cuentasContablesVo) {
        this.cuentasContablesVo = cuentasContablesVo;
    }

    public CuentasContablesVO getCuentasContablesVo() {
        return cuentasContablesVo;
    }
    
    
    /**
     * Obtiene el nombre del Tipo de la Cuenta Bancaria.
     * @return Nombre asociado al cbaTipo.
     */
    public String getTipoCuentaBancaria() {
        String nombreTipoCuenta = null;
        if (cbaTipo!=null) {
            nombreTipoCuenta = EnumTipoCuentaBancaria.getNombreById(cbaTipo);
        }
        return (nombreTipoCuenta);
    }
}
