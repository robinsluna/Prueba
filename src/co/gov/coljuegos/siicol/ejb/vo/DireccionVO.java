package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoCalleDireccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSectorDirec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSufijo1Calle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSufijo2Calle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.util.List;

public class DireccionVO {
    
    private String dirActivo;
    private Integer dirCallePpal;
    private Long dirCodigo;
    private String dirInfoAdicional;
    private Integer dirNumero1;
    private Integer dirNumero2;
    private TipoCalleDireccionVO tipoCalleDireccionVo;
    private TipoSectorDirecVO tipoSectorDirecPpalVo;
    private TipoSufijo1CalleVO tipoSufijo1CallePpal1Vo;
    private List<DenunciaVO> denunciaDenunListVo;
    private List<DenunciaVO> denunciaListVo;
    private TipoSufijo1CalleVO tipoSufijo1CallePpal2Vo;
    private UsuarioVO usuarioConecVo;
    private List<DenunciaVO> denunciaDnadoListVo;
    private TipoSufijo2CalleVO tipoSufijo2CalleVo;
    private TipoSectorDirecVO tipoSectorDirecNum2Vo;
    private TipoSufijo1CalleVO tipoSufijo1CalleNum1Vo;

    public DireccionVO() {
        
    }
    
    public DireccionVO(SiiDireccion siiDireccion) {
        
        this.dirActivo = siiDireccion.getDirActivo();
        this.dirCallePpal = siiDireccion.getDirCallePpal();
        this.dirCodigo = siiDireccion.getDirCodigo();
        this.dirInfoAdicional = siiDireccion.getDirInfoAdicional();
        this.dirNumero1 = siiDireccion.getDirNumero1();
        this.dirNumero2 = siiDireccion.getDirNumero2();
        
        
        if(siiDireccion.getSiiTipoCalleDireccion() != null)
            this.tipoCalleDireccionVo = new TipoCalleDireccionVO(siiDireccion.getSiiTipoCalleDireccion());
        
        if(siiDireccion.getSiiTipoSectorDirecPpal() != null)
            this.tipoSectorDirecPpalVo = new TipoSectorDirecVO(siiDireccion.getSiiTipoSectorDirecPpal());
        
        if(siiDireccion.getSiiTipoSufijo1CallePpal1() != null)
            this.tipoSufijo1CallePpal1Vo = new TipoSufijo1CalleVO(siiDireccion.getSiiTipoSufijo1CallePpal1());
        
        if(siiDireccion.getSiiTipoSufijo1CallePpal2() != null)
            this.tipoSufijo1CallePpal2Vo = new TipoSufijo1CalleVO(siiDireccion.getSiiTipoSufijo1CallePpal2());
        
        if(siiDireccion.getSiiUsuarioConec() != null)
            this.usuarioConecVo = new UsuarioVO(siiDireccion.getSiiUsuarioConec());
        
        if(siiDireccion.getSiiTipoSufijo2Calle() != null)
            this.tipoSufijo2CalleVo = new TipoSufijo2CalleVO(siiDireccion.getSiiTipoSufijo2Calle());
        
        if(siiDireccion.getSiiTipoSectorDirecNum2() != null)
            this.tipoSectorDirecNum2Vo = new TipoSectorDirecVO(siiDireccion.getSiiTipoSectorDirecNum2());
        
        if(siiDireccion.getSiiTipoSufijo1CalleNum1() != null)
            this.tipoSufijo1CalleNum1Vo = new TipoSufijo1CalleVO(siiDireccion.getSiiTipoSufijo1CalleNum1());
        
    }

    public String getDirActivo() {
        return dirActivo;
    }

    public void setDirActivo(String dirActivo) {
        this.dirActivo = dirActivo;
    }

    public Integer getDirCallePpal() {
        return dirCallePpal;
    }

    public void setDirCallePpal(Integer dirCallePpal) {
        this.dirCallePpal = dirCallePpal;
    }

    public Long getDirCodigo() {
        return dirCodigo;
    }

    public void setDirCodigo(Long dirCodigo) {
        this.dirCodigo = dirCodigo;
    }

    public String getDirInfoAdicional() {
        return dirInfoAdicional;
    }

    public void setDirInfoAdicional(String dirInfoAdicional) {
        this.dirInfoAdicional = dirInfoAdicional;
    }

    public Integer getDirNumero1() {
        return dirNumero1;
    }

    public void setDirNumero1(Integer dirNumero1) {
        this.dirNumero1 = dirNumero1;
    }

    public Integer getDirNumero2() {
        return dirNumero2;
    }

    public void setDirNumero2(Integer dirNumero2) {
        this.dirNumero2 = dirNumero2;
    }

    public TipoCalleDireccionVO getTipoCalleDireccionVo() {
        return tipoCalleDireccionVo;
    }

    public void setTipoCalleDireccionVo(TipoCalleDireccionVO tipoCalleDireccionVo) {
        this.tipoCalleDireccionVo = tipoCalleDireccionVo;
    }

    public TipoSectorDirecVO getTipoSectorDirecPpalVo() {
        return tipoSectorDirecPpalVo;
    }

    public void setTipoSectorDirecPpalVo(TipoSectorDirecVO tipoSectorDirecPpalVo) {
        this.tipoSectorDirecPpalVo = tipoSectorDirecPpalVo;
    }

    public TipoSufijo1CalleVO getTipoSufijo1CallePpal1Vo() {
        return tipoSufijo1CallePpal1Vo;
    }

    public void setTipoSufijo1CallePpal1Vo(TipoSufijo1CalleVO tipoSufijo1CallePpal1Vo) {
        this.tipoSufijo1CallePpal1Vo = tipoSufijo1CallePpal1Vo;
    }

    public List<DenunciaVO> getDenunciaDenunListVo() {
        return denunciaDenunListVo;
    }

    public void setDenunciaDenunListVo(List<DenunciaVO> denunciaDenunListVo) {
        this.denunciaDenunListVo = denunciaDenunListVo;
    }

    public List<DenunciaVO> getDenunciaListVo() {
        return denunciaListVo;
    }

    public void setDenunciaListVo(List<DenunciaVO> denunciaListVo) {
        this.denunciaListVo = denunciaListVo;
    }

    public TipoSufijo1CalleVO getTipoSufijo1CallePpal2Vo() {
        return tipoSufijo1CallePpal2Vo;
    }

    public void setTipoSufijo1CallePpal2Vo(TipoSufijo1CalleVO tipoSufijo1CallePpal2Vo) {
        this.tipoSufijo1CallePpal2Vo = tipoSufijo1CallePpal2Vo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public List<DenunciaVO> getDenunciaDnadoListVo() {
        return denunciaDnadoListVo;
    }

    public void setDenunciaDnadoListVo(List<DenunciaVO> denunciaDnadoListVo) {
        this.denunciaDnadoListVo = denunciaDnadoListVo;
    }

    public TipoSufijo2CalleVO getTipoSufijo2CalleVo() {
        return tipoSufijo2CalleVo;
    }

    public void setTipoSufijo2CalleVo(TipoSufijo2CalleVO tipoSufijo2CalleVo) {
        this.tipoSufijo2CalleVo = tipoSufijo2CalleVo;
    }

    public TipoSectorDirecVO getTipoSectorDirecNum2Vo() {
        return tipoSectorDirecNum2Vo;
    }

    public void setTipoSectorDirecNum2Vo(TipoSectorDirecVO tipoSectorDirecNum2Vo) {
        this.tipoSectorDirecNum2Vo = tipoSectorDirecNum2Vo;
    }

    public TipoSufijo1CalleVO getTipoSufijo1CalleNum1Vo() {
        return tipoSufijo1CalleNum1Vo;
    }

    public void setTipoSufijo1CalleNum1Vo(TipoSufijo1CalleVO tipoSufijo1CalleNum1Vo) {
        this.tipoSufijo1CalleNum1Vo = tipoSufijo1CalleNum1Vo;
    }
}
