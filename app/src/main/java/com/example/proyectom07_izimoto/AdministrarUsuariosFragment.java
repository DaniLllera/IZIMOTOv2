package com.example.proyectom07_izimoto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectom07_izimoto.Model.Usuario;
import com.example.proyectom07_izimoto.databinding.FragmentAdministrarUsuariosBinding;
import com.example.proyectom07_izimoto.databinding.FragmentPaginaPrincipalProfessorBinding;
import com.example.proyectom07_izimoto.databinding.ViewholderUsuariosBinding;

import java.util.List;


public class AdministrarUsuariosFragment extends Fragment {

FragmentAdministrarUsuariosBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentAdministrarUsuariosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppViewModel appViewModel = new ViewModelProvider(this).get(AppViewModel.class);


    }

    class  AlbumsAdapter extends RecyclerView.Adapter<UsuarioViewHolder> {

        List<Usuario> usuarioList;
        @NonNull
        @Override
        public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UsuarioViewHolder(ViewholderUsuariosBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
            Usuario usuario = usuarioList.get(position);

            /*AQUI ESTA EL ERROR
            holder.binding.titulo.setText(usuario.);
*/
        }

        @Override
        public int getItemCount() {
            return usuarioList == null ? 0 : usuarioList.size();
        }
        void  setUsuarioList (List<Usuario> usuarioList){
            this.usuarioList = usuarioList;
        }
    }
    class UsuarioViewHolder extends RecyclerView.ViewHolder {

        ViewholderUsuariosBinding binding;

        public UsuarioViewHolder(@NonNull ViewholderUsuariosBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}