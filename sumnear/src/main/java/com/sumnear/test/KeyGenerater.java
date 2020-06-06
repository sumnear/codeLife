package test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;

public class KeyGenerater {

	private static byte[] priKey;

	private static byte[] pubKey;

	public static void main(String[] args) {
		generater();
	}

	public static void generater() {
		try {

			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");

			SecureRandom secrand = new SecureRandom();

			secrand.setSeed("www.川江号子.cn".getBytes()); // 初始化随机产生器

			keygen.initialize(1024, secrand);

			KeyPair keys = keygen.genKeyPair();

			PublicKey pubkey = keys.getPublic();

			PrivateKey prikey = keys.getPrivate();

			// pubKey = Base64.encodeToByte(pubkey.getEncoded());
			//
			// priKey = Base64.encodeToByte(prikey.getEncoded());
			pubKey = Base64.getEncoder().encode(pubkey.getEncoded());
			priKey = Base64.getEncoder().encode(prikey.getEncoded());
			System.out.println("pubKey = " + new String(pubKey));
			System.out.println("priKey = " + new String(priKey));

		} catch (java.lang.Exception e) {

			System.out.println("生成密钥对失败");

			e.printStackTrace();

		}

	}

	public byte[] getPriKey() {

		return priKey;

	}

	public byte[] getPubKey() {

		return pubKey;

	}

}