package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionGctDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionGct;
import co.gov.coljuegos.siicol.ejb.vo.RevisionGctVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRevisionGctBean implements AdminRevisionGct {
    @EJB 
    RevisionGctDAO revisionGctDao;
    
    public List<RevisionGctVO> buscarRevisionGctPorContrato(Long conCodigo) throws ExcepcionDAO {
        List<RevisionGctVO> revisionesVo = new ArrayList<RevisionGctVO>();
        List<SiiRevisionGct> revisiones = new ArrayList<SiiRevisionGct>();
        revisiones = revisionGctDao.buscarRevisionGctPorContrato(conCodigo);
        for (SiiRevisionGct revision : revisiones) {
            revisionesVo.add(new RevisionGctVO(revision));
        }
        return revisionesVo;
    }
    
}
