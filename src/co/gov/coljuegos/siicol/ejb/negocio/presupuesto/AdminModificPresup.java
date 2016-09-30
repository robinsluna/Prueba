/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ModificPresupVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n de la Modificaci&oacute;n Presupuestal.
 * @author Camilo Miranda
 */
@Local
public interface AdminModificPresup {
    public ModificPresupVO buscarModificPresupPorId(Long idMprCodigo) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param modificPresupVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public ModificPresupVO actualizarModificPresup(ModificPresupVO modificPresupVo,
                                                   UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion;

    public ModificPresupVO insertarModificPresup(ModificPresupVO modificPresupVo) throws ExcepcionDAO;

    public List<ModificPresupVO> buscarTodaModificPresup() throws ExcepcionDAO;

    public List<ModificPresupVO> buscarModificPresupPorEstado(Long empCodigo) throws ExcepcionDAO;

    public List<ModificPresupVO> buscarModificPresupPorTipoYEstado(String mprTipo, Long empCodigo) throws ExcepcionDAO;

    public List<ModificPresupVO> buscarTodoTrasladoPresupuestal() throws ExcepcionDAO;

    public List<ModificPresupVO> buscarTrasladoPresupuestalPorEstado(Long empCodigo) throws ExcepcionDAO;

    public List<ModificPresupVO> buscarTodaAdicionPresupuestal() throws ExcepcionDAO;

    public List<ModificPresupVO> buscarAdicionPresupuestalPorEstado(Long empCodigo) throws ExcepcionDAO;

    public List<ModificPresupVO> buscarTodaReduccionPresupuestal() throws ExcepcionDAO;

    public List<ModificPresupVO> buscarReduccionPresupuestalPorEstado(Long empCodigo) throws ExcepcionDAO;

    public Long generarConsecutivoModificPresup() throws ExcepcionDAO;
    
    public BigDecimal valorAdicionesPorDruCodigo(Long druCodigo) throws ExcepcionDAO;
    
    public BigDecimal valorReduccionesPorDruCodigo(Long druCodigo) throws ExcepcionDAO ;
    
    public BigDecimal valorCreditoPorDruCodigo(Long druCodigo) throws ExcepcionDAO;
    
    public BigDecimal valorContracreditoPorDruCodigo(Long druCodigo) throws ExcepcionDAO;
    
    public BigDecimal obtenerSaldoDetalleRubroModificPresup (Long druCodigo) throws ExcepcionDAO;
}
