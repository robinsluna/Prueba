/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 26-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoNoDestruccionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoNoDestruccion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.MotivoNoDestruccionVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona el motivo de no destrucción
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminMotivoNoDestruccionBean implements AdminMotivoNoDestruccion {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private MotivoNoDestruccionDAO motivoNoDestruccionDao;

    /**
     * Constructor.
     */

    public AdminMotivoNoDestruccionBean() {
        super();
    }


    /*   private void persistirActaDestruccion (MotivoNoDestruccionVO motivoNoDestruccionVo) throws ExcepcionDAO
    {
        if (motivoNoDestruccionVo!=null && motivoNoDestruccionVo.getActaDestruccionVoList()!=null) {
            for (MotivoNoDestruccionVO mndVo: motivoNoDestruccionVo.getActaDestruccionVoList()) {
                if (mndVo!=null) {
                    mndVo.setNotaCreditoVo(notaCreditoVo);

                    if (notaCreditoVo.getNcrCodigo() == null) {
                        // OPERACION INSERTAR
                        adminNotaCredOblConcepto.insertarNotaCredOblConcepto(mndVo);
                    } else {
                        // OPERACION ACTUALIZAR
                        adminNotaCredOblConcepto.actualizarNotaCredOblConcepto(mndVo);
                    }
                }
            }
        }
    } */

    /**
     * Persistir hijos.
     * @param motivoNoDestruccionVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    private void persistirHijos(MotivoNoDestruccionVO motivoNoDestruccionVo) throws ExcepcionDAO, ExcepcionAplicacion {
        // this.persistirActaDestruccion(motivoNoDestruccionVo);


    }

    /**
     * Insertar el Motivo No Destrucción
     * @param motivoNoDestruccionVo
     * @return resultado - Motivo de no destrucción.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public MotivoNoDestruccionVO insertarMotivoNoDestruccion(MotivoNoDestruccionVO motivoNoDestruccionVo) throws ExcepcionDAO,
                                                                                                                 ExcepcionAplicacion {
        MotivoNoDestruccionVO resultado = null;

        try {
            SiiMotivoNoDestruccion siiMotivoNoDestruccion =
                motivoNoDestruccionDao.insertar(conversionVoEntidad.convertir(motivoNoDestruccionVo));
            if (siiMotivoNoDestruccion != null) {
                resultado = new MotivoNoDestruccionVO(siiMotivoNoDestruccion);

                // persistir las entidades hijas provenientes del Motivo de no Destrucción
                resultado.setActaDestruccionVoList(motivoNoDestruccionVo.getActaDestruccionVoList());
                this.persistirHijos(resultado);
            }
        } catch (ExcepcionAplicacion | ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar el Motivo de No Destrucción: " + e.getMessage());
        }

        return (resultado);
    }

    /**
     * Actualizar el Motivo de No Destrucción
     * @param motivoNoDestruccionVo
     * @return resultado - Motivo de No Destrucción.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public MotivoNoDestruccionVO actualizarMotivoNoDestruccion(MotivoNoDestruccionVO motivoNoDestruccionVo) throws ExcepcionDAO,
                                                                                                                   ExcepcionAplicacion {
        MotivoNoDestruccionVO resultado = null;

        try {
            // eliminar entidades hijas pendientes por remover
            //  this.eliminarHijos();


            SiiMotivoNoDestruccion siiMotivoNoDestruccion =
                motivoNoDestruccionDao.actualizar(conversionVoEntidad.convertir(motivoNoDestruccionVo));
            if (siiMotivoNoDestruccion != null) {
                resultado = new MotivoNoDestruccionVO(siiMotivoNoDestruccion);

                // persistir las entidades hijas provenientes del Motivo de no Destrucción
                resultado.setActaDestruccionVoList(motivoNoDestruccionVo.getActaDestruccionVoList());

                this.persistirHijos(resultado);
            }
        } catch (ExcepcionAplicacion | ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar el Motivo de No Destrucción: " + e.getMessage());
        }

        return (resultado);
    }

    /**
     * Buscar todos los Motivos de No Destrucción
     * @return resultado - Lista de todos los Motivos de no Destrucción
     * @throws ExcepcionDAO
     */

    public List<MotivoNoDestruccionVO> buscarTodoMotivoNoDestruccion() throws ExcepcionDAO {
        List<MotivoNoDestruccionVO> resultado = null;
        List<SiiMotivoNoDestruccion> lista = motivoNoDestruccionDao.buscarTodo();
        if (lista != null) {
            resultado = new ArrayList<MotivoNoDestruccionVO>();
            for (SiiMotivoNoDestruccion siiMotivoNoDestruccion : lista) {
                if (siiMotivoNoDestruccion != null)
                    resultado.add(new MotivoNoDestruccionVO(siiMotivoNoDestruccion));
            }
        }

        return (resultado);
    }
}
