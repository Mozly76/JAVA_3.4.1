package ru.netology.PosterManager.service;

public class PosterManager {
    private int limitMovies = 10;
    private AddMovie[] movies = new AddMovie[0];


    public PosterManager() {
    }

    public PosterManager(int limitMovies) {
        this.limitMovies = limitMovies;
    }

    public int getLimitMovies() {
        return limitMovies;
    }

    public void setLimitMovies(int limitMovies) {
        this.limitMovies = limitMovies;
    }

    // Добавление нового фильма
    public void add(AddMovie movie) {
        AddMovie[] tmp = new AddMovie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    // Вывод всех фильмов в порядке добавления
    public AddMovie[] findAll() {
        return movies;
    }

    // Вывод последних добавленных фильмов в обратном от добавления порядке
    public void getLast() {
        AddMovie[] all = findAll();
        if (all.length >= limitMovies) {
            this.limitMovies = limitMovies;
        } else {
            limitMovies = all.length;
        }
        AddMovie[] reversed = new AddMovie[limitMovies];
        int copyToIndex = 0;
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = all[all.length - 1 - i];
            copyToIndex++;
            if (copyToIndex >= limitMovies) {
                movies = reversed;
            }
        }
    }

    public AddMovie[] findLast() {
        return movies;
    }
}