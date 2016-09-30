package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAcuerdoPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
import co.gov.coljuegos.siicol.ejb.vo.BancoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;

@Stateless
public class AdminBancoBean implements AdminBanco {

    @EJB
    private BancoDAO bancoDAO;

    /**
     * @author
     * @return
     * @throws ExcepcionDAO
     */
    public List<BancoVO> consultarBancos() throws ExcepcionDAO {
        List<BancoVO> bancoVOs = new ArrayList<BancoVO>();
        List<SiiBanco> siiBancos = new ArrayList<SiiBanco>();
        siiBancos = bancoDAO.consultarBancos();

        for (SiiBanco siiBanco : siiBancos) {
            BancoVO bancoVO = new BancoVO(siiBanco);
            bancoVOs.add(bancoVO);
        }
        return bancoVOs;
    }
    public BancoVO buscarBancoPorCodigo(String idBanco) throws ExcepcionDAO {
        return(new BancoVO(bancoDAO.buscarBancoPorCodigo(idBanco)) );
    }

}
