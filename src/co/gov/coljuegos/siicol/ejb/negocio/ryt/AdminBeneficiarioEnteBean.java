/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-10-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BeneficiarioEnteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaBancoPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaCtaBancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBeneficiarioEnte;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancoPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaCtaBanco;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.BeneficiarioEnteVO;

import co.gov.coljuegos.siicol.ejb.vo.CuentaBancoPersonaVO;

import co.gov.coljuegos.siicol.ejb.vo.DistribucionMesVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class AdminBeneficiarioEnteBean implements AdminBeneficiarioEnte 
{
    @EJB 
    ConversionVOEntidad conversionVoEntidad; 
    @EJB
    private BeneficiarioEnteDAO beneficiarioEnteDao;
    @EJB
    private CuentaBancoPersonaDAO cuentaBancoPersonaDao;
    @EJB
    private PersonaCtaBancoDAO personaCtaBancoDao;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;

    /**
     * Constructor.
     */
    

    public AdminBeneficiarioEnteBean() { }
    
    
    
    @Override
    public List<BeneficiarioEnteVO> buscarPorCodigoEnteTerritorial(Long etiCodigo) throws ExcepcionDAO {
        List<BeneficiarioEnteVO> resultado = null;
        
        List<SiiBeneficiarioEnte> lista = beneficiarioEnteDao.buscarPorCodigoEnteTerritorial(etiCodigo);
        if (lista!=null) {
            resultado = new ArrayList<BeneficiarioEnteVO>();
            for (SiiBeneficiarioEnte siiBeneficiarioEnte: lista) {
                if (siiBeneficiarioEnte!=null)
                    resultado.add(new BeneficiarioEnteVO(siiBeneficiarioEnte));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<BeneficiarioEnteVO> buscarPorCodigoEnteTerritorial(Long etiCodigo, String benEstado) throws ExcepcionDAO 
    {
        List<BeneficiarioEnteVO> resultado = null;
        
        List<SiiBeneficiarioEnte> lista = beneficiarioEnteDao.buscarPorCodigoEnteTerritorial(etiCodigo, benEstado);
        if (lista!=null) {
            resultado = new ArrayList<BeneficiarioEnteVO>();
            for (SiiBeneficiarioEnte siiBeneficiarioEnte: lista) {
                if (siiBeneficiarioEnte!=null)
                    resultado.add(new BeneficiarioEnteVO(siiBeneficiarioEnte));
            }
        }
        
        return (resultado);
    }
    
    
   public List<BeneficiarioEnteVO> buscarTodosBeneficiariosEnteTerritorial () throws ExcepcionDAO 
    {
        List<BeneficiarioEnteVO> resultado = null;
        
        List<SiiBeneficiarioEnte> lista = beneficiarioEnteDao.buscarTodosBeneficiariosEnteTerritorial();
        if (lista!=null) {
            resultado = new ArrayList<BeneficiarioEnteVO>();
            for (SiiBeneficiarioEnte siiBeneficiarioEnte: lista) {
                if (siiBeneficiarioEnte!=null)
                    resultado.add(new BeneficiarioEnteVO(siiBeneficiarioEnte));
            }
        }
        
        return (resultado);
    }
   
    public BeneficiarioEnteVO insertarSiiBeneficiarioEnte(SiiBeneficiarioEnte beneficiarioEnte) throws ExcepcionDAO 
    {
        SiiBeneficiarioEnte siiBeneficiarioEnte = beneficiarioEnteDao.insertarSiiBeneficiarioEnte(beneficiarioEnte);
        return ( new BeneficiarioEnteVO(siiBeneficiarioEnte));
    }
    
    public void registrarBeneficiarioEnte(BeneficiarioEnteVO beneficiarioVo, CuentaBancoPersonaVO ctaBcoPnaVo)throws ExcepcionDAO{
        // Se inserta la persona
        if(beneficiarioVo!= null){ 
            SiiBeneficiarioEnte siiBenEnte =  null;
            SiiPersonaCtaBanco siiPerCtaBco = new SiiPersonaCtaBanco();
            siiBenEnte = conversionVoEntidad.convertir(beneficiarioVo);
            if(beneficiarioVo.getPersonaVo()!= null ){
               if( beneficiarioVo.getPersonaVo().getPerCodigo()== null){
                    //siiBenEnte = new SiiBeneficiarioEnte();
                    SiiPersona resultadoSiiPersona = personaDao.insertarPersona(conversionVoEntidad.convertir(beneficiarioVo.getPersonaVo()));
                    siiBenEnte.setSiiPersona(resultadoSiiPersona);
                    siiPerCtaBco.setSiiPersona(resultadoSiiPersona);
               }else {
                    
                    siiPerCtaBco.setSiiPersona(siiBenEnte.getSiiPersona());
                   // Se actualiza los datos de persona
                   personaDao.actualizarPersona(siiBenEnte.getSiiPersona());
                   
                }
                beneficiarioEnteDao.insertar(siiBenEnte);
                
                // se registra sii_cuenta_banco_persona
                if(ctaBcoPnaVo!= null){
                    SiiCuentaBancoPersona siiCtaBcoPna = conversionVoEntidad.convertir(ctaBcoPnaVo);
                    SiiCuentaBancoPersona resultadoSiiCuentaBancoPersona = cuentaBancoPersonaDao.insertarSiiCuentaBancoPersona(siiCtaBcoPna);                   
                    siiPerCtaBco.setSiiCuentaBancoPersona(resultadoSiiCuentaBancoPersona);
                    personaCtaBancoDao.insertarPersonaCtaBanco(siiPerCtaBco);
                }
                
            }
             
        }
    }
    public BeneficiarioEnteVO buscarPorCodigoBeneficiarioEnte(Long idCodigoBen) throws ExcepcionDAO {
        return(new BeneficiarioEnteVO(beneficiarioEnteDao.buscarPorCodigoBeneficiarioEnte(idCodigoBen)));
    }
    
    
    /**
     * Actualiza un registro de Beneficiario Ente.
     * @param beneficiarioEnteVo
     * @return instance of BeneficiarioEnteVO.
     * @throws ExcepcionDAO
     */
    public BeneficiarioEnteVO actualizarBeneficiarioEnte (BeneficiarioEnteVO beneficiarioEnteVo) throws ExcepcionDAO {
        BeneficiarioEnteVO resultado = null;
        SiiPersona resultadoSiiPersona = personaDao.actualizarPersona(conversionVoEntidad.convertir(beneficiarioEnteVo.getPersonaVo()));
        SiiBeneficiarioEnte siiBeneficiarioEnte = conversionVoEntidad.convertir(beneficiarioEnteVo);
        siiBeneficiarioEnte.setSiiPersona(resultadoSiiPersona);
        beneficiarioEnteDao.actualizar(siiBeneficiarioEnte);
        if (siiBeneficiarioEnte!=null)
            resultado = new BeneficiarioEnteVO(siiBeneficiarioEnte);        
        return (resultado);
    }
    
    
    
    @Override
    public List<BeneficiarioEnteVO> buscarPorCodigoEnteTerritorialMes (Long etiCodigo, Integer mesCodigo, Integer vigencia) throws ExcepcionDAO {
        List<BeneficiarioEnteVO> resultado = null;
        
        List<SiiBeneficiarioEnte> lista = beneficiarioEnteDao.buscarPorCodigoEnteTerritorialMes(etiCodigo, mesCodigo, vigencia);
        if (lista!=null) {
            resultado = new ArrayList<BeneficiarioEnteVO>();
            for (SiiBeneficiarioEnte siiBeneficiarioEnte: lista) {
                if (siiBeneficiarioEnte!=null)
                    resultado.add(new BeneficiarioEnteVO(siiBeneficiarioEnte));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<BeneficiarioEnteVO> buscarPorCodigoEnteTerritorialMes (Long etiCodigo, Integer mesCodigo, Integer vigencia, String benEstado) throws ExcepcionDAO {
        List<BeneficiarioEnteVO> resultado = null;
        
        List<SiiBeneficiarioEnte> lista = beneficiarioEnteDao.buscarPorCodigoEnteTerritorialMes(etiCodigo, mesCodigo, vigencia, benEstado);
        if (lista!=null) {
            resultado = new ArrayList<BeneficiarioEnteVO>();
            for (SiiBeneficiarioEnte siiBeneficiarioEnte: lista) {
                if (siiBeneficiarioEnte!=null)
                    resultado.add(new BeneficiarioEnteVO(siiBeneficiarioEnte));
            }
        }
        
        return (resultado);
    }
    public List<BeneficiarioEnteVO> buscarBeneficiariosEnteTerritorialPorNit (String nit) throws ExcepcionDAO {
        List<SiiBeneficiarioEnte> listaSiiBeneficiarios = new ArrayList<>();
        List<BeneficiarioEnteVO> resultadoVo = new ArrayList<>();
        listaSiiBeneficiarios = beneficiarioEnteDao.buscarBeneficiariosEnteTerritorialPorNit(nit);
        if(listaSiiBeneficiarios.size() > 0){
            for(SiiBeneficiarioEnte unSiiBenef : listaSiiBeneficiarios ){
                resultadoVo.add(new BeneficiarioEnteVO(unSiiBenef));
            }            
        }
        return resultadoVo;
    }
    
    public void actualizarBeneficiarioCta(BeneficiarioEnteVO beneficiarioVo,CuentaBancoPersonaVO ctaBcoPnaVo)throws ExcepcionDAO {
            // Se inserta la persona
            if(beneficiarioVo!= null){ 
                SiiBeneficiarioEnte siiBenEnte =  null;
                SiiPersonaCtaBanco siiPerCtaBco = null;
                if(beneficiarioVo.getPersonaVo()!= null ){               
                    siiBenEnte = conversionVoEntidad.convertir(beneficiarioVo);
                    siiPerCtaBco.setSiiPersona(siiBenEnte.getSiiPersona());
                   // Se actualiza los datos de persona
                   SiiPersona resultadoSiiPersona = personaDao.actualizarPersona(siiBenEnte.getSiiPersona());
                   
                   // si la cuenta es nueva:
                   if(ctaBcoPnaVo.getCbpCodigo()== null){
                           SiiCuentaBancoPersona siiCtaBcoPna = conversionVoEntidad.convertir(ctaBcoPnaVo);
                           SiiCuentaBancoPersona resultadoSiiCuentaBancoPersona = cuentaBancoPersonaDao.insertarSiiCuentaBancoPersona(siiCtaBcoPna);                   
                           siiPerCtaBco.setSiiCuentaBancoPersona(resultadoSiiCuentaBancoPersona);
                           personaCtaBancoDao.insertarPersonaCtaBanco(siiPerCtaBco);
                   }else {
                           cuentaBancoPersonaDao.actualizarPersona(conversionVoEntidad.convertir(ctaBcoPnaVo));
                       }                
                }             
            }    
    }
    
    public void actualizarEstadoBeneficiarioEnte(BeneficiarioEnteVO beneficiario, UsuarioVO usuarioLogueado) throws ExcepcionDAO,ExcepcionAplicacion {
        if(beneficiario!= null && usuarioLogueado!= null ){                
            SiiBeneficiarioEnte beneficiarioEnte = beneficiarioEnteDao.buscarPorCodigoBeneficiarioEnte(beneficiario.getBenCodigo());
            if(!beneficiarioEnte.getBenActivo().equals(beneficiario.getIdEstadoAnterior())){
                throw new ExcepcionAplicacion("Error de concurrencia: El estado del beneficiario ente fue cambiado durante la modificación. Seleccione nuevamente el beneficiario");
            }
           SiiBeneficiarioEnte resultado = beneficiarioEnteDao.actualizarSiiBeneficiarioEnte(conversionVoEntidad.convertir(beneficiario));
           // se actualiza el log
          /* adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.BENEFICIARIO_ENTE.getId(),
                                                                     beneficiario.getBenActivo(),
                                                                 usuarioLogueado, beneficiario.getBenCodigo());*/
        }
    }
}
