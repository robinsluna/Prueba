package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPoblacionEnte;

import java.util.Date;

public class PoblacionEnteVO {
    
    private Long penCodigo;
    private Date penFechaFin;
    private Date penFechaIni;
    private Long penPoblacCabec;
    private Long penPoblacResto;
    private Long penPoblacTotal;
    private EnteTerritorialVO enteTerritorialVo;
    private CargaPoblacionVO cargaPoblacionVo;
    private UsuarioVO usuarioConec;
    
    public PoblacionEnteVO() {
    }
    
    public PoblacionEnteVO(SiiPoblacionEnte siiPoblacionEnte) {
        if (siiPoblacionEnte!= null) {
            this.setPenCodigo(siiPoblacionEnte.getPenCodigo());
            this.setPenFechaFin(siiPoblacionEnte.getPenFechaFin());
            this.setPenFechaIni(siiPoblacionEnte.getPenFechaIni());
            this.setPenPoblacCabec(siiPoblacionEnte.getPenPoblacCabec());
            this.setPenPoblacResto(siiPoblacionEnte.getPenPoblacResto());
            this.setPenPoblacTotal(siiPoblacionEnte.getPenPoblacTotal());
            
            if (siiPoblacionEnte.getSiiUsuarioConec()!=null)
                this.usuarioConec = new UsuarioVO(siiPoblacionEnte.getSiiUsuarioConec());
        
        
        if (siiPoblacionEnte.getSiiCargaPoblacion()!=null)
            this.cargaPoblacionVo = new CargaPoblacionVO(siiPoblacionEnte.getSiiCargaPoblacion());
        
        if (siiPoblacionEnte.getSiiEnteTerritorial()!=null)
            this.enteTerritorialVo = new EnteTerritorialVO(siiPoblacionEnte.getSiiEnteTerritorial());
        }
    }

    public void setPenCodigo(Long penCodigo) {
        this.penCodigo = penCodigo;
    }

    public Long getPenCodigo() {
        return penCodigo;
    }

    public void setPenFechaFin(Date penFechaFin) {
        this.penFechaFin = penFechaFin;
    }

    public Date getPenFechaFin() {
        return penFechaFin;
    }

    public void setPenFechaIni(Date penFechaIni) {
        this.penFechaIni = penFechaIni;
    }

    public Date getPenFechaIni() {
        return penFechaIni;
    }

    public void setPenPoblacCabec(Long penPoblacCabec) {
        this.penPoblacCabec = penPoblacCabec;
    }

    public Long getPenPoblacCabec() {
        return penPoblacCabec;
    }

    public void setPenPoblacResto(Long penPoblacResto) {
        this.penPoblacResto = penPoblacResto;
    }

    public Long getPenPoblacResto() {
        return penPoblacResto;
    }

    public void setPenPoblacTotal(Long penPoblacTotal) {
        this.penPoblacTotal = penPoblacTotal;
    }

    public Long getPenPoblacTotal() {
        return penPoblacTotal;
    }

    public void setEnteTerritorialVo(EnteTerritorialVO enteTerritorialVo) {
        this.enteTerritorialVo = enteTerritorialVo;
    }

    public EnteTerritorialVO getEnteTerritorialVo() {
        return enteTerritorialVo;
    }

    public void setCargaPoblacionVo(CargaPoblacionVO cargaPoblacionVo) {
        this.cargaPoblacionVo = cargaPoblacionVo;
    }

    public CargaPoblacionVO getCargaPoblacionVo() {
        return cargaPoblacionVo;
    }

    public void setUsuarioConec(UsuarioVO usuarioConec) {
        this.usuarioConec = usuarioConec;
    }

    public UsuarioVO getUsuarioConec() {
        return usuarioConec;
    }
}
