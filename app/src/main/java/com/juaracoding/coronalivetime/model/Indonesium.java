
package com.juaracoding.coronalivetime.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Indonesium implements Serializable, Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("positif")
    @Expose
    private String positif;
    @SerializedName("sembuh")
    @Expose
    private String sembuh;
    @SerializedName("meninggal")
    @Expose
    private String meninggal;
    public final static Creator<Indonesium> CREATOR = new Creator<Indonesium>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Indonesium createFromParcel(Parcel in) {
            return new Indonesium(in);
        }

        public Indonesium[] newArray(int size) {
            return (new Indonesium[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3738154104915017087L;

    protected Indonesium(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.positif = ((String) in.readValue((String.class.getClassLoader())));
        this.sembuh = ((String) in.readValue((String.class.getClassLoader())));
        this.meninggal = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Indonesium() {
    }

    /**
     * 
     * @param meninggal
     * @param positif
     * @param sembuh
     * @param name
     */
    public Indonesium(String name, String positif, String sembuh, String meninggal) {
        super();
        this.name = name;
        this.positif = positif;
        this.sembuh = sembuh;
        this.meninggal = meninggal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositif() {
        return positif;
    }

    public void setPositif(String positif) {
        this.positif = positif;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = sembuh;
    }

    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = meninggal;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(positif);
        dest.writeValue(sembuh);
        dest.writeValue(meninggal);
    }

    public int describeContents() {
        return  0;
    }

}
