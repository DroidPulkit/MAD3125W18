package com.droidpulkit.thunder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button login, register;
    EditText username, password;
    String strUsername = "";
    String strPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin :
                //Login button clicked
                Toast.makeText(this, "Yo login clicked", Toast.LENGTH_SHORT).show();
                getData();
                break;
            case R.id.btnRegister:
                //Register button clicked
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                //No button clicked
                break;
        }
    }

    void getData(){
        strUsername = username.getText().toString();
        strPassword = password.getText().toString();
    }
}
