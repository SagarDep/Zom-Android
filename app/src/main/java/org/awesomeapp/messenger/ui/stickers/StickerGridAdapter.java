package org.awesomeapp.messenger.ui.stickers;

import java.io.InputStream;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class StickerGridAdapter extends BaseAdapter
{
    private Context mContext;       
    ArrayList<Sticker> mEmoji;
    
    public StickerGridAdapter(Context c, ArrayList<Sticker> emoji)
    {
          mContext = c;
          mEmoji = emoji;
          
    }
    
    
    public int getCount() 
    {
          return mEmoji.size();
    }
    public Object getItem(int position)
    {
          return mEmoji.get(position);
    }
    public long getItemId(int position)
    {
          return position;
    }

    public View getView(int position,View convertView,ViewGroup parent)
    {
       
        ImageView i = null ;

        if (convertView != null && convertView instanceof ImageView)
        	i = (ImageView)convertView;
        else
        	i = new ImageView(mContext);
       
  	  try
  	  {
  		  
  		  InputStream  is = mEmoji.get(position).res.getAssets().open(mEmoji.get(position).assetUri.getPath());
    	
    	  Bitmap bmp = BitmapFactory.decodeStream(is);
    	  
          i = new ImageView(mContext);
          i.setLayoutParams(new GridView.LayoutParams(256,256));
          i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          i.setImageBitmap(bmp);

  	  }
  	  catch (Exception e)
  	  {
  		  Log.e("grid","problem rendering grid",e);
  	  }
  	  
         return i;
    }               
}