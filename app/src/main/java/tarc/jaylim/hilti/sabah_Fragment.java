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
public class sabah_Fragment extends Fragment {
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

        textViewLocation.setText("Kota Kinabalu");
        textViewState.setText("Sabah");
        textViewAddress.setText("Lot 23, Grd Flr (DBKK shop no: 28-0),\n" +
                "Block D, Iramanis Center,\n" +
                "Ruang Iramanis, Jalan Lintas,\n" +
                "88450, Kota Kinabalu,\n" +
                "Sabah");
        mImageView.setImageResource(R.drawable.sabah);
        textViewOperating.setText("Monday - Friday: 8:00 a.m. - 5:00 p.m.\n" +
                "Saturday / Sunday / Public Holiday closed.");
        textViewTelephone.setText("088-380521");

        Button buttonNo = (Button) rootview.findViewById(R.id.buttonNavigate);
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double latitude, longtitude;

                latitude = 5.969486;
                longtitude = 116.109672;
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
