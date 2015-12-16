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

import org.w3c.dom.Text;

/**
 * Created by Jaylim on 17/12/2015.
 */
public class meeting_Fragment extends Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.event_fragment_layout, container, false);

        TextView textViewTitle = (TextView) rootview.findViewById(R.id.textViewEventTitle);
        TextView textViewDate = (TextView) rootview.findViewById(R.id.textViewDate);
        TextView textViewDetails = (TextView) rootview.findViewById(R.id.textViewDetails);

        textViewTitle.setText("Annual General Meeting 2016");
        textViewDate.setText("15-01-2016");
        textViewDetails.setText("I am pleased to invite you to this year’s Annual General Meeting. The AGM will be held at 11.00am on Wednesday, 15 January 2016 at HILTI Centre," +
                "Petaling Jaya, Selangor. Full details of the meeting and the Resolutions that will be put to shareholders are set out in the enclosed Notice" +
                "of Annual General Meeting.\n" +
                "If you intend to come to the AGM, please sign your admission card and bring it with you to the meeting to help speed up the registration process. This card also" +
                "has directions on how to get to the meeting. Refreshments will be available from 9.30am and there will be a number of exhibition stands which may be of" +
                "interest to you. I do recommend that you arrive by 10.15am to enable us to carry out all of the registration formalities to ensure a prompt start at 11.00am.\n" +
                "If you cannot come to the AGM in person, your vote is still important and I would urge you to complete, sign and return the enclosed proxy card to be received" +
                "by 11.00am on Monday, 6 July 2015. You may also register your proxy vote electronically by accessing our Registrar’s website www.hilti.com.my/eproxy\n");


        Button buttonNav = (Button) rootview.findViewById(R.id.buttonNav);
        buttonNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double latitude, longtitude;

                latitude = 3.068557;
                longtitude = 101.600805;
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
                fragmentManager.beginTransaction().replace(R.id.container, new upcomingEvent_Fragment()).commit();
            }
        });

        return rootview;
    }
}

