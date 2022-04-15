package com.belajar.colalin.homeView.CardAdapter;

import android.view.View;

public class OnItemClick implements View.OnClickListener {
    private int position;
    private OnItemCallBack onItemCallBack;

    @Override
    public void onClick(View view) {
        onItemCallBack.OnItemClicked(view, position);
    }

    public OnItemClick(int position, OnItemCallBack onItemCallBack) {
        this.position = position;
        this.onItemCallBack = onItemCallBack;
    }

    public interface OnItemCallBack{
        void OnItemClicked(View view, int position);
    }
}
