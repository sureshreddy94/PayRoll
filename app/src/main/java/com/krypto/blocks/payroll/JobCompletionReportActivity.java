package com.krypto.blocks.payroll;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;


public class JobCompletionReportActivity extends AppCompatActivity {

    ImageView img;
    Toolbar toolbar_jobreport;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_completion_report);
        toolbar_jobreport = findViewById(R.id.toolbar_jobreport);
        initToolBar();
        toolbar_jobreport.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_jobreport.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(JobCompletionReportActivity.this,MapsActivity.class);
               startActivity(i);


            }
        });

        img = findViewById(R.id.send_img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JobCompletionReportActivity.this, WeeklySummaryActivity.class);
                startActivity(i);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void initToolBar() {

        //  toolbar_bitcoin = findViewById(R.id.toolbar_bit);
        toolbar_jobreport.setTitle(R.string.toolbar_for_jobreport);
        toolbar_jobreport.setTitleTextColor(getResources().getColor(R.color.white));
        //setSupportActionBar(toolbar_bitcoin);

    }
}
