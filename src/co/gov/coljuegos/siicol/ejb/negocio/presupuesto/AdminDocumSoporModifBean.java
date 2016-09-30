package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumSoporModifDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumSoporModif;
import co.gov.coljuegos.siicol.ejb.vo.DocumSoporModifVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminDocumSoporModifBean implements AdminDocumSoporModif {
    @EJB
    DocumSoporModifDAO documSoporModifDao;

    public AdminDocumSoporModifBean() {

    }

    public List<DocumSoporModifVO> documentosSoportePorModif(Long mpcCodigo) throws ExcepcionDAO {
        List<DocumSoporModifVO> documentosSoporModifVo = new ArrayList<DocumSoporModifVO>();
        for (SiiDocumSoporModif documSoporModif : documSoporModifDao.documentosSoportePorModif(mpcCodigo)) {
            documentosSoporModifVo.add(new DocumSoporModifVO(documSoporModif));
        }
        return documentosSoporModifVo;
    }
    
    public boolean existeDocumento(DocumSoporModifVO docVo) throws ExcepcionDAO {
        return  documSoporModifDao.existeDocumento(docVo.getDsmActivo(), docVo.getDsmNumDoc(), docVo.getTipoDocSoporteModifVo().getTdmCodigo()); 
    }
}
