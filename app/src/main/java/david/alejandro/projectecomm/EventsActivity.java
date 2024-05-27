package david.alejandro.projectecomm;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    private ArrayList<Event> listEvents = new ArrayList<>();
    private RecyclerView rvEventsMain;

    private Toolbar toolbar;


    protected void onCreate(Bundle savedInstanceState, ArrayList<Event> listEvent) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_events);

        toolbar = findViewById(R.id.top_app_bar_events);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        loadFakeData();

        rvEventsMain = findViewById(R.id.rv_events);
        EventAdapter myAdapter = new EventAdapter(listEvents);
        rvEventsMain.setAdapter(myAdapter);
        StaggeredGridLayoutManager myStaged = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvEventsMain.setLayoutManager(myStaged);

    }

    private void loadFakeData() {
        Event event1 = new Event("https://img.freepik.com/vector-gratis/diseno-plantilla-banner-rectangulo-festival-anime-otaku_742173-4924.jpg?size=626&ext=jpg&ga=GA1.1.1319243779.1711411200&semt=ais");
        Event event2 = new Event("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/anime-event-flyer-design-facebook-template-0def29cd5467ccbd8fe67424599bfd7e_screen.jpg?ts=1660392266");
        Event event3 = new Event("https://img.freepik.com/vector-gratis/banner-anime-fuera-linea-twitch_79603-2016.jpg?size=626&ext=jpg&ga=GA1.1.1319243779.1711411200&semt=ais");
        listEvents.add(event1);
        listEvents.add(event2);
        listEvents.add(event3);
        listEvents.add(event1);
        listEvents.add(event2);
        listEvents.add(event3);
        listEvents.add(event1);
        listEvents.add(event2);
        listEvents.add(event3);
        listEvents.add(event1);
        listEvents.add(event2);
        listEvents.add(event3);
        listEvents.add(event1);
        listEvents.add(event2);
        listEvents.add(event3);
        listEvents.add(event1);
        listEvents.add(event2);
        listEvents.add(event3);
        listEvents.add(event1);
        listEvents.add(event2);
        listEvents.add(event3);
        listEvents.add(event1);
        listEvents.add(event2);
        listEvents.add(event3);
    }
}