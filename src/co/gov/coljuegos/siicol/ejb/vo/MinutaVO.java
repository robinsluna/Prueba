package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;

public class MinutaVO {
       BigDecimal cpr_valor;
       String cpr_fecha; 
       Long oad_vigencia_contr;
       String oad_tipo_contr;
       Date oad_fecha_reg;
       String epe_descr_justif;
       String epe_formas_analiz;
       BigDecimal epe_valor_contrat;
       String epe_forma_pago; 
       String epe_obligac_contrat;
       String epe_analisi_econ;
       Long epe_vigencia;
       String tga_nombre;
       Long ipc_codigo;
       String ipc_descripcion;
       Long cdp_codigo;
       Long cdp_consecutivo;
       String cdp_fecha_expedicion;
       Long oad_consec_contr;       
       String pro_ejecutivo_cuenta; 
       String per_num_identificacion; 
       String per_jur_nombre_largo; 
       String per_direccion;
       String sem_objeto_contrato;
       Long sem_tiempo_estimado; 
       String sem_unid_tiempo_estim;
       String sem_tipo_supervisor;
       Long usu_codigo_supervisor;
       String rep_num_identificacion;
       String rep_nombre;
       String rep_tid_nombre;
       String cbp_numero;
       String tid_persona;
       String tid_representante;
       
       
    public MinutaVO() {
        
    }

    public void setCpr_valor(BigDecimal cpr_valor) {
        this.cpr_valor = cpr_valor;
    }

    public BigDecimal getCpr_valor() {
        return cpr_valor;
    }

    public void setCpr_fecha(String cpr_fecha) {
        this.cpr_fecha = cpr_fecha;
    }

    public String getCpr_fecha() {
        return cpr_fecha;
    }

    public void setOad_vigencia_contr(Long oad_vigencia_contr) {
        this.oad_vigencia_contr = oad_vigencia_contr;
    }

    public Long getOad_vigencia_contr() {
        return oad_vigencia_contr;
    }

    public void setOad_tipo_contr(String oad_tipo_contr) {
        this.oad_tipo_contr = oad_tipo_contr;
    }

    public String getOad_tipo_contr() {
        return oad_tipo_contr;
    }

    public void setOad_fecha_reg(Date oad_fecha_reg) {
        this.oad_fecha_reg = oad_fecha_reg;
    }

    public Date getOad_fecha_reg() {
        return oad_fecha_reg;
    }

    public void setEpe_descr_justif(String epe_descr_justif) {
        this.epe_descr_justif = epe_descr_justif;
    }

    public String getEpe_descr_justif() {
        return epe_descr_justif;
    }

    public void setEpe_formas_analiz(String epe_formas_analiz) {
        this.epe_formas_analiz = epe_formas_analiz;
    }

    public String getEpe_formas_analiz() {
        return epe_formas_analiz;
    }

    public void setEpe_valor_contrat(BigDecimal epe_valor_contrat) {
        this.epe_valor_contrat = epe_valor_contrat;
    }

    public BigDecimal getEpe_valor_contrat() {
        return epe_valor_contrat;
    }

    public void setEpe_forma_pago(String epe_forma_pago) {
        this.epe_forma_pago = epe_forma_pago;
    }

    public String getEpe_forma_pago() {
        return epe_forma_pago;
    }

    public void setEpe_obligac_contrat(String epe_obligac_contrat) {
        this.epe_obligac_contrat = epe_obligac_contrat;
    }

    public String getEpe_obligac_contrat() {
        return epe_obligac_contrat;
    }

    public void setEpe_analisi_econ(String epe_analisi_econ) {
        this.epe_analisi_econ = epe_analisi_econ;
    }

    public String getEpe_analisi_econ() {
        return epe_analisi_econ;
    }

    public void setEpe_vigencia(Long epe_vigencia) {
        this.epe_vigencia = epe_vigencia;
    }

    public Long getEpe_vigencia() {
        return epe_vigencia;
    }

    public void setTga_nombre(String tga_nombre) {
        this.tga_nombre = tga_nombre;
    }

    public String getTga_nombre() {
        return tga_nombre;
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

    public void setCdp_codigo(Long cdp_codigo) {
        this.cdp_codigo = cdp_codigo;
    }

    public Long getCdp_codigo() {
        return cdp_codigo;
    }

    public void setCdp_consecutivo(Long cdp_consecutivo) {
        this.cdp_consecutivo = cdp_consecutivo;
    }

    public Long getCdp_consecutivo() {
        return cdp_consecutivo;
    }

    public void setCdp_fecha_expedicion(String cdp_fecha_expedicion) {
        this.cdp_fecha_expedicion = cdp_fecha_expedicion;
    }

    public String getCdp_fecha_expedicion() {
        return cdp_fecha_expedicion;
    }

    public void setOad_consec_contr(Long oad_consec_contr) {
        this.oad_consec_contr = oad_consec_contr;
    }

    public Long getOad_consec_contr() {
        return oad_consec_contr;
    }

    public void setPro_ejecutivo_cuenta(String pro_ejecutivo_cuenta) {
        this.pro_ejecutivo_cuenta = pro_ejecutivo_cuenta;
    }

    public String getPro_ejecutivo_cuenta() {
        return pro_ejecutivo_cuenta;
    }

    public void setPer_num_identificacion(String per_num_identificacion) {
        this.per_num_identificacion = per_num_identificacion;
    }

    public String getPer_num_identificacion() {
        return per_num_identificacion;
    }

    public void setPer_jur_nombre_largo(String per_jur_nombre_largo) {
        this.per_jur_nombre_largo = per_jur_nombre_largo;
    }

    public String getPer_jur_nombre_largo() {
        return per_jur_nombre_largo;
    }

    public void setPer_direccion(String per_direccion) {
        this.per_direccion = per_direccion;
    }

    public String getPer_direccion() {
        return per_direccion;
    }

    public void setSem_objeto_contrato(String sem_objeto_contrato) {
        this.sem_objeto_contrato = sem_objeto_contrato;
    }

    public String getSem_objeto_contrato() {
        return sem_objeto_contrato;
    }

    public void setSem_tiempo_estimado(Long sem_tiempo_estimado) {
        this.sem_tiempo_estimado = sem_tiempo_estimado;
    }

    public Long getSem_tiempo_estimado() {
        return sem_tiempo_estimado;
    }

    public void setSem_unid_tiempo_estim(String sem_unid_tiempo_estim) {
        this.sem_unid_tiempo_estim = sem_unid_tiempo_estim;
    }

    public String getSem_unid_tiempo_estim() {
        return sem_unid_tiempo_estim;
    }

    public void setSem_tipo_supervisor(String sem_tipo_supervisor) {
        this.sem_tipo_supervisor = sem_tipo_supervisor;
    }

    public String getSem_tipo_supervisor() {
        return sem_tipo_supervisor;
    }

    public void setUsu_codigo_supervisor(Long usu_codigo_supervisor) {
        this.usu_codigo_supervisor = usu_codigo_supervisor;
    }

    public Long getUsu_codigo_supervisor() {
        return usu_codigo_supervisor;
    }

    public void setRep_num_identificacion(String rep_num_identificacion) {
        this.rep_num_identificacion = rep_num_identificacion;
    }

    public String getRep_num_identificacion() {
        return rep_num_identificacion;
    }

    public void setRep_nombre(String rep_nombre) {
        this.rep_nombre = rep_nombre;
    }

    public String getRep_nombre() {
        return rep_nombre;
    }

    public void setRep_tid_nombre(String rep_tid_nombre) {
        this.rep_tid_nombre = rep_tid_nombre;
    }

    public String getRep_tid_nombre() {
        return rep_tid_nombre;
    }

    public void setCbp_numero(String cbp_numero) {
        this.cbp_numero = cbp_numero;
    }

    public String getCbp_numero() {
        return cbp_numero;
    }

    public void setTid_persona(String tid_persona) {
        this.tid_persona = tid_persona;
    }

    public String getTid_persona() {
        return tid_persona;
    }

    public void setTid_representante(String tid_representante) {
        this.tid_representante = tid_representante;
    }

    public String getTid_representante() {
        return tid_representante;
    }
}
