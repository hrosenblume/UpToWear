package com.upto.android;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by hunter on 7/31/14.
 */
public class UserOptions {
    private static final String TAG = UserOptions.class.getSimpleName();

    public static final String[] OPTIONS = new String[] {
            "Schedule Event",
            "My Events",
            "All Events",
            "Discover"
    };

    public static void run(Context context, String option) {
        if (option.equals(UserOptions.OPTIONS[0])) {
            Intent scheduleEventIntent = new Intent(context, ScheduleEventActivity.class);
            scheduleEventIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(scheduleEventIntent);
        } else if (option.equals(UserOptions.OPTIONS[1])) {
            Log.d(TAG, UserOptions.OPTIONS[1]);
        } else if (option.equals(UserOptions.OPTIONS[2])) {
            Log.d(TAG, UserOptions.OPTIONS[2]);
        } else if (option.equals(UserOptions.OPTIONS[3])) {
            Log.d(TAG, UserOptions.OPTIONS[3]);
        }
    }
}
