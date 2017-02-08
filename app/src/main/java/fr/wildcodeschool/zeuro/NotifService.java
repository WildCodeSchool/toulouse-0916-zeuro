package fr.wildcodeschool.zeuro;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fr.wildcodeschool.zeuro.DBHandler.DBHandler;

/**
 * Created by apprenti on 07/02/17.
 */

public class NotifService extends Service {

    private DBHandler dbHandler = new DBHandler(this);
    private ForfaitModel comparetForfait = null;
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

        if (intent == null) {
            return START_STICKY;
        }
        Toast.makeText(this, "Service is Start", Toast.LENGTH_SHORT).show();
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRefs = database.child("forfaits");

        myRefs.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ForfaitModel forfait = dataSnapshot.getValue(ForfaitModel.class);
                if (forfait.getAppels() >= dbHandler.getsavesseekbar().get(0)[0] && forfait.getAppels() <= dbHandler.getsavesseekbar().get(0)[1]
                        && forfait.getPrix() >= dbHandler.getsavesseekbar().get(1)[0] && forfait.getPrix() <= dbHandler.getsavesseekbar().get(1)[1]
                        && forfait.getInternet() >= dbHandler.getsavesseekbar().get(2)[0] && forfait.getInternet() <= dbHandler.getsavesseekbar().get(2)[1]
                        && forfait.getSms() >= dbHandler.getsavesseekbar().get(3)[0] && forfait.getSms() <= dbHandler.getsavesseekbar().get(3)[1]
                        && forfait.getMms() >= dbHandler.getsavesseekbar().get(4)[0] && forfait.getMms() <= dbHandler.getsavesseekbar().get(4)[1]) {
                    if(comparetForfait == null) {
                        comparetForfait = new ForfaitModel();
                        comparetForfait = forfait;
                        showNotif(comparetForfait);
                    }
                    if(comparetForfait.getPrix() > forfait.getPrix()){
                        comparetForfait = new ForfaitModel();
                        comparetForfait = forfait;
                        showNotif(comparetForfait);
                    }

                }

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
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service is Destroy", Toast.LENGTH_SHORT).show();
    }

    public void showNotif(ForfaitModel forfait){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.splash)
                        .setVibrate(new long[]{400, 400, 400, 400})
                        .setContentTitle("Zeuro")
                        .setContentText("nouveaux forfaits disponibles!!" + forfait.getPrix()+"€");
// Creates an explicit intent for an Activity in your app
        Intent notifIntent = new Intent(this, MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
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
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(0, mBuilder.build());
    }
}
