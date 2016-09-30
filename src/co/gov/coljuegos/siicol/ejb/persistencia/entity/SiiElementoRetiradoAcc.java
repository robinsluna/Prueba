package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ELEMENTO_RETIRADO_ACC")
public class SiiElementoRetiradoAcc implements Serializable{
    private static final long serialVersionUID = 5809161300585168557L;
    private String elrActivo;
    private BigDecimal elrAvaluo;
    private Long elrCodigo;
    private String elrMarca;
    private String elrModelo;
    private Integer elrNumElementos;
    private Integer elrSello;
    private String elrSerial;
    private String elrUtilizaTrans;
    private SiiTipoElemenIlegalidad siiTipoElemenIlegalidad;
    private SiiUsuario siiUsuarioConect;
    private SiiAccionControl siiAccionControl;
    private String elrAccion;
    private String elrDestruido;

    public SiiElementoRetiradoAcc(){
    }

    public SiiElementoRetiradoAcc(SiiAccionControl siiAccionControl, String elrActivo, BigDecimal elrAvaluo, Long elrCodigo, String elrMarca, String elrModelo, Integer elrNumElementos,
                                  Integer elrSello, String elrSerial, String elrUtilizaTrans, SiiTipoElemenIlegalidad siiTipoElemenIlegalidad, SiiUsuario siiUsuarioConect){
        this.siiAccionControl = siiAccionControl;
        this.elrActivo = elrActivo;
        this.elrAvaluo = elrAvaluo;
        this.elrCodigo = elrCodigo;
        this.elrMarca = elrMarca;
        this.elrModelo = elrModelo;
        this.elrNumElementos = elrNumElementos;
        this.elrSello = elrSello;
        this.elrSerial = elrSerial;
        this.elrUtilizaTrans = elrUtilizaTrans;
        this.siiTipoElemenIlegalidad = siiTipoElemenIlegalidad;
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @Column(name = "ELR_ACCION", length = 2)
    public String getElrAccion(){
        return elrAccion;
    }

    public void setElrAccion(String elrAccion){
        this.elrAccion = elrAccion;
    }

    @Column(name = "ELR_ACTIVO", nullable = false, length = 1)
    public String getElrActivo(){
        return elrActivo;
    }

    public void setElrActivo(String elrActivo){
        this.elrActivo = elrActivo;
    }

    @Column(name = "ELR_AVALUO")
    public BigDecimal getElrAvaluo(){
        return elrAvaluo;
    }

    public void setElrAvaluo(BigDecimal elrAvaluo){
        this.elrAvaluo = elrAvaluo;
    }

    @Id
    @Column(name = "ELR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ELEMENTO_RETIR_ACC_COD")
    @SequenceGenerator(name = "SEQ_ELEMENTO_RETIR_ACC_COD", sequenceName = "SEQ_ELEMENTO_RETIR_ACC_COD",allocationSize=1)
    public Long getElrCodigo(){
        return elrCodigo;
    }

    public void setElrCodigo(Long elrCodigo){
        this.elrCodigo = elrCodigo;
    }

    @Column(name = "ELR_DESTRUIDO", length = 1)
    public String getElrDestruido(){
        return elrDestruido;
    }

    public void setElrDestruido(String elrDestruido){
        this.elrDestruido = elrDestruido;
    }

    @Column(name = "ELR_MARCA", length = 100)
    public String getElrMarca(){
        return elrMarca;
    }

    public void setElrMarca(String elrMarca){
        this.elrMarca = elrMarca;
    }

    @Column(name = "ELR_MODELO", length = 100)
    public String getElrModelo(){
        return elrModelo;
    }

    public void setElrModelo(String elrModelo){
        this.elrModelo = elrModelo;
    }

    @Column(name = "ELR_NUM_ELEMENTOS", nullable = false)
    public Integer getElrNumElementos(){
        return elrNumElementos;
    }

    public void setElrNumElementos(Integer elrNumElementos){
        this.elrNumElementos = elrNumElementos;
    }

    @Column(name = "ELR_SELLO")
    public Integer getElrSello(){
        return elrSello;
    }

    public void setElrSello(Integer elrSello){
        this.elrSello = elrSello;
    }

    @Column(name = "ELR_SERIAL", length = 30)
    public String getElrSerial(){
        return elrSerial;
    }

    public void setElrSerial(String elrSerial){
        this.elrSerial = elrSerial;
    }

    @Column(name = "ELR_UTILIZA_TRANS", nullable = false, length = 1)
    public String getElrUtilizaTrans(){
        return elrUtilizaTrans;
    }

    public void setElrUtilizaTrans(String elrUtilizaTrans){
        this.elrUtilizaTrans = elrUtilizaTrans;
    }


    @ManyToOne
    @JoinColumn(name = "TEI_CODIGO")
    public SiiTipoElemenIlegalidad getSiiTipoElemenIlegalidad(){
        return siiTipoElemenIlegalidad;
    }

    public void setSiiTipoElemenIlegalidad(SiiTipoElemenIlegalidad siiTipoElemenIlegalidad){
        this.siiTipoElemenIlegalidad = siiTipoElemenIlegalidad;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConect(){
        return siiUsuarioConect;
    }

    public void setSiiUsuarioConect(SiiUsuario siiUsuarioConect){
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @ManyToOne
    @JoinColumn(name = "ACC_CODIGO")
    public SiiAccionControl getSiiAccionControl(){
        return siiAccionControl;
    }

    public void setSiiAccionControl(SiiAccionControl siiAccionControl){
        this.siiAccionControl = siiAccionControl;
    }
}
