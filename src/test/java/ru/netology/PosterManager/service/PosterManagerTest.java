package ru.netology.PosterManager.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    AddMovie movie = new AddMovie(1, "Бладшот", "боевик");
    AddMovie movie1 = new AddMovie(1, "Бладшот", "боевик");
    AddMovie movie2 = new AddMovie(2, "Вперёд", "мультфильм");
    AddMovie movie3 = new AddMovie(3, "Отель Белград", "комедия");

    PosterManager manager = new PosterManager();

    @Test
    public void shouldSetMovieId() {
        movie.setMovieId(1);

        int expected = 1;
        int actual = movie.getMovieId();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetMovie() {
        movie.setMovie("Бладшот");

        String expected = "Бладшот";
        String actual = movie.getMovie();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetGenre() {
        movie.setGenre("Боевик");

        String expected = "Боевик";
        String actual = movie.getGenre();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetLimitMovies() {
        manager.setLimitMovies(5);

        int expected = 5;
        int actual = manager.getLimitMovies();

        assertEquals(expected, actual);
    }

    @Test
    public void addMovies() {
        PosterManager repo = new PosterManager();
        repo.add(movie1);
        repo.add(movie2);
        repo.add(movie3);

        AddMovie[] expected = {movie1, movie2, movie3};
        AddMovie[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast() {
        PosterManager repo = new PosterManager(2);
        repo.add(movie1);
        repo.add(movie2);
        repo.add(movie3);
        repo.getLast();

        AddMovie[] expected = {movie3, movie2};
        AddMovie[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAboveAllMovies() {
        PosterManager repo = new PosterManager(4);
        repo.add(movie1);
        repo.add(movie2);
        repo.add(movie3);
        repo.getLast();

        AddMovie[] expected = {movie3, movie2, movie1};
        AddMovie[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastBelowAllMovies() {
        PosterManager repo = new PosterManager(0);
        repo.add(movie1);
        repo.add(movie2);
        repo.add(movie3);
        repo.getLast();

        AddMovie[] expected = {movie1, movie2, movie3};
        AddMovie[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }
}