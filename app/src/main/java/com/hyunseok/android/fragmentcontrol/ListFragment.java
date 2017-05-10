package com.hyunseok.android.fragmentcontrol;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    MainActivity mainActivity;

    // setter 함수
    public void setActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        Button btn = (Button) view.findViewById(R.id.btn_list);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.goDetail();
            }
        });

        return view;
    }

}
