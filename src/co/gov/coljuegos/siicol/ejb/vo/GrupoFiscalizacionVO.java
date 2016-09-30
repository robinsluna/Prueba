package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFiscalizadorSustanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoFiscalizacion;

import java.util.Date;
import java.util.List;

public class GrupoFiscalizacionVO {
    
    private Long gfiCodigo;
    private String gfiNumero;
    private Date gfiFechaIni;
    private Date gfiFechaFin;
    private FiscalizadorSustancVO fiscalizadorSustancVoPrincipal;
    private FiscalizadorSustancVO fiscalizadorSustancVoAcompa�ante;
    
    //datos para grilla
    private List<UsuarioVO>  listUsuarioVo;
    //private List<SiiAutoComisorio> siiAutoComisorioList;    
    
    public GrupoFiscalizacionVO(SiiGrupoFiscalizacion siiGrupoFiscalizacion) {
       this.gfiCodigo = siiGrupoFiscalizacion.getGfiCodigo();
       this.gfiNumero = siiGrupoFiscalizacion.getGfiNumero();
       this.gfiFechaIni = siiGrupoFiscalizacion.getGfiFechaIni();
       this.gfiFechaFin = siiGrupoFiscalizacion.getGfiFechaFin();
       if(siiGrupoFiscalizacion.getSiiFiscalizadorSustancPrincipal() != null)
          this.fiscalizadorSustancVoPrincipal = new FiscalizadorSustancVO (siiGrupoFiscalizacion.getSiiFiscalizadorSustancPrincipal());

        if(siiGrupoFiscalizacion.getSiiFiscalizadorSustancAcomp() != null)
           this.fiscalizadorSustancVoAcompa�ante = new FiscalizadorSustancVO (siiGrupoFiscalizacion.getSiiFiscalizadorSustancAcomp());
       
    }
    
    public GrupoFiscalizacionVO() {
       
    }


    public void setGfiCodigo(Long gfiCodigo) {
        this.gfiCodigo = gfiCodigo;
    }

    public Long getGfiCodigo() {
        return gfiCodigo;
    }

    public void setGfiNumero(String gfiNumero) {
        this.gfiNumero = gfiNumero;
    }

    public String getGfiNumero() {
        return gfiNumero;
    }

    public void setGfiFechaIni(Date gfiFechaIni) {
        this.gfiFechaIni = gfiFechaIni;
    }

    public Date getGfiFechaIni() {
        return gfiFechaIni;
    }

    public void setGfiFechaFin(Date gfiFechaFin) {
        this.gfiFechaFin = gfiFechaFin;
    }

    public Date getGfiFechaFin() {
        return gfiFechaFin;
    }


    public void setFiscalizadorSustancVoPrincipal(FiscalizadorSustancVO fiscalizadorSustancVoPrincipal) {
        this.fiscalizadorSustancVoPrincipal = fiscalizadorSustancVoPrincipal;
    }

    public FiscalizadorSustancVO getFiscalizadorSustancVoPrincipal() {
        return fiscalizadorSustancVoPrincipal;
    }

    public void setFiscalizadorSustancVoAcompa�ante(FiscalizadorSustancVO fiscalizadorSustancVoAcompa�ante) {
        this.fiscalizadorSustancVoAcompa�ante = fiscalizadorSustancVoAcompa�ante;
    }

    public FiscalizadorSustancVO getFiscalizadorSustancVoAcompa�ante() {
        return fiscalizadorSustancVoAcompa�ante;
    }


    public void setListUsuarioVo(List<UsuarioVO> listUsuarioVo) {
        this.listUsuarioVo = listUsuarioVo;
    }

    public List<UsuarioVO> getListUsuarioVo() {
        return listUsuarioVo;
    }

    
}
