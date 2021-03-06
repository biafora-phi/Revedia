package it.ingsw.revedia.daoInterfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ingsw.revedia.model.*;

public interface MovieDao {
	public Movie findByPrimaryKey(String title) throws SQLException;

	public ArrayList<Movie> findByGenre(String genre, Integer offset, Integer modality, Integer order) throws SQLException;
	public Movie findMovie(Movie movie) throws SQLException;

	public int insertMovie(Movie movie) throws SQLException;

	public void deleteMovie(String title) throws SQLException;

	public void updateMovie(Movie movie) throws SQLException;

	public ArrayList<MovieReview> getReviews(String title, Integer offset) throws SQLException;
	public MovieReview getUserReview(String title, String nickname) throws SQLException;
	public ArrayList<MovieReview> getReviewsByUserRater(String title, String nickname, Integer offset) throws SQLException;

	public void addReview(MovieReview review) throws SQLException;

	public void deleteReview(String nickname, String title) throws SQLException;

	public void updateReview(MovieReview review) throws SQLException;

	public ArrayList<Movie> searchByKeyWords(String[] keyWords, int limit, int offset) throws SQLException;
	public ArrayList<Movie> searchByUser(String user, Integer offset, Integer modality, Integer order) throws SQLException;
	public ArrayList<Movie> searchByUserWithKeyWords(String user, String[] keyWords, Integer offset, Integer modality, Integer order) throws SQLException;

	public Integer getUserCountWithKeyWords(String user, String[] keyWords) throws SQLException;

	public List<Movie> findAll() throws SQLException;

	public ArrayList<Movie> getBestMovies() throws SQLException;

	public ArrayList<Movie> getLatestMovies() throws SQLException;

	public ArrayList<Movie> getRandomMoviesByConditions(int limit, boolean mostRated) throws SQLException;

	public void insertMovieGenres(String movieTitle, List<String> genres) throws SQLException;

	public ArrayList<String> getGenres(String title) throws SQLException;

	public void addGenre(String g) throws SQLException;

	public List<String> getAllGenres() throws SQLException;

	public ArrayList<Movie> getBestMoviesByGenre(String genre) throws SQLException;
	public ArrayList<Movie> getLatestMoviesByGenre(String genre) throws SQLException;
	public Integer getMoviesNumberByGenre(String genre) throws SQLException;
	public ArrayList<Movie> getRandomMovies(String genre) throws SQLException;

	public void upsertMovieReview(String ownerNickname, String title, String raterNickname, boolean rating)
			throws SQLException;
}
