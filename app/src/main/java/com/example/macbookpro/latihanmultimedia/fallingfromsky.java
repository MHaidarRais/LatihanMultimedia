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

public class fallingfromsky extends AppCompatActivity {

    @BindView(R.id.videoStreaming)
    VideoView videoStreaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fallingfromsky);
        ButterKnife.bind(this);


        final ProgressDialog dialog = new ProgressDialog(fallingfromsky.this);
        dialog.setMessage("Mohon Tunggu");
        dialog.setTitle("Loading");
        dialog.setIndeterminate(false);
        dialog.setCancelable(false);
        dialog.show();

        MediaController controller = new MediaController(this);
        controller.setAnchorView(videoStreaming);
        videoStreaming.setMediaController(controller);

        String url = "https://r2---sn-2uuxa3vh-jb3z.googlevideo.com/videoplayback?ipbits=0&ratebypass=yes&expire=1519306852&fvip=3&sparams=dur,ei,expire,id,initcwndbps,ip,ipbits,itag,lmt,mime,mip,mm,mn,ms,mv,pcm2cms,pl,ratebypass,requiressl,source&c=WEB&ei=BHSOWrzIKceJ1wL7i674Dg&lmt=1516079923859299&source=youtube&mime=video%2Fmp4&itag=22&key=cms1&ip=144.76.118.103&pl=21&id=o-AAh1omjrfLFeaZUz4zhMrEJLmO5l5Cj7IeoXhngRHeqe&signature=4E9BB25CA01A705D9BFAF8EABAFC4B0DF16C497F.7496DDADEA884A9CDC099870FBC9B9E87C2B72F1&requiressl=yes&dur=100.194&title=GoPro%20Awards%20%20Frozen%20Lake%20Free%20Dive&cms_redirect=yes&mip=36.77.221.5&mm=31&mn=sn-2uuxa3vh-jb3z&ms=au&mt=1519285178&mv=m&pcm2cms=yes";
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
