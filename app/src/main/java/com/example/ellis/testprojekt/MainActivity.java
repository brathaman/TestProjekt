package com.example.ellis.testprojekt;

import android.app.Activity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       final EditText e = (EditText) findViewById(R.id.editText);
       final String pass = e.getText().toString();

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pass = e.getText().toString();
                byte[] d = encrypt(pass);

                String out = Base64.encodeToString(d, Base64.DEFAULT);

                TextView v1 =(TextView) findViewById(R.id.textView);
                v1.setText(out);
                Log.e(null,out);

            }
        });

    }

    byte[] encrypt(String thePass) {

        byte[] b = null;
        try {
            Encoder e = new Encoder();
            e.setKey(generateKey());
            b = e.send(thePass.getBytes());

        } catch (Exception e1) {

        }
        return b;
    }


    byte[] generateKey() {
        byte[] mArray = new byte[16];
        int gen = 7;
        for(int i =0; i < 16; i++) {
            mArray[i] = (byte) gen;

            gen  += (gen*i % 3) *4;
        }

        return mArray;
    }

}
