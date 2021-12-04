/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Linh
 */
public class Institution extends BaseModel{
    private int iid;
    private String iname;

    public Institution() {
    }

    public Institution(int iid, String iname) {
        this.iid = iid;
        this.iname = iname;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    @Override
    public String toString() {
        return "Institution{" + "iid=" + iid + ", iname=" + iname + '}';
    }
    
}
