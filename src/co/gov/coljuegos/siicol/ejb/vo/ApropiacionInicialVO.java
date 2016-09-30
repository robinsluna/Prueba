/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 16-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiApropiacionInicial;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.util.Date;

public class ApropiacionInicialVO {
    private static final long serialVersionUID = -8354565780074300394L;
    private String ainAutorizado;
    private String ainCerrado;
    private Long ainCodigo;
    private String ainElaborado;
    private Date ainFechaAcuerdoJunta;
    private Date ainFechaAutorizacion;
    private Date ainFechaCierre;
    private Date ainFechaDecreto;
    private Date ainFechaElaboracion;
    private Date ainFechaOficioDesagregacion;
    private String ainNumOficioDesagregacion;
    private String ainNumeroAcuerdoJunta;
    private String ainNumeroDecreto;
    private Integer ainVigencia;
    private UsuarioVO usuarioVo1;
    private UsuarioVO usuarioVo3;
    private UsuarioVO usuarioVo4;
    private String cadenaNiveles;
    private NivelRubroDetFuenteValorVO unNivelRubroDetFuenteValorVO;
    private ArchivoFisicoVO archivoFisicoVo;

    public ApropiacionInicialVO(SiiApropiacionInicial siiApropiacionInicial){
        this.ainAutorizado = siiApropiacionInicial.getAinAutorizado();
        this.ainCerrado = siiApropiacionInicial.getAinCerrado();
        this.ainCodigo = siiApropiacionInicial.getAinCodigo();
        this.ainElaborado = siiApropiacionInicial.getAinElaborado();
        this.ainFechaAcuerdoJunta = siiApropiacionInicial.getAinFechaAcuerdoJunta();
        this.ainFechaAutorizacion = siiApropiacionInicial.getAinFechaAutorizacion();
        this.ainFechaCierre = siiApropiacionInicial.getAinFechaCierre();
        this.ainFechaDecreto = siiApropiacionInicial.getAinFechaDecreto();
        this.ainFechaElaboracion = siiApropiacionInicial.getAinFechaElaboracion();
        this.ainFechaOficioDesagregacion = siiApropiacionInicial.getAinFechaOficioDesagregacion();
        this.ainNumOficioDesagregacion = siiApropiacionInicial.getAinNumOficioDesagregacion();
        this.ainNumeroAcuerdoJunta = siiApropiacionInicial.getAinNumeroAcuerdoJunta();
        this.ainNumeroDecreto = siiApropiacionInicial.getAinNumeroDecreto();
        this.ainVigencia = siiApropiacionInicial.getAinVigencia();
        if(siiApropiacionInicial.getSiiArchivoFisico() != null){
            this.archivoFisicoVo = new ArchivoFisicoVO(siiApropiacionInicial.getSiiArchivoFisico());
        }
        
        if(siiApropiacionInicial.getSiiUsuario1() != null){
            this.usuarioVo1 = new UsuarioVO(siiApropiacionInicial.getSiiUsuario1());
        }
        if(siiApropiacionInicial.getSiiUsuario3() != null){
            this.usuarioVo3 = new UsuarioVO(siiApropiacionInicial.getSiiUsuario3());
        }
        if(siiApropiacionInicial.getSiiUsuario4() != null){
            this.usuarioVo4 = new UsuarioVO(siiApropiacionInicial.getSiiUsuario4());
        }
    }
    
    public ApropiacionInicialVO() {
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setAinAutorizado(String ainAutorizado) {
        this.ainAutorizado = ainAutorizado;
    }

    public String getAinAutorizado() {
        return ainAutorizado;
    }

    public void setAinCerrado(String ainCerrado) {
        this.ainCerrado = ainCerrado;
    }

    public String getAinCerrado() {
        return ainCerrado;
    }

    public void setAinCodigo(Long ainCodigo) {
        this.ainCodigo = ainCodigo;
    }

    public Long getAinCodigo() {
        return ainCodigo;
    }

    public void setAinElaborado(String ainElaborado) {
        this.ainElaborado = ainElaborado;
    }

    public String getAinElaborado() {
        return ainElaborado;
    }

    public void setAinFechaAcuerdoJunta(Date ainFechaAcuerdoJunta) {
        this.ainFechaAcuerdoJunta = ainFechaAcuerdoJunta;
    }

    public Date getAinFechaAcuerdoJunta() {
        return ainFechaAcuerdoJunta;
    }

    public void setAinFechaAutorizacion(Date ainFechaAutorizacion) {
        this.ainFechaAutorizacion = ainFechaAutorizacion;
    }

    public Date getAinFechaAutorizacion() {
        return ainFechaAutorizacion;
    }

    public void setAinFechaCierre(Date ainFechaCierre) {
        this.ainFechaCierre = ainFechaCierre;
    }

    public Date getAinFechaCierre() {
        return ainFechaCierre;
    }

    public void setAinFechaDecreto(Date ainFechaDecreto) {
        this.ainFechaDecreto = ainFechaDecreto;
    }

    public Date getAinFechaDecreto() {
        return ainFechaDecreto;
    }

    public void setAinFechaElaboracion(Date ainFechaElaboracion) {
        this.ainFechaElaboracion = ainFechaElaboracion;
    }

    public Date getAinFechaElaboracion() {
        return ainFechaElaboracion;
    }

    public void setAinFechaOficioDesagregacion(Date ainFechaOficioDesagregacion) {
        this.ainFechaOficioDesagregacion = ainFechaOficioDesagregacion;
    }

    public Date getAinFechaOficioDesagregacion() {
        return ainFechaOficioDesagregacion;
    }

    public void setAinNumOficioDesagregacion(String ainNumOficioDesagregacion) {
        this.ainNumOficioDesagregacion = ainNumOficioDesagregacion;
    }

    public String getAinNumOficioDesagregacion() {
        return ainNumOficioDesagregacion;
    }

    public void setAinNumeroAcuerdoJunta(String ainNumeroAcuerdoJunta) {
        this.ainNumeroAcuerdoJunta = ainNumeroAcuerdoJunta;
    }

    public String getAinNumeroAcuerdoJunta() {
        return ainNumeroAcuerdoJunta;
    }

    public void setAinNumeroDecreto(String ainNumeroDecreto) {
        this.ainNumeroDecreto = ainNumeroDecreto;
    }

    public String getAinNumeroDecreto() {
        return ainNumeroDecreto;
    }

    public void setUnNivelRubroDetFuenteValorVO(NivelRubroDetFuenteValorVO unNivelRubroDetFuenteValorVO) {
        this.unNivelRubroDetFuenteValorVO = unNivelRubroDetFuenteValorVO;
    }

    public NivelRubroDetFuenteValorVO getUnNivelRubroDetFuenteValorVO() {
        return unNivelRubroDetFuenteValorVO;
    }

    public void setAinVigencia(Integer ainVigencia) {
        this.ainVigencia = ainVigencia;
    }

    public Integer getAinVigencia() {
        return ainVigencia;
    }

    public void setUsuarioVo1(UsuarioVO usuarioVo1) {
        this.usuarioVo1 = usuarioVo1;
    }

    public UsuarioVO getUsuarioVo1() {
        return usuarioVo1;
    }

    public void setUsuarioVo3(UsuarioVO usuarioVo3) {
        this.usuarioVo3 = usuarioVo3;
    }

    public UsuarioVO getUsuarioVo3() {
        return usuarioVo3;
    }

    public void setCadenaNiveles(String cadenaNiveles) {
        this.cadenaNiveles = cadenaNiveles;
    }

    public String getCadenaNiveles() {
        return cadenaNiveles;
    }

    public void setUsuarioVo4(UsuarioVO usuarioVo4) {
        this.usuarioVo4 = usuarioVo4;
    }

    public UsuarioVO getUsuarioVo4() {
        return usuarioVo4;
    }

}
