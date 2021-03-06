package it.ingsw.revedia.daoInterfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

import it.ingsw.revedia.model.*;

public interface SongDao 
{
	public ArrayList<Song> findByTitle(String name) throws SQLException;
	public void insertSong(Song song, String userNickname) throws SQLException;
	public void updateSong(Song song) throws SQLException;
	public void deleteSong(Song song) throws SQLException;
	public Song findByPrimaryKey(String name, int albumKey) throws SQLException;
	public List<Song> findAll() throws SQLException;
	public Song findSong(Song song) throws SQLException;
	
	public ArrayList<SongReview> getReviews(String name, int albumId, Integer offset) throws SQLException;
	public SongReview getUserReview(String name, int albumId, String nickname) throws SQLException;
	public ArrayList<SongReview> getReviewsByUserRater(String name, int albumId, String nickname, Integer offset) throws SQLException;
	public void addReview(SongReview review) throws SQLException;
	public void deleteReview(String nickname, String song, int albumId) throws SQLException;
	public void updateReview(SongReview review) throws SQLException;
	
	public ArrayList<Song> searchByKeyWords(String[] keyWords, int limit, int offset) throws SQLException;
	public ArrayList<Song> searchByUser(String user, Integer offset, Integer modality, Integer order) throws SQLException;
	public ArrayList<Song> searchByUserWithKeyWords(String user, String[] keyWords, Integer offset, Integer modality, Integer order) throws SQLException;

	public Integer getUserCountWithKeyWords(String user, String[] keyWords) throws SQLException;

	public ArrayList<Song> getRandomSongsByConditions(int limit, boolean mostRated) throws SQLException;
	public ArrayList<Song> findByGenre(String genre, Integer offset, Integer modality, Integer order) throws SQLException;

	public ArrayList<String> getGenres(int albumId) throws SQLException;
	
	
	public ArrayList<Song> getBestSongs() throws SQLException;
	public ArrayList<Song> getLatestSongs() throws SQLException;
	public ArrayList<Song> getBestSongsByGenre(String genre) throws SQLException;
	public ArrayList<Song> getLatestSongsByGenre(String genre) throws SQLException;
	public ArrayList<Song> getRandomSongs(String genre) throws SQLException;
	public Integer getSongsNumberByGenre(String genre) throws SQLException;
	
	public void upsertSongReview(String ownerNickname, String name, int albumId, String raterNickname, boolean rating) throws SQLException;
}
