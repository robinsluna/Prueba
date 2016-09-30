/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 07-03-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ComunicResolPersIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComunicResolPersIle;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ComunicResolPersIleVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que maneja las comunicaciones de las resoluciones de personas investigadas
 * @author Paola Andrea Rueda León
 */

@Stateless
public class AdminComunicResolPersIleBean implements AdminComunicResolPersIle {

    @EJB
    private ComunicResolPersIleDAO comunicResolPersIleDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    /**
     * Constructor
     */

    public AdminComunicResolPersIleBean() {
        super();
    }

    /**
     * Insertar a la base de datos la comunicación de la resolución de las personas investigadas
     * @param comunicResolPersIleVo
     * @return
     * @throws ExcepcionDAO
     */

    public ComunicResolPersIleVO insertarComunicResolPersIle(ComunicResolPersIleVO comunicResolPersIleVo) throws ExcepcionDAO {
        ComunicResolPersIleVO resultado = null;
        SiiComunicResolPersIle siiComunicResolPersIle = comunicResolPersIleDao.insertar(conversionVoEntidad.convertir(comunicResolPersIleVo));
        if(siiComunicResolPersIle != null)
            resultado = new ComunicResolPersIleVO(siiComunicResolPersIle);

        return (resultado);
    }
    
    /**
     * Actualizar la comunición de la resolución de las personas investigadas
     * @param comunicResolPersIleVo
     * @return resultado - ComunicResolPersIleVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public ComunicResolPersIleVO actualizarComunicResolPersIle(ComunicResolPersIleVO comunicResolPersIleVo) throws ExcepcionDAO, ExcepcionAplicacion {
        ComunicResolPersIleVO resultado = null;

        try {
            SiiComunicResolPersIle siiComunicResolPersIle = comunicResolPersIleDao.actualizar(conversionVoEntidad.convertir(comunicResolPersIleVo));
            if(siiComunicResolPersIle != null) {
                resultado = new ComunicResolPersIleVO(siiComunicResolPersIle);
            }
        } catch(ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar la Comunicación de Personas Investigadas: " + e.getMessage());
        }

        return (resultado);
    }
    
    public List<ComunicResolPersIleVO> buscarComunicResolPersIlePorResolucion(Long rpiCodigo) throws ExcepcionDAO {
        List<ComunicResolPersIleVO> comunicacionesVo = new ArrayList<ComunicResolPersIleVO>();
        for (SiiComunicResolPersIle comunicacion :comunicResolPersIleDao.buscarComunicResolPersIlePorResolucion(rpiCodigo)) {
            comunicacionesVo.add(new ComunicResolPersIleVO(comunicacion));
        }
        return comunicacionesVo;
    }
}
