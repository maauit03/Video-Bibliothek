package com.tierlist.springboot.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    ResponseEntity<List<Movie>> getMovies(){
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping(path = "{movieId}")
    ResponseEntity<Movie> getMovie(@PathVariable("movieId") Long id){
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @PostMapping
    ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addNewMovie(movie));
    }

    @DeleteMapping(path = "{movieId}")
    ResponseEntity<Map<String, String>> deleteMovie(@PathVariable("movieId") Long id){
        movieService.deleteMovie(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "deleted");
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "{movieId}")
    ResponseEntity<Movie> updateMovie(@PathVariable("movieId") Long id, @RequestBody Movie newMovie) {
        return ResponseEntity.ok(movieService.editMovie(id, newMovie));
    }
}
