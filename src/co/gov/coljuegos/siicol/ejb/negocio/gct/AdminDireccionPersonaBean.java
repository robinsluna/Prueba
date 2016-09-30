/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 05-04-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DireccionPersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionVO;

import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona las direcciones de las personas
 * @author Paola Andrea Rueda León
 */

@Stateless
public class AdminDireccionPersonaBean implements AdminDireccionPersona {

    /**
     * Constructor
     */
    @EJB
    private DireccionPersonaDAO direccionPersonaDao;
    @EJB
    private AdminDireccion adminDireccion;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;


    public AdminDireccionPersonaBean() {
        super();
    }


    private DireccionVO persistirDireccion(DireccionPersonaVO direccionPersonaVO) throws ExcepcionDAO, ExcepcionAplicacion {

        DireccionVO resultado = null;
        if(direccionPersonaVO != null) {
            DireccionVO direccionVo = direccionPersonaVO.getDireccionVo();
            if(direccionVo != null) {
                if(direccionVo.getDirCodigo() == null) {
                    // OPERACION INSERTAR
                    resultado = adminDireccion.insertarDireccion(direccionVo);
                }
                else {
                    // OPERACION ACTUALIZAR
                    resultado = adminDireccion.actualizarDireccion(direccionVo);
                }
            }

        }
        return resultado;
    }

    /**
     * Insertar la dirección de la persona
     * @param direccionPersonaVO
     * @return resultado - DireccionPersonaVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public DireccionPersonaVO insertarDireccionPersona(DireccionPersonaVO direccionPersonaVO) throws ExcepcionDAO, ExcepcionAplicacion {
        DireccionPersonaVO resultado = null;

        try {

            DireccionVO direccionVo = this.persistirDireccion(direccionPersonaVO);
            direccionPersonaVO.setDireccionVo(direccionVo);
            SiiDireccionPersona siiDireccionPersona = direccionPersonaDao.insertar(conversionVoEntidad.convertir(direccionPersonaVO));
            if(siiDireccionPersona != null) {
                resultado = new DireccionPersonaVO(siiDireccionPersona);
            }
        } catch(ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Dirección de la Persona: " + e.getMessage());
        }

        return (resultado);
    }
    
    /**
     * Actualizar la dirección de la persona
     * @param direccionPersonaVO
     * @return resultado - DireccionPersonaVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public DireccionPersonaVO actualizarDireccionPersona(DireccionPersonaVO direccionPersonaVO, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion {
        DireccionPersonaVO resultado = null;

        try {
            SiiDireccionPersona siiDireccionPersona = direccionPersonaDao.actualizar(conversionVoEntidad.convertir(direccionPersonaVO));
            if(siiDireccionPersona != null) {
                resultado = new DireccionPersonaVO(siiDireccionPersona);
                resultado.setDireccionVo(direccionPersonaVO.getDireccionVo());
                if(cascade)
                    this.persistirDireccion(resultado);
            }
        } catch(ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar la dirección de la persona: " + e.getMessage());
        }

        return (resultado);
    }

    /**
     * Buscar la lista de direcciones según el id de la persona
     * @param perCodigo
     * @return resultado - Lista de DireccionPersonaVO
     * @throws ExcepcionDAO
     */

    public List<DireccionPersonaVO> buscarDireccionPersonaListXIdPersona(Long perCodigo) throws ExcepcionDAO {
        List<DireccionPersonaVO> resultado = null;
        List<SiiDireccionPersona> lista = direccionPersonaDao.buscarDireccionPersonaXIdPersona(perCodigo);
        if(lista != null) {
            resultado = new ArrayList<DireccionPersonaVO>();
            for(SiiDireccionPersona siiDireccionPersona : lista) {
                if(siiDireccionPersona != null)
                    resultado.add(new DireccionPersonaVO(siiDireccionPersona));
            }
        }
        return (resultado);
    }
}
