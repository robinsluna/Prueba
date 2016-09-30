package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComunicResolPersIle;

import java.util.Date;

public class ComunicResolPersIleVO {
    private Long corCodigo;
    private Date corFechaFinPub;
    private Date corFechaIniPub;
    private Date corFechaRad;
    private String corRadicado;
    private ResolucionProcIlegVO resolucionProcIlegVo;
    private PersonaInvestProIleVO personaInvestProIleVo;
    private UsuarioVO usuarioConecVo;
    
    public ComunicResolPersIleVO() {
        
    }
    
    public ComunicResolPersIleVO(SiiComunicResolPersIle comunicResolPersIle){
        this.corCodigo = comunicResolPersIle.getCorCodigo();
        this.corFechaFinPub = comunicResolPersIle.getCorFechaFinPub(); 
        this.corFechaIniPub = comunicResolPersIle.getCorFechaIniPub();
        this.corFechaRad = comunicResolPersIle.getCorFechaRad();
        this.corRadicado = comunicResolPersIle.getCorRadicado();
        //Padres
        if (comunicResolPersIle.getSiiPersonaInvestProIle()!= null){
            this.personaInvestProIleVo = new PersonaInvestProIleVO(comunicResolPersIle.getSiiPersonaInvestProIle());
        }
        if (comunicResolPersIle.getSiiResolucionProcIleg() != null) {
            this.resolucionProcIlegVo = new ResolucionProcIlegVO(comunicResolPersIle.getSiiResolucionProcIleg());
        }
        if (comunicResolPersIle.getSiiUsuarioConec()!= null) {
            this.usuarioConecVo = new UsuarioVO(comunicResolPersIle.getSiiUsuarioConec());
        }
    }

    public void setCorCodigo(Long corCodigo) {
        this.corCodigo = corCodigo;
    }

    public Long getCorCodigo() {
        return corCodigo;
    }

    public void setCorFechaFinPub(Date corFechaFinPub) {
        this.corFechaFinPub = corFechaFinPub;
    }

    public Date getCorFechaFinPub() {
        return corFechaFinPub;
    }

    public void setCorFechaIniPub(Date corFechaIniPub) {
        this.corFechaIniPub = corFechaIniPub;
    }

    public Date getCorFechaIniPub() {
        return corFechaIniPub;
    }

    public void setCorFechaRad(Date corFechaRad) {
        this.corFechaRad = corFechaRad;
    }

    public Date getCorFechaRad() {
        return corFechaRad;
    }

    public void setCorRadicado(String corRadicado) {
        this.corRadicado = corRadicado;
    }

    public String getCorRadicado() {
        return corRadicado;
    }

    public void setResolucionProcIlegVo(ResolucionProcIlegVO resolucionProcIlegVo) {
        this.resolucionProcIlegVo = resolucionProcIlegVo;
    }

    public ResolucionProcIlegVO getResolucionProcIlegVo() {
        return resolucionProcIlegVo;
    }

    public void setPersonaInvestProIleVo(PersonaInvestProIleVO personaInvestProIleVo) {
        this.personaInvestProIleVo = personaInvestProIleVo;
    }

    public PersonaInvestProIleVO getPersonaInvestProIleVo() {
        return personaInvestProIleVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }
}
