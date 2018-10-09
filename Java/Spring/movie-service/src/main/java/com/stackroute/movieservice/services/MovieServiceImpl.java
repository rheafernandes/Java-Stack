package com.stackroute.movieservice.services;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Primary
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public Movie createMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getId()))
            throw new MovieAlreadyExistsException("Movie Already Exists");
        Movie savedMovie= movieRepository.save(movie);
        if(savedMovie==null)
            throw new MovieAlreadyExistsException("Movie Already Exists");
        return savedMovie;
    }

    @Override
    public List<Movie> retrieveAllMovies() throws MovieNotFoundException {
        return (List) movieRepository.findAll();
    }

    @Override
    public Movie retrieveMovieByID(String movieID) throws MovieNotFoundException {
        if(movieRepository.existsById(movieID))
        return movieRepository.findById(movieID).get();
        else
            throw new MovieNotFoundException("No Movie with this title");
    }

    @Override
    public Movie retrieveMovieByName(String movieTitle) throws MovieNotFoundException {
        if(movieRepository.existsByTitle(movieTitle))
            return movieRepository.findByTitle(movieTitle).get();
        else
            throw new MovieNotFoundException("No Movie with this title");
    }

    @Override
    public List<Movie> searchMoviesByName(String input) throws MovieNotFoundException {
        List<Movie> userList=(List)movieRepository.findAll();
        List<Movie> matchedList=new ArrayList<>();
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getTitle().toLowerCase().matches("(.*)"+input.toLowerCase()+"(.*)"))
            matchedList.add(userList.get(i));
        }
        return matchedList;
    }

    @Override
    public Movie updateMovie(Movie movie) throws MovieNotFoundException {

        Movie savedMovie=null;
        if(movieRepository.existsById(movie.getId())){
            savedMovie=movieRepository.save(movie);
            System.out.println(savedMovie);
            return savedMovie;
        }
        else
            throw new MovieNotFoundException("Movie doesn't exist can't update");

    }

    @Override
    public void deleteMovie(Movie movie) throws MovieNotFoundException {
        if(movieRepository.existsById(movie.getId()))
           movieRepository.delete(movie);
        else
            throw new MovieNotFoundException("No movie with this title");

    }



}
