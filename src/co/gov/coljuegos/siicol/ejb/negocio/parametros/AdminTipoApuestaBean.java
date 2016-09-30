package co.gov.coljuegos.siicol.ejb.negocio.parametros;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.ryt.AdminCierreRecaudo;
import co.gov.coljuegos.siicol.ejb.negocio.ryt.AdminCierreRecaudoBean;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoSancionatorio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.vo.CierreRecaudoVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoSancionatorioVO;
import co.gov.coljuegos.siicol.ejb.vo.SaldoCuentaBancoVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestaVO;

import co.gov.coljuegos.siicol.ejb.vo.TipoDocContableVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminTipoApuestaBean implements AdminTipoApuesta{
    
    @EJB
    TipoApuestaDAO TipoApuestaDao;
    
    
    public AdminTipoApuestaBean() {
        
    }
    
    public TipoApuestaVO  buscarPorcentajePromocionales() throws ExcepcionDAO {
        TipoApuestaVO tipoApuestaVo = TipoApuestaDao.buscarPorcentajePromocionales();
        return tipoApuestaVo;
    
    }
    
    public TipoApuestaVO buscarSiiTipoCodigoApuesta(String  codTipoCodigoApuesta) throws ExcepcionDAO {
        TipoApuestaVO tipoApuestaVo = TipoApuestaDao.buscarSiiTipoCodigoApuesta(codTipoCodigoApuesta);
        return tipoApuestaVo;
       }

    /**
     * Buscar todos los tipos de apuesta
     * @return
     * @throws ExcepcionDAO
     */

    public List<TipoApuestaVO> buscarTodoTipoApuesta() throws ExcepcionDAO {
        List<TipoApuestaVO> resultado = null;
        List<SiiTipoApuesta> lista = TipoApuestaDao.buscarTodoTipoApuesta();

        if (lista != null) {
            resultado = new ArrayList<TipoApuestaVO>();
            for (SiiTipoApuesta siiTipoApuesta : lista) {
                if (siiTipoApuesta != null)
                    resultado.add(new TipoApuestaVO(siiTipoApuesta));
            }
        }

        return (resultado);
    }
    
}


