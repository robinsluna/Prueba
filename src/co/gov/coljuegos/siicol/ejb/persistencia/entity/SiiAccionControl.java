package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_ACCION_CONTROL")
public class SiiAccionControl implements Serializable{
    private static final long serialVersionUID = -8647903764735067107L;
    private String accBarrio;
    private String accBodega;
    private Long accCodigo;
    private String accDireccion;
    private String accEstado;
    private String accEstadoEstabl;
    private Date accFechaActa;
    private String accLocalidad;
    private String accNomEstabl;
    private Integer accNumElemEncon;
    private Integer accNumElemRetir;
    private String accNumeroActa;
    private String accObservaciones;
    private String accSucursal;
    private String accTipoAccion;
    private SiiMotivoAnulaAccCont siiMotivoAnulaAccCont;
    private SiiUsuario siiUsuarioConect;
    private List<SiiPersonaAtiendeAcc> siiPersonaAtiendeAccList;
    private SiiUbicacion siiUbicacionMunic;
    private List<SiiElementoRetiradoAcc> siiElementoRetiradoAccList;
    private SiiAutoComisorioAccCon siiAutoComisorioAccCon;
    private SiiResolucionDecomDest siiResolucionDecomDest;
    private SiiResolucionDecomDest siiResolucionDecomDestResuelve;

    public SiiAccionControl(){
    }

    public SiiAccionControl(SiiAutoComisorioAccCon siiAutoComisorioAccCon, String accBarrio, String accBodega, Long accCodigo, String accDireccion, String accEstado, String accEstadoEstabl,
                            Date accFechaActa, String accLocalidad, String accNomEstabl, Integer accNumElemEncon, Integer accNumElemRetir, String accNumeroActa, String accObservaciones,
                            String accSucursal, String accTipoAccion, SiiMotivoAnulaAccCont siiMotivoAnulaAccCont, SiiUbicacion siiUbicacionMunic, SiiUsuario siiUsuarioConect){
        this.siiAutoComisorioAccCon = siiAutoComisorioAccCon;
        this.accBarrio = accBarrio;
        this.accBodega = accBodega;
        this.accCodigo = accCodigo;
        this.accDireccion = accDireccion;
        this.accEstado = accEstado;
        this.accEstadoEstabl = accEstadoEstabl;
        this.accFechaActa = accFechaActa;
        this.accLocalidad = accLocalidad;
        this.accNomEstabl = accNomEstabl;
        this.accNumElemEncon = accNumElemEncon;
        this.accNumElemRetir = accNumElemRetir;
        this.accNumeroActa = accNumeroActa;
        this.accObservaciones = accObservaciones;
        this.accSucursal = accSucursal;
        this.accTipoAccion = accTipoAccion;
        this.siiMotivoAnulaAccCont = siiMotivoAnulaAccCont;
        this.siiUbicacionMunic = siiUbicacionMunic;
        this.siiUsuarioConect = siiUsuarioConect;
    }


    @Column(name = "ACC_BARRIO", length = 30)
    public String getAccBarrio(){
        return accBarrio;
    }

    public void setAccBarrio(String accBarrio){
        this.accBarrio = accBarrio;
    }

    @Column(name = "ACC_BODEGA", length = 60)
    public String getAccBodega(){
        return accBodega;
    }

    public void setAccBodega(String accBodega){
        this.accBodega = accBodega;
    }

    @Id
    @Column(name = "ACC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACCION_CONTROL_COD")
    @SequenceGenerator(name = "SEQ_ACCION_CONTROL_COD", sequenceName = "SEQ_ACCION_CONTROL_COD",allocationSize=1)
    public Long getAccCodigo(){
        return accCodigo;
    }

    public void setAccCodigo(Long accCodigo){
        this.accCodigo = accCodigo;
    }

    @Column(name = "ACC_DIRECCION", length = 100)
    public String getAccDireccion(){
        return accDireccion;
    }

    public void setAccDireccion(String accDireccion){
        this.accDireccion = accDireccion;
    }

    @Column(name = "ACC_ESTADO", nullable = false, length = 1)
    public String getAccEstado(){
        return accEstado;
    }

    public void setAccEstado(String accEstado){
        this.accEstado = accEstado;
    }

    @Column(name = "ACC_ESTADO_ESTABL", nullable = false, length = 1)
    public String getAccEstadoEstabl(){
        return accEstadoEstabl;
    }

    public void setAccEstadoEstabl(String accEstadoEstabl){
        this.accEstadoEstabl = accEstadoEstabl;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACC_FECHA_ACTA")
    public Date getAccFechaActa(){
        return accFechaActa;
    }

    public void setAccFechaActa(Date accFechaActa){
        this.accFechaActa = accFechaActa;
    }

    @Column(name = "ACC_LOCALIDAD", length = 30)
    public String getAccLocalidad(){
        return accLocalidad;
    }

    public void setAccLocalidad(String accLocalidad){
        this.accLocalidad = accLocalidad;
    }

    @Column(name = "ACC_NOM_ESTABL", length = 50)
    public String getAccNomEstabl(){
        return accNomEstabl;
    }

    public void setAccNomEstabl(String accNomEstabl){
        this.accNomEstabl = accNomEstabl;
    }

    @Column(name = "ACC_NUM_ELEM_ENCON")
    public Integer getAccNumElemEncon(){
        return accNumElemEncon;
    }

    public void setAccNumElemEncon(Integer accNumElemEncon){
        this.accNumElemEncon = accNumElemEncon;
    }

    @Column(name = "ACC_NUM_ELEM_RETIR")
    public Integer getAccNumElemRetir(){
        return accNumElemRetir;
    }

    public void setAccNumElemRetir(Integer accNumElemRetir){
        this.accNumElemRetir = accNumElemRetir;
    }

    @Column(name = "ACC_NUMERO_ACTA", length = 8)
    public String getAccNumeroActa(){
        return accNumeroActa;
    }

    public void setAccNumeroActa(String accNumeroActa){
        this.accNumeroActa = accNumeroActa;
    }

    @Column(name = "ACC_OBSERVACIONES", length = 1100)
    public String getAccObservaciones(){
        return accObservaciones;
    }

    public void setAccObservaciones(String accObservaciones){
        this.accObservaciones = accObservaciones;
    }

    @Column(name = "ACC_SUCURSAL", length = 60)
    public String getAccSucursal(){
        return accSucursal;
    }

    public void setAccSucursal(String accSucursal){
        this.accSucursal = accSucursal;
    }

    @Column(name = "ACC_TIPO_ACCION", nullable = false, length = 1)
    public String getAccTipoAccion(){
        return accTipoAccion;
    }

    public void setAccTipoAccion(String accTipoAccion){
        this.accTipoAccion = accTipoAccion;
    }


    @ManyToOne
    @JoinColumn(name = "MAC_CODIGO")
    public SiiMotivoAnulaAccCont getSiiMotivoAnulaAccCont(){
        return siiMotivoAnulaAccCont;
    }

    public void setSiiMotivoAnulaAccCont(SiiMotivoAnulaAccCont siiMotivoAnulaAccCont){
        this.siiMotivoAnulaAccCont = siiMotivoAnulaAccCont;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConect(){
        return siiUsuarioConect;
    }

    public void setSiiUsuarioConect(SiiUsuario siiUsuarioConect){
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @OneToMany(mappedBy = "siiAccionControl")
    public List<SiiPersonaAtiendeAcc> getSiiPersonaAtiendeAccList(){
        return siiPersonaAtiendeAccList;
    }

    public void setSiiPersonaAtiendeAccList(List<SiiPersonaAtiendeAcc> siiPersonaAtiendeAccList){
        this.siiPersonaAtiendeAccList = siiPersonaAtiendeAccList;
    }

    public SiiPersonaAtiendeAcc addSiiPersonaAtiendeAcc(SiiPersonaAtiendeAcc siiPersonaAtiendeAcc){
        getSiiPersonaAtiendeAccList().add(siiPersonaAtiendeAcc);
        siiPersonaAtiendeAcc.setSiiAccionControl(this);
        return siiPersonaAtiendeAcc;
    }

    public SiiPersonaAtiendeAcc removeSiiPersonaAtiendeAcc(SiiPersonaAtiendeAcc siiPersonaAtiendeAcc){
        getSiiPersonaAtiendeAccList().remove(siiPersonaAtiendeAcc);
        siiPersonaAtiendeAcc.setSiiAccionControl(null);
        return siiPersonaAtiendeAcc;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO_MUNIC")
    public SiiUbicacion getSiiUbicacionMunic(){
        return siiUbicacionMunic;
    }

    public void setSiiUbicacionMunic(SiiUbicacion siiUbicacionMunic){
        this.siiUbicacionMunic = siiUbicacionMunic;
    }

    @OneToMany(mappedBy = "siiAccionControl")
    public List<SiiElementoRetiradoAcc> getSiiElementoRetiradoAccList(){
        return siiElementoRetiradoAccList;
    }

    public void setSiiElementoRetiradoAccList(List<SiiElementoRetiradoAcc> siiElementoRetiradoAccList){
        this.siiElementoRetiradoAccList = siiElementoRetiradoAccList;
    }

    public SiiElementoRetiradoAcc addSiiElementoRetiradoAcc(SiiElementoRetiradoAcc siiElementoRetiradoAcc){
        getSiiElementoRetiradoAccList().add(siiElementoRetiradoAcc);
        siiElementoRetiradoAcc.setSiiAccionControl(this);
        return siiElementoRetiradoAcc;
    }

    public SiiElementoRetiradoAcc removeSiiElementoRetiradoAcc(SiiElementoRetiradoAcc siiElementoRetiradoAcc){
        getSiiElementoRetiradoAccList().remove(siiElementoRetiradoAcc);
        siiElementoRetiradoAcc.setSiiAccionControl(null);
        return siiElementoRetiradoAcc;
    }

    @ManyToOne
    @JoinColumn(name = "ACA_CODIGO")
    public SiiAutoComisorioAccCon getSiiAutoComisorioAccCon(){
        return siiAutoComisorioAccCon;
    }

    public void setSiiAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon){
        this.siiAutoComisorioAccCon = siiAutoComisorioAccCon;
    }

    @ManyToOne
    @JoinColumn(name = "RDD_CODIGO")
    public SiiResolucionDecomDest getSiiResolucionDecomDest(){
        return siiResolucionDecomDest;
    }

    public void setSiiResolucionDecomDest(SiiResolucionDecomDest siiResolucionDecomDest){
        this.siiResolucionDecomDest = siiResolucionDecomDest;
    }

    @ManyToOne
    @JoinColumn(name = "RDD_CODIGO_RESUELVE")
    public SiiResolucionDecomDest getSiiResolucionDecomDestResuelve(){
        return siiResolucionDecomDestResuelve;
    }

    public void setSiiResolucionDecomDestResuelve(SiiResolucionDecomDest siiResolucionDecomDestResuelve){
        this.siiResolucionDecomDestResuelve = siiResolucionDecomDestResuelve;
    }
}
