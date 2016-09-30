package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumLogGeneral;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogGeneral;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SqlDirectDAO;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminDirectSqlBean implements AdminDirectSql{
    
    @EJB
    SqlDirectDAO sqlDirectDAO;
    @EJB
    AdminLogGeneral adminLogGeneral;
    Recursos recursos = null;
    
    public AdminDirectSqlBean() {
        recursos = new Recursos();
    }
    
    public void ejecutarUpdate(String sql) throws ExcepcionDAO{
        sqlDirectDAO.ejecutarUpdate(sql);
        //adminLogGeneral.log(EnumLogGeneral.TIPO_INFO.getId(), 1, "AdminDirectSql - ejecutarUpdate", sql, null);
        
    }
}
