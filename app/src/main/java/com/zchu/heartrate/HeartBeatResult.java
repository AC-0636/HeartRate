package com.zchu.heartrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.zchu.heartrate.R.id.HeartBeatData;

public class HeartBeatResult extends AppCompatActivity
{
    protected Button ReDoButton=null;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_beat_result);
        Redo();
        setResult();


    }

    public void Redo()
    {
        ReDoButton =(Button) findViewById(R.id.ReDoButton);
        ReDoButton.setOnClickListener(onClickredobutton);
    }

    private Button.OnClickListener onClickredobutton = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            Intent RedoIntent =new Intent (HeartBeatResult.this, HeartRateActivity.class);
            startActivity(RedoIntent);
        }
    };
    public void setResult()
    {
        Intent Result =getIntent();
        result = (TextView) findViewById(R.id.HeartBeatData);
        String TempStr=Result.getStringExtra("data");
        result.setText(TempStr);
    }

}
