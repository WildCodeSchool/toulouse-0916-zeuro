package fr.wildcodeschool.zeuro;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by apprenti on 07/02/17.
 */

public class NotifService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service is Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service is Start", Toast.LENGTH_SHORT).show();
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRef = database.child("forfaits");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                /*NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(ProfilActivity.this)
                                .setSmallIcon(R.drawable.splash)
                                .setVibrate(new long[]{400, 400, 400, 400})
                                .setContentTitle("Zeuro")
                                .setContentText("nouveaux forfaits disponibles!!");
// Creates an explicit intent for an Activity in your app
                Intent notifIntent = new Intent(ProfilActivity.this, MainActivity.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(ProfilActivity.this);
// Adds the back stack for the Intent (but not the Intent itself)
                stackBuilder.addParentStack(ProfilActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
                stackBuilder.addNextIntent(notifIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );
                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
                mNotificationManager.notify(0, mBuilder.build());
            }
        }
    });*/

}

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service is Destroy", Toast.LENGTH_SHORT).show();
    }
}
