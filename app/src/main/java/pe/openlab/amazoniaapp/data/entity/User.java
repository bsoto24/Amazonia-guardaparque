package pe.openlab.amazoniaapp.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bryam Soto on 30/11/2017.
 */

public class User {

    @SerializedName("account_id")
    @Expose
    private int accountId;

    @SerializedName("account_level")
    @Expose
    private String accountLevel;

    @SerializedName("protected_natural_area")
    @Expose
    private ProtectedNaturalArea protectedNaturalArea;

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    public ProtectedNaturalArea getProtectedNaturalArea() {
        return protectedNaturalArea;
    }

    public void setProtectedNaturalArea(ProtectedNaturalArea protectedNaturalArea) {
        this.protectedNaturalArea = protectedNaturalArea;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
