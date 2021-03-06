package com.example.lidiia.tabbed;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class UnCheckedFragment1 extends Fragment {

    private OnFragmentInteractionListenerU mListener;
    RecyclerView recyclerView;
    CheckBox checkBox;
    List<String> list;
    MyAdapter myAdapter;

    public UnCheckedFragment1() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        checkBox = (CheckBox) view.findViewById(R.id.checkbox_id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter = new MyAdapter(myList());
        myAdapter.setOnListClickListener(new MyAdapter.OnListClickListener() {
            @Override
            public void onListClick(int id) {
                mListener.onFragmentInteractionU(id);
            }
        });
        recyclerView.setAdapter(myAdapter);
    }

    private List<String> myList() {
        list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add("Lego " + i);
        }
        return list;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListenerU) {
            mListener = (OnFragmentInteractionListenerU) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
    public interface OnFragmentInteractionListenerU {
        void onFragmentInteractionU(int id);
    }

    public void removeItem(int idU) {
//        checkBox.setChecked(true);
        list.remove(idU);
        myAdapter.notifyDataSetChanged();
    }


}
