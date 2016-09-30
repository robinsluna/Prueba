package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SII_PARAMETROS_SISTEMA")
public class SiiParametrosSistema implements Serializable {
    private static final long serialVersionUID = -2103401007331174360L;
    private String psiNombre;
    private String psiValor;

    public SiiParametrosSistema() {
    }

    public SiiParametrosSistema(String psiNombre, String psiValor) {
        this.psiNombre = psiNombre;
        this.psiValor = psiValor;
    }

    @Id
    @Column(name = "PSI_NOMBRE", nullable = false, length = 50)
    public String getPsiNombre() {
        return psiNombre;
    }

    public void setPsiNombre(String psiNombre) {
        this.psiNombre = psiNombre;
    }

    @Column(name = "PSI_VALOR", nullable = false, length = 200)
    public String getPsiValor() {
        return psiValor;
    }

    public void setPsiValor(String psiValor) {
        this.psiValor = psiValor;
    }
}
