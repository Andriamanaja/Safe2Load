package com.example.safe2load.Fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.JsonWriter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safe2load.R;
import com.example.safe2load.ViewPagerAdapter.ViewPagerAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import model.object.controle_model;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CategorieFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CategorieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategorieFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    int selectedTabPosition;

    private OnFragmentInteractionListener mListener;

    ViewPager viewPager ;
    TabLayout tabLayout ;
    ViewPagerAdapter viewPagerAdapter ;
    View view ;

    public CategorieFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategorieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategorieFragment newInstance(String param1, String param2) {
        CategorieFragment fragment = new CategorieFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_categorie, container, false);
        this.getIDs();
        this.setEvents();
        return view ;
    }

    public void getIDs() {
        this.tabLayout = view.findViewById(R.id.tab_layout) ;
        this.viewPager = view.findViewById(R.id.view_pager) ;
        viewPagerAdapter = new ViewPagerAdapter(getFragmentManager(), getContext(), viewPager, tabLayout) ;
        viewPager.setAdapter(viewPagerAdapter);
    }

    public void setEvents () {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void add_categorie(String nom_categorie, String _list_controle_model) {

        Log.d("categorie => ", _list_controle_model) ;

        Bundle bundle = new Bundle() ;
        bundle.putString("_list_inspection", _list_controle_model) ;

        InspectionFragment inspectionFragment = new InspectionFragment() ;
        inspectionFragment.setArguments(bundle);

        viewPagerAdapter.addFrag(inspectionFragment, nom_categorie);
        viewPagerAdapter.notifyDataSetChanged();
        if(viewPagerAdapter.getCount() > 0) {
            tabLayout.setupWithViewPager(viewPager);
        }
        viewPager.setCurrentItem(0);
        selectedTabPosition = viewPager.getCurrentItem() ;
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setCustomView(viewPagerAdapter.getTabView(i));
        }
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
