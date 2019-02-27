package by.it.subach.project.java.beans;

public class BlackList {

    private long id;
    private long user_id;

    public BlackList() {
    }

    public BlackList(long id, long user_id) {
        this.id = id;
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "id=" + id +
                ", user_id=" + user_id +
                '}';
    }
}
