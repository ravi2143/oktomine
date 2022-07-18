package com.oktomine.mining.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.oktomine.mining.R;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class SplashActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    Session session;
    ImageView logo;
    String Userid;
    private static final int READ_PHONE_STATE =123;

    String[] permlist = {Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        session= new Session(SplashActivity.this);
        Userid = session.getUserDetails().get(Session.KEY_USERID);
        logo = findViewById(R.id.logo);
        // versioncode = BuildConfig.VERSION_CODE;


//        if(CheckNetwork.isInternetAvailable(this)){
////
////        }else{
////            Toast.makeText(SplashActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();
////        }

        if(hasReadPhoneState()) {
            startApp();
        }else{
            EasyPermissions.requestPermissions(SplashActivity.this,
                    getString(R.string.request_read_phone_state),
                    READ_PHONE_STATE,permlist);
        }//has permissions

        YoYo.with(Techniques.Bounce).duration(7000).playOn(logo);
    }

    public void startApp(){
        new Handler().postDelayed(new Runnable() {

            @SuppressLint("PrivateResource")
            @Override
            public void run() {

                if (session.getLoggedIn()) {
                    Intent i = new Intent(SplashActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();
                    overridePendingTransition(R.anim.entry, R.anim.exit);
                } else {
                    Intent i = new Intent(SplashActivity.this,
                            LoginActivity.class);
                    startActivity(i);
                    finish();
                    overridePendingTransition(R.anim.entry, R.anim.exit);
                }
            }

        }, 1000);
    }

    private boolean hasReadPhoneState(){
        return EasyPermissions.hasPermissions(this,permlist);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        startApp();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

        EasyPermissions.requestPermissions(SplashActivity.this,
                getString(R.string.request_read_phone_state),
                READ_PHONE_STATE, permlist);
    }
}