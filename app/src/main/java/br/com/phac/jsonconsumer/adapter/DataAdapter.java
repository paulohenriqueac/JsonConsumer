package br.com.phac.jsonconsumer.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.phac.jsonconsumer.R;
import br.com.phac.jsonconsumer.domain.Data;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private final Context context;
    private final List<Data> dataList;

    public DataAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list, viewGroup, false);
        DataViewHolder holder = new DataViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        Data d = dataList.get(position);

        holder.textViewId.setText(d.getId());
        holder.textViewName.setText(d.getName());
        holder.textViewPwd.setText(d.getPwd());
    }

    @Override
    public int getItemCount() {
        return this.dataList != null ? this.dataList.size() : 0;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{
        TextView textViewId;
        TextView textViewName;
        TextView textViewPwd;
        CardView cardView;

        public DataViewHolder(View itemView) {
            super(itemView);

            textViewId = (TextView) itemView.findViewById(R.id.textViewId);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewPwd = (TextView) itemView.findViewById(R.id.textViewPwd);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }
}
