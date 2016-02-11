package com.dubeboard.dubeboard;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Verbos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_Verbos extends Fragment {

    private OnFragmentInteractionListener mListener;
    //AdaptadorDeImagenes adapter;
    Activity activity;
    Comunicador comunicador;
    String[] verbos = new String[]{
            "estar","ser","ver","oir", "despertar",
            "jugar","meter","romper","pintar",
            "tener","sentir","tocar","buscar","olvidar",
            "cortar","amar","coger","ir",
            "venir","cerrar","caer","traer","llevar",
            "ayudar","dar","recibir","querer","dormir",
            "comer","beber","hablar","estudiar",
            "pensar","nadar","sentar","parar",
            "correr","caminar","poner","necesitar"
    };
/*
    String[] titulo = new String[]{

    };

    int[] imagenes = {

    };
*/

    public Fragment_Verbos() {
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
        View view = inflater.inflate(R.layout.fragment_fragment__verbos, container, false);
        ArrayAdapter<String> adapter;
        final GridView listgridverbos = (GridView)view.findViewById(R.id.listagridverbos);
        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,verbos);
        listgridverbos.setAdapter(adapter);
        listgridverbos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    comunicador.enviar("estar");
                }else if(pos == 1){
                    comunicador.enviar("ser");
                }else if(pos == 2){
                    comunicador.enviar("ver");
                }else if(pos == 3){
                    comunicador.enviar("oir");
                }else if(pos == 4){
                    comunicador.enviar("despertar");
                }else if(pos == 5){
                    comunicador.enviar("jugar");
                }else if(pos == 6){
                    comunicador.enviar("meter");
                }else if(pos == 7){
                    comunicador.enviar("romper");
                }else if(pos == 8){
                    comunicador.enviar("pintar");
                }else if(pos == 9){
                    comunicador.enviar("tener");
                }else if(pos == 10){
                    comunicador.enviar("sentir");
                }else if(pos == 11){
                    comunicador.enviar("tocar");
                }else if(pos == 12){
                    comunicador.enviar("buscar");
                }else if(pos == 13) {
                    comunicador.enviar("olvidar");
                }else if(pos == 14){
                    comunicador.enviar("cortar ");
                }else if(pos == 15){
                    comunicador.enviar("amar");
                }else if(pos == 16){
                    comunicador.enviar("coger");
                }else if(pos == 17){
                    comunicador.enviar("ir");
                }else if(pos == 18){
                    comunicador.enviar("venir");
                }else if(pos == 19){
                    comunicador.enviar("cerrar");
                }else if(pos == 20){
                    comunicador.enviar("caer");
                }else if(pos == 21) {
                    comunicador.enviar("traer");
                }else if(pos == 22){
                    comunicador.enviar("llevar");
                }else if(pos == 23){
                    comunicador.enviar("ayudar");
                }else if(pos == 24){
                    comunicador.enviar("dar");
                }else if(pos == 25){
                    comunicador.enviar("recibir");
                }else if(pos == 26){
                    comunicador.enviar("querer");
                }else if(pos == 27) {
                    comunicador.enviar("dormir");
                }else if(pos == 28){
                    comunicador.enviar("comer");
                }else if(pos == 29){
                    comunicador.enviar("beber");
                }else if(pos == 30){
                    comunicador.enviar("hablar");
                }else if(pos == 31) {
                    comunicador.enviar("estudiar");
                }else if(pos == 32){
                    comunicador.enviar("pensar");
                }else if(pos == 33){
                    comunicador.enviar("nadar");
                }else if(pos == 34){
                    comunicador.enviar("sentar");
                }else if(pos == 35){
                    comunicador.enviar("parar");
                }else if(pos == 36){
                    comunicador.enviar("correr");
                }else if(pos == 37){
                    comunicador.enviar("caminar");
                }else if(pos == 38){
                    comunicador.enviar("poner");
                }else if(pos == 39){
                    comunicador.enviar("necesitar");
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
