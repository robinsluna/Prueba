package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TASA_INTERES_LEGAL_CIVIL")
public class SiiTasaInteresLegalCivil implements Serializable {
    private static final long serialVersionUID = -6500826609459622364L;
    private String tilActivo;
    private Long tilCodigo;
    private Integer tilTasa;

    public SiiTasaInteresLegalCivil() {
    }

    public SiiTasaInteresLegalCivil(String tilActivo, Long tilCodigo, Integer tilTasa) {
        this.tilActivo = tilActivo;
        this.tilCodigo = tilCodigo;
        this.tilTasa = tilTasa;
    }

    @Column(name = "TIL_ACTIVO", nullable = false, length = 1)
    public String getTilActivo() {
        return tilActivo;
    }

    public void setTilActivo(String tilActivo) {
        this.tilActivo = tilActivo;
    }

    @Id
    @Column(name = "TIL_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TASA_INT_LEG_CIVIL_COD")
    @SequenceGenerator(name = "SEQ_TASA_INT_LEG_CIVIL_COD", sequenceName = "SEQ_TASA_INT_LEG_CIVIL_COD  ",allocationSize=1)
    public Long getTilCodigo() {
        return tilCodigo;
    }

    public void setTilCodigo(Long tilCodigo) {
        this.tilCodigo = tilCodigo;
    }

    @Column(name = "TIL_TASA", nullable = false)
    public Integer getTilTasa() {
        return tilTasa;
    }

    public void setTilTasa(Integer tilTasa) {
        this.tilTasa = tilTasa;
    }
}
