package com.example.proyectom07_izimoto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.proyectom07_izimoto.Model.Usuario;

import java.util.Arrays;
import java.util.List;

public class UsuarioRepository {
    LiveData<List<Usuarios>> usuariosLiveData;

    UsuarioRepository() {

        List<Usuarios> usuarios = Arrays.asList(
                new Usuarios("Jose", "8", R.drawable.mariano),
                new Usuarios("Alejandro","7",R.drawable.image),
                 new Usuarios("Juan","7",R.drawable.cara1),
                 new Usuarios("Dani","7",R.drawable.cara2),
                new Usuarios("Maria","7",R.drawable.cara3),
                new Usuarios("Pol","7",R.drawable.cara4),
                new Usuarios("Juana","7",R.drawable.cara5),
                new Usuarios("Lolo","7",R.drawable.cara6),
                new Usuarios("Jaime","7",R.drawable.cara7),
                new Usuarios("Maite","7",R.drawable.cara8),
                new Usuarios("Nuria","7",R.drawable.cara9),
                new Usuarios("Josefa","7",R.drawable.cara10),
                new Usuarios("Josepe","7",R.drawable.cara11)
        );

        usuariosLiveData = new MutableLiveData<>(usuarios);
    }


    LiveData<List<Usuarios>> usuarios() {
        return usuariosLiveData;
    }
}
