package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import javax.ejb.Local;

@Local
public interface AdminUtilidades {
    public String valorEnLetras(int numero);
    public void garbageCollect();
}
