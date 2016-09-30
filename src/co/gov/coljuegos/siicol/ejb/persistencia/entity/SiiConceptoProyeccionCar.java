package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CONCEPTO_PROYECCION_CAR")
public class SiiConceptoProyeccionCar implements Serializable {
    private static final long serialVersionUID = -1373746625294827198L;
    private String cpcActivo;
    private Long cpcCodigo;
    private BigDecimal cpcSaldoInt;
    private BigDecimal cpcTotalInteres;
    private BigDecimal cpcTotalPagInt;
    private BigDecimal cpcTotalPagado;
    private BigDecimal cpcValorResoluc;
    private SiiProyeccionCargaAct siiProyeccionCargaAct;
    private SiiUsuario siiUsuarioConectado;
    private SiiConcepCuotCarActAdm siiConcepCuotCarActAdm;
    private BigDecimal cpcSaldoCapital;
    private BigDecimal cpcTotalAjustes;
    
    public SiiConceptoProyeccionCar() {
    }

    public SiiConceptoProyeccionCar(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm, String cpcActivo, Long cpcCodigo, BigDecimal cpcSaldoInt, BigDecimal cpcTotalInteres, BigDecimal cpcTotalPagInt, BigDecimal cpcTotalPagado,
                                    BigDecimal cpcValorResoluc, SiiProyeccionCargaAct siiProyeccionCargaAct, SiiUsuario siiUsuarioConectado) {
        this.siiConcepCuotCarActAdm = siiConcepCuotCarActAdm;
        this.cpcActivo = cpcActivo;
        this.cpcCodigo = cpcCodigo;
        this.cpcSaldoInt = cpcSaldoInt;
        this.cpcTotalInteres = cpcTotalInteres;
        this.cpcTotalPagInt = cpcTotalPagInt;
        this.cpcTotalPagado = cpcTotalPagado;
        this.cpcValorResoluc = cpcValorResoluc;
        this.siiProyeccionCargaAct = siiProyeccionCargaAct;
        this.siiUsuarioConectado = siiUsuarioConectado;
    }


    @Column(name = "CPC_ACTIVO", nullable = false, length = 1)
    public String getCpcActivo() {
        return cpcActivo;
    }

    public void setCpcActivo(String cpcActivo) {
        this.cpcActivo = cpcActivo;
    }

    @Id
    @Column(name = "CPC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CONC_PROYECC_CAR_COD")
    @SequenceGenerator(name = "SEQ_CONC_PROYECC_CAR_COD", sequenceName = "SEQ_CONC_PROYECC_CAR_COD",allocationSize=1)
    public Long getCpcCodigo() {
        return cpcCodigo;
    }

    public void setCpcCodigo(Long cpcCodigo) {
        this.cpcCodigo = cpcCodigo;
    }

    @Column(name = "CPC_SALDO_INT", nullable = false)
    public BigDecimal getCpcSaldoInt(){
        return cpcSaldoInt;
    }
    
    public void setCpcSaldoInt(BigDecimal cpcSaldoInt){
        this.cpcSaldoInt = cpcSaldoInt;
    }
  
   
    @Column(name = "CPC_TOTAL_INTERES", nullable = false)
    public BigDecimal getCpcTotalInteres(){
        return cpcTotalInteres;
    }
    
    public void setCpcTotalInteres(BigDecimal cpcTotalInteres){
        this.cpcTotalInteres = cpcTotalInteres;
    }

    @Column(name = "CPC_TOTAL_PAG_INT", nullable = false)
    public BigDecimal getCpcTotalPagInt(){
        return cpcTotalPagInt;
    }
    
    public void setCpcTotalPagInt(BigDecimal cpcTotalPagInt){
        this.cpcTotalPagInt = cpcTotalPagInt;
    }

    @Column(name = "CPC_TOTAL_PAGADO", nullable = false)
    public BigDecimal getCpcTotalPagado() {
        return cpcTotalPagado;
    }


    public void setCpcTotalPagado(BigDecimal cpcTotalPagado) {
        this.cpcTotalPagado = cpcTotalPagado;
    }

    @Column(name = "CPC_VALOR_RESOLUC", nullable = false)
    public BigDecimal getCpcValorResoluc(){
        return cpcValorResoluc;
    }
    
    public void setCpcValorResoluc(BigDecimal cpcValorResoluc){
        this.cpcValorResoluc = cpcValorResoluc;
    }
   
   
    @ManyToOne
    @JoinColumn(name = "PYC_CODIGO")
    public SiiProyeccionCargaAct getSiiProyeccionCargaAct() {
        return siiProyeccionCargaAct;
    }

    public void setSiiProyeccionCargaAct(SiiProyeccionCargaAct siiProyeccionCargaAct) {
        this.siiProyeccionCargaAct = siiProyeccionCargaAct;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConectado() {
        return siiUsuarioConectado;
    }

    public void setSiiUsuarioConectado(SiiUsuario siiUsuarioConectado) {
        this.siiUsuarioConectado = siiUsuarioConectado;
    }

    @ManyToOne
    @JoinColumn(name = "CAM_CODIGO")
    public SiiConcepCuotCarActAdm getSiiConcepCuotCarActAdm() {
        return siiConcepCuotCarActAdm;
    }

    public void setSiiConcepCuotCarActAdm(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm) {
        this.siiConcepCuotCarActAdm = siiConcepCuotCarActAdm;
    }

    @Column(name = "CPC_SALDO_CAPITAL", nullable = false)
    public BigDecimal getCpcSaldoCapital() {
        return cpcSaldoCapital;
    }
    
    public void setCpcSaldoCapital(BigDecimal cpcSaldoCapital) {
        this.cpcSaldoCapital = cpcSaldoCapital;
    }

    @Column(name = "CPC_TOTAL_AJUSTES", nullable = false)
    public BigDecimal getCpcTotalAjustes() {
        return cpcTotalAjustes;
    }
    
    public void setCpcTotalAjustes(BigDecimal cpcTotalAjustes) {
        this.cpcTotalAjustes = cpcTotalAjustes;
    }
}
