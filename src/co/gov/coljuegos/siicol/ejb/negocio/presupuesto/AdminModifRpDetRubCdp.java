package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ModifRpDetRubCdpVO;

import java.math.BigDecimal;

import java.util.List;


public interface AdminModifRpDetRubCdp {
    public List<ModifRpDetRubCdpVO> listaModifRpDetRubCdp(Long mrpCodigo) throws ExcepcionDAO;

    public List<ModifRpDetRubCdpVO> listaModifRpDetRubCdpPorRpDetRubroCdp(Long rdrCodigo) throws ExcepcionDAO;

    public BigDecimal valorDecRpDetRubCdpAprobado(Long dcrCodigo, Long rpCodigo) throws ExcepcionDAO;

    public BigDecimal valorIncRpDetRubCdpAprobado(Long dcrCodigo, Long rpCodigo) throws ExcepcionDAO;

    public BigDecimal valorDecRpPorDetRubRpAprobados(Long rdrCodigo) throws ExcepcionDAO;

    public BigDecimal valorIncRpPorDetRubRpAprobados(Long rdrCodigo) throws ExcepcionDAO;
    /* public BigDecimal valorNotasCreditoSinReconocimiento(Long dcrCodigo) throws ExcepcionDAO ;
    public BigDecimal valorReintegrosNotasCreditoConReconocimiento(Long dcrCodigo) throws ExcepcionDAO ; */
}
