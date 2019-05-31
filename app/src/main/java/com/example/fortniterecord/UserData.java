package com.example.fortniterecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class UserData extends AppCompatActivity {
    public static final String NICK =
            "Nick introducido por el usuario";
    public static final String PLATFORM =
            "Plataforma introducida por el usuario";

    String nick;
    String platform;
    EditText txtNick;
    RadioGroup radioPlatforms;
    RadioButton radioPlatformSelected;
    Button btnBuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        txtNick = findViewById(R.id.txtNick);
        radioPlatforms = findViewById(R.id.radioPlatforms);
        btnBuscar = findViewById(R.id.btnBuscar);
    }

    public void enviarPerfil(View view) {
        int radioId = radioPlatforms.getCheckedRadioButtonId();
        radioPlatformSelected = findViewById(radioId);
        nick = txtNick.getText().toString();
        platform = radioPlatformSelected.getText().toString();
        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra(NICK, nick);
        intent.putExtra(PLATFORM, platform);
        startActivity(intent);
    }
}
