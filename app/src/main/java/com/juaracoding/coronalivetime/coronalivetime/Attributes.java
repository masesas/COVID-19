
package com.juaracoding.coronalivetime.coronalivetime;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes implements Serializable, Parcelable
{

    @SerializedName("FID")
    @Expose
    private Integer fID;
    @SerializedName("Kode_Provi")
    @Expose
    private Integer kodeProvi;
    @SerializedName("Provinsi")
    @Expose
    private String provinsi;
    @SerializedName("Kasus_Posi")
    @Expose
    private Integer kasusPosi;
    @SerializedName("Kasus_Semb")
    @Expose
    private Integer kasusSemb;
    @SerializedName("Kasus_Meni")
    @Expose
    private Integer kasusMeni;
    public final static Creator<Attributes> CREATOR = new Creator<Attributes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes createFromParcel(Parcel in) {
            return new Attributes(in);
        }

        public Attributes[] newArray(int size) {
            return (new Attributes[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1632285344791999688L;

    protected Attributes(Parcel in) {
        this.fID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.kodeProvi = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.provinsi = ((String) in.readValue((String.class.getClassLoader())));
        this.kasusPosi = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.kasusSemb = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.kasusMeni = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attributes() {
    }

    /**
     * 
     * @param fID
     * @param provinsi
     * @param kasusMeni
     * @param kodeProvi
     * @param kasusSemb
     * @param kasusPosi
     */
    public Attributes(Integer fID, Integer kodeProvi, String provinsi, Integer kasusPosi, Integer kasusSemb, Integer kasusMeni) {
        super();
        this.fID = fID;
        this.kodeProvi = kodeProvi;
        this.provinsi = provinsi;
        this.kasusPosi = kasusPosi;
        this.kasusSemb = kasusSemb;
        this.kasusMeni = kasusMeni;
    }

    public Integer getFID() {
        return fID;
    }

    public void setFID(Integer fID) {
        this.fID = fID;
    }

    public Integer getKodeProvi() {
        return kodeProvi;
    }

    public void setKodeProvi(Integer kodeProvi) {
        this.kodeProvi = kodeProvi;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public Integer getKasusPosi() {
        return kasusPosi;
    }

    public void setKasusPosi(Integer kasusPosi) {
        this.kasusPosi = kasusPosi;
    }

    public Integer getKasusSemb() {
        return kasusSemb;
    }

    public void setKasusSemb(Integer kasusSemb) {
        this.kasusSemb = kasusSemb;
    }

    public Integer getKasusMeni() {
        return kasusMeni;
    }

    public void setKasusMeni(Integer kasusMeni) {
        this.kasusMeni = kasusMeni;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(fID);
        dest.writeValue(kodeProvi);
        dest.writeValue(provinsi);
        dest.writeValue(kasusPosi);
        dest.writeValue(kasusSemb);
        dest.writeValue(kasusMeni);
    }

    public int describeContents() {
        return  0;
    }

}
