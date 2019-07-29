/**
 * Description: 
 * Date: 2017年9月28日
 * Author: zhao_yuanchao
 */
package com.commons.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAUtil {
	
	public static final String PublicKey = "";
	public static final String PrivateKey = "";
	 public static final String RSA_ALGORITHM = "RSA";
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(createKeys(512));
	}
	public static Map<String, String> createKeys(int keySize){
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg;
        try{
            kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        }catch(NoSuchAlgorithmException e){
            throw new IllegalArgumentException("No such algorithm-->[" + RSA_ALGORITHM + "]");
        }

        //初始化KeyPairGenerator对象,密钥长度
        kpg.initialize(keySize);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        //得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded());
        //得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        Map<String, String> keyPairMap = new HashMap<String, String>();
        keyPairMap.put("publicKey", publicKeyStr);
        keyPairMap.put("privateKey", privateKeyStr);

        return keyPairMap;
    }

    /**
     * 得到公钥
     * @param publicKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        return key;
    }

    /**
     * 得到私钥
     * @param privateKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static RSAPrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }
	
	public static void printData() throws Exception {
		//加密与解密
		String userCount = new String(Base64.encodeBase64(encryptByRSA("300".getBytes())));
		System.out.println(new String(decryptByRSA(Base64.decodeBase64(userCount)), "utf-8"));
	}
	
	/**
	 * 使用RSA私钥加密数据
	 * @param pubKeyInByte 打包的byte[]形式私钥
	 * @param data 要加密的数据
	 * @return 加密数据
	 */
	public static byte[] encryptByRSA(byte[] data, String privateKey) {
		try {
			byte[] privKeyInByte = Base64.decodeBase64(privateKey);
			PKCS8EncodedKeySpec priv_spec = new PKCS8EncodedKeySpec(privKeyInByte);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privKey = keyFactory.generatePrivate(priv_spec);
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, privKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static byte[] encryptByRSA(byte[] data) {
		return encryptByRSA(data, PrivateKey);
	}

	/**
	 * 用RSA公钥解密
	 * @param privKeyInByte 公钥打包成byte[]形式
	 * @param data  要解密的数据
	 * @return 解密数据
	 */
	public static byte[] decryptByRSA(byte[] data, String publicKey) {
		try {
			byte[] pubKeyInByte = Base64.decodeBase64(publicKey);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec pub_spec = new X509EncodedKeySpec(pubKeyInByte);
			PublicKey pubKey = keyFactory.generatePublic(pub_spec);
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, pubKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static byte[] decryptByRSA(byte[] data) {
		return decryptByRSA(data, PublicKey);
	}
}
