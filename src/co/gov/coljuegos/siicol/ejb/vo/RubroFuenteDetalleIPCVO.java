package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class RubroFuenteDetalleIPCVO {
    
    private Long ffiCodigo;
    private String ffiNombre;
    private String ffiDescripcion;
    private Long dffCodigo;
    private String dffDescripcion;
    private Long drCodigo;
    private String rubDescripcion;
    private BigDecimal drValor;
    private Long drVigencia;
    private BigDecimal valorSolEstMercado;
    private BigDecimal saldoDetRub;
    private BigDecimal totalRubroSolicitud;
    private BigDecimal totalSaldoRubroSolicitud;
    private Long drcCodigo;
    private BigDecimal drSaldo;
    private Long epdcodigo;
    private BigDecimal saldoApropiacion;
    private String aplicaGMF;
    private Long idGF;
    private BigDecimal saldoAnterior;
    private Long epeCodigo;
    private Long ffi_codigo_fuente;
    private Long dff_ffi_codigo;
    private String codigo_rubro;
    private BigDecimal drValorTotalRubro;
    private BigDecimal drValorSaldoRubro;
    private Long interno;
    private Long dffCodigoRecurso;
    
    
    public RubroFuenteDetalleIPCVO() {
    }

    public void setFfiCodigo(Long ffiCodigo) {
        this.ffiCodigo = ffiCodigo;
    }

    public Long getFfiCodigo() {
        return ffiCodigo;
    }

    public void setFfiNombre(String ffiNombre) {
        this.ffiNombre = ffiNombre;
    }

    public String getFfiNombre() {
        return ffiNombre;
    }

    public void setDffCodigo(Long dffCodigo) {
        this.dffCodigo = dffCodigo;
    }

    public Long getDffCodigo() {
        return dffCodigo;
    }

    public void setDffDescripcion(String dffDescripcion) {
        this.dffDescripcion = dffDescripcion;
    }

    public String getDffDescripcion() {
        return dffDescripcion;
    }

    public void setDrCodigo(Long drCodigo) {
        this.drCodigo = drCodigo;
    }

    public Long getDrCodigo() {
        return drCodigo;
    }

    public void setRubDescripcion(String rubDescripcion) {
        this.rubDescripcion = rubDescripcion;
    }

    public String getRubDescripcion() {
        return rubDescripcion;
    }

    public void setDrValor(BigDecimal drValor) {
        this.drValor = drValor;
    }

    public BigDecimal getDrValor() {
        return drValor;
    }

    public void setDrVigencia(Long drVigencia) {
        this.drVigencia = drVigencia;
    }

    public Long getDrVigencia() {
        return drVigencia;
    }


    public void setValorSolEstMercado(BigDecimal valorSolEstMercado) {
        this.valorSolEstMercado = valorSolEstMercado;
    }

    public BigDecimal getValorSolEstMercado() {
        return valorSolEstMercado;
    }

    public void setSaldoDetRub(BigDecimal saldoDetRub) {
        this.saldoDetRub = saldoDetRub;
    }

    public BigDecimal getSaldoDetRub() {
        return saldoDetRub;
    }

    public void setTotalRubroSolicitud(BigDecimal totalRubroSolicitud) {
        this.totalRubroSolicitud = totalRubroSolicitud;
    }

    public BigDecimal getTotalRubroSolicitud() {
        return totalRubroSolicitud;
    }

    public void setTotalSaldoRubroSolicitud(BigDecimal totalSaldoRubroSolicitud) {
        this.totalSaldoRubroSolicitud = totalSaldoRubroSolicitud;
    }

    public BigDecimal getTotalSaldoRubroSolicitud() {
        return totalSaldoRubroSolicitud;
    }

    public void setDrcCodigo(Long drcCodigo) {
        this.drcCodigo = drcCodigo;
    }

    public Long getDrcCodigo() {
        return drcCodigo;
    }

    public void setDrSaldo(BigDecimal drSaldo) {
        this.drSaldo = drSaldo;
    }

    public BigDecimal getDrSaldo() {
        return drSaldo;
    }

    public void setEpdcodigo(Long epdcodigo) {
        this.epdcodigo = epdcodigo;
    }

    public Long getEpdcodigo() {
        return epdcodigo;
    }

    public void setSaldoApropiacion(BigDecimal saldoApropiacion) {
        this.saldoApropiacion = saldoApropiacion;
    }

    public BigDecimal getSaldoApropiacion() {
        return saldoApropiacion;
    }

    public void setFfiDescripcion(String ffiDescripcion) {
        this.ffiDescripcion = ffiDescripcion;
    }

    public String getFfiDescripcion() {
        return ffiDescripcion;
    }

    public void setAplicaGMF(String aplicaGMF) {
        this.aplicaGMF = aplicaGMF;
    }

    public String getAplicaGMF() {
        return aplicaGMF;
    }

    public void setIdGF(Long idGF) {
        this.idGF = idGF;
    }

    public Long getIdGF() {
        return idGF;
    }

    public void setSaldoAnterior(BigDecimal saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setEpeCodigo(Long epeCodigo) {
        this.epeCodigo = epeCodigo;
    }

    public Long getEpeCodigo() {
        return epeCodigo;
    }

    public void setFfi_codigo_fuente(Long ffi_codigo_fuente) {
        this.ffi_codigo_fuente = ffi_codigo_fuente;
    }

    public Long getFfi_codigo_fuente() {
        return ffi_codigo_fuente;
    }

    public void setDff_ffi_codigo(Long dff_ffi_codigo) {
        this.dff_ffi_codigo = dff_ffi_codigo;
    }

    public Long getDff_ffi_codigo() {
        return dff_ffi_codigo;
    }

    public void setCodigo_rubro(String codigo_rubro) {
        this.codigo_rubro = codigo_rubro;
    }

    public String getCodigo_rubro() {
        return codigo_rubro;
    }

    public void setDrValorTotalRubro(BigDecimal drValorTotalRubro) {
        this.drValorTotalRubro = drValorTotalRubro;
    }

    public BigDecimal getDrValorTotalRubro() {
        return drValorTotalRubro;
    }

    public void setDrValorSaldoRubro(BigDecimal drValorSaldoRubro) {
        this.drValorSaldoRubro = drValorSaldoRubro;
    }

    public BigDecimal getDrValorSaldoRubro() {
        return drValorSaldoRubro;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    public Long getInterno() {
        return interno;
    }

    public void setDffCodigoRecurso(Long dffCodigoRecurso) {
        this.dffCodigoRecurso = dffCodigoRecurso;
    }

    public Long getDffCodigoRecurso() {
        return dffCodigoRecurso;
    }
}
