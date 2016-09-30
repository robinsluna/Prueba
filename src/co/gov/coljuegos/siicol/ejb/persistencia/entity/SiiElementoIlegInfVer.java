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
@Table(name = "SII_ELEMENTO_ILEG_INF_VER")
public class SiiElementoIlegInfVer implements Serializable {
    private static final long serialVersionUID = -3164847671460129270L;
    private Long eivCodigo;
    private Integer eivNumElementos;
    private SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer;
    private SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer;
    private SiiBarrioOrdenInfVer siiBarrioOrdenInfVer;
    private SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif;
    private SiiTipoElemenIlegalidad siiTipoElemenIlegalidad;
    private String eivActivo;

    public SiiElementoIlegInfVer() {
    }

    public SiiElementoIlegInfVer(SiiBarrioOrdenInfVer siiBarrioOrdenInfVer,
                                 SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer,
                                 SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer, Long eivCodigo, Integer eivNumElementos,
                                 SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif,
                                 SiiTipoElemenIlegalidad siiTipoElemenIlegalidad) {
        this.siiBarrioOrdenInfVer = siiBarrioOrdenInfVer;
        this.siiCuadranteOrdTraInfVer = siiCuadranteOrdTraInfVer;
        this.siiDenuncOrdTraInfVer = siiDenuncOrdTraInfVer;
        this.eivCodigo = eivCodigo;
        this.eivNumElementos = eivNumElementos;
        this.siiMunicOrdTraInfVerif = siiMunicOrdTraInfVerif;
        this.siiTipoElemenIlegalidad = siiTipoElemenIlegalidad;
    }


    @Id
    @Column(name = "EIV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ELEMENTO_ILEG_INF_VER_COD")
    @SequenceGenerator(name = "SEQ_ELEMENTO_ILEG_INF_VER_COD", sequenceName = "SEQ_ELEMENTO_ILEG_INF_VER_COD",allocationSize=1)
    public Long getEivCodigo() {
        return eivCodigo;
    }

    public void setEivCodigo(Long eivCodigo) {
        this.eivCodigo = eivCodigo;
    }

    @Column(name = "EIV_NUM_ELEMENTOS", nullable = false)
    public Integer getEivNumElementos() {
        return eivNumElementos;
    }

    public void setEivNumElementos(Integer eivNumElementos) {
        this.eivNumElementos = eivNumElementos;
    }


    @ManyToOne
    @JoinColumn(name = "CIV_CODIGO")
    public SiiCuadranteOrdTraInfVer getSiiCuadranteOrdTraInfVer() {
        return siiCuadranteOrdTraInfVer;
    }

    public void setSiiCuadranteOrdTraInfVer(SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer) {
        this.siiCuadranteOrdTraInfVer = siiCuadranteOrdTraInfVer;
    }

    @ManyToOne
    @JoinColumn(name = "DIV_CODIGO")
    public SiiDenuncOrdTraInfVer getSiiDenuncOrdTraInfVer() {
        return siiDenuncOrdTraInfVer;
    }

    public void setSiiDenuncOrdTraInfVer(SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer) {
        this.siiDenuncOrdTraInfVer = siiDenuncOrdTraInfVer;
    }

    @ManyToOne
    @JoinColumn(name = "BIV_CODIGO")
    public SiiBarrioOrdenInfVer getSiiBarrioOrdenInfVer() {
        return siiBarrioOrdenInfVer;
    }

    public void setSiiBarrioOrdenInfVer(SiiBarrioOrdenInfVer siiBarrioOrdenInfVer) {
        this.siiBarrioOrdenInfVer = siiBarrioOrdenInfVer;
    }

    @ManyToOne
    @JoinColumn(name = "MIV_CODIGO")
    public SiiMunicOrdTraInfVerif getSiiMunicOrdTraInfVerif() {
        return siiMunicOrdTraInfVerif;
    }

    public void setSiiMunicOrdTraInfVerif(SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif) {
        this.siiMunicOrdTraInfVerif = siiMunicOrdTraInfVerif;
    }

    @ManyToOne
    @JoinColumn(name = "TEI_CODIGO")
    public SiiTipoElemenIlegalidad getSiiTipoElemenIlegalidad() {
        return siiTipoElemenIlegalidad;
    }

    public void setSiiTipoElemenIlegalidad(SiiTipoElemenIlegalidad siiTipoElemenIlegalidad) {
        this.siiTipoElemenIlegalidad = siiTipoElemenIlegalidad;
    }
    
    @Column(name = "EIV_ACTIVO", nullable = false, length = 1)
    public String getEivActivo() {
        return eivActivo;
    }

    public void setEivActivo(String eivActivo) {
        this.eivActivo = eivActivo;
    }
}
