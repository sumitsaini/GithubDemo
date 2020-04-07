package com.github.carrerfour.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ProfileDetail implements Parcelable {

    @SerializedName("name")
    String name;
    @SerializedName("location")
    String location;
    @SerializedName("company")
    String company;
    @SerializedName("blog")
    String blog;
    @SerializedName("avatar_url")
    String avatarUrl;


    public ProfileDetail(Parcel sources)
    {
        name=sources.readString();
        company=sources.readString();
        blog=sources.readString();
        avatarUrl=sources.readString();
        location=sources.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(company);
        parcel.writeString(blog);
        parcel.writeString(avatarUrl);
        parcel.writeString(location);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public static final Creator<ProfileDetail> CREATOR = new Creator<ProfileDetail>() {
        public ProfileDetail createFromParcel(Parcel sources) {
            return new ProfileDetail(sources);
        }

        public ProfileDetail[] newArray(int size) {
            return new ProfileDetail[size];
        }
    };

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
