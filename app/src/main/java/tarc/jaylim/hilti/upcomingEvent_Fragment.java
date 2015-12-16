package tarc.jaylim.hilti;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jaylim on 16/12/2015.
 */
public class upcomingEvent_Fragment extends Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.upcoming_event_layout, container, false);
        ListView listViewEvent = (ListView) rootview.findViewById(R.id.listViewEvent);

        final eventName[] eventN = eventName.values();
        final ListAdapter listAdapter = createListAdapter(eventN);

        listViewEvent.setAdapter(listAdapter);

        listViewEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentManager fragmentManager = getFragmentManager();
                switch (position) {
                    case 0:
                        fragmentManager.beginTransaction().replace(R.id.container, new meeting_Fragment()).commit();
                        break;
                    case 1:
                        fragmentManager.beginTransaction().replace(R.id.container, new dinner_Fragment()).commit();
                        break;

                }

            }
        });

        return rootview;
    }

    public enum eventName {
        MEETING("Annual General Meeting 2016 (15/01/2016)"),
        DINNER("Annual Dinner (17/01/2016)");

        private String eventName;

        private eventName(final String name) {
            this.eventName = name;
        }

        public String getEventName() {
            return this.eventName;
        }

        public String getAbbreviation() {
            return this.name();
        }

    }

    private static final String TEXT1 = "text1";
    private static final String TEXT2 = "text2";

    private List<Map<String, String>> convertToListItems(final eventName[] eventN) {

        final List<Map<String, String>> listItem = new ArrayList<Map<String, String>>(eventN.length);

        for (final eventName event : eventN) {
            final Map<String, String> listItemEvent = new HashMap<String, String>();
            listItemEvent.put(TEXT1, event.getEventName());
            listItemEvent.put(TEXT2, event.getAbbreviation());
            listItem.add(Collections.unmodifiableMap(listItemEvent));
        }

        return Collections.unmodifiableList(listItem);
    }

    private ListAdapter createListAdapter(final eventName[] event) {
        final String[] fromMapKey = new String[]{TEXT1, TEXT2};
        final int[] toLayoutId = new int[]{android.R.id.text1, android.R.id.text2};
        final List<Map<String, String>> list = convertToListItems(event);

        return new SimpleAdapter(getActivity(), list, android.R.layout.simple_list_item_2, fromMapKey, toLayoutId);
    }


}
