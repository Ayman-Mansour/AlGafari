package tech2go.example.com.algafari;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by AYMAN MNSOR on 1/27/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostsHolder> {

    List<Post> postsData;
    Context context;

    public PostAdapter(List<Post> postsData, Context context) {
        this.postsData = postsData;
        this.context = context;
    }

    @Override
    public PostsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_custom_row, parent, false);
        PostsHolder postsHolder = new PostsHolder(row);
        return postsHolder;
    }

    @Override
    public void onBindViewHolder(final PostsHolder postsHolder, final int position) {
        Post singlePost = postsData.get(position);
//        if (singlePost.image_res == 0) {
//            postsHolder.imageView.setImageResource(R.drawable.ic_algafari);
//        }
        postsHolder.imageView.setImageResource(singlePost.image_res);
        postsHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,position, Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return postsData.size();
    }

    class PostsHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public PostsHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
