package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.math.BigDecimal;

public class NovedadParaRetiroWSVO implements Serializable {
   public Integer tipoNovedad;
   public BigDecimal valorIndicador;
   public long tipoElemento;
   public Long tipoJuego;
   public String codigoLocal;
   public String municipioDane;
   public Long idColjuegosMet;
   public String idNuidMet;
   public String serialMet;
   public Long cantidadSillas;
   public Long estadoUbicacionInst;
   
   
   
    public NovedadParaRetiroWSVO() {
       
    }
}
