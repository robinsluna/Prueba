/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Mónica Pabón
 * FECHA	: 18-11-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AcuerdoPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BalancePruebaDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HlpCuotaAcuerdoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HlpCuotaOpCuoAcuDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionNoPresupDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TasaIntSuperbanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAcuerdoPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaAcuerdo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaOpCuoAcu;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImpContabOblNoPres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaIntSuperban;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AcuerdoPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.BalancePruebaVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.FiltrosBalancePruebaVO;

import co.gov.coljuegos.siicol.ejb.vo.HlpCuotaAcuerdoVO;
import co.gov.coljuegos.siicol.ejb.vo.HlpCuotaOpCuoAcuVO;
import co.gov.coljuegos.siicol.ejb.vo.ImpContabOblNoPresVO;
import co.gov.coljuegos.siicol.ejb.vo.TasaIntSuperbanVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminAcuerdoPagoBean implements AdminAcuerdoPago{
    @EJB 
    ConversionVOEntidad conversionVoEntidad; 
    @EJB
    private AcuerdoPagoDAO acuerdoPagoDao;
    @EJB
    private TasaIntSuperbanDAO tasaIntSuperbanDAO;
    @EJB
    private CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    private HlpCuotaAcuerdoDAO hlpCuotaAcuerdoDao;
    @EJB
    private HlpCuotaOpCuoAcuDAO hlpCuotaOpCuoAcuDao;
    
    public AdminAcuerdoPagoBean() {        
    }
    
    /**
     * Genera el listado de acuerdos de pago.
     * @return List of AcuerdoPagoVO
     * @throws ExcepcionDAO
     */
    public List<AcuerdoPagoVO> buscarTodoAcuerdoPago() throws ExcepcionDAO {
        List<AcuerdoPagoVO> listaAcuerdosVo = new  ArrayList<AcuerdoPagoVO>();
        List<SiiAcuerdoPago> listaSiiAcuerdoPago = acuerdoPagoDao.buscarTodoAcuerdoPago();
        if(listaSiiAcuerdoPago!= null && listaSiiAcuerdoPago.size()> 0){
            for(SiiAcuerdoPago unSiiAcuerdoPago : listaSiiAcuerdoPago){
                if(unSiiAcuerdoPago!= null){
                    listaAcuerdosVo.add(new AcuerdoPagoVO(unSiiAcuerdoPago));
                }
            }
        }
        return (listaAcuerdosVo);
    }
    
    /**
     *Metodo encargado de consultar el consecutivo de acuerdos de pago    
     * @return consecutivo
     * @throws ExcepcionDAO
     */
    public Long consultarConsecutivoAcuerdo() throws ExcepcionDAO {
        return acuerdoPagoDao.consultarConsecutivoAcuerdo();
    }
    /**
     *Metodo encargado de insertar el acuerdo de pago    
     * @return AcuerdoPagoVO
     * @throws ExcepcionDAO
     */
    public AcuerdoPagoVO insertarAcuerdoPago(AcuerdoPagoVO acuerdoPagoVO,List<HlpCuotaAcuerdoVO> listaCuotasNuevas) throws ExcepcionDAO {
        SiiAcuerdoPago siiResultadoAcuerdoPago = acuerdoPagoDao.insertarSiiAcuerdoPago(conversionVoEntidad.convertir(acuerdoPagoVO));
        // Se insertan las nuevas cuotas resultado de la amortización
        if(listaCuotasNuevas!= null && listaCuotasNuevas.size()> 0){
            for(HlpCuotaAcuerdoVO unVo : listaCuotasNuevas){
                SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo = conversionVoEntidad.convertir(unVo);
                siiHlpCuotaAcuerdo.setSiiAcuerdoPago(siiResultadoAcuerdoPago);
                SiiHlpCuotaAcuerdo resulSiiHlpCuotaAcuerdo = hlpCuotaAcuerdoDao.insertarSiiHlpCuotaAcuerdo(siiHlpCuotaAcuerdo);  
                if(unVo.getHlpCuotaOpCuoAcuListVO().size() > 0){
                    for(HlpCuotaOpCuoAcuVO unHlpCuoAcu : unVo.getHlpCuotaOpCuoAcuListVO() ){
                        SiiHlpCuotaOpCuoAcu siiHlpCuotaOpCuoAcu = conversionVoEntidad.convertir(unHlpCuoAcu);
                        siiHlpCuotaOpCuoAcu.setSiiHlpCuotaAcuerdo(resulSiiHlpCuotaAcuerdo);
                        SiiHlpCuotaOpCuoAcu resulSiiHlpCuotaOpCuoAcu = hlpCuotaOpCuoAcuDao.insertarSiiHlpCuotaOpCuoAcu(siiHlpCuotaOpCuoAcu);
                    }
                }
            }
        }
       
        return new AcuerdoPagoVO(siiResultadoAcuerdoPago);
    }
    /**
     *Metodo encargado de consultar un acuerdo de pago 
     * @ param Long
     * @return AcuerdoPagoVO
     * @throws ExcepcionDAO
     */
    public AcuerdoPagoVO buscarAcuerdoPagoPorCodigo(Long idAcuerdo) throws ExcepcionDAO {
        return (new AcuerdoPagoVO(acuerdoPagoDao.buscarAcuerdoPagoPorCodigo(idAcuerdo)));    
    }
    /**
     *Metodo encargado de consultar las cuotas de un acuerdo de pago 
     * @ param Long
     * @return List<HlpCuotaAcuerdoVO>
     * @throws ExcepcionDAO
     */
    public List<HlpCuotaAcuerdoVO> buscarCuotasPorNumeroAcuerdoPago (Long idAcuerdoPago) throws ExcepcionDAO {
            List<HlpCuotaAcuerdoVO> listaHlpCuotaAcuerdoVo = new ArrayList();
            List<SiiHlpCuotaAcuerdo> listaSiiHlpCuotaAcuerdo = null;
            listaSiiHlpCuotaAcuerdo = hlpCuotaAcuerdoDao.buscarCuotasPorNumeroAcuerdoPago(idAcuerdoPago);
            if(listaSiiHlpCuotaAcuerdo.size() > 0){
                for(SiiHlpCuotaAcuerdo unSiiHlpAcuerdo : listaSiiHlpCuotaAcuerdo){
                    listaHlpCuotaAcuerdoVo.add(new HlpCuotaAcuerdoVO(unSiiHlpAcuerdo));
                }
            }
            return listaHlpCuotaAcuerdoVo;
        }
}
