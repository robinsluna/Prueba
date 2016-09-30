package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GrupoRetencDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoRetenc;
import co.gov.coljuegos.siicol.ejb.vo.GrupoRetencVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.management.loading.PrivateClassLoader;

@Stateless

public class AdminGrupoRetencBean implements AdminGrupoRetenc  {
    @EJB
    private GrupoRetencDAO grupoRetencDao;
    
    public AdminGrupoRetencBean() {
        //super();
    }
    
    public List<GrupoRetencVO> buscarTodoGrupoRetenc() throws ExcepcionDAO{
        List<GrupoRetencVO> listaGrupoRetencVo = new ArrayList<GrupoRetencVO>();
        List<SiiGrupoRetenc> listaSiiGrupoRetenc = new ArrayList <SiiGrupoRetenc>();
        
        listaSiiGrupoRetenc = grupoRetencDao.buscarTodo();
        if (listaSiiGrupoRetenc != null){
            for (SiiGrupoRetenc siiGrupoRetenc :listaSiiGrupoRetenc){
                if (siiGrupoRetenc != null){
                    listaGrupoRetencVo.add(new GrupoRetencVO(siiGrupoRetenc));
                }
            }
        }
        return listaGrupoRetencVo;
    }
    
    public GrupoRetencVO buscarGrupoRetencPorCodigo(Long idGrupoRetenc) throws ExcepcionDAO{
        SiiGrupoRetenc siiGrupoRetnecion = new SiiGrupoRetenc();                
        siiGrupoRetnecion = grupoRetencDao.buscarPorCodigo(idGrupoRetenc);
        
        return new GrupoRetencVO (siiGrupoRetnecion);
    }
}
