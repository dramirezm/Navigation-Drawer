package com.ramirez.diego.navigationdrawer;

import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.ramirez.diego.navigationdrawer.Fragments.FragmentOne;
import com.ramirez.diego.navigationdrawer.Fragments.FragmentThree;
import com.ramirez.diego.navigationdrawer.Fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        myToolbar = (Toolbar)findViewById(R.id.mytolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.hamburguer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;


                switch (menuItem.getItemId())
                {
                    case R.id.item_one:
                        fragment = new FragmentOne();
                        fragmentTransaction = true;
                        break;
                    case R.id.item_two:
                        fragment = new FragmentTwo();
                        fragmentTransaction = true;
                        break;
                    case R.id.item_three:
                        fragment = new FragmentThree();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_opcion_1:
                        Log.e("Menu Opcion 1","Pulsado");
                        break;
                    case R.id.menu_opcion_2:
                        Log.e("Menu Opcion 2","Pulsado");
                        break;

                }


                if (fragmentTransaction)
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container,fragment)
                            .commit();

                    menuItem.setCheckable(true);
                    getSupportActionBar().setTitle(menuItem.getTitle());
                }

                drawerLayout.closeDrawers();

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:

                drawerLayout.openDrawer(GravityCompat.END);

                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
