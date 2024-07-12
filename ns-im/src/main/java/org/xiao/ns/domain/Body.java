package org.xiao.ns.domain;

import java.time.LocalDateTime;

public class Body {
    String target;
    String message;
    LocalDateTime timestamp;

    public Body() {
    }

    public String getTarget() {
        return target;
    }

    public Body setTarget(String target) {
        this.target = target;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Body setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Body setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
