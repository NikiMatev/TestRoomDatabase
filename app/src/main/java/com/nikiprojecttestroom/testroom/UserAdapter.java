package com.nikiprojecttestroom.testroom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nikiprojecttestroom.testroom.databinding.UserRowBinding;

import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> users;


    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        holder.firstName.setText(users.get(position).getFirstName());
        holder.lastName.setText(users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //private UserRowBinding binding;
        public TextView firstName, lastName,email;


        public ViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.first_Name);
            lastName = itemView.findViewById(R.id.last_Name);
            email = itemView.findViewById(R.id.user_Email);
        }
    }
}
