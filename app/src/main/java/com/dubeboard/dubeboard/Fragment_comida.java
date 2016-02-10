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
 * {@link Fragment_comida.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_comida extends Fragment {

    private OnFragmentInteractionListener mListener;

    AdaptadorDeImagenes adapter;
    Comunicador comunicador;

    String[] titulo = new String[]{
            "SANDWICH",
            "CAFE",
            "PAN",
            "VERDURAS",
            "FRUTA",
            "LECHE",
            "PESCADO",
            "HUEVO",
            "CARNE",
            "POLLO",
            "SOPA",
            "JUGO",
            "TORTILLA",
            "FREJOL"
    };

    int[] imagenes = {
            R.drawable.sanduche,
            R.drawable.cafe,
            R.drawable.pan,
            R.drawable.verduras,
            R.drawable.fruta,
            R.drawable.leche,
            R.drawable.pescado,
            R.drawable.huevo,
            R.drawable.carne,
            R.drawable.pollo,
            R.drawable.sopa,
            R.drawable.jugo,
            R.drawable.tortilla,
            R.drawable.frejol
    };

    public Fragment_comida() {
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
        View view =  inflater.inflate(R.layout.fragment_fragment_comida, container, false);
        final GridView listgridcomida = (GridView)view.findViewById(R.id.listagridcomida);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listgridcomida.setAdapter(adapter);
        listgridcomida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("sanduche");
                    //mp = MediaPlayer.create(getContext(), R.raw.pedro);
                    //mp.start();
                }else if(pos == 1){
                    comunicador.enviar("café");
                }else if(pos == 2){
                    comunicador.enviar("pan");
                }else if(pos == 3){
                    comunicador.enviar("verduras");
                }else if(pos == 4){
                    comunicador.enviar("fruta");
                }else if(pos == 5){
                    comunicador.enviar("leche");
                }else if(pos == 6){
                    comunicador.enviar("pescado");
                }else if(pos == 7){
                    comunicador.enviar("huevo");
                }else if(pos == 8){
                    comunicador.enviar("carne");
                }else if(pos == 9){
                    comunicador.enviar("pollo");
                }else if(pos == 10){
                    comunicador.enviar("sopa");
                }else if(pos == 11){
                    comunicador.enviar("jugo");
                }else if(pos == 12){
                    comunicador.enviar("tortilla");
                }else if(pos == 13){
                    comunicador.enviar("frejol");
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
