package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_PROYECCION_FLUJO_CAJA")
public class SiiProyeccionFlujoCaja implements Serializable {
    private static final long serialVersionUID = -1656030198495033267L;
    private Long pfcCodigo;
    private Date pfcFechaSolicitud;
    private Integer pfcVigencia;
    private SiiEstadoPfc siiEstadoPfc;
    private List<SiiDistribucionPfc> siiDistribucionPfcList1;

    public SiiProyeccionFlujoCaja() {
    }

    public SiiProyeccionFlujoCaja(SiiEstadoPfc siiEstadoPfc, Long pfcCodigo, Date pfcFechaSolicitud,
                                  Integer pfcVigencia) {
        this.siiEstadoPfc = siiEstadoPfc;
        this.pfcCodigo = pfcCodigo;
        this.pfcFechaSolicitud = pfcFechaSolicitud;
        this.pfcVigencia = pfcVigencia;
    }


    @Id
    @Column(name = "PFC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROYECCION_FLUJO_CAJA_COD")
    @SequenceGenerator(name = "SEQ_PROYECCION_FLUJO_CAJA_COD", sequenceName = "SEQ_PROYECCION_FLUJO_CAJA_COD",allocationSize=1)
    public Long getPfcCodigo() {
        return pfcCodigo;
    }

    public void setPfcCodigo(Long pfcCodigo) {
        this.pfcCodigo = pfcCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PFC_FECHA_SOLICITUD", nullable = false)
    public Date getPfcFechaSolicitud() {
        return pfcFechaSolicitud;
    }

    public void setPfcFechaSolicitud(Date pfcFechaSolicitud) {
        this.pfcFechaSolicitud = pfcFechaSolicitud;
    }

    @Column(name = "PFC_VIGENCIA", nullable = false)
    public Integer getPfcVigencia() {
        return pfcVigencia;
    }

    public void setPfcVigencia(Integer pfcVigencia) {
        this.pfcVigencia = pfcVigencia;
    }

    @ManyToOne
    @JoinColumn(name = "EPF_CODIGO")
    public SiiEstadoPfc getSiiEstadoPfc() {
        return siiEstadoPfc;
    }

    public void setSiiEstadoPfc(SiiEstadoPfc siiEstadoPfc) {
        this.siiEstadoPfc = siiEstadoPfc;
    }

    @OneToMany(mappedBy = "siiProyeccionFlujoCaja")
    public List<SiiDistribucionPfc> getSiiDistribucionPfcList1() {
        return siiDistribucionPfcList1;
    }

    public void setSiiDistribucionPfcList1(List<SiiDistribucionPfc> siiDistribucionPfcList1) {
        this.siiDistribucionPfcList1 = siiDistribucionPfcList1;
    }

    public SiiDistribucionPfc addSiiDistribucionPfc(SiiDistribucionPfc siiDistribucionPfc) {
        getSiiDistribucionPfcList1().add(siiDistribucionPfc);
        siiDistribucionPfc.setSiiProyeccionFlujoCaja(this);
        return siiDistribucionPfc;
    }

    public SiiDistribucionPfc removeSiiDistribucionPfc(SiiDistribucionPfc siiDistribucionPfc) {
        getSiiDistribucionPfcList1().remove(siiDistribucionPfc);
        siiDistribucionPfc.setSiiProyeccionFlujoCaja(null);
        return siiDistribucionPfc;
    }
}
