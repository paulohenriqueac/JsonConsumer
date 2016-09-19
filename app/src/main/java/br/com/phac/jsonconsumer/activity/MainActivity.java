package br.com.phac.jsonconsumer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import br.com.phac.jsonconsumer.R;
import br.com.phac.jsonconsumer.domain.Data;
import br.com.phac.jsonconsumer.fragment.ListFragment;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    protected List<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListFragment();
    }

    private void addListFragment(){
        ListFragment frag = ListFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentPanel, frag, "LIST_FRAGMENT")
                .commit();

    }
}
