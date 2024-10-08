package com.example.rikiapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;




public class Principal extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        linearLayout = findViewById(R.id.linearLayoutInformacion);


        //referencia al toolbar
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        //este es mi bottombar
        TabLayout tl = findViewById(R.id.navbottom);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int posicion = tab.getPosition();
                switch (posicion) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Inicio()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Nuevo()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Informacion()).commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Perfil()).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
            //menu lateral
        NavigationView nav = findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.opInicio) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Inicio()).commit();
            } else if(id == R.id.opOrganizaciones){
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Organizaciones()).commit();
            }else if (id == R.id.opPuestos) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Puestos()).commit();
            }else if (id == R.id.opConfiguracion) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Configuraciones()).commit();
            } else if (id == R.id.opCerrarSesion) {
                SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = datos.edit();
                editor.remove("correo");
                editor.apply();
                finish();
            }
            DrawerLayout drawerLayout = findViewById(R.id.Principal);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        DrawerLayout dl = findViewById(R.id.Principal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                dl,
                R.string.abrir_drawer,
                R.string.cerrar_drawer
        );
        dl.addDrawerListener(toggle);
        toggle.syncState();

        tb.setNavigationOnClickListener(view -> {
            if (dl.isDrawerOpen(GravityCompat.START)) {
                dl.closeDrawer(GravityCompat.START);
            } else {
                dl.openDrawer(GravityCompat.START);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Principal), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void perfil(MenuItem item) {
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Perfil()).commit();
    }

    public void insigniasCertificaciones(MenuItem item) {
        Intent intent = new Intent(this, InsigniasCertificaciones.class);
        startActivity(intent);
    }
}