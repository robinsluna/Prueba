/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 30-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteResolDecDesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenTrabajoVisita;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolDecDes;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.OrdenTrabajoVisitaVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolDecDesVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona los tr�mites de resoluci�n de decomiso y destrucci�n
 * @author PAOLA ANDREA RUEDA LE�N
 */

@Stateless
public class AdminTramiteResolDecDesBean implements AdminTramiteResolDecDes {

    @EJB
    private TramiteResolDecDesDAO tramiteResolDecDesDao;
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    /**
     * Constructor.
     */

    public AdminTramiteResolDecDesBean() {
        super();
    }

    /**
     * Buscar tr�mite de resoluci�n de decomiso y destrucci�n por id de resoluci�n y por id de estado
     * @param rddCodigo
     * @param etdCodigo
     * @return resultado - lista de tr�mites
     * @throws ExcepcionDAO
     */

    public List<TramiteResolDecDesVO> buscarTramiteResolDecDesXIdResolucionXIdEstado(Long rddCodigo,
                                                                                     Long etdCodigo) throws ExcepcionDAO {
        List<TramiteResolDecDesVO> resultado = null;
        List<SiiTramiteResolDecDes> lista =
            tramiteResolDecDesDao.buscarTramiteResolDecDesXIdResolucionXIdEstado(rddCodigo, etdCodigo);
        if (lista != null) {
            resultado = new ArrayList<TramiteResolDecDesVO>();
            for (SiiTramiteResolDecDes siiTramiteResolDecDes : lista) {
                if (siiTramiteResolDecDes != null)
                    resultado.add(new TramiteResolDecDesVO(siiTramiteResolDecDes));
            }
        }

        return (resultado);
    }
    
    /**
     * Insertar el tr�mite de resoluci�n de decomiso y destrucci�n
     * @param tramiteResolDecDesVo
     * @return resultado - VO insertado en la BD
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public TramiteResolDecDesVO insertarTramiteResolDecDes(TramiteResolDecDesVO tramiteResolDecDesVo) throws ExcepcionDAO, ExcepcionAplicacion {
        TramiteResolDecDesVO resultado = null;

        try {
            SiiTramiteResolDecDes siiTramiteResolDecDes = tramiteResolDecDesDao.insertar(conversionVoEntidad.convertir(tramiteResolDecDesVo));
            if(siiTramiteResolDecDes != null) {
                resultado = new TramiteResolDecDesVO(siiTramiteResolDecDes);

            }
        } catch( ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar el tr�mite de la resoluci�n de decomiso y destrucci�n: " + e.getMessage());
        }
        return (resultado);
    }
    
    /**
     * Actualizar el tr�mite de la resoluci�n de decomiso y destrucci�n
     * @param tramiteResolDecDesVo
     * @return resultado - TramiteResolDecDesVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public TramiteResolDecDesVO actualizarTramiteResolDecDes(TramiteResolDecDesVO tramiteResolDecDesVo) throws ExcepcionDAO, ExcepcionAplicacion {
        TramiteResolDecDesVO resultado = null;

        try {
            SiiTramiteResolDecDes siiTramiteResolDecDes = tramiteResolDecDesDao.actualizar(conversionVoEntidad.convertir(tramiteResolDecDesVo));
            if(siiTramiteResolDecDes != null) {
                resultado = new TramiteResolDecDesVO(siiTramiteResolDecDes);

            }
        } catch( ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar el tr�mite de la resoluci�n de decomiso y destrucci�n: " + e.getMessage());
        }
        return (resultado);
    }
}
