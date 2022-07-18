package com.oktomine.mining.activity;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;


/**
 * Created by Ravi Shankar on 4/26/2017.
 */

public class Session {
    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;
    Context ctx;
    public static final String KEY_USERID ="UserId";
    public static final String KEY_NAME ="Uname";
    public static final String KEY_LOCATION ="ULocation";
    public static final String KEY_GEND ="Ugend";
    public static final String KEY_EMAIL ="UEmail";
    public static final String KEY_PROPIC ="Propicuri";
    public static final String KEY_UMOBILE ="UPhone";
    public static final String KEY_UCITY ="UserCity";
    public static final String KEY_USLOC ="UserArea";
    public static final String KEY_SPONREFFID ="RefferID";
    public static final String KEY_SPSIDE = "SpSide";
    public static final String KEY_FIREBASEID = "FireBaseId";
    public static final String KEY_VCARDSTAT = "VcardStat";
    public static final String KEY_PASSCODE = "PasCode";


    public Session(Context context) {
       // sp = PreferenceManager.getDefaultSharedPreferences(context);
        this.ctx = context;
        sp =ctx.getSharedPreferences("GoVcard", Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }



    public boolean setLogin(boolean status) {
        spEditor.putBoolean("is_logged_in", status);
        spEditor.apply();
        return true;
    }


    public void setMember(String userId, String uname, String mobile, String email, String Pascode){
        spEditor.putString("UserId", userId );
        spEditor.putString("Uname", uname);
        spEditor.putString("UPhone", mobile);
        spEditor.putString("UEmail", email);
        spEditor.putString("PasCode", Pascode);
        spEditor.apply();
    }

    public void setSponsor(String sponsor,String Side) {
        spEditor.putString("RefferID",sponsor);
        spEditor.putString("SpSide",Side);
        spEditor.apply();
    }

    public void setLocation(double lat, double lon, String city , String area){
        spEditor=sp.edit();
        spEditor.putString("Lati", String.valueOf(lat));
        spEditor.putString("Longi", String.valueOf(lon));
        spEditor.putString("UserCity", city);
        spEditor.putString("UserArea", area);
        spEditor.apply();
    }

    public HashMap<String, String> getSponsor(){
        HashMap<String, String> sponsor = new HashMap<String, String>();
        sponsor.put(KEY_SPONREFFID, sp.getString(KEY_SPONREFFID, null));
        sponsor.put(KEY_SPSIDE, sp.getString(KEY_SPSIDE, null));
        return sponsor;
    }

    public HashMap<String, String> getUserLocation(){
        HashMap<String, String> ulocation = new HashMap<String, String>();
        // user location
        ulocation.put(KEY_UCITY, sp.getString(KEY_UCITY, null));
        ulocation.put(KEY_USLOC, sp.getString(KEY_USLOC, null));

        return ulocation;
    }

    public HashMap<String, String> getFirebasid(){
        HashMap<String, String> firebaseid = new HashMap<String, String>();
        // user location
        firebaseid.put(KEY_FIREBASEID, sp.getString(KEY_FIREBASEID, null));

        return firebaseid;
    }

    public HashMap<String, String> getVcardStat(){
        HashMap<String, String> vcardstat = new HashMap<String, String>();
        // user location
        vcardstat.put(KEY_VCARDSTAT, sp.getString(KEY_VCARDSTAT, null));

        return vcardstat;
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, sp.getString(KEY_NAME, null));
        user.put(KEY_LOCATION, sp.getString(KEY_LOCATION, null));
        user.put(KEY_GEND, sp.getString(KEY_GEND, null));
        user.put(KEY_EMAIL, sp.getString(KEY_EMAIL, null));
        user.put(KEY_USERID, sp.getString(KEY_USERID, null));
        user.put(KEY_PROPIC, sp.getString(KEY_PROPIC, null));
        user.put(KEY_UMOBILE, sp.getString(KEY_UMOBILE, null));
        user.put(KEY_PASSCODE, sp.getString(KEY_PASSCODE, null));

        return user;
    }

    public boolean getLoggedIn() {
        return sp.getBoolean("is_logged_in", false);
    }


    public void setFireBaseid(String token) {
        spEditor.putString("FireBaseId",token);
        spEditor.apply();
    }

    public void setVcardStatus(String vcardstat) {
        spEditor.putString("VcardStat",vcardstat);
        spEditor.apply();
    }


}
