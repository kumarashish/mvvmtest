package adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.testproject.R;


import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import interfaces.OnSubscriberCompleted;
import model.Result;

public class ListItemAdapter extends BaseAdapter {
    List<Result> listItems;
    Activity act;
    OnSubscriberCompleted callback;
   public ListItemAdapter(List<Result> listItems , Activity act)
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
       Result model=listItems.get(position);
        ViewHolder holder=null;
        if(convertView==null){

            LayoutInflater inflater=act.getLayoutInflater();
            convertView=inflater.inflate(R.layout.list_item, null,true);
            holder=new ViewHolder(convertView);

        }else{
            holder=(ViewHolder)convertView.getTag();

        }
        holder.heading.setText(model.getHeadline());
        holder.content.setText(model.getSummaryShort());
        holder.date.setText(model.getPublicationDate());
        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onListItemClicked(model);
            }
        });
        Glide.with(act).load(model.getMultimedia().getSrc()).into(holder.imageView);
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
