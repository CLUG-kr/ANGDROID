package com.example.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Simpledata implements Parcelable {

    int number;
    String message;
    public Simpledata(int number, String message){
        this.number = number;
        this.message = message;
    }

    public Simpledata(Parcel src){
        number = src.readInt();
        message = src.readString();

    }
    public static final Parcelable.Creator CREATOR =new Parcelable.Creator(){
        public Simpledata createFromParcel(Parcel src) {
            return new Simpledata(src);
        }
        public Simpledata[] newArray(int size) {
            return new Simpledata[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }

}
