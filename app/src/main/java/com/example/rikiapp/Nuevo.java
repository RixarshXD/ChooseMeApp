// Nuevo.java
package com.example.rikiapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Nuevo extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri imageUri;
    private ImageView imageView;
    private static ArrayList<Bundle> imageDataList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nuevo, container, false);

        imageView = view.findViewById(R.id.imageView);
        EditText titleEditText = view.findViewById(R.id.editTextText);
        EditText descriptionEditText = view.findViewById(R.id.editTextText2);
        EditText locationEditText = view.findViewById(R.id.editTextText3);
        EditText detailsEditText = view.findViewById(R.id.editTextText4);
        Button uploadButton = view.findViewById(R.id.btnCompartir);
        Button selectImageButton = view.findViewById(R.id.selectImageButton);

        selectImageButton.setOnClickListener(v -> abrirImagen());

        uploadButton.setOnClickListener(v -> {
            String title = titleEditText.getText().toString();
            String description = descriptionEditText.getText().toString();
            String location = locationEditText.getText().toString();
            String details = detailsEditText.getText().toString();

            if (title.isEmpty() || description.isEmpty() || location.isEmpty() || details.isEmpty() || imageUri == null) {
                Toast.makeText(getContext(), "Llenar todos los campos para publicar", Toast.LENGTH_SHORT).show();
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putString("description", description);
                bundle.putString("location", location);
                bundle.putString("details", details);
                bundle.putParcelable("imageUri", imageUri);

                imageDataList.add(bundle);

                Inicio inicioFragment = new Inicio();
                Bundle args = new Bundle();
                args.putParcelableArrayList("imageDataList", imageDataList);
                inicioFragment.setArguments(args);

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, inicioFragment).commit();
            }
        });

        return view;
    }

    private void abrirImagen() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == getActivity().RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}