package com.kushal.ChatRoom.chat;

//import lombok.*;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;

    public ChatMessage() {}

    public ChatMessage(String content, String sender, MessageType type) {
        this.content = content;
        this.sender = sender;
        this.type = type;
    }

    public String getContent() {
        return content;
    }
    public String getSender() {
        return sender;
    }
    public MessageType getType() {
        return type;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public void setType(MessageType type) {
        this.type = type;
    }

    public static ChatMessageBuilder builder() {
        return new ChatMessageBuilder();
    }

    public static class ChatMessageBuilder {
        private String content;
        private String sender;
        private MessageType type;

        public ChatMessageBuilder content(String content) {
            this.content = content;
            return this;
        }

        public ChatMessageBuilder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public ChatMessageBuilder type(MessageType type) {
            this.type = type;
            return this;
        }

        public ChatMessage build() {
            return new ChatMessage(content, sender, type);
        }
    }
}