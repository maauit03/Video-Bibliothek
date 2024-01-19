import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movie } from '../models/movie';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  movie!: Movie; // Adjust the type based on your product data structure

  constructor(private movieService: MovieService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const movieId = +params['id'];
      this.loadMoviedetails(movieId);
    });
  }

  loadMoviedetails(movieId: number): void {
    this.movieService.getMovie(movieId).subscribe(data => {
      this.movie = data;
    }),
    (error: any) => {
      console.error('Error fetching product details:', error);
    }
  }

}
