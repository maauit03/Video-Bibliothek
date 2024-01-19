import { Component, OnInit } from '@angular/core';
import { MovieService } from '../services/movie.service';
import { Movie } from '../models/movie';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  status: String="";
  movies: Movie[] | undefined;
  addMovieForm: FormGroup = new FormGroup({
    name:  new FormControl('', Validators.required),
    description:  new FormControl('', Validators.required),
    rating:  new FormControl('', Validators.required),
    releaseYear:  new FormControl('', [Validators.required]),
  });;

  constructor(private movieService: MovieService) {}

  ngOnInit(): void {    
    this.movieService.getAllMovies().subscribe(data => {
    this.movies = data;
  });
  }

  addMovie(): void{
    console.log(this.addMovieForm?.value)
    this.movieService.postMovie(this.addMovieForm?.value)
    .subscribe(data => {
      console.log(data)
      this.movieService.getAllMovies().subscribe(updatedMovies =>
        this.movies = updatedMovies)});
        this.addMovieForm.reset();
  }

  deleteMovie(movie: Movie): void{
    this.movieService.deleteMovie(movie.id).subscribe(data => 
      this.movieService.getAllMovies().subscribe(updatedMovies =>
        this.movies = updatedMovies));
  }
}
