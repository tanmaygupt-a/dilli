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

public class FoodFragment extends Fragment {
    ArrayList<Place> foodPlaces = new ArrayList<Place>();

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        setupPlaces();


        Collections.shuffle(foodPlaces);
        // Setting up List View
        ListView listView = (ListView) rootView.findViewById(R.id.rootView);

        // Creating adapter
        CardAdapter adapter = new CardAdapter(getActivity(), foodPlaces);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Place place = foodPlaces.get(position);
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
        foodPlaces.add(new Place("Paranthe Wali Gali", "9 AM to 11 PM", "Chandni Chowk Metro Station", R.drawable.paranthewaligali, "https://www.google.com/maps/place/Paranthe+Wali+Gali,+Katra+Lehswan,+Chandni+Chowk,+Delhi,+110006/@28.6560677,77.2283697,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd1a5fc13f73:0xba3a88724a5b3658!8m2!3d28.6560677!4d77.2305584",
                "A tapered street in Chandni Chowk area, Paranthe Wali Gali is noted because of its sequential shops located one after the other known for selling paratha, a typical Indian unleavened thin bread. The food sold in Paranthe Wali Gali is strictly vegetarian, presented in old retrospective style without any addition of onion or garlic to the food. "));

        foodPlaces.add(new Place("Rose Cafe", "12 Noon to 9 PM", "Saket Metro Station", R.drawable.rosecafe, "https://www.google.com/maps/place/Rose+Cafe/@28.517792,77.1960994,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce1e407a7bc3f:0xe4daa7dba1c7f579!8m2!3d28.5178173!4d77.1982499?authuser=0&hl=en",
                "An all-day exquisite restaurant, Rose Café serves distinct cuisines. Hosting an elegant range of cuisines like Italian, Mediterranean, Continental, and Lebanese, the restaurant exhibits great ambiance. Constituting both contemporary and traditional cuisines, the menu delineates enough choices for non-vegetarian and vegetarian dishes, making it a captivating and one of the gripping places to visit in Delhi.    "));

        foodPlaces.add(new Place("Karim's", "11 AM to 4 PM | 8 PM to 11.30 PM", "Jama Masjid metro station", R.drawable.karims, "https://www.google.com/maps/place/Karim+Hotel/@28.5913483,77.241478,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce31b00000001:0x8896556f51e41d81!8m2!3d28.5913463!4d77.2436292",
                "Karim’s is a historic, retrospective restaurant situated near Jama Masjid in Gali Kababian, Delhi. Introduced in the year 1913, Karim’s is a restaurant that is delineated to be synonymous with this location and is conceivably Delhi’s most popular culinary point of disembarkation. The main course of the place includes Naan & Roti, Kabab, Bharatia Pattal, Rice & Pulao and Shahi Dastar Khwan. For dessert, the place serves Kheer Benazir."));

        foodPlaces.add(new Place("Kunzum Travel Cafe", "11:00 am to 07:30 pm (except Mondays)", "Hauz Khas metro station", R.drawable.kunzumcafe, "https://www.google.com/maps/place/Kunzum+Travel+Cafe/@28.553541,77.1921343,17z/data=!3m1!4b1!4m5!3m4!1s0x390d1d8a9cc8b757:0x1fe57f9bb019ebed!8m2!3d28.553541!4d77.194323",
                "An extraordinary place for travelers to meet and share thoughts and stories, make new travel buddies and plans over a cup of coffee is the Kunzum Café in Delhi. This is where you can enjoy reading travel books, share travel pictures, write about your experiences if you are not really travelling for the time being. Here, you will get to see many people who are from other countries as well with whom you can share the best knowledge about the places and travelogues."));

        foodPlaces.add(new Place("Khan Chacha", "11 AM to 11 PM", "Khan Market metro station", R.drawable.khanchacha, "https://www.google.com/maps/place/Khan+Chacha/@28.6006271,77.2251511,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce2e83d367611:0xf9c80d68de873c75!8m2!3d28.6006169!4d77.2273238",
                "Khan Chacha, quarries on the story of a splendid legacy. Founded in the early 1970s by Haji Banda Hasan, who started his interest with a modest little shop in Khan Market which later on popularly became to be known as Khan Chacha amongst the youngsters."));

        foodPlaces.add(new Place("Tamra - Shangri-La's", " 6 AM to 12 Noon", "Janpath metro station", R.drawable.tamrarasteraunt, "https://www.google.com/maps/place/Tamra+Restaurant/@28.6207873,77.2160792,16.79z/data=!4m5!3m4!1s0x390cfd375c42903b:0xee81c91f1df72220!8m2!3d28.62096!4d77.218162",
                "Tamra is an elegant, radiant, vibrant and most cherished fun restaurant serving different kinds of dishes. Located in the Eros Hotel at Connaught Place, Tamra mostly serves the North Indian, Pan Asian and Continental cuisines to relish and lighten up the taste buds of the visitors visiting the place."));

        foodPlaces.add(new Place("Farzi Cafe", "12 Noon to 1 AM", "Rajiv Chowk metro station", R.drawable.farzicafe, "https://www.google.com/maps/place/Farzi+Cafe/@28.6325985,77.2193059,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd36e3172485:0x209f4b7346c52858!8m2!3d28.6325989!4d77.2214681",
                "Highly focused on the gourmet dinner, Farzi Café – the contemporary Indian inexpensive restaurant, is best delineated to be an epicure experience blending in global traditional cuisine with the Indian contemporary ambiance and style. Farzi Café is a place where the restaurant guests can relish good and fine food."));

        foodPlaces.add(new Place("Barbeque Nation", "12 Noon to 3 PM | 6:30 PM to 11 PM", "Rajiv Chowk metro station", R.drawable.barbequenation, "https://www.google.com/maps/place/Barbeque+Nation/@28.6301968,77.218458,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd3688e349cb:0xce0d96d63feed9fb!8m2!3d28.6301968!4d77.2206467",
                "Buffets organized in Barbeque Nation exhibits every family’s treat. The place allows you to fulfill and satiate your hunger for good, mesmerizing food until the last moment. The Barbeque Nation at Delhi is one such happening place that makes people crave till the end till they are thoroughly full."));

        foodPlaces.add(new Place("Murthal", "Murthal is open 24 hours", "46.4 km from Delhi", R.drawable.murthal, "https://www.google.com/maps/place/Murthal,+Haryana+131027/@29.0320597,77.0581857,14z/data=!3m1!4b1!4m5!3m4!1s0x390db10d97d2a9b1:0x77a157c8b133cef9!8m2!3d29.0315896!4d77.0723807",
                "Murthal restaurant is one of the most famous restaurants in Delhi that is open 24X7 inviting tourists and guest from within and afar the city."));

        foodPlaces.add(new Place("Hauz Khas Social", "11 AM to 1 AM", "Hauz Khas metro station", R.drawable.hauzkhassocial, "https://www.google.com/maps/place/Hauz+Khas+Social/@28.5543504,77.1917894,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce20fdb584417:0x1f893fe3f6203e0b!8m2!3d28.5543504!4d77.1939781",
                "Hauz Khas Social is considered to be the best chilling tourist places in Delhi that merge the best of office and café. An ideal place, Hauz Khas Social is for the people who crave to relish and feel tranquil after a hectic workday. An all-day bar and café, Social invites you all day long to discuss work or feel relaxed from the tiresome work. This calls to be one of the best places to visit in Delhi for youngsters."));

        foodPlaces.add(new Place("Hard Rock Café", "12 Noon to 1 AM", "Saket metro station", R.drawable.hardrockcafe, "https://www.google.com/maps/place/Hard+Rock+Cafe/@28.5084422,77.1304011,13z/data=!3m1!5s0x390ce1f4d03bccf5:0xa1ae2c7ec4527c65!4m5!3m4!1s0x0:0x8cbf61d63100b20b!8m2!3d28.5272314!4d77.2171245",
                "Hard Rock Café, Delhi is the fourth restaurant in India which is opened in Delhi at DLF Place Saket. Hard Rock Café is a vibrant, leisure and happy chilling spot. Ideally situated near luxurious grand hotels, a short distance away from Delhi Indira Gandhi International Airport, Hard Rock Café offers the best to the local visitors and travelers and is among the best tourist places in Delhi to visit at night. "));

        foodPlaces.add(new Place("The Blue Bar", "12.30 PM to 12.45 AM", "Jor Bagh Metro Station", R.drawable.bluebar, "https://www.google.com/maps/place/The+Blue+Bar/@28.5951676,77.1680373,17z/data=!3m1!4b1!4m5!3m4!1s0x390d1d154f87079d:0xb7e6e5162c64dba0!8m2!3d28.5951676!4d77.170226",
                "One of the best luxurious bar and lounge, The Blue Bar endows a charismatic and edgy experience. Owing to the ideal and dramatically beautiful color scheme of red on black, the ambient lighting sets the mood perfect for the audience."));

        foodPlaces.add(new Place("Club Pangaea", "12 PM to 1 AM", "Jor Bagh Metro Station", R.drawable.clubpangaea, "https://www.google.com/maps/place/Pangea/@28.597171,77.1870681,15z/data=!4m8!1m2!2m1!1sclub+pangawa!3m4!1s0x390d1d593357f1f9:0x8d03220858d620ee!8m2!3d28.5971447!4d77.1957665",
                "Club Pangaea, a luxurious dining restaurant, and bar is indubitably a class apart in all aspect. A well-stocked restaurant with tenuous ambiance featuring a distinct variety of delicacies. Known to serve the best spirits, wines, and beverages, Club Pangaea mixes delectable food with happy drinks. "));

        foodPlaces.add(new Place("Kitty Su", "10 PM to 1.30 AM", "Barakhamba Road metro station", R.drawable.kittysu, "https://www.google.com/maps/place/Kitty+Su+New+Delhi/@28.6314031,77.2252287,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd31962e9e1b:0xe2653c036fc377c4!8m2!3d28.6314036!4d77.2274165",
                "Nestled and ducked in The Lalit, Kitty Su has transmogrified as the most luxurious and stylish clubbing places in Delhi. Classy, full of radiant and vibrant and exquisitely designed delineating the aura of happiness, Kitty Su is an impressive nightspot considered to be a great choice for people who are hardcore party drivers. It is one of the best places to visit in Delhi at night."));

    }
}