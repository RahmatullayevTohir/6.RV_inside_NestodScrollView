 package com.example.a6rv_inside_nestodscrollview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a6rv_inside_nestodscrollview.adapter.CustomAdapter;
import com.example.a6rv_inside_nestodscrollview.model.User;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    private Context context;
    private NestedScrollView nestedScrollView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<User> users = prepareUserList();
        refreshAdapter(users);
    }

     private void initViews() {
        nestedScrollView = findViewById(R.id.nestedScrollView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
     }

     private void refreshAdapter(List<User>users){
         CustomAdapter adapter = new CustomAdapter(context, users);
         recyclerView.setAdapter(adapter);
         recyclerView.setNestedScrollingEnabled(false);
     }


     private List<User> prepareUserList() {
        List<User>users = new ArrayList<>();
        users.add(new User());  // for Header

         for (int i =1; i<20; i++) {
             if (i == 5 || i == 10) {
                 users.add(new User("Rahmatullayev " + i, "Tohir " + i));
             }
             else {
                 users.add(new User("Ortig'aliyev "+i,"AbuBakr "+i));
             }
         }
         return users;

     }


}