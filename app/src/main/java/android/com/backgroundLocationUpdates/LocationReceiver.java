package android.com.backgroundLocationUpdates;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;

public class LocationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Location location = (Location) intent.getExtras().get("LocationClient");

    }
}