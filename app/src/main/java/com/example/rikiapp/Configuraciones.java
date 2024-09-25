package com.example.rikiapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Configuraciones extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Configuraciones() {
        // Required empty public constructor
    }

    public static Configuraciones newInstance(String param1, String param2) {
        Configuraciones fragment = new Configuraciones();
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
        View view = inflater.inflate(R.layout.fragment_configuraciones, container, false);

        EditText editTextDeviceName = view.findViewById(R.id.editTextDeviceName);
        Switch switchAirplaneMode = view.findViewById(R.id.switchAirplaneMode);
        SeekBar seekBarVolume = view.findViewById(R.id.seekBarVolume);
        SeekBar seekBarBrightness = view.findViewById(R.id.seekBarBrightness);
        Button btnGuardar = view.findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deviceName = editTextDeviceName.getText().toString();
                boolean airplaneMode = switchAirplaneMode.isChecked();
                int volume = seekBarVolume.getProgress();
                int brightness = seekBarBrightness.getProgress();

                Toast.makeText(getActivity(), "Configuraciones guardadas:\n" +
                        "Nombre del dispositivo: " + deviceName + "\n" +
                        "Modo avión: " + airplaneMode + "\n" +
                        "Volumen: " + volume + "\n" +
                        "Brillo: " + brightness, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}