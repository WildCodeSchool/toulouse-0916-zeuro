package fr.wildcodeschool.zeuro;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import fr.wildcodeschool.zeuro.DBHandler.DBHandler;
import fr.wildcodeschool.zeuro.fragment.ListFragment;


public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    private ImageButton imgButtun;
    private Button test;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private Button buttonProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        DBHandler db = new DBHandler(this);
        FilterSingleton.getInstance().setAppelMin(db.getsavesseekbar().get(0)[0]);
        FilterSingleton.getInstance().setAppelMax(db.getsavesseekbar().get(0)[1]);
        FilterSingleton.getInstance().setPrixMin(db.getsavesseekbar().get(1)[0]);
        FilterSingleton.getInstance().setPrixMax(db.getsavesseekbar().get(1)[1]);
        FilterSingleton.getInstance().setInternetMin(db.getsavesseekbar().get(2)[0]);
        FilterSingleton.getInstance().setInternetMax(db.getsavesseekbar().get(2)[1]);
        FilterSingleton.getInstance().setSmsMin(db.getsavesseekbar().get(3)[0]);
        FilterSingleton.getInstance().setSmsMax(db.getsavesseekbar().get(3)[1]);
        FilterSingleton.getInstance().setMmsMin(db.getsavesseekbar().get(4)[0]);
        FilterSingleton.getInstance().setMmsMax(db.getsavesseekbar().get(4)[1]);


        Button profilbtn = (Button) findViewById(R.id.buttonProfil);
        profilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
                startActivityForResult(intent,1);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);


        getFragmentManager().beginTransaction().add(R.id.idListFragment, new ListFragment()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.aide_menu:
                Intent intent = new Intent(this, Helpscreen.class);
                this.startActivity(intent);
                break;
            case R.id.forfaits_internet:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        MainActivity.this);
                // set title
                alertDialogBuilder.setTitle("Disponible prochaînement");
                // set dialog message
                alertDialogBuilder
                       // .setMessage("Pelase select your choice")
                        .setCancelable(false)
                        /*.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                //do whatever you want to do when user clicks ok}
                        })*/
                        .setNegativeButton("Retour",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();}
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
                break;
            case R.id.energie_menu:
                AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(
                        MainActivity.this);
                // set title
                alertDialogBuilder2.setTitle("Disponible prochaînement");
                // set dialog message
                alertDialogBuilder2
                        // .setMessage("Pelase select your choice")
                        .setCancelable(false)
                        /*.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                //do whatever you want to do when user clicks ok}
                        })*/
                        .setNegativeButton("Retour",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();}
                        });
                // create alert dialog
                AlertDialog alertDialog2 = alertDialogBuilder2.create();
                // show it
                alertDialog2.show();
                break;
            case R.id.assurances_menu:
                AlertDialog.Builder alertDialogBuilder3 = new AlertDialog.Builder(
                        MainActivity.this);
                // set title
                alertDialogBuilder3.setTitle("Disponible prochaînement");
                // set dialog message
                alertDialogBuilder3
                        // .setMessage("Pelase select your choice")
                        .setCancelable(false)
                        /*.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                //do whatever you want to do when user clicks ok}
                        })*/
                        .setNegativeButton("Retour",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();}
                        });
                // create alert dialog
                AlertDialog alertDialog3 = alertDialogBuilder3.create();
                // show it
                alertDialog3.show();
                break;
            case R.id.banque_menu:
                AlertDialog.Builder alertDialogBuilder4 = new AlertDialog.Builder(
                        MainActivity.this);
                // set title
                alertDialogBuilder4.setTitle("Disponible prochaînement");
                // set dialog message
                alertDialogBuilder4
                        // .setMessage("Pelase select your choice")
                        .setCancelable(false)
                        /*.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                //do whatever you want to do when user clicks ok}
                        })*/
                        .setNegativeButton("Retour",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();}
                        });
                // create alert dialog
                AlertDialog alertDialog4 = alertDialogBuilder4.create();
                // show it
                alertDialog4.show();
                break;
            case R.id.tips_menu:
                AlertDialog.Builder alertDialogBuilder5 = new AlertDialog.Builder(
                        MainActivity.this);
                // set title
                alertDialogBuilder5.setTitle("Nous contacter ?");
                // set dialog message
                alertDialogBuilder5
                        // .setMessage("Pelase select your choice")
                        .setCancelable(false)
                        .setPositiveButton("Oui",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                Intent intent3 = new Intent(MainActivity.this, Email.class);
                                MainActivity.this.startActivity(intent3);
                        }})

                        .setNegativeButton("Retour",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();}
                        });
                // create alert dialog
                AlertDialog alertDialog5 = alertDialogBuilder5.create();
                // show it
                alertDialog5.show();

                break;
            case R.id.forfaits_menu:
                Intent intent2 = new Intent(this, MainActivity.class);
                this.startActivity(intent2);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.idListFragment)).commit();
        getFragmentManager().beginTransaction().add(R.id.idListFragment, new ListFragment()).commit();
    }

}
