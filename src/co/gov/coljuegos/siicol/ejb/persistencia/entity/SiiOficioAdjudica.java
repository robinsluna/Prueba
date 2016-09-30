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
@Table(name = "SII_OFICIO_ADJUDICA")
public class SiiOficioAdjudica implements Serializable {
    private static final long serialVersionUID = -6338275446143694204L;
    private Long oadCodigo;
    private Integer oadConsecContr;
    private String oadEstado;
    private Date oadFechaReg;
    private SiiProcesoContratacion siiProcesoContratacion;
    private SiiProveedor siiProveedor;
    private String oadTipoContr;
    private Integer oadVigenciaContr;
    private List<SiiContratoProveedor> siiContratoProveedorList;

    public SiiOficioAdjudica() {
    }

    public SiiOficioAdjudica(Long oadCodigo, String oadEstado, Date oadFechaReg,
                             SiiProcesoContratacion siiProcesoContratacion, SiiProveedor siiProveedor,
						String oadTipoContr, Integer oadVigenciaContr, Integer oadConsecContr) {
        this.oadCodigo = oadCodigo;
        this.oadConsecContr = oadConsecContr;
        this.oadEstado = oadEstado;
        this.oadFechaReg = oadFechaReg;
        this.siiProcesoContratacion = siiProcesoContratacion;
        this.siiProveedor = siiProveedor;
        this.oadTipoContr = oadTipoContr;
        this.oadVigenciaContr = oadVigenciaContr;
    }

    @Id
    @Column(name = "OAD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OFICIO_ADJUDICA_COD")
    @SequenceGenerator(name = "SEQ_OFICIO_ADJUDICA_COD", sequenceName = "SEQ_OFICIO_ADJUDICA_COD",allocationSize=1)
    public Long getOadCodigo() {
        return oadCodigo;
    }

    public void setOadCodigo(Long oadCodigo) {
        this.oadCodigo = oadCodigo;
    }

    @Column(name = "OAD_CONSEC_CONTR")
    public Integer getOadConsecContr() {
        return oadConsecContr;
    }

    public void setOadConsecContr(Integer oadConsecContr) {
        this.oadConsecContr = oadConsecContr;
    }

    @Column(name = "OAD_ESTADO", nullable = false, length = 1)
    public String getOadEstado() {
        return oadEstado;
    }

    public void setOadEstado(String oadEstado) {
        this.oadEstado = oadEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OAD_FECHA_REG", nullable = false)
    public Date getOadFechaReg() {
        return oadFechaReg;
    }

    public void setOadFechaReg(Date oadFechaReg) {
        this.oadFechaReg = oadFechaReg;
    }

    @Column(name = "OAD_TIPO_CONTR", length = 3)
    public String getOadTipoContr() {
        return oadTipoContr;
    }

    public void setOadTipoContr(String oadTipoContr) {
        this.oadTipoContr = oadTipoContr;
    }

    @Column(name = "OAD_VIGENCIA_CONTR")
    public Integer getOadVigenciaContr() {
        return oadVigenciaContr;
    }

    public void setOadVigenciaContr(Integer oadVigenciaContr) {
        this.oadVigenciaContr = oadVigenciaContr;
    }

    @ManyToOne
    @JoinColumn(name = "PRC_CODIGO")
    public SiiProcesoContratacion getSiiProcesoContratacion() {
        return siiProcesoContratacion;
    }

    public void setSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        this.siiProcesoContratacion = siiProcesoContratacion;
    }

    @ManyToOne
    @JoinColumn(name = "PRO_CODIGO")
    public SiiProveedor getSiiProveedor() {
        return siiProveedor;
    }

    public void setSiiProveedor(SiiProveedor siiProveedor) {
        this.siiProveedor = siiProveedor;
    }

    @OneToMany(mappedBy = "siiOficioAdjudica")
    public List<SiiContratoProveedor> getSiiContratoProveedorList() {
        return siiContratoProveedorList;
    }

    public void setSiiContratoProveedorList(List<SiiContratoProveedor> siiContratoProveedorList) {
        this.siiContratoProveedorList = siiContratoProveedorList;
    }

    public SiiContratoProveedor addSiiContratoProveedor(SiiContratoProveedor siiContratoProveedor) {
        getSiiContratoProveedorList().add(siiContratoProveedor);
        siiContratoProveedor.setSiiOficioAdjudica(this);
        return siiContratoProveedor;
    }

    public SiiContratoProveedor removeSiiContratoProveedor(SiiContratoProveedor siiContratoProveedor) {
        getSiiContratoProveedorList().remove(siiContratoProveedor);
        siiContratoProveedor.setSiiOficioAdjudica(null);
        return siiContratoProveedor;
    }
}
