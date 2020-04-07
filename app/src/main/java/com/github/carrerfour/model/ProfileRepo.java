package com.github.carrerfour.model;

import com.google.gson.annotations.SerializedName;

public class ProfileRepo {

    @SerializedName("name")
    String name;
    @SerializedName("private")
    boolean isPrivate;
    @SerializedName("updated_at")
    String updatedAt;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
