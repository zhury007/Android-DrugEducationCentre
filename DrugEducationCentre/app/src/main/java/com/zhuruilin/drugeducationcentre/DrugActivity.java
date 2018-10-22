package com.zhuruilin.drugeducationcentre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhuruilin.drugeducationcentre.Drugs.Ecstasy.DrugFragment;
import com.zhuruilin.drugeducationcentre.Drugs.Methamphetamine.MethamphetamineFragment;

public class DrugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug);


        // get the ecstasy activity
        Button btn_ecstasy = (Button) findViewById(R.id.button_ecstasy);
        btn_ecstasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(DrugActivity.this, DrugFragment.class);
                startActivity(intent);
            }

        });

        //get the Methamphetamine activity
        Button btn_meth = (Button) findViewById(R.id.button_Methamphetamine);
        btn_meth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(DrugActivity.this, MethamphetamineFragment.class);
                startActivity(intent);
            }
        });
    }
}

