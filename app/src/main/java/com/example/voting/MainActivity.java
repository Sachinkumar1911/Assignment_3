package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int candidate1=2;
    int candidate2=2;
    int candidate3=2;
    TextView  candidates;
    TextView  candidateh;
    TextView  candidatea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        candidates=findViewById(R.id.can1);
        candidateh=findViewById(R.id.can2);
        candidatea=findViewById(R.id.can3);
        candidates.setText("Sachin got "+candidate1+" votes");
        candidateh.setText("Hiral got "+candidate2+" votes");
        candidatea.setText("Arvind got "+candidate3+" votes");

    }
    public void onActivityResult(int requestCode, int resultCode,Intent i){
        super.onActivityResult(requestCode,resultCode,i);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                candidate1=i.getExtras().getInt("can1upd");
                candidate2=i.getExtras().getInt("can2upd");
                candidate3=i.getExtras().getInt("can3upd");
                candidates.setText("Sachin got "+candidate1+" votes");
                candidateh.setText("Hiral got "+candidate2+" votes");
                candidatea.setText("Arvind got "+candidate3+" votes");
            }
        }
    }
    public void Votingcan(View view){
        Intent i=new Intent(this,Activity2.class);
        i.putExtra("cand1",candidate1);
        i.putExtra("cand2",candidate2);
        i.putExtra("cand3",candidate3);
        startActivityForResult(i,1);

    }
}