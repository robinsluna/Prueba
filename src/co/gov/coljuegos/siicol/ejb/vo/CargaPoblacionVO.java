package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaPoblacion;

import java.util.Date;
import java.util.List;

public class CargaPoblacionVO {

    private Long cpoCodigo;
    private Integer cpoConsecutivoCar;
    private Date cpoFechaRad;
    private Date cpoFechaRegistro;
    private String cpoFuente;
    private String cpoNumeroRad;
    private ArchivoFisicoVO archivoFisicoVo;
    private PoblacionEnteVO poblacionEnteVo;
    private List<PoblacionEnteVO> listaPoblacionEnteVo;


    public CargaPoblacionVO() {
    }

    public CargaPoblacionVO(SiiCargaPoblacion siiCargaPoblacion) {
        
        this.setCpoCodigo(siiCargaPoblacion.getCpoCodigo());
        this.setCpoConsecutivoCar(siiCargaPoblacion.getCpoConsecutivoCar());
        this.setCpoFechaRad(siiCargaPoblacion.getCpoFechaRad());
        this.setCpoFechaRegistro(siiCargaPoblacion.getCpoFechaRegistro());
        this.setCpoFuente(siiCargaPoblacion.getCpoFuente());
        this.setCpoNumeroRad(siiCargaPoblacion.getCpoNumeroRad());

        //padres
        if (siiCargaPoblacion.getSiiArchivoFisico() !=null)
            this.archivoFisicoVo = new ArchivoFisicoVO(siiCargaPoblacion.getSiiArchivoFisico());
    }

    public void setCpoCodigo(Long cpoCodigo) {
        this.cpoCodigo = cpoCodigo;
    }

    public Long getCpoCodigo() {
        return cpoCodigo;
    }

    public void setCpoConsecutivoCar(Integer cpoConsecutivoCar) {
        this.cpoConsecutivoCar = cpoConsecutivoCar;
    }

    public Integer getCpoConsecutivoCar() {
        return cpoConsecutivoCar;
    }

    public void setCpoFechaRad(Date cpoFechaRad) {
        this.cpoFechaRad = cpoFechaRad;
    }

    public Date getCpoFechaRad() {
        return cpoFechaRad;
    }

    public void setCpoFechaRegistro(Date cpoFechaRegistro) {
        this.cpoFechaRegistro = cpoFechaRegistro;
    }

    public Date getCpoFechaRegistro() {
        return cpoFechaRegistro;
    }

    public void setCpoFuente(String cpoFuente) {
        this.cpoFuente = cpoFuente;
    }

    public String getCpoFuente() {
        return cpoFuente;
    }

    public void setCpoNumeroRad(String cpoNumeroRad) {
        this.cpoNumeroRad = cpoNumeroRad;
    }

    public String getCpoNumeroRad() {
        return cpoNumeroRad;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setPoblacionEnteVo(PoblacionEnteVO poblacionEnteVo) {
        this.poblacionEnteVo = poblacionEnteVo;
    }

    public PoblacionEnteVO getPoblacionEnteVo() {
        return poblacionEnteVo;
    }

    public void setListaPoblacionEnteVo(List<PoblacionEnteVO> listaPoblacionEnteVo) {
        this.listaPoblacionEnteVo = listaPoblacionEnteVo;
    }

    public List<PoblacionEnteVO> getListaPoblacionEnteVo() {
        return listaPoblacionEnteVo;
    }
    
}
