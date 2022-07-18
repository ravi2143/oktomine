package com.oktomine.mining.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class loginModal {

    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("vcard")
    @Expose
    private String vcard;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("pascode")
    @Expose
    private String pascode;


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVcard() {
        return vcard;
    }

    public void setVcard(String vcard) {
        this.vcard = vcard;
    }

    public String getPascode() {
        return pascode;
    }

    public void setPascode(String pascode) {
        this.pascode = pascode;
    }
}
