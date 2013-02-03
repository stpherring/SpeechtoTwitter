import twitter4j.TwitterException;
import twitter4j.media.ImageUpload;
import twitter4j.media.ImageUploadFactory;
import twitter4j.media.MediaProvider;

import java.io.*;
import java.nio.file.DirectoryStream;

/*
 * This will upload every image in the "pics" folder
 */

public class ImageUploader {
	public static void main(String[] arg){
		//grab more files than one
		File file = new File("pics/");
		File[] children = file.listFiles();

		ImageUpload uploader = new ImageUploadFactory().getInstance(MediaProvider.TWITTER);
		try {
			for (File child : children){
				uploader.upload(child);
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}