package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ArchivoFisicoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminArchivoFisico {
    public ArchivoFisicoVO insertarArchivoFisico(ArchivoFisicoVO archivoFisicoVo) throws ExcepcionDAO;
    public ArchivoFisicoVO buscarArchivoFisicoPorId(ArchivoFisicoVO archivoFisicoVo) throws ExcepcionDAO;
    //public ArchivoFisicoVO actualizarArchivoFisico(ArchivoFisicoVO archivoFisicoVo) throws ExcepcionDAO;
    public List<ArchivoFisicoVO> buscarTodoArchivoFisico() throws ExcepcionDAO;
    public List<ArchivoFisicoVO> buscarArchivoFisicoPorNombre(String afiNombre)throws ExcepcionDAO; 
}
