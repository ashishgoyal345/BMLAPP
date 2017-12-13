package bmu.in.bmuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PrimaryFragment extends Fragment {

    public PrimaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.faculty_primary, container, false);

        TextView t =(TextView) contentView.findViewById(R.id.ashish);
        t.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ashish.class);
                startActivity(i);
            }
        });

        TextView t1 =(TextView) contentView.findViewById(R.id.nishant);
        t1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), nishant.class);
                startActivity(i);
            }
        });


        return contentView;
    }
}