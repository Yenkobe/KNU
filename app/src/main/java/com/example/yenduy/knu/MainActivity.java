package com.example.yenduy.knu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextView tv_register;
    private EditText Name;
    private EditText Password;
    private Button Login;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog; // en lo que esperan para entrar a la app, aparecera un msg

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user !=null){  // si el usuario ya esta registrado lo envia directamente al mainpage
            finish();
            startActivity(new Intent(MainActivity.this,Mainpage.class ));
        }


        // esto es para cuando demos un click en register, te pueda enviar al activityregister//
        Name = (EditText)findViewById(R.id.editText4);
        Password = (EditText)findViewById(R.id.editText5);
        Login = (Button)findViewById(R.id.button3) ;
        tv_register= (TextView) findViewById(R.id.Register);


        Login.setOnClickListener(new View.OnClickListener() {// login button para ir al mainpage\
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(MainActivity.this, Mainpage.class);
                MainActivity.this.startActivity(intentLogin);
            }
        });

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(MainActivity.this,Register.class);
                MainActivity.this.startActivity(intentRegister);
            }
        });

        }
        private void validate(String Name, String Password){

        progressDialog.setMessage("Please wait until you are verified");
        progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(Name , Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this , Mainpage.class));
                    }else {
                        Toast.makeText(MainActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
