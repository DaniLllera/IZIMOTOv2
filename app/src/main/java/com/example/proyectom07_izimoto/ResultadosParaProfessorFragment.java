package com.example.proyectom07_izimoto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectom07_izimoto.databinding.FragmentPermisoCamionBinding;
import com.example.proyectom07_izimoto.databinding.FragmentResultadosParaProfessorBinding;


public class ResultadosParaProfessorFragment extends Fragment {


    FragmentResultadosParaProfessorBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentResultadosParaProfessorBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_resultadosParaProfessorFragment_to_enviarCorreoFragment);
            }
        });

    }
}