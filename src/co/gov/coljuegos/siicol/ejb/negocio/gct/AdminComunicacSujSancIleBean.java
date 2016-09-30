/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 21-04-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ComunicacSujSancIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComunicacSujSancIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ComunicacSujSancIleVO;

import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona las comunicaciones del sujeto sancionatorio
 * @author Paola Andrea Rueda León
 */

@Stateless
public class AdminComunicacSujSancIleBean implements AdminComunicacSujSancIle {
    
    @EJB
    private ComunicacSujSancIleDAO comunicacSujSancIleDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    /**
     * Constructor
     */
    public AdminComunicacSujSancIleBean() {
        super();
    }
    
    /**
     * Insertar la comunicación del sujeto sancionable 
     * @param comunicacSujSancIleVo
     * @return resultado - ComunicacSujSancIleVO ya insertado en la BD
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public ComunicacSujSancIleVO insertarComunicacSujSancIle(ComunicacSujSancIleVO comunicacSujSancIleVo) throws ExcepcionDAO, ExcepcionAplicacion {
        ComunicacSujSancIleVO resultado = null;
        
        try {
            SiiComunicacSujSancIle siiComunicacSujSancIle = comunicacSujSancIleDao.insertar(conversionVoEntidad.convertir(comunicacSujSancIleVo));
            if (siiComunicacSujSancIle!=null) {
                resultado = new ComunicacSujSancIleVO(siiComunicacSujSancIle);
            }
        }
        catch(ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Comunicación del Sujeto Sancionable: "+e.getMessage());
        }
        
        return (resultado);
    }
    
    /**
     * Buscar las comunicaciones por determinar sujeto sancionable según id del proceso de ilegalidad
     * @param prsCodigo
     * @return resultado - Lista de ComunicacSujSancIleVO
     * @throws ExcepcionDAO
     */
    
    public List<ComunicacSujSancIleVO> buscarComunicacSujSancIleXIdProceso(Long prsCodigo) throws ExcepcionDAO{
        List<ComunicacSujSancIleVO> resultado = null;
        List<SiiComunicacSujSancIle> lista = comunicacSujSancIleDao.buscarComunicacSujSancIleXIdProceso(prsCodigo);
        
        if (lista!=null) {
            resultado = new ArrayList<ComunicacSujSancIleVO>();
            for (SiiComunicacSujSancIle siiComunicacSujSancIle: lista) {
                if (siiComunicacSujSancIle!=null)
                    resultado.add(new ComunicacSujSancIleVO(siiComunicacSujSancIle));
            }
        }
        
        return (resultado);
    }
}
