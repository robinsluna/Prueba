package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFinancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminDetalleFinancBean implements AdminDetalleFinanc {
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private DetalleFinancDAO detalleFinancDAO;

    public AdminDetalleFinancBean() {
    }

    public DetalleFinancVO insertarSiiDetalleFinanc(DetalleFinancVO detalleFinancVo) throws ExcepcionDAO {
        SiiDetalleFinanc siiDetalleFinanc = conversionVoEntidad.convertir(detalleFinancVo);
        siiDetalleFinanc = detalleFinancDAO.insertarSiiDetalleFinanc(siiDetalleFinanc);
        return new DetalleFinancVO(siiDetalleFinanc);
    }


    public DetalleFinancVO actualizarSiiDetalleFinanc(DetalleFinancVO detalleFinanc) throws ExcepcionDAO {
        SiiDetalleFinanc siiDetalleFinanc =
            detalleFinancDAO.actualizarSiiDetalleFinanc(conversionVoEntidad.convertir(detalleFinanc));
        return new DetalleFinancVO(siiDetalleFinanc);
    }

    public void borrarSiiDetalleFinanc(Long idCodigoDetalleFinanc) throws ExcepcionDAO {
        detalleFinancDAO.borrarSiiDetalleFinanc(idCodigoDetalleFinanc);
    }

    public List<DetalleFinancVO> buscarTodoSiiDetalleFinanc() throws ExcepcionDAO {
        List<SiiDetalleFinanc> listaDetalleFinanc = detalleFinancDAO.buscarTodoSiiDetalleFinanc();
        List<DetalleFinancVO> listaDetalleFinancVO = new ArrayList<DetalleFinancVO>();
        for (SiiDetalleFinanc unDetalleFinanc : listaDetalleFinanc) {
            listaDetalleFinancVO.add(new DetalleFinancVO(unDetalleFinanc));
        }
        return listaDetalleFinancVO;
    }

    public DetalleFinancVO buscarDetalleFinancPorCodigo(Long idCodigoDetFinanc) throws ExcepcionDAO {
        SiiDetalleFinanc siiDetalleFinanc = detalleFinancDAO.buscarDetalleFinancPorCodigo(idCodigoDetFinanc);
        return new DetalleFinancVO(siiDetalleFinanc);

    }

    public DetalleFinancVO buscarDetalleFinancPorPersona(Long perCodigo) throws ExcepcionDAO {
        return new DetalleFinancVO(detalleFinancDAO.buscarDetalleFinancPorPersona(perCodigo));
    }

    /**
     * @author Giovanni
     * @param perCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public List<DetalleFinancVO> buscarDetallesFinancierosXPersona(Long perCodigo) throws ExcepcionDAO {
        List<DetalleFinancVO> detalleFinancVOs = new ArrayList<DetalleFinancVO>();
        List<SiiDetalleFinanc> siiDetalleFinancs = new ArrayList<SiiDetalleFinanc>();
        siiDetalleFinancs = detalleFinancDAO.buscarDetallesFinancierosXPersona(perCodigo);

        for (SiiDetalleFinanc siiDetalleFinanc : siiDetalleFinancs) {
            DetalleFinancVO detalleFinancVO = new DetalleFinancVO(siiDetalleFinanc);
            detalleFinancVOs.add(detalleFinancVO);
        }
        return detalleFinancVOs;
    }
}
