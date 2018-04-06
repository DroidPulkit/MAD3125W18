package com.example.macstudent.thunder;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSubmit;
    TextView txtDOB;
    DBHelper dbHelper;
    SQLiteDatabase thunderDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        txtDOB = (TextView) findViewById(R.id.txtDOB);
        txtDOB.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == btnSubmit.getId()){

            insertUser();
            displayData();


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

    private void insertUser(){

        EditText edtName = (EditText) findViewById(R.id.editName);
        EditText edtPhone = (EditText) findViewById(R.id.editPhone);
        EditText edtEmail = (EditText) findViewById(R.id.editEmail);
        EditText edtPass = (EditText) findViewById(R.id.editPassword);
        TextView txtDOB  = (TextView) findViewById(R.id.txtDOB);

        String name = edtName.getText().toString();
        String phone = edtPhone.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPass.getText().toString();
        String dob = txtDOB.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put("Name", name);
        cv.put("Phone", phone);
        cv.put("Email", email);
        cv.put("Password", password);
        cv.put("DOB", dob);

        try{
            thunderDB = dbHelper.getWritableDatabase();
            thunderDB.insert("UserInfo", null, cv);

        }catch(Exception e){
            Log.e("Insert User", e.getMessage());
        }
        thunderDB.close();
    }

    private void displayData(){
        try{
            thunderDB = dbHelper.getReadableDatabase();
            String columns[] = {"Name", "Phone", "Email", "Password", "DOB"};
            Cursor cursor = thunderDB.query("UserInfo",columns,null,null,null,null,null);

            while(cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex("Name"));
                String email = cursor.getString(cursor.getColumnIndex("Email"));
                String phone = cursor.getString(cursor.getColumnIndex("Phone"));
                String password = cursor.getString(cursor.getColumnIndex("Password"));
                String birthDate = cursor.getString(cursor.getColumnIndex("DOB"));

                String userInfo = name + "\n" + phone + "\n" + email + "\n" + password + "\n" +birthDate;

                Toast.makeText(this, userInfo, Toast.LENGTH_SHORT).show();

            }


        }catch(Exception e){
            Log.e("RegisterActivity : ", "Unable to fetch the records");
        }
        thunderDB.close();

    }
}
