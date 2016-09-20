package br.com.phac.jsonconsumer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import br.com.phac.jsonconsumer.R;
import br.com.phac.jsonconsumer.adapter.DataAdapter;
import br.com.phac.jsonconsumer.domain.Data;
import br.com.phac.jsonconsumer.service.DataService;

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_list, container, false);;
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setHasFixedSize(true);

            return recyclerView;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);

        List<Data> datalist = null;

        try {
            datalist = DataService.getCarros(getContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        recyclerView.setAdapter(new DataAdapter(getContext(), datalist));

    }
}
