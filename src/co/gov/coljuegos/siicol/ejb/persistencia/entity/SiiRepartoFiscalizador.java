package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_REPARTO_FISCALIZADOR")
public class SiiRepartoFiscalizador implements Serializable {
    private static final long serialVersionUID = 48408614175936067L;
    private String rfsActivo;
    private Long rfsCodigo;
    private Date rfsFecha;
    private SiiIncumplimientoContr siiIncumplimientoContr;
    private SiiFiscalizadorSustanc siiFiscalizadorSustanc;
    private SiiProcesoSancionatorio siiProcesoSancionatorio;

    public SiiRepartoFiscalizador() {
    }

    public SiiRepartoFiscalizador(SiiFiscalizadorSustanc siiFiscalizadorSustanc, SiiIncumplimientoContr siiIncumplimientoContr, String rfsActivo, Long rfsCodigo, Date rfsFecha) {
        this.siiFiscalizadorSustanc = siiFiscalizadorSustanc;
        this.siiIncumplimientoContr = siiIncumplimientoContr;
        this.rfsActivo = rfsActivo;
        this.rfsCodigo = rfsCodigo;
        this.rfsFecha = rfsFecha;
    }


    @Column(name = "RFS_ACTIVO", nullable = false, length = 1)
    public String getRfsActivo() {
        return rfsActivo;
    }

    public void setRfsActivo(String rfsActivo) {
        this.rfsActivo = rfsActivo;
    }

    @Id
    @Column(name = "RFS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REPARTO_FISCALIZADOR_COD")
    @SequenceGenerator(name = "SEQ_REPARTO_FISCALIZADOR_COD", sequenceName = "SEQ_REPARTO_FISCALIZADOR_COD",allocationSize=1)
    public Long getRfsCodigo() {
        return rfsCodigo;
    }

    public void setRfsCodigo(Long rfsCodigo) {
        this.rfsCodigo = rfsCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RFS_FECHA", nullable = false)
    public Date getRfsFecha() {
        return rfsFecha;
    }

    public void setRfsFecha(Date rfsFecha) {
        this.rfsFecha = rfsFecha;
    }

    @ManyToOne
    @JoinColumn(name = "ICN_CODIGO")
    public SiiIncumplimientoContr getSiiIncumplimientoContr() {
        return siiIncumplimientoContr;
    }

    public void setSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        this.siiIncumplimientoContr = siiIncumplimientoContr;
    }

    @ManyToOne
    @JoinColumn(name = "FSU_CODIGO")
    public SiiFiscalizadorSustanc getSiiFiscalizadorSustanc() {
        return siiFiscalizadorSustanc;
    }

    public void setSiiFiscalizadorSustanc(SiiFiscalizadorSustanc siiFiscalizadorSustanc) {
        this.siiFiscalizadorSustanc = siiFiscalizadorSustanc;
    }

    @ManyToOne
    @JoinColumn(name = "PSA_CODIGO")
    public SiiProcesoSancionatorio getSiiProcesoSancionatorio(){
        return siiProcesoSancionatorio;
    }

    public void setSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio){
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }
}
