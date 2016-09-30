package co.gov.coljuegos.siicol.ejb.vo;

import java.util.Date;

public class ItemPlanContratacionCdpVO {
    
    Long ipc_codigo;
    String ipc_descripcion;
    Long aco_codigo;
    Long ipc_valor_est;
    Date ipc_fecha_ini_proc;
    Date ipc_fecha_ini_con;
    Long pcn_codigo;
    
    public ItemPlanContratacionCdpVO() {
        
    }

    public void setIpc_codigo(Long ipc_codigo) {
        this.ipc_codigo = ipc_codigo;
    }

    public Long getIpc_codigo() {
        return ipc_codigo;
    }

    public void setIpc_descripcion(String ipc_descripcion) {
        this.ipc_descripcion = ipc_descripcion;
    }

    public String getIpc_descripcion() {
        return ipc_descripcion;
    }

    public void setAco_codigo(Long aco_codigo) {
        this.aco_codigo = aco_codigo;
    }

    public Long getAco_codigo() {
        return aco_codigo;
    }

    public void setIpc_valor_est(Long ipc_valor_est) {
        this.ipc_valor_est = ipc_valor_est;
    }

    public Long getIpc_valor_est() {
        return ipc_valor_est;
    }

    public void setIpc_fecha_ini_proc(Date ipc_fecha_ini_proc) {
        this.ipc_fecha_ini_proc = ipc_fecha_ini_proc;
    }

    public Date getIpc_fecha_ini_proc() {
        return ipc_fecha_ini_proc;
    }

    public void setIpc_fecha_ini_con(Date ipc_fecha_ini_con) {
        this.ipc_fecha_ini_con = ipc_fecha_ini_con;
    }

    public Date getIpc_fecha_ini_con() {
        return ipc_fecha_ini_con;
    }

    public void setPcn_codigo(Long pcn_codigo) {
        this.pcn_codigo = pcn_codigo;
    }

    public Long getPcn_codigo() {
        return pcn_codigo;
    }    
}
