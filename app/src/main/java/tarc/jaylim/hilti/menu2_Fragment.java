package tarc.jaylim.hilti;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jaylim on 16/12/2015.
 */
public class menu2_Fragment extends Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu2_layout, container, false);
        ListView listViewState = (ListView) rootview.findViewById(R.id.listViewState);

        ArrayList<String> state = new ArrayList<String>();
        state.add("Johor");
        state.add("Perak");
        state.add("Penang");
        state.add("Sabah");
        state.add("Sarawak");
        state.add("Selangor");


        ArrayAdapter<String> allItemsAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, state);
        listViewState.setAdapter(allItemsAdapter);

        listViewState.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = ((TextView) view).getText().toString();
                FragmentManager fragmentManager = getFragmentManager();
                switch (position) {
                    case 0: //johor
                        fragmentManager.beginTransaction().replace(R.id.container, new johor_Fragment()).commit();
                        break;
                    case 3: //sabah
                        fragmentManager.beginTransaction().replace(R.id.container, new sabah_Fragment()).commit();
                        break;
                    case 4: //sarawak
                        fragmentManager.beginTransaction().replace(R.id.container, new sarawak_Fragment()).commit();
                        break;
                    case 5: //selangor
                        fragmentManager.beginTransaction().replace(R.id.container, new selangor_Fragment()).commit();
                        break;
                    case 1: //perak
                        fragmentManager.beginTransaction().replace(R.id.container, new perak_Fragment()).commit();
                        break;
                    case 2: //penang
                        fragmentManager.beginTransaction().replace(R.id.container, new penang_Fragment()).commit();
                        break;
                    default:
                        Toast.makeText(getActivity(), "What Happen ?", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

        return rootview;
    }

}
