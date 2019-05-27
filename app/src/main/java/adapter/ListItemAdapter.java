package adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.testproject.R;


import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import interfaces.OnSubscriberCompleted;
import model.Result;
import room.Data;

public class ListItemAdapter extends BaseAdapter {
    List<Data> listItems;
    Activity act;
    OnSubscriberCompleted callback;
   public ListItemAdapter(List<Data> listItems , Activity act)
    {
        this.listItems=listItems;
        callback=(OnSubscriberCompleted) act;
        this.act=act;
    }
    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Data model=listItems.get(position);
        ViewHolder holder=null;
        if(convertView==null){

            LayoutInflater inflater=act.getLayoutInflater();
            convertView=inflater.inflate(R.layout.list_item, null,true);
            holder=new ViewHolder(convertView);

        }else{
            holder=(ViewHolder)convertView.getTag();

        }
        holder.heading.setText(model.getHeadline());
        holder.content.setText(model.getSummary_short());
        holder.date.setText(model.getPublication_date());
        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onListItemClicked(model);
            }
        });
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.no_image);
        requestOptions.error(R.drawable.no_image);
        Glide.with(act).load(model.getSrc()).apply(requestOptions).into(holder.imageView);
        convertView.setTag(holder);
        return convertView;
    }
    public class ViewHolder{
        @BindView(R.id.heading)
        TextView heading;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.click)
        View click;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
