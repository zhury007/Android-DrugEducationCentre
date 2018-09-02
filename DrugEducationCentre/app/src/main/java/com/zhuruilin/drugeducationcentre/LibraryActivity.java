package com.zhuruilin.drugeducationcentre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                Intent intent = new Intent(LibraryActivity.this, QuestionnaireActivity.class);
                startActivity(intent);
            }
        });
    }
}
