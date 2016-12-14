package fr.wildcodeschool.zeuro;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class HambMenu extends AppCompatActivity {


    private DrawerLayout mDrawer;

    private Toolbar toolbar;

    private NavigationView nvDrawer;
    private ImageButton hamburger;


    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.

    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.

    private ActionBarDrawerToggle drawerToggle;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hamb_menu);

        // Set a Toolbar to replace the ActionBar.

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        this.hamburger = (ImageButton) findViewById(R.id.idHamb);

        // Find our drawer view

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        this.hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HambMenu.this.mDrawer.openDrawer(Gravity.LEFT);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // The action bar home/up action should open or close the drawer.

        switch (item.getItemId()) {

            case android.R.id.home:

                mDrawer.openDrawer(GravityCompat.START);

                return true;

        }
        return super.onOptionsItemSelected(item);

    }
}
