package com.example.macbookpro.latihanmultimedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.video1)
    Button video1;
    @BindView(R.id.video2)
    Button video2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.video1, R.id.video2,R.id.prambors,R.id.ir})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.video1:
                startActivity(new Intent(MainActivity.this, newyorktrip.class));
                break;
            case R.id.video2:
                startActivity(new Intent(MainActivity.this, fallingfromsky.class));
                break;
            case R.id.prambors:
                startActivity(new Intent(MainActivity.this, Prambors.class));
            case R.id.ir:
                startActivity(new Intent(MainActivity.this, internetradio.class));
        }
    }
}
