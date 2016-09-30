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
@Table(name = "SII_PRUEBA_DESCARGO_PRO_ILE")
public class SiiPruebaDescargoProIle implements Serializable {
    private static final long serialVersionUID = -8671299572149135569L;
    private Long pdpCodigo;
    private SiiTipoPruebaIleg siiTipoPruebaIleg;
    private SiiDescargoProcIleg siiDescargoProcIleg;
    private SiiUsuario siiUsuarioConec;

    public SiiPruebaDescargoProIle() {
    }

    public SiiPruebaDescargoProIle(SiiDescargoProcIleg siiDescargoProcIleg, Long pdpCodigo, SiiTipoPruebaIleg siiTipoPruebaIleg, SiiUsuario siiUsuarioConec) {
        this.siiDescargoProcIleg = siiDescargoProcIleg;
        this.pdpCodigo = pdpCodigo;
        this.siiTipoPruebaIleg = siiTipoPruebaIleg;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "PDP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PRUE_DESCAR_PRO_ILE_COD")
    @SequenceGenerator(name = "SEQ_PRUE_DESCAR_PRO_ILE_COD", sequenceName = "SEQ_PRUE_DESCAR_PRO_ILE_COD",allocationSize=1)
    public Long getPdpCodigo() {
        return pdpCodigo;
    }

    public void setPdpCodigo(Long pdpCodigo) {
        this.pdpCodigo = pdpCodigo;
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
    @JoinColumn(name = "DPR_CODIGO")
    public SiiDescargoProcIleg getSiiDescargoProcIleg() {
        return siiDescargoProcIleg;
    }

    public void setSiiDescargoProcIleg(SiiDescargoProcIleg siiDescargoProcIleg) {
        this.siiDescargoProcIleg = siiDescargoProcIleg;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }
}
