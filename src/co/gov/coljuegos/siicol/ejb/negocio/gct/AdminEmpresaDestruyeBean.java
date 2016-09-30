/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 27-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EmpresaDestruyeDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEmpresaDestruye;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EmpresaDestruyeVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona la Empresa que Destruye
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminEmpresaDestruyeBean implements AdminEmpresaDestruye {
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private EmpresaDestruyeDAO empresaDestruyeDao;

    /**
     * Constructor.
     */
    
    public AdminEmpresaDestruyeBean() {
        super();
    }


    
    /**
     * Insertar Empresa Destruye 
     * @param empresaDestruyeVo
     * @return resultado - Empresa Destruye
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
     public EmpresaDestruyeVO insertarEmpresaDestruye(EmpresaDestruyeVO empresaDestruyeVo) throws ExcepcionDAO, ExcepcionAplicacion {
        EmpresaDestruyeVO resultado = null;
        
        try {
            SiiEmpresaDestruye siiEmpresaDestruyeVo = empresaDestruyeDao.insertar(conversionVoEntidad.convertir(empresaDestruyeVo));
            if (siiEmpresaDestruyeVo!=null) {
                resultado = new EmpresaDestruyeVO(siiEmpresaDestruyeVo);
                
                // persistir las entidades hijas provenientes de la Empresa que Destruye
                resultado.setActaDestruccionVoList(empresaDestruyeVo.getActaDestruccionVoList());
              
               // this.persistirHijos(resultado);
            }
        }
        catch(ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Empresa que Destruye: "+e.getMessage());
        }
        
        return (resultado);
    } 
    
    /**
     * Actualizar la empresa que destruye
     * @param empresaDestruyeVo
     * @return resultado - Empresa que Destruye
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public EmpresaDestruyeVO actualizarEmpresaDestruye(EmpresaDestruyeVO empresaDestruyeVo) throws ExcepcionDAO, ExcepcionAplicacion {
        EmpresaDestruyeVO resultado = null;
        
        try {
            // eliminar entidades hijas pendientes por remover
      //      this.eliminarHijos();
            
            
            SiiEmpresaDestruye siiEmpresaDestruye = empresaDestruyeDao.actualizar(conversionVoEntidad.convertir(empresaDestruyeVo));
            if (siiEmpresaDestruye!=null) {
                resultado = new EmpresaDestruyeVO(siiEmpresaDestruye);
                
                // persistir las entidades hijas provenientes de la empresa que destruye
                resultado.setActaDestruccionVoList(empresaDestruyeVo.getActaDestruccionVoList());
           //     this.persistirHijos(resultado);
            }
        }
        catch(ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar la Nota de Crédito: "+e.getMessage());
        }
        
        return (resultado);
    }
    
    /**
     * Buscar todas las empresas que destruyen
     * @return resultado - Lista de empresas que destruyen.
     * @throws ExcepcionDAO
     */
    
    public List<EmpresaDestruyeVO> buscarTodaEmpresaDestruye() throws ExcepcionDAO {
        List<EmpresaDestruyeVO> resultado = null;
        List<SiiEmpresaDestruye> lista = empresaDestruyeDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<EmpresaDestruyeVO>();
            for (SiiEmpresaDestruye siiEmpresaDestruye: lista) {
                if (siiEmpresaDestruye!=null)
                    resultado.add(new EmpresaDestruyeVO(siiEmpresaDestruye));
            }
        }
        
        return (resultado);
    }
    
    /**
     * Buscar la empresa que destruye vigente 
     * @return
     * @throws ExcepcionDAO
     */
    
    public List<EmpresaDestruyeVO> buscarEmpresaDestruyeVigente() throws ExcepcionDAO {
        List<EmpresaDestruyeVO> resultado = null;
        Date fecha= new Date();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        Integer año= (cal.get(Calendar.YEAR));

        List<SiiEmpresaDestruye> lista = empresaDestruyeDao.buscarEmpresaDestruyeVigente(año);
        if (lista!=null && lista.size()>0) {
            resultado = new ArrayList<EmpresaDestruyeVO>();
            for (SiiEmpresaDestruye siiEmpresaDestruye: lista) {
                if (siiEmpresaDestruye!=null)
                    resultado.add(new EmpresaDestruyeVO(siiEmpresaDestruye));
            }
        }
        
        return (resultado);
    }
}
