package it.ingsw.revedia.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Book 
{
	private String title; //PK
	private short numberOfPages;
	private String description;
	private String publishingHouse;
	private String user;
	private String link;
	private String artist;
	private List<String> genres;
	private float rating;
	private Date postDate;
	private int imageId = 0;
	
	public Book() 
	{
		this.genres = new ArrayList<String>();
	}
	
	public Book(String title, short numberOfPages, String description, String publishingHouse, String user, 
			String link, String artist, List<String> genres, int imageId)
	{
		super();
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.description = description;
		this.publishingHouse = publishingHouse;
		this.user = user;
		this.link = link;
		this.artist = artist;
		this.genres = genres;
		this.imageId = imageId;
	}

	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public short getNumberOfPages() { return numberOfPages; }
	public void setNumberOfPages(short numberOfPages) { this.numberOfPages = numberOfPages; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	public String getPublishingHouse() { return publishingHouse; }
	public void setPublishingHouse(String publishingHouse) { this.publishingHouse = publishingHouse; }

	public String getUser() { return user; }
	public void setUser(String user) { this.user = user; }
	
	public String getLink() { return link;}
	public void setLink(String link) { this.link = link; }

	public String getArtist() { return artist; }
	public void setArtist(String artist) { this.artist = artist; }

	public List<String> getGenres() { return genres; }
	public void setGenres(List<String> genres) { this.genres = genres; }
	
	public float getRating() { return rating; }
	public void setRating(float rating) { this.rating = rating; }

	public Date getPostDate() { return postDate; }
	public void setPostDate(Date postDate) { this.postDate = postDate; }

	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
}
