/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 15-05-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminObligacion;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaNominaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaNomina;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CargaNominaVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleContNominaVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminCargaNominaBean implements AdminCargaNomina {
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    @EJB
    private CargaNominaDAO cargaNominaDao;
    
    @EJB
    AdminObligacion adminObligacion;
    
    
    
    /**
     * Constructor.
     */
    public AdminCargaNominaBean() {
        super();
    }
    
    
    @Override
    public CargaNominaVO buscarCargaNominaPorId(Long cnoCodigo) throws ExcepcionDAO {
        CargaNominaVO resultado = null;
        SiiCargaNomina siiCargaNomina = cargaNominaDao.buscarPorCodigo(cnoCodigo);
        if (siiCargaNomina!=null)
            resultado = new CargaNominaVO(siiCargaNomina);
        
        return (resultado);
    }
    

    @Override
    public List<CargaNominaVO> buscarTodoCargaNomina() throws ExcepcionDAO {
        List<CargaNominaVO> resultado = null;
        List<SiiCargaNomina> lista = cargaNominaDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<CargaNominaVO>();
            for (SiiCargaNomina siiCargaNomina: lista) {
                if (siiCargaNomina!=null) {
                    resultado.add(new CargaNominaVO(siiCargaNomina));
                }
            }
        }
        return (resultado);
    }
    
    
    @Override
    public CargaNominaVO insertarCargaNomina(CargaNominaVO cargaNominaVo) throws ExcepcionDAO, ExcepcionAplicacion {
        CargaNominaVO resultado = null;
        SiiCargaNomina siiCargaNomina = cargaNominaDao.insertar(conversionVoEntidad.convertir(cargaNominaVo));
        if (siiCargaNomina!=null) {
            resultado = new CargaNominaVO(siiCargaNomina);
            resultado.setObligacionList(cargaNominaVo.getObligacionList());
            
            // adicionar el carga nomina a cada detalle de nomina asociado dentro de cada obligacion
            if (resultado.getObligacionList()!=null && !resultado.getObligacionList().isEmpty()) {
                for (ObligacionVO oblVo: resultado.getObligacionList()) {
                    if (oblVo!=null && oblVo.getDetalleContNominaList()!=null) {
                        // recorrer cada detalle de nomina para asignar el registro carga nomina
                        for (DetalleContNominaVO dcnVo: oblVo.getDetalleContNominaList()) {
                            if (dcnVo!=null)
                                dcnVo.setCargaNominaVo(resultado);
                        }
                    }
                }
            }
            
            this.persistirObligaciones(resultado);
        }
        
        return (resultado);
    }
    
    
    @Override
    public CargaNominaVO actualizarCargaNomina(CargaNominaVO cargaNominaVo) throws ExcepcionDAO {
        CargaNominaVO resultado = null;
        SiiCargaNomina siiCargaNomina = cargaNominaDao.actualizar(conversionVoEntidad.convertir(cargaNominaVo));
        if (siiCargaNomina!=null)
            resultado = new CargaNominaVO(siiCargaNomina);
        
        return (resultado);
    }
    
    
    @Override
    public void borrarCargaNomina(Long cnoCodigo) throws ExcepcionDAO {
        cargaNominaDao.eliminar(cnoCodigo);
    }
    
    
    @Override
    public CargaNominaVO buscarPorNombreArchivo(String cnoNombreArch) throws ExcepcionDAO {
        CargaNominaVO cargaNominaVo = null;
        SiiCargaNomina siiCargaNomina = cargaNominaDao.buscarPorNombreArchivo(cnoNombreArch);
        if (siiCargaNomina!=null)
            cargaNominaVo = new CargaNominaVO(siiCargaNomina);
        
        return (cargaNominaVo);
    }
    
    
    
    /**
     * Almacena el listado de Obligaciones que hacen parte de la entidad Carga N&oacute;mina.
     * @throws ExcepcionDAO
     */
    private void persistirObligaciones (CargaNominaVO cargaNominaVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        if (cargaNominaVo!=null && cargaNominaVo.getObligacionList()!=null) {
            for (ObligacionVO obligacionVo: cargaNominaVo.getObligacionList()) {
                obligacionVo.setCargaNominaVo(cargaNominaVo);
                
                if (obligacionVo.getOblCodigo()==null) {
                    // OPERACION INSERTAR
                    adminObligacion.insertarObligacion(obligacionVo);
                }
                else {
                    // OPERACION ACTUALIZAR
                    adminObligacion.actualizarObligacion(obligacionVo);
                }
            }
        }
    }

    public Long buscarUltimoConsecutivo(Calendar calendar) throws ExcepcionDAO {
        return (cargaNominaDao.buscarUltimoConsecutivo(calendar));
    }

    public Long buscarUltimoConsecutivo(Date fecha) throws ExcepcionDAO {
        return (cargaNominaDao.buscarUltimoConsecutivo(fecha));
    }

    public Long buscarUltimoConsecutivo(String formatoFecha) throws ExcepcionDAO {
        return (cargaNominaDao.buscarUltimoConsecutivo(formatoFecha));
    }

    public List<CargaNominaVO> buscarCargaNominaSinOrdenPago() throws ExcepcionDAO {
        List<CargaNominaVO> resultado = null;
        List<SiiCargaNomina> lista = cargaNominaDao.buscarCargaNominaSinOrdenPago();
        if (lista!=null) {
            resultado = new ArrayList<CargaNominaVO>();
            for (SiiCargaNomina siiCargaNomina: lista) {
                if (siiCargaNomina!=null) {
                    resultado.add(new CargaNominaVO(siiCargaNomina));
                }
            }
        }
        return (resultado);
    }

    public List<CargaNominaVO> buscarCargaNominaConOrdenPagoPendientes() throws ExcepcionDAO {
        List<CargaNominaVO> resultado = null;
        List<SiiCargaNomina> lista = cargaNominaDao.buscarCargaNominaConOrdenPagoPendientes();
        if (lista!=null) {
            resultado = new ArrayList<CargaNominaVO>();
            for (SiiCargaNomina siiCargaNomina: lista) {
                if (siiCargaNomina!=null) {
                    resultado.add(new CargaNominaVO(siiCargaNomina));
                }
            }
        }
        return (resultado);
    }
}
