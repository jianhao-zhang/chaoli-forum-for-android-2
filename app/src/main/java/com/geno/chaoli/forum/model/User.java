package com.geno.chaoli.forum.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by daquexian on 16-4-8.
 * 保存用户账户信息的类
 */
public class User implements Parcelable {
    private static final String TAG = "User";
    private boolean isEmpty = true;
    private int userId;
    private String username;

    @SerializedName("avatarFormat")
    private String avatarSuffix;
    private String status;
    private Preferences preferences;
    private static User user;

    public User(){}

    private User(Parcel in){
        userId = in.readInt();
        username = in.readString();
        avatarSuffix = in.readString();
        status = in.readString();
        preferences.privateAdd = (in.readByte() == 1);
        preferences.starOnReply = (in.readByte() == 1);
        preferences.starPrivate = (in.readByte() == 1);
        preferences.hideOnline = (in.readByte() == 1);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(username);
        dest.writeString(avatarSuffix);
        dest.writeString(status);
        dest.writeString(preferences.signature);
        dest.writeByte((byte)(preferences.privateAdd ? 1 : 0));
        dest.writeByte((byte)(preferences.starOnReply ? 1 : 0));
        dest.writeByte((byte)(preferences.starPrivate ? 1 : 0));
        dest.writeByte((byte)(preferences.hideOnline ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };


    public static class Preferences{
        private String signature;
        @SerializedName("email.privateAdd")
        private Boolean privateAdd;
        private Boolean starOnReply;
        private Boolean starPrivate;
        private Boolean hideOnline;

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public Boolean getPrivateAdd() {
            return privateAdd;
        }

        public void setPrivateAdd(Boolean privateAdd) {
            this.privateAdd = privateAdd;
        }

        public Boolean getStarOnReply() {
            return starOnReply;
        }

        public void setStarOnReply(Boolean starOnReply) {
            this.starOnReply = starOnReply;
        }

        public Boolean getStarPrivate() {
            return starPrivate;
        }

        public void setStarPrivate(Boolean starPrivate) {
            this.starPrivate = starPrivate;
        }

        public Boolean getHideOnline() {
            return hideOnline;
        }

        public void setHideOnline(Boolean hideOnline) {
            this.hideOnline = hideOnline;
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarSuffix() {
        return avatarSuffix;
    }

    public void setAvatarSuffix(String avatarSuffix) {
        this.avatarSuffix = avatarSuffix;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
}
