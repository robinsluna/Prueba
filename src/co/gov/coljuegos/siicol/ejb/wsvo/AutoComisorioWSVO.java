package co.gov.coljuegos.siicol.ejb.wsvo;

import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoFiscalizacionVO;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class AutoComisorioWSVO implements Serializable {
   
    public Long aucCodigo;
    public Integer aucNumero;
    public Date aucFecha;
    public String aucTipoVisita;
    public Date aucFechaVisita;
    public String aucEstado;
    public Date aucFechaAnulac;
    public String aucMotivoAnulac;
    
    
   
    public AutoComisorioWSVO() {
        super();
    }
}
