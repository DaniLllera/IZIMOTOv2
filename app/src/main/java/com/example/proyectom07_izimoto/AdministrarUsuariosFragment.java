package com.example.proyectom07_izimoto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.proyectom07_izimoto.Model.Usuario;
import com.example.proyectom07_izimoto.databinding.FragmentAdministrarUsuariosBinding;
import com.example.proyectom07_izimoto.databinding.FragmentPaginaPrincipalProfessorBinding;
import com.example.proyectom07_izimoto.databinding.ViewholderUsuariosBinding;

import java.util.List;


public class AdministrarUsuariosFragment extends Fragment {

FragmentAdministrarUsuariosBinding binding;
    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentAdministrarUsuariosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        AppViewModel appViewModel = new ViewModelProvider(this).get(AppViewModel.class);

        UsuariosAdapter usuariosAdapter = new UsuariosAdapter();

        binding.recyclerView.setAdapter(usuariosAdapter);

        appViewModel.usuarios().observe(getViewLifecycleOwner(), new Observer<List<Usuarios>>() {
            @Override
            public void onChanged(List<Usuarios> usuarios) {
                usuariosAdapter.setUsuarioList(usuarios);
            }
        });

    }

    class  UsuariosAdapter extends RecyclerView.Adapter<UsuariosViewHolder> {

        List<Usuarios> usuarioList;
        @NonNull
        @Override
        public UsuariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UsuariosViewHolder(ViewholderUsuariosBinding.inflate(getLayoutInflater(), parent, false));
        }


        @Override
        public void onBindViewHolder(@NonNull UsuariosViewHolder holder, int position) {

            Usuarios usuario = usuarioList.get(position);

            holder.binding.titulo.setText(usuario.titulo);
            Glide.with(AdministrarUsuariosFragment.this).load(usuario.portada).into(holder.binding.portada);


        }


        @Override
        public int getItemCount() {

            return usuarioList == null ? 0 : usuarioList.size();
        }
        void  setUsuarioList (List<Usuarios> usuarioList){
            this.usuarioList = usuarioList;
            notifyDataSetChanged();
        }
    }
    class UsuariosViewHolder extends RecyclerView.ViewHolder {

        ViewholderUsuariosBinding binding;

        public UsuariosViewHolder(@NonNull ViewholderUsuariosBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
