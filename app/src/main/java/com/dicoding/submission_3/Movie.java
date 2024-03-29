package com.dicoding.submission_3;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Movie implements Parcelable {

    private String mv_name, mv_rate, mv_description, mv_date, mv_ori_lang, mv_photo;


    public String getMv_name() {
        return mv_name;
    }

    public void setMv_name(String mv_name) {
        this.mv_name = mv_name;
    }

    public String getMv_rate() {
        return mv_rate;
    }

    public void setMv_rate(String mv_rate) {
        this.mv_rate = mv_rate;
    }

    public String getMv_description() {
        return mv_description;
    }

    public void setMv_description(String mv_description) {
        this.mv_description = mv_description;
    }

    public String getMv_date() {
        return mv_date;
    }

    public void setMv_date(String mv_date) {
        this.mv_date = mv_date;
    }

    public String getMv_ori_lang() {
        return mv_ori_lang;
    }

    public void setMv_ori_lang(String mv_ori_lang) {
        this.mv_ori_lang = mv_ori_lang;
    }

    public String getMv_photo() {
        return mv_photo;
    }

    public void setMv_photo(String mv_photo) {
        this.mv_photo = mv_photo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mv_name);
        dest.writeString(this.mv_rate);
        dest.writeString(this.mv_description);
        dest.writeString(this.mv_date);
        dest.writeString(this.mv_ori_lang);
        dest.writeString(this.mv_photo);
    }

    Movie(JSONObject object) {
        try{
            String name = object.getString("title");
            String ori_lang = object.getString("original_language");
            String date = object.getString("release_date");
            String rate = object.getString("vote_average");
            String description = object.getString("overview");
            String photo = object.getString("poster_path");


            this.mv_name = name;
            this.mv_ori_lang = ori_lang;
            this.mv_date = date;
            this.mv_rate = rate;
            this.mv_description = description;
            this.mv_photo = photo;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Movie(Parcel in) {
        this.mv_name = in.readString();
        this.mv_rate = in.readString();
        this.mv_description = in.readString();
        this.mv_date = in.readString();
        this.mv_ori_lang = in.readString();
        this.mv_photo = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };


}
