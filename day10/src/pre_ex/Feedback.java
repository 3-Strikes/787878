package pre_ex;

public class Feedback {
    private String username;
    private int id;
    private String type;
    private String content;
    private String submitTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", submitTime=" + submitTime +
                '}';
    }

    public Feedback(String username, int id, String type, String content, String submitTime) {
        this.username = username;
        this.id = id;
        this.type = type;
        this.content = content;
        this.submitTime = submitTime;
    }
    public Feedback(){

    }
}
