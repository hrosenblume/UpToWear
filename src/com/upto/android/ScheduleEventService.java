package com.upto.android;

import java.util.Collection;
import java.util.HashSet;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.Wearable;

public class ScheduleEventService extends IntentService implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{
    private static final String TAG = "UPTO-REPORT-WEAR";
    protected static final String PARAM_IN_MSG = "imsg";
    protected static final String PARAM_OUT_MSG = "omsg";
    protected static final String START_ACTIVITY_PATH = "/outbox/upto";
    private GoogleApiClient mGoogleApiClient;
    
	public ScheduleEventService(String name) {
		super(name);
	}
	
	public ScheduleEventService() {
		super("name");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
        String msg = intent.getStringExtra(PARAM_IN_MSG);
        //sendMessage(msg);
        Log.d(TAG, "Message received in intent service: " + msg);
    }

    private void sendMessage(String msgString) {
        byte[] msg = msgString.getBytes();
        Collection<String> nodeIDs = getNodes();
        for (String node : nodeIDs) {
            SendMessageResult result = Wearable.MessageApi.sendMessage(
                    mGoogleApiClient, node, START_ACTIVITY_PATH, msg).await();
            if (!result.getStatus().isSuccess()) {
                Log.e(TAG, "ERROR: failed to send Message: " + result.getStatus());
            }
        }
    }

    private Collection<String> getNodes() {
        HashSet<String> results= new HashSet<String>();
        NodeApi.GetConnectedNodesResult nodes =
                Wearable.NodeApi.getConnectedNodes(mGoogleApiClient).await();
        for (Node node : nodes.getNodes()) {
            results.add(node.getId());
        }
        return results;
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        Log.e(TAG, "onConnected");
    }

    @Override
    public void onConnectionSuspended(int cause) {
        Log.e(TAG, "onConnectionSuspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.e(TAG, "onConnectionFailed");
    }

}
