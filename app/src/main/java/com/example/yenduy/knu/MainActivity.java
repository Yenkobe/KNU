package com.example.yenduy.knu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
