package model;

/**
 *
 * @author Linh
 */
public class Author extends BaseModel{
    private int aid;
    private String aname;

    public Author() {
    }

    public Author(int aid, String aname) {
        this.aid = aid;
        this.aname = aname;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Author{" + "aid=" + aid + ", aname=" + aname + '}';
    }
    
    
}
