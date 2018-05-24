package com.softvision.targetdeals.ui.base;

import android.support.v7.widget.*;
import android.view.*;


public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void onBind(int position);
}
