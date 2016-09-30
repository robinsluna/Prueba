package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LogModificacionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogModificacion;
import co.gov.coljuegos.siicol.ejb.vo.LogModificacionVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminLogModificacionBean implements AdminLogModificacion {

    @EJB
    LogModificacionDAO logModificacionDAO;

    public AdminLogModificacionBean() {
    }

    public List<LogModificacionVO> buscarTablasLogModificacion() throws ExcepcionDAO {
        List<SiiLogModificacion> listaTabla = logModificacionDAO.buscarTablasLogModificacion();
        List<LogModificacionVO> resultado = null;
        if (listaTabla!=null && !listaTabla.isEmpty()) {
            resultado = new ArrayList<LogModificacionVO>();
            for (SiiLogModificacion siiLogModificacion: listaTabla) {
                if (siiLogModificacion!=null)
                    resultado.add(new LogModificacionVO(siiLogModificacion));
            }
        }
        return resultado;
    }
}


