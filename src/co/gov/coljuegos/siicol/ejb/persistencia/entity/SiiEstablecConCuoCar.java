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
@Table(name = "SII_ESTABLEC_CON_CUO_CAR")
public class SiiEstablecConCuoCar implements Serializable {
    private static final long serialVersionUID = 407801780452950235L;
    private String ecuActivo;
    private String ecuCodEstablec;
    private Long ecuCodigo;
    private BigDecimal ecuPorcentaje;
    private BigDecimal ecuValor;
    private SiiUbicacion siiUbicacionMunicipio;
    private SiiConcepCuotCarActAdm siiConcepCuotCarActAdm;
    private SiiUsuario siiUsuarioConectado;

    public SiiEstablecConCuoCar() {
    }

    public SiiEstablecConCuoCar(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm, String ecuActivo, String ecuCodEstablec, Long ecuCodigo, BigDecimal ecuPorcentaje, BigDecimal ecuValor,
                                SiiUbicacion siiUbicacionMunicipio, SiiUsuario siiUsuarioConectado) {
        this.siiConcepCuotCarActAdm = siiConcepCuotCarActAdm;
        this.ecuActivo = ecuActivo;
        this.ecuCodEstablec = ecuCodEstablec;
        this.ecuCodigo = ecuCodigo;
        this.ecuPorcentaje = ecuPorcentaje;
        this.ecuValor = ecuValor;
        this.siiUbicacionMunicipio = siiUbicacionMunicipio;
        this.siiUsuarioConectado = siiUsuarioConectado;
    }


    @Column(name = "ECU_ACTIVO", nullable = false, length = 1)
    public String getEcuActivo() {
        return ecuActivo;
    }

    public void setEcuActivo(String ecuActivo) {
        this.ecuActivo = ecuActivo;
    }

    @Column(name = "ECU_COD_ESTABLEC", nullable = false, length = 3)
    public String getEcuCodEstablec() {
        return ecuCodEstablec;
    }

    public void setEcuCodEstablec(String ecuCodEstablec) {
        this.ecuCodEstablec = ecuCodEstablec;
    }

    @Id
    @Column(name = "ECU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTABL_CON_CUO_CAR_COD")
    @SequenceGenerator(name = "SEQ_ESTABL_CON_CUO_CAR_COD", sequenceName = "SEQ_ESTABL_CON_CUO_CAR_COD",allocationSize=1)
    public Long getEcuCodigo() {
        return ecuCodigo;
    }

    public void setEcuCodigo(Long ecuCodigo) {
        this.ecuCodigo = ecuCodigo;
    }

    @Column(name = "ECU_PORCENTAJE", nullable = false)
    public BigDecimal getEcuPorcentaje(){
        return ecuPorcentaje;
    }
    
    public void setEcuPorcentaje(BigDecimal ecuPorcentaje){
        this.ecuPorcentaje = ecuPorcentaje;
    }


    @Column(name = "ECU_VALOR", nullable = false)
    public BigDecimal getEcuValor(){
        return ecuValor;
    }
    
    public void setEcuValor(BigDecimal ecuValor){
        this.ecuValor = ecuValor;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO")
    public SiiUbicacion getSiiUbicacionMunicipio() {
        return siiUbicacionMunicipio;
    }

    public void setSiiUbicacionMunicipio(SiiUbicacion siiUbicacionMunicipio) {
        this.siiUbicacionMunicipio = siiUbicacionMunicipio;
    }

    @ManyToOne
    @JoinColumn(name = "CAM_CODIGO")
    public SiiConcepCuotCarActAdm getSiiConcepCuotCarActAdm() {
        return siiConcepCuotCarActAdm;
    }

    public void setSiiConcepCuotCarActAdm(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm) {
        this.siiConcepCuotCarActAdm = siiConcepCuotCarActAdm;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConectado() {
        return siiUsuarioConectado;
    }

    public void setSiiUsuarioConectado(SiiUsuario siiUsuarioConectado) {
        this.siiUsuarioConectado = siiUsuarioConectado;
    }
}
