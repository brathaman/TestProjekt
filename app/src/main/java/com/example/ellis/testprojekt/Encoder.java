package com.example.ellis.testprojekt;

/**
 * Created by Christian on 2015-04-08.
 */


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encoder {
    private Cipher encoder;
    private SecretKeySpec myKey;

    public Encoder() throws Exception {
        encoder = Cipher.getInstance("AES");
    }

    public void setKey(byte[] key) throws Exception {
        myKey = new SecretKeySpec(key, "AES");
        encoder.init(Cipher.ENCRYPT_MODE, myKey);
    }

    public byte[] send(byte[] message) throws Exception {
        return encoder.doFinal(message);
    }

}