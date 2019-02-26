package by.it.subach.jd03_02.beans;

public class BlackList {

    private int id;
    private long user_id;

    public BlackList() {
    }

    public BlackList(int id, long user_id) {
        this.id = id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
