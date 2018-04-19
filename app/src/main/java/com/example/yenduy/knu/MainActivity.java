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

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog; // en lo que esperan para entrar a la app, aparecera un msg
    private TextView tv_register;
    private EditText Name;
    private EditText Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init FirebaseAuth instanse
        firebaseAuth = FirebaseAuth.getInstance();


        //-----------------  If user Login  -----------------------------------------------//

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user !=null){  // si el usuario ya esta registrado lo envia directamente al mainpage
            finish();
            startActivity(new Intent(MainActivity.this,Mainpage.class ));
        }



        //-----------------  Register button code  -----------------------------------------------//

        tv_register= (TextView) findViewById(R.id.Register);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(MainActivity.this,Register.class);
                MainActivity.this.startActivity(intentRegister);
            }
        });


        //-----------------  Login button code  --------------------------------------------------//
        Login = (Button)findViewById(R.id.button3) ;
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(MainActivity.this,Register.class);
                //Get activity obj;
                Name = (EditText)findViewById(R.id.editText4);
                Password = (EditText)findViewById(R.id.editText5);

                //Get data value in activity obj
                String name = Name.getText().toString();
                String password = Password.getText().toString();

                //validate name/pass (all data not null or empty)
                if( validateNamePass(name,password) ){
                    // firebase auth
                    firebaseAuth.signInWithEmailAndPassword(name,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) { //tenemos que crear un loop con condicion if , else
                                Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                                Intent intentLogin = new Intent(MainActivity.this, Mainpage.class);
                                MainActivity.this.startActivity(intentLogin);
                            }else {
                                Toast.makeText(MainActivity.this,"Incorrect Username or password.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

    //-------------------------------------------------------------------------------------------//
    private Boolean validateNamePass(String name, String password ){
        Boolean result = false;
        // si el usuario no se registra le dara error por eso creamos un if para que le de error
        if (name.isEmpty() || password.isEmpty() ) {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
            // error msg por si no entran su informacion requerida
        }else {
            result = true;
        }
        return result;
    }
    //-------------------------------------------------------------------------------------------//



}