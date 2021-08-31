package tech2go.example.com.algafari;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class MirrorFragment5 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mirror5, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Home");
        final ImageView imageView = (ImageView) view.findViewById(R.id.card_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {


                    //view.setTransitionName(getString(R.string.transition_name) + 4);
                    Intent intent = new Intent(getContext(), ScrollingActivity.class);
                    intent.putExtra("awareness_3", "");
                    //Toast.makeText(getContext(),view.getTransitionName(),Toast.LENGTH_LONG).show();
                    ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation(getActivity(), imageView, imageView.getTransitionName());
                    startActivity(intent, options.toBundle());
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

                    Intent intent = new Intent(getContext(), ScrollingActivity.class);
                    intent.putExtra("awareness_3", "");
                    startActivity(intent);
                }
            }
        });
    }
}
