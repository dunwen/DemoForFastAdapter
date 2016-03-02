package edu.cqut.cn.demoforfastadapter.Beans;

import android.widget.ImageView;
import android.widget.TextView;

import com.dundunwen.annotation.BindId;

import edu.cqut.cn.demoforfastadapter.R;

/**
 * Created by dun on 2016/3/2.
 */
public class News {
    @BindId(Id = R.id.newlist_title,ViewType = TextView.class)
    String newTitle;

    @BindId(Id = R.id.newlist_time,ViewType = TextView.class)
    String postTime;

    @BindId(Id = R.id.newlist_headimage,ViewType = ImageView.class)
    String ImageUrl;

    public News() {
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}

