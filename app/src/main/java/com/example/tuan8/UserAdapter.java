package com.example.tuan8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> listuser;

   public void setData(List<User> list){
       this.listuser=list;
       notifyDataSetChanged();
   }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

       return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user=listuser.get(position);
        if(user==null)
        {
            return;
        }
        holder.txtuser.setText(user.getUser());
        holder.txtaddress.setText(user.getAddress());
    }

    @Override
    public int getItemCount() {
       if(listuser!=null)
       {
           return  listuser.size();
       }
        return 0;
    }

    public  class UserViewHolder extends RecyclerView.ViewHolder{

        private TextView txtuser;
        private TextView txtaddress;


        public UserViewHolder(@NonNull View view) {
            super(view);
            txtuser= view.findViewById(R.id.txt_user);
            txtaddress=view.findViewById(R.id.txt_address);

        }

    }
}
