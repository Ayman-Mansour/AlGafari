package tech2go.example.com.algafari;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


public class RVArrayAdapter_Fragment_Certificate extends RecyclerView.Adapter<RVArrayAdapter_Fragment_Certificate.MyViewHolder> {
    private LayoutInflater inflater;
    private List<Information> data = Collections.emptyList();
    private final static int FADE_DURATION = 1000; // in milliseconds
    private Context context;
    public RVArrayAdapter_Fragment_Certificate(Context context, List<Information> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = inflater.inflate(R.layout.custom_certificates_list, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, int position) {
        final Information current = data.get(position);
        viewHolder.textView.setText(current.icon_lable);
        final int TransitionPosition = position+1;
        viewHolder.imageView.setImageResource(current.icon_id);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            viewHolder.imageView.setTransitionName(current.icon_transition);
//        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    Intent intent = new Intent(inflater.getContext(), CertificatesActivity.class);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity) inflater.getContext(),viewHolder.imageView,
                                    viewHolder.imageView.getTransitionName());
                    //view.setTransitionName(getString(R.string.transition_name) + 1);

                    intent.putExtra("awareness_"+TransitionPosition, "");
                    //Toast.makeText(getContext(),view.getTransitionName(),Toast.LENGTH_LONG).show();

                    inflater.getContext().startActivity(intent, options.toBundle());
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                    Intent intent = new Intent(inflater.getContext(), CertificatesActivity.class);
                    intent.putExtra("awareness_"+TransitionPosition, "");
                    inflater.getContext().startActivity(intent);
                }
            }
        });
//        setFadeAnimation(viewHolder.itemView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textViewDes;
        public ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.section_label);
//            textViewDes = (TextView) itemView.findViewById(R.id.section_description);
            imageView = (ImageView) itemView.findViewById(R.id.section_icon);
        }
    }
    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }
    /*private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }*/
}
