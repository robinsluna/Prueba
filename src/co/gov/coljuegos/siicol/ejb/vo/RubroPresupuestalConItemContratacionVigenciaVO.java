package co.gov.coljuegos.siicol.ejb.vo;

public class RubroPresupuestalConItemContratacionVigenciaVO {
    
    private Long idr_codigo;
    private Long ipc_codigo;
    private Long dru_codigo;
    private Long idr_valor;
    private Long interno;
    private Long dff_codigo;
    private Long costos;
    
    public RubroPresupuestalConItemContratacionVigenciaVO() {
    }


    public void setIdr_codigo(Long idr_codigo) {
        this.idr_codigo = idr_codigo;
    }

    public Long getIdr_codigo() {
        return idr_codigo;
    }

    public void setIpc_codigo(Long ipc_codigo) {
        this.ipc_codigo = ipc_codigo;
    }

    public Long getIpc_codigo() {
        return ipc_codigo;
    }

    public void setDru_codigo(Long dru_codigo) {
        this.dru_codigo = dru_codigo;
    }

    public Long getDru_codigo() {
        return dru_codigo;
    }

    public void setIdr_valor(Long idr_valor) {
        this.idr_valor = idr_valor;
    }

    public Long getIdr_valor() {
        return idr_valor;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    public Long getInterno() {
        return interno;
    }

    public void setDff_codigo(Long dff_codigo) {
        this.dff_codigo = dff_codigo;
    }

    public Long getDff_codigo() {
        return dff_codigo;
    }

    public void setCostos(Long costos) {
        this.costos = costos;
    }

    public Long getCostos() {
        return costos;
    }
}
