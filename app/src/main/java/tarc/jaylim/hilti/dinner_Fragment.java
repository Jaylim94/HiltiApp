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
import android.widget.TextView;

/**
 * Created by Jaylim on 17/12/2015.
 */
public class dinner_Fragment extends Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.event_fragment_layout, container, false);

        TextView textViewTitle = (TextView) rootview.findViewById(R.id.textViewEventTitle);
        TextView textViewDate = (TextView) rootview.findViewById(R.id.textViewDate);
        TextView textViewDetails = (TextView) rootview.findViewById(R.id.textViewDetails);

        textViewTitle.setText("Annual Dinner ");
        textViewDate.setText("17-01-2016");
        textViewDetails.setText("This is a invitation to all employees of Hilti Corporation for the annual employee holiday party. It will be held at Grand Imperial Royale Ballroom from 7:00 to 10:00pm on Sunday, January, 2016.\n" +
                "\n" +
                "The party will be attended by the top management and board of directors of the company. They would be addressing the party in order to express their sincere appreciation for your hard-work and generous input into the overall success and development of the organization. \n" +
                "\n" +
                "As it an organizational event, you are requested to dress formally and make sure not to bring in family members.\n" +
                "\n" +
                "Please make sure to inform Mr. John Mathew till Friday, January 15, 2016 in case if you are unable to attend the party. You can email him at Mathew.john22@hilti.com or call at 012-22829292.\n" +
                "\n" +
                "We hope you would be able to join us on this great yearly occasion and looking forward to meet you in the venue.");


        Button buttonNav = (Button) rootview.findViewById(R.id.buttonNav);
        buttonNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double latitude, longtitude;

                latitude = 3.070341;
                longtitude = 101.609567;
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
                fragmentManager.beginTransaction().replace(R.id.container, new upcomingEvent_Fragment()).commit();
            }
        });

        return rootview;
    }
}

