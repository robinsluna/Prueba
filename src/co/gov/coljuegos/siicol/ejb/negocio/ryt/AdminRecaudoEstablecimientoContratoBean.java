package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.RecaudoEstablecimientoManualVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminRecaudoEstablecimientoContratoBean implements AdminRecaudoEstablecimientoContrato {
    @Resource
    SessionContext sessionContext;
    
    @EJB
    private DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB
    private PersonaDAO personaDao;
    
    
    
    public AdminRecaudoEstablecimientoContratoBean() {
    
    }


        
    
}
