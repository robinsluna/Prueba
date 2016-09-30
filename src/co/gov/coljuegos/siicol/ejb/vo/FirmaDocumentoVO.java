package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmaDocumento;


import java.util.Date;

public class FirmaDocumentoVO {
    private Long fdoCodigo;
    private Date fdoFechaFirma;
    private UsuarioVO usuarioVo;
    private FirmasRequeridasVO firmasRequeridasVo;
    private Long fdoIdDocumento;
    
    
    /**
     * Constructor.
     */
    public FirmaDocumentoVO () { }
    
    
    /**
     * Constructor.
     * @param firmaDocumento - Entity
     */
    public FirmaDocumentoVO(SiiFirmaDocumento firmaDocumento) {
        this.fdoCodigo = firmaDocumento.getFdoCodigo();
        this.fdoFechaFirma = firmaDocumento.getTdoFechaFirma();
        this.fdoIdDocumento = firmaDocumento.getFdoIdDocumento();
        
        //Padres:
        if (firmaDocumento.getSiiFirmasRequeridas()!=null)
            this.firmasRequeridasVo = new FirmasRequeridasVO(firmaDocumento.getSiiFirmasRequeridas());
        
        if (firmaDocumento.getSiiUsuario()!=null)
            this.usuarioVo = new UsuarioVO(firmaDocumento.getSiiUsuario());
    }

    public void setFdoIdDocumento(Long fdoIdDocumento) {
        this.fdoIdDocumento = fdoIdDocumento;
    }

    public Long getFdoIdDocumento() {
        return fdoIdDocumento;
    }

    public void setFdoCodigo(Long fdoCodigo) {
        this.fdoCodigo = fdoCodigo;
    }

    public Long getFdoCodigo() {
        return fdoCodigo;
    }

    public void setFdoFechaFirma(Date fdoFechaFirma) {
        this.fdoFechaFirma = fdoFechaFirma;
    }

    public Date getFdoFechaFirma() {
        return fdoFechaFirma;
    }

    public void setUsuarioVo(UsuarioVO usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioVO getUsuarioVo() {
        return usuarioVo;
    }

    public void setFirmasRequeridasVo(FirmasRequeridasVO firmasRequeridasVo) {
        this.firmasRequeridasVo = firmasRequeridasVo;
    }

    public FirmasRequeridasVO getFirmasRequeridasVo() {
        return firmasRequeridasVo;
    }
    
    
    /**
     * Obtiene el nombre de la Funci&oacute;n asociada a la FirmaDocumentoVO.
     * @return firmasRequeridasVo.funcionVO.funNombre
     */
    public String getNombreFuncion () 
    {
        return ( firmasRequeridasVo!=null && firmasRequeridasVo.getFuncionVO()!=null ? firmasRequeridasVo.getFuncionVO().getFunNombre() : null );    
    }
    
    
    /**
     * Obtiene el nombre de la Persona a la cual est&aacute; asociada la FirmaDocumentoVO.
     * @return usuarioVo.personaVo.nombreCompleto
     */
    public String getNombrePersona () {
        return ( usuarioVo!=null && usuarioVo.getPersonaVo()!=null ? usuarioVo.getPersonaVo().getNombreCompleto() : null);
    }
    
}
