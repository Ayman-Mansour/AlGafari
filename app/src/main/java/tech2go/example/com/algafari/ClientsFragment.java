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


public class ClientsFragment extends Fragment {

   public View rootView;
    android.support.design.widget.FloatingActionButton btn;
    private RVArrayAdapter_Fragment_clients adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_clients, container, false);
//        ListView listview = (ListView) rootView.findViewById(R.id.list_a);
        android.support.v7.widget.RecyclerView recyclerView = (android.support.v7.widget.RecyclerView) rootView.findViewById(R.id.certificates_list);
        adapter = new RVArrayAdapter_Fragment_clients(getContext(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Clients");
    }

    public List<Information> getData() {
        List<Information> data = new ArrayList<>();
        String[] sections = getResources().getStringArray(R.array.clients);
        String[] sections_description = getResources().getStringArray(R.array.warning);
        int[] sections_id = {R.drawable.cl_1, R.drawable.cl_2, R.drawable.cl_3, R.drawable.cl_4,
                R.drawable.cl_5,R.drawable.cl_6, R.drawable.cl_7, R.drawable.cl_8, R.drawable.cl_9,
                R.drawable.cl_10,R.drawable.cl_11, R.drawable.cl_12, R.drawable.cl_13, R.drawable.cl_14,
                R.drawable.cl_15,R.drawable.cl_x, R.drawable.cl_x, R.drawable.cl_x, R.drawable.cl_x,
                R.drawable.cl_x,R.drawable.cl_x, R.drawable.cl_x, R.drawable.cl_x, R.drawable.cl_x,
                R.drawable.cl_x,R.drawable.cl_x ,R.drawable.cl_x,R.drawable.cl_x };
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
