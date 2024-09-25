package com.example.rikiapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Principal), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

// metodo para iniciar sesion y validar el correo
public void login(View v) {
    try {
        // Recuperar el id del input del correo
        EditText campoCorreo = this.findViewById(R.id.correo);
        // Pasar a string
        String correoSTR = campoCorreo.getText().toString();

        // Recuperar el id del input de la contraseña
        EditText campoContrasenia = this.findViewById(R.id.contrasenia);
        // Pasar a string
        String contraseniaSTR = campoContrasenia.getText().toString();

        System.out.println(correoSTR + " " + contraseniaSTR);

        // Validar si el correo y la contraseña son correctos
        if (correoSTR.equals("admin") && contraseniaSTR.equals("admin")) {

            CheckBox cbRecuerdame = (CheckBox) findViewById(R.id.cbRecuerdame);
            boolean chequeado = cbRecuerdame.isChecked();
            if(chequeado == true){
                SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = datos.edit();
                editor.putString("correo", correoSTR);
                editor.apply();
            }


            Intent intent = new Intent(this, Principal.class); // Aquí redirecciono a la pantalla
            startActivity(intent);
        } else {
            Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    } catch (Exception e) {
        e.printStackTrace();
        Toast.makeText(this, "Ocurrió un error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}



    public void crearCuenta(View v) {
        Intent intent = new Intent(this, RegistrarCuenta.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        String correo = datos.getString("correo", "");

        if(!correo.equals("")){
            Intent i = new Intent(this, Principal.class);
            startActivity(i);
        }
    }

    public void insigniasCertificaciones(View v) {
        Intent intent = new Intent(this, InsigniasCertificaciones.class);
        startActivity(intent);
    }

    public void Perfil(MenuItem item) {
        Intent i = new Intent(this, Perfil.class);
        startActivity(i);
    }

    public void OlvidarCuenta(View view) {
        Intent i = new Intent(this, OlvidarCuenta.class);
        startActivity(i);
    }


}