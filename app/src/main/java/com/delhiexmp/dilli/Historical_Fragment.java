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


public class Historical_Fragment extends Fragment {

    ArrayList<Place> historicPlaces = new ArrayList<Place>();

    public Historical_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // Setting up ArrayList
        setupPlaces();

        // shuffling array list
        Collections.shuffle(historicPlaces);

        // Setting up List View
        ListView listView = (ListView) rootView.findViewById(R.id.rootView);

        // Creating adapter
        CardAdapter adapter = new CardAdapter(getActivity(), historicPlaces);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = historicPlaces.get(position);
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

        historicPlaces.add(new Place(getString(R.string.india_gate), getString(R.string.alltime_open), "Central Secretariat, New Delhi", R.drawable.indiagate2, "https://www.google.com/maps/place/India+Gate/@28.612912,77.227321,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce2daa9eb4d0b:0x717971125923e5d!8m2!3d28.612912!4d77.2295097"
        ,"India Gate symbolises the sacrifice of 70,000 Indian soldiers who lost their lives battling against the foreign army during the World War I. Designed by Edwin Lutyens, it features the undying Amar Jawan Jyoti or the Flame of the Immortal Soldier which was added later to honour Indian martyred soldiers in the Indo-Pak War. Furthermore, this beautiful masterpiece is counted amongst the largest war memorials in India. Standing on a Bharatpur stone base, the structure is surrounded by lush lawns making it a popular picnic spot during winter afternoons and summer evenings. Lit at night, the monument looks magnificent with colourful fountains in the in the vicinity."));

        historicPlaces.add(new Place("Humayun's Tomb", getString(R.string.sunrise_to_sunset), "Jor Bagh metro station", R.drawable.humayuntomb, "https://www.google.com/maps/place/Humayun’s+Tomb/@28.5932848,77.2485605,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce31ce8460ba7:0xb9f1ba2d3bdfa80d!8m2!3d28.5932848!4d77.2507492",
                "Built in 1565 A.D., the Humayun’s Tomb was established in the memory of Humayun by his widow Bega Begam, and was the first delhiexmp of Mughal architecture in India. Constructed after nine years of his demise, the tomb is inspired by Persian architecture which is reflected in the corridors arched alcoves, and the double dome. The tomb is also called chaharbagh, owing to its garden squares with passageways water channels, and holds graves of Mughal rulers inside the walled enclosed space."));

        historicPlaces.add(new Place("Red Fort", "09:30 am to 04:30 pm (closed on Mondays)", "Chandni Chowk, New Delhi", R.drawable.redfort, "https://www.google.com/maps/place/Red+Fort/@28.6565311,77.2314973,15.5z/data=!4m9!1m2!2m1!1sred+fort!3m5!1s0x390cfce26ec085ef:0x441e32f4fa5002fb!8m2!3d28.6561592!4d77.2410203!15sCghyZWQgZm9ydFoUCghyZWQgZm9ydCIIcmVkIGZvcnSSAQhmb3J0cmVzcw",
                "Constructed in 1639 by the Mughals, Red Fort gets its name from its massive red-coloured sandstone walls. Set in Old Delhi, the octagonal-shaped fort is spread over an area of 254 acres. The planning and designing of the fort is a fusion of Mughal, Persian, Hindu, and Timurid traditions. A strong influence on later structures built in and around Delhi, Red Fort also features a museum that holds Mughal-era artefacts, including daggers, curtains, miniature paintings and carpets. The highlights of this architectural creativity include the peacock throne, step well, imperial bath, Moti Masjid and Hira Mahal."));

        historicPlaces.add(new Place("Hauz Khas Village", getString(R.string.alltime_open), "Hauz Khas, New Delhi", R.drawable.hauzkhas, "https://www.google.com/maps/place/Hauz+Khas+Village,+Deer+Park,+Hauz+Khas,+New+Delhi,+Delhi+110016/@28.553331,77.1920222,17z/data=!3m1!4b1!4m5!3m4!1s0x390d1d8aa6bccb0f:0x357d3d8396615cec!8m2!3d28.5533997!4d77.1941654",
                "If you are a party animal, then definitely head to Hauz Khas, which is popular for its swanky clubs, quirky cafes, and fine-dine restaurants. Earlier known as Hauz-e-Alai, this affluent neighbourhood in South Delhi holds a historical importance with remnants of Mughal architecture. The place is popular for a 13-century structure, Hauz Khas Complex, which retains the old charm amidst the modernised street. Besides raving it up at urban village in Delhi, we suggest you take delight in the greenery of Deer Park, splurge at designer label boutiques and admire the fine artwork at various art galleries."));


        historicPlaces.add(new Place("Akshardham", "09:30 am to 06:30 pm", "Akshardham, New Delhi", R.drawable.akshardham, "https://www.google.com/maps/place/Akshardham/@28.6126735,77.2750732,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce35b9975b1fb:0x69a09f265ef3b22a!8m2!3d28.6126735!4d77.2772619",
                "Dedicated to Bhagwan Swaminarayan, Akshardham Temple exhibits the ancient culture of India. The temple complex maintains a step-well styled courtyard and 60 acres of lush lawns featuring the bronze statues of Indian heroes, including patriots and warriors. Registered as the World’s largest comprehensive Hindu temple in the Guinness World Record, the temple is an architectural marvel built from intricately carved sandstone and marble.  Furthermore, the temple organizes exhibitions on Swaminarayan’s life teachings and also organises a musical fountain and light show after sunset every day."));


        historicPlaces.add(new Place("Lotus Temple", "9:00 am to 5:00 pm", "Kalkaji Mandir, New Delhi", R.drawable.lotustemple, "https://www.google.com/maps/place/Lotus+Temple/@28.553492,77.2566377,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce3c16e028cd1:0x653beb1ee85ec67a!8m2!3d28.553492!4d77.2588264",
                "Known for its unique architectural design, Lotus Temple is a Bahá’í House of Worship, dedicated to harmony of humanity. Inspired by the lotus flower, the temple boasts of 27 free-standing marble-clad petals, and is surrounded by sprawling gardens and pond. With a height of over 34 metres, it can accommodate around 2500 people altogether. The temple welcomes every religion symbolizing the culture of Bahá’í Houses of Worship, and offers a tranquil ambience ideal for rejuvenation."));

        historicPlaces.add(new Place("Qutub Minar", "7:00 am to 5:00 pm", "Qutub Minar metro station, New Delhi", R.drawable.qutubminar, "https://www.google.com/maps/place/Qutub+Minar/@28.5244754,77.1833319,17z/data=!3m1!4b1!4m5!3m4!1s0x390d1e0667819b4f:0x834995f160759db8!8m2!3d28.5245087!4d77.1855817",
                "Qutub Minar is a 73-metre tall minaret, named after Qutb-ud-din Aibak. The tower contains 5 distinct tapering storeys, wherein first 3 storeys of this masterpiece are adorned with red sandstone, while the fourth and fifth storeys are constructed in marble and sandstone respectively, engraved with decorative Quranic texts. Interestingly, the tower has a spiral staircase with 379 steps, and has a mosque named ‘Quwwat-ul-Islam Masjid’ at the foot of the tower, which is the first mosque in India."));


        historicPlaces.add(new Place("Jama Masjid", "7:00 am to 12:00 pm, 1:30 pm to 6:30 pm", "Jama Masjid, New Delhi", R.drawable.jamamasjid, "https://www.google.com/maps/place/Jama+Masjid/@28.6506792,77.2312534,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd18df89b215:0xdd57369e29bf9d96!8m2!3d28.6506792!4d77.2334421",
                "Located in the heart of Old Delhi, Jama Masjid is the largest and most well-known mosque in India. It was constructed between 1650 and 1656 under the reign of Mughal emperor Shah Jahan and it took more than 5000 labourers to complete this extravagant structure. Built in red sandstone and marble, this revered mosque has three gates, fours towers, two 40-metre high minarets and a courtyard that can hold 25,000 devotees. Please note that entry is not allowed in the mosque during prayers."));

        historicPlaces.add(new Place("Rashtrapati Bhavan", " 9:00 am to 4:00 pm", "Central Secretariat, New Delhi", R.drawable.rashtrapatibhavan, "https://www.google.com/maps/place/Rashtrapati+Bhavan/@28.6143478,77.1972413,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce2a99b6f9fa7:0x83a25e55f0af1c82!8m2!3d28.6143478!4d77.19943",
                "When in New Delhi, don’t miss out on exploring the Rashtrapati Bhavan, the official residence of the President of India. Flanked on the western end of Rajpath, this sprawling 330-acre estate houses the Main Building (Circuit 1), the Rashtrapati Bhavan Museum Complex (Circuit 2) and the world-famous Mughal Gardens (Circuit 3). A creation of Sir Edwin Lutyens and Herbert Baker, this huge presidential palace is the largest home of any head of state in the world and is truly an architectural marvel."));

        historicPlaces.add(new Place("Agrasen ki Baoli", "7:30 AM to 6:00 PM on all days", "Barakhamba Road Metro Station", R.drawable.agrasenkibaoli, "https://www.google.com/maps/place/Agrasen+ki+baoli/@28.6260482,77.2228442,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd3313d868d9:0x9084a965630af01b!8m2!3d28.6260482!4d77.2250329",
                "The Agrasen ki Baoli is a protected monument that is located near Connaught Place. This is a deep stepwell that has 108 steps and is said to have been built by the Agrawal community in the 14th century. You can spend up to an hour here marvelling the architectural brilliance."));

        historicPlaces.add(new Place("Raj Ghat", "5:00 AM to 7:30 PM on all days", "Delhi Gate Metro Station", R.drawable.rajghat, "https://www.google.com/maps/place/Raj+Ghat/@28.6406214,77.2473115,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfcdafe80dca3:0x1a5978757d31b6ef!8m2!3d28.6406214!4d77.2495002",
                "Raj Ghat is an important monument in Delhi and is dedicated to the Father of the Nation. It is located quite close to the river Yamuna and is the place where the last rites for Mahatma Gandhi was performed. The spot has an eternal flame burning and is open to the sky. It is a peaceful and very beautiful spot to visit."));

        historicPlaces.add(new Place("Purana Qila", "7:00 AM to 5:00 PM every day", "Indraprastha Metro Station", R.drawable.puranaqila, "https://www.google.com/maps/place/Purana+Qila/@28.6095744,77.2415484,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce3214b3b6771:0x139279610ab2ccb3!8m2!3d28.6095744!4d77.2437371",
                "The Purana Qila, also called the Old Fort, is one of the oldest forts in Delhi. Remains dating back to the Pre-Mauryan period were discovered here. The complex has three arched gateways and contains monuments like the Sher Mandal and the Qila-i-Kuhna mosque. Other historically important monuments can also be found around the Purana Qila. The Old Fort is located in Mehrauli."));

        historicPlaces.add(new Place("Laxminarayan Temple (Birla Mandir)", "04:30 am to 01:30 pm and from 02:30 pm and 09:00 pm", "", R.drawable.birlamandir, "https://www.google.com/maps/place/Shri+Laxmi+Narayan+Temple+(Birla+Mandir)/@28.6326666,77.1968076,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfcbaaa7edb15:0x2d2dc76b52aa7f6e!8m2!3d28.6326666!4d77.1989963",
                "Birla Mandir is a common name for different Hindu temples built by the Birla family at different locations in India. Almost all the temples are built of white marbles as well as sandstones. The prominent cities across the country have given their spaces for these temples to be erected. Among them, Birla Mandir is particularly a famed one and an important Delhi tourist attraction as well. All the temples are created very carefully as to accommodate a huge number of visitors."));

        historicPlaces.add(new Place("Feroz Shah Kotla Fort", "Tuesday to Sunday from 06:00 am to 06:00 pm.", "Pragati Maidan Metro Station", R.drawable.ferozshahkotlafort, "https://www.google.com/maps/place/Feroz+Shah+Kotla/@28.634963,77.2405047,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfcd722979b5b:0x780ad31b2b00daf8!8m2!3d28.634963!4d77.2426934",
                "Kotla is the name people of Delhi simply call the famous historic figure the Feroz Shah Kotla in Delhi. It was fortress built by Sultan Feroz Shah Tughlaq to obtain his version of Delhi city named Ferozabad. The fortress looked amazingly stunning- a polished sandstone Topra Ashokan pillar is standing tall in the fortress and it is one of the best places to visit in east Delhi. It was one of the many pillars left by the Mauryan emperor. It was re-erected at the fort as per the orders of Firoz Shah after it was abandoned and left alone in Topra Kalan in Pong Ghati."));

        historicPlaces.add(new Place("The Tomb of Safdarjung", getString(R.string.sunrise_to_sunset), "Jor Bagh metro station ", R.drawable.tombofsafdarganj, "https://www.google.com/maps/place/Safdarjung+Tomb/@28.5893011,77.2083795,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce291e9cdc555:0xcd09511bfd9337ec!8m2!3d28.5895128!4d77.2105526"
        ,"Safdarjung’s Tomb in Delhi is a famous attraction that is made of sandstone and marble mausoleum and it came into existence in 1754. The late Mughal Empire style is depicted for the statesman of Safdarjung. It extends a special ambiance with it's domed and arched red-brown and white coloured structures. Safdarjung was the prime minister of the Mughal Empire when Ahmad Shah Bahadur was on the throne in 1748 and it is one of the best places in east Delhi."));

        historicPlaces.add(new Place("ISKCON Temple", "4:30 am to 9 pm", "Nehru Place metro station", R.drawable.iskontemple, "https://www.google.com/maps/place/ISKCON+Temple+Delhi-Glory+Of+India+%26+Vedic+Cultural+Centre,+New+Delhi/@28.5561132,77.2516419,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce254b22ae79f:0xf25771c34bfa1ebf!8m2!3d28.5561132!4d77.2538306",
                "The Iskcon Temple is a spectacular shrine located in Delhi constituted to be the best tourist places in Delhi. Situated at the Sant Nagar in East Kailash, Iskcon Temple dwarfs the southern skyline zone of Delhi. Originally initiated by Bhaktivedanta Prabhupada, ISKCON is an association belonging to Hare Rama Hare Krishna fad."));

        historicPlaces.add(new Place("Gurudwara Bangla Sahib", "The Gurudwara is open on all days 24 hours", "Rajiv Chowk metro station", R.drawable.banglasahib, "https://www.google.com/maps/place/Gurudwara+Bangla+Sahib/@28.6265828,77.206874,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd24f8845b47:0xc31d7dba181b70c9!8m2!3d28.6265828!4d77.2090627",
                "The Gurudwara Bangla Sahib is one of the most prominent gurudwaras for the Sikhs in Delhi. Located near the Connaught Place, this gurudwara has a holy river name Sarovar inside its complex. This complex also houses a hospital, a library, a museum, and a higher secondary school."));

        historicPlaces.add(new Place("Nizamuddin Dargah", "05:00 am to 10:30 pm", "Pragati Maiden & Indraprastha", R.drawable.nixamuddindargah, "https://www.google.com/maps/place/Nizamuddin+Dargah+Sharif/@28.5913224,77.2405342,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce3fb60131333:0x45b26ad8fe1bcf5f!8m2!3d28.5913224!4d77.2427229",
                "Hazrat Nizamudin Dargah or simply called Nizamuddin Dargah in Delhi is a famous tourist destination in India. It is a mausoleum of one of the famous Sufi saints, Hazrat Khwaja Syed Nizamuddin Auliya who lived from 1238 to 1325. It is situated in the Hazrat Nizamuddin West area of Delhi and visited by thousands of Islam believers every week but since it was declared to be an attraction, many other people also visit the Dargah."));

        historicPlaces.add(new Place("Jamali Kamli Mosque and Tomb", getString(R.string.sunrise_to_sunset), "Qutab Minar metro station", R.drawable.jamalikamli, "https://www.google.com/maps/place/Jamali+Kamali,+ladha+sarai,+Mehrauli+Archeological+Park+Trail,+Christian+Colony,+Mehrauli,+New+Delhi,+Delhi+110016/@28.5195712,77.1849559,17z/data=!3m1!4b1!4m5!3m4!1s0x390d1e04f306a703:0x6e4f1f96a5d9d44f!8m2!3d28.5195712!4d77.1871446",
                "A famous mosque which is archaeologically significant for India is Jamali Kamali Mosque and Tomb related to it. It is located in the archaeological village complex in Mehrauli in Delhi. The two monuments situated in contact with each other are the mosque and the tomb of two persons, Jamali and Kamali. The Urdu name Jamali originated from Jamal which means beauty. The name was an alias given to Shaikh Fazlullah and he was also known as Shaikh Jamali Kamboh or Jalal Khan. He was a great Sufi saint lived during the pre-Mughal period ruled by Lodi. While on the other side, Kamali was not famous as Jamali but he associated with Jamali."));

        historicPlaces.add(new Place("Mehrauli Archaeological Park", getString(R.string.sunrise_to_sunset), "Opposite Qutub Minar Metro Station", R.drawable.nationalarchaelogicalpark, "https://www.google.com/maps/place/Mehrauli+Archaeological+Park+Jamali+Kamali/@28.5202041,77.1854903,17z/data=!3m1!4b1!4m5!3m4!1s0x390d1e035c47ce23:0x2c919deeead57752!8m2!3d28.5202041!4d77.187679",
                "The Mehrauli Archaeological Park is located adjacent to the Qutub Minar Complex and is spread over 200 acres. This park houses almost 100 archaeologically significant monuments, including the Tomb of Balban, Madhi Masjid, the Tomb of Quli Khan, and the Rajon Ki Baoli. It is easy to spend the whole day here, exploring monuments if you are an archaeology enthusiast."));

        historicPlaces.add(new Place("Tughlaqabad Fort", "08:00 am to 06:00 pm", "Govindpuri metro station", R.drawable.tughlaqabadfort, "https://www.google.com/maps/place/Tughlaqabad+Fort,+Tughlakabad,+New+Delhi,+Delhi/@28.5159554,77.2559258,16z/data=!3m1!4b1!4m5!3m4!1s0x390ce16bac76386f:0x5d576a21b95dff10!8m2!3d28.5163996!4d77.2613488",
                "A herald lying in the history of India is the ruined fort which is fondly called as Tughlaqabad Fort in Dehi. It stretches across more than 6 km and it was built by Ghiyas-ud-din Tughlaq, the founder of Tughlaq dynasty. He established the historic city of Delhi which was abandoned in 1327. The fort was a gigantic structure made of stone with hard walls about 10-15 meters high and those walls were crowned by battlement parapets and bastions. The fort city of Tughlaqabad had 52 gates and now only 13 are remaining."));
    }

}