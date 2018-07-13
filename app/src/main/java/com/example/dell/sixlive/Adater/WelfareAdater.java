package com.example.dell.sixlive.Adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.sixlive.Bean.WelfareBean;
import com.example.dell.sixlive.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WelfareAdater extends RecyclerView.Adapter<WelfareAdater.Holder> {
    private List<WelfareBean.ResultsBean> list;
    private Context context;
    private List<Integer> heightList;
    private String a;

    public WelfareAdater(List<WelfareBean.ResultsBean> list, Context context) {

        this.list = list;
        this.context = context;

        heightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int height = new Random().nextInt(300) + 500;//[100,300)的随机数
            heightList.add(height);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.welfare_item, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String url = list.get(position).getUrl();
//        String[] split = url.split("/");
//        a = split[1];
//        Log.e("AAAAA",a);
        holder.simple.setImageURI(url);

        //由于需要实现瀑布流的效果,所以就需要动态的改变控件的高度了
        ViewGroup.LayoutParams params = holder.simple.getLayoutParams();
        params.height = heightList.get(position);
        holder.simple.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simple;

        public Holder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.simple);
        }
    }
}
