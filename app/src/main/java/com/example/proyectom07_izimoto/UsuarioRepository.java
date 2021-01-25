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
                new Usuarios("Jose", "8", R.drawable.jose),
                new Usuarios("Maria","7",R.drawable.maria)

        );

        usuariosLiveData = new MutableLiveData<>(usuarios);
    }


    LiveData<List<Usuarios>> usuarios() {
        return usuariosLiveData;
    }
}
