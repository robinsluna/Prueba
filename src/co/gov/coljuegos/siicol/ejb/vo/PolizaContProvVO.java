package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoPolContProv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAseguradora;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContProv;

import java.util.Date;
import java.util.List;

public class PolizaContProvVO {
    private Long pcpCodigo;
    private String pcpEstado;
    private Date pcpFechaExped;
    private Date pcpFechaRecep;
    private String pcpNumero;
    private ProcesoContratacionVO procesoContratacionVo;    
    private List<AmparoPolContProvVO> AmparoPolContProvListVo;
    private AseguradoraVO aseguradoraVo;
    private ArchivoFisicoVO archivoFisicoVo;
    private Date pcpFechaAprob;
    
    public PolizaContProvVO() {
    }
    
    public PolizaContProvVO(SiiPolizaContProv siiPolizaContProv) {
        
        this.pcpCodigo = siiPolizaContProv.getPcpCodigo();
        this.pcpEstado = siiPolizaContProv.getPcpEstado();
        this.pcpFechaExped = siiPolizaContProv.getPcpFechaExped();
        this.pcpFechaRecep = siiPolizaContProv.getPcpFechaRecep();
        this.pcpNumero = siiPolizaContProv.getPcpNumero();
        this.pcpFechaAprob = siiPolizaContProv.getPcpFechaAprob();
        
        //Padres
        if (siiPolizaContProv.getSiiAseguradora() != null){
            this.aseguradoraVo = new AseguradoraVO(siiPolizaContProv.getSiiAseguradora());
        }
        
        if (siiPolizaContProv.getSiiArchivoFisico() != null){
            this.archivoFisicoVo = new ArchivoFisicoVO (siiPolizaContProv.getSiiArchivoFisico());
        }
        
        if(siiPolizaContProv.getSiiProcesoContratacion() != null){
            this.procesoContratacionVo = new ProcesoContratacionVO(siiPolizaContProv.getSiiProcesoContratacion());
        }
    }

    public void setPcpCodigo(Long pcpCodigo) {
        this.pcpCodigo = pcpCodigo;
    }

    public Long getPcpCodigo() {
        return pcpCodigo;
    }

    public void setPcpEstado(String pcpEstado) {
        this.pcpEstado = pcpEstado;
    }

    public String getPcpEstado() {
        return pcpEstado;
    }

    public void setPcpFechaExped(Date pcpFechaExped) {
        this.pcpFechaExped = pcpFechaExped;
    }

    public Date getPcpFechaExped() {
        return pcpFechaExped;
    }

    public void setPcpFechaRecep(Date pcpFechaRecep) {
        this.pcpFechaRecep = pcpFechaRecep;
    }

    public Date getPcpFechaRecep() {
        return pcpFechaRecep;
    }

    public void setPcpNumero(String pcpNumero) {
        this.pcpNumero = pcpNumero;
    }

    public String getPcpNumero() {
        return pcpNumero;
    }

    public void setAseguradoraVo(AseguradoraVO aseguradoraVo) {
        this.aseguradoraVo = aseguradoraVo;
    }

    public AseguradoraVO getAseguradoraVo() {
        return aseguradoraVo;
    }

    public void setAmparoPolContProvListVo(List<AmparoPolContProvVO> AmparoPolContProvListVo) {
        this.AmparoPolContProvListVo = AmparoPolContProvListVo;
    }

    public List<AmparoPolContProvVO> getAmparoPolContProvListVo() {
        return AmparoPolContProvListVo;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setPcpFechaAprob(Date pcpFechaAprob) {
        this.pcpFechaAprob = pcpFechaAprob;
    }

    public Date getPcpFechaAprob() {
        return pcpFechaAprob;
    }

    public void setProcesoContratacionVo(ProcesoContratacionVO procesoContratacionVo) {
        this.procesoContratacionVo = procesoContratacionVo;
    }

    public ProcesoContratacionVO getProcesoContratacionVo() {
        return procesoContratacionVo;
    }
}
