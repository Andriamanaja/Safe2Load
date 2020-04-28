package com.example.safe2load.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safe2load.R;
import com.example.safe2load.RecyclerView.FragmentViewPagerAdapter;

public class CLCC_chargement_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TabLayout tabLayout ;
    private ViewPager viewPager ;
    View view ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;





    public CLCC_chargement_Fragment() {
        // Required empty public constructor
    }

    public static CLCC_chargement_Fragment newInstance(String param1, String param2) {
        CLCC_chargement_Fragment fragment = new CLCC_chargement_Fragment();
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

    public void init_doc_portail_fragment() {

       // getActivity().setContentView(R.layout.fragment_clcc_chargement_) ;

        tabLayout = this.view.findViewById(R.id.tab_layout) ;
        viewPager = this.view.findViewById(R.id.clcc_chargement_view_pager) ;

        FragmentViewPagerAdapter fragmentViewPagerAdapter = new FragmentViewPagerAdapter(getChildFragmentManager()) ;
        fragmentViewPagerAdapter.addFragment(new doc_portailFragment(), "PRÉSENTATION DES DOC AU PORTAIL");
        fragmentViewPagerAdapter.addFragment(new Control_conducteur_Fragment(), "CONTRÔLE CONDUCTEUR");
        fragmentViewPagerAdapter.addFragment(new Controle_camion_Fragment(), "CONTRÔLE CAMION");

        viewPager.setAdapter(fragmentViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_clcc_chargement_, container, false);
        init_doc_portail_fragment();

       //

        return view ;
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
}
