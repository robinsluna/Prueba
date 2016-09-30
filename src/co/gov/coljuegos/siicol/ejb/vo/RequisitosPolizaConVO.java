package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRequisitosPolizaCon;

import java.util.List;

public class RequisitosPolizaConVO {
    private String rpcActivo;
    private Long rpcCodigo;
    private String rpcNombre;
    private List<PolizaRequisitosPolVO> polizaRequisitosPolListVo;

    public RequisitosPolizaConVO () {
        
    }
    
    public RequisitosPolizaConVO(SiiRequisitosPolizaCon requisitos) {
        this.rpcActivo = requisitos.getRpcActivo();
        this.rpcCodigo = requisitos.getRpcCodigo();
        this.rpcNombre = requisitos.getRpcNombre();
                
    }

    public void setRpcActivo(String rpcActivo) {
        this.rpcActivo = rpcActivo;
    }

    public String getRpcActivo() {
        return rpcActivo;
    }

    public void setRpcCodigo(Long rpcCodigo) {
        this.rpcCodigo = rpcCodigo;
    }

    public Long getRpcCodigo() {
        return rpcCodigo;
    }

    public void setRpcNombre(String rpcNombre) {
        this.rpcNombre = rpcNombre;
    }

    public String getRpcNombre() {
        return rpcNombre;
    }

    public void setPolizaRequisitosPolListVo(List<PolizaRequisitosPolVO> polizaRequisitosPolListVo) {
        this.polizaRequisitosPolListVo = polizaRequisitosPolListVo;
    }

    public List<PolizaRequisitosPolVO> getPolizaRequisitosPolListVo() {
        return polizaRequisitosPolListVo;
    }
}
