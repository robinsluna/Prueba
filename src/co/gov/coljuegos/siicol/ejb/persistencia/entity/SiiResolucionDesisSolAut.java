package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_RESOLUCION_DESIS_SOL_AUT")
public class SiiResolucionDesisSolAut implements Serializable{
    private static final long serialVersionUID = 693928938650363898L;
    private Long rdsCodigo;
    private Integer rdsDuracCont;
    private Integer rdsDuracProrr;
    private Date rdsFechaRadicado;
    private Date rdsFechaResFirme;
    private Date rdsFechaResoluc;
    private Date rdsFechaSol;
    private String rdsNumContrato;
    private Long rdsNumResolFirme;
    private Long rdsNumeroSol;
    private String rdsRadicado;
    private SiiUsuario siiUsuarioConect;
    private SiiTipoSolicAutoriza siiTipoSolicAutoriza;
    private SiiTipoNovedad siiTipoNovedad;
    private SiiOperador siiOperador;
    private List<SiiInventarioResolDesis> siiInventarioResolDesisList;
    private String rdsEstado;

    public SiiResolucionDesisSolAut(){
    }

    public SiiResolucionDesisSolAut(SiiOperador siiOperador, Long rdsCodigo, Integer rdsDuracCont, Integer rdsDuracProrr, Date rdsFechaRadicado, Date rdsFechaSol, String rdsNumContrato,
                                    Long rdsNumeroSol, String rdsRadicado, SiiTipoNovedad siiTipoNovedad, SiiTipoSolicAutoriza siiTipoSolicAutoriza, SiiUsuario siiUsuarioConect){
        this.siiOperador = siiOperador;
        this.rdsCodigo = rdsCodigo;
        this.rdsDuracCont = rdsDuracCont;
        this.rdsDuracProrr = rdsDuracProrr;
        this.rdsFechaRadicado = rdsFechaRadicado;
        this.rdsFechaSol = rdsFechaSol;
        this.rdsNumContrato = rdsNumContrato;
        this.rdsNumeroSol = rdsNumeroSol;
        this.rdsRadicado = rdsRadicado;
        this.siiTipoNovedad = siiTipoNovedad;
        this.siiTipoSolicAutoriza = siiTipoSolicAutoriza;
        this.siiUsuarioConect = siiUsuarioConect;
    }


    @Id
    @Column(name = "RDS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESOLUCION_DESIS_SOL_AUT")
    @SequenceGenerator(name = "SEQ_RESOLUCION_DESIS_SOL_AUT", sequenceName = "SEQ_RESOLUCION_DESIS_SOL_AUT",allocationSize=1)
    public Long getRdsCodigo(){
        return rdsCodigo;
    }

    public void setRdsCodigo(Long rdsCodigo){
        this.rdsCodigo = rdsCodigo;
    }

    @Column(name = "RDS_DURAC_CONT")
    public Integer getRdsDuracCont(){
        return rdsDuracCont;
    }

    public void setRdsDuracCont(Integer rdsDuracCont){
        this.rdsDuracCont = rdsDuracCont;
    }

    @Column(name = "RDS_DURAC_PRORR")
    public Integer getRdsDuracProrr(){
        return rdsDuracProrr;
    }

    public void setRdsDuracProrr(Integer rdsDuracProrr){
        this.rdsDuracProrr = rdsDuracProrr;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RDS_FECHA_RADICADO", nullable = false)
    public Date getRdsFechaRadicado(){
        return rdsFechaRadicado;
    }

    public void setRdsFechaRadicado(Date rdsFechaRadicado){
        this.rdsFechaRadicado = rdsFechaRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RDS_FECHA_SOL", nullable = false)
    public Date getRdsFechaSol(){
        return rdsFechaSol;
    }

    public void setRdsFechaSol(Date rdsFechaSol){
        this.rdsFechaSol = rdsFechaSol;
    }

    @Column(name = "RDS_NUM_CONTRATO", length = 5)
    public String getRdsNumContrato(){
        return rdsNumContrato;
    }

    public void setRdsNumContrato(String rdsNumContrato){
        this.rdsNumContrato = rdsNumContrato;
    }

    @Column(name = "RDS_NUMERO_SOL", nullable = false)
    public Long getRdsNumeroSol(){
        return rdsNumeroSol;
    }

    public void setRdsNumeroSol(Long rdsNumeroSol){
        this.rdsNumeroSol = rdsNumeroSol;
    }

    @Column(name = "RDS_RADICADO", nullable = false, length = 60)
    public String getRdsRadicado(){
        return rdsRadicado;
    }

    public void setRdsRadicado(String rdsRadicado){
        this.rdsRadicado = rdsRadicado;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConect(){
        return siiUsuarioConect;
    }

    public void setSiiUsuarioConect(SiiUsuario siiUsuarioConect){
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @ManyToOne
    @JoinColumn(name = "TSA_CODIGO")
    public SiiTipoSolicAutoriza getSiiTipoSolicAutoriza(){
        return siiTipoSolicAutoriza;
    }

    public void setSiiTipoSolicAutoriza(SiiTipoSolicAutoriza siiTipoSolicAutoriza){
        this.siiTipoSolicAutoriza = siiTipoSolicAutoriza;
    }

/*    @ManyToOne
    @JoinColumn(name = "TNO_CODIGO")
    public SiiTipoNovedad getSiiTipoNovedad(){
        return siiTipoNovedad;
    }*/

    public void setSiiTipoNovedad(SiiTipoNovedad siiTipoNovedad){
        this.siiTipoNovedad = siiTipoNovedad;
    }

    @ManyToOne
    @JoinColumn(name = "OPE_CODIGO")
    public SiiOperador getSiiOperador(){
        return siiOperador;
    }

    public void setSiiOperador(SiiOperador siiOperador){
        this.siiOperador = siiOperador;
    }

    @OneToMany(mappedBy = "siiResolucionDesisSolAut")
    public List<SiiInventarioResolDesis> getSiiInventarioResolDesisList(){
        return siiInventarioResolDesisList;
    }

    public void setSiiInventarioResolDesisList(List<SiiInventarioResolDesis> siiInventarioResolDesisList){
        this.siiInventarioResolDesisList = siiInventarioResolDesisList;
    }

    public SiiInventarioResolDesis addSiiInventarioResolDesis(SiiInventarioResolDesis siiInventarioResolDesis){
        getSiiInventarioResolDesisList().add(siiInventarioResolDesis);
        siiInventarioResolDesis.setSiiResolucionDesisSolAut(this);
        return siiInventarioResolDesis;
    }

    public SiiInventarioResolDesis removeSiiInventarioResolDesis(SiiInventarioResolDesis siiInventarioResolDesis){
        getSiiInventarioResolDesisList().remove(siiInventarioResolDesis);
        siiInventarioResolDesis.setSiiResolucionDesisSolAut(null);
        return siiInventarioResolDesis;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RDS_FECHA_RES_FIRME")
    public Date getRdsFechaResFirme() {
        return rdsFechaResFirme;
    }

    public void setRdsFechaResFirme(Date rdsFechaResFirme) {
        this.rdsFechaResFirme = rdsFechaResFirme;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RDS_FECHA_RESOLUC")
    public Date getRdsFechaResoluc() {
        return rdsFechaResoluc;
    }

    public void setRdsFechaResoluc(Date rdsFechaResoluc) {
        this.rdsFechaResoluc = rdsFechaResoluc;
    }
    
    @Column(name = "RDS_NUM_RESOL_FIRME")
    public Long getRdsNumResolFirme() {
        return rdsNumResolFirme;
    }

    public void setRdsNumResolFirme(Long rdsNumResolFirme) {
        this.rdsNumResolFirme = rdsNumResolFirme;
    }

    @Column(name = "RDS_ESTADO", length = 1)
    public String getRdsEstado() {
        return rdsEstado;
    }
    
    public void setRdsEstado(String rdsEstado) {
        this.rdsEstado = rdsEstado;
    }
}
