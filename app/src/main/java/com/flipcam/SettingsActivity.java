package com.flipcam;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    public static final String TAG = "SettingsActivity";
    LinearLayout phoneMemParentVert;
    TextView phoneMemText;
    TextView phoneMemTextMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_settings);
        phoneMemParentVert = (LinearLayout)findViewById(R.id.phoneMemParentVert);
        phoneMemTextMsg = (TextView)findViewById(R.id.phoneMemTextMsg);
        phoneMemText = (TextView)findViewById(R.id.phoneMemText);
        reDrawPhoneMem();
        getSupportActionBar().setTitle(getResources().getString(R.string.settingTitle));
    }

    public void reDrawPhoneMem(){
        Configuration config = getResources().getConfiguration();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if(config.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.d(TAG,"oncreate portrait");
            layoutParams.width = 523;
        }
        else{
            Log.d(TAG,"oncreate landscape");
            layoutParams.width = 750;
        }
        layoutParams.setMargins(20,0,0,0);
        phoneMemParentVert.setLayoutParams(layoutParams);
        phoneMemText.setLayoutParams(layoutParams);
        phoneMemTextMsg.setLayoutParams(layoutParams);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        reDrawPhoneMem();
    }
}
