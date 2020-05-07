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

import com.example.safe2load.Detail_statFragment;
import com.example.safe2load.R;
import com.example.safe2load.RecyclerView.FragmentViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Detail_stat_op#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Detail_stat_op extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private TabLayout tabLayout ;
    private ViewPager viewPager ;
    View view ;


    private CLCC_chargement_Fragment.OnFragmentInteractionListener mListener;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Detail_stat_op() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Detail_stat_op.
     */
    // TODO: Rename and change types and number of parameters
    public static Detail_stat_op newInstance(String param1, String param2) {
        Detail_stat_op fragment = new Detail_stat_op();
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

    public void init_detail_statFragment(){

        tabLayout = this.view.findViewById(R.id.detail_stat_tab_layout);
        viewPager = this.view.findViewById(R.id.detail_stat_view_pager);

        FragmentViewPagerAdapter fragmentViewPagerAdapter = new FragmentViewPagerAdapter(getChildFragmentManager()) ;
        fragmentViewPagerAdapter.addFragment(new Detail_statFragment(), "DETAILS DE L'OPERATION");

        viewPager.setAdapter(fragmentViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_detail_stat_op, container, false);
        init_detail_statFragment();
        return view;
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
