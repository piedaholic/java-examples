package com.piedaholic.models;

import java.io.Serializable;
import java.util.Objects;

public class UserCredentials implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
    private String userFirstName;
    private String userMiddleName;
    private String userLastName;
    private transient String userPassword;
    private transient String userPrimaryEmail;
    private transient String userSecondaryEmail;
    private String userLang;

    public UserCredentials() {
    }


    public UserCredentials(String userId, String userFirstName, String userMiddleName, String userLastName, String userLang) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userMiddleName = userMiddleName;
        this.userLastName = userLastName;
        this.userLang = userLang;
    }

    public UserCredentials(String userId, String userFirstName, String userMiddleName, String userLastName, String userPrimaryEmail, String userLang) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userMiddleName = userMiddleName;
        this.userLastName = userLastName;
        this.userPrimaryEmail = userPrimaryEmail;
        this.userLang = userLang;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return this.userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserMiddleName() {
        return this.userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return this.userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public UserCredentials(String userPassword, String userPrimaryEmail, String userSecondaryEmail) {
        this.userPassword = userPassword;
        this.userPrimaryEmail = userPrimaryEmail;
        this.userSecondaryEmail = userSecondaryEmail;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPrimaryEmail() {
        return this.userPrimaryEmail;
    }

    public void setUserPrimaryEmail(String userPrimaryEmail) {
        this.userPrimaryEmail = userPrimaryEmail;
    }

    public String getUserSecondaryEmail() {
        return this.userSecondaryEmail;
    }

    public void setUserSecondaryEmail(String userSecondaryEmail) {
        this.userSecondaryEmail = userSecondaryEmail;
    }

    public UserCredentials userPassword(String userPassword) {
        setUserPassword(userPassword);
        return this;
    }

    public UserCredentials userPrimaryEmail(String userPrimaryEmail) {
        setUserPrimaryEmail(userPrimaryEmail);
        return this;
    }

    public UserCredentials userSecondaryEmail(String userSecondaryEmail) {
        setUserSecondaryEmail(userSecondaryEmail);
        return this;
    }

    public String getUserLang() {
        return this.userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", userFirstName='" + getUserFirstName() + "'" +
            ", userMiddleName='" + getUserMiddleName() + "'" +
            ", userLastName='" + getUserLastName() + "'" +
            ", userPrimaryEmail='" + getUserPrimaryEmail() + "'" +
            ", userLang='" + getUserLang() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserCredentials)) {
            return false;
        }
        UserCredentials userCredentials = (UserCredentials) o;
        return Objects.equals(userId, userCredentials.userId) && Objects.equals(userFirstName, userCredentials.userFirstName) && Objects.equals(userMiddleName, userCredentials.userMiddleName) && Objects.equals(userLastName, userCredentials.userLastName) && Objects.equals(userLang, userCredentials.userLang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userFirstName, userMiddleName, userLastName, userLang);
    }


}
