package com.nagarro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image_table")
public class Image implements Serializable {
	private static final long serialVersionUID = 8978861178494995714L;
	@Id
	@Column(name = "image_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

	@Column(name = "size")
	int imageSize;

	@Column(name = "image_name")
	public String imageName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "image")
	byte[] image;

	public Image(User user, String imageName, int imageSize, byte[] image) {
		this.user = user;
		this.imageName = imageName;
		this.imageSize = imageSize;
		this.image = image;
	}

	public Image() {

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getImageSize() {
		return imageSize;
	}

	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {

		return "{" + imageName + "  " + imageSize + "  " + id + "}";
	}
}
