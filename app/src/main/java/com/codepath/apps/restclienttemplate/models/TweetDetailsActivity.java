package com.codepath.apps.restclienttemplate.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.R;

import org.parceler.Parcels;

public class TweetDetailsActivity extends AppCompatActivity {

    Tweet tweet;

    ImageView ivProfileDetail;
    TextView tvNameDetail;
    TextView tvScreenNameDetail;
    TextView tvBodyDetail;
    TextView tvDateDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_details);

        ivProfileDetail = findViewById(R.id.ivProfileDetail);
        tvNameDetail = findViewById(R.id.tvNameDetail);
        tvScreenNameDetail = findViewById(R.id.tvScreenNameDetail);
        tvBodyDetail = findViewById(R.id.tvBodyDetail);
        tvDateDetail = findViewById(R.id.tvDateDetail);

        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", tweet.user.name));


        Glide.with(this).load(tweet.user.profileImageUrl).into(ivProfileDetail);
        tvNameDetail.setText(tweet.user.name);
        tvScreenNameDetail.setText("@" + tweet.user.screenName);
        tvBodyDetail.setText(tweet.body);
        tvDateDetail.setText(Tweet.getRelativeTimeAgo(tweet.createdAt));
    }
}