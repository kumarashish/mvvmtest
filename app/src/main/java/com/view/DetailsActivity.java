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
import com.google.gson.Gson;
import com.testproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.Result;


public class DetailsActivity  extends Activity {
    Result model=null;
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
       model= new Gson().fromJson(getIntent().getStringExtra("resultdata"),Result.class);
        Log.d("TAG", "onCreate: "+model);
        setUI();

    }
    public void setUI()
    {
        Glide.with(this).load(model.getMultimedia().getSrc()).into(imageView);
        shortheading.setText(model.getDisplayTitle());
        heading.setText(model.getHeadline());
        content.setText(model.getSummaryShort());
        by.setText("By  "+model.getByline());
        publishedon.setText(model.getPublicationDate());
        hyperlinkcontent.setText(model.getLink().getSuggestedLinkText());
        hyperlink.setText(Html.fromHtml("<p><u>"+model.getLink().getUrl()+"</u></p>"));
    }

    @OnClick({R.id.hyperlink})
    public void onClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(model.getLink().getUrl()));
        startActivity(browserIntent);
    }



}
