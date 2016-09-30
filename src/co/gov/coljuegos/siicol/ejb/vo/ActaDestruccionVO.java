/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-10-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaDestruccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Value object que gestiona las actas de destrucción.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public class ActaDestruccionVO {

    private Long adeCodigo;
    private String adeEstado;
    private Date adeFecha;
    private Date adeFechaFin;
    private Date adeFechaIni;
    private String adeLugar;
    private Integer adeNumero;

    private EmpresaDestruyeVO empresaDestruyeVo;
    private MotivoNoDestruccionVO motivoNoDestruccionVo;
    private UbicacionVO ubicacionMunicVo;
    private UsuarioVO usuarioConectVo;

    private List<ResolucionDecomDestVO> resolucionDecomDestListVo;
    private List<ResolucionDecomDestVO> eliminarResolucionSeleccionadaVo; 

    /**
     * Constructor.
     */

    public ActaDestruccionVO() {
        super();
    }

    /**
     * Constructor.
     * @param siiActaDestruccion
     */

    public ActaDestruccionVO(SiiActaDestruccion siiActaDestruccion) {
        this.adeCodigo = siiActaDestruccion.getAdeCodigo();
        this.adeEstado = siiActaDestruccion.getAdeEstado();
        this.adeFecha = siiActaDestruccion.getAdeFecha();
        this.adeFechaFin = siiActaDestruccion.getAdeFechaFin();
        this.adeFechaIni = siiActaDestruccion.getAdeFechaIni();
        this.adeLugar = siiActaDestruccion.getAdeLugar();
        this.adeNumero = siiActaDestruccion.getAdeNumero();

        if (siiActaDestruccion.getSiiEmpresaDestruye() != null) {
            this.empresaDestruyeVo = new EmpresaDestruyeVO(siiActaDestruccion.getSiiEmpresaDestruye());
        }

        if (siiActaDestruccion.getSiiMotivoNoDestruccion() != null) {
            this.motivoNoDestruccionVo = new MotivoNoDestruccionVO(siiActaDestruccion.getSiiMotivoNoDestruccion());
        }

        if (siiActaDestruccion.getSiiUbicacionMunic() != null) {
            this.ubicacionMunicVo = new UbicacionVO(siiActaDestruccion.getSiiUbicacionMunic());
        }

        if (siiActaDestruccion.getSiiUsuarioConect() != null) {
            this.usuarioConectVo = new UsuarioVO(siiActaDestruccion.getSiiUsuarioConect());
        }
    }

    /**
     * Agregar un nuevo registro de resolucion de decomiso y destrucción.
     * @param resolucionDecomDestVo
     * @return exitoso - boolean
     */

    public boolean addResolucionDecomDestVo(ResolucionDecomDestVO resolucionDecomDestVo) {
        boolean exitoso = false;

        if (this.resolucionDecomDestListVo == null)
            resolucionDecomDestListVo = new ArrayList<ResolucionDecomDestVO>();

        exitoso = resolucionDecomDestListVo.add(resolucionDecomDestVo);

        if (exitoso)
            resolucionDecomDestVo.setActaDestruccionVo(this);

        return (exitoso);
    }


    /**
     * Remover un registro de resolucion de decomiso y destrucción.
     * @param resolucionDecomDestVo
     * @return exitoso - boolean
     */
    
    public boolean removeResolucionDecomDestVo(ResolucionDecomDestVO resolucionDecomDestVo) {
        boolean exitoso = false;

        if (this.resolucionDecomDestListVo != null) {
            exitoso = resolucionDecomDestListVo.remove(resolucionDecomDestVo);

            if (exitoso)
                resolucionDecomDestVo.setActaDestruccionVo(null);
        }

        return (exitoso);
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ActaDestruccionVO)) {
            return false;
        }
        final ActaDestruccionVO other = (ActaDestruccionVO) object;
        if (!(adeCodigo == null ? other.adeCodigo == null : adeCodigo.equals(other.adeCodigo))) {
            return false;
        }
        if (!(adeEstado == null ? other.adeEstado == null : adeEstado.equals(other.adeEstado))) {
            return false;
        }
        if (!(adeFecha == null ? other.adeFecha == null : adeFecha.equals(other.adeFecha))) {
            return false;
        }
        if (!(adeFechaFin == null ? other.adeFechaFin == null : adeFechaFin.equals(other.adeFechaFin))) {
            return false;
        }
        if (!(adeFechaIni == null ? other.adeFechaIni == null : adeFechaIni.equals(other.adeFechaIni))) {
            return false;
        }
        if (!(adeLugar == null ? other.adeLugar == null : adeLugar.equals(other.adeLugar))) {
            return false;
        }
        if (!(adeNumero == null ? other.adeNumero == null : adeNumero.equals(other.adeNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((adeCodigo == null) ? 0 : adeCodigo.hashCode());
        result = PRIME * result + ((adeEstado == null) ? 0 : adeEstado.hashCode());
        result = PRIME * result + ((adeFecha == null) ? 0 : adeFecha.hashCode());
        result = PRIME * result + ((adeFechaFin == null) ? 0 : adeFechaFin.hashCode());
        result = PRIME * result + ((adeFechaIni == null) ? 0 : adeFechaIni.hashCode());
        result = PRIME * result + ((adeLugar == null) ? 0 : adeLugar.hashCode());
        result = PRIME * result + ((adeNumero == null) ? 0 : adeNumero.hashCode());
        return result;
    }

    public void setAdeCodigo(Long adeCodigo) {
        this.adeCodigo = adeCodigo;
    }

    public Long getAdeCodigo() {
        return adeCodigo;
    }

    public void setAdeEstado(String adeEstado) {
        this.adeEstado = adeEstado;
    }

    public String getAdeEstado() {
        return adeEstado;
    }

    public void setAdeFecha(Date adeFecha) {
        this.adeFecha = adeFecha;
    }

    public Date getAdeFecha() {
        return adeFecha;
    }

    public void setAdeFechaFin(Date adeFechaFin) {
        this.adeFechaFin = adeFechaFin;
    }

    public Date getAdeFechaFin() {
        return adeFechaFin;
    }

    public void setAdeFechaIni(Date adeFechaIni) {
        this.adeFechaIni = adeFechaIni;
    }

    public Date getAdeFechaIni() {
        return adeFechaIni;
    }

    public void setAdeLugar(String adeLugar) {
        this.adeLugar = adeLugar;
    }

    public String getAdeLugar() {
        return adeLugar;
    }

    public void setAdeNumero(Integer adeNumero) {
        this.adeNumero = adeNumero;
    }

    public Integer getAdeNumero() {
        return adeNumero;
    }

    public void setEmpresaDestruyeVo(EmpresaDestruyeVO empresaDestruyeVo) {
        this.empresaDestruyeVo = empresaDestruyeVo;
    }

    public EmpresaDestruyeVO getEmpresaDestruyeVo() {
        return empresaDestruyeVo;
    }

    public void setMotivoNoDestruccionVo(MotivoNoDestruccionVO motivoNoDestruccionVo) {
        this.motivoNoDestruccionVo = motivoNoDestruccionVo;
    }

    public MotivoNoDestruccionVO getMotivoNoDestruccionVo() {
        return motivoNoDestruccionVo;
    }

    public void setUbicacionMunicVo(UbicacionVO ubicacionMunicVo) {
        this.ubicacionMunicVo = ubicacionMunicVo;
    }

    public UbicacionVO getUbicacionMunicVo() {
        return ubicacionMunicVo;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }

    public void setResolucionDecomDestListVo(List<ResolucionDecomDestVO> resolucionDecomDestListVo) {
        this.resolucionDecomDestListVo = resolucionDecomDestListVo;
    }

    public List<ResolucionDecomDestVO> getResolucionDecomDestListVo() {
        return resolucionDecomDestListVo;
    }


    public void setEliminarResolucionSeleccionadaVo(List<ResolucionDecomDestVO> eliminarResolucionSeleccionadaVo){
        this.eliminarResolucionSeleccionadaVo = eliminarResolucionSeleccionadaVo;
    }

    public List<ResolucionDecomDestVO> getEliminarResolucionSeleccionadaVo(){
        return eliminarResolucionSeleccionadaVo;
    }


}
