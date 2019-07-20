package com.example.macbookpro.latihanmultimedia;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class newyorktrip extends AppCompatActivity {


    @BindView(R.id.videoStreaming)
    VideoView videoStreaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newyorktrip);
        ButterKnife.bind(this);

        final ProgressDialog dialog = new ProgressDialog(newyorktrip.this);
        dialog.setMessage("Mohon Tunggu");
        dialog.setTitle("Loading");
        dialog.setIndeterminate(false);
        dialog.setCancelable(false);
        dialog.show();

        MediaController controller = new MediaController(this);
        controller.setAnchorView(videoStreaming);
        videoStreaming.setMediaController(controller);

        String url = "https://r4---sn-2uuxa3vh-jb3z.googlevideo.com/videoplayback?lmt=1508378648411133&sparams=dur,ei,expire,id,initcwndbps,ip,ipbits,itag,lmt,mime,mip,mm,mn,ms,mv,pcm2cms,pl,ratebypass,requiressl,source&ratebypass=yes&ipbits=0&key=cms1&signature=79B87115CF08DCF327761F455367C1B003DF46D9.0B4E26C6859B07C1E5E999DF4771CCB52CE5BF5D&c=WEB&itag=22&ei=xm6OWpTUKs2x1gL3z6_wCw&pl=21&source=youtube&fvip=2&dur=79.946&mime=video%2Fmp4&ip=2a01%3A4f8%3A190%3A7490%3A%3A2&requiressl=yes&expire=1519305510&id=o-AK-z4klvLLZRs6hVumPUU5MSR67FqN5h1aQZwJaw9o_r&title=New%20York%20Trip%20%20CINEMATIC%20%20Sony%20a6000%20%2024mm%201.8%20%2010-18mm%20%20Zhiyun%20Crane&cms_redirect=yes&mip=36.77.221.5&mm=31&mn=sn-2uuxa3vh-jb3z&ms=au&mt=1519283860&mv=m&pcm2cms=yes";
        Uri uri_url = Uri.parse(url);
        videoStreaming.setVideoURI(uri_url);
        videoStreaming.requestFocus();

        videoStreaming.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                dialog.dismiss();
                mediaPlayer.start();
            }
        });
    }
}
