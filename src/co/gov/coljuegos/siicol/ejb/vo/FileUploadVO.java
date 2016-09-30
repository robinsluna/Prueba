/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.io.File;


/**
 * Value Object usado comunmente por el <b>FileUploadAdmin</b> para el manejo de persistencia de ArchivoFisicoVO por fuera del mismo admin.
 * @author Camilo Miranda
 */
public class FileUploadVO 
{
    /** Archivo donde fue almacenado temporalmente el archivo. */
    private File tempFileFS;
    /** Value Object del Archivo F&iacute;sico */
    private ArchivoFisicoVO archivoFisicoVo;


    /**
     * Constructor.
     * @param tempFileFS
     * @param archivoFisicoVo
     */
    public FileUploadVO(File tempFileFS, ArchivoFisicoVO archivoFisicoVo) 
    {
        this.tempFileFS = tempFileFS;
        this.archivoFisicoVo = archivoFisicoVo;
    }


    public void setTempFileFS(File tempFileFS) {
        this.tempFileFS = tempFileFS;
    }

    public File getTempFileFS() {
        return tempFileFS;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }
    
    
    /**
     * Obtiene el nombre del archivo recientemente cargado al sistema.
     * @return archivoFisicoVo.afiNombreOriginal
     */
    public String getNombreArchivo () 
    {
        return (archivoFisicoVo!=null?archivoFisicoVo.getAfiNombreOrignal():null);
    }
    
}