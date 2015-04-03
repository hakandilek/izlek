package me.dilek.izlek.domain;

public class Season {

    private int number;
    private int year;
    private String title;
    private final EpisodeCollection episodes = new EpisodeCollection();

    public Season() {
        super();
    }

    public Season(int number, int year, String title) {
        super();
        this.number = number;
        this.year = year;
        this.title = title;
    }

    public Season(int number, int year) {
        super();
        this.number = number;
        this.year = year;
    }

    public Season(int number) {
        super();
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EpisodeCollection getEpisodes() {
        return episodes;
    }

    public void addEpisode(int episode, String title, String publishDate) {
        episodes.addEpisode(episode, title, publishDate);
    }

}
