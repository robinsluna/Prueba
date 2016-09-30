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
@Table(name = "SII_INVENTARIO_AUTO_COMIS")
public class SiiInventarioAutoComis implements Serializable {
    private static final long serialVersionUID = 6498729467188562070L;
    private Long iacCodigo;
    private BigDecimal iacCoinIn;
    private BigDecimal iacCoinOut;
    private String iacItem;
    private String iacRevCodApuesta;
    private String iacRevContadores;
    private String iacRevDescJuego;
    private String iacRevPlanPremios;
    private String iacRevSerial;
    private String iacRevValorPremios;
    private BigDecimal iacValorCredito;
    private BigDecimal iacValorJackpot;
    private SiiInventario siiInventario;
    private SiiAutoComisorio siiAutoComisorio;

    public SiiInventarioAutoComis() {
    }

    public SiiInventarioAutoComis(SiiAutoComisorio siiAutoComisorio, Long iacCodigo, BigDecimal iacCoinIn, BigDecimal iacCoinOut, String iacItem, String iacRevCodApuesta, String iacRevContadores,
                                  String iacRevDescJuego, String iacRevPlanPremios, String iacRevSerial, String iacRevValorPremios, BigDecimal iacValorCredito, BigDecimal iacValorJackpot,
                                  SiiInventario siiInventario) {
        this.siiAutoComisorio = siiAutoComisorio;
        this.iacCodigo = iacCodigo;
        this.iacCoinIn = iacCoinIn;
        this.iacCoinOut = iacCoinOut;
        this.iacItem = iacItem;
        this.iacRevCodApuesta = iacRevCodApuesta;
        this.iacRevContadores = iacRevContadores;
        this.iacRevDescJuego = iacRevDescJuego;
        this.iacRevPlanPremios = iacRevPlanPremios;
        this.iacRevSerial = iacRevSerial;
        this.iacRevValorPremios = iacRevValorPremios;
        this.iacValorCredito = iacValorCredito;
        this.iacValorJackpot = iacValorJackpot;
        this.siiInventario = siiInventario;
    }


    @Id
    @Column(name = "IAC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INVENTARIO_AUTO_COMIS_COD")
    @SequenceGenerator(name = "SEQ_INVENTARIO_AUTO_COMIS_COD", sequenceName = "SEQ_INVENTARIO_AUTO_COMIS_COD",allocationSize=1)
    public Long getIacCodigo() {
        return iacCodigo;
    }

    public void setIacCodigo(Long iacCodigo) {
        this.iacCodigo = iacCodigo;
    }

    @Column(name = "IAC_COIN_IN")
    public BigDecimal getIacCoinIn() {
        return iacCoinIn;
    }

    public void setIacCoinIn(BigDecimal iacCoinIn) {
        this.iacCoinIn = iacCoinIn;
    }

    @Column(name = "IAC_COIN_OUT")
    public BigDecimal getIacCoinOut() {
        return iacCoinOut;
    }

    public void setIacCoinOut(BigDecimal iacCoinOut) {
        this.iacCoinOut = iacCoinOut;
    }

    @Column(name = "IAC_ITEM", nullable = false, length = 8)
    public String getIacItem() {
        return iacItem;
    }

    public void setIacItem(String iacItem) {
        this.iacItem = iacItem;
    }

    @Column(name = "IAC_REV_COD_APUESTA", length = 1)
    public String getIacRevCodApuesta() {
        return iacRevCodApuesta;
    }

    public void setIacRevCodApuesta(String iacRevCodApuesta) {
        this.iacRevCodApuesta = iacRevCodApuesta;
    }

    @Column(name = "IAC_REV_CONTADORES", length = 1)
    public String getIacRevContadores() {
        return iacRevContadores;
    }

    public void setIacRevContadores(String iacRevContadores) {
        this.iacRevContadores = iacRevContadores;
    }

    @Column(name = "IAC_REV_DESC_JUEGO", length = 1)
    public String getIacRevDescJuego() {
        return iacRevDescJuego;
    }

    public void setIacRevDescJuego(String iacRevDescJuego) {
        this.iacRevDescJuego = iacRevDescJuego;
    }

    @Column(name = "IAC_REV_PLAN_PREMIOS", length = 1)
    public String getIacRevPlanPremios() {
        return iacRevPlanPremios;
    }

    public void setIacRevPlanPremios(String iacRevPlanPremios) {
        this.iacRevPlanPremios = iacRevPlanPremios;
    }

    @Column(name = "IAC_REV_SERIAL", length = 1)
    public String getIacRevSerial() {
        return iacRevSerial;
    }

    public void setIacRevSerial(String iacRevSerial) {
        this.iacRevSerial = iacRevSerial;
    }

    @Column(name = "IAC_REV_VALOR_PREMIOS", length = 1)
    public String getIacRevValorPremios() {
        return iacRevValorPremios;
    }

    public void setIacRevValorPremios(String iacRevValorPremios) {
        this.iacRevValorPremios = iacRevValorPremios;
    }

    @Column(name = "IAC_VALOR_CREDITO")
    public BigDecimal getIacValorCredito() {
        return iacValorCredito;
    }

    public void setIacValorCredito(BigDecimal iacValorCredito) {
        this.iacValorCredito = iacValorCredito;
    }

    @Column(name = "IAC_VALOR_JACKPOT")
    public BigDecimal getIacValorJackpot() {
        return iacValorJackpot;
    }

    public void setIacValorJackpot(BigDecimal iacValorJackpot) {
        this.iacValorJackpot = iacValorJackpot;
    }


    @ManyToOne
    @JoinColumn(name = "INV_CODIGO")
    public SiiInventario getSiiInventario() {
        return siiInventario;
    }

    public void setSiiInventario(SiiInventario siiInventario) {
        this.siiInventario = siiInventario;
    }

    @ManyToOne
    @JoinColumn(name = "AUC_CODIGO")
    public SiiAutoComisorio getSiiAutoComisorio() {
        return siiAutoComisorio;
    }

    public void setSiiAutoComisorio(SiiAutoComisorio siiAutoComisorio) {
        this.siiAutoComisorio = siiAutoComisorio;
    }
}
