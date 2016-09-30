package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionFinanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionFinan;
import co.gov.coljuegos.siicol.ejb.vo.RevisionFinanVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRevisionFinanBean implements AdminRevisionFinan {
    @EJB 
    RevisionFinanDAO revisionFinanDao;
    
    public List<RevisionFinanVO> buscarRevisionFinanPorContrato(Long conCodigo, String rfiTipoValidac) throws ExcepcionDAO {
        List<RevisionFinanVO> revisionesVo = new ArrayList<RevisionFinanVO>();
        List<SiiRevisionFinan> revisiones = new ArrayList<SiiRevisionFinan>();
        revisiones = revisionFinanDao.buscarRevisionFinanPorContrato(conCodigo,rfiTipoValidac);
        for (SiiRevisionFinan revision : revisiones) {
            revisionesVo.add(new RevisionFinanVO(revision));
        }
        return revisionesVo;
    }
    
}
