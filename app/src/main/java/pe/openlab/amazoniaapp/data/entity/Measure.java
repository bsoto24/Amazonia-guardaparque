package pe.openlab.amazoniaapp.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bryam Soto on 30/11/2017.
 */

public class Measure {

    @SerializedName("approved")
    @Expose
    private boolean approved;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("exonerated")
    @Expose
    private int exonerated;
    @SerializedName("foreign")
    @Expose
    private int foreign;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("national")
    @Expose
    private int national;
    @SerializedName("protected_natural_area")
    @Expose
    private int protectedNaturalArea;

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getExonerated() {
        return exonerated;
    }

    public void setExonerated(int exonerated) {
        this.exonerated = exonerated;
    }

    public int getForeign() {
        return foreign;
    }

    public void setForeign(int foreign) {
        this.foreign = foreign;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNational() {
        return national;
    }

    public void setNational(int national) {
        this.national = national;
    }

    public int getProtectedNaturalArea() {
        return protectedNaturalArea;
    }

    public void setProtectedNaturalArea(int protectedNaturalArea) {
        this.protectedNaturalArea = protectedNaturalArea;
    }
}
