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
 * {@link Fragment_parCuerpo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_parCuerpo extends Fragment {

    private OnFragmentInteractionListener mListener;

    AdaptadorDeImagenes adapter;
    Comunicador comunicador;

    String[] titulo = new String[]{
            "OJO",
            "PIES",
            "PIERNAS",
            "ESPALDA",
            "LABIOS",
            "MANOS",
            "PECHO",
            "NARIZ",
            "CUELLO",
            "DIENTES",
            "LENGUA",
            "RODILLA",
            "BRAZO",
            "OREJA",
            "CABELLO",
            "ESTOMAGO"

    };

    int[] imagenes = {
            R.drawable.ojo,
            R.drawable.pies,
            R.drawable.piernas,
            R.drawable.espalda,
            R.drawable.labios,
            R.drawable.manos,
            R.drawable.pecho,
            R.drawable.nariz,
            R.drawable.cuello,
            R.drawable.dientes,
            R.drawable.lengua,
            R.drawable.rodilla,
            R.drawable.brazo,
            R.drawable.oreja,
            R.drawable.cabello,
            R.drawable.estomago
    };


    public Fragment_parCuerpo() {
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
        View view = inflater.inflate(R.layout.fragment_fragment_par_cuerpo, container, false);
        final GridView listgridpartecuerpo = (GridView)view.findViewById(R.id.listagridpartecuerpo);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listgridpartecuerpo.setAdapter(adapter);
        listgridpartecuerpo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("ojos");
                    //mp = MediaPlayer.create(getContext(), R.raw.pedro);
                    //mp.start();
                }else if(pos == 1){
                    comunicador.enviar("pies");
                }else if(pos == 2){
                    comunicador.enviar("piernas");
                }else if(pos == 3){
                    comunicador.enviar("espalda");
                }else if(pos == 4){
                    comunicador.enviar("labios");
                }else if(pos == 5){
                    comunicador.enviar("manos");
                }else if(pos == 6){
                    comunicador.enviar("pecho");
                }else if(pos == 7){
                    comunicador.enviar("nariz");
                }else if(pos == 8){
                    comunicador.enviar("cuello");
                }else if(pos == 9){
                    comunicador.enviar("dientes");
                }else if(pos == 10){
                    comunicador.enviar("lengua");
                }else if(pos == 11){
                    comunicador.enviar("rodilla");
                }else if(pos == 12){
                    comunicador.enviar("brazo");
                }else if(pos == 13){
                    comunicador.enviar("oreja");
                }else if(pos == 14){
                    comunicador.enviar("cabello");
                }else if(pos == 15){
                    comunicador.enviar("estómago");
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
