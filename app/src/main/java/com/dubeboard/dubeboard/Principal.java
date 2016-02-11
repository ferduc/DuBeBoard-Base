package com.dubeboard.dubeboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Principal extends AppCompatActivity implements
        //LISTENER A IMAGENES
        Fragmentuno.OnFragmentInteractionListener, Fragmentdos.OnFragmentInteractionListener, Fragment_cosas.OnFragmentInteractionListener,
        Fragment_Verbos.OnFragmentInteractionListener, Fragment_cocina.OnFragmentInteractionListener, Fragment_comida.OnFragmentInteractionListener,
        Fragment_postres.OnFragmentInteractionListener, Fragment_parCuerpo.OnFragmentInteractionListener, Fragment_hogar.OnFragmentInteractionListener,
        fragment_transporte.OnFragmentInteractionListener, Fragment_prendas.OnFragmentInteractionListener, Fragment_escuela.OnFragmentInteractionListener,
        Fragment_lugares.OnFragmentInteractionListener, Fragment_animales.OnFragmentInteractionListener,
        //LLAMADA A COMUNICADOR
        Fragmentuno.Comunicador, Fragmentdos.Comunicador, Fragment_cocina.Comunicador, Fragment_comida.Comunicador, Fragment_cosas.Comunicador,
        Fragment_escuela.Comunicador, Fragment_hogar.Comunicador, Fragment_lugares.Comunicador, Fragment_parCuerpo.Comunicador, Fragment_postres.Comunicador,
        Fragment_prendas.Comunicador, fragment_transporte.Comunicador, Fragment_Verbos.Comunicador, Fragmentuno.Comunicador2, Fragment_animales.Comunicador{
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private MediaPlayer mp;
    String nuevorecibirtexto;
    private MediaPlayer nuevomp = null;
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    AdaptadorDeImagenes adapter;

    private ListView lista;
    TextView recibirtexto;
    Button boton_borrar;
    Button boton_reproducir;

    String[] titulo = new String[]{
            "PRONOMBRES",
            "FAMILIA",
            "COSAS",
            "VERBOS",
            "COCINA",
            "COMIDA",
            "POSTRES",
            "PARTES DEL CUERPO",
            "HOGAR",
            "TRANSPORTE",
            "PRENDAS DE VESTIR",
            "ESCUELA",
            "LUGARES",
            "ANIMALES"
    };

    int[] imagenes = {
            R.drawable.pronombres,
            R.drawable.family,
            R.drawable.cosas,
            R.drawable.verbos,
            R.drawable.cocina,
            R.drawable.comida,
            R.drawable.postretorta,
            R.drawable.cuerpo,
            R.drawable.casahogar,
            R.drawable.transporte,
            R.drawable.ropa,
            R.drawable.escuelaprincipal,
            R.drawable.lugar,
            R.drawable.animales

    };

    @Override
    public void mediaplay(MediaPlayer mp) {
        nuevomp = mp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Paso3:Crear un nuevo fragmento y añadirlo
        final Fragmentuno fragment = new Fragmentuno();
        final Fragmentdos fragment1 = new Fragmentdos();
        final Fragment_cosas fragment_cosas = new Fragment_cosas();
        final Fragment_Verbos fragment_verbos = new Fragment_Verbos();
        final Fragment_cocina fragment_cocina = new Fragment_cocina();
        final Fragment_comida fragment_comida = new Fragment_comida();
        final Fragment_postres fragment_postres = new Fragment_postres();
        final Fragment_parCuerpo fragment_parCuerpo = new Fragment_parCuerpo();
        final Fragment_hogar fragment_hogar = new Fragment_hogar();
        final fragment_transporte fragment_transporte = new fragment_transporte();
        final Fragment_prendas fragment_prendas = new Fragment_prendas();
        final Fragment_escuela fragment_escuela = new Fragment_escuela();
        final Fragment_lugares fragment_lugares = new Fragment_lugares();
        final Fragment_animales fragment_animales = new Fragment_animales();

        //TextView
        recibirtexto = (TextView) findViewById(R.id.txtrecibirtexto);

        //LISTVIEW
        lista = (ListView) findViewById(R.id.Lista);
        adapter = new AdaptadorDeImagenes(this,titulo,imagenes);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Paso1: Obtener la instancia del administrador de fragmentos
                FragmentManager FM = getSupportFragmentManager();
                //Paso2: Crear una nueva transaccion
                FragmentTransaction FT = FM.beginTransaction();

                if (position == 0) {
                    FT.replace(R.id.framefragmentos, fragment);
                } else if (position == 1) {
                    FT.replace(R.id.framefragmentos, fragment1);
                } else if (position == 2) {
                    FT.replace(R.id.framefragmentos, fragment_cosas);
                } else if (position == 3) {
                    FT.replace(R.id.framefragmentos, fragment_verbos);
                } else if (position == 4) {
                    FT.replace(R.id.framefragmentos, fragment_cocina);
                } else if (position == 5) {
                    FT.replace(R.id.framefragmentos, fragment_comida);
                } else if (position == 6) {
                    FT.replace(R.id.framefragmentos, fragment_postres);
                } else if (position == 7) {
                    FT.replace(R.id.framefragmentos, fragment_parCuerpo);
                } else if (position == 8) {
                    FT.replace(R.id.framefragmentos, fragment_hogar);
                } else if (position == 9) {
                    FT.replace(R.id.framefragmentos, fragment_transporte);
                } else if (position == 10) {
                    FT.replace(R.id.framefragmentos, fragment_prendas);
                } else if (position == 11) {
                    FT.replace(R.id.framefragmentos, fragment_escuela);
                } else if (position == 12) {
                    FT.replace(R.id.framefragmentos, fragment_lugares);
                } else if (position == 13){
                    FT.replace(R.id.framefragmentos, fragment_animales);
                }
                //Paso4: Confirmar el cambio
                //FT.addToBackStack(null);
                FT.commit();
            }
        });

        boton_borrar=(Button)findViewById(R.id.btn_borrar);
        boton_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recibirtexto.setText(" ");
                nuevomp = null;
            }
        });

        boton_reproducir=(Button) findViewById(R.id.btn_reproducir);
        boton_reproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevomp.start();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.opciongrabar) {
            //Envia a la ventanagrabar
            Intent i= new Intent(getApplicationContext(),Grabar.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Principal Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.dubeboard.dubeboard/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Principal Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.dubeboard.dubeboard/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


    @Override
    public void enviar(String envia) {

        String e = envia;
        nuevorecibirtexto = recibirtexto.getText().toString();
        recibirtexto.setText(nuevorecibirtexto + " " + e);
    }


}
