/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialmedia;

/**
 *
 * @author jdavet
 */
public class YouTubeVideoAdapter implements SocialMediaEntry {
    
    YouTubeVideo youTubeVideo;

    @Override
    public String getUser() {
        return youTubeVideo.getAuthor();
    }

    @Override
    public String getPostText() {
        String postText = "Title: " + youTubeVideo.getTitle() + "\n" +
                "Description: " + youTubeVideo.getDescription();
        return postText;
    }
    
    
}
