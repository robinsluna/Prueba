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
@Table(name = "SII_OPERADOR")
public class SiiOperador implements Serializable {
    private static final long serialVersionUID = -3591065548524471190L;
    private Long opeCodigo;
    private List<SiiContrato> siiContratoList;
    private SiiPersona siiPersona;
    private List<SiiInstrumento> siiInstrumentoList2;
    private List<SiiEstablecimiento> siiEstablecimientoList1;
    private List<SiiCuotaOperador> siiCuotaOperadorList;
    private String opePotencial;
    private String opeTipoPoblac;
    private String opeEstado;
    private Date opeFechaFinInhab;
    private Date opeFechaIniInhab;
    private List<SiiDireccionProcesalInc> siiDireccionProcesalIncList;
    private List<SiiResolucionDesisSolAut> siiResolucionDesisSolAutList;

    public SiiOperador() {
    }

    public SiiOperador(Long opeCodigo, String opeDireccion, SiiPersona siiPersona,
                       SiiUbicacion siiUbicacion2) {
        this.opeCodigo = opeCodigo;
        this.siiPersona = siiPersona;
    }

    @Id
    @Column(name = "OPE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OPERADOR_COD")
    @SequenceGenerator(name = "SEQ_OPERADOR_COD", sequenceName = "SEQ_OPERADOR_COD",allocationSize=1)
    public Long getOpeCodigo() {
        return opeCodigo;
    }

    public void setOpeCodigo(Long opeCodigo) {
        this.opeCodigo = opeCodigo;
    }

    @OneToMany(mappedBy = "siiOperador")
    public List<SiiContrato> getSiiContratoList() {
        return siiContratoList;
    }

    public void setSiiContratoList(List<SiiContrato> siiContratoList) {
        this.siiContratoList = siiContratoList;
    }

    public SiiContrato addSiiContrato(SiiContrato siiContrato) {
        getSiiContratoList().add(siiContrato);
        siiContrato.setSiiOperador(this);
        return siiContrato;
    }

    public SiiContrato removeSiiContrato(SiiContrato siiContrato) {
        getSiiContratoList().remove(siiContrato);
        siiContrato.setSiiOperador(null);
        return siiContrato;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @OneToMany(mappedBy = "siiOperador1")
    public List<SiiInstrumento> getSiiInstrumentoList2() {
        return siiInstrumentoList2;
    }

    public void setSiiInstrumentoList2(List<SiiInstrumento> siiInstrumentoList2) {
        this.siiInstrumentoList2 = siiInstrumentoList2;
    }

    public SiiInstrumento addSiiInstrumento(SiiInstrumento siiInstrumento) {
        getSiiInstrumentoList2().add(siiInstrumento);
        siiInstrumento.setSiiOperador1(this);
        return siiInstrumento;
    }

    public SiiInstrumento removeSiiInstrumento(SiiInstrumento siiInstrumento) {
        getSiiInstrumentoList2().remove(siiInstrumento);
        siiInstrumento.setSiiOperador1(null);
        return siiInstrumento;
    }

    @OneToMany(mappedBy = "siiOperador2")
    public List<SiiEstablecimiento> getSiiEstablecimientoList1() {
        return siiEstablecimientoList1;
    }

    public void setSiiEstablecimientoList1(List<SiiEstablecimiento> siiEstablecimientoList1) {
        this.siiEstablecimientoList1 = siiEstablecimientoList1;
    }

    public SiiEstablecimiento addSiiEstablecimiento(SiiEstablecimiento siiEstablecimiento) {
        getSiiEstablecimientoList1().add(siiEstablecimiento);
        siiEstablecimiento.setSiiOperador2(this);
        return siiEstablecimiento;
    }

    public SiiEstablecimiento removeSiiEstablecimiento(SiiEstablecimiento siiEstablecimiento) {
        getSiiEstablecimientoList1().remove(siiEstablecimiento);
        siiEstablecimiento.setSiiOperador2(null);
        return siiEstablecimiento;
    }

    @OneToMany(mappedBy = "siiOperador")
    public List<SiiCuotaOperador> getSiiCuotaOperadorList() {
        return siiCuotaOperadorList;
    }

    public void setSiiCuotaOperadorList(List<SiiCuotaOperador> siiCuotaOperadorList) {
        this.siiCuotaOperadorList = siiCuotaOperadorList;
    }

    public SiiCuotaOperador addSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().add(siiCuotaOperador);
        siiCuotaOperador.setSiiOperador(this);
        return siiCuotaOperador;
    }

    public SiiCuotaOperador removeSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().remove(siiCuotaOperador);
        siiCuotaOperador.setSiiOperador(null);
        return siiCuotaOperador;
    }

    @Column(name = "OPE_POTENCIAL", length = 1)
    public String getOpePotencial() {
        return opePotencial;
    }

    public void setOpePotencial(String opePotencial) {
        this.opePotencial = opePotencial;
    }

    @Column(name = "OPE_TIPO_POBLAC", length = 1)
    public String getOpeTipoPoblac() {
        return opeTipoPoblac;
    }

    public void setOpeTipoPoblac(String opeTipoPoblac) {
        this.opeTipoPoblac = opeTipoPoblac;
    }

    @Column(name = "OPE_ESTADO", nullable = false, length = 1)
    public String getOpeEstado() {
        return opeEstado;
    }

    public void setOpeEstado(String opeEstado) {
        this.opeEstado = opeEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OPE_FECHA_FIN_INHAB")
    public Date getOpeFechaFinInhab() {
        return opeFechaFinInhab;
    }

    public void setOpeFechaFinInhab(Date opeFechaFinInhab) {
        this.opeFechaFinInhab = opeFechaFinInhab;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OPE_FECHA_INI_INHAB")
    public Date getOpeFechaIniInhab() {
        return opeFechaIniInhab;
    }

    public void setOpeFechaIniInhab(Date opeFechaIniInhab) {
        this.opeFechaIniInhab = opeFechaIniInhab;
    }
    @OneToMany(mappedBy = "siiOperador")
    public List<SiiDireccionProcesalInc> getSiiDireccionProcesalIncList() {
        return siiDireccionProcesalIncList;
    }

    public void setSiiDireccionProcesalIncList(List<SiiDireccionProcesalInc> siiDireccionProcesalIncList) {
        this.siiDireccionProcesalIncList = siiDireccionProcesalIncList;
    }

    public SiiDireccionProcesalInc addSiiDireccionProcesalInc(SiiDireccionProcesalInc siiDireccionProcesalInc) {
        getSiiDireccionProcesalIncList().add(siiDireccionProcesalInc);
        siiDireccionProcesalInc.setSiiOperador(this);
        return siiDireccionProcesalInc;
    }

    public SiiDireccionProcesalInc removeSiiDireccionProcesalInc(SiiDireccionProcesalInc siiDireccionProcesalInc) {
        getSiiDireccionProcesalIncList().remove(siiDireccionProcesalInc);
        siiDireccionProcesalInc.setSiiOperador(null);
        return siiDireccionProcesalInc;
    }

    @OneToMany(mappedBy = "siiOperador")
    public List<SiiResolucionDesisSolAut> getSiiResolucionDesisSolAutList(){
        return siiResolucionDesisSolAutList;
    }

    public void setSiiResolucionDesisSolAutList(List<SiiResolucionDesisSolAut> siiResolucionDesisSolAutList){
        this.siiResolucionDesisSolAutList = siiResolucionDesisSolAutList;
    }

    public SiiResolucionDesisSolAut addSiiResolucionDesisSolAut(SiiResolucionDesisSolAut siiResolucionDesisSolAut){
        getSiiResolucionDesisSolAutList().add(siiResolucionDesisSolAut);
        siiResolucionDesisSolAut.setSiiOperador(this);
        return siiResolucionDesisSolAut;
    }

    public SiiResolucionDesisSolAut removeSiiResolucionDesisSolAut(SiiResolucionDesisSolAut siiResolucionDesisSolAut){
        getSiiResolucionDesisSolAutList().remove(siiResolucionDesisSolAut);
        siiResolucionDesisSolAut.setSiiOperador(null);
        return siiResolucionDesisSolAut;
    }
}
