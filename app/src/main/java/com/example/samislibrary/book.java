package com.example.samislibrary;

public class book {
   private int id;
    private String name;
    private String author;
    private int pages;
    private String description;
    private String imgurl;
    private boolean isExpanded;

    public book(int id, String name, String author, int pages, String description, String imgurl) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.description = description;
        this.imgurl = imgurl;
        isExpanded=false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}
