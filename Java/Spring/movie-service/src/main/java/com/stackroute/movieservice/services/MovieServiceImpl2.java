package com.stackroute.movieservice.services;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Service
//@Primary
//@Qualifier("MovieServiceImpl2")
public class MovieServiceImpl2 implements MovieService {
    @Override
    public Movie createMovie(Movie movie) throws MovieAlreadyExistsException {
        return null;
    }

    @Override
    public List<Movie> retrieveAllMovies() throws MovieNotFoundException {
        return null;
    }

    @Override
    public Movie retrieveMovieByID(String movieID) throws MovieNotFoundException {
        return null;
    }

    @Override
    public Movie retrieveMovieByName(String name) throws MovieNotFoundException {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) throws MovieNotFoundException {
        return null;
    }

    @Override
    public void deleteMovie(Movie movie) throws MovieNotFoundException {

    }

    @Override
    public List<Movie> searchMoviesByName(String name) throws MovieNotFoundException {
        return null;
    }
}
