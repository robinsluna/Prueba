package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoPersonalDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPersonal;

import co.gov.coljuegos.siicol.ejb.vo.TipoPersonalVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoPersonalBean implements AdminTipoPersonal {
    @EJB
    private TipoPersonalDAO tipoPersonalDAO;

    /**
     *metodo para consultar todos los tipos de personal
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<TipoPersonalVO> buscarTipoPersonal() throws ExcepcionDAO {
        List<TipoPersonalVO> tipoPersonalVOs = new ArrayList<TipoPersonalVO>();
        List<SiiTipoPersonal> siiTipoPersonals =  new ArrayList<SiiTipoPersonal>();
        siiTipoPersonals = tipoPersonalDAO.buscarTodoSiiTipoPersonal();
        for(SiiTipoPersonal siiTipoPersonal : siiTipoPersonals) {
            TipoPersonalVO tipoPersonalVO = new TipoPersonalVO(siiTipoPersonal);
            tipoPersonalVOs.add(tipoPersonalVO);
        }
        return tipoPersonalVOs;
    }
}
