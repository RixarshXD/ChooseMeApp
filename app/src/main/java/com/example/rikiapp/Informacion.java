package com.example.rikiapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Informacion extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Informacion() {
        // Required empty public constructor
    }

    public static Informacion newInstance(String param1, String param2) {
        Informacion fragment = new Informacion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_informacion, container, false);
        LinearLayout linearLayout = view.findViewById(R.id.linearLayoutInformacion);

        String[][] voluntariados = {
                {"Nombre del Voluntariado", "Ayuda a los Ancianos"},
                {"Ubicación", "Centro Comunitario"},
                {"Fecha", "25 de Diciembre, 2023"},
                {"Hora", "10:00 AM - 2:00 PM"},
                {"Descripción", "Ayuda a los ancianos con actividades recreativas y cuidado personal."},
                {"Contacto", "voluntarios@comunidad.org"},
        };

        for (String[] voluntariado : voluntariados) {
            TextView textView = new TextView(getContext());
            textView.setText(voluntariado[0] + ": " + voluntariado[1]);
            textView.setTextSize(18);
            textView.setPadding(0, 16, 0, 16);
            linearLayout.addView(textView);
        }

        return view;
    }
}