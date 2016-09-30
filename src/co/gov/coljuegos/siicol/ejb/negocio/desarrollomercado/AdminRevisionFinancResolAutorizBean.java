package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionFinancResolAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionFinancResolAutoriz;
import co.gov.coljuegos.siicol.ejb.vo.RevisionFinancResolAutorizVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRevisionFinancResolAutorizBean implements AdminRevisionFinancResolAutoriz {
    @EJB
    RevisionFinancResolAutorizDAO revisionFinancResolAutorizDao;

    public List<RevisionFinancResolAutorizVO> buscarRevisionFinanPorResolucion(Long rauCodigo) throws ExcepcionDAO {
        List<RevisionFinancResolAutorizVO> revisionesVo = new ArrayList<RevisionFinancResolAutorizVO>();
        List<SiiRevisionFinancResolAutoriz> revisiones = new ArrayList<SiiRevisionFinancResolAutoriz>();
        revisiones = revisionFinancResolAutorizDao.buscarRevisionFinancResolAutorizPorResolucion(rauCodigo);
        for (SiiRevisionFinancResolAutoriz revision : revisiones) {
            revisionesVo.add(new RevisionFinancResolAutorizVO(revision));
        }
        return (List<RevisionFinancResolAutorizVO>) revisionesVo;
    }
}

