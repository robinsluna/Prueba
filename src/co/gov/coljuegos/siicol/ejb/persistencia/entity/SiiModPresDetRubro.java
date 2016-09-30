package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MOD_PRES_DET_RUBRO")
public class SiiModPresDetRubro implements Serializable {
    private static final long serialVersionUID = -1958420650082008457L;
    private Long mpdCodigo;
    private Long mpdValor;
    private SiiDetalleRubro siiDetalleRubroOri;
    private SiiDetalleRubro siiDetalleRubroDest;
    private SiiModificPresup siiModificPresup;
    private SiiUsuario siiUsuarioConec;

    public SiiModPresDetRubro() {
    }

    public SiiModPresDetRubro(SiiDetalleRubro siiDetalleRubroOri, SiiDetalleRubro siiDetalleRubroDest, Long mpdCodigo,
                              Long mpdValor, SiiModificPresup siiModificPresup) {
        this.siiDetalleRubroOri = siiDetalleRubroOri;
        this.siiDetalleRubroDest = siiDetalleRubroDest;
        this.mpdCodigo = mpdCodigo;
        this.mpdValor = mpdValor;
        this.siiModificPresup = siiModificPresup;
    }


    @Id
    @Column(name = "MPD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MOD_PRES_DET_RUBRO")
    @SequenceGenerator(name = "SEQ_MOD_PRES_DET_RUBRO", sequenceName = "SEQ_MOD_PRES_DET_RUBRO",allocationSize=1)
    public Long getMpdCodigo() {
        return mpdCodigo;
    }

    public void setMpdCodigo(Long mpdCodigo) {
        this.mpdCodigo = mpdCodigo;
    }

    @Column(name = "MPD_VALOR", nullable = false)
    public Long getMpdValor() {
        return mpdValor;
    }

    public void setMpdValor(Long mpdValor) {
        this.mpdValor = mpdValor;
    }


    @ManyToOne
    @JoinColumn(name = "DRU_CODIGO_ORIGEN")
    public SiiDetalleRubro getSiiDetalleRubroOri() {
        return siiDetalleRubroOri;
    }

    public void setSiiDetalleRubroOri(SiiDetalleRubro siiDetalleRubroOri) {
        this.siiDetalleRubroOri = siiDetalleRubroOri;
    }

    @ManyToOne
    @JoinColumn(name = "DRU_CODIGO_DESTINO")
    public SiiDetalleRubro getSiiDetalleRubroDest() {
        return siiDetalleRubroDest;
    }

    public void setSiiDetalleRubroDest(SiiDetalleRubro siiDetalleRubroDest) {
        this.siiDetalleRubroDest = siiDetalleRubroDest;
    }

    @ManyToOne
    @JoinColumn(name = "MPR_CODIGO")
    public SiiModificPresup getSiiModificPresup() {
        return siiModificPresup;
    }

    public void setSiiModificPresup(SiiModificPresup siiModificPresup) {
        this.siiModificPresup = siiModificPresup;
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
