package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_NOVEDAD")
public class SiiTipoNovedad implements Serializable {
    private static final long serialVersionUID = -8418459346069252603L;
    private Long tnoCodigo;
    private String tnoNombre;
    private List<SiiNovedad> siiNovedadList1;
    private List<SiiResolucionDesisSolAut> siiResolucionDesisSolAutList;
    private List<SiiInventarioResolDesis> siiInventarioResolDesisList;
    
    public SiiTipoNovedad() {
    }

    public SiiTipoNovedad(Long tnoCodigo, String tnoNombre) {
        this.tnoCodigo = tnoCodigo;
        this.tnoNombre = tnoNombre;
    }

    @Id
    @Column(name = "TNO_CODIGO", nullable = false)
    public Long getTnoCodigo() {
        return tnoCodigo;
    }

    public void setTnoCodigo(Long tnoCodigo) {
        this.tnoCodigo = tnoCodigo;
    }

    @Column(name = "TNO_NOMBRE", nullable = false, length = 50)
    public String getTnoNombre() {
        return tnoNombre;
    }

    public void setTnoNombre(String tnoNombre) {
        this.tnoNombre = tnoNombre;
    }

    @OneToMany(mappedBy = "siiTipoNovedad")
    public List<SiiNovedad> getSiiNovedadList1() {
        return siiNovedadList1;
    }

    public void setSiiNovedadList1(List<SiiNovedad> siiNovedadList1) {
        this.siiNovedadList1 = siiNovedadList1;
    }

    public SiiNovedad addSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList1().add(siiNovedad);
        siiNovedad.setSiiTipoNovedad(this);
        return siiNovedad;
    }

    public SiiNovedad removeSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList1().remove(siiNovedad);
        siiNovedad.setSiiTipoNovedad(null);
        return siiNovedad;
    }

/*    @OneToMany(mappedBy = "siiTipoNovedad")
    public List<SiiResolucionDesisSolAut> getSiiResolucionDesisSolAutList(){
        return siiResolucionDesisSolAutList;
    }

    public void setSiiResolucionDesisSolAutList(List<SiiResolucionDesisSolAut> siiResolucionDesisSolAutList){
        this.siiResolucionDesisSolAutList = siiResolucionDesisSolAutList;
    }

    public SiiResolucionDesisSolAut addSiiResolucionDesisSolAut(SiiResolucionDesisSolAut siiResolucionDesisSolAut){
        getSiiResolucionDesisSolAutList().add(siiResolucionDesisSolAut);
        siiResolucionDesisSolAut.setSiiTipoNovedad(this);
        return siiResolucionDesisSolAut;
    }

    public SiiResolucionDesisSolAut removeSiiResolucionDesisSolAut(SiiResolucionDesisSolAut siiResolucionDesisSolAut){
        getSiiResolucionDesisSolAutList().remove(siiResolucionDesisSolAut);
        siiResolucionDesisSolAut.setSiiTipoNovedad(null);
        return siiResolucionDesisSolAut;
    }*/
    
    @OneToMany(mappedBy = "siiTipoNovedad")
    public List<SiiInventarioResolDesis> getSiiInventarioResolDesisList(){
        return siiInventarioResolDesisList;
    }

    public void setSiiInventarioResolDesisList(List<SiiInventarioResolDesis> siiInventarioResolDesisList){
        this.siiInventarioResolDesisList = siiInventarioResolDesisList;
    }

    public SiiInventarioResolDesis addSiiInventarioResolDesis(SiiInventarioResolDesis siiInventarioResolDesis){
        getSiiInventarioResolDesisList().add(siiInventarioResolDesis);
        siiInventarioResolDesis.setSiiTipoNovedad(this);
        return siiInventarioResolDesis;
    }

    public SiiInventarioResolDesis removeSiiInventarioResolDesis(SiiInventarioResolDesis siiInventarioResolDesis){
        getSiiInventarioResolDesisList().remove(siiInventarioResolDesis);
        siiInventarioResolDesis.setSiiTipoNovedad(null);
        return siiInventarioResolDesis;
    }
}
