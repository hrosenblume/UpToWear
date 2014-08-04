package com.upto.android;


import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hunter on 7/29/14.
 */
public final class Adapter extends WearableListView.Adapter {
    private static final String TAG = Adapter.class.getSimpleName();
    private final Context mContext;
    private final LayoutInflater mInflater;

    public Adapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }
    
    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WearableListView.ViewHolder(
                mInflater.inflate(R.layout.list_item, null));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
        //TextView view = (TextView) holder.itemView.findViewById(R.id.name);
        //view.setText(mContext.getString(NotificationPresets.PRESETS[position].nameResId));
    	//ImageView uptoLogo = new ImageView(getApplicationContext());
    	if (position == 0) {
    		View uptoView = (View) holder.itemView.findViewById(R.id.uptoview);
    		uptoView.setVisibility(View.VISIBLE);
    		TextView textView = (TextView) holder.itemView.findViewById(R.id.name);
    		textView.setVisibility(View.GONE);
    		ImageView circleView = (ImageView) holder.itemView.findViewById(R.id.circle);
    		circleView.setVisibility(View.GONE);
    		return;
    	} else {
    		View uptoView = (View) holder.itemView.findViewById(R.id.uptoview);
    		uptoView.setVisibility(View.GONE);
    		ImageView circleView = (ImageView) holder.itemView.findViewById(R.id.circle);
    		circleView.setVisibility(View.VISIBLE);
    	}
        TextView textView = (TextView) holder.itemView.findViewById(R.id.name);
        textView.setText(UserOptions.OPTIONS[position]);
        textView.setVisibility(View.VISIBLE);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return UserOptions.OPTIONS.length;
        //return NotificationPresets.PRESETS.length;
    }
}
