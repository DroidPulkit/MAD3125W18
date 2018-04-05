package com.droidpulkit.thunder;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSubmit;
    TextView txtDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        txtDOB = findViewById(R.id.txtDOB);
        txtDOB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == btnSubmit.getId()){
            EditText etName = findViewById(R.id.etName);
            EditText etPhone = findViewById(R.id.etPhone);
            EditText etEmail = findViewById(R.id.etEmail);
            EditText etPass = findViewById(R.id.etPass);

            String name = etName.getText().toString();
            String phone = etPhone.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPass.getText().toString();

            Toast.makeText(this, name + "\n" + phone + "\n" + email + "\n" + password, Toast.LENGTH_LONG).show();
        }else if(view.getId() == txtDOB.getId()){
            Calendar calendar = Calendar.getInstance();
            new DatePickerDialog(this, datePickerListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        }

    }

    DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            String yy = String.valueOf(year);
            String  mm = String.valueOf(month+1);
            String dd = String.valueOf(day);

            if (month<10){
                mm = "0" + mm;
            }

            if (day<10){
                dd = "0" + dd;
            }

            txtDOB.setText(mm + "-" + dd + "-" + yy);


        }
    };
}
