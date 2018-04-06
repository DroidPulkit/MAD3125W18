package com.example.macstudent.thunder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin;
    Button btnRegister;
    EditText edtUsername;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        btnRegister = findViewById(R.id.btnRegistration);
        btnRegister.setOnClickListener(this);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btnLogin.getId()){
            String uname = edtUsername.getText().toString();
            String passwd = edtPassword.getText().toString();

            if(uname.equals("test") && passwd.equals("test")){
                Toast.makeText(this,
                        "Login Successful",
                        Toast.LENGTH_LONG).show();

                Intent homeIntent = new Intent(this, HomeActivity.class);
                startActivity(homeIntent);

            }


        }else if (view.getId() == btnRegister.getId()){
            Toast.makeText(this,
                    "Register Clicked",
                    Toast.LENGTH_SHORT).show();

            Intent registerIntent = new Intent(this,RegisterActivity.class);
            startActivity(registerIntent);
        }
    }
}
