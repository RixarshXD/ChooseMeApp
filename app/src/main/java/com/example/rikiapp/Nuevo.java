package com.example.rikiapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Nuevo#newInstance} factory method to
 * create an instance of this fragment.
 */


public class Nuevo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Nuevo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Nuevo.
     */
    // TODO: Rename and change types and number of parameters
    public static Nuevo newInstance(String param1, String param2) {
        Nuevo fragment = new Nuevo();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nuevo, container, false);

        Button compartirButton = view.findViewById(R.id.btnCompartir);
        compartirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] textos = getTextViewsContent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("publicaciones", textos);

                Inicio inicioFragment = new Inicio();
                inicioFragment.setArguments(bundle);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor, inicioFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }

    public String[][] getTextViewsContent() {
        View view = getView();
        if (view == null) return new String[0][0];

        LinearLayout linearLayout = view.findViewById(R.id.linearLayoutInformacion);
        int childCount = linearLayout.getChildCount();
        String[][] textos = new String[childCount][2];

        for (int i = 0; i < childCount; i++) {
            View child = linearLayout.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                textos[i][0] = "Publicacion" + (i + 1);
                textos[i][1] = textView.getText().toString();
            }
        }
        return textos;
    }
}

