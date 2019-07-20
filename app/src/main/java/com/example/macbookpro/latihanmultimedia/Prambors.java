package com.example.macbookpro.latihanmultimedia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Prambors extends AppCompatActivity {

    @BindView(R.id.progBar)
    ProgressBar progBar;
    @BindView(R.id.btnPlay)
    Button btnPlay;
    @BindView(R.id.btnPause)
    Button btnPause;

    MediaPlayer player;
    String url_radio = "http://103.226.246.42/masima-pramborsjakarta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prambors);
        ButterKnife.bind(this);

        progBar.setIndeterminate(false);
        progBar.setVisibility(View.INVISIBLE);
        progBar.setMax(100);


        setPlaying();
    }
    private void setPlaying() {
        player = new MediaPlayer();
        try {
            player.setDataSource(url_radio);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                progBar.setIndeterminate(true);
            }
        });
    }

    @OnClick({ R.id.btnPlay, R.id.btnPause})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                progBar.setVisibility(View.VISIBLE);
                setProgressBarIndeterminate(true);
                player.prepareAsync();
                player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                        progBar.setIndeterminate(false);
                    }
                });
                break;
            case R.id.btnPause:
                if (player == null) return;
                if (player.isPlaying()){
                    player.stop();
                    player.release();
                    setPlaying();
                    progBar.setVisibility(View.INVISIBLE);
                    progBar.setIndeterminate(true);
                    //TODO set Enable/disable button
                    btnPause.setEnabled(false);
                    btnPlay.setEnabled(true);
                }
                break;
        }
    }
}
