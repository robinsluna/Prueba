/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Contabilidad
 * AUTOR	: Walter Becerra
 * FECHA	: 17-03-2014
 */


package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CierreMensualDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreContable;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CierreMensualVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminCierreMensualBean implements AdminCierreMensual {
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    CierreMensualDAO cierreMensualDao;

    public AdminCierreMensualBean() {

    }

    public CierreMensualVO insertarCierreContable(CierreMensualVO cierreMensualVo) throws ExcepcionDAO {
        return new CierreMensualVO(cierreMensualDao.insertarCierreContable(conversionVoEntidad.convertir(cierreMensualVo)));
    }

    public CierreMensualVO procesoCierreContable(CierreMensualVO cierreMensualVo) throws ExcepcionDAO {
        cierreMensualVo = insertarCierreContable(cierreMensualVo);
        cierreMensualDao.insertarDetalleCierre(cierreMensualVo.getCicVigencia(),
                                               cierreMensualVo.getMesVo().getMesCodigo(),
                                               cierreMensualVo.getCicCodigo());

        return cierreMensualVo;
    }

    public String proveedoresNulosEnCierreMensual(Integer vigencia, Integer mes) throws ExcepcionDAO  {
        return cierreMensualDao.proveedoresNulosEnCierreMensual(vigencia, mes);
    }
    
    public List<CierreMensualVO> buscarTodoCierreContable() throws ExcepcionDAO {
        List<CierreMensualVO> listaCierreMensualVo = new ArrayList();
        List<SiiCierreContable> listaSiiCierreContable = cierreMensualDao.buscarTodoCierreContable();
        for (SiiCierreContable unSiiCierreContable : listaSiiCierreContable) {
            CierreMensualVO nuevoCierreMensualVo = new CierreMensualVO(unSiiCierreContable);
            listaCierreMensualVo.add(nuevoCierreMensualVo);
        }
        return listaCierreMensualVo;
    }

    public CierreMensualVO buscarUltimoCierreContable() throws ExcepcionDAO {
        List<CierreMensualVO> cierresMensuales = buscarTodoCierreContable();
        if (cierresMensuales.size() > 0)
            return cierresMensuales.get(0);
        else
            return new CierreMensualVO();

    }

    public CierreMensualVO actualizarCierreContable(CierreMensualVO cierreMensualVo) throws ExcepcionDAO {
        SiiCierreContable siiCierreContable = conversionVoEntidad.convertir(cierreMensualVo);
        siiCierreContable = cierreMensualDao.actualizarCierreContable(siiCierreContable);
        return new CierreMensualVO(siiCierreContable);
    }

    public CierreMensualVO buscarCierreContablePorId(Long idCierre) throws ExcepcionDAO {
        SiiCierreContable siiCierreContable = cierreMensualDao.buscarCierreContablePorId(idCierre);
        return new CierreMensualVO(siiCierreContable);
    }


    public boolean isMesCerrado(Date fecha) throws ExcepcionDAO {
        return (cierreMensualDao.isMesCerrado(fecha));
    }
}
