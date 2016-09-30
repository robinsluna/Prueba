package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoUsuario;

import java.util.List;

public class EstadoUsuarioVO {
    private static final long serialVersionUID = 8948443728358353742L;
    private Long eusCodigo;
    private String eusDescripcion;
    private String eusNombre;
    private List<UsuarioVO> usuarioVoList;
    
    public EstadoUsuarioVO (){
    }
    
    public EstadoUsuarioVO (SiiEstadoUsuario siiEstadoUsuario){
        this.eusCodigo = siiEstadoUsuario.getEusCodigo();
        this.eusDescripcion = siiEstadoUsuario.getEusDescripcion();
        this.eusNombre = siiEstadoUsuario.getEusNombre();
    }

    public void setEusCodigo(Long eusCodigo) {
        this.eusCodigo = eusCodigo;
    }

    public Long getEusCodigo() {
        return eusCodigo;
    }

    public void setEusDescripcion(String eusDescripcion) {
        this.eusDescripcion = eusDescripcion;
    }

    public String getEusDescripcion() {
        return eusDescripcion;
    }

    public void setEusNombre(String eusNombre) {
        this.eusNombre = eusNombre;
    }

    public String getEusNombre() {
        return eusNombre;
    }

    public void setUsuarioVoList(List<UsuarioVO> usuarioVoList) {
        this.usuarioVoList = usuarioVoList;
    }

    public List<UsuarioVO> getUsuarioVoList() {
        return usuarioVoList;
    }

}
