package MessageAPI;

import UserAPI.User;

public class Message {
    User from,to;
    String text,sendTime;
    public Message(User from, User to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public String toJSON() {
        return "{\"Message\":{" +
                "\"from\": " + from.toJSON() + "\"," +
                "\"to\": " + to.toJSON() + "\"," +
                "\"text\": \"" + text + "\"," +
                "\"sendTime\": \"" + sendTime + "\"}}";
    }
}
