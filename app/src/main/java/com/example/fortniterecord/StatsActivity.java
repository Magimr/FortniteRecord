package com.example.fortniterecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class StatsActivity extends AppCompatActivity implements Controller.ServerResponse{

    StatsAdapter adapter;
    String nick;
    String platform;
    TextView txtTop1Solo;
    TextView txtTop1Duo;
    TextView txtTop1Squad;
    TextView txtKdSolo;
    TextView txtKdDuo;
    TextView txtKdSquad;
    TextView txtWinSolo;
    TextView txtWinDuo;
    TextView txtWinSquad;
    TextView txtSPMSolo;
    TextView txtSPMDuo;
    TextView txtSPMSquad;
    TextView txtNickTitulo;



    long currentTime;
    String actualTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        Intent intent = getIntent();
        nick = intent.getStringExtra(UserData.NICK);
        platform = intent.getStringExtra(UserData.PLATFORM);
        Controller controller = new Controller(this);
        controller.start(nick,platform);

        adapter = new StatsAdapter(this,null);


        LinearLayoutManager manager = new LinearLayoutManager(this);
        currentTime = System.currentTimeMillis();
        actualTime = getFormattedDate(currentTime);

        txtTop1Solo = findViewById(R.id.txtTop1Solo);
        txtTop1Duo = findViewById(R.id.txtTop1Duo);
        txtTop1Squad = findViewById(R.id.txtTop1Squad);
        txtKdSolo = findViewById(R.id.txtKDSolo);
        txtKdDuo = findViewById(R.id.txtKDDuo);
        txtKdSquad = findViewById(R.id.txtKDSquad);
        txtWinSolo = findViewById(R.id.txtWinSolo);
        txtWinDuo = findViewById(R.id.txtWinDuo);
        txtWinSquad = findViewById(R.id.txtWinSquad);
        txtSPMSolo = findViewById(R.id.txtSPMSolo);
        txtSPMDuo = findViewById(R.id.txtSPMDuo);
        txtSPMSquad = findViewById(R.id.txtSPMSquad);
        txtNickTitulo = findViewById(R.id.txtNickTitulo);


    }

    public String getFormattedDate(long millis)  {
        DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        String localTime = date.format(millis);

        return localTime;
    }

    @Override
    public void onResponse(Profile profile) {
        adapter.setData(profile.getLifeTimeStats());

        txtNickTitulo.setText(profile.getEpicUserHandle());

        //Recogida de TOP 1
        txtTop1Solo.setText(profile.getStats().getP2().getTop1().toString());
        txtTop1Duo.setText(profile.getStats().getP10().getTop1().toString());
        txtTop1Squad.setText(profile.getStats().getP9().getTop1().toString());

        //Recogida de KD
        txtKdSolo.setText(profile.getStats().getP2().getKd().toString());
        txtKdDuo.setText(profile.getStats().getP10().getKd().toString());
        txtKdSquad.setText(profile.getStats().getP9().getKd().toString());

        //RECOGIDA DE WIN

        txtWinSolo.setText(profile.getStats().getP2().getWinRatio().toString());
        txtWinDuo.setText(profile.getStats().getP10().getWinRatio().toString());
        txtWinSquad.setText(profile.getStats().getP9().getWinRatio().toString());


        //RECOGIDA DE SPM

        txtSPMSolo.setText(profile.getStats().getP2().getScorePerMatch().toString());
        txtSPMDuo.setText(profile.getStats().getP10().getScorePerMatch().toString());
        txtWinSquad.setText(profile.getStats().getP9().getScorePerMatch().toString());



    }
}