package org.arip;

import java.util.Date;

/**
 * Created by Arip Hidayat on 3/19/2017.
 */
public class Change {
    private Date timestamp = new Date();
    private String user;
    private String message;

    public Change(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
