package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lxxxxxxy
 * @time 2019/3/4 17:16
 */
public class User implements Serializable {

    private int id;
    private String stu_id;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", stu_id='" + stu_id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }
}
