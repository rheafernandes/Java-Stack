package com.stackroute.movieservice.controller;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    @Autowired
//    @Qualifier("MovieServiceImpl2")
    MovieService movieService;

    @PostMapping("/movieSave")
    public ResponseEntity<?> createMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        Movie storedMovie = null;
        try {
            storedMovie = movieService.createMovie(movie);
            responseEntity = new ResponseEntity<Movie>(storedMovie, HttpStatus.OK);
        } catch (MovieAlreadyExistsException e) {
            responseEntity = new ResponseEntity<Movie>(storedMovie, HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("/allMovies")
    public ResponseEntity<?> retrieveAllMovies() {
        ResponseEntity responseEntity;
        List movieList = null;
        try {
            movieList = movieService.retrieveAllMovies();
            responseEntity = new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);

        } catch (MovieNotFoundException e) {
            responseEntity = new ResponseEntity<List<Movie>>(movieList, HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @DeleteMapping("/deleteMovies")
    public ResponseEntity<?> deleteMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try {
            movieService.deleteMovie(movie);
            responseEntity = new ResponseEntity<Movie>(new Movie(), HttpStatus.OK);
        } catch (MovieNotFoundException e) {
            responseEntity = new ResponseEntity<Movie>(movie, HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;

    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable String id) {
        ResponseEntity responseEntity;
        Movie savedMovie = null;
        try {
            savedMovie = movieService.retrieveMovieByID(id);
            responseEntity = new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<Movie>(savedMovie, HttpStatus.CONFLICT);

        }
        return responseEntity;
    }

    @PutMapping("/movieUpdate")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie, Movie oldMovie) {
        ResponseEntity responseEntity;
        List<Movie> storedMovie = new ArrayList<>();
        try {
            oldMovie=movieService.retrieveMovieByID(movie.getId());
        } catch (MovieNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(oldMovie);
            storedMovie.add(movieService.updateMovie(movie));
            storedMovie.add(oldMovie);
            System.out.println(storedMovie);
            responseEntity = new ResponseEntity<List<Movie>>(storedMovie, HttpStatus.OK);
            return responseEntity;
        } catch (MovieNotFoundException e) {
            responseEntity = new ResponseEntity<List<Movie>>(storedMovie, HttpStatus.CONFLICT);
            e.printStackTrace();
            return responseEntity;
        }
    }
    @GetMapping("/searchMovies/{input}")
    public ResponseEntity<?> searchMoviesByName(@PathVariable String input){
        ResponseEntity responseEntity;
        List<Movie>foundMovies=new ArrayList<>();
        try {
            foundMovies=movieService.searchMoviesByName(input);
            responseEntity = new ResponseEntity<List<Movie>>(foundMovies, HttpStatus.OK);
        } catch (MovieNotFoundException e) {
            responseEntity = new ResponseEntity<List<Movie>>(foundMovies, HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }
    @GetMapping("/searchMovie/{input}")
    public ResponseEntity<?> searchMovieByTitle(@PathVariable String input){
        ResponseEntity responseEntity;
        Movie foundMovies=null;
        try {
            foundMovies=movieService.retrieveMovieByName(input);
            responseEntity = new ResponseEntity<Movie>(foundMovies, HttpStatus.OK);
        } catch (MovieNotFoundException e) {
            responseEntity = new ResponseEntity<Movie>(foundMovies, HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

}
