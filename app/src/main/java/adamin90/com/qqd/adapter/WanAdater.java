package adamin90.com.qqd.adapter;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import adamin90.com.qqd.R;
import adamin90.com.qqd.moled.fun.Data;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LiTao on 2015-11-29-20:56.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class WanAdater extends RecyclerView.Adapter<WanAdater.MyHolder> {

    private List<Data> datas;

    public WanAdater(List<Data> datas) {
        this.datas = datas;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wan,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
//        Glide.with(holder.itemView.getContext())
//                .load(datas.get(position).getImgs().get(0).getImg()).into(holder.imageView);
        Log.e("地址啊","兑换izhi"+datas.get(position).getImgs().get(0).getImg());
        Picasso.with(holder.itemView.getContext())
                .load(datas.get(position).getImgs().get(0).getImg()).into(holder.imageView);
        holder.textView.setText(datas.get(position).getTitle());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"点击"+position,Snackbar.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
 @Bind(R.id.image) ImageView imageView;
        @Bind(R.id.text) TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
