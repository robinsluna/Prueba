package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_REQUISITOS_POLIZA_CON")
public class SiiRequisitosPolizaCon implements Serializable {
    private static final long serialVersionUID = 1321205976598608640L;
    private String rpcActivo;
    private Long rpcCodigo;
    private String rpcNombre;
    private List<SiiPolizaRequisitosPol> siiPolizaRequisitosPolList1;

    public SiiRequisitosPolizaCon() {
    }

    public SiiRequisitosPolizaCon(String rpcActivo, Long rpcCodigo, String rpcNombre) {
        this.rpcActivo = rpcActivo;
        this.rpcCodigo = rpcCodigo;
        this.rpcNombre = rpcNombre;
    }

    @Column(name = "RPC_ACTIVO", nullable = false, length = 1)
    public String getRpcActivo() {
        return rpcActivo;
    }

    public void setRpcActivo(String rpcActivo) {
        this.rpcActivo = rpcActivo;
    }

    @Id
    @Column(name = "RPC_CODIGO", nullable = false)
    public Long getRpcCodigo() {
        return rpcCodigo;
    }

    public void setRpcCodigo(Long rpcCodigo) {
        this.rpcCodigo = rpcCodigo;
    }

    @Column(name = "RPC_NOMBRE", nullable = false, length = 20)
    public String getRpcNombre() {
        return rpcNombre;
    }

    public void setRpcNombre(String rpcNombre) {
        this.rpcNombre = rpcNombre;
    }

    @OneToMany(mappedBy = "siiRequisitosPolizaCon")
    public List<SiiPolizaRequisitosPol> getSiiPolizaRequisitosPolList1() {
        return siiPolizaRequisitosPolList1;
    }

    public void setSiiPolizaRequisitosPolList1(List<SiiPolizaRequisitosPol> siiPolizaRequisitosPolList1) {
        this.siiPolizaRequisitosPolList1 = siiPolizaRequisitosPolList1;
    }

    public SiiPolizaRequisitosPol addSiiPolizaRequisitosPol(SiiPolizaRequisitosPol siiPolizaRequisitosPol) {
        getSiiPolizaRequisitosPolList1().add(siiPolizaRequisitosPol);
        siiPolizaRequisitosPol.setSiiRequisitosPolizaCon(this);
        return siiPolizaRequisitosPol;
    }

    public SiiPolizaRequisitosPol removeSiiPolizaRequisitosPol(SiiPolizaRequisitosPol siiPolizaRequisitosPol) {
        getSiiPolizaRequisitosPolList1().remove(siiPolizaRequisitosPol);
        siiPolizaRequisitosPol.setSiiRequisitosPolizaCon(null);
        return siiPolizaRequisitosPol;
    }
}
