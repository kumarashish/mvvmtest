package com.view;




import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.testproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.Result;
import room.Data;


public class DetailsActivity  extends Activity {
   Data model=null;
    @BindView(R.id.heading)
    TextView heading;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.hyperlink)
    TextView hyperlink;
    @BindView(R.id.by)
    TextView by;
    @BindView(R.id.publishedon)
    TextView publishedon;
    @BindView(R.id.hyperlinkcontent)
    TextView hyperlinkcontent;
    @BindView(R.id.shortheading)
    TextView shortheading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        model= new Gson().fromJson(getIntent().getStringExtra("resultdata"), Data.class);
        Log.d("TAG", "onCreate: "+model);
        setUI();

    }
    public void setUI()
    { RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.no_image);
        requestOptions.error(R.drawable.no_image);
        Glide.with(this).load(model.getSrc()).apply(requestOptions).into(imageView);
        shortheading.setText(model.getDisplay_title());
        heading.setText(model.getHeadline());
        content.setText(model.getSummary_short());
        by.setText("By  "+model.getByline());
        publishedon.setText(model.getPublication_date());
        hyperlinkcontent.setText(model.getSuggested_link_text());
        hyperlink.setText(Html.fromHtml("<p><u>"+model.getUrl()+"</u></p>"));
    }

    @OnClick({R.id.hyperlink})
    public void onClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(model.getUrl()));
        startActivity(browserIntent);
    }



}
