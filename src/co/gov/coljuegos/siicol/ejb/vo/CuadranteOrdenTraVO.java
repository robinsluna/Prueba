package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdenTra;

import java.util.List;

/**
 * Value Objecto para gestionar los cuadrantes de las órdenes de trabajo de visita
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class CuadranteOrdenTraVO {
    private String cotActivo;
    private Long cotCodigo;
    private String cotLimite1;
    private String cotLimite2;
    private String cotLimite3;
    private String cotLimite4;
    private OrdenTrabajoVisitaVO ordenTrabajoVisitaVO;
    
    private List<CuadranteOrdTraInfVerVO> listCuadranteOrdTraInfVerVo;

    /**
     * Constructor.
     */
    public CuadranteOrdenTraVO() {
     
    }
    
    /**
     * Constructor.
     * @param siiCuadranteOrdenTra
     */
    public CuadranteOrdenTraVO(SiiCuadranteOrdenTra siiCuadranteOrdenTra) {
        this.cotActivo = siiCuadranteOrdenTra.getCotActivo();
        this.cotCodigo = siiCuadranteOrdenTra.getCotCodigo();
        this.cotLimite1 = siiCuadranteOrdenTra.getCotLimite1();
        this.cotLimite2 = siiCuadranteOrdenTra.getCotLimite2();
        this.cotLimite3 = siiCuadranteOrdenTra.getCotLimite3();
        this.cotLimite4 = siiCuadranteOrdenTra.getCotLimite4();
        
        if (siiCuadranteOrdenTra.getSiiOrdenTrabajoVisita()!=null)
            this.ordenTrabajoVisitaVO = new OrdenTrabajoVisitaVO(siiCuadranteOrdenTra.getSiiOrdenTrabajoVisita());
    }


    public String getCotActivo() {
        return cotActivo;
    }

    public Long getCotCodigo() {
        return cotCodigo;
    }

    public String getCotLimite1() {
        return cotLimite1;
    }

    public String getCotLimite2() {
        return cotLimite2;
    }

    public String getCotLimite3() {
        return cotLimite3;
    }

    public String getCotLimite4() {
        return cotLimite4;
    }

    public OrdenTrabajoVisitaVO getOrdenTrabajoVisitaVO() {
        return ordenTrabajoVisitaVO;
    }

    public void setCotActivo(String cotActivo) {
        this.cotActivo = cotActivo;
    }

    public void setCotCodigo(Long cotCodigo) {
        this.cotCodigo = cotCodigo;
    }

    public void setCotLimite1(String cotLimite1) {
        this.cotLimite1 = cotLimite1;
    }

    public void setCotLimite2(String cotLimite2) {
        this.cotLimite2 = cotLimite2;
    }

    public void setCotLimite3(String cotLimite3) {
        this.cotLimite3 = cotLimite3;
    }

    public void setCotLimite4(String cotLimite4) {
        this.cotLimite4 = cotLimite4;
    }

    public void setOrdenTrabajoVisitaVO(OrdenTrabajoVisitaVO ordenTrabajoVisitaVO) {
        this.ordenTrabajoVisitaVO = ordenTrabajoVisitaVO;
    }


    public void setListCuadranteOrdTraInfVerVo(List<CuadranteOrdTraInfVerVO> listCuadranteOrdTraInfVerVo){
        this.listCuadranteOrdTraInfVerVo = listCuadranteOrdTraInfVerVo;
    }

    public List<CuadranteOrdTraInfVerVO> getListCuadranteOrdTraInfVerVo(){
        return listCuadranteOrdTraInfVerVo;
    }
}
