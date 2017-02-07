package fr.wildcodeschool.zeuro;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.BoringLayout;

/**
 * Created by apprenti on 07/02/17.
 */

public class OnBoot extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Create Intent
        Intent serviceIntent = new Intent(context, NotifService.class);
        // Start service
        context.startService(serviceIntent);
    }
}
