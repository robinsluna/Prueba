/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEvaluacionJurTecFin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object para la Evaluaci&oacute;n.
 * @author Camilo Miranda
 */
public class EvaluacionJurTecFinVO {
    private Long ejtCodigo;
    private Date ejtFechaAprobFin;
    private Date ejtFechaAprobJur;
    private Date ejtFechaAprobTec;
    private String ejtObservaciones;
    private List<PropuestaEvaluacionVO> propuestaEvaluacionList;
    private EstadoEvaluacionJtfVO estadoEvaluacionJtf;
    private ProcesoContratacionVO procesoContratacion;
    private ArchivoFisicoVO archivoFisicoJur;
    private ArchivoFisicoVO archivoFisicoTec;
    private ArchivoFisicoVO archivoFisicoFin;
    private Long idEstadoAnterior;


    /**
     * Constructor.
     */
    public EvaluacionJurTecFinVO() {
    }


    /**
     * @author Modifica Giovanni
     * Constructor.
     * @param siiEvaluacionJurTecFin - Entity
     */
    public EvaluacionJurTecFinVO(SiiEvaluacionJurTecFin siiEvaluacionJurTecFin) {
        this.ejtCodigo = siiEvaluacionJurTecFin.getEjtCodigo();
        this.ejtFechaAprobFin = siiEvaluacionJurTecFin.getEjtFechaAprobFin();
        this.ejtFechaAprobJur = siiEvaluacionJurTecFin.getEjtFechaAprobJur();
        this.ejtFechaAprobTec = siiEvaluacionJurTecFin.getEjtFechaAprobTec();
        this.ejtObservaciones = siiEvaluacionJurTecFin.getEjtObservaciones();

        //Estado
        if (siiEvaluacionJurTecFin.getSiiEstadoEvaluacionJtf() != null) {
            this.estadoEvaluacionJtf = new EstadoEvaluacionJtfVO(siiEvaluacionJurTecFin.getSiiEstadoEvaluacionJtf());
            this.idEstadoAnterior = siiEvaluacionJurTecFin.getSiiEstadoEvaluacionJtf().getEejCodigo();
        }

        //Proceso Contratacion
        if (siiEvaluacionJurTecFin.getSiiProcesoContratacion() != null)
            this.procesoContratacion = new ProcesoContratacionVO(siiEvaluacionJurTecFin.getSiiProcesoContratacion());

        /*
        if (siiEvaluacionJurTecFin.getSiiPropuestaEvaluacionList()!=null) {
            propuestaEvaluacionList = new ArrayList<PropuestaEvaluacionVO>();
            for (SiiPropuestaEvaluacion prEv: siiEvaluacionJurTecFin.getSiiPropuestaEvaluacionList()) {
                this.addPropuestaEvaluacionVO(new PropuestaEvaluacionVO(prEv));
            }
        }
        */

        if (siiEvaluacionJurTecFin.getSiiArchivoFisicoJur() != null)
            this.archivoFisicoJur = new ArchivoFisicoVO(siiEvaluacionJurTecFin.getSiiArchivoFisicoJur());

        if (siiEvaluacionJurTecFin.getSiiArchivoFisicoTec() != null)
            this.archivoFisicoTec = new ArchivoFisicoVO(siiEvaluacionJurTecFin.getSiiArchivoFisicoTec());

        if (siiEvaluacionJurTecFin.getSiiArchivoFisicoFin() != null)
            this.archivoFisicoFin = new ArchivoFisicoVO(siiEvaluacionJurTecFin.getSiiArchivoFisicoFin());
    }


    public void setEjtCodigo(Long ejtCodigo) {
        this.ejtCodigo = ejtCodigo;
    }

    public Long getEjtCodigo() {
        return ejtCodigo;
    }

    public void setEjtFechaAprobFin(Date ejtFechaAprobFin) {
        this.ejtFechaAprobFin = ejtFechaAprobFin;
    }

    public Date getEjtFechaAprobFin() {
        return ejtFechaAprobFin;
    }

    public void setEjtFechaAprobJur(Date ejtFechaAprobJur) {
        this.ejtFechaAprobJur = ejtFechaAprobJur;
    }

    public Date getEjtFechaAprobJur() {
        return ejtFechaAprobJur;
    }

    public void setEjtFechaAprobTec(Date ejtFechaAprobTec) {
        this.ejtFechaAprobTec = ejtFechaAprobTec;
    }

    public Date getEjtFechaAprobTec() {
        return ejtFechaAprobTec;
    }

    public void setPropuestaEvaluacionList(List<PropuestaEvaluacionVO> propuestaEvaluacionList) {
        this.propuestaEvaluacionList = propuestaEvaluacionList;
    }

    public List<PropuestaEvaluacionVO> getPropuestaEvaluacionList() {
        return propuestaEvaluacionList;
    }

    public void setEstadoEvaluacionJtf(EstadoEvaluacionJtfVO estadoEvaluacionJtf) {
        this.estadoEvaluacionJtf = estadoEvaluacionJtf;
    }

    public EstadoEvaluacionJtfVO getEstadoEvaluacionJtf() {
        return estadoEvaluacionJtf;
    }

    public void setProcesoContratacion(ProcesoContratacionVO procesoContratacion) {
        this.procesoContratacion = procesoContratacion;
    }

    public ProcesoContratacionVO getProcesoContratacion() {
        return procesoContratacion;
    }


    public boolean addPropuestaEvaluacionVO(PropuestaEvaluacionVO propuestaEvaluacionVO) {
        boolean exitoso = false;

        if (propuestaEvaluacionList == null)
            propuestaEvaluacionList = new ArrayList<PropuestaEvaluacionVO>();

        exitoso = getPropuestaEvaluacionList().add(propuestaEvaluacionVO);
        if (exitoso)
            propuestaEvaluacionVO.setEvaluacionJurTecFin(this);
        return (exitoso);
    }

    public boolean removePropuestaEvaluacionVO(PropuestaEvaluacionVO propuestaEvaluacionVO) {
        boolean exitoso = false;
        exitoso = getPropuestaEvaluacionList().remove(propuestaEvaluacionVO);
        if (exitoso)
            propuestaEvaluacionVO.setEvaluacionJurTecFin(null);
        return (exitoso);
    }


    public void setArchivoFisicoJur(ArchivoFisicoVO archivoFisicoJur) {
        this.archivoFisicoJur = archivoFisicoJur;
    }

    public ArchivoFisicoVO getArchivoFisicoJur() {
        return archivoFisicoJur;
    }

    public void setArchivoFisicoTec(ArchivoFisicoVO archivoFisicoTec) {
        this.archivoFisicoTec = archivoFisicoTec;
    }

    public ArchivoFisicoVO getArchivoFisicoTec() {
        return archivoFisicoTec;
    }

    public void setArchivoFisicoFin(ArchivoFisicoVO archivoFisicoFin) {
        this.archivoFisicoFin = archivoFisicoFin;
    }

    public ArchivoFisicoVO getArchivoFisicoFin() {
        return archivoFisicoFin;
    }


    public void setEjtObservaciones(String ejtObservaciones) {
        this.ejtObservaciones = ejtObservaciones;
    }

    public String getEjtObservaciones() {
        return ejtObservaciones;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }
}
