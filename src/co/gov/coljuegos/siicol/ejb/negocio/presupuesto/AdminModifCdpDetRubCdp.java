package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ModifCdpDetRubCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudIncrementoCdpVO;

import java.math.BigDecimal;

import java.util.List;


public interface AdminModifCdpDetRubCdp {
    public List<ModifCdpDetRubCdpVO> listaModifCdpDetRubCdpPorModificacion(Long id) throws ExcepcionDAO;

    public List<ModifCdpDetRubCdpVO> listaModifCdpRubPorDetRubCdp(Long id) throws ExcepcionDAO;

    public List<SolicitudIncrementoCdpVO> buscarValorIncRubroCdpPorItemPlanContratIdCdp(Long idIpc,
                                                                                        Long idCdp) throws ExcepcionDAO;

    public BigDecimal valorDecCdpRubPorDetRubCdpAprobados(Long id) throws ExcepcionDAO;

    public BigDecimal valorIncCdpRubPorDetRubCdpAprobados(Long id) throws ExcepcionDAO;

    public ModifCdpDetRubCdpVO buscarModifCdpDetRubCdpBaseGMF(Long druCodigo) throws ExcepcionDAO;
    
    public List<ModifCdpDetRubCdpVO> rubrosFinanciadosConRecursosPropios(Long mcdCodigo) throws ExcepcionDAO;
}
