package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepCuotCarActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecConCuoCar;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.math.BigDecimal;

public class EstablecConCuoCarVO{
    
    private String ecuActivo;
    private String ecuCodEstablec;
    private Long ecuCodigo;
    private BigDecimal ecuPorcentaje;
    private BigDecimal ecuValor;
    private UbicacionVO ubicacionMunicipioVo;
    private ConcepCuotCarActAdmVO concepCuotCarActAdmVo;
    private UsuarioVO usuarioConectadoVo;
    // datos para grilla
    private String ubiCodigo;
    private BigDecimal valorTotal;
    
    
    public EstablecConCuoCarVO(SiiEstablecConCuoCar siiEstablecConCuoCar){
       this.ecuActivo = siiEstablecConCuoCar.getEcuActivo();
       this.ecuCodEstablec = siiEstablecConCuoCar.getEcuCodEstablec();
       this.ecuCodigo = siiEstablecConCuoCar.getEcuCodigo();
       this.ecuPorcentaje = siiEstablecConCuoCar.getEcuPorcentaje();
       this.ecuValor = siiEstablecConCuoCar.getEcuValor();
       
       if (siiEstablecConCuoCar.getSiiUbicacionMunicipio() != null )
            this.ubicacionMunicipioVo = new UbicacionVO(siiEstablecConCuoCar.getSiiUbicacionMunicipio() );
       
       if(siiEstablecConCuoCar.getSiiConcepCuotCarActAdm() != null )
            this.concepCuotCarActAdmVo = new ConcepCuotCarActAdmVO(siiEstablecConCuoCar.getSiiConcepCuotCarActAdm() );
       
       if(siiEstablecConCuoCar.getSiiUsuarioConectado() != null )
            this.usuarioConectadoVo = new UsuarioVO (siiEstablecConCuoCar.getSiiUsuarioConectado());
       
    }
    
    public EstablecConCuoCarVO(){
       
    }


    public void setEcuActivo(String ecuActivo){
        this.ecuActivo = ecuActivo;
    }

    public String getEcuActivo(){
        return ecuActivo;
    }

    public void setEcuCodEstablec(String ecuCodEstablec){
        this.ecuCodEstablec = ecuCodEstablec;
    }

    public String getEcuCodEstablec(){
        return ecuCodEstablec;
    }

    public void setEcuCodigo(Long ecuCodigo){
        this.ecuCodigo = ecuCodigo;
    }

    public Long getEcuCodigo(){
        return ecuCodigo;
    }

    public void setValorTotal(BigDecimal valorTotal){
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTotal(){
        return valorTotal;
    }


    public void setEcuPorcentaje(BigDecimal ecuPorcentaje){
        this.ecuPorcentaje = ecuPorcentaje;
    }

    public BigDecimal getEcuPorcentaje(){
        return ecuPorcentaje;
    }

    public void setEcuValor(BigDecimal ecuValor){
        this.ecuValor = ecuValor;
    }

    public BigDecimal getEcuValor(){
        return ecuValor;
    }

    public void setUbicacionMunicipioVo(UbicacionVO ubicacionMunicipioVo){
        this.ubicacionMunicipioVo = ubicacionMunicipioVo;
    }

    public UbicacionVO getUbicacionMunicipioVo(){
        return ubicacionMunicipioVo;
    }

    public void setConcepCuotCarActAdmVo(ConcepCuotCarActAdmVO concepCuotCarActAdmVo){
        this.concepCuotCarActAdmVo = concepCuotCarActAdmVo;
    }

    public ConcepCuotCarActAdmVO getConcepCuotCarActAdmVo(){
        return concepCuotCarActAdmVo;
    }

    public void setUsuarioConectadoVo(UsuarioVO usuarioConectadoVo){
        this.usuarioConectadoVo = usuarioConectadoVo;
    }

    public UsuarioVO getUsuarioConectadoVo(){
        return usuarioConectadoVo;
    }

    public void setUbiCodigo(String ubiCodigo){
        this.ubiCodigo = ubiCodigo;
    }

    public String getUbiCodigo(){
        return ubiCodigo;
    }
}
