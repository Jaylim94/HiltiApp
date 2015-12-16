package tarc.jaylim.hilti;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by JAYLIM on 16/12/2015.
 */
public class menu3_Fragment extends Fragment {
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu3_layout, container, false);

        Button buttonYes = (Button) rootview.findViewById(R.id.btnYes);
        buttonYes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getActivity().finish();
                Toast.makeText(getActivity(), "Successfully Log Out.",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(v.getContext(), LoginActivity.class);
                startActivity(myIntent);
            }
        });

        Button buttonNo = (Button) rootview.findViewById(R.id.btnNo);
        buttonNo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // update the main content by replacing fragments
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, new menu1_Fragment()).commit();
            }
        });

        return rootview ;
    }
}
