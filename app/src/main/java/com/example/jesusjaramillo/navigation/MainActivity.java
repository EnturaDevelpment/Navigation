package com.example.jesusjaramillo.navigation;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView mensaje;
    final int RQS_PICKCONTACT = 1;
    FragmentActivity current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
//                startActivityForResult(intent, 1);
//
//
//
//
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Fragment fragment=null;
        Class fragmentClass= null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            //Toast.makeText(getApplicationContext(), "NO data!", Toast.LENGTH_LONG).show();
            fragmentManager.beginTransaction().replace(R.id.content_frame , Fr_PurchaseAirTime.newInstance( fragmentManager),Fr_PurchaseAirTime.TAG).commit();

        } else if (id == R.id.nav_slideshow) {
            //fragmentClass = Fr_PurchaseAirTime.class;
            fragmentManager.beginTransaction().replace(R.id.content_frame , Fr_PurchaseAirTime2.newInstance( fragmentManager),Fr_PurchaseAirTime2.TAG).commit();


        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }




        //FragmentManager fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.content_frame , Fr_PurchaseAirTime.newInstance( current.getSupportFragmentManager())).commit();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(reqCode == RQS_PICKCONTACT){
                Uri returnUri = data.getData();
                Cursor cursor = getContentResolver().query(returnUri, null, null, null, null);

                if(cursor.moveToNext()){
                    int columnIndex_ID = cursor.getColumnIndex(ContactsContract.Contacts._ID);
                    String contactID = cursor.getString(columnIndex_ID);

                    int columnIndex_HASPHONENUMBER = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
                    String stringHasPhoneNumber = cursor.getString(columnIndex_HASPHONENUMBER);

                    if(stringHasPhoneNumber.equalsIgnoreCase("1")){
                        Cursor cursorNum = getContentResolver().query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactID,
                                null,
                                null);

                        //Get the first phone number
                        if(cursorNum.moveToNext()){
                            int columnIndex_number = cursorNum.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                            String stringNumber = cursorNum.getString(columnIndex_number);
                            //mensaje2.setText(stringNumber);
                        }

                    }else{
                        //mensaje2.setText("NO Phone Number");
                    }


                }else{
                    Toast.makeText(getApplicationContext(), "NO data!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}
