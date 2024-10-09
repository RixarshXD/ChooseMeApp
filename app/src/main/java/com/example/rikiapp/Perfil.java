package com.example.rikiapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Perfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Perfil extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private static String nombre;
    private static String apellido;
    private static String email;

    public Perfil() {
        // Required empty public constructor
    }

    public static Perfil newInstance(String nombre, String apellido, String email) {
        Perfil fragment = new Perfil();
        Bundle args = new Bundle();

        args.putString("nombre", nombre);
        args.putString("apellido", apellido);
        args.putString("email", email);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombre = getArguments().getString("nombre");
            apellido = getArguments().getString("apellido");
            email = getArguments().getString("email");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        LinearLayout linearLayout = view.findViewById(R.id.linearLayout);

        String[][] datos = {
                {"Nombre", nombre},
                {"Apellido", apellido},
                {"Email", email},
        };

        for (String[] dato : datos){
            TextView textView = new TextView(getContext());
            textView.setText(dato[0] + ": " + dato[1]);
            textView.setTextSize(18);
            textView.setPadding(0, 16, 0, 16);
            linearLayout.addView(textView);

        }

        return view;
    }


}