package com.example.dell.sixlive.Adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by DELL on 2018/7/9.
 */

public class ChoicenessAdater extends RecyclerView.Adapter<ChoicenessAdater.Holder> {
    private List<ChoicenessBean.RetBean.ListBean> list;
    private Context context;
    private setOn setOnLisenner;

    public ChoicenessAdater(List<ChoicenessBean.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setSetOnLisenner(setOn setOnLisenner) {
        this.setOnLisenner = setOnLisenner;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.choiceness_item, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.image.setImageURI(list.get(2).getChildList().get(position).getPic());
        holder.tv.setText(list.get(2).getChildList().get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loadURL = list.get(2).getChildList().get(position).getLoadURL();
                setOnLisenner.setOnitem(position, view, loadURL);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface setOn {
        void setOnitem(int i, View view, String loadURL);
    }

    class Holder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView image;
        private final TextView tv;

        public Holder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.choiceness_image);
            tv = itemView.findViewById(R.id.choiceness_tv);
        }
    }
}
