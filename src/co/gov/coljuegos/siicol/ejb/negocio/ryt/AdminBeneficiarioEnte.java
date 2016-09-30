/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-10-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBeneficiarioEnte;
import co.gov.coljuegos.siicol.ejb.vo.BeneficiarioEnteVO;

import co.gov.coljuegos.siicol.ejb.vo.CuentaBancoPersonaVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;



/**
 * Interfaz local para el manejo de Beneficiarios por Ente Territorial.
 * @author Camilo Miranda
 */
@Local
public interface AdminBeneficiarioEnte 
{
    public List<BeneficiarioEnteVO> buscarPorCodigoEnteTerritorial (Long etiCodigo) throws ExcepcionDAO;
    public List<BeneficiarioEnteVO> buscarPorCodigoEnteTerritorial (Long etiCodigo, String benEstado) throws ExcepcionDAO;
    public List<BeneficiarioEnteVO> buscarPorCodigoEnteTerritorialMes (Long etiCodigo, Integer mesCodigo, Integer vigencia) throws ExcepcionDAO;
    public List<BeneficiarioEnteVO> buscarPorCodigoEnteTerritorialMes (Long etiCodigo, Integer mesCodigo, Integer vigencia, String benEstado) throws ExcepcionDAO;
    public List<BeneficiarioEnteVO> buscarTodosBeneficiariosEnteTerritorial () throws ExcepcionDAO;
    public BeneficiarioEnteVO insertarSiiBeneficiarioEnte(SiiBeneficiarioEnte beneficiarioEnte) throws ExcepcionDAO;
    public void registrarBeneficiarioEnte(BeneficiarioEnteVO beneficiarioVo, CuentaBancoPersonaVO ctaBcoPnaVo)throws ExcepcionDAO;
    public BeneficiarioEnteVO buscarPorCodigoBeneficiarioEnte(Long idCodigoBen) throws ExcepcionDAO;
    public BeneficiarioEnteVO actualizarBeneficiarioEnte (BeneficiarioEnteVO beneficiarioEnteVo) throws ExcepcionDAO;
    public List<BeneficiarioEnteVO> buscarBeneficiariosEnteTerritorialPorNit (String nit) throws ExcepcionDAO;
    public void actualizarBeneficiarioCta(BeneficiarioEnteVO beneficiarioVo,CuentaBancoPersonaVO ctaBcoPnaVo)throws ExcepcionDAO;
    public void actualizarEstadoBeneficiarioEnte(BeneficiarioEnteVO beneficiario, UsuarioVO usuarioLogueado) throws ExcepcionDAO,ExcepcionAplicacion ;
}
