package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionGctResolucAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionGctResolucAutoriza;
import co.gov.coljuegos.siicol.ejb.vo.RevisionGctResolucAutorizaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRevisionGctResolucAutorizaBean implements AdminRevisionGctResolucAutoriza {
    @EJB
    RevisionGctResolucAutorizaDAO revisionGctResolucAutorizaDao;
    public List<RevisionGctResolucAutorizaVO> buscarRevisionGctPorResolucion(Long rauCodigo) throws ExcepcionDAO {
        List<RevisionGctResolucAutorizaVO> revisionesVo = new ArrayList<RevisionGctResolucAutorizaVO>();
        List<SiiRevisionGctResolucAutoriza> revisiones = new ArrayList<SiiRevisionGctResolucAutoriza>();
        revisiones = revisionGctResolucAutorizaDao.buscarRevisionGctResolucAutorizaPorResolucion(rauCodigo);
        for (SiiRevisionGctResolucAutoriza revision : revisiones) {
            revisionesVo.add(new RevisionGctResolucAutorizaVO(revision));
        }
        return revisionesVo;
    }
}
