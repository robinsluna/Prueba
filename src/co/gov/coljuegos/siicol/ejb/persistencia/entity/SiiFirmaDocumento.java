package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_FIRMA_DOCUMENTO")
public class SiiFirmaDocumento implements Serializable {
    private static final long serialVersionUID = 1566033888941526278L;
    private Long fdoCodigo;
    private Date fdoFechaFirma;
    private SiiUsuario siiUsuario;
    private SiiFirmasRequeridas siiFirmasRequeridas;
    private Long fdoIdDocumento;    
    public SiiFirmaDocumento() {
    }

    public SiiFirmaDocumento(Long fdoCodigo, String fdoFirmado,SiiFirmasRequeridas siiFirmasRequeridas,
                             Date fdoFechaFirma, SiiUsuario siiUsuario) {
        this.fdoCodigo = fdoCodigo;
        this.siiFirmasRequeridas = siiFirmasRequeridas;
        this.fdoFechaFirma = fdoFechaFirma;
        this.siiUsuario = siiUsuario;
    }

    @Id
    @Column(name = "FDO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ__FIRMA_DOCUMENTO_COD")
    @SequenceGenerator(name = "SEQ__FIRMA_DOCUMENTO_COD", sequenceName = "SEQ__FIRMA_DOCUMENTO_COD",allocationSize=1)
    public Long getFdoCodigo() {
        return fdoCodigo;
    }

    public void setFdoCodigo(Long fdoCodigo) {
        this.fdoCodigo = fdoCodigo;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FDO_FECHA_FIRMA")
    public Date getTdoFechaFirma() {
        return fdoFechaFirma;
    }

    public void setTdoFechaFirma(Date tdoFechaFirma) {
        this.fdoFechaFirma = tdoFechaFirma;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "FRE_CODIGO")
    public SiiFirmasRequeridas getSiiFirmasRequeridas() {
        return siiFirmasRequeridas;
    }

    public void setSiiFirmasRequeridas(SiiFirmasRequeridas siiFirmasRequeridas) {
        this.siiFirmasRequeridas = siiFirmasRequeridas;
    }

    @Column(name = "FDO_ID_DOCUMENTO", nullable = false)
    public Long getFdoIdDocumento() {
        return fdoIdDocumento;
    }

    public void setFdoIdDocumento(Long fdoIdDocumento) {
        this.fdoIdDocumento = fdoIdDocumento;
    }
}
