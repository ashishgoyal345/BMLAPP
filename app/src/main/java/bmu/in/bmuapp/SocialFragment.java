package bmu.in.bmuapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;

/**
 * Created by Goyal on 5/3/2017.
 */
public class SocialFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.faculty_secondary, container, false);




        ShimmerFrameLayout contaier =
                (ShimmerFrameLayout) contentView.findViewById(R.id.shimmer_view_container);
        contaier.startShimmerAnimation();



    return contentView;
    }

}

