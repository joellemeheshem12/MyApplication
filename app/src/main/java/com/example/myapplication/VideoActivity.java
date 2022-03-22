package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Objects;

public class VideoActivity extends AppCompatActivity {

    YouTubePlayerView fly;
    YouTubePlayerView back1;
    YouTubePlayerView back2;
    YouTubePlayerView breastStroke;
    YouTubePlayerView free;
    YouTubePlayerView turn1;
    YouTubePlayerView turn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        YouTubePlayerView fly = findViewById(R.id.flyVideo1);
        YouTubePlayerView back1 = findViewById(R.id.backVideo1);
        YouTubePlayerView back2 = findViewById(R.id.backVideo2);
        YouTubePlayerView breastStroke = findViewById(R.id.breastVideo);
        YouTubePlayerView free = findViewById(R.id.freeVideo);
        YouTubePlayerView turn1 = findViewById(R.id.turnVideo1);
        YouTubePlayerView turn2 = findViewById(R.id.turnVideo2);

        getLifecycle().addObserver(fly);
        fly.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "VQpFhM18zu4";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        getLifecycle().addObserver(back1);
        back1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "YkjOvxHsY1g";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        getLifecycle().addObserver(back2);
        back2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "MrFt6JHii8w";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        getLifecycle().addObserver(breastStroke);
        breastStroke.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "rPrSVDBdaDM";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        getLifecycle().addObserver(free);
        free.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "uiI6Z_0Q2Io";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        getLifecycle().addObserver(turn1);
        turn1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "PqXrZuNCthg";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        getLifecycle().addObserver(turn2);
        turn2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "rPrSVDBdaDM";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

    }
}