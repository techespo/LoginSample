package com.techespo.classone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener {
    private Button btnLogin;
    private EditText etEmail, etPassword;

    private String dummyEmail ="test@gmail.com";
    private String dummyPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin.setOnClickListener(this);
        ((Button) findViewById(R.id.btnRegister)).setOnClickListener(this);
      /*  btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if(email != null && email.length()>0){

                    if(password != null && password.length()>0){

                        if(email.equals(dummyEmail) && password.equals(dummyPassword) ){
                            Intent intent = new Intent( LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this, "Invalid Email/Password.", Toast.LENGTH_LONG).show();
                        }

                    }else {
                        Toast.makeText(LoginActivity.this, "Password can not empty.", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(LoginActivity.this, "Email can not empty.", Toast.LENGTH_LONG).show();
                }

            }
        });*/

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                if(checkValidation()) {
                    if (etEmail.getText().toString().equals(dummyEmail) && etPassword.getText().toString().equals(dummyPassword)) {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Email/Password.", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.btnRegister:
                Intent intent = new Intent(LoginActivity.this,  SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }
    private boolean checkValidation(){
        if(etEmail.getText().toString() == null || etEmail.getText().toString().length() <=0){
            etEmail.setError("Email can not empty.");
            etEmail.requestFocus();
           return  false;
        }
        if(etPassword.getText().toString() == null || etPassword.getText().toString().length()<=0){
            etPassword.setError("Password can not empty.");
            etPassword.requestFocus();
           return false;
        }
        return true;
    }
}
