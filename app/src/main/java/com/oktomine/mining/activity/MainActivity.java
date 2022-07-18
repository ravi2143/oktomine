package com.oktomine.mining.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.oktomine.mining.R;
import com.oktomine.mining.config.Config;
import com.oktomine.mining.fragment.MainFragment;
import com.oktomine.mining.interfactor.Apiinterface;
import com.oktomine.mining.network.ApiClint;
import com.oktomine.mining.util.NotificationUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener{

    private DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;

    private Handler mHandler;
    private final String FRAG_TAG_HOME = "Home";
    private final String FRAG_TAG_CREATE_VCARD = "CreateVcard";
    private String fragTagCurrent = null;
    final float scaleFactor = 5F;
    Session session;
    int Firstintent;
    RelativeLayout content;
    private Toolbar toolbar;
    TextView logout;

    String Userid,teamside="A";
    int smileemoji = 0x1F60A;
    Apiinterface apiinterface;
    Button cancle,confirm;
    private String sponsside ="Team A";
    TextView sponid;

    private ArrayList<String> mTitles = new ArrayList<>();
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        session= new Session(this);
        Userid = session.getUserDetails().get(Session.KEY_USERID);
        apiinterface = ApiClint.getApiClint().create(Apiinterface.class);

        mNavigationView = (NavigationView) findViewById(R.id.menunav);
        mNavigationView.setItemIconTintList(null);

        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        content= findViewById(R.id.content);
        logout=findViewById(R.id.logout);


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }

                if (menuItem.getItemId() == R.id.notification) {
                    Intent intent = new Intent(MainActivity.this,notificationActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.wallet) {
                    Intent intent = new Intent(MainActivity.this, walletActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.refer) {
                    Toast.makeText(getApplicationContext(),"rateus",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,RefferAFriendActivity.class);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.settings) {
                    Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.support) {
                    Intent intent = new Intent(MainActivity.this,SupportActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.logout) {
                    Intent intent = new Intent(MainActivity.this, SplashActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    session.setLogin(false);

                    Toast.makeText(getApplicationContext(),"search",Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(MainActivity.this,UserProfileActivity.class);
                    //startActivity(intent);
                }
                return false;
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                toolbar.setBackgroundResource(R.drawable.rounded_corners_default);
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);

                if (fragTagCurrent != null) {
                    loadFragment(fragTagCurrent);
                    fragTagCurrent = null;
                }
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                float slidex= (drawerView.getWidth()* slideOffset);

                content.setTranslationX(slidex);
                content.setScaleX(1 - slideOffset / scaleFactor);
                content.setScaleY(1 - slideOffset/scaleFactor);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                toolbar.setBackgroundResource(R.drawable.rounded_corners);

                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }

        };

        //Setting the actionbarToggle to drawer layout
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerLayout.setDrawerElevation(0f);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

//        String vstat= session.getVcardStat().get(Session.KEY_VCARDSTAT);
//        Log.e("SessionVstat", "Vcard: "+vstat);
//
//        if(vstat.equals("true")) {
//                Log.e("Vstat", "Vcard Created");
//            loadFragment(FRAG_TAG_HOME);
//        }else {
//            Log.e("Vstat", "Vcard Not Created");
//            loadFragment(FRAG_TAG_CREATE_VCARD);
//        }
        //GetVcardStatus(Userid);
        loadFragment(FRAG_TAG_HOME);

        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // checking for type intent filter
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
                    displayFirebaseRegId();

                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    // new push notification is received
                    String message = intent.getStringExtra("message");
                    Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();
                    //txtMessage.setText(message);
                }
            }
        };
        displayFirebaseRegId();

    }

    private void loadFragment(final String fragTag) {
        Fragment fragment = null;
        //toolbarLayout.setVisibility(View.GONE);
        if (FRAG_TAG_HOME.equals(fragTag)) {//toolbarLayout.setVisibility(View.VISIBLE);
            fragment = new MainFragment();
        }

        getSupportActionBar().setTitle(fragTag);
        getSupportActionBar().setDisplayShowTitleEnabled(!fragTag.equals(FRAG_TAG_HOME));

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        final Fragment finalFragment = fragment;
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.mainFrame, finalFragment,fragTag);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        if (mHandler == null)
            mHandler = new Handler();
        if (getSupportFragmentManager().findFragmentByTag(fragTag) == null)
            mHandler.post(mPendingRunnable);
    }

    private void displayFirebaseRegId() {
        String regId = session.getFirebasid().get(Session.KEY_FIREBASEID);

        Log.e(TAG, "Firebase reg id: " + regId);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Toast.makeText(MainActivity.this,"Internet Connected",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(MainActivity.this,"Internet Not Connected",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(MainActivity.this,"Internet Not Connected",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

    }

    @Override
    protected void onResume() {
        super.onResume();

        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());

        // register connection status listener
        AppController.getInstance().setConnectivityListener(this);
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}