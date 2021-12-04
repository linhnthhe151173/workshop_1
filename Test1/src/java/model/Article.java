/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Linh
 */
public class Article extends BaseModel{
    private int arid;
    private String title;
    private Date publishedDate;
    private boolean isOpenAccess;
    private Author aid;
    private Institution iid;

    public Article() {
    }

    public Article(int arid, String title, Date publishedDate, boolean isOpenAccess, Author aid, Institution iid) {
        this.arid = arid;
        this.title = title;
        this.publishedDate = publishedDate;
        this.isOpenAccess = isOpenAccess;
        this.aid = aid;
        this.iid = iid;
    }

    public int getArid() {
        return arid;
    }

    public void setArid(int arid) {
        this.arid = arid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public boolean isIsOpenAccess() {
        return isOpenAccess;
    }

    public void setIsOpenAccess(boolean isOpenAccess) {
        this.isOpenAccess = isOpenAccess;
    }

    public Author getAid() {
        return aid;
    }

    public void setAid(Author aid) {
        this.aid = aid;
    }

    public Institution getIid() {
        return iid;
    }

    public void setIid(Institution iid) {
        this.iid = iid;
    }
    

    @Override
    public String toString() {
        return "Article{" + "arid=" + arid + ", title=" + title + ", publishedDate=" + publishedDate + ", isOpenAccess=" + isOpenAccess + ", aid=" + aid + ", iid=" + iid + '}';
    }
    
    
}
