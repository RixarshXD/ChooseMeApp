// Inicio.java
package com.example.rikiapp;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class Inicio extends Fragment {

    private ArrayList<Bundle> imageDataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        if (getArguments() != null) {
            imageDataList = getArguments().getParcelableArrayList("imageDataList");
        } else {
            imageDataList = new ArrayList<>();
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_item, parent, false);
                return new ViewHolder(itemView);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ViewHolder viewHolder = (ViewHolder) holder;
                Bundle bundle = imageDataList.get(position);
                viewHolder.titleTextView.setText(bundle.getString("title"));
                viewHolder.descriptionTextView.setText(bundle.getString("description"));
                viewHolder.locationTextView.setText(bundle.getString("location"));
                viewHolder.detailsTextView.setText(bundle.getString("details"));
                viewHolder.imageView.setImageURI((Uri) bundle.getParcelable("imageUri"));
            }

            @Override
            public int getItemCount() {
                return imageDataList.size();
            }

            class ViewHolder extends RecyclerView.ViewHolder {
                TextView titleTextView, descriptionTextView, locationTextView, detailsTextView;
                ImageView imageView;

                ViewHolder(@NonNull View itemView) {
                    super(itemView);
                    titleTextView = itemView.findViewById(R.id.titleTextView);
                    descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
                    locationTextView = itemView.findViewById(R.id.locationTextView);
                    detailsTextView = itemView.findViewById(R.id.detailsTextView);
                    imageView = itemView.findViewById(R.id.imageView);
                }
            }
        });

        return view;
    }
}