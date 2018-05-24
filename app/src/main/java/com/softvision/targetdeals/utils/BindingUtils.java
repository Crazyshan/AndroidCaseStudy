package com.softvision.targetdeals.utils;

import android.content.*;
import android.databinding.*;
import android.net.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;

import com.bumptech.glide.*;
import com.softvision.targetdeals.data.model.*;
import com.softvision.targetdeals.ui.landing.*;

import java.util.*;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }
    @BindingAdapter({"adapter"})
    public static void addBlogItems(RecyclerView recyclerView, List<Datum> blogs) {
        DealsItemAdapter adapter = (DealsItemAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(blogs);
        }
    }
    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }


}
