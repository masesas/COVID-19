
package com.juaracoding.coronalivetime.coronalivetime;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Provinsi implements Serializable, Parcelable
{

    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    public final static Creator<Provinsi> CREATOR = new Creator<Provinsi>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Provinsi createFromParcel(Parcel in) {
            return new Provinsi(in);
        }

        public Provinsi[] newArray(int size) {
            return (new Provinsi[size]);
        }

    }
    ;
    private final static long serialVersionUID = -7696266265450390566L;

    protected Provinsi(Parcel in) {
        this.attributes = ((Attributes) in.readValue((Attributes.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Provinsi() {
    }

    /**
     * 
     * @param attributes
     */
    public Provinsi(Attributes attributes) {
        super();
        this.attributes = attributes;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(attributes);
    }

    public int describeContents() {
        return  0;
    }

}
