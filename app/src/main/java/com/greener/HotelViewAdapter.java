package com.greener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HotelViewAdapter extends RecyclerView.Adapter<HotelViewAdapter.ViewHolder> {

    private ArrayList<HotelList> arrayList;
    private Context context;

    public HotelViewAdapter(ArrayList<HotelList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    // ViewHolder 생성
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotellist_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    //position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView).load(arrayList.get(position).getHotelImage()).into(holder.hotel_image);
        holder.hotel_name.setText(arrayList.get(position).getHotelName());
        holder.hotel_telNum.setText(arrayList.get(position).getHotelTel());
    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0); // RecyclerView의 size return
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hotel_image;
        TextView hotel_name;
        TextView hotel_telNum;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);

            this.hotel_image = itemView.findViewById(R.id.hotel_image);
            this.hotel_name = itemView.findViewById(R.id.hotel_name);
            this.hotel_telNum = itemView.findViewById(R.id.hotel_telNum);
        }

    }

}
