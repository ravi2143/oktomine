package com.oktomine.mining.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.oktomine.mining.R;
import com.oktomine.mining.interfactor.Apiinterface;
import com.oktomine.mining.modal.loginModal;
import com.oktomine.mining.network.ApiClint;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView forgotpwd,signup;
    EditText etusername,etpassword;
    Button loginbtn;
    String userid,pwd;
    private Session session;
    // public static final String TAG = "MyTag";
    public static Apiinterface apiinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        apiinterface = ApiClint.getApiClint().create(Apiinterface.class);

        session = new Session(LoginActivity.this);

        etusername =  findViewById(R.id.username);
        etpassword =  findViewById(R.id.password);
        loginbtn= findViewById(R.id.loginbtn);
        forgotpwd = findViewById(R.id.forgotpwd);
        signup =findViewById(R.id.signup);

        loginbtn.setOnClickListener(this);
        forgotpwd.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginbtn:

                //LoginProcess();

                Intent loginintent = new Intent(LoginActivity.this,
                        MainActivity.class);
                startActivity(loginintent);
                overridePendingTransition(R.anim.entry, R.anim.exit);
                finish();

                break;
            case R.id.forgotpwd:

                Intent fintent = new Intent(LoginActivity.this,
                        ForgotPwdOptions.class);
                startActivity(fintent);
                overridePendingTransition(R.anim.entry, R.anim.exit);
                finish();

                break;

            case R.id.signup:
                RegistratonPage();
                break;
        }
    }

    private void LoginProcess() {
        userid = etusername.getText().toString().trim();
        pwd = etpassword.getText().toString().trim();

        if (validateusername(userid) && validatePassword(pwd)) { //Username and Password Validation
            //Progress Bar while connection establishes
            final KProgressHUD progressDialog = KProgressHUD.create(LoginActivity.this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel("Please wait")
                    .setCancellable(false)
                    .setAnimationSpeed(2)
                    .setDimAmount(0.5f)
                    .show();

            Call<loginModal> call = apiinterface.performLogin(userid,pwd);
            call.enqueue(new Callback<loginModal>() {
                @Override
                public void onResponse(@NotNull Call<loginModal> call, @NotNull Response<loginModal> response) {
                    progressDialog.dismiss();

                    if (response.body() != null) {
                        if(response.body().getSuccess().equals("true")){

                            String userId = response.body().getUserid();
                            String uname = response.body().getName();
                            String mobile = response.body().getPhone();
                            String email = response.body().getEmail();
                            String passcode = response.body().getPascode();

                            session.setLogin(true);
                            session.setMember(userId, uname, mobile,email,passcode);
                            //count value of firebase cart and wishlist

                            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();


                            Intent intent = new Intent(LoginActivity.this,
                                    MainActivity.class);
                            intent.putExtra("UserId", userId);
                            intent.putExtra("uname", uname);
                            startActivity(intent);
                            overridePendingTransition(R.anim.entry, R.anim.exit);
                            finish();


                        }else if(response.body().getSuccess().equals("false")){

                            Toast.makeText(LoginActivity.this,"Invalid Userid Or Password",Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<loginModal> call, @NotNull Throwable t) {
                    progressDialog.dismiss();
                    t.printStackTrace();
                    Toast.makeText(LoginActivity.this,"Slow Network or No Internet Try Agin",Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void RegistratonPage() {

        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.entry, R.anim.exit);
    }

    private  boolean validateusername(String username){
        if(username.length() < 3){
            etusername.setError("User Name Must consist for 3 to 20 characters");
            return false;
        }
        return true;
    }

    private  boolean validatePassword(String password){
        if(password.length() < 3 ){
            etpassword.setError("Please Enter Valid Password");
            return false;
        }
        return true;
    }
}