package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_PRUEBA_AUTO_DECR_PRU")
public class SiiPruebaAutoDecrPru implements Serializable {
    private static final long serialVersionUID = 5199014359415540140L;
    private Long papCodigo;
    private SiiUsuario siiUsuarioConec;
    private SiiTipoPruebaIleg siiTipoPruebaIleg;
    private SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle;

    public SiiPruebaAutoDecrPru() {
    }

    public SiiPruebaAutoDecrPru(SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle, Long papCodigo, SiiTipoPruebaIleg siiTipoPruebaIleg, SiiUsuario siiUsuarioConec) {
        this.siiAutoDecretaPrueProIle = siiAutoDecretaPrueProIle;
        this.papCodigo = papCodigo;
        this.siiTipoPruebaIleg = siiTipoPruebaIleg;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "PAP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PRUE_AUTO_DECR_PRU_COD")
    @SequenceGenerator(name = "SEQ_PRUE_AUTO_DECR_PRU_COD", sequenceName = "SEQ_PRUE_AUTO_DECR_PRU_COD",allocationSize=1)
    public Long getPapCodigo() {
        return papCodigo;
    }

    public void setPapCodigo(Long papCodigo) {
        this.papCodigo = papCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @ManyToOne
    @JoinColumn(name = "TPI_CODIGO")
    public SiiTipoPruebaIleg getSiiTipoPruebaIleg() {
        return siiTipoPruebaIleg;
    }

    public void setSiiTipoPruebaIleg(SiiTipoPruebaIleg siiTipoPruebaIleg) {
        this.siiTipoPruebaIleg = siiTipoPruebaIleg;
    }

    @ManyToOne
    @JoinColumn(name = "ATP_CODIGO")
    public SiiAutoDecretaPrueProIle getSiiAutoDecretaPrueProIle() {
        return siiAutoDecretaPrueProIle;
    }

    public void setSiiAutoDecretaPrueProIle(SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle) {
        this.siiAutoDecretaPrueProIle = siiAutoDecretaPrueProIle;
    }
}
