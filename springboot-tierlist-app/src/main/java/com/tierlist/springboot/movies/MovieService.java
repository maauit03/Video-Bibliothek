package com.tierlist.springboot.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovie(Long id){
        return movieRepository.findById(id).orElse(null);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public Movie addNewMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie editMovie(Long id, Movie newMovie){

        Movie currentMovie = movieRepository.findById(id).orElse(null);

        if (currentMovie != null){
            currentMovie.setName(newMovie.getName());
            currentMovie.setDescription(newMovie.getDescription());
            currentMovie.setRating(newMovie.getRating());
            currentMovie.setReleaseYear(newMovie.getReleaseYear());
        }

        return movieRepository.save(currentMovie);
    }
}
