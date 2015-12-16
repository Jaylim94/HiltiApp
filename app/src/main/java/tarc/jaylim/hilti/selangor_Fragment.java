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
public class selangor_Fragment extends Fragment {
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

        textViewLocation.setText("Petaling Jaya");
        textViewState.setText("Selangor");
        textViewAddress.setText("9 & 11, Jalan PJS 11/20\n" +
                "Bandar Sunway\n" +
                "46150, Petaling Jaya\n" +
                "Selangor");
        mImageView.setImageResource(R.drawable.selangor);
        textViewOperating.setText("Monday - Friday: 8:00 a.m. - 5:00 p.m.\n" +
                "Saturday / Sunday / Public Holiday closed.");
        textViewTelephone.setText("1800-88-0985");

        Button buttonNo = (Button) rootview.findViewById(R.id.buttonNavigate);
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double latitude, longtitude;

                latitude = 3.068557;
                longtitude = 101.600805;
                String uriString = "geo:" + latitude + "," + longtitude +
                        "?q=" + latitude + "," + longtitude; //Adding a mark
                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
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
