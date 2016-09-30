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
@Table(name = "SII_BARRIO_ORDEN_INF_VER")
public class SiiBarrioOrdenInfVer implements Serializable {
    private static final long serialVersionUID = -4229915504435815021L;
    private Long bivCodigo;
    private String bivDireccion;
    private String bivTipoJuego;
    private SiiBarrioOrden siiBarrioOrden;
    private List<SiiElementoIlegInfVer> siiElementoIlegInfVerList;
    private SiiInformeVerificCampo siiInformeVerificCampo;
    private String bivActivo;

    public SiiBarrioOrdenInfVer() {
    }

    public SiiBarrioOrdenInfVer(Long bivCodigo, String bivDireccion, String bivTipoJuego, SiiBarrioOrden siiBarrioOrden,
                                SiiInformeVerificCampo siiInformeVerificCampo) {
        this.bivCodigo = bivCodigo;
        this.bivDireccion = bivDireccion;
        this.bivTipoJuego = bivTipoJuego;
        this.siiBarrioOrden = siiBarrioOrden;
        this.siiInformeVerificCampo = siiInformeVerificCampo;
    }

    @Id
    @Column(name = "BIV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_BAR_ORD_INF_VER_COD")
    @SequenceGenerator(name = "SEQ_BAR_ORD_INF_VER_COD", sequenceName = "SEQ_BAR_ORD_INF_VER_COD",allocationSize=1)
    public Long getBivCodigo() {
        return bivCodigo;
    }

    public void setBivCodigo(Long bivCodigo) {
        this.bivCodigo = bivCodigo;
    }

    @Column(name = "BIV_DIRECCION", nullable = false, length = 100)
    public String getBivDireccion() {
        return bivDireccion;
    }

    public void setBivDireccion(String bivDireccion) {
        this.bivDireccion = bivDireccion;
    }

    @Column(name = "BIV_TIPO_JUEGO", nullable = false, length = 15)
    public String getBivTipoJuego() {
        return bivTipoJuego;
    }

    public void setBivTipoJuego(String bivTipoJuego) {
        this.bivTipoJuego = bivTipoJuego;
    }


    @ManyToOne
    @JoinColumn(name = "BOR_CODIGO")
    public SiiBarrioOrden getSiiBarrioOrden() {
        return siiBarrioOrden;
    }

    public void setSiiBarrioOrden(SiiBarrioOrden siiBarrioOrden) {
        this.siiBarrioOrden = siiBarrioOrden;
    }

    @OneToMany(mappedBy = "siiBarrioOrdenInfVer")
    public List<SiiElementoIlegInfVer> getSiiElementoIlegInfVerList() {
        return siiElementoIlegInfVerList;
    }

    public void setSiiElementoIlegInfVerList(List<SiiElementoIlegInfVer> siiElementoIlegInfVerList) {
        this.siiElementoIlegInfVerList = siiElementoIlegInfVerList;
    }

    public SiiElementoIlegInfVer addSiiElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) {
        getSiiElementoIlegInfVerList().add(siiElementoIlegInfVer);
        siiElementoIlegInfVer.setSiiBarrioOrdenInfVer(this);
        return siiElementoIlegInfVer;
    }

    public SiiElementoIlegInfVer removeSiiElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) {
        getSiiElementoIlegInfVerList().remove(siiElementoIlegInfVer);
        siiElementoIlegInfVer.setSiiBarrioOrdenInfVer(null);
        return siiElementoIlegInfVer;
    }

    @ManyToOne
    @JoinColumn(name = "IVC_CODIGO")
    public SiiInformeVerificCampo getSiiInformeVerificCampo() {
        return siiInformeVerificCampo;
    }

    public void setSiiInformeVerificCampo(SiiInformeVerificCampo siiInformeVerificCampo) {
        this.siiInformeVerificCampo = siiInformeVerificCampo;
    }
    
    @Column(name = "BIV_ACTIVO", nullable = false, length = 1)
    public String getBivActivo() {
        return bivActivo;
    }

    public void setBivActivo(String bivActivo) {
        this.bivActivo = bivActivo;
    }
}
