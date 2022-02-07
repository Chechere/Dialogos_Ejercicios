package com.cesartejero.ejercicio_dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MiDialogoEjercicio2 extends DialogFragment {

    public interface MiDialogoListener { void onDialogResult(String opcion); }

    MiDialogoListener miEscuchador;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        assert getArguments() != null;
        final String title = getArguments().getString("title");
        String[] opciones = getResources().getStringArray(R.array.DialogOptionsEj2);

        builder.setTitle(title)
               .setItems(opciones,
                         (dialogInterface, i) -> miEscuchador.onDialogResult(opciones[i])
                        );


        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            miEscuchador = (MiDialogoListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(requireActivity().toString() + " must implement MiDialogoListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        miEscuchador = null;
    }
}