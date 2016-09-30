package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_FESTIVO")
public class SiiFestivo implements Serializable {
    private static final long serialVersionUID = -1720625944041006834L;
    private Date fesFecha;

    public SiiFestivo() {
    }

    public SiiFestivo(Date fesFecha) {
        this.fesFecha = fesFecha;
    }

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FES_FECHA", nullable = false)
    public Date getFesFecha() {
        return fesFecha;
    }

    public void setFesFecha(Date fesFecha) {
        this.fesFecha = fesFecha;
    }
}
