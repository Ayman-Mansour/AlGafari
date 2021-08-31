package tech2go.example.com.algafari;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class CertificatesFragment extends Fragment {

   public View rootView;
    android.support.design.widget.FloatingActionButton btn;
    private RVArrayAdapter_Fragment_Certificate adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_certificates, container, false);
//        ListView listview = (ListView) rootView.findViewById(R.id.list_a);
        android.support.v7.widget.RecyclerView recyclerView = (android.support.v7.widget.RecyclerView) rootView.findViewById(R.id.certificates_list);
        adapter = new RVArrayAdapter_Fragment_Certificate(getContext(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Certificates");
    }

    public List<Information> getData() {
        List<Information> data = new ArrayList<>();
        String[] sections = getResources().getStringArray(R.array.certificates);
        String[] sections_description = getResources().getStringArray(R.array.certificates);
        int[] sections_id = {R.drawable.crtf_1, R.drawable.crtf_2, R.drawable.crtf_3, R.drawable.crtf_4,
                R.drawable.crtf_5,R.drawable.crtf_6, R.drawable.crtf_7,R.drawable.crtf_8, R.drawable.crtf_9, R.drawable.crtf_10,
                R.drawable.crtf_11, R.drawable.crtf_12 };
        for (int i = 0; i < sections.length && i < sections_id.length; i++) {

            Information current = new Information();
            current.icon_id = sections_id[i];
            current.icon_lable = sections[i];
//            current.icon_description = sections_description[i];
            data.add(current);

        }
        return data;

    }




}
