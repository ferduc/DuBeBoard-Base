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
 * {@link Fragment_hogar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_hogar extends Fragment {

    private OnFragmentInteractionListener mListener;

    AdaptadorDeImagenes adapter;
    Comunicador comunicador;

    String[] titulo = new String[]{
            "HOGAR",
            "BAÑO",
            "DORMITORIO",
            "CAMA",
            "PUERTA",
            "SILLA",
            "JARDIN",
            "GRADAS",
            "COMEDOR",
            "PISO",
            "TECHO",
            "MESA",
            "SILLON",
            "CASA",
            "SALA",
            "COCINA",
            "VENTANA"
    };

    int[] imagenes = {
            R.drawable.hogar,
            R.drawable.bano,
            R.drawable.dormitorio,
            R.drawable.cama,
            R.drawable.puerta,
            R.drawable.silla,
            R.drawable.jardin,
            R.drawable.gradas,
            R.drawable.comedor,
            R.drawable.piso,
            R.drawable.techo,
            R.drawable.mesa,
            R.drawable.sillon,
            R.drawable.casa,
            R.drawable.sala,
            R.drawable.cocina,
            R.drawable.ventana
    };


    public Fragment_hogar() {
        // Required empty public constructor
    }

    public interface Comunicador{
        public void enviar (String envia);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_hogar, container, false);
        final GridView listgridhogar = (GridView)view.findViewById(R.id.listagridhogar);
        adapter = new AdaptadorDeImagenes(getContext(),titulo,imagenes);
        listgridhogar.setAdapter(adapter);
        listgridhogar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("hogar");
                    //mp = MediaPlayer.create(getContext(), R.raw.pedro);
                    //mp.start();
                }else if(pos == 1){
                    comunicador.enviar("baño");
                }else if(pos == 2){
                    comunicador.enviar("dormitorio");
                }else if(pos == 3){
                    comunicador.enviar("cama");
                }else if(pos == 4){
                    comunicador.enviar("puerta");
                }else if(pos == 5){
                    comunicador.enviar("silla");
                }else if(pos == 6){
                    comunicador.enviar("jardín");
                }else if(pos == 7){
                    comunicador.enviar("gradas");
                }else if(pos == 8){
                    comunicador.enviar("comedor");
                }else if(pos == 9){
                    comunicador.enviar("piso");
                }else if(pos == 10){
                    comunicador.enviar("techo");
                }else if(pos == 11){
                    comunicador.enviar("mesa");
                }else if(pos == 12){
                    comunicador.enviar("sillón");
                }else if(pos == 13){
                    comunicador.enviar("casa");
                }else if(pos == 14){
                    comunicador.enviar("sala");
                }else if(pos == 15){
                    comunicador.enviar("cocina");
                }else if(pos == 16){
                    comunicador.enviar("ventana");
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
