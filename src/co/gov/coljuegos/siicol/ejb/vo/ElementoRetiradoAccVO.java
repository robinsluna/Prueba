package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumElementoRetiradoACC;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoRetiradoAcc;

import java.math.BigDecimal;

import java.util.List;

public class ElementoRetiradoAccVO implements Cloneable {
    private String elrActivo;
    private BigDecimal elrAvaluo;
    private Long elrCodigo;
    private String elrMarca;
    private String elrModelo;
    private Integer elrNumElementos;
    private Integer elrSello;
    private String elrSerial;
    private String elrUtilizaTrans;
    private TipoElemenIlegalidadVO tipoElemenIlegalidadVo;
    private UsuarioVO usuarioConectVo;
    private AccionControlVO accionControlVo;
    private String elrAccion;
    private String elrDestruido;
    
    private boolean accionDevolucion;
    private boolean accionDecomisoDestruccion;

    //adicional a la defincion en la entity
    private List<TipoElemenIlegalidadVO> tiposElemenIlegalidadVo;


    public ElementoRetiradoAccVO() {

    }

    public ElementoRetiradoAccVO(SiiElementoRetiradoAcc elemento) {
        this.elrActivo = elemento.getElrActivo();
        this.elrAvaluo = elemento.getElrAvaluo();
        this.elrCodigo = elemento.getElrCodigo();
        this.elrMarca = elemento.getElrMarca();
        this.elrModelo = elemento.getElrModelo();
        this.elrNumElementos = elemento.getElrNumElementos();
        this.elrSello = elemento.getElrSello();
        this.elrSerial = elemento.getElrSerial();
        this.elrUtilizaTrans = elemento.getElrUtilizaTrans();
        this.elrAccion = elemento.getElrAccion();
        this.elrDestruido = elemento.getElrDestruido();
        //Padres:

        this.accionControlVo = elemento.getSiiAccionControl() != null ? new AccionControlVO(elemento.getSiiAccionControl()) : new AccionControlVO();
        this.tipoElemenIlegalidadVo = elemento.getSiiTipoElemenIlegalidad() != null ? new TipoElemenIlegalidadVO(elemento.getSiiTipoElemenIlegalidad()) : new TipoElemenIlegalidadVO();
        this.usuarioConectVo = elemento.getSiiUsuarioConect() != null ? new UsuarioVO(elemento.getSiiUsuarioConect()) : new UsuarioVO();
    }

    @Override
    public Object clone() {
        ElementoRetiradoAccVO elemento = new ElementoRetiradoAccVO();
        elemento.elrAccion = elrAccion;
        elemento.elrActivo = elrActivo;
        elemento.elrAvaluo = elrAvaluo;
        elemento.elrCodigo = elrCodigo;
        elemento.elrDestruido = elrDestruido;
        elemento.elrMarca = elrMarca;
        elemento.elrModelo = elrModelo;
        elemento.elrNumElementos = elrNumElementos;
        elemento.elrSello = elrSello;
        elemento.elrSerial = elrSerial;
        elemento.elrUtilizaTrans = elrUtilizaTrans;
        elemento.tipoElemenIlegalidadVo = tipoElemenIlegalidadVo != null ? (TipoElemenIlegalidadVO) tipoElemenIlegalidadVo.clone() : null;
        return elemento;
    }

    public void setElrActivo(String elrActivo) {
        this.elrActivo = elrActivo;
    }

    public String getElrActivo() {
        return elrActivo;
    }

    public void setElrAvaluo(BigDecimal elrAvaluo) {
        this.elrAvaluo = elrAvaluo;
    }

    public BigDecimal getElrAvaluo() {
        return elrAvaluo;
    }

    public void setElrCodigo(Long elrCodigo) {
        this.elrCodigo = elrCodigo;
    }

    public Long getElrCodigo() {
        return elrCodigo;
    }

    public void setElrMarca(String elrMarca) {
        this.elrMarca = elrMarca;
    }

    public String getElrMarca() {
        return elrMarca;
    }

    public void setElrModelo(String elrModelo) {
        this.elrModelo = elrModelo;
    }

    public String getElrModelo() {
        return elrModelo;
    }

    public void setElrNumElementos(Integer elrNumElementos) {
        this.elrNumElementos = elrNumElementos;
    }

    public Integer getElrNumElementos() {
        return elrNumElementos;
    }

    public void setElrSello(Integer elrSello) {
        this.elrSello = elrSello;
    }

    public Integer getElrSello() {
        return elrSello;
    }

    public void setElrSerial(String elrSerial) {
        this.elrSerial = elrSerial;
    }

    public String getElrSerial() {
        return elrSerial;
    }

    public void setElrUtilizaTrans(String elrUtilizaTrans) {
        this.elrUtilizaTrans = elrUtilizaTrans;
    }

    public String getElrUtilizaTrans() {
        return elrUtilizaTrans;
    }

    public void setTipoElemenIlegalidadVo(TipoElemenIlegalidadVO tipoElemenIlegalidadVo) {
        this.tipoElemenIlegalidadVo = tipoElemenIlegalidadVo;
    }

    public TipoElemenIlegalidadVO getTipoElemenIlegalidadVo() {
        return tipoElemenIlegalidadVo;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }

    public void setAccionControlVo(AccionControlVO accionControlVo) {
        this.accionControlVo = accionControlVo;
    }

    public AccionControlVO getAccionControlVo() {
        return accionControlVo;
    }

    public void setTiposElemenIlegalidadVo(List<TipoElemenIlegalidadVO> tiposElemenIlegalidadVo) {
        this.tiposElemenIlegalidadVo = tiposElemenIlegalidadVo;
    }

    public List<TipoElemenIlegalidadVO> getTiposElemenIlegalidadVo() {
        return tiposElemenIlegalidadVo;
    }

    public void setElrAccion(String elrAccion) {
        this.elrAccion = elrAccion;
    }

    public String getElrAccion() {
        return elrAccion;
    }

    public void setElrDestruido(String elrDestruido) {
        this.elrDestruido = elrDestruido;
    }

    public String getElrDestruido() {
        return elrDestruido;
    }

    public void setAccionDevolucion(boolean accionDevolucion) {
        this.accionDevolucion = accionDevolucion;
    }

    public boolean isAccionDevolucion() {
        return accionDevolucion;
    }

    public void setAccionDecomisoDestruccion(boolean accionDecomisoDestruccion) {
        this.accionDecomisoDestruccion = accionDecomisoDestruccion;
    }

    public boolean isAccionDecomisoDestruccion() {
        return accionDecomisoDestruccion;
    }
}
