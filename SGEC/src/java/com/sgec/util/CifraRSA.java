//
//package com.sgec.util;
//
//
//import java.math.BigInteger;
//import java.security.SecureRandom;
//
//
///**
// *
// * @author DHINNO
// */
//public class CifraRSA {
//    private static String msg = "hasotusi";
//    private static String msgCifrada = null;
//    private static String msgDecifrada = null;
//    private static BigInteger n, d, e;
//    private static int bitlen = 2048;
//    private static SecureRandom r = new SecureRandom();
//     private static BigInteger p = new BigInteger(bitlen/2, 100, r);
//    private static BigInteger q = new BigInteger(bitlen/2,100,r);
//    
//    public static void main(String[] args){    
//    
//    n = p.multiply(q);
//    
//    BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
//    
//    e = new BigInteger("1");
//   while(m.gcd(e).intValue()>1) e = e.add(new BigInteger("2"));
//   
//   d = e.modInverse(m);
//   
//        /*System.out.println("p:"+p);
//        System.out.println("q:"+q);
//        System.out.println("n:"+n);
//        System.out.println("e:"+e);
//        System.out.println("d:"+d);*/
//        
//        msgCifrada = new BigInteger(msg.getBytes()).modPow(e, n).toString();
//        System.out.println("msg cifrada "+ msgCifrada);
//        
//        msgDecifrada = new String(new BigInteger(msgCifrada).modPow(d, n).toByteArray());
//        System.out.println("msg decifrada "+msgDecifrada);
//   
//    }
//    
//    
//}
