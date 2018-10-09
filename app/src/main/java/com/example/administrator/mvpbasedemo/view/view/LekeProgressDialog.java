package com.example.administrator.mvpbasedemo.view.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mvpbasedemo.R;


/**
 * Created by ljp on 2018/8/29.
 * <p>
 */
public class LekeProgressDialog extends Dialog {

    private ImageView mImageView;
    private TextView mMessage;

    public LekeProgressDialog(Context context) {
        super(context, R.style.alert_dialog);
        setContentView(R.layout.leke_baseview_progress_dialog);
        mImageView = findViewById(R.id.leke_baseview_progress_rotate_image);
        mMessage = findViewById(R.id.leke_baseview_progress_progress_message);
        this.setCancelable(false);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.leke_baseresource_dialog_loading_progress_anim);
        mImageView.startAnimation(animation);
    }

    public void setMessage(int id) {
        mMessage.setText(id);
    }

    public void hideText() {
        mMessage.setVisibility(View.GONE);
    }

    public void setMessage(String text) {
        mMessage.setText(text);
    }
}
