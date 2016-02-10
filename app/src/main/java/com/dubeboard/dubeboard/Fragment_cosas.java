package com.dubeboard.dubeboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_cosas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_cosas extends Fragment {
    AdaptadorDeImagenes adapter;
    Comunicador comunicador;

    private OnFragmentInteractionListener mListener;

    String[] titulo = new String[]{
            "JUGUETE",
            "RELOJ",
            "CELULAR",
            "PEINE",
            "JABON",
            "ALMOHADAS",
            "RADIO",
            "TELEVISOR",
            "BOTELLA",
            "SILLA DE RUEDAS"
    };

    int[] imagenes = {
            R.drawable.juguete,
            R.drawable.reloj,
            R.drawable.celular,
            R.drawable.peine,
            R.drawable.jabon,
            R.drawable.almohadas,
            R.drawable.radio,
            R.drawable.televisor,
            R.drawable.botella,
            R.drawable.silla_de_ruedas
    };

    public Fragment_cosas() {
        // Required empty public constructor
    }

    //COMUNICADOR enviar informacion a Activity
    public interface Comunicador{
        public void enviar (String envia);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_cosas, container, false);
        //Declaramos el Gridview
        final GridView listGridcosas = (GridView)view.findViewById(R.id.listagridcosas);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listGridcosas.setAdapter(adapter);
        listGridcosas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("juguete");
                    //mp = MediaPlayer.create(getContext(), R.raw.pedro);
                    //mp.start();
                }else if(pos == 1){
                    comunicador.enviar("reloj");
                }else if(pos == 2){
                    comunicador.enviar("celular");
                }else if(pos == 3){
                    comunicador.enviar("peine");
                }else if(pos == 4){
                    comunicador.enviar("jabón");
                }else if(pos == 5){
                    comunicador.enviar("almohadas");
                }else if(pos == 6){
                    comunicador.enviar("radio");
                }else if(pos == 7){
                    comunicador.enviar("televisor");
                }else if(pos == 8){
                    comunicador.enviar("botella");
                }else if(pos == 9){
                    comunicador.enviar("silla de ruedas");
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        //INICIAMOS el Comunicador y le asignamos el contexto
        comunicador = (Comunicador) context;
        // Nos aseguramos de que la actividad contenedora haya implementado la
        // interfaz de retrollamada. Si no, lanzamos una excepción
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
