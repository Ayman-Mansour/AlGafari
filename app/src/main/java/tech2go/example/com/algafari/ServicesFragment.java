package tech2go.example.com.algafari;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.ActivityOptionsCompat;
import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;
import static java.security.AccessController.getContext;
import static java.security.AccessController.getContext;


public class ServicesFragment extends Fragment {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_services, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list_ar);

        RVArrayAdapter adapter = new RVArrayAdapter(getContext(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        /*recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(),
                new OnItemClickListener()));*/
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Services");
    }

    public List<Information> getData() {
        List<Information> data = new ArrayList<>();
        String[] sections = getResources().getStringArray(R.array.services);
        int[] sections_id = {R.drawable.infrastructure_sys, R.drawable.construction, R.drawable.syssolution
                , R.drawable.fire_protection, R.drawable.electrical_sys, R.drawable.plumbing_sys,
                R.drawable.security_sys,R.drawable.network_sys};
        String[] transitions = getResources().getStringArray(R.array.transition);
        for (int i = 0; i < sections.length && i < sections_id.length; i++) {

            Information current = new Information();
            current.icon_id = sections_id[i];
            current.icon_lable = sections[i];
            current.icon_transition=transitions[i];
//            //Toast.makeText(getContext()(),current.icon_transition,Toast.LENGTH_LONG).show();

            data.add(current);

        }
        return data;

    }

  /*  private class OnItemClickListener extends RecyclerItemClickListener.SimpleOnItemClickListener {


        @Override
        public void onItemClick(View childView, int position) {
            ImageView view = (ImageView) rootView.findViewById(R.id.card_image);

            switch (position) {
                case 0:

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        childView.setPressed(true);
                        //view.setTransitionName(getString(R.string.transition_name) + 1);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_1", R.string.awareness_1);
                        //Toast.makeText(getContext(),view.getTransitionName(),Toast.LENGTH_LONG).show();
                        ActivityOptionsCompat options = ActivityOptionsCompat.
                                makeSceneTransitionAnimation(getActivity(),
                                        view,
                                        ViewCompat.getTransitionName(view));
                        startActivity(intent, options.toBundle());
                    } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        childView.setPressed(true);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_1", R.string.awareness_1);
                        startActivity(intent);
                    }

                    break;
                case 1:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        childView.setPressed(true);
                        //view.setTransitionName(getString(R.string.transition_name) + 2);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_2", R.string.awareness_2);
                        ActivityOptionsCompat options = ActivityOptionsCompat.
                                makeSceneTransitionAnimation(getActivity(),
                                        view,
                                        ViewCompat.getTransitionName(view));
                        startActivity(intent, options.toBundle());
                    } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        childView.setPressed(true);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_2", R.string.awareness_2);
                        startActivity(intent);
                    }
                    break;
                case 2:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        childView.setPressed(true);
                        //view.setTransitionName(getString(R.string.transition_name) + 3);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_3", R.string.awareness_3);
                        ActivityOptionsCompat options = ActivityOptionsCompat.
                                makeSceneTransitionAnimation(getActivity(),
                                        view,
                                        ViewCompat.getTransitionName(view));
                        startActivity(intent, options.toBundle());
                    } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        childView.setPressed(true);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_3", R.string.awareness_3);
                        startActivity(intent);
                    }
                    break;
                case 3:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        childView.setPressed(true);
                        //view.setTransitionName(getString(R.string.transition_name) + 4);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_4", R.string.awareness_4);
                        //Toast.makeText(getContext(),view.getTransitionName(),Toast.LENGTH_LONG).show();
                        ActivityOptions options = ActivityOptions
                                .makeSceneTransitionAnimation(getActivity(), view, view.getTransitionName());
                        startActivity(intent, options.toBundle());
                    } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        childView.setPressed(true);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_4", R.string.awareness_4);
                        startActivity(intent);
                    }
                    break;
                case 4:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        childView.setPressed(true);
                        //view.setTransitionName(getString(R.string.transition_name) + 5);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_5", R.string.awareness_5);
                        //Toast.makeText(getContext(),view.getTransitionName(),Toast.LENGTH_LONG).show();
                        ActivityOptions options = ActivityOptions
                                .makeSceneTransitionAnimation(getActivity(), view, view.getTransitionName());
                        startActivity(intent, options.toBundle());
                    } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        childView.setPressed(true);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_5", R.string.awareness_5);
                        startActivity(intent);
                    }
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        childView.setPressed(true);
                        //view.setTransitionName(getString(R.string.transition_name) + 5);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_6", R.string.awareness_5);
                        //Toast.makeText(getContext(),view.getTransitionName(),Toast.LENGTH_LONG).show();
                        ActivityOptions options = ActivityOptions
                                .makeSceneTransitionAnimation(getActivity(), view, view.getTransitionName());
                        startActivity(intent, options.toBundle());
                    } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        childView.setPressed(true);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_6", R.string.awareness_5);
                        startActivity(intent);
                    }
                    break;
                case 6:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        childView.setPressed(true);
                        //view.setTransitionName(getString(R.string.transition_name) + 5);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_7", R.string.awareness_5);
                        //Toast.makeText(getContext(),view.getTransitionName(),Toast.LENGTH_LONG).show();
                        ActivityOptions options = ActivityOptions
                                .makeSceneTransitionAnimation(getActivity(), view, view.getTransitionName());
                        startActivity(intent, options.toBundle());
                    } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        childView.setPressed(true);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_7", R.string.awareness_5);
                        startActivity(intent);
                    }
                    break;
                case 7:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        childView.setPressed(true);
                        //view.setTransitionName(getString(R.string.transition_name) + 5);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_8", R.string.awareness_5);
                        //Toast.makeText(getContext(),view.getTransitionName(),Toast.LENGTH_LONG).show();
                        ActivityOptions options = ActivityOptions
                                .makeSceneTransitionAnimation(getActivity(), view, view.getTransitionName());
                        startActivity(intent, options.toBundle());
                    } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        childView.setPressed(true);
                        Intent intent = new Intent(getContext(), ScrollingActivity.class);
                        intent.putExtra("awareness_8", R.string.awareness_5);
                        startActivity(intent);
                    }
                    break;


            }
            *//*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (childView.isPressed()) {
                    childView.setTranslationZ(20);
                } else {
                    childView.setTranslationZ(0.0f);
                }
            }*//*
        }

    }*/
}
