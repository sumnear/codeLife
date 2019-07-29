package com.commons.utils;///**
// * Description:
// * Date: 2015年12月24日
// * Author: zhao_yuanchao
// */
//package utilss;
//
//import org.apache.commons.codec.binary.Base64;
//
//import javax.crypto.Cipher;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.IOException;
//
//
//public class DesUtil {
//
//    public static void main(String[] args) throws Exception {
//    		String str = "607291393458890";
//
//
//
//    		String s = encryptBASE64(encryptDesEcb(str.getBytes()));
//    		System.out.println(s);
//    		System.out.println(new String(decryptDesEcb(decryptBASE64(s))));
//
//    		s = encryptBASE64(encrypt3DesEcb(str.getBytes()));
//    		System.out.println(s);
//    		System.out.println(new String(decrypt3DesEcb(decryptBASE64(s))));
//
//    		s = encryptBASE64(encryptDesCbc(str.getBytes()));
//    		System.out.println(s);
//    		System.out.println(new String(decryptDesCbc(decryptBASE64(s))));
//
//    		s = encryptBASE64(encrypt3DesCbc(str.getBytes()));
//    		System.out.println(s);
//    		System.out.println(new String(decrypt3DesCbc(decryptBASE64(s))));
//
//    		s = encryptUrl(str);
//    		System.out.println(s);
//    		System.out.println(decryptUrl(s, true));
//
//    }
//
//
//    public static String encryptUrl(String str) throws Exception {
//		String s = encryptBASE64(encryptDesEcb(str.getBytes()));
//		s = java.net.URLEncoder.encode(s);
//		return s;
//    }
//
//    public static String decryptUrl(String str, boolean needDec) throws Exception {
//    	String s = str;
//    	if(needDec){
//    		s = java.net.URLDecoder.decode(str);
//    	}
//		return new String(decryptDesEcb(decryptBASE64(s)));
//    }
//
//
//
//    /**
//     * Description:
//     * @param data
//     * @return
//     * Date: 2015年12月24日
//     * Author: zhao_yuanchao
//     */
//    public static String encryptBASE64(byte[] data) {
//        return new String(Base64.encodeBase64(data));
//    }
//
//    /**
//     * Description:
//     * @param data
//     * @return
//     * @throws IOException
//     * @throws Exception
//     * Date: 2015年12月24日
//     * Author: zhao_yuanchao
//     */
//    public static byte[] decryptBASE64(String data) {
//		return Base64.decodeBase64(data);
//    }
//
//
//    /**
//     * Description: ecb模式(8字节的key)
//     * @param data
//     * @return
//     * @throws Exception
//     * Date: 2016年7月13日
//     * Author: zhao_yuanchao
//     */
//	public static byte[] encryptDesEcb(byte[] data) throws Exception {
//		String key = ConfigHelper.getStringOption("Encrypt_8Bit_Key");
//
//		SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DES");
//
//		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//		return cipher.doFinal(data);
//	}
//
//	public static byte[] decryptDesEcb(byte[] data) throws Exception {
//		String key = ConfigHelper.getStringOption("Encrypt_8Bit_Key");
//
//		SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DES");
//
//		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//		cipher.init(Cipher.DECRYPT_MODE, secretKey);
//
//		return cipher.doFinal(data);
//	}
//
//
//	 /**
//     * Description: ecb模式(24字节的key)
//     * @param data
//     * @return
//     * @throws Exception
//     * Date: 2016年7月13日
//     * Author: zhao_yuanchao
//     */
//	public static byte[] encrypt3DesEcb(byte[] data) throws Exception {
//		String key = ConfigHelper.getStringOption("Encrypt_24Bit_Key");
//
//		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
//		SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DESede");
//		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//		return cipher.doFinal(data);
//	}
//
//	public static byte[] decrypt3DesEcb(byte[] data) throws Exception {
//		String key = ConfigHelper.getStringOption("Encrypt_24Bit_Key");
//
//		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
//		SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DESede");
//		cipher.init(Cipher.DECRYPT_MODE, secretKey);
//		return cipher.doFinal(data);
//	}
//
//
//	/**
//	 * Description: cbc模式(8字节的key)
//	 * @param data
//	 * @return
//	 * @throws Exception
//	 * Date: 2016年7月13日
//	 * Author: zhao_yuanchao
//	 */
//    public static byte[] encryptDesCbc(byte[] data) throws Exception {
//    		String key = ConfigHelper.getStringOption("Encrypt_8Bit_Key");
//		String initVector = ConfigHelper.getStringOption("Initialization_Vector");
//
//        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes());
//        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DES");
//
//        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
//        return cipher.doFinal(data);
//    }
//
//    public static byte[] decryptDesCbc(byte[] data) throws Exception {
//    		String key = ConfigHelper.getStringOption("Encrypt_8Bit_Key");
//    		String initVector = ConfigHelper.getStringOption("Initialization_Vector");
//
//    		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes());
//        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DES");
//
//        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
//
//        return cipher.doFinal(data);
//    }
//
//
//	/**
//	 * Description: cbc模式(24字节的key)
//	 * @param data
//	 * @return
//	 * @throws Exception
//	 * Date: 2016年7月13日
//	 * Author: zhao_yuanchao
//	 */
//    public static byte[]  encrypt3DesCbc(byte[] data) throws Exception {
//    		String key = ConfigHelper.getStringOption("Encrypt_24Bit_Key");
//		String initVector = ConfigHelper.getStringOption("Initialization_Vector");
//
//        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes());
//        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DESede");
//
//        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
//        return cipher.doFinal(data);
//    }
//
//    public static byte[] decrypt3DesCbc(byte[] data) throws Exception {
//    		String key = ConfigHelper.getStringOption("Encrypt_24Bit_Key");
//		String initVector = ConfigHelper.getStringOption("Initialization_Vector");
//
//        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes());
//        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DESede");
//
//        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
//        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
//
//        return cipher.doFinal(data);
//    }
//}
//
