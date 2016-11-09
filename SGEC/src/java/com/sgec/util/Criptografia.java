
package com.sgec.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author DHINNO
 */
public class Criptografia {
    private static String msgCifrada = null;
    private static String msgDecifrada = null;
    private static BigInteger n, d, e;
    private static int bitlen = 2048;
    private static SecureRandom r = new SecureRandom();
     private static BigInteger p = new BigInteger(bitlen/2,100, r);
    private static BigInteger q = new BigInteger(bitlen/2,100, r);
    
    public String Cifrar(String mensagem){
        n = p.multiply(q);
    
            BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
    
            e = new BigInteger("1");
         while(m.gcd(e).intValue()>1) e = e.add(new BigInteger("2"));
   
         d = e.modInverse(m);
    
    msgCifrada =  new BigInteger(mensagem.getBytes()).modPow(e, n).toString();
    return msgCifrada;
    }
    
    public String Decifrar(String mensagem){
            n = p.multiply(q);
    
            BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
    
            e = new BigInteger("1");
         while(m.gcd(e).intValue()>1) e = e.add(new BigInteger("2"));
   
         d = e.modInverse(m);
         
         msgDecifrada = new String(new BigInteger(msgCifrada).modPow(d, n).toByteArray());
    
         return msgDecifrada;
    }
}
