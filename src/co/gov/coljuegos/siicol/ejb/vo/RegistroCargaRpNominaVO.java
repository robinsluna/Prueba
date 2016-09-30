package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class RegistroCargaRpNominaVO implements Comparable<RegistroCargaRpNominaVO> {

    private Integer vigencia;
    private Long numeroCdp;
    private Long tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    //    Rubro Presupuestal;
    private String unidad;
    private String tipo;
    private String cuenta;
    private String subcuenta;
    private String objeto;
    private String ordinal;
    private String subordinal;
    private Integer fuenteFinanciacion;
    private Integer detalleFuente;
    private String nombreDelRubro;
    private BigDecimal valor;
    private String objetoDelGasto;
    private String inconsistencia;
    private BigDecimal saldoRubro; // Saldo del rubro en la secuencia de carga.
    private CdpVO cdpVo;

    public RegistroCargaRpNominaVO() {
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setNumeroCdp(Long numeroCdp) {
        this.numeroCdp = numeroCdp;
    }

    public Long getNumeroCdp() {
        return numeroCdp;
    }

    public void setTipoDocumento(Long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getTipoDocumento() {
        return tipoDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setSubcuenta(String subcuenta) {
        this.subcuenta = subcuenta;
    }

    public String getSubcuenta() {
        return subcuenta;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setOrdinal(String ordinal) {
        this.ordinal = ordinal;
    }

    public String getOrdinal() {
        return ordinal;
    }

    public void setSubordinal(String subordinal) {
        this.subordinal = subordinal;
    }

    public String getSubordinal() {
        return subordinal;
    }

    public void setFuenteFinanciacion(Integer fuenteFinanciacion) {
        this.fuenteFinanciacion = fuenteFinanciacion;
    }

    public Integer getFuenteFinanciacion() {
        return fuenteFinanciacion;
    }

    public void setDetalleFuente(Integer detalleFuente) {
        this.detalleFuente = detalleFuente;
    }

    public Integer getDetalleFuente() {
        return detalleFuente;
    }

    public void setNombreDelRubro(String nombreDelRubro) {
        this.nombreDelRubro = nombreDelRubro;
    }

    public String getNombreDelRubro() {
        return nombreDelRubro;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setObjetoDelGasto(String objetoDelGasto) {
        this.objetoDelGasto = objetoDelGasto;
    }

    public String getObjetoDelGasto() {
        return objetoDelGasto;
    }

    public void setInconsistencia(String inconsistencia) {
        this.inconsistencia = inconsistencia;
    }

    public String getInconsistencia() {
        return inconsistencia;
    }


    public int compareTo(RegistroCargaRpNominaVO reg) {
        String identificacion1 = null;
        String identificacion2 = null;
        if (reg.getTipoDocumento() != null && reg.getNumeroDocumento() != null) {
            identificacion1 =
                reg.getTipoDocumento().toString() + "." + reg.getNumeroDocumento() + "." + reg.getCodigoPresupuestal() +
                "." + reg.getFuenteFinanciacion().toString() + "." + reg.getDetalleFuente().toString();
        }
        if (this.getTipoDocumento() != null && this.getNumeroDocumento() != null) {
            identificacion2 =
                this.getTipoDocumento().toString() + "." + this.getNumeroDocumento() + "." +
                this.getCodigoPresupuestal() + "." + this.getFuenteFinanciacion() + "." + this.getDetalleFuente();
        }

        if (identificacion2 != null && identificacion1 != null)
            return identificacion2.compareTo(identificacion1);
        else if (identificacion2 != null)
            return 1;
        else if (identificacion1 != null)
            return -1;
        else
            return 0;
    }

    public String getCodigoPresupuestal() {
        return this.unidad + "." +
               (this.tipo == null ? "" :
                (this.tipo + "." +
                 (this.cuenta == null ? "" :
                  (this.cuenta + "." +
                   (this.subcuenta == null ? "" :
                    (this.subcuenta + "." +
                     (this.objeto == null ? "" :
                      (this.objeto + "." +
                       (this.ordinal == null ? "" :
                        (this.ordinal + (this.subordinal == null ? "" : "." + this.subordinal)))))))))));
    }

    public void setCdpVo(CdpVO cdpVo) {
        this.cdpVo = cdpVo;
    }

    public CdpVO getCdpVo() {
        return cdpVo;
    }

    public void setSaldoRubro(BigDecimal saldoRubro) {
        this.saldoRubro = saldoRubro;
    }

    public BigDecimal getSaldoRubro() {
        return saldoRubro;
    }
}
