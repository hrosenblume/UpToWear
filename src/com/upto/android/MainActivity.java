package com.upto.android;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WearableListView listView = (WearableListView) findViewById(R.id.list);
        listView.setAdapter(new Adapter(this));
        listView.setClickListener(new WearableClickListener());
    }

    private class WearableClickListener implements WearableListView.ClickListener {

        @Override
        public void onClick(WearableListView.ViewHolder v) {
            Log.d(TAG, "successful click");
            Log.d(TAG, Integer.toString(v.getPosition()));
            decide(v.getPosition());
        }

        @Override
        public void onTopEmptyRegionClick() {
        }

        private void decide(int position) {
            String option = UserOptions.OPTIONS[position];
            UserOptions.run(getApplicationContext(), option);
        }
    }
}
