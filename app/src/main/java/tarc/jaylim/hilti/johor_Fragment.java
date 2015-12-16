package tarc.jaylim.hilti;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jaylim on 16/12/2015.
 */
public class johor_Fragment extends Fragment {
    View rootview;
    private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.state_layout, container, false);

        TextView textViewLocation = (TextView)rootview.findViewById(R.id.textViewLocation);
        TextView textViewState = (TextView)rootview.findViewById(R.id.textViewState);
        TextView textViewAddress = (TextView)rootview.findViewById(R.id.textViewAddress);
        mImageView = (ImageView)rootview.findViewById(R.id.imageViewMap);
        TextView textViewOperating = (TextView)rootview.findViewById(R.id.textViewOperateHour);
        TextView textViewTelephone = (TextView)rootview.findViewById(R.id.textViewTelephone);

        textViewLocation.setText("Johor Bahru");
        textViewState.setText("Johor");
        textViewAddress.setText("27, Jalan Molek 2/1\n" +
                "Taman Molek\n" +
                "81100, Johor Bahru\n" +
                "Johor");
        mImageView.setImageResource(R.drawable.johor);
        textViewOperating.setText("Monday - Friday: 8:00 a.m. - 5:00 p.m.\n" +
                "Saturday / Sunday / Public Holiday closed.");
        textViewTelephone.setText("07-3551759");

        Button buttonNo = (Button) rootview.findViewById(R.id.buttonNavigate);
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double latitude, longtitude;

                latitude = 1.528549;
                longtitude = 103.793281;
                String uriString = "geo:" + latitude + "," + longtitude +
                        "?q=" + latitude + "," + longtitude; //Adding a mark
                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button buttonBack = (Button) rootview.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, new menu2_Fragment()).commit();
            }
        });

        return rootview;
    }
}
