package com.example.android.musicplayer;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

        public class MainActivity extends AppCompatActivity {
        private MediaPlayer mediaPlayer;
    @Override
         protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        Button playButton = (Button)findViewById(R.id.play_btn);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                        Toast.makeText
                        (MainActivity.this,
                                "I'm done!",
                         Toast.LENGTH_SHORT).show();
                    }});}}
                    );

        Button pauseButton = (Button)findViewById(R.id.pause_btn);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }});

        Button stopButton = (Button)findViewById(R.id.stop_btn);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }}); }


    private void releaseMediaPlayer(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
