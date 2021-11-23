package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.examen.Adaptadores.adaptadorContactos;
import com.example.examen.Modelos.Accion;
import com.example.examen.Modelos.Contacto;
import com.example.examen.Modelos.Telefono;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listas);
        String[] permisosNecesarios = new String[1];
        permisosNecesarios[0] = Manifest.permission.CALL_PHONE;

        List<Contacto> l = new ArrayList<>();
        l.add(new Contacto("Alan",new Telefono("8713788377","+52")));
        List<Accion> lis = new ArrayList<>();
        lis.add(new Accion("Marcar","Marcar al 8713788377",1));
        lis.add(new Accion("Abrir Navegador","Abrir el navegador en google",2));
        lis.add(new Accion("Abrir Mapas","Abrir mapas",3));
        lis.add(new Accion("Abrir Marcador", "Abre en el numero 8713788377", 4));
        lis.add(new Accion("Cambiar Pantalla","Cambia pantalla", 5));
        adaptadorContactos ac = new adaptadorContactos(lis);
        lista.setAdapter(ac);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lista.setLayoutManager(lm);
        lista.setHasFixedSize(true);
        verificarPermiso(permisosNecesarios);


    }
    protected void verificarPermiso(String[] permisosNecesarios){
        String[] permisosDenegados = new String[1];
        for (int x = 0; x < permisosNecesarios.length; x++){
            if (ContextCompat.checkSelfPermission(this,permisosNecesarios[x])== PackageManager.PERMISSION_DENIED){
                permisosDenegados[x] = permisosNecesarios[x];
            }
        }
        requestPermissions(permisosDenegados,300);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 300:
                if(permissions.length>0){
                    if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                        //ejecutar accion
                    }
                    else{
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[0])){

                        }
                    }
                }
                break;
        }
    }
}