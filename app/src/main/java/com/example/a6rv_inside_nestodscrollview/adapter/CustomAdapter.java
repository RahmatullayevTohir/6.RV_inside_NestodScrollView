package com.example.a6rv_inside_nestodscrollview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a6rv_inside_nestodscrollview.R;
import com.example.a6rv_inside_nestodscrollview.model.User;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<User> users;

    public CustomAdapter(Context context, List<User> users){
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);
        if (holder instanceof CustomViewHolder) {
            TextView name1 = ((CustomViewHolder) holder).name1;
            TextView name2 = ((CustomViewHolder) holder).name2;

            name1.setText(user.getName1());
            name2.setText(user.getName2());

        }

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
public class CustomViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public TextView name1, name2;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;

        name1 = view.findViewById(R.id.name1);
        name2 = view.findViewById(R.id.name2);


    }
}
}
