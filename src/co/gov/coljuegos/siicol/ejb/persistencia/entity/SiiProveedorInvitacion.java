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
@Table(name = "SII_PROVEEDOR_INVITACION")
public class SiiProveedorInvitacion implements Serializable {
    private static final long serialVersionUID = 4863555673399319716L;
    private Long pinCodigo;
    private SiiProveedor siiProveedor;
    private SiiInvitacionProceso siiInvitacionProceso;

    public SiiProveedorInvitacion() {
    }

    public SiiProveedorInvitacion(SiiInvitacionProceso siiInvitacionProceso, Long pinCodigo,
                                  SiiProveedor siiProveedor) {
        this.siiInvitacionProceso = siiInvitacionProceso;
        this.pinCodigo = pinCodigo;
        this.siiProveedor = siiProveedor;
    }


    @Id
    @Column(name = "PIN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROV_INVIT_CODIGO")
    @SequenceGenerator(name = "SEQ_PROV_INVIT_CODIGO", sequenceName = "SEQ_PROV_INVIT_CODIGO",allocationSize=1)
    public Long getPinCodigo() {
        return pinCodigo;
    }

    public void setPinCodigo(Long pinCodigo) {
        this.pinCodigo = pinCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "PRO_CODIGO")
    public SiiProveedor getSiiProveedor() {
        return siiProveedor;
    }

    public void setSiiProveedor(SiiProveedor siiProveedor) {
        this.siiProveedor = siiProveedor;
    }

    @ManyToOne
    @JoinColumn(name = "IPR_CODIGO")
    public SiiInvitacionProceso getSiiInvitacionProceso() {
        return siiInvitacionProceso;
    }

    public void setSiiInvitacionProceso(SiiInvitacionProceso siiInvitacionProceso) {
        this.siiInvitacionProceso = siiInvitacionProceso;
    }
}
