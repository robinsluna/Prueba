package co.gov.coljuegos.siicol.ejb.util;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoMovimiento;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionContableVO;

import java.io.PrintWriter;
import java.io.StringWriter;

import java.lang.annotation.Annotation;

import java.lang.reflect.Method;

import java.math.BigDecimal;

import java.math.RoundingMode;

import java.text.NumberFormat;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.Column;
import javax.persistence.JoinColumn;


/**
 * Conjunto de funcionalidades &uacute;tiles para todo tipo de soluci&oacute;n.
 * @author Camilo Miranda.
 */
public class Utilidades {
    
    /**
     * Convierte un atributo Num&eacute;rico a su representaci&oacute;n de Cadena en formato de la Moneda local.
     * @param numero - N&uacute;mero que se desea convertir.
     * @return Currency String value of Number (Ejemplo: 375600 => $375.600).
     */
    public static String convertirNumeroEnMoneda (Number numero) {
        String resultado = null;
        if (numero!=null) {
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            resultado = nf.format(numero);
        }
        return (resultado);
    }
    
    
    
    /**
     * Obtiene el nombre del M&eacute;todo correspondiente al nombre de la Propiedad especificada.
     * @param propertyName - Nombre de la propiedad correspondiente al m&eacute;todo que se desea buscar.
     * @return <b>get</b><i>propertyName</i>
     */
    public static String getMethodNameFromProperty (String propertyName) {
        String methodName = null;
        
        if (propertyName!=null && !propertyName.isEmpty()) {
            // METODOS
            if (propertyName.startsWith("get")) {
                if (propertyName.endsWith("()")) {
                    methodName = propertyName.substring(0, propertyName.length()-2);
                }
                else {
                    methodName = propertyName;
                }
            }
            // ATRIBUTOS
            else {
                // convertir al nombre del metodo getter
                methodName = "get" + String.valueOf(propertyName.charAt(0)).toUpperCase();
                if (propertyName.length()>1) {
                    methodName = methodName + propertyName.substring(1, propertyName.length());
                }
            }
        }
        
        return (methodName);
    }
    
    
    
    /**
     * Obtiene el nombre de la columna asociada al nombre de la propiedad.
     * @param clase - Clase que contiene definida la propiedad.
     * @param propertyName - Propiedad a buscar. Puede ser un nombre de M&eacute;todo o un nombre de Columna de base de datos.
     * @return valor del atributo <i>name</i> asociada a la anotaci&oacute;n <b>@Column</b>.
     */
    public static String getColumnNameFromProperty (Class clase, String propertyName) {
        String columnName = null;
        
        if (propertyName!=null) {
            // obtiene el nombre del metodo a partir de la propiedad
            String methodName = getMethodNameFromProperty(propertyName);
            if (methodName!=null) {
                try {
                    Method metodo = clase.getMethod(methodName);
                    if (metodo!=null) {
                        // obtiene las anotaciones asociadas al metodo
                        Annotation[] anotaciones = metodo.getDeclaredAnnotations();
                        if (anotaciones!=null) {
                            for (Annotation annotation: anotaciones) {
                                if (annotation instanceof Column){
                                    Column columnAnnotation = (Column) annotation;
                                    columnName = columnAnnotation.name();
                                }
                                else if (annotation instanceof JoinColumn) {
                                    JoinColumn jColumnAnnotation = (JoinColumn) annotation;
                                    columnName = jColumnAnnotation.name();
                                }
                            }
                        }
                    }
                }
                catch (NoSuchMethodException e) {
                    columnName = null;
                }
            }
            
            
            if (columnName==null) {
                // determinar si la propertyName corresponde a un nombre de columna
                Method[] metodos = clase.getDeclaredMethods();
                
                if (metodos!=null) {
                    // recorrer metodo a metodo para buscar si el propertyName corresponde a un nombre de columna
                    for (int i=0; i<metodos.length && columnName==null; i++) {
                        Method metodo = metodos[i];
                        // obtiene las anotaciones asociadas al metodo
                        Annotation[] anotaciones = metodo.getDeclaredAnnotations();
                        if (anotaciones!=null) {
                            // recorrer cada anotacion correspondiente al metodo
                            for (int j=0; j<anotaciones.length && columnName==null; j++) {
                                Annotation annotation = anotaciones[j];
                                if (annotation instanceof Column){
                                    Column columnAnnotation = (Column) annotation;
                                    if (propertyName.equalsIgnoreCase(columnAnnotation.name())) {
                                        columnName = columnAnnotation.name();
                                    }
                                }
                                else if (annotation instanceof JoinColumn) {
                                    JoinColumn jColumnAnnotation = (JoinColumn) annotation;
                                    if (propertyName.equalsIgnoreCase(jColumnAnnotation.name())) {
                                        columnName = jColumnAnnotation.name();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return (columnName);
    }
    
    
    
    /**
     * Realiza la ejecuci&oacute;n del m&eacute;todo perteneciente a la instancia de objeto suministrada, cuyo nombre corresponde al methodName especificado.
     * @param instancia - Instancia de Object que contiene el m&eacute;todo a ejecutar.
     * @param methodName - Nombre del m&eacute;todo que se desea invocar.
     * @return Resultado de la ejecuci&oacute;n del m&eacute;todo.
     */
    public static Object invocarMetodo (Object instancia, String methodName) {
        Object result = null;
        
        try {
            if (instancia!=null && methodName!=null) {
                Method metodo = instancia.getClass().getMethod(methodName);
                if (metodo!=null) {
                    result = metodo.invoke(instancia);
                }
            }
        }
        catch (Exception e) {
            result = null;
        }
        
        return (result);
    }
    
    
    /**
     * Realiza la ejecuci&oacute;n del m&eacute;todo perteneciente a la instancia de objeto suministrada, cuyo nombre de propiedad especificado corresponde al atributo de un getter en la instancia.
     * @param instancia - Instancia de Object que contiene el m&eacute;todo a ejecutar.
     * @param propertyName - Nombre de la propiedad correspondiente al m&eacute;todo que se desea invocar.
     * @return Resultado de la ejecuci&oacute;n del m&eacute;todo.
     */
    public static Object invocarMetodoDesdePropiedad (Object instancia, String propertyName) {
        
        if (instancia!=null && propertyName!=null) {
            Object temp = instancia;
            
            // verificar si el propertyName esta compuesto por varios atributos
            StringTokenizer tokenizer = new StringTokenizer(propertyName, ".");
            while (tokenizer.hasMoreTokens()) {
                String property = tokenizer.nextToken();
                String methodName = getMethodNameFromProperty(property);
                
                if (methodName!=null) {
                    temp = invocarMetodo(temp, methodName);
                }
                else {
                    temp = null;
                }
            }
            
            return (temp);
        }
        
        return null;
    }
    
    
    
    /**
     * Retorna una fecha con la informaci&oacute;n horaria de la fecha removida.
     * @param fecha
     * @return dd/MM/yyyy 00:00:00
     */
    public static Date truncDate (Date fecha) {
        Date resultado = null;
        if (fecha!=null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fecha);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            resultado = cal.getTime();
        }
        
        return (resultado);
    }
    
    
    public static String stackTraceToString(Exception ex){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }
    
    
    
    /**
     * Redondea el n&uacute;mero de tipo BigDecimal a 0 decimales.
     * @param valor - Valor que se desea redondear.
     * @return BigDecimal redondeado con 0 decimales.
     */
    public static BigDecimal redondear (BigDecimal valor) {
        return (redondear(valor, 0));
    }
    
    
    /**
     * Redondea el n&uacute;mero de tipo BigDecimal con respecto al n&uacute;mero de decimales especificado.
     * @param valor - Valor que se desea redondear.
     * @param numeroDecimales - N&uacute;mero de decimales al cual se desea redondear.
     * @return
     */
    public static BigDecimal redondear (BigDecimal valor, int numeroDecimales) {
        BigDecimal resultado = null;
        if (valor!=null) {
            resultado = valor.setScale(numeroDecimales, RoundingMode.HALF_UP);
        }
        return (resultado);
    }
    
    
    
    /**
     * M&eacute;todo encargado de Filtrar todo tipo de palabra reservada SQL o sentencia SQL, para prevenir un ataque SQL Injection.
     * @author Camilo Miranda
     * @param texto - Texto que se desea Filtrar.
     * @return Texto resultante del reemplazo de los caracteres y palabras reservadas SQL por cadena en blanco.
     */
    public static String filtrarInyeccionSQL (String texto) 
    {
        String replacement = null;
        if (texto!=null) {
            String regex = "('(''|[^'])*')|(;)|(\b(ALTER|CREATE|DELETE|DROP|EXEC(UTE){0,1}|INSERT( +INTO){0,1}|MERGE|SELECT|UPDATE|UNION( +ALL){0,1})\b)";
            replacement = texto.replaceAll(regex, "");
        }
        
        return (replacement);
    }
    
    
    
    /**
     * Obtiene la representaci&oacute;n literal de la fecha suministrada.
     * @return Representaci&oacute;n String: <u><i>DD</i> d&iacute;as del mes de <i>MMMMM</i> de <i>yyyy</i></u>.
     */
    public static String convertirFechaALetras (Date fecha) 
    {
        String resultado = null;
        
        if (fecha!=null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'días del mes de' MMMMM 'de' yyyy");
            resultado = dateFormat.format(fecha);
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Calcula la diferencia en d&iacute;as entre dos fechas.
     * @param fechaInicial - Fecha Inicial.
     * @param fechaFinal - Fecha Final.
     * @return Diferencia en d&iacute;as entre <i>Fecha Inicial</i> y <i>Fecha Final</i>.
     */
    public static long diferenciaEnDias (Date fechaInicial, Date fechaFinal) 
    {
        long diferencia = 0;
        
        if (fechaInicial!=null && fechaFinal!=null) {
            long startTime = fechaInicial.getTime();
            long endTime = fechaFinal.getTime();
            long diffTime = endTime - startTime;
            diferencia = diffTime / (1000 * 60 * 60 * 24);
        }
        
        return (diferencia);
    }
    
    
    
    /**
     * Verifica la consistencia del Documento Contable especificado.
     * @param documentoContableVo - Documento Contable que se desea validar.
     * @return Los movimientos del Documento Contable son consistentes?
     */
    public static boolean isConsistenteDocumentoContable (DocumentoContableVO documentoContableVo) 
    {
        boolean consistente = false;
        
        if (documentoContableVo!=null) {
            List<ImputacionContableVO> listaImpContab = documentoContableVo.getImputacionContableList();
            if (listaImpContab!=null && !listaImpContab.isEmpty()) {
                BigDecimal creditos = new BigDecimal(0);
                BigDecimal debitos = new BigDecimal(0);
                
                for (ImputacionContableVO imcVo: listaImpContab) {
                    if (imcVo!=null && imcVo.getImcTipoMovim()!=null && imcVo.getImcValor()!=null) {
                        if (EnumTipoMovimiento.CREDITO.getId().equals(imcVo.getImcTipoMovim()))
                            creditos = creditos.add(imcVo.getImcValor());
                        else if (EnumTipoMovimiento.DEBITO.getId().equals(imcVo.getImcTipoMovim()))
                            debitos = debitos.add(imcVo.getImcValor());
                    }
                }
                
                // LA SUMA DE CREDITOS DEBE SER IGUAL A LA SUMA DE DEBITOS
                consistente = creditos.compareTo(debitos)==0;
            }
        }
        
        return (consistente);
    }
}