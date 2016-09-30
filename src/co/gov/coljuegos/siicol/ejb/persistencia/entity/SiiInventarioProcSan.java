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
@Table(name = "SII_INVENTARIO_PROC_SAN")
public class SiiInventarioProcSan implements Serializable {
    private static final long serialVersionUID = -3440687476182507233L;
    private Long ipsCodigo;
    private SiiTipoApuesta siiTipoApuesta;
    private SiiProcesoSancionatorio siiProcesoSancionatorio;
    private SiiInventario siiInventario;
    private SiiTipoApuesta siiTipoApuestaEncont;
    private String ipsActivo;

    public SiiInventarioProcSan() {
    }

    public SiiInventarioProcSan(Long ipsCodigo, SiiProcesoSancionatorio siiProcesoSancionatorio, SiiTipoApuesta siiTipoApuesta) {
        this.ipsCodigo = ipsCodigo;
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
        this.siiTipoApuesta = siiTipoApuesta;
    }

    @Id
    @Column(name = "IPS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INVENTARIO_PROC_SAN_COD")
    @SequenceGenerator(name = "SEQ_INVENTARIO_PROC_SAN_COD", sequenceName = "SEQ_INVENTARIO_PROC_SAN_COD",allocationSize=1)
    public Long getIpsCodigo() {
        return ipsCodigo;
    }

    public void setIpsCodigo(Long ipsCodigo) {
        this.ipsCodigo = ipsCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "TAP_CODIGO_AUT")
    public SiiTipoApuesta getSiiTipoApuesta() {
        return siiTipoApuesta;
    }

    public void setSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta) {
        this.siiTipoApuesta = siiTipoApuesta;
    }

    @ManyToOne
    @JoinColumn(name = "PSA_CODIGO")
    public SiiProcesoSancionatorio getSiiProcesoSancionatorio() {
        return siiProcesoSancionatorio;
    }

    public void setSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }

    @ManyToOne
    @JoinColumn(name = "INV_CODIGO")
    public SiiInventario getSiiInventario() {
        return siiInventario;
    }

    public void setSiiInventario(SiiInventario siiInventario) {
        this.siiInventario = siiInventario;
    }

    @ManyToOne
    @JoinColumn(name = "TAP_CODIGO_ENCONT")
    public SiiTipoApuesta getSiiTipoApuestaEncont(){
        return siiTipoApuestaEncont;
    }

    public void setSiiTipoApuestaEncont(SiiTipoApuesta siiTipoApuestaEncont){
        this.siiTipoApuestaEncont = siiTipoApuestaEncont;
    }

    @Column(name = "IPS_ACTIVO", length = 1, nullable = false)
    public String getIpsActivo() {
        return ipsActivo;
    }
    
    public void setIpsActivo(String ipsActivo) {
        this.ipsActivo = ipsActivo;
    }
}
