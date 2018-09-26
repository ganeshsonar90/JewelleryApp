package com.jewellery.jewellery_list_detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jewellery.R;
import com.jewellery.data.local.entity.CategoryImage;
import com.jewellery.data.local.entity.Cateloguecategory;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import java.util.List;

/**
 * Created by gboss on 22/09/18.
 */


public class JewelleryListAdapter extends RecyclerView.Adapter<JewelleryListAdapter.MyViewHolder> {


  private final List<Cateloguecategory> mJewelleryList;

  public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public CarouselView carouselView;

    public MyViewHolder(View view) {
      super(view);
      title = (TextView) view.findViewById(R.id.title);
      carouselView = (CarouselView) view.findViewById(R.id.carouselView);
    }
  }


  public JewelleryListAdapter(List<Cateloguecategory> jewelleryList) {
    this.mJewelleryList = jewelleryList;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.jewellery_list_row, parent, false);

    return new MyViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, final int position) {
    Cateloguecategory jewellery = mJewelleryList.get(position);

    if (jewellery.getCategoryName() != null) {
      holder.title.setText(jewellery.getCategoryName());
    }

    final List<CategoryImage> categoryImages = jewellery.getCategoryImages();
    if (categoryImages != null && categoryImages.size() > 0) {
      holder.carouselView.setPageCount(categoryImages.size());
      holder.carouselView.setImageListener(new ImageListener() {
        @Override
        public void setImageForPosition(int imagePosition, ImageView imageView) {

          CategoryImage categoryImage = categoryImages.get(imagePosition);
          if (categoryImage != null) {
            String imageUrl = categoryImage.getIphone();
            if (imageUrl != null && !imageUrl.isEmpty()) {
              Picasso.get().load(imageUrl).placeholder(R.color.image_placeholder).into(imageView);
            }

          }


        }
      });

    }


  }

  @Override
  public int getItemCount() {
    return mJewelleryList.size();
  }
}
