package co.gov.coljuegos.siicol.ejb.negocio.parametros;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.TasaIntSuperbanVO;

import co.gov.coljuegos.siicol.ejb.vo.TasaInteresLegalCivilVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminParametrosCartera {

    /**
     *Metodo encargado de hacer el registro de una tasa de intereses
     * @author David Tafur
     * @param tasaIntSuperbanVO
     * @return
     * @throws ExcepcionDAO
     */
    public TasaIntSuperbanVO insertarSiiTasaIntSuperban(TasaIntSuperbanVO tasaIntSuperbanVO) throws ExcepcionDAO;

    /**
     *Metodo encargado de hacer la actualizacion de una tasa de intereses
     * @author David Tafur
     * @param tasaIntSuperbanVO
     * @return
     * @throws ExcepcionDAO
     */
    public TasaIntSuperbanVO actualizarSiiTasaIntSuperban(TasaIntSuperbanVO tasaIntSuperbanVO) throws ExcepcionDAO;

    /**
     *Metodo encargado de consulta el listado de tasas interes
     * @author David Tafur
     * @return
     * @throws ExcepcionDAO
     */
    public List<TasaIntSuperbanVO> consultarListaTasaIntSuperban() throws ExcepcionDAO;
    
    
    public TasaIntSuperbanVO consultarTasaIntSuperbanActiva() throws ExcepcionDAO;
    
    public TasaInteresLegalCivilVO buscarTasaInteresLegalCivilActiva () throws ExcepcionDAO;
}
