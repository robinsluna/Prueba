package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_SOLIC_AUTORIZA")
public class SiiTipoSolicAutoriza implements Serializable {
    private static final long serialVersionUID = 211096651416489975L;
    private Long tsaCodigo;
    private String tsaNombre;
    private List<SiiSolicitudAutoriza> siiSolicitudAutorizaList;
    private List<SiiResolucionDesisSolAut> siiResolucionDesisSolAutList;

    public SiiTipoSolicAutoriza() {
    }

    public SiiTipoSolicAutoriza(Long tsaCodigo, String tsaNombre) {
        this.tsaCodigo = tsaCodigo;
        this.tsaNombre = tsaNombre;
    }

    @Id
    @Column(name = "TSA_CODIGO", nullable = false)
    public Long getTsaCodigo() {
        return tsaCodigo;
    }

    public void setTsaCodigo(Long tsaCodigo) {
        this.tsaCodigo = tsaCodigo;
    }

    @Column(name = "TSA_NOMBRE", nullable = false, length = 20)
    public String getTsaNombre() {
        return tsaNombre;
    }

    public void setTsaNombre(String tsaNombre) {
        this.tsaNombre = tsaNombre;
    }

    @OneToMany(mappedBy = "siiTipoSolicAutoriza")
    public List<SiiSolicitudAutoriza> getSiiSolicitudAutorizaList() {
        return siiSolicitudAutorizaList;
    }

    public void setSiiSolicitudAutorizaList(List<SiiSolicitudAutoriza> siiSolicitudAutorizaList) {
        this.siiSolicitudAutorizaList = siiSolicitudAutorizaList;
    }

    public SiiSolicitudAutoriza addSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().add(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiTipoSolicAutoriza(this);
        return siiSolicitudAutoriza;
    }

    public SiiSolicitudAutoriza removeSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().remove(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiTipoSolicAutoriza(null);
        return siiSolicitudAutoriza;
    }

    @OneToMany(mappedBy = "siiTipoSolicAutoriza")
    public List<SiiResolucionDesisSolAut> getSiiResolucionDesisSolAutList(){
        return siiResolucionDesisSolAutList;
    }

    public void setSiiResolucionDesisSolAutList(List<SiiResolucionDesisSolAut> siiResolucionDesisSolAutList){
        this.siiResolucionDesisSolAutList = siiResolucionDesisSolAutList;
    }

    public SiiResolucionDesisSolAut addSiiResolucionDesisSolAut(SiiResolucionDesisSolAut siiResolucionDesisSolAut){
        getSiiResolucionDesisSolAutList().add(siiResolucionDesisSolAut);
        siiResolucionDesisSolAut.setSiiTipoSolicAutoriza(this);
        return siiResolucionDesisSolAut;
    }

    public SiiResolucionDesisSolAut removeSiiResolucionDesisSolAut(SiiResolucionDesisSolAut siiResolucionDesisSolAut){
        getSiiResolucionDesisSolAutList().remove(siiResolucionDesisSolAut);
        siiResolucionDesisSolAut.setSiiTipoSolicAutoriza(null);
        return siiResolucionDesisSolAut;
    }
}
