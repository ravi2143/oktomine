package com.oktomine.mining.interfactor;

import com.oktomine.mining.modal.loginModal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface Apiinterface {

    @GET("login/{userid}/{password}")
    Call<loginModal> performLogin(@Path("userid") String Userid, @Path("password") String UserPassword);

//    @Headers({"Content-Type: application/json"})
//    @POST("register")
//    Call<loginModal> performRegistration(@Body JsonObject rawjsonObject);
//
//    @GET("vcardstatus/{userid}")
//    Call<VcardStatModal> performVcardstat(@Path("userid") String Userid);
//
//    @GET("about/{userid}")
//    Call<aboutModal> performAbout(@Path("userid") String Userid);
//
//    @GET("company/{userid}")
//    Call<aboutModal> performCompany(@Path("userid") String Userid);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("aboutupdate")
//    Call<aboutModal> performAboutUpdate(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("aboutcompanyupdate")
//    Call<aboutModal> performAboutCompanyUpdate(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("submitvcard")
//    Call<aboutModal> performsubmitvcard(@Body JsonObject rawjsonObject);
//
//    @GET("profilepic/{userid}")
//    Call<aboutModal> performPropic(@Path("userid") String Userid);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("checkmobilefpwd")
//    Call<VcardStatModal> performmobilenofpwd(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("updatepassword")
//    Call<aboutModal> performUpdatepassword(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("propicupdate")
//    Call<aboutModal> performProPicUpdate(@Body JsonObject rawjsonObject);
//
//    @GET("contact/{userid}")
//    Call<aboutModal> performContact(@Path("userid") String Userid);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("contactupdate")
//    Call<aboutModal> performContactUpdate(@Body JsonObject rawjsonObject);
//
////    @Headers({"Content-Type: application/json"})
////    @POST("paymentprocess")
////    Call<PaymentProcessModal> performPaymentProcess(@Body JsonObject rawjsonObject);
//
//    @GET("paymentstart")
//    Call<PaymentProcessModal> performStart();
//
////    @Headers({"Content-Type: application/json"})
////    @POST("paymentprocesspin")
////    Call<PaymentProcessModal> performPaymentProcessPin(@Body JsonObject rawjsonObject);
//
//    @GET("getwallet/{userid}")
//    Call<aboutModal> performgetWallet(@Path("userid") String Userid);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("savepassword")
//    Call<aboutModal> performsavePassword(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("support")
//    Call<aboutModal> performsupport(@Body JsonObject rawjsonObject);
//
//    @GET("compfilepic/{userid}")
//    Call<aboutModal> performComppic(@Path("userid") String Userid);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("comppicupdate")
//    Call<aboutModal> performCompPicUpdate(@Body JsonObject rawjsonObject);
//
//    @GET("vcardtheme/{userid}/{themeid}")
//    Call<aboutModal> performVcardtheme(@Path("userid") String Userid, @Path("themeid")  int Themeid);
//
//    //skils Process
//    @GET("getskils/{userid}/{pageid}")
//    Call<ArrayList<SkilsModal>> performgetSkils(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("addskill")
//    Call<SkilsModal> performAddSkils(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("editskill")
//    Call<SkilsModal> performEditSkils(@Body JsonObject rawjsonObject);
//
//    @GET("getskilssingle/{userid}/{rowid}")
//    Call<SkilsModal> performgetSkilsSingle(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    @GET("deleteskilssingle/{userid}/{rowid}")
//    Call<SkilsModal> performgetSkilsDelete(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//
//
//    //Achivements Process
//    @GET("getachivements/{userid}/{pageid}")
//    Call<ArrayList<AchivementModal>> performgetachivements(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("addachivements")
//    Call<AchivementModal> performAddachivements(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("editachivements")
//    Call<AchivementModal> performEditachivements(@Body JsonObject rawjsonObject);
//
//    @GET("getachivementssingle/{userid}/{rowid}")
//    Call<AchivementModal> performgetachivementsSingle(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    @GET("deleteachivementssingle/{userid}/{rowid}")
//    Call<AchivementModal> performgetachivementsDelete(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//
//
//    //Testimonials Process
//    @GET("gettestimonials/{userid}/{pageid}")
//    Call<ArrayList<TestemonialModal>> performgettestimonials(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("addtestimonials")
//    Call<TestemonialModal> performAddtestimonials(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("edittestimonials")
//    Call<TestemonialModal> performEdittestimonials(@Body JsonObject rawjsonObject);
//
//    @GET("gettestimonialssingle/{userid}/{rowid}")
//    Call<TestemonialModal> performgettestimonialsSingle(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    @GET("deletetestimonialssingle/{userid}/{rowid}")
//    Call<TestemonialModal> performgettestimonialsDelete(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//
//    //experience Process
//    @GET("getexperience/{userid}/{pageid}")
//    Call<ArrayList<ExperenceModal>> performgetexperience(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("addexperience")
//    Call<ExperenceModal> performAddexperience(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("editexperience")
//    Call<ExperenceModal> performEditexperience(@Body JsonObject rawjsonObject);
//
//    @GET("getexperienceingle/{userid}/{rowid}")
//    Call<ExperenceModal> performgetexperienceSingle(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    @GET("deleteexperienceingle/{userid}/{rowid}")
//    Call<ExperenceModal> performgetexperienceDelete(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//
//    //education Process
//    @GET("geteducation/{userid}/{pageid}")
//    Call<ArrayList<EducationModal>> performgeteducation(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("addeducation")
//    Call<EducationModal> performAddeducation(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("editeducation")
//    Call<EducationModal> performEditeducation(@Body JsonObject rawjsonObject);
//
//    @GET("geteducationingle/{userid}/{rowid}")
//    Call<EducationModal> performgeteducationSingle(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    @GET("deleteeducationingle/{userid}/{rowid}")
//    Call<EducationModal> performgeteducationDelete(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//
//
//    //products Process
//    @GET("getproducts/{userid}/{pageid}")
//    Call<ArrayList<ProductModal>> performgetproducts(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("addproducts")
//    Call<ProductModal> performAddproducts(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("editproducts")
//    Call<ProductModal> performEditproducts(@Body JsonObject rawjsonObject);
//
//    @GET("getproductsingle/{userid}/{rowid}")
//    Call<ProductModal> performgetproductsSingle(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    @GET("deleteproductsingle/{userid}/{rowid}")
//    Call<ProductModal> performgetproductsDelete(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    //social Process
//    @GET("getsociallinks/{userid}/{pageid}")
//    Call<ArrayList<SocialLinksModal>> performgetsocial(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("addsociallinks")
//    Call<SocialLinksModal> performAddsocial(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("editsociallinksl")
//    Call<SocialLinksModal> performEditsocial(@Body JsonObject rawjsonObject);
//
//    @GET("getsociallinksingle/{userid}/{rowid}")
//    Call<SocialLinksModal> performgetsocialSingle(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    @GET("deletesociallinksingle/{userid}/{rowid}")
//    Call<SocialLinksModal> performgetsocialDelete(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//
//    //payment Process
//    @GET("getpaymentlinks/{userid}/{pageid}")
//    Call<ArrayList<PaymentLinksModal>> performgetpayment(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("addpaymentlinks")
//    Call<PaymentLinksModal> performAddpayment(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("editpaymentlinks")
//    Call<PaymentLinksModal> performEditpayment(@Body JsonObject rawjsonObject);
//
//    @GET("getpaymentlinksingle/{userid}/{rowid}")
//    Call<PaymentLinksModal> performgetpaymentSingle(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    @GET("deletepaymentlinksingle/{userid}/{rowid}")
//    Call<PaymentLinksModal> performgetpaymentDelete(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    //gallery
//    @GET("getgallery/{userid}/{pageid}")
//    Call<ArrayList<GalleryModal>> performgetgallery(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("addgallery")
//    Call<GalleryModal> performAddgallery(@Body JsonObject rawjsonObject);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("editgallery")
//    Call<GalleryModal> performEditgallery(@Body JsonObject rawjsonObject);
//
//    @GET("getgalleryingle/{userid}/{rowid}")
//    Call<GalleryModal> performgetgallerySingle(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    @GET("deletegallerysingle/{userid}/{rowid}")
//    Call<GalleryModal> performgetgalleryDelete(@Path("userid") String Userid, @Path("rowid") int PageId);
//
//    //leads
//    @Headers({"Content-Type: application/json"})
//    @POST("userdata")
//    Call<userModal> performgetuserData(@Body JsonObject rawjsonObject);
//
//    @GET("leads/{userid}/{pageid}")
//    Call<ArrayList<LeadsModal>> performgetLeads(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @GET("transaction/{userid}/{pageid}")
//    Call<ArrayList<TransectionModal>> performgetTransaction(@Path("userid") String Userid, @Path("pageid") int PageId);
//
//    @GET("vcardusertheme/{userid}")
//    Call<themeModal> performThemeDetails(@Path("userid") String Userid);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("themeupdate")
//    Call<themeModal> performThemeUpdate(@Body JsonObject rawjsonObject);
//
//    @GET("news")
//    Call<newsModal> getNews();
//
//    @Headers({"Content-Type: application/json"})
//    @POST("update/bankdetails")
//    Call<UserDetails> performBankUpdate(@Body JsonObject rawjsonObject);
//
//    @GET("getifscdetails/{ifsc}")
//    Call<IfscCode> CheckIfscCode(@Path("ifsc") String Ifsc);
//
//    @GET("getuserdetails/{userid}")
//    Call<UserDetails> performgetUser(@Path("userid") String Userid);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("locationupdate")
//    Call<aboutModal> performLocationUpdate(@Body JsonObject rawjsonObject);
//
//    @GET("location/{userid}")
//    Call<aboutModal> performLocation(@Path("userid") String Userid);
//
//    @GET("requestpayment/{userid}")
//    Call<aboutModal> performPaymentRequest(@Path("userid") String Userid);
//
//    @GET("payreqlist/{userid}/{pageid}")
//    Call<ArrayList<PayoutListModal>> performPaymentRequestList(@Path("userid") String Userid, @Path("pageid") int Pageid);

}
