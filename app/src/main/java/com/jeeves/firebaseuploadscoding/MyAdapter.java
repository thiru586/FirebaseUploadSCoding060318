package com.jeeves.firebaseuploadscoding;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import static android.media.ThumbnailUtils.createVideoThumbnail;
import static android.support.v4.content.ContextCompat.startActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<Upload> uploads;

    public MyAdapter(Context context, List<Upload> uploads) {
        this.uploads = uploads;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_images, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Upload upload = uploads.get(position);

        holder.textViewName.setText(upload.getName());
       // holder.mEmVideoView.setVideoURI(uploads);

        Glide
                .with( context )
                .load( upload.getUrl() )
                .into( holder.mEmVideoView);

        //Glide.with(context).load(upload.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewName;
        //public ImageView imageView;
         ImageView mEmVideoView;
        MediaController mMediaController;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName=(TextView)itemView.findViewById(R.id.textViewName);
            mEmVideoView=(ImageView) itemView.findViewById(R.id.imageView);
            mMediaController = new MediaController(context);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            //VideoView Videoview =(VideoView) itemView.findViewById(R.id.Videoview);
            //Videoview.setVideoPath( String.valueOf( uploads ) );
            //Videoview.setMediaController(mMediaController);
           // Videoview.requestFocus();
          //  Videoview.start();

            LayoutInflater inflater;
            inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.layout_images,
                    (ViewGroup) findViewById(R.id.custom_toast_container));

            TextView text = (TextView) layout.findViewById(R.id.text);
            text.setText("This is a custom toast");

            Toast toast = new Toast(context());
            toast.setGravity( Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();

            // Context context = v.getContext();
           // Intent intent = new Intent(context, ChannelDetailActivity.class);
           // context.startActivity(intent);

           //Toast.makeText(context,"The Item Clicked is: "+getPosition(), Toast.LENGTH_SHORT).show();

        }
    };
}
    //class ViewHolder extends RecyclerView.ViewHolder {

      //  public TextView textViewName;
        //public ImageView imageView;

//        public ViewHolder(View itemView) {
  //          super(itemView);

    //        textViewName = (TextView) itemView.findViewById(R.id.textViewName);
      //      imageView = (ImageView) itemView.findViewById(R.id.imageView);
        //}

