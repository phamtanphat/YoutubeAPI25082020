package com.example.youtubeapi25082020;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends AppCompatActivity {

    YouTubePlayerView mYouTubePlayerView;
    String API_KEY = "AIzaSyALHrxyABQhidGnlUF4aMH1vFpvQSHCuCc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYouTubePlayerView = findViewById(R.id.youtubePlayerView);

        mYouTubePlayerView.initialize(API_KEY, initPlayer);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 123 && resultCode == RESULT_OK){
            mYouTubePlayerView.initialize(API_KEY, initPlayer);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private YouTubePlayer.OnInitializedListener initPlayer = new YouTubePlayer.OnInitializedListener() {
        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
            youTubePlayer.loadVideo();
        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
            if (result.isUserRecoverableError()){
                result.getErrorDialog(MainActivity.this,123);
            }
        }
    };


}