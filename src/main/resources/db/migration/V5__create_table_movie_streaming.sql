CREATE TABLE movie_streaming(
      movie_id integer,
      streaming_id integer,
      constraint fk_movie_streaming_movie foreign key(movie_id) references movie(id),
      constraint fk_movie_streaming_streaming foreign key(streaming_id) references streaming(id)
);