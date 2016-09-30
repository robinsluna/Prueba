package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaIniContrato;

import java.util.Date;
import java.util.List;

public class ActaIniContratoVO {
    private Long acnCodigo;
    private Date acnFechaIni;
    private Integer acnEstado;    
    private ArchivoFisicoVO archivoFisicoVo;
    private ProcesoContratacionVO procesoContratacionVo;
    private ClaseContratoVO claseContratoVo;
    private List<InformeActaIniVO> informeActaIniListVo;
    private List<InformeContrProvVO> informeContrProvListVo;
    private String estadoActaInicio; // Campo calculado
    

    public ActaIniContratoVO() {
    }
    
    public ActaIniContratoVO(SiiActaIniContrato actaIniContrato) {
        this.acnCodigo = actaIniContrato.getAcnCodigo();
        this.acnFechaIni = actaIniContrato.getAcnFechaIni();
        this.acnEstado = actaIniContrato.getAcnEstado();
        this.estadoActaInicio = "";
        if (this.acnEstado == 1) {
            this.estadoActaInicio = "BORRADOR";
        } 
        if (this.acnEstado == 2) {
            this.estadoActaInicio =  "APROBADO";
        }
        //Padres:
        if (actaIniContrato.getSiiArchivoFisico() != null ) {
            this.archivoFisicoVo = new ArchivoFisicoVO(actaIniContrato.getSiiArchivoFisico());
        }
        if (actaIniContrato.getSiiClaseContrato() != null) {
            this.claseContratoVo = new ClaseContratoVO(actaIniContrato.getSiiClaseContrato());
        }
        if (actaIniContrato.getSiiProcesoContratacion() != null) {
            this.procesoContratacionVo = new ProcesoContratacionVO(actaIniContrato.getSiiProcesoContratacion());
        }
    }

    public void setAcnCodigo(Long acnCodigo) {
        this.acnCodigo = acnCodigo;
    }

    public Long getAcnCodigo() {
        return acnCodigo;
    }

    public void setAcnFechaIni(Date acnFechaIni) {
        this.acnFechaIni = acnFechaIni;
    }

    public Date getAcnFechaIni() {
        return acnFechaIni;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setProcesoContratacionVo(ProcesoContratacionVO procesoContratacionVo) {
        this.procesoContratacionVo = procesoContratacionVo;
    }

    public ProcesoContratacionVO getProcesoContratacionVo() {
        return procesoContratacionVo;
    }

    public void setClaseContratoVo(ClaseContratoVO claseContratoVo) {
        this.claseContratoVo = claseContratoVo;
    }

    public ClaseContratoVO getClaseContratoVo() {
        return claseContratoVo;
    }

    public void setInformeActaIniListVo(List<InformeActaIniVO> informeActaIniListVo) {
        this.informeActaIniListVo = informeActaIniListVo;
    }

    public List<InformeActaIniVO> getInformeActaIniListVo() {
        return informeActaIniListVo;
    }

    public void setInformeContrProvListVo(List<InformeContrProvVO> informeContrProvListVo) {
        this.informeContrProvListVo = informeContrProvListVo;
    }

    public List<InformeContrProvVO> getInformeContrProvListVo() {
        return informeContrProvListVo;
    }

    public void setAcnEstado(Integer acnEstado) {
        this.acnEstado = acnEstado;
    }

    public Integer getAcnEstado() {
        return acnEstado;
    }

    public void setEstadoActaInicio(String estadoActaInicio) {
        this.estadoActaInicio = estadoActaInicio;
    }

    public String getEstadoActaInicio() {
        return estadoActaInicio;
    }
}
