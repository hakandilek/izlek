package me.dilek.izlek.domain;

import java.io.Serializable;

public class Episode implements Serializable {

    private static final long serialVersionUID = -7978623271630275746L;

    private int number;
    private String title;
    private String publishDate;

    public Episode(int number, String title, String publishDate) {
        this.number = number;
        this.title = title;
        this.publishDate = publishDate;
    }

    public Episode() {
        super();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Episode [#").append(number).append(" '").append(title)
                .append("' ").append(publishDate).append("]");
        return builder.toString();
    }

}
