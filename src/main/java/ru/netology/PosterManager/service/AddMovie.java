package ru.netology.PosterManager.service;

public class AddMovie {
    private int movieId;
    private String movie;
    private String genre;

    public AddMovie(int movieId, String movie, String genre) {
        this.movieId = movieId;
        this.movie = movie;
        this.genre = genre;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}