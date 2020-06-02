package com.example.safe2load;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    CardView btn_acc_operation ;
    CardView btn_acc_stat ;
    CardView btn_acc_sync ;
    CardView btn_acc_params ;
    CardView btn_acc_dsc;

    View view;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false) ;
        this.initView();
        //content_operation = view.findViewById(R.id.content_operation) ;
        return view;
    }

    private void initView() {
        btn_acc_operation = view.findViewById(R.id.acc_operation);
        btn_acc_params = view.findViewById(R.id.acc_params);
        btn_acc_stat = view.findViewById(R.id.acc_stat);
        btn_acc_sync = view.findViewById(R.id.acc_sync);
        btn_acc_dsc = view.findViewById(R.id.acc_dsc);

        btn_acc_operation.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            try {
                fragmentManager.beginTransaction().replace(R.id.layout_content, OperationFragment.class.newInstance()).commit();
                getActivity().setTitle("Opération");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
        });

        btn_acc_params.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            try {
                fragmentManager.beginTransaction().replace(R.id.layout_content,ParamsFragment.class.newInstance()).commit();
                getActivity().setTitle("Paramètres");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
        });

        btn_acc_sync.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            try {
                fragmentManager.beginTransaction().replace(R.id.layout_content, SynchroFragment.class.newInstance()).commit();
                getActivity().setTitle("Synchronisation");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
        });

        btn_acc_stat.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            try {
                fragmentManager.beginTransaction().replace(R.id.layout_content, StatFragment.class.newInstance()).commit();
                getActivity().setTitle("Statistique des opérations");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
        });

        btn_acc_dsc.setOnClickListener(v -> {


        });
    }

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
}
