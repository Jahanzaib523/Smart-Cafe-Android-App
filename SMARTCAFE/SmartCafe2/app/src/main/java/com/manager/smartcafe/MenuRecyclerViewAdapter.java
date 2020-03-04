package com.manager.smartcafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.manager.smartcafe.database.Menu;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.MenuViewHolder> {

    private Context mContext;

    private List<Menu> menuList;

    public MenuRecyclerViewAdapter(Context mContext, List<Menu> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }


    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.snippet_menu_row,parent,false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menu = this.menuList.get(position);


        Glide.with(mContext).load(menu.getMenuImageUrl()).error(R.mipmap.smartcafe_200x200).into(holder.ivMenuImage);
        holder.tvMenuName.setText(menu.getMenuName());
        holder.tvMenuPrice.setText("RS: "+menu.getMenuPrice());
        holder.tvMenuDescription.setText(menu.getMenuDescription());

    }





    @Override
    public int getItemCount() {
        return menuList.size();
    }


    public class MenuViewHolder extends   RecyclerView.ViewHolder{

        ImageView ivMenuImage;
        TextView tvMenuName,tvMenuPrice,tvMenuDescription;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMenuImage = itemView.findViewById(R.id.iv_menu_image);
            tvMenuName = itemView.findViewById(R.id.tv_menu_name);
            tvMenuDescription = itemView.findViewById(R.id.tv_menu_discription);
            tvMenuPrice = itemView.findViewById(R.id.tv_menu_price);
        }
    }
}
