package adamin90.com.qqd.adapter;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import adamin90.com.qqd.R;
import adamin90.com.qqd.moled.hot.Header;
import adamin90.com.qqd.ui.QqdWebActivity;
import adamin90.com.qqd.view.LinePageIndicator;
import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by LiTao on 2015-12-03-14:30.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class HotAdapter extends RecyclerView.Adapter<HotAdapter.MyHolder> {

    private List<adamin90.com.qqd.moled.hot.List> listList;
    private List<Header> headerList;
    private ImageAdapter imageAdapter;
//
//    public HotAdapter(List<adamin90.com.qqd.moled.hot.List> listList) {
//        this.listList = listList;
//    }

    public HotAdapter(List<adamin90.com.qqd.moled.hot.List> listList, List<Header> headerList) {
        this.listList = listList;
        this.headerList = headerList;
        this.imageAdapter=new ImageAdapter(headerList);
    }

    public static  final int TYPE_HEADER=0;
    public static final int TYPE_CONTENT=1;

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
switch (viewType){
    case TYPE_HEADER:
        view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_header,parent,false);
        break;
    case TYPE_CONTENT:
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hot_rec,parent,false);
        break;
}

        return new MyHolder(view,viewType);
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return TYPE_HEADER;
        }else {
            return TYPE_CONTENT;
        }
    }


    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        if(position==0){
            holder.viewPager.setAdapter(imageAdapter);
            holder.linePageIndicator.setViewPager(holder.viewPager);

        }else {
            if(listList.get(position).getPic()!=null&&listList.get(position).getPic().contains("http")){
                Picasso.with(holder.itemView.getContext()).load(listList.get(position).getPic())
                        .into(holder.imageView);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(holder.itemView.getContext(), QqdWebActivity.class);
                        intent.putExtra("topic_id",listList.get(position).getTopicId());
                        intent.putExtra("board_id",listList.get(position).getBoardId());
                        intent.putExtra("title",listList.get(position).getName());
                        holder.itemView.getContext().startActivity(intent);
                    }
                });
            }

            holder.textView.setText(listList.get(position).getName()+"");
            holder.name.setText(listList.get(position).getAuthor()+"");
            holder.ckandtime.setText(listList.get(position).getClickNum()+"/"+listList.get(position).getReplyNum()
            +"  "+listList.get(position).getTime());
        }


    }

    @Override
    public int getItemCount() {
        return listList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView,name,ckandtime;
        ViewPager viewPager;
        LinePageIndicator linePageIndicator;
        public MyHolder(View itemView,int type) {
            super(itemView);
//            ButterKnife.bind(this,itemView);
            switch (type){
                case TYPE_HEADER:
                    viewPager= (ViewPager) itemView.findViewById(R.id.header);
                    linePageIndicator= (LinePageIndicator) itemView.findViewById(R.id.indicator);
                    break;
                case TYPE_CONTENT:
                    imageView= (ImageView) itemView.findViewById(R.id.image);
                    textView= (TextView) itemView.findViewById(R.id.tv);
                    name= (TextView) itemView.findViewById(R.id.tv_name);
                    ckandtime= (TextView) itemView.findViewById(R.id.tv_ckandtime);
                    break;
            }


        }
    }

    class ImageAdapter extends PagerAdapter {
        private List<Header> headerList;

        public ImageAdapter(List<Header> headerList) {
            this.headerList = headerList;
        }

        @Override
        public int getCount() {
            return headerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view==object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            final ImageView imageView=new ImageView(container.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout .LayoutParams.MATCH_PARENT, 150));
            if(headerList.size()!=0&&headerList!=null){
                Picasso.with(container.getContext()).load(headerList.get(position).getPic().equals("")?"https://avatars0.githubusercontent.com/u/8577147?v=3&u=61c8520090d53c" +
                        "c125d9105393d55febf7a20178&s=140":headerList.get(position).getPic())
                        .into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {
                                Timber.e("Picasso失败"+headerList.get(position).getPic());

                            }
                        });
            }

            container.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(imageView.getContext(), QqdWebActivity.class);
                    intent.putExtra("topic_id",headerList.get(position).getTopicId());
                    intent.putExtra("board_id",headerList.get(position).getBoardId());
                    intent.putExtra("title",headerList.get(position).getName());
                    imageView.getContext().startActivity(intent);
                }
            });
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView((ImageView)object);
        }


    }
}
