package jungjaehun.libraryexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaehoonjung on 2017. 5. 13..
 */

public class AdapterExample extends RecyclerView.Adapter<AdapterExample.ViewHolder> {

    private OnClickExampleItemListener onClickExampleItemListener;

    public AdapterExample(OnClickExampleItemListener onClickExampleItemListener) {
        this.onClickExampleItemListener = onClickExampleItemListener;
    }

    private List<ExampleData> datas = new ArrayList<ExampleData>();

    public void setDatas(List<ExampleData> datas){
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_example, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ExampleData exampleData = datas.get(position);
        holder.setRemoteData(exampleData);
        holder.textLibraryTitle.setText(exampleData.getExampleTitle());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textLibraryTitle;
        ExampleData remoteData;

        public ViewHolder(View itemView) {
            super(itemView);
            textLibraryTitle = (TextView) itemView.findViewById(R.id.textLibraryTitle);
            itemView.setOnClickListener(view -> {
                if(onClickExampleItemListener != null)
                    onClickExampleItemListener.onClickExampleItem(remoteData);
            });
        }

        public void setRemoteData(ExampleData exampleData){
            this.remoteData = exampleData;
        }
    }

    public interface OnClickExampleItemListener{
        void onClickExampleItem(ExampleData exampleData);
    }
}
