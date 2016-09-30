/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 24-01-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoConpes;

import java.util.Date;
import java.util.List;

public class DocumentoConpesVO {

    private Long dcnCodigo;
    private String dcnNumero;
    private Date dcnFecha;
    private String dcnActivo;
    private Date dcnFechaRegistro;
    private ArchivoFisicoVO archivoFisicoVo;
    private EstadoDocConpesVO estadoDocConpesVo;
    private List<DistribucionUbicaVO> listaDistribucionUbicaVo;
    private Long idEstadoAnterior;

    public DocumentoConpesVO() {
    }

    public DocumentoConpesVO(SiiDocumentoConpes siiDocumentoConpes) {

        this.setDcnCodigo(siiDocumentoConpes.getDcnCodigo());
        this.setDcnActivo(siiDocumentoConpes.getDcnActivo());
        this.setDcnFecha(siiDocumentoConpes.getDcnFecha());
        this.setDcnFechaRegistro(siiDocumentoConpes.getDcnFechaReg());
        this.setDcnNumero(siiDocumentoConpes.getDcnNumero());

        //padres
        if (siiDocumentoConpes.getSiiArchivoFisico() != null)
            this.archivoFisicoVo = new ArchivoFisicoVO(siiDocumentoConpes.getSiiArchivoFisico());

        //Estado
        if (siiDocumentoConpes.getSiiEstadoDocConpes() != null) {
            this.estadoDocConpesVo = new EstadoDocConpesVO(siiDocumentoConpes.getSiiEstadoDocConpes());
            this.idEstadoAnterior = siiDocumentoConpes.getSiiEstadoDocConpes().getEdcCodigo();
        }
    }


    public void setDcnCodigo(Long dcnCodigo) {
        this.dcnCodigo = dcnCodigo;
    }

    public Long getDcnCodigo() {
        return dcnCodigo;
    }


    public void setDcnNumero(String dcnNumero) {
        this.dcnNumero = dcnNumero;
    }

    public String getDcnNumero() {
        return dcnNumero;
    }

    public void setListaDistribucionUbicaVo(List<DistribucionUbicaVO> listaDistribucionUbicaVo) {
        this.listaDistribucionUbicaVo = listaDistribucionUbicaVo;
    }

    public List<DistribucionUbicaVO> getListaDistribucionUbicaVo() {
        return listaDistribucionUbicaVo;
    }

    public void setDcnFecha(Date dcnFecha) {
        this.dcnFecha = dcnFecha;
    }

    public Date getDcnFecha() {
        return dcnFecha;
    }

    public void setDcnActivo(String dcnActivo) {
        this.dcnActivo = dcnActivo;
    }

    public String getDcnActivo() {
        return dcnActivo;
    }

    public void setDcnFechaRegistro(Date dcnFechaRegistro) {
        this.dcnFechaRegistro = dcnFechaRegistro;
    }

    public Date getDcnFechaRegistro() {
        return dcnFechaRegistro;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setEstadoDocConpesVo(EstadoDocConpesVO estadoDocConpesVo) {
        this.estadoDocConpesVo = estadoDocConpesVo;
    }

    public EstadoDocConpesVO getEstadoDocConpesVo() {
        return estadoDocConpesVo;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }
}
