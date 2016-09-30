package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.vo.ResultadoVerifDenunVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminResultadoVerifDenun {
    

    public List<ResultadoVerifDenunVO> buscartodos() throws Exception;

}
