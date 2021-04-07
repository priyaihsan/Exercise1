package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edEmail,edPassword;
    ImageButton btnLogin;
    TextView btnDaftar;
    String nama,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnLogin  =findViewById(R.id.Button);
        edEmail   =findViewById(R.id.textemail);
        edPassword=findViewById(R.id.textpass);
        btnDaftar = findViewById(R.id.Bterdaftar);


        btnLogin.setOnClickListener(new View.OnClickListener() {

            String email = "priya@gmail";
            String pass = "1234";

            @Override
            public void onClick(View view) {
                nama     = edEmail.getText().toString();
                password = edPassword.getText().toString();

                // untuk menampilkan toast
                if (nama.isEmpty() || password.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext()
                            ,"Email dan Password wajib diisi",Toast.LENGTH_LONG);
                    t.show();

                }
                else{
                    if (nama.equals(email) || password.equals(pass)){
                        Toast t = Toast.makeText(getApplicationContext()
                                ,"login Berhasil",Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a",nama.trim());

                        b.putString("b",password.trim());

                        //ke layout home activity yang berisi list
                        Intent i =  new Intent(getApplicationContext(),HomeActivity.class);

                        i.putExtras(b);

                        startActivity(i);

                    }
                    else{
                        Toast t = Toast.makeText(getApplicationContext()
                                ,"login Gagal",Toast.LENGTH_LONG);

                        t.show();
                    }
                }

            }
        });


        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ke layout pendaftaran
                Intent i =  new Intent(getApplicationContext(),PendaftaranActivity.class);
                startActivity(i);
            }
        });


    }


}