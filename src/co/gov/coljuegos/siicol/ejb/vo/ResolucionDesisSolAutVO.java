package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumResolucionDesisSolAut;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionDesisSolAut;

import java.util.Date;
import java.util.List;

public class ResolucionDesisSolAutVO {
    private Long rdsCodigo;
    private Integer rdsDuracCont;
    private Integer rdsDuracProrr;
    private Date rdsFechaRadicado;
    private Date rdsFechaSol;
    private String rdsNumContrato;
    private Long rdsNumeroSol;
    private String rdsRadicado;
    private OperadorVO operadorVo; 
    private UsuarioVO usuarioConectVo;
    private TipoSolicAutorizaVO tipoSolicAutorizaVo;
    private TipoNovedadVO tipoNovedadVo;
    private TipoApuestaVO tipoApuestaVo;
    private PersonaVO personaVo;
    private PersonaVO personaRepVo;
    private List<InventarioResolDesisVO> listInvResDesVo;
    private String irdActivo;
    private String rdsEstado;
    private Date rdsFechaResFirme;
    private Date rdsFechaResoluc; 
    private Long rdsNumResolFirme;

    public ResolucionDesisSolAutVO() {
        super();
    }

    public ResolucionDesisSolAutVO(SiiResolucionDesisSolAut siiResolucionDesisSolAut) {
        
        if (siiResolucionDesisSolAut!=null){
            this.rdsCodigo = siiResolucionDesisSolAut.getRdsCodigo();
            this.rdsDuracCont = siiResolucionDesisSolAut.getRdsDuracCont();
            this.rdsDuracProrr = siiResolucionDesisSolAut.getRdsDuracProrr();
            this.rdsFechaRadicado = siiResolucionDesisSolAut.getRdsFechaRadicado();
            this.rdsFechaSol = siiResolucionDesisSolAut.getRdsFechaSol();
            this.rdsNumContrato = siiResolucionDesisSolAut.getRdsNumContrato();
            this.rdsNumeroSol = siiResolucionDesisSolAut.getRdsNumeroSol();
            this.rdsRadicado = siiResolucionDesisSolAut.getRdsRadicado();
            this.rdsEstado = siiResolucionDesisSolAut.getRdsEstado();
            this.rdsNumResolFirme = siiResolucionDesisSolAut.getRdsNumResolFirme();
            this.rdsFechaResFirme = siiResolucionDesisSolAut.getRdsFechaResFirme();
            this.rdsFechaResoluc = siiResolucionDesisSolAut.getRdsFechaResoluc();
            
            if (siiResolucionDesisSolAut.getSiiUsuarioConect()!=null)
            this.setUsuarioConectVo(new UsuarioVO(siiResolucionDesisSolAut.getSiiUsuarioConect()));
            
            if (siiResolucionDesisSolAut.getSiiTipoSolicAutoriza()!=null)
            this.setTipoSolicAutorizaVo(new TipoSolicAutorizaVO(siiResolucionDesisSolAut.getSiiTipoSolicAutoriza()));
            
/*            if (siiResolucionDesisSolAut.getSiiTipoNovedad()!=null)
                this.tipoNovedadVo = new TipoNovedadVO(siiResolucionDesisSolAut.getSiiTipoNovedad());*/
            
            if (siiResolucionDesisSolAut.getSiiOperador()!=null)
                this.setOperadorVo(new OperadorVO(siiResolucionDesisSolAut.getSiiOperador()));
        }
    }

    public void setRdsFechaResFirme(Date rdsFechaResFirme) {
        this.rdsFechaResFirme = rdsFechaResFirme;
    }

    public Date getRdsFechaResFirme() {
        return rdsFechaResFirme;
    }

    public void setRdsFechaResoluc(Date rdsFechaResoluc) {
        this.rdsFechaResoluc = rdsFechaResoluc;
    }

    public Date getRdsFechaResoluc() {
        return rdsFechaResoluc;
    }

    public void setRdsNumResolFirme(Long rdsNumResolFirme) {
        this.rdsNumResolFirme = rdsNumResolFirme;
    }

    public Long getRdsNumResolFirme() {
        return rdsNumResolFirme;
    }

    public void setRdsEstado(String rdsEstado) {
        this.rdsEstado = rdsEstado;
    }

    public String getRdsEstado() {
        return rdsEstado;
    }

    public void setIrdActivo(String irdActivo) {
        this.irdActivo = irdActivo;
    }

    public String getIrdActivo() {
        return irdActivo;
    }

    public void setPersonaRepVo(PersonaVO personaRepVo) {
        this.personaRepVo = personaRepVo;
    }

    public PersonaVO getPersonaRepVo() {
        return personaRepVo;
    }
    
    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }
    
    public void setRdsCodigo(Long rdsCodigo) {
        this.rdsCodigo = rdsCodigo;
    }

    public Long getRdsCodigo() {
        return rdsCodigo;
    }

    public void setRdsDuracCont(Integer rdsDuracCont) {
        this.rdsDuracCont = rdsDuracCont;
    }

    public Integer getRdsDuracCont() {
        return rdsDuracCont;
    }

    public void setRdsDuracProrr(Integer rdsDuracProrr) {
        this.rdsDuracProrr = rdsDuracProrr;
    }

    public Integer getRdsDuracProrr() {
        return rdsDuracProrr;
    }

    public void setRdsFechaRadicado(Date rdsFechaRadicado) {
        this.rdsFechaRadicado = rdsFechaRadicado;
    }

    public Date getRdsFechaRadicado() {
        return rdsFechaRadicado;
    }

    public void setRdsFechaSol(Date rdsFechaSol) {
        this.rdsFechaSol = rdsFechaSol;
    }

    public Date getRdsFechaSol() {
        return rdsFechaSol;
    }

    public void setRdsNumContrato(String rdsNumContrato) {
        this.rdsNumContrato = rdsNumContrato;
    }

    public String getRdsNumContrato() {
        return rdsNumContrato;
    }

    public void setRdsNumeroSol(Long rdsNumeroSol) {
        this.rdsNumeroSol = rdsNumeroSol;
    }

    public Long getRdsNumeroSol() {
        return rdsNumeroSol;
    }


    public void setRdsRadicado(String rdsRadicado) {
        this.rdsRadicado = rdsRadicado;
    }

    public String getRdsRadicado() {
        return rdsRadicado;
    }

    public void setOperadorVo(OperadorVO operadorVo) {
        this.operadorVo = operadorVo;
    }

    public OperadorVO getOperadorVo() {
        return operadorVo;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }

    public void setTipoSolicAutorizaVo(TipoSolicAutorizaVO tipoSolicAutorizaVo) {
        this.tipoSolicAutorizaVo = tipoSolicAutorizaVo;
    }

    public TipoSolicAutorizaVO getTipoSolicAutorizaVo() {
        return tipoSolicAutorizaVo;
    }

    public void setTipoNovedadVo(TipoNovedadVO tipoNovedadVo) {
        this.tipoNovedadVo = tipoNovedadVo;
    }

    public TipoNovedadVO getTipoNovedadVo() {
        return tipoNovedadVo;
    }
    
    public void setTipoApuestaVo(TipoApuestaVO tipoApuestaVo) {
        this.tipoApuestaVo = tipoApuestaVo;
    }

    public TipoApuestaVO getTipoApuestaVo() {
        return tipoApuestaVo;
    }

    public void setListInvResDesVo(List<InventarioResolDesisVO> listInvResDesVo) {
        this.listInvResDesVo = listInvResDesVo;
    }

    public List<InventarioResolDesisVO> getListInvResDesVo() {
        return listInvResDesVo;
    }
    
    
    public String getEstado () {
        String estado = null;
        
        if (rdsEstado!=null)
            estado = EnumResolucionDesisSolAut.getNombreById(rdsEstado);
        
        return estado;
    }
}
