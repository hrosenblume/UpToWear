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
    		"UpTo Logo",
            "Schedule Event",
            "My Events",
            "All Events",
            "Discover"
    };

    public static void run(Context context, String option) {
    	if (option.equals(UserOptions.OPTIONS[0])) {
    		Log.d(TAG, UserOptions.OPTIONS[0]);
    	}
        if (option.equals(UserOptions.OPTIONS[1])) {
            Intent scheduleEventIntent = new Intent(context, ScheduleEventActivity.class);
            scheduleEventIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(scheduleEventIntent);
        } else if (option.equals(UserOptions.OPTIONS[2])) {
            Log.d(TAG, UserOptions.OPTIONS[2]);
            Intent msgIntent = new Intent(context, ScheduleEventService.class);
        	msgIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            msgIntent.putExtra(ScheduleEventService.PARAM_IN_MSG, "myevents");
            context.startService(msgIntent);
        } else if (option.equals(UserOptions.OPTIONS[3])) {
            Log.d(TAG, UserOptions.OPTIONS[3]);
            Intent msgIntent = new Intent(context, ScheduleEventService.class);
        	msgIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            msgIntent.putExtra(ScheduleEventService.PARAM_IN_MSG, "allevents");
            context.startService(msgIntent);
        } else if (option.equals(UserOptions.OPTIONS[4])) {
            Log.d(TAG, UserOptions.OPTIONS[4]);
            Intent msgIntent = new Intent(context, ScheduleEventService.class);
        	msgIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            msgIntent.putExtra(ScheduleEventService.PARAM_IN_MSG, "discover");
            context.startService(msgIntent);
        }
    }
}
