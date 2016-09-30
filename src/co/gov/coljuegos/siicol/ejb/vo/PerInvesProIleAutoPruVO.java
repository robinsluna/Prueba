package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPerInvesProIleAutoPru;

import java.util.Date;


/**
 * Value Object para el manejo de Personas Investigadas del Auto que Decreta Pruebas en Procesos Sancionatorios de Ilegalidad.
 * @author Camilo Miranda
 */
public class PerInvesProIleAutoPruVO 
{
    private Long pauCodigo;
    private Date pauFechaFinPubl;
    private Date pauFechaIniPubl;
    private Date pauFechaRadic;
    private String pauRadicado;
    
    private UsuarioVO usuarioConecVo;
    private AutoDecretaPrueProIleVO autoDecretaPrueProIleVo;
    private PersonaInvestProIleVO personaInvestProIleVo;
    
    
    /**
     * Constructor.
     */
    public PerInvesProIleAutoPruVO() { }
    
    
    /**
     * Constructor.
     * @param siiPerInvesProIleAutoPru - Entity.
     */
    public PerInvesProIleAutoPruVO (SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru) 
    {
        if (siiPerInvesProIleAutoPru!=null) {
            this.pauCodigo = siiPerInvesProIleAutoPru.getPauCodigo();
            this.pauFechaFinPubl = siiPerInvesProIleAutoPru.getPauFechaFinPubl();
            this.pauFechaIniPubl = siiPerInvesProIleAutoPru.getPauFechaIniPubl();
            this.pauFechaRadic = siiPerInvesProIleAutoPru.getPauFechaRadic();
            this.pauRadicado = siiPerInvesProIleAutoPru.getPauRadicado();
            
            if (siiPerInvesProIleAutoPru.getSiiAutoDecretaPrueProIle()!=null)
                this.autoDecretaPrueProIleVo = new AutoDecretaPrueProIleVO(siiPerInvesProIleAutoPru.getSiiAutoDecretaPrueProIle());
            
            if (siiPerInvesProIleAutoPru.getSiiPersonaInvestProIle()!=null)
                this.personaInvestProIleVo = new PersonaInvestProIleVO(siiPerInvesProIleAutoPru.getSiiPersonaInvestProIle());
            
            if (siiPerInvesProIleAutoPru.getSiiUsuarioConec()!=null)
                this.usuarioConecVo = new UsuarioVO(siiPerInvesProIleAutoPru.getSiiUsuarioConec());
        }
    }


    public void setPauCodigo(Long pauCodigo) {
        this.pauCodigo = pauCodigo;
    }

    public Long getPauCodigo() {
        return pauCodigo;
    }

    public void setPauFechaFinPubl(Date pauFechaFinPubl) {
        this.pauFechaFinPubl = pauFechaFinPubl;
    }

    public Date getPauFechaFinPubl() {
        return pauFechaFinPubl;
    }

    public void setPauFechaIniPubl(Date pauFechaIniPubl) {
        this.pauFechaIniPubl = pauFechaIniPubl;
    }

    public Date getPauFechaIniPubl() {
        return pauFechaIniPubl;
    }

    public void setPauFechaRadic(Date pauFechaRadic) {
        this.pauFechaRadic = pauFechaRadic;
    }

    public Date getPauFechaRadic() {
        return pauFechaRadic;
    }

    public void setPauRadicado(String pauRadicado) {
        this.pauRadicado = pauRadicado;
    }

    public String getPauRadicado() {
        return pauRadicado;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setAutoDecretaPrueProIleVo(AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) {
        this.autoDecretaPrueProIleVo = autoDecretaPrueProIleVo;
    }

    public AutoDecretaPrueProIleVO getAutoDecretaPrueProIleVo() {
        return autoDecretaPrueProIleVo;
    }

    public void setPersonaInvestProIleVo(PersonaInvestProIleVO personaInvestProIleVo) {
        this.personaInvestProIleVo = personaInvestProIleVo;
    }

    public PersonaInvestProIleVO getPersonaInvestProIleVo() {
        return personaInvestProIleVo;
    }
}
