package tech2go.example.com.algafari;

import android.widget.ImageView;

/**
 * Created by AYMAN MNSOR on 1/27/2017.
 */

public class Post {
    public String id,postContent,writer;
    int image_res;
    ImageView imageView ;
    public Post(int res) {
       this.image_res = res;
    }

}
