package com.example.rikiapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Organizaciones extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Organizaciones() {
        // Required empty public constructor
    }

    public static Organizaciones newInstance(String param1, String param2) {
        Organizaciones fragment = new Organizaciones();
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
        View view = inflater.inflate(R.layout.fragment_organizaciones, container, false);

        EditText editTextOrgName = view.findViewById(R.id.editTextOrgName);
        EditText editTextOrgAddress = view.findViewById(R.id.editTextOrgAddress);
        EditText editTextOrgContact = view.findViewById(R.id.editTextOrgContact);
        EditText editTextOrgEmail = view.findViewById(R.id.editTextOrgEmail);
        EditText editTextOrgDescription = view.findViewById(R.id.editTextOrgDescription);
        Button btnGuardar = view.findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orgName = editTextOrgName.getText().toString();
                String orgAddress = editTextOrgAddress.getText().toString();
                String orgContact = editTextOrgContact.getText().toString();
                String orgEmail = editTextOrgEmail.getText().toString();
                String orgDescription = editTextOrgDescription.getText().toString();

                Toast.makeText(getActivity(), "Organización guardada:\n" +
                        "Nombre: " + orgName + "\n" +
                        "Dirección: " + orgAddress + "\n" +
                        "Contacto: " + orgContact + "\n" +
                        "Correo: " + orgEmail + "\n" +
                        "Descripción: " + orgDescription, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}