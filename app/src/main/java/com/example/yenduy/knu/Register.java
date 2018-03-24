package com.example.yenduy.knu;

import android.app.Activity;
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

public class Register extends Activity {

    private EditText userEmail, userName, userPassword;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;  // this auntification for the firebaseauth variable debajo de setupuiview


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // find View-element in reg activity
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();



        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){
                    // upload data to the database
                    String user_email = userEmail.getText().toString();
                    String user_password = userPassword.getText().toString().trim();
                      // estas lineas son para ver si el user registration es successfull or not, y para enviar la database a firebase
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()) { //tenemos que crear un loop con condicion if , else
                                Toast.makeText(Register.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register.this, MainActivity.class));
                            }else {
                                Toast.makeText(Register.this,"Registration Fail",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this , MainActivity.class));

                // if u click in the already have account will sent u to the login layout

            }
        });

    }

    private void setupUIViews(){
        userEmail=(EditText) findViewById(R.id.Email);
        userName= (EditText) findViewById(R.id.Username);
        userPassword=(EditText)findViewById(R.id.Password);
        regButton=(Button)findViewById(R.id.BRegister);
        // then we need to register the detail ,cuando la persona de clck en el button pues que haga una funcion
        userLogin=(TextView)findViewById(R.id.tvUserLogin);

    }

    private Boolean validate(){
        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email= userEmail.getText().toString();

        // si el usuario no se registra le dara error por eso creamos un if para que le de error

        if (name.isEmpty() && password.isEmpty() && email.isEmpty()) {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
            // error msg por si no entran su informacion requerida
        }else {
            result = true;

        }

        return result;
    }

}