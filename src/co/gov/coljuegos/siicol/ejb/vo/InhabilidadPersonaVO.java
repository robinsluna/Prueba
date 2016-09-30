package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInhabilidadPersona;

import java.util.Date;


/**
 * Value Object para el manejo de Inhabilidad de la Persona.
 * @author Camilo Miranda
 */
public class InhabilidadPersonaVO 
{
    private String ipeActivo;
    private Long ipeCodigo;
    private Date ipeFechaFin;
    private Date ipeFechaIni;
    
    private UsuarioVO usuarioConecVo;
    private PersonaVO personaVo;
    private IncumplimientoContrVO incumplimientoContrVo;
    private ProcesoSancionatorioVO procesoSancionatorioVo;
    private ProcesoSancIlegalidadVO procesoSancIlegalidadVo;
    
    
    
    /**
     * Constructor.
     */
    public InhabilidadPersonaVO() { }
    
    
    /**
     * Constructor.
     */
    public InhabilidadPersonaVO (SiiInhabilidadPersona siiInhabilidadPersona) 
    {
        if (siiInhabilidadPersona!=null) {
            this.ipeActivo = siiInhabilidadPersona.getIpeActivo();
            this.ipeCodigo = siiInhabilidadPersona.getIpeCodigo();
            this.ipeFechaFin = siiInhabilidadPersona.getIpeFechaFin();
            this.ipeFechaIni = siiInhabilidadPersona.getIpeFechaIni();
            
            if (siiInhabilidadPersona.getSiiUsuarioConec()!=null)
                this.usuarioConecVo = new UsuarioVO(siiInhabilidadPersona.getSiiUsuarioConec());
            
            if (siiInhabilidadPersona.getSiiIncumplimientoContr()!=null)
                this.incumplimientoContrVo = new IncumplimientoContrVO(siiInhabilidadPersona.getSiiIncumplimientoContr());
            
            if (siiInhabilidadPersona.getSiiProcesoSancionatorio()!=null)
                this.procesoSancionatorioVo = new ProcesoSancionatorioVO(siiInhabilidadPersona.getSiiProcesoSancionatorio());
            
            if (siiInhabilidadPersona.getSiiPersona()!=null)
                this.personaVo = new PersonaVO(siiInhabilidadPersona.getSiiPersona());
            
            if (siiInhabilidadPersona.getSiiProcesoSancIlegalidad()!=null)
                this.procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO(siiInhabilidadPersona.getSiiProcesoSancIlegalidad());
        }
    }


    public void setIpeActivo(String ipeActivo) {
        this.ipeActivo = ipeActivo;
    }

    public String getIpeActivo() {
        return ipeActivo;
    }

    public void setIpeCodigo(Long ipeCodigo) {
        this.ipeCodigo = ipeCodigo;
    }

    public Long getIpeCodigo() {
        return ipeCodigo;
    }

    public void setIpeFechaFin(Date ipeFechaFin) {
        this.ipeFechaFin = ipeFechaFin;
    }

    public Date getIpeFechaFin() {
        return ipeFechaFin;
    }

    public void setIpeFechaIni(Date ipeFechaIni) {
        this.ipeFechaIni = ipeFechaIni;
    }

    public Date getIpeFechaIni() {
        return ipeFechaIni;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setIncumplimientoContrVo(IncumplimientoContrVO incumplimientoContrVo) {
        this.incumplimientoContrVo = incumplimientoContrVo;
    }

    public IncumplimientoContrVO getIncumplimientoContrVo() {
        return incumplimientoContrVo;
    }

    public void setProcesoSancionatorioVo(ProcesoSancionatorioVO procesoSancionatorioVo) {
        this.procesoSancionatorioVo = procesoSancionatorioVo;
    }

    public ProcesoSancionatorioVO getProcesoSancionatorioVo() {
        return procesoSancionatorioVo;
    }

    public void setProcesoSancIlegalidadVo(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) {
        this.procesoSancIlegalidadVo = procesoSancIlegalidadVo;
    }

    public ProcesoSancIlegalidadVO getProcesoSancIlegalidadVo() {
        return procesoSancIlegalidadVo;
    }
}
