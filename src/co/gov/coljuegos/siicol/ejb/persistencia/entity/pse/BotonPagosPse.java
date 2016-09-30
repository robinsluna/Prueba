package co.gov.coljuegos.siicol.ejb.persistencia.entity.pse;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"BotonPagosPSE\"")
public class BotonPagosPse implements Serializable {
    private static final long serialVersionUID = -978429098346258077L;
    private int cicloTransaccion;
    private int codigoAprobacion;
    private int codigoBanco;
    private String codigoTransaccion;
    private String descripcion;
    private Timestamp fechaEstado;
    private Timestamp fechaInicio;
    private Timestamp fechaTransaccion;
    private int formaPago;
    private String franquicia;
    private String iDCliente;
    private String iPCliente;
    private int id;
    private String identificadorTransaccion;
    private String nombreBanco;
    private String referencia1;
    private String referencia2;
    private String referencia3;
    private String ticketID;
    private int transaccionPagoEstado;
    private String usuario;
    private Long valor;
    private Long valorImpuesto;
    private Long valorPagado;

    public BotonPagosPse() {
    }

    public BotonPagosPse(int cicloTransaccion, int codigoAprobacion, int codigoBanco, String codigoTransaccion,
                         String descripcion, Timestamp fechaEstado, Timestamp fechaInicio, Timestamp fechaTransaccion,
                         int formaPago, String franquicia, String iDCliente, String iPCliente, int id,
                         String identificadorTransaccion, String nombreBanco, String referencia1, String referencia2,
                         String referencia3, String ticketID, int transaccionPagoEstado, String usuario, Long valor,
                         Long valorImpuesto, Long valorPagado) {
        this.cicloTransaccion = cicloTransaccion;
        this.codigoAprobacion = codigoAprobacion;
        this.codigoBanco = codigoBanco;
        this.codigoTransaccion = codigoTransaccion;
        this.descripcion = descripcion;
        this.fechaEstado = fechaEstado;
        this.fechaInicio = fechaInicio;
        this.fechaTransaccion = fechaTransaccion;
        this.formaPago = formaPago;
        this.franquicia = franquicia;
        this.iDCliente = iDCliente;
        this.iPCliente = iPCliente;
        this.id = id;
        this.identificadorTransaccion = identificadorTransaccion;
        this.nombreBanco = nombreBanco;
        this.referencia1 = referencia1;
        this.referencia2 = referencia2;
        this.referencia3 = referencia3;
        this.ticketID = ticketID;
        this.transaccionPagoEstado = transaccionPagoEstado;
        this.usuario = usuario;
        this.valor = valor;
        this.valorImpuesto = valorImpuesto;
        this.valorPagado = valorPagado;
    }

    @Column(name = "CicloTransaccion")
    public int getCicloTransaccion() {
        return cicloTransaccion;
    }

    public void setCicloTransaccion(int cicloTransaccion) {
        this.cicloTransaccion = cicloTransaccion;
    }

    @Column(name = "CodigoAprobacion")
    public int getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(int codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    @Column(name = "CodigoBanco")
    public int getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    @Column(name = "CodigoTransaccion")
    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(String codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    @Column(name = "Descripcion", nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "FechaEstado", nullable = false)
    public Timestamp getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Timestamp fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    @Column(name = "FechaInicio", nullable = false)
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column(name = "FechaTransaccion")
    public Timestamp getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Timestamp fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    @Column(name = "FormaPago")
    public int getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    @Column(name = "Franquicia")
    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    @Column(name = "IDCliente", nullable = false)
    public String getIDCliente() {
        return iDCliente;
    }

    public void setIDCliente(String iDCliente) {
        this.iDCliente = iDCliente;
    }

    @Column(name = "IPCliente", nullable = false)
    public String getIPCliente() {
        return iPCliente;
    }

    public void setIPCliente(String iPCliente) {
        this.iPCliente = iPCliente;
    }

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "IdentificadorTransaccion")
    public String getIdentificadorTransaccion() {
        return identificadorTransaccion;
    }

    public void setIdentificadorTransaccion(String identificadorTransaccion) {
        this.identificadorTransaccion = identificadorTransaccion;
    }

    @Column(name = "NombreBanco")
    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    @Column(name = "Referencia1")
    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    @Column(name = "Referencia2")
    public String getReferencia2() {
        return referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    @Column(name = "Referencia3")
    public String getReferencia3() {
        return referencia3;
    }

    public void setReferencia3(String referencia3) {
        this.referencia3 = referencia3;
    }

    @Column(name = "TicketID")
    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    @Column(name = "TransaccionPagoEstado", nullable = false)
    public int getTransaccionPagoEstado() {
        return transaccionPagoEstado;
    }

    public void setTransaccionPagoEstado(int transaccionPagoEstado) {
        this.transaccionPagoEstado = transaccionPagoEstado;
    }

    @Column(name = "Usuario", nullable = false)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "Valor", nullable = false)
    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    @Column(name = "ValorImpuesto", nullable = false)
    public Long getValorImpuesto() {
        return valorImpuesto;
    }

    public void setValorImpuesto(Long valorImpuesto) {
        this.valorImpuesto = valorImpuesto;
    }

    @Column(name = "ValorPagado")
    public Long getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(Long valorPagado) {
        this.valorPagado = valorPagado;
    }
}
