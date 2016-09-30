package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaInvProIleAuto;

import java.util.Date;


/**
 * Value Object para la Persona Investigada del Auto de Formulaci&oacute;n de Cargos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
public class PersonaInvProIleAutoVO 
{
    private Long piaCodigo;
    private Date piaComFechaFinP;
    private Date piaComFechaIniP;
    private Date piaComFechaRad;
    private String piaComRadicado;
    private Date piaNumFechaRad;
    private String piaNumRadicado;
    
    private AutoFormCargProIleVO autoFormCargProIleVo;
    private PersonaInvestProIleVO personaInvestProIleVo;
    private UsuarioVO usuarioConecVo;
    
    
    /**
     * Constructor.
     */
    public PersonaInvProIleAutoVO() { }
    
    
    /**
     * Constructor.
     * @param siiPersonaInvProIleAuto - Entity.
     */
    public PersonaInvProIleAutoVO(SiiPersonaInvProIleAuto siiPersonaInvProIleAuto) 
    {
        if (siiPersonaInvProIleAuto!=null) {
            this.piaCodigo = siiPersonaInvProIleAuto.getPiaCodigo();
            this.piaComFechaFinP = siiPersonaInvProIleAuto.getPiaComFechaFinP();
            this.piaComFechaIniP = siiPersonaInvProIleAuto.getPiaComFechaIniP();
            this.piaComFechaRad = siiPersonaInvProIleAuto.getPiaComFechaRad();
            this.piaComRadicado = siiPersonaInvProIleAuto.getPiaComRadicado();
            this.piaNumFechaRad = siiPersonaInvProIleAuto.getPiaNumFechaRad();
            this.piaNumRadicado = siiPersonaInvProIleAuto.getPiaNumRadicado();
            
            if (siiPersonaInvProIleAuto.getSiiAutoFormCargProIle()!=null)
                this.autoFormCargProIleVo = new AutoFormCargProIleVO(siiPersonaInvProIleAuto.getSiiAutoFormCargProIle());
            
            if (siiPersonaInvProIleAuto.getSiiPersonaInvestProIle()!=null)
                this.personaInvestProIleVo = new PersonaInvestProIleVO(siiPersonaInvProIleAuto.getSiiPersonaInvestProIle());
            
            if (siiPersonaInvProIleAuto.getSiiUsuarioConec()!=null)
                this.usuarioConecVo = new UsuarioVO(siiPersonaInvProIleAuto.getSiiUsuarioConec());
        }
    }
    
    
    
    public void setPiaCodigo(Long piaCodigo) {
        this.piaCodigo = piaCodigo;
    }

    public Long getPiaCodigo() {
        return piaCodigo;
    }

    public void setPiaComFechaFinP(Date piaComFechaFinP) {
        this.piaComFechaFinP = piaComFechaFinP;
    }

    public Date getPiaComFechaFinP() {
        return piaComFechaFinP;
    }

    public void setPiaComFechaIniP(Date piaComFechaIniP) {
        this.piaComFechaIniP = piaComFechaIniP;
    }

    public Date getPiaComFechaIniP() {
        return piaComFechaIniP;
    }

    public void setPiaComFechaRad(Date piaComFechaRad) {
        this.piaComFechaRad = piaComFechaRad;
    }

    public Date getPiaComFechaRad() {
        return piaComFechaRad;
    }

    public void setPiaComRadicado(String piaComRadicado) {
        this.piaComRadicado = piaComRadicado;
    }

    public String getPiaComRadicado() {
        return piaComRadicado;
    }

    public void setPiaNumFechaRad(Date piaNumFechaRad) {
        this.piaNumFechaRad = piaNumFechaRad;
    }

    public Date getPiaNumFechaRad() {
        return piaNumFechaRad;
    }

    public void setPiaNumRadicado(String piaNumRadicado) {
        this.piaNumRadicado = piaNumRadicado;
    }

    public String getPiaNumRadicado() {
        return piaNumRadicado;
    }

    public void setAutoFormCargProIleVo(AutoFormCargProIleVO autoFormCargProIleVo) {
        this.autoFormCargProIleVo = autoFormCargProIleVo;
    }

    public AutoFormCargProIleVO getAutoFormCargProIleVo() {
        return autoFormCargProIleVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setPersonaInvestProIleVo(PersonaInvestProIleVO personaInvestProIleVo) {
        this.personaInvestProIleVo = personaInvestProIleVo;
    }

    public PersonaInvestProIleVO getPersonaInvestProIleVo() {
        return personaInvestProIleVo;
    }
}
