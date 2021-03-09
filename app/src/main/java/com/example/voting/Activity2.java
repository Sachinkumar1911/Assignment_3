package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    int c1;
    int c2;
    int c3;
    ArrayList<String> listcan=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent=getIntent();
        c1=intent.getExtras().getInt("cand1");
        c2=intent.getExtras().getInt("cand2");
        c3=intent.getExtras().getInt("cand3");
        final EditText names=findViewById(R.id.Vname);
        final EditText id=findViewById(R.id.vid);
        final Spinner selection=findViewById(R.id.spinner);
        final ToggleButton agree=findViewById(R.id.toggleButton);
        final Button btn=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_v=id.getText().toString();
                String name_v=names.getText().toString();
                String select=selection.getItemAtPosition(0).toString();
                String selected=selection.getSelectedItem().toString();
                if(agree.isChecked() && !id_v.isEmpty() && !name_v.isEmpty() && !selected.equals(select)){
                    if(!listcan.contains(id_v)){
                        listcan.add(id_v);
                        Log.d("Result", "onClick: Success");
                        Context tstmsgs=getApplicationContext();
                        CharSequence txtmsg="Your vote was recorded";
                        int duration= Toast.LENGTH_LONG;
                        Toast t=Toast.makeText(tstmsgs,txtmsg,duration);
                        t.show();
                        if(selected.equals(selection.getItemAtPosition(1).toString())){
                            c1++;
                        }
                        else if(selected.equals(selection.getItemAtPosition(2).toString())){
                            c2++;
                        }
                        else {
                            c3++;
                        }
                    }
                    else{

                        Log.d("Result", "onClick: Failed");
                        Context tstmsgf=getApplicationContext();
                        CharSequence txtmsg="Sorry!! you already voted";
                        int duration= Toast.LENGTH_LONG;
                        Toast t=Toast.makeText(tstmsgf,txtmsg,duration);
                        t.show();
                    }
                }
                else{
                    Context tstmsg=getApplicationContext();
                    CharSequence txtmsg="please fill all details";
                    int duration= Toast.LENGTH_LONG;
                    Toast t=Toast.makeText(tstmsg,txtmsg,duration);
                    t.show();
                }
            }
        });

    }
    @Override
    public void onBackPressed(){
        Intent i=new Intent();
        i.putExtra("can1upd",c1);
        i.putExtra("can2upd",c2);
        i.putExtra("can3upd",c3);
        setResult(RESULT_OK,i);
        finish();


    }

}