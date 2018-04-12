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
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.editText4);
        Password = (EditText)findViewById(R.id.editText5);
        Login = (Button)findViewById(R.id.button3);

        firebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser(); // check is the user is already loged or not

        if(user != null) {
            finish();
            startActivity(new Intent(MainActivity.this, Mainpage.class) ); // lo envia al main page

        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        // esto es para cuando demos un click en register, te pueda enviar al activityregister//
        tv_register= (TextView) findViewById(R.id.Register);

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(MainActivity.this,Register.class);
                MainActivity.this.startActivity(intentRegister);
            }
        });
    }

    private void validate (String username, String userPassword) {

        progressDialog.setMessage("Please wait we are working on your verification!");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(username, userPassword). addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, Mainpage.class)); // lo envia al main page
                }else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

}
