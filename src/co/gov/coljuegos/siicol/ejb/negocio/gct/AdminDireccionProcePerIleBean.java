/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 17-03-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionProcePerIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionProcePerIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DireccionProcePerIleVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionVO;

import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona las direcciones procesales de las personas investigadas
 * @author Paola Andrea Rueda León
 */

@Stateless
public class AdminDireccionProcePerIleBean implements AdminDireccionProcePerIle {

    @EJB
    private DireccionProcePerIleDAO direccionProcePerIleDao;
    @EJB
    private AdminDireccion adminDireccion;
    @EJB
    private AdminPersonaInvestProIle adminPersonaInvestProIle;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    /**
     * Constructor
     */
    public AdminDireccionProcePerIleBean() {
        super();
    }

    /**
     * Asignar los hijos
     * @param resultado
     * @param direccionProcePerIleVo
     */

    private void asignarHijos(DireccionProcePerIleVO resultado, DireccionProcePerIleVO direccionProcePerIleVo) {
        if(resultado != null && direccionProcePerIleVo != null) {

            // establecer hijos
            resultado.setDireccionVo(direccionProcePerIleVo.getDireccionVo());
            resultado.setPersonaInvestProIleVo(direccionProcePerIleVo.getPersonaInvestProIleVo());
            resultado.setUbicacionVo(direccionProcePerIleVo.getUbicacionVo());
            resultado.setUsuarioConecVo(direccionProcePerIleVo.getUsuarioConecVo());

        }
    }

    /**
     * Persistir la dirección
     * @param direccionProcePerIleVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    private DireccionVO persistirDireccionVo(DireccionProcePerIleVO direccionProcePerIleVo) throws ExcepcionDAO, ExcepcionAplicacion {
        DireccionVO direccion = new DireccionVO();

        if(direccionProcePerIleVo.getDireccionVo().getDirCodigo() == null) {

            // OPERACION INSERTAR
            direccion = adminDireccion.insertarDireccion(direccionProcePerIleVo.getDireccionVo());
        }
        else {
            // OPERACION ACTUALIZAR
            direccion = adminDireccion.actualizarDireccion(direccionProcePerIleVo.getDireccionVo());
        }
        return direccion;
    }

    private void persistirHijos(DireccionProcePerIleVO direccionProcePerIleVo) throws ExcepcionDAO, ExcepcionAplicacion {

    }

    /**
     * Insertar la dirección procesal de la persona investigada en la BD
     * @param direccionProcePerIleVo
     * @return resultado - DireccionProcePerIleVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public DireccionProcePerIleVO insertarDireccionProcePerIle(DireccionProcePerIleVO direccionProcePerIleVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion {
        DireccionProcePerIleVO resultado = null;

        try {

            if(cascadeUpdate) {
                this.asignarHijos(resultado, direccionProcePerIleVo);
                //this.persistirHijos(direccionProcePerIleVo);
                direccionProcePerIleVo.setDireccionVo(this.persistirDireccionVo(direccionProcePerIleVo));
            }

            SiiDireccionProcePerIle siiDireccionProcePerIle = direccionProcePerIleDao.insertar(conversionVoEntidad.convertir(direccionProcePerIleVo));
            if(siiDireccionProcePerIle != null) {
                resultado = new DireccionProcePerIleVO(siiDireccionProcePerIle);


            }
        } catch(ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Dirección Procesal de la Persona Investigada: " + e.getMessage());
        }

        return (resultado);
    }
    
    /**
     * Actualizar la dirección procesal de la persona investigada del proceso de ilegalidad
     * @param direccionProcePerIleVo
     * @return resultado - DireccionProcePerIleVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public DireccionProcePerIleVO actualizarDireccionProcePerIle(DireccionProcePerIleVO direccionProcePerIleVo) throws ExcepcionDAO, ExcepcionAplicacion {
        DireccionProcePerIleVO resultado = null;
        
        try {
            SiiDireccionProcePerIle siiDireccionProcePerIle = direccionProcePerIleDao.actualizar(conversionVoEntidad.convertir(direccionProcePerIleVo));
            if (siiDireccionProcePerIle!=null) {
                resultado = new DireccionProcePerIleVO(siiDireccionProcePerIle);
                adminDireccion.actualizarDireccion(direccionProcePerIleVo.getDireccionVo());
            }
        }
        catch(ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar la dirección procesal: "+e.getMessage());
        }
        
        return (resultado);
    }

    /**
     * Buscar las direcciones procesales según id de la persona investigada
     * @param pipCodigo
     * @return resultado - Lista de DireccionProcePerIleVO
     * @throws ExcepcionDAO
     */

    public List<DireccionProcePerIleVO> buscarDireccionProcePerIleXIdPerInvest(Long pipCodigo) throws ExcepcionDAO {
        List<DireccionProcePerIleVO> resultado = null;
        List<SiiDireccionProcePerIle> lista = direccionProcePerIleDao.buscarDireccionProcePerIleXIdPerInvest(pipCodigo);
        if(lista != null) {
            resultado = new ArrayList<DireccionProcePerIleVO>();
            for(SiiDireccionProcePerIle siiDireccionProcePerIle : lista) {
                if(siiDireccionProcePerIle != null)
                    resultado.add(new DireccionProcePerIleVO(siiDireccionProcePerIle));
            }
        }

        return (resultado);
    }
}
