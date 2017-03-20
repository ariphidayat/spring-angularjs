package org.arip;

import java.util.UUID;

/**
 * Created by Arip Hidayat on 3/18/2017.
 */
public class Message {
    private String id = UUID.randomUUID().toString();
    private String content;

    Message() {}

    public Message(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
