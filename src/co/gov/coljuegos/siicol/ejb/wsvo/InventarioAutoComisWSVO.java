package co.gov.coljuegos.siicol.ejb.wsvo;

import co.gov.coljuegos.siicol.ejb.vo.AutoComisorioVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;

import java.io.Serializable;

import java.math.BigDecimal;

public class InventarioAutoComisWSVO implements Serializable  {
    
    public String  iacItem;
    public String iacSerial;
    public Integer iacRevSerial;
    public String iacMarca;
    public Integer iacRevCodApuesta;
    public Integer iacRevDescJuego;
    public Integer iacRevPlanPremios;
    public Integer iacRevValorPremios;
    public Integer iacRevcontadores;
    public BigDecimal iacValorCredito;
    public BigDecimal iacCoinIn;
    public BigDecimal iacCoinOut;
    public BigDecimal iacValorjackpot;
    
    public InventarioAutoComisWSVO() {
      super();
    }

   

}
