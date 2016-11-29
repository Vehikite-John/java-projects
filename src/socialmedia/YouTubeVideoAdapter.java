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
    
    YouTubeVideoAdapter(YouTubeVideo ytv) {
        youTubeVideo = ytv;
    }

    @Override
    public String getUser() {
        return youTubeVideo.getAuthor();
    }

    @Override
    public String getPostText() {
        String postText = youTubeVideo.getTitle() + ": " + youTubeVideo.getDescription();
        return postText;
    }
    
    
}
