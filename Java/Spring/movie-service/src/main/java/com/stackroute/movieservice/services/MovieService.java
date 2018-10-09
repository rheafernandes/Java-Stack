//App should allow all users to search movies in India by specifying
//        movie name.
//        2. App should allow authenticated users to perform the following
//        activities:
//        a. Save information of a movie with comments
//        b. View saved movie information
//        c. Update comments of a saved movie
//        d. Delete a movie

package com.stackroute.movieservice.services;


import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;

import java.util.List;

public interface MovieService {
    public Movie createMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> retrieveAllMovies() throws MovieNotFoundException;
    public Movie retrieveMovieByID(String movieID) throws MovieNotFoundException;
    public Movie retrieveMovieByName(String name) throws MovieNotFoundException;
    public Movie updateMovie(Movie movie) throws MovieNotFoundException;
    public void deleteMovie(Movie movie) throws MovieNotFoundException;
    public List<Movie> searchMoviesByName(String name)throws MovieNotFoundException;
}
