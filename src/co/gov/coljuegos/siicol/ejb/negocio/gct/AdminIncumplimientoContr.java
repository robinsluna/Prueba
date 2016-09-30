package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.IncumplimientoContrVO;

import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminIncumplimientoContr {
    public List<IncumplimientoContrVO> buscarIncumplimientosInforme(Long isuCodigo) throws ExcepcionDAO ;
    public boolean sustanciadorConIncumplimientosVigentes(Long fsuCodigo) throws ExcepcionDAO ;
    public List<IncumplimientoContrVO> buscarIncumplimientoPorPerCodigoSustanciador (Long perCodigo) throws ExcepcionDAO;
    public IncumplimientoContrVO buscarIncumplimientoContrPorCodigo (Long icnCodigo) throws ExcepcionDAO;
    public IncumplimientoContrVO insertarIncumplimientoContr (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public IncumplimientoContrVO insertarIncumplimientoContr (IncumplimientoContrVO incumplimientoContrVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion;
    public IncumplimientoContrVO actualizarIncumplimientoContr (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public IncumplimientoContrVO actualizarIncumplimientoContr (IncumplimientoContrVO incumplimientoContrVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion;
    public void eliminarIncumplimientoContr (Long icnCodigo) throws ExcepcionDAO;
    public IncumplimientoContrVO buscarIncumplimientoPorIdResolucionYCategoria (Long rcoCodigo, Long categoriaResolucion) throws ExcepcionDAO;
    public String liquidarValorMulta(IncumplimientoContrVO incumplimientoContrVo, String tipoResolucion) throws ExcepcionDAO;
    public void establecerResolucionesIncumContrEnFirme ();
    
    
    
    /////////////////////////////////////////////////////////////
    // Objetos a persistir junto al proceso de Incumplimiento. //
    /////////////////////////////////////////////////////////////
    public void setListaInventarioPersistir(List<InventarioVO> listaInventarioPersistir);
    public List<InventarioVO> getListaInventarioPersistir();
    public void setContratoVoPersistir(ContratoVO contratoVoPersistir);
    public ContratoVO getContratoVoPersistir();
}
