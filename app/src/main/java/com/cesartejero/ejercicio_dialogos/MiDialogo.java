package com.cesartejero.ejercicio_dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MiDialogo extends DialogFragment {
    public interface MiDialogoListener {
        void onDialogResult(boolean devuelto);
    }

    MiDialogoListener miEscuchador;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.SalirDialogTitle)
                .setMessage(R.string.SalirDialogBody)
                .setNegativeButton(R.string.SalirDialogNo, (dialog, id) -> miEscuchador.onDialogResult(false))
                .setPositiveButton(R.string.SalirDialogSi, (dialog, id) -> miEscuchador.onDialogResult(true));
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            miEscuchador = (MiDialogoListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement MiDialogoListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        miEscuchador=null;
    }
}