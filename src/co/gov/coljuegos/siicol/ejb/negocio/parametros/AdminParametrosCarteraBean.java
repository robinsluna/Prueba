package co.gov.coljuegos.siicol.ejb.negocio.parametros;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TasaIntSuperbanDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.TasaInteresLegalCivilDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaIntSuperban;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteresLegalCivil;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TasaIntSuperbanVO;

import co.gov.coljuegos.siicol.ejb.vo.TasaInteresLegalCivilVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminParametrosCarteraBean implements AdminParametrosCartera {
    @EJB
    private TasaIntSuperbanDAO tasaIntSuperbanDAO;
    @EJB
    private TasaInteresLegalCivilDAO tasaInteresLegalCivilDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;


    /**
     *Metodo encargado de hacer el registro de una tasa de intereses
     * @author David Tafur
     * @param tasaIntSuperbanVO
     * @return
     * @throws ExcepcionDAO
     */
    public TasaIntSuperbanVO insertarSiiTasaIntSuperban(TasaIntSuperbanVO tasaIntSuperbanVO) throws ExcepcionDAO {
        SiiTasaIntSuperban siiTasaIntSuperban = new SiiTasaIntSuperban();
        siiTasaIntSuperban = conversionVoEntidad.convertir(tasaIntSuperbanVO);
        return new TasaIntSuperbanVO(tasaIntSuperbanDAO.insertarSiiTasaIntSuperban(siiTasaIntSuperban));
    }

    /**
     *Metodo encargado de hacer la actualizacion de una tasa de intereses
     * @author David Tafur
     * @param tasaIntSuperbanVO
     * @return
     * @throws ExcepcionDAO
     */
    public TasaIntSuperbanVO actualizarSiiTasaIntSuperban(TasaIntSuperbanVO tasaIntSuperbanVO) throws ExcepcionDAO {
        SiiTasaIntSuperban siiTasaIntSuperban = new SiiTasaIntSuperban();
        siiTasaIntSuperban = conversionVoEntidad.convertir(tasaIntSuperbanVO);
        return new TasaIntSuperbanVO(tasaIntSuperbanDAO.actualizarSiiTasaIntSuperban(siiTasaIntSuperban));
    }

    /**
     *Metodo encargado de consulta el listado de tasas interes
     * @author David Tafur
     * @return
     * @throws ExcepcionDAO
     */
    public List<TasaIntSuperbanVO> consultarListaTasaIntSuperban() throws ExcepcionDAO {
        List<TasaIntSuperbanVO> listaTasaIntSuperbanVO = new ArrayList<TasaIntSuperbanVO>();
        for (SiiTasaIntSuperban siiTasaIntSuperban : tasaIntSuperbanDAO.consultarListaTasaIntSuperban()) {
            listaTasaIntSuperbanVO.add(new TasaIntSuperbanVO(siiTasaIntSuperban));
        }
        return listaTasaIntSuperbanVO;
    }
    
    
    @Override
    public TasaIntSuperbanVO consultarTasaIntSuperbanActiva() throws ExcepcionDAO {
        TasaIntSuperbanVO resultado = null;
        SiiTasaIntSuperban siiTasaIntSuperban = tasaIntSuperbanDAO.consultarTasaIntSuperbanActiva();
        if (siiTasaIntSuperban!=null)
            resultado = new TasaIntSuperbanVO(siiTasaIntSuperban);
        
        return (resultado);
    }
    
    @Override
    public TasaInteresLegalCivilVO buscarTasaInteresLegalCivilActiva () throws ExcepcionDAO {
        TasaInteresLegalCivilVO resultado = null;
        SiiTasaInteresLegalCivil siiTasaInteresLegalCivil = tasaInteresLegalCivilDao.buscarTasaInteresLegalCivilActiva();
        if (siiTasaInteresLegalCivil!=null)
            resultado = new TasaInteresLegalCivilVO(siiTasaInteresLegalCivil);
        
        return (resultado);
    }
}
