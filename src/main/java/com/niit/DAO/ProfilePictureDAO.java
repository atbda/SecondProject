package com.niit.DAO;

import com.niit.model.ProfilePicture;

public interface ProfilePictureDAO {
	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);

}
