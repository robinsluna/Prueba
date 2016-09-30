package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuncion;

import java.util.ArrayList;
import java.util.List;


public class FuncionVO 
{
    private String funActivo;
    private Long funCodigo;
    private String funDescripcion;
    private String funNombre;
    private List<FirmasRequeridasVO> firmasRequeridasList;
    private List<UsuarioVO> usuarioList;
    
    
    public FuncionVO(SiiFuncion siiFuncion){
        this.funActivo = siiFuncion.getFunActivo();
        this.funCodigo = siiFuncion.getFunCodigo();
        this.funDescripcion = siiFuncion.getFunDescripcion();
        this.funNombre = siiFuncion.getFunNombre();
    }
    
    public FuncionVO() {
    }

    public void setFunActivo(String funActivo) {
        this.funActivo = funActivo;
    }

    public String getFunActivo() {
        return funActivo;
    }

    public void setFunCodigo(Long funCodigo) {
        this.funCodigo = funCodigo;
    }

    public Long getFunCodigo() {
        return funCodigo;
    }

    public void setFunDescripcion(String funDescripcion) {
        this.funDescripcion = funDescripcion;
    }

    public String getFunDescripcion() {
        return funDescripcion;
    }

    public void setFunNombre(String funNombre) {
        this.funNombre = funNombre;
    }

    public String getFunNombre() {
        return funNombre;
    }


    public void setFirmasRequeridasList(List<FirmasRequeridasVO> firmasRequeridasList) {
        this.firmasRequeridasList = firmasRequeridasList;
    }

    public List<FirmasRequeridasVO> getFirmasRequeridasList() {
        return firmasRequeridasList;
    }

    public void setUsuarioList(List<UsuarioVO> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<UsuarioVO> getUsuarioList() {
        return usuarioList;
    }
    
    
    /**
     * Adiciona un objeto FirmasRequeridasVO a la lista.
     * @param firmasRequeridasVO
     * @return adicionado?
     */
    public boolean addFirmasRequeridasVO (FirmasRequeridasVO firmasRequeridasVO) 
    {
        boolean exitoso = false;
        
        if (firmasRequeridasList==null)
            firmasRequeridasList = new ArrayList<FirmasRequeridasVO>();
        
        exitoso = getFirmasRequeridasList().add(firmasRequeridasVO);
        if (exitoso)
            firmasRequeridasVO.setFuncionVO(this);
        return (exitoso);
    }
    
    
    /**
     * Elimina un objeto FirmasRequeridasVO de la lista.
     * @param firmasRequeridasVO
     * @return eliminado?
     */
    public boolean removeFirmasRequeridasVO (FirmasRequeridasVO firmasRequeridasVO) 
    {
        boolean exitoso = false;
        exitoso = getFirmasRequeridasList().remove(firmasRequeridasVO);
        if (exitoso)
            firmasRequeridasVO.setFuncionVO(null);
        return (exitoso);
    }
    
    
    /**
     * Adiciona un objeto UsuarioVO a la lista.
     * @param usuarioVO
     * @return adicionado?
     */
    public boolean addUsuarioVO (UsuarioVO usuarioVO) 
    {
        boolean exitoso = false;
        
        if (usuarioList==null)
            usuarioList = new ArrayList<UsuarioVO>();
        
        exitoso = getUsuarioList().add(usuarioVO);
        if (exitoso)
            usuarioVO.setFuncionVo(this);
        return (exitoso);
    }
    
    
    /**
     * Elimina un objeto UsuarioVO de la lista.
     * @param usuarioVO
     * @return eliminado?
     */
    public boolean removeUsuarioVO (UsuarioVO usuarioVO) 
    {
        boolean exitoso = false;
        exitoso = getUsuarioList().remove(usuarioVO);
        if (exitoso)
            usuarioVO.setFuncionVo(null);
        return (exitoso);
    }
    
}
