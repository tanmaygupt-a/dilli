package com.delhiexmp.dilli;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;

public class AmusementFragment extends Fragment {
    ArrayList<Place> amusementPlace = new ArrayList<Place>();


    public AmusementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);


        setupPlaces();
        Collections.shuffle(amusementPlace);

        // Setting up List View
        ListView listView = (ListView) rootView.findViewById(R.id.rootView);

        // Creating adapter
        CardAdapter adapter = new CardAdapter(getActivity(), amusementPlace);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Place place = amusementPlace.get(position);
                Intent intent = new Intent(getContext(), CardDetails.class);
                intent.putExtra("imageId", place.getPhotoResourceId());
                intent.putExtra("locationURL", place.getLocationURL());
                intent.putExtra("description",place.getDescription());

                // Adding animations
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                        Pair.create(view.findViewById(R.id.list_constraint),"cardViewMain"),
                        Pair.create(view.findViewById(R.id.cardViewImageMain),"cardViewImage"),
                        Pair.create(view.findViewById(R.id.timings_textView),"textView")
                );
                startActivity(intent, options.toBundle());
            }
        });

        return rootView;
    }

    private void setupPlaces() {
        amusementPlace.add(new Place("Kingdom Of Dreams", "12:30 pm to 12:00 am on weekdays and 12:00 pm to 12:00 am on weekends", "IFFCO Chowk, Gurugram", R.drawable.kingdomofdreams, "https://www.google.com/maps/place/Kingdom+of+Dreams/@28.4678664,77.0666979,17z/data=!3m1!4b1!4m5!3m4!1s0x390d18e3233df2b5:0xc1f823d5f7e59d32!8m2!3d28.4678664!4d77.0688866",
                "Situated near the Leisure Valley Park in Gurugram, Kingdom of Dreams is an ultimate entertainment destination. It is designed with the intent of displaying the rich Indian culture by means of a majestic structure. Besides its splendid architecture, the place features Nautanki Mahal, an auditorium which showcases fanciful cinematic musicals and hosts a number of live entertainment shows, including Indian and international theatre. Additionally, the place houses Culture gully, where you can witness a boulevard dedicated to unique Indian culture, arts and crafts, and authentic cuisines."));

        amusementPlace.add(new Place("Snow World", "11:00 am to 10:00 pm", "Sector-18, Noida", R.drawable.snowworld, "https://www.google.com/maps/place/Snow+World/@28.5674285,77.3189463,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce44627372cfb:0xeb3abf021c483c31!8m2!3d28.5674285!4d77.321135",
                "Located inside DLF Mall of India, Noida, Snow World is Asia’s largest indoor snow park featuring ice skating & sledding. With an area of 6,000 square meters, it is a themed real snow-filled wonderland. Offering mesmerizing interiors and unmatchable scope of activities, the park maintains a minus 10 degrees of chilly weather. Moreover, this family entertainment spot has Ski-Slides, Icy Luge (ride) and multi coaster (Toboggan)."));

        amusementPlace.add(new Place("Worlds Of Wonder", "10:30 am to 7:00 pm", "Sector-18, Noida", R.drawable.wow, "https://www.google.com/maps/place/Worlds+of+Wonder/@28.5630938,77.3231191,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce437992ea39f:0xa26bb41d89eacf5b!8m2!3d28.5630938!4d77.3253078",
                "A world-class amusement park, Worlds of Wonder ensures a fun-filled quality-time with your friends and family amidst a variety of attractions. Popularly known as WOW, it maintains over 20 rides, including Mega Disco, Download, Chart Smashers, Feedback, Fast Forward, Big Beat and Rockin Roller. Its La Fiesta zone, which is meant for your little ones exclusively, features rides like Hippti Hopp, Loco Motion, Space Shot and Samba Rhumba. Spread over 10 acres of land, the theme park is additionally popular for water rides and go-karting, and also features a pool bar, snack bar and Punjabi dhaba."));

        amusementPlace.add(new Place("Appu Ghar", "11:00 am to 7:00 pm", "Huda City Centre, Gurgaon", R.drawable.appughar, "https://www.google.com/maps/place/Appu+Ghar+Water+Park+Gurgaon,+Sector+30+M+Wide+Main+Rd,+Sector+29,+Gurugram,+Haryana+122001/@28.4603245,77.0638775,15z/data=!3m1!4b1!4m5!3m4!1s0x390d18ef5f52da51:0x3aa4d76d1eb8693d!8m2!3d28.4603252!4d77.0726323",
                "A rainforest-themed water park, Appu Ghar Water Park is bringing back the old charm with its newly launched Oyesters Water Park. Spread over an area of 10 acres, it offers 16 innovative rides like Sky Fall, Whirl Wind, and Rapid Racers, including India’s tallest 93 feet slide and first free fall ride. Additionally, the park maintains banquet facilities for up to 3,500 guests, and has an amazing food court offering refreshing mocktails and mesmerizing dining options"));

        amusementPlace.add(new Place("Damdama Lake", "9:30 am to 6:00 pm", "60 Km away from I.T.O. Delhi", R.drawable.damdamalake, "https://www.google.com/maps/place/Damdama+Lake/@28.3042684,77.1272783,17z/data=!3m1!4b1!4m5!3m4!1s0x390d26f26e06824f:0xcc95c6e7df4e6222!8m2!3d28.3040418!4d77.1282023",
                "Situated at almost 60 Km away from I.T.O. Delhi, Damdama Lake offers a splendid view of Aravalli ranges and is perfect for day picnics. Popular for its serenity, t is amongst the largest natural lakes in Haryana, and offers activities like para-sailing, hot air ballooning, rock climbing, camping and trekking. Besides, there are various resorts in the vicinity which are ideal for a family getaway or corporate meetings."));

        amusementPlace.add(new Place("National Rail Museum", "10:00 am to 5:00 pm", "Dhaula Kuan, New Delhi", R.drawable.railmuseum, "https://www.google.com/maps/place/National+Rail+Museum/@28.5857968,77.1775643,17z/data=!3m1!4b1!4m5!3m4!1s0x390d1d7021a0de89:0xdb46d0593f9caa02!8m2!3d28.5857134!4d77.1799853",
                "First of its kind in India, Delhi’s National Rail Museum houses the largest collection of life-size railway exhibits including locomotives, coaches and simulators collected from different princely states of the country. The indoor galleries within this 11-acre museum also preserve documents, drawings, books, maps and other items that take you on a journey through over 160 years of Indian Railway. Toy Train 1:8, 3D Virtual Coach Ride, Joy Train and PSMT Ride are the major attractions at this museum."));

        amusementPlace.add(new Place("Delhi Zoo", "9:00 AM to 4:30 PM | Friday closes", "Pragati Maidan Metro Station", R.drawable.delhizoo, "https://www.google.com/maps/place/National+Zoological+Park/@28.6067403,77.2432148,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce318a027dbb9:0xf12a1c6b59580448!8m2!3d28.6067403!4d77.2454035",
                "The Delhi Zoo is also called the National Zoological Park and has more than 130 species of animals, birds, and reptiles from around the world here. The Majestic White Bengal Tiger is a major attraction. The zoo is a favourite hanging spot for tourists and locals alike."));

        amusementPlace.add(new Place("Jantar Mantar", "9:00 AM to 7:00 PM", "Rajiv Chowk Metro Station", R.drawable.jantarmantar, "https://www.google.com/maps/place/Jantar+Mantar/@28.6270547,77.214438,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd4a694fc49b:0xa24a6ec962781b0c!8m2!3d28.6270547!4d77.2166267",
                "Jantar Mantar is one of the most popular places to visit in Delhi. This UNESCO World Heritage Site houses the equinoctial sundial that can measure the time of the day based on the sun’s movements. There are a total of 13 astronomy architectural instruments here and you can spend a couple of hours enjoying their precision and build."));

        amusementPlace.add(new Place("Waste to Wonder Park", "11:00 AM to 11:00 PM (Closed on Mondays)", "Nizammudin Metro station", R.drawable.wastetowonder, "https://www.google.com/maps/place/Waste+To+Wonders+Park+SDMC/@28.5926716,77.2546675,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce31796bf1f47:0xd97b2c7a3ecf3812!8m2!3d28.5926716!4d77.2568562",
                "The Waste to Wonder Park is one of the recent attractions in Delhi. Spread in over 7 acres of land, this theme park has recreated the 7 wonders of the world using waste materials, including domestic and industrial wastes. The park entirely runs on renewable energy sources and is a great place to explore."));

        amusementPlace.add(new Place("Lodhi Gardens", "6:00 AM to 7:30 PM on all days", "Jor Bagh Metro Station", R.drawable.lodhigardens, "https://www.google.com/maps/place/Lodhi+Garden/@28.5930959,77.2174907,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce2ececc92e35:0x86c0764b1c0d4bea!8m2!3d28.5930959!4d77.2196794",
                "Lodhi Gardens is a park in the city that is spread over 90 acres and is surrounded by a beautifully maintained landscape. It contains the tombs of Sikander Lodi, Mohammed Shah, Bara Gumbad, and Shisha Gumbad. The 15th-century architectural work is exquisite here. You can spend a couple of hours in the morning here exploring the grounds."));

        amusementPlace.add(new Place("Garden of Five Senses", "09:00 am to 07:00 pm", "Near Saket Metro Station", R.drawable.gardenfivesenses, "https://www.google.com/maps/place/The+Garden+of+Five+Senses/@28.513403,77.195334,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce1e3ea219915:0x14fc57988731271c!8m2!3d28.513403!4d77.1975227",
                "The Garden of Five Senses was developed by the Delhi Tourism Transportation Development Corporation and is a beautiful leisure spot that locals and tourists love. The garden is located at the Said-Ul-Azaib village and is spectacular. Fountains, sky-high rocks, flowered pathways, water cascades, a Mughal garden, and stone and steel structures fill up the 20.5-acre area and are a delight for the eyes."));

        amusementPlace.add(new Place("National Museum", "10 am daily. Closed on Monday", "Janpath Metro Station", R.drawable.nationalmuseum, "https://www.google.com/maps/place/National+Museum/@28.6119078,77.2171022,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd52c71ff0eb:0x20429f292fa5eecf!8m2!3d28.6119078!4d77.2192909",
                "Places to visit in Delhi are many. But amongst them, a visit to the National Museum of India will be a lifetime experience for you. This largest repository in India contains many prominent artworks dated over 5000 years ago and it is one of the best places in east Delhi."));

    }
}