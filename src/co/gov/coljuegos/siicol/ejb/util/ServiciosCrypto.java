/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Seguridad
 * AUTOR	: Gatopardo
 * FECHA	: 06-03-2014
 */

package co.gov.coljuegos.siicol.ejb.util;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;

import java.security.AlgorithmParameters;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ServiciosCrypto {
    
    private static final String claveMaestra = "cM3dkQes9dFvAnN1pCDrpdpW6MAeVS4WngQ6Pu2oqGHoX29OeGf3y95b4S56Tofk";
    private static final String sal = "Kfi04K0dM2b7ihhndM6i5s9pOj50W2Vs";
    private static final int ITERACIONES = 65536  ;
    private static final int KEY_SIZE = 256;
    
    public ServiciosCrypto() {
    }

    public static String convertPassword(String password, String salt) throws ExcepcionAplicacion {
        for (int i = 0; i < 1000; i++) {
            if (i == 500) {
                password = salt + password + salt;
            }
            password = bytesMD5(password);
        }
        return "{MD5}" + password;
    }
    
    public static String desencriptarAES(String textoEncriptado) throws ExcepcionAplicacion{
        String textoDesencriptado = null;
        if(textoEncriptado == null){
            throw new ExcepcionAplicacion("El texto encriptado no puede ser nulo", "ServiciosCrypto");
        }
        if(textoEncriptado.startsWith("{ENC1}")){
            textoDesencriptado = desencriptarAES128(textoEncriptado);
        }
        else if(textoEncriptado.startsWith("{ENC2}")){
            textoDesencriptado = desencriptarAES256(textoEncriptado);
        }
        else {
            throw new ExcepcionAplicacion("El texto encriptado debe empezar con {ENC1} o {ENC2}", "ServiciosCrypto");
        }
        return textoDesencriptado;
    }
    
    public static String encriptarAES128(String textoPlano) throws ExcepcionAplicacion{
        try{
            String hashClave = calcularSHA256(claveMaestra);
            SecretKeySpec key = new SecretKeySpec(hashClave.getBytes(), 0, 16, "AES");
                
            Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
            aes.init(Cipher.ENCRYPT_MODE, key);
            byte[] ciphertext = aes.doFinal(textoPlano.getBytes());
            String codificadoBase64 = "{ENC1}" + new BASE64Encoder().encode(ciphertext);
            return codificadoBase64;
        }catch (Exception ex) {
            throw new ExcepcionAplicacion("Error de encriptación: " + ex.getMessage(), "ServiciosCrypto");
        }
    }
    
    private static String desencriptarAES128(String textoEncriptado) throws ExcepcionAplicacion{
        String cleartext = textoEncriptado;
        try{
            textoEncriptado = textoEncriptado.substring(6);
            String hashClave = calcularSHA256(claveMaestra);
            SecretKeySpec key = new SecretKeySpec(hashClave.getBytes(), 0, 16, "AES");
            
            Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
            aes.init(Cipher.DECRYPT_MODE, key);
            byte[] bytesTextoDecodificado = new BASE64Decoder().decodeBuffer(textoEncriptado);
            cleartext = new String(aes.doFinal(bytesTextoDecodificado));
            
        }catch (Exception ex) {
            throw new ExcepcionAplicacion("Error de encriptación: " + ex.getMessage(), "ServiciosCrypto");
        }
        return cleartext;
    }
    
    private static String calcularSHA256(String cadena) throws ExcepcionAplicacion {
        String hash;
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(cadena.getBytes());
            byte[] shaBytes = digest.digest();
            hash = new BASE64Encoder().encode(shaBytes);
        }catch (Exception ex) {
            throw new ExcepcionAplicacion("Error de encriptación: " + ex.getMessage(), "ServiciosCrypto");
        }
        return hash;
    }
    
    public static String calcularMD5( String cadena ) throws ExcepcionAplicacion {
        String hash = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] mdBytes = md.digest(cadena.getBytes());
            hash = new BASE64Encoder().encode(mdBytes);
        }catch (NoSuchAlgorithmException ex){
            throw new ExcepcionAplicacion("Error de encriptación: " + ex.getMessage(), "ServiciosCrypto");
        }
        return hash;
    }


    public static String bytesMD5( String cadena ){
        MessageDigest md;
        String tempCadena = "";
        try{
            md = MessageDigest.getInstance("MD5");
            byte[] mdBytes = md.digest(cadena.getBytes());
            int tempEntero=0;
            
            for (int i=0;i<mdBytes.length;i++){
                tempEntero = mdBytes[i];
                if (tempEntero<0) tempEntero=256+tempEntero;
                if (tempEntero<16) tempCadena += "0" + Integer.toHexString(tempEntero);
                else tempCadena += Integer.toHexString(tempEntero);
            }
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return tempCadena;
      }
    
    public static String encriptarAES256(String textoPlano) throws ExcepcionAplicacion{
        String ivBase64 = null;
        String codificadoBase64 = null;
        try{
            if(textoPlano == null){
                throw new ExcepcionAplicacion("El texto a encriptar no puede ser nulo", "ServiciosCrypto");
            }
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            String hashClave = calcularSHA256(claveMaestra);
            PBEKeySpec spec = new PBEKeySpec(hashClave.toCharArray(), sal.getBytes("UTF-8"), ITERACIONES, KEY_SIZE);
            SecretKey key = factory.generateSecret(spec);
            SecretKeySpec secret = new SecretKeySpec(key.getEncoded(), "AES");
            
            Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            aesCipher.init(Cipher.ENCRYPT_MODE, secret);
            AlgorithmParameters params = aesCipher.getParameters();
            byte[] ivBytes = params.getParameterSpec(IvParameterSpec.class).getIV();
            ivBase64 = "{I}" + new BASE64Encoder().encode(ivBytes);
            
            byte[] textoEncriptadoBytes = aesCipher.doFinal(textoPlano.getBytes("UTF-8"));
            codificadoBase64 = "{ENC2}" + new BASE64Encoder().encode(textoEncriptadoBytes);
            
        } catch(Exception ex){
            throw new ExcepcionAplicacion("Error de encriptación: " + ex.getMessage(), "ServiciosCrypto");
        }
        
        return codificadoBase64 + ivBase64;
    }
    
    private static String desencriptarAES256(String totalTextoEncriptado) throws ExcepcionAplicacion{
        String plaintext = null;
        try{
            int ivPos = totalTextoEncriptado.indexOf("{I}");
            if(ivPos == -1) {
                throw new ExcepcionAplicacion("No se encontró el texto {I}", "ServiciosCrypto");
            }
            String textoEncriptado = totalTextoEncriptado.substring(6,ivPos);
            String ivString = totalTextoEncriptado.substring(ivPos);
            ivString = ivString.substring(3);
            
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            String hashClave = calcularSHA256(claveMaestra);
            PBEKeySpec spec = new PBEKeySpec(hashClave.toCharArray(), sal.getBytes("UTF-8"), ITERACIONES, KEY_SIZE);
            SecretKey key = factory.generateSecret(spec);
            SecretKeySpec secret = new SecretKeySpec(key.getEncoded(), "AES");
            byte[] ivBytes = new BASE64Decoder().decodeBuffer(ivString);
            
            Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            aesCipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(ivBytes));
            
            byte[] bytesTextoDecodificado = new BASE64Decoder().decodeBuffer(textoEncriptado);
            plaintext = new String(aesCipher.doFinal(bytesTextoDecodificado), "UTF-8");
            
        } catch(Exception ex){
            throw new ExcepcionAplicacion("Error de encriptación: " + ex.getMessage(), "ServiciosCrypto");
        }
        return plaintext;
    }

}
