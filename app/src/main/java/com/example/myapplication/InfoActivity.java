package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class InfoActivity extends AppCompatActivity {

    TextView detailsText1,detailsText2,detailsText3;
    LinearLayout layout1,layout2,layout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));
        detailsText1 = findViewById(R.id.details1);
        layout1 = findViewById(R.id.layout1);
        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        detailsText2 = findViewById(R.id.details2);
        layout2 = findViewById(R.id.layout2);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        detailsText3 = findViewById(R.id.details3);
        layout3 = findViewById(R.id.layout3);
        layout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }

    public void expand1(View view) {
        int v1 =(detailsText1.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;

        TransitionManager.beginDelayedTransition(layout1,new AutoTransition());
        detailsText1.setVisibility(v1);
    }

    public void expand2(View view) {
        int v2 =(detailsText2.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;

        TransitionManager.beginDelayedTransition(layout2,new AutoTransition());
        detailsText2.setVisibility(v2);
    }

    public void expand3(View view) {
        int v2 =(detailsText3.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;

        TransitionManager.beginDelayedTransition(layout3,new AutoTransition());
        detailsText3.setVisibility(v2);
    }
}