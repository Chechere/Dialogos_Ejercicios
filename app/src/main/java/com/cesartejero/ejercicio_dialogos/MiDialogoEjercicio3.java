package com.cesartejero.ejercicio_dialogos;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;

public class MiDialogoEjercicio3  extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    public interface MiDialogoListener {
        void onDialogResult(Date fecha);
    }

    MiDialogoListener miEscuchador;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        /*assert getArguments() != null;
        final String title = getArguments().getString("title");
        String[] opciones = getResources().getStringArray(R.array.DialogOptionsEj2);

        builder.setTitle(title)
                .setItems(opciones, (dialogInterface, i) -> miEscuchador.onDialogResult(opciones[i]));
        */
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i1, i2);
        miEscuchador.onDialogResult(calendar.getTime());
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