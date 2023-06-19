package net.skhu;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Memo implements Serializable {
    String title;
    String content;

    public Memo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String body) {
        this.content = body;
    }
}

