package co.gov.coljuegos.siicol.ejb.wsvo;

public class InventarioMarcarMetVO {

    private String perNumeroIdentificacion;
    private String perJurNombreLargo;
    private String tipoPoblacionOperador;
    private String metNuc;
    private String metSerial;
    private String metMarca;
    private String codInternoLocal;
    private String fase;
    private long metCodigo;


    public InventarioMarcarMetVO() {
        super();
    }


    public String getPerNumeroIdentificacion() {
        return perNumeroIdentificacion;
    }

    public void setPerNumeroIdentificacion(String perNumeroIdentificacion) {
        this.perNumeroIdentificacion = perNumeroIdentificacion;
    }

    public String getPerJurNombreLargo() {
        return perJurNombreLargo;
    }

    public void setPerJurNombreLargo(String perJurNombreLargo) {
        this.perJurNombreLargo = perJurNombreLargo;
    }

    public String getTipoPoblacionOperador() {
        return tipoPoblacionOperador;
    }

    public void setTipoPoblacionOperador(String tipoPoblacionOperador) {
        this.tipoPoblacionOperador = tipoPoblacionOperador;
    }

    public String getMetNuc() {
        return metNuc;
    }

    public void setMetNuc(String metNuc) {
        this.metNuc = metNuc;
    }

    public String getMetSerial() {
        return metSerial;
    }

    public void setMetSerial(String metSerial) {
        this.metSerial = metSerial;
    }

    public String getMetMarca() {
        return metMarca;
    }

    public void setMetMarca(String metMarca) {
        this.metMarca = metMarca;
    }

    public String getCodInternoLocal() {
        return codInternoLocal;
    }

    public void setCodInternoLocal(String codInternoLocal) {
        this.codInternoLocal = codInternoLocal;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }


    public long getMetCodigo() {
        return metCodigo;
    }

    public void setMetCodigo(long metCodigo) {
        this.metCodigo = metCodigo;
    }
}
