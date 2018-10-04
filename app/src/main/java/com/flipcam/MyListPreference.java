package com.flipcam;

import android.content.Context;
import android.preference.ListPreference;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyListPreference extends ListPreference {

    Context mContext;
    boolean enableSeparator;
    public static final String TAG = "MyListPreference";

    public MyListPreference(Context context, boolean enableSep) {
        super(context);
        mContext = context;
        enableSeparator = enableSep;
    }

    @Override
    protected void onBindView(View view) {
        Log.d(TAG, "onBindView = "+view);
        TextView title = (TextView)view.findViewById(R.id.resolTitle);
        title.setText(getTitle());
        TextView summary = (TextView)view.findViewById(R.id.resolSummary);
        summary.setText(getSummary());
        LinearLayout seperator = (LinearLayout)view.findViewById(R.id.separator);
        seperator.setVisibility(enableSeparator ? View.VISIBLE : View.GONE);
        super.onBindView(view);
    }

    @Override
    public void setEntries(CharSequence[] entries) {
        super.setEntries(entries);
        Log.d(TAG, "setEntries");
    }

    @Override
    public void setEntryValues(CharSequence[] entryValues) {
        super.setEntryValues(entryValues);
        Log.d(TAG, "setEntryValues");
    }
}