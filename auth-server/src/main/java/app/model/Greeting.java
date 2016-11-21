package app.model;

/**
 * Created by GrahamH on 11/08/2016.
 */
public class Greeting {
    private long id;
    private String content;

    public Greeting(long id, String content) {
        this.setId(id);
        this.setContent(content);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

