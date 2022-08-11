package com.coffee.miniproject.common;

import lombok.Builder;
import lombok.Data;

@Data
public class Message {
    private boolean result;
    private String returnMessage;
    private Object data;

    @Builder
    public Message(boolean result, String returnMessage, Object data) {
        this.result = result;
        this.returnMessage = returnMessage;
        this.data = data;
    }

    @Builder
    public Message(boolean result, String returnMessage) {
        this.result = result;
        this.returnMessage = returnMessage;
    }
}
