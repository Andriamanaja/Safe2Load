package com.example.safe2load.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.safe2load.R;
import com.example.safe2load.RecyclerView.Doc_Portail_ViewAdapter;

import java.util.ArrayList;
import java.util.List;

import model.object.controle_model;

public class doc_portailFragment extends Fragment implements ActivityCompat.OnRequestPermissionsResultCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView _recyclerView ;
    List<controle_model> _list_controle_model ;
    private OnFragmentInteractionListener mListener;

    public doc_portailFragment() {
        // Required empty public constructor
    }

    public static doc_portailFragment newInstance(String param1, String param2) {
        doc_portailFragment fragment = new doc_portailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _list_controle_model = new ArrayList() ;
        _list_controle_model.add(new controle_model(1 , "Le camion dispose de tous les certificats d\\'aptitude sur les contrôles de confirmité APAVA/MADAUTO en cours de validité (Code de la route, test de freinage, visite intérieur compartiement, test d\\étanchéité)", true)) ;
        _list_controle_model.add(new controle_model(2 , "Le transporteur dispose t-il le protocole de sécurité valide et signé par un responsable habilité de LPSA", true)) ;
        _list_controle_model.add(new controle_model(3, "Le conducteur est muni d\\'un certificat d\\'habilitation à conduire de PATH / LPSA (PASSEPORT DE CONDUITE)", true)) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_doc_portail, container, false) ;
        _recyclerView = v.findViewById(R.id._doc_portail_recycler_viex) ;
        Doc_Portail_ViewAdapter doc_portail_viewAdapter = new Doc_Portail_ViewAdapter(this.getContext(), _list_controle_model) ;
        _recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        _recyclerView.setAdapter(doc_portail_viewAdapter);
        return v ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onRequestPermissionsResult(int i, @NonNull String[] strings, @NonNull int[] ints) {
       /* switch (i) {
            case 1001 : {
                if(ints.length > 0&&ints[0]== PackageManager.PERMISSION_GRANTED) {
                   // open_camera();
                }
                else{
                    Toast.makeText(context, "Permission réfusée", Toast.LENGTH_LONG).show();
                }
            }
        }*/
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Bitmap bitmap = (Bitmap) data.getExtras().get(MediaStore.EXTRA_OUTPUT) ;
       /* try {
            Bundle bundle = new Bundle(data.getExtras()) ;
            Log.d("extra", String.valueOf(bundle.get)) ;
        }catch (Exception e) {
            e.printStackTrace();
        }*/
        Log.d("doc_portailFragment" , String.valueOf(data.getExtras().get("data")) ) ;
    }

}
