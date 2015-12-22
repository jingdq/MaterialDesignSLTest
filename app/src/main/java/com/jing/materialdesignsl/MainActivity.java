package com.jing.materialdesignsl;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout rl_root;

    EditText edit_text_email;

    DrawerLayout drawer_layout;

    NavigationView navigation_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
//        setSupportActionBar(toolbar);
//
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        ab.setDisplayHomeAsUpEnabled(true);


        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);

        rl_root = (CoordinatorLayout) findViewById(R.id.rl_root);
        edit_text_email = (EditText) findViewById(R.id.edit_text_email);
        edit_text_email.setError("error xxxxxx");

        setupDrawerContent(navigation_view);

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);

                        if (menuItem.getItemId() == R.id.nav_messages){

                            Intent it = new Intent(MainActivity.this,TabLayoutActivity.class);

                            MainActivity.this.startActivity(it);

                            return true;

                        }else if(menuItem.getItemId() == R.id.nav_friends){

                            Intent it = new Intent(MainActivity.this,AppBarActivity.class);

                            MainActivity.this.startActivity(it);

                            return true;


                        }else if(menuItem.getItemId() == R.id.nav_discussion){
                            Intent it = new Intent(MainActivity.this,ToolBarsActivity.class);

                            MainActivity.this.startActivity(it);

                            return true;
                        }

                        drawer_layout.closeDrawers();
                        return true;
                    }
                });
    }

    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.btn_toggle:
                drawer_layout.openDrawer(GravityCompat.START);
                break;

            case R.id.btn:
                Snackbar.make(rl_root, "I like eat fish", Snackbar.LENGTH_LONG).setAction("undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("aaa", "click");
                    }
                }).show();
                break;

        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == android.R.id.home){

            drawer_layout.openDrawer(GravityCompat.START);

        }


        return super.onOptionsItemSelected(item);
    }
}
