package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCategoriaDistrib;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;

import java.util.List;


/**
 * Value Object para el Concepto de Cuota.
 */
public class ConceptoCuotaVO {
    
    private Long ccuCodigo;
    private String ccuNombre;
    private String ccuAbreviatura;
    private String ccuDestino;
    private String ccuTipoTasa;
    private String ccuDistribucion;
    private String ccuAbrevImp;
    private CategoriaDistribVO categoriaDistribVo;
    
    private List<CuotaOperadorVO> cuotaOperadorList;
    private List<DetalleDistribVO> detalleDistribList;
    
    
    /**
     * Constructor.
     */
    public ConceptoCuotaVO() { }
    
    
    
    /**
     * Constructor.
     * @param siiConceptoCuota - Entity.
     */
    public ConceptoCuotaVO(SiiConceptoCuota siiConceptoCuota) {
        if (siiConceptoCuota!=null) {
            this.ccuCodigo = siiConceptoCuota.getCcuCodigo();
            this.ccuNombre = siiConceptoCuota.getCcuNombre();
            this.ccuAbreviatura = siiConceptoCuota.getCcuAbreviatura();
            this.ccuDestino = siiConceptoCuota.getCcuDestino();
            this.ccuTipoTasa = siiConceptoCuota.getCcuTipoTasa();
            this.ccuDistribucion = siiConceptoCuota.getCcuDistribucion();
            this.ccuAbrevImp = siiConceptoCuota.getCcuAbrevImp();
            if(siiConceptoCuota.getSiiCategoriaDistrib()!= null){
                this.categoriaDistribVo = new CategoriaDistribVO(siiConceptoCuota.getSiiCategoriaDistrib());
            }
        }
    }

    
    
    public void setCcuCodigo(Long ccuCodigo) {
        this.ccuCodigo = ccuCodigo;
    }

    public Long getCcuCodigo() {
        return ccuCodigo;
    }

    public void setCcuNombre(String ccuNombre) {
        this.ccuNombre = ccuNombre;
    }

    public String getCcuNombre() {
        return ccuNombre;
    }

    public void setCcuAbreviatura(String ccuAbreviatura) {
        this.ccuAbreviatura = ccuAbreviatura;
    }

    public String getCcuAbreviatura() {
        return ccuAbreviatura;
    }

    public void setCcuDestino(String ccuDestino) {
        this.ccuDestino = ccuDestino;
    }

    public String getCcuDestino() {
        return ccuDestino;
    }

    public void setCcuTipoTasa(String ccuTipoTasa) {
        this.ccuTipoTasa = ccuTipoTasa;
    }

    public String getCcuTipoTasa() {
        return ccuTipoTasa;
    }

    public void setCcuDistribucion(String ccuDistribucion) {
        this.ccuDistribucion = ccuDistribucion;
    }

    public String getCcuDistribucion() {
        return ccuDistribucion;
    }

    public void setCcuAbrevImp(String ccuAbrevImp) {
        this.ccuAbrevImp = ccuAbrevImp;
    }

    public String getCcuAbrevImp() {
        return ccuAbrevImp;
    }

    public void setCuotaOperadorList(List<CuotaOperadorVO> cuotaOperadorList) {
        this.cuotaOperadorList = cuotaOperadorList;
    }

    public List<CuotaOperadorVO> getCuotaOperadorList() {
        return cuotaOperadorList;
    }

    public void setDetalleDistribList(List<DetalleDistribVO> detalleDistribList) {
        this.detalleDistribList = detalleDistribList;
    }

    public List<DetalleDistribVO> getDetalleDistribList() {
        return detalleDistribList;
    }

    public void setCategoriaDistribVo(CategoriaDistribVO categoriaDistribVo) {
        this.categoriaDistribVo = categoriaDistribVo;
    }

    public CategoriaDistribVO getCategoriaDistribVo() {
        return categoriaDistribVo;
    }
}
