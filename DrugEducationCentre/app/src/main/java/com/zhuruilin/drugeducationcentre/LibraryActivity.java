package com.zhuruilin.drugeducationcentre;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);


        // ================
        Button btn_explore = (Button) findViewById(R.id.button_Test);
        btn_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://wj.qq.com/s/2342832/f761");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
//                Intent intent = new Intent(LibraryActivity.this, QuestionnaireActivity.class);
//                startActivity(intent);
            }
        });

        Button btn_photo = (Button) findViewById(R.id.button_Photography);
        btn_photo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LibraryActivity.this, PhotographActivity.class);
                        startActivity(intent);
                    }
                }
        );

        Button btn_video = (Button) findViewById(R.id.button_Video);
        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LibraryActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}
