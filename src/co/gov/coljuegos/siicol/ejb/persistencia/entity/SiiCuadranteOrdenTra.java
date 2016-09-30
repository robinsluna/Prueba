package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_CUADRANTE_ORDEN_TRA")
public class SiiCuadranteOrdenTra implements Serializable {
    private static final long serialVersionUID = 3898893067228172212L;
    private String cotActivo;
    private Long cotCodigo;
    private String cotLimite1;
    private String cotLimite2;
    private String cotLimite3;
    private String cotLimite4;
    private SiiOrdenTrabajoVisita siiOrdenTrabajoVisita;
    private List<SiiCuadranteOrdTraInfVer> siiCuadranteOrdTraInfVerList;

    public SiiCuadranteOrdenTra() {
    }

    public SiiCuadranteOrdenTra(String cotActivo, Long cotCodigo, String cotLimite1, String cotLimite2, String cotLimite3, String cotLimite4, SiiOrdenTrabajoVisita siiOrdenTrabajoVisita) {
        this.cotActivo = cotActivo;
        this.cotCodigo = cotCodigo;
        this.cotLimite1 = cotLimite1;
        this.cotLimite2 = cotLimite2;
        this.cotLimite3 = cotLimite3;
        this.cotLimite4 = cotLimite4;
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
    }

    @Column(name = "COT_ACTIVO", nullable = false, length = 1)
    public String getCotActivo() {
        return cotActivo;
    }

    public void setCotActivo(String cotActivo) {
        this.cotActivo = cotActivo;
    }

    @Id
    @Column(name = "COT_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CUADRANTE_ORD_TRA_COD")
    @SequenceGenerator(name = "SEQ_CUADRANTE_ORD_TRA_COD", sequenceName = "SEQ_CUADRANTE_ORD_TRA_COD",allocationSize=1)
    public Long getCotCodigo() {
        return cotCodigo;
    }

    public void setCotCodigo(Long cotCodigo) {
        this.cotCodigo = cotCodigo;
    }

    @Column(name = "COT_LIMITE1", nullable = false, length = 100)
    public String getCotLimite1() {
        return cotLimite1;
    }

    public void setCotLimite1(String cotLimite1) {
        this.cotLimite1 = cotLimite1;
    }

    @Column(name = "COT_LIMITE2", nullable = false, length = 100)
    public String getCotLimite2() {
        return cotLimite2;
    }

    public void setCotLimite2(String cotLimite2) {
        this.cotLimite2 = cotLimite2;
    }

    @Column(name = "COT_LIMITE3", nullable = false, length = 100)
    public String getCotLimite3() {
        return cotLimite3;
    }

    public void setCotLimite3(String cotLimite3) {
        this.cotLimite3 = cotLimite3;
    }

    @Column(name = "COT_LIMITE4", nullable = false, length = 100)
    public String getCotLimite4() {
        return cotLimite4;
    }

    public void setCotLimite4(String cotLimite4) {
        this.cotLimite4 = cotLimite4;
    }


    @ManyToOne
    @JoinColumn(name = "OTV_CODIGO")
    public SiiOrdenTrabajoVisita getSiiOrdenTrabajoVisita() {
        return siiOrdenTrabajoVisita;
    }

    public void setSiiOrdenTrabajoVisita(SiiOrdenTrabajoVisita siiOrdenTrabajoVisita) {
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
    }

    @OneToMany(mappedBy = "siiCuadranteOrdenTra")
    public List<SiiCuadranteOrdTraInfVer> getSiiCuadranteOrdTraInfVerList() {
        return siiCuadranteOrdTraInfVerList;
    }

    public void setSiiCuadranteOrdTraInfVerList(List<SiiCuadranteOrdTraInfVer> siiCuadranteOrdTraInfVerList) {
        this.siiCuadranteOrdTraInfVerList = siiCuadranteOrdTraInfVerList;
    }

    public SiiCuadranteOrdTraInfVer addSiiCuadranteOrdTraInfVer(SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer) {
        getSiiCuadranteOrdTraInfVerList().add(siiCuadranteOrdTraInfVer);
        siiCuadranteOrdTraInfVer.setSiiCuadranteOrdenTra(this);
        return siiCuadranteOrdTraInfVer;
    }

    public SiiCuadranteOrdTraInfVer removeSiiCuadranteOrdTraInfVer(SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer) {
        getSiiCuadranteOrdTraInfVerList().remove(siiCuadranteOrdTraInfVer);
        siiCuadranteOrdTraInfVer.setSiiCuadranteOrdenTra(null);
        return siiCuadranteOrdTraInfVer;
    }
}
