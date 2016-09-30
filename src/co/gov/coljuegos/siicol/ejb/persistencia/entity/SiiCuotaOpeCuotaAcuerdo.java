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
@Table(name = "SII_CUOTA_OPE_CUOTA_ACUERDO")
public class SiiCuotaOpeCuotaAcuerdo implements Serializable {
    private static final long serialVersionUID = -6557524408955716910L;
    private Long cocCodigo;
    private SiiCuotaOperador siiCuotaOperadorAcuerdo;
    private SiiCuotaOperador siiCuotaOperador;

    public SiiCuotaOpeCuotaAcuerdo() {
    }

    public SiiCuotaOpeCuotaAcuerdo(Long cocCodigo, SiiCuotaOperador siiCuotaOperador,
                                   SiiCuotaOperador siiCuotaOperadorAcuerdo) {
        this.cocCodigo = cocCodigo;
        this.siiCuotaOperador = siiCuotaOperador;
        this.siiCuotaOperadorAcuerdo = siiCuotaOperadorAcuerdo;
    }

    @Id
    @Column(name = "COC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CUOT_OPE_CUOT_ACU_COD")
    @SequenceGenerator(name = "SEQ_CUOT_OPE_CUOT_ACU_COD", sequenceName = "SEQ_CUOT_OPE_CUOT_ACU_COD",allocationSize=1)
    public Long getCocCodigo() {
        return cocCodigo;
    }

    public void setCocCodigo(Long cocCodigo) {
        this.cocCodigo = cocCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "COP_CODIGO_APA")
    public SiiCuotaOperador getSiiCuotaOperadorAcuerdo() {
        return siiCuotaOperadorAcuerdo;
    }

    public void setSiiCuotaOperadorAcuerdo(SiiCuotaOperador siiCuotaOperadorAcuerdo) {
        this.siiCuotaOperadorAcuerdo = siiCuotaOperadorAcuerdo;
    }

    @ManyToOne
    @JoinColumn(name = "COP_CODIGO")
    public SiiCuotaOperador getSiiCuotaOperador() {
        return siiCuotaOperador;
    }

    public void setSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        this.siiCuotaOperador = siiCuotaOperador;
    }
}
