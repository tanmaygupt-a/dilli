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

public class ShoppingFragment extends Fragment {

    ArrayList<Place> shoppingPlace = new ArrayList<Place>();

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // setting up array list
        setupPlacesObjects();

        Collections.shuffle(shoppingPlace);
        // Setting up List View
        ListView listView = (ListView) rootView.findViewById(R.id.rootView);

        // Creating adapter
        CardAdapter adapter = new CardAdapter(getActivity(), shoppingPlace);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = shoppingPlace.get(position);
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

    private void setupPlacesObjects() {
        shoppingPlace.add(new Place("Cannaut Place", "24 hours a day, seven days a week", "Rajiv Chowk, New Delhi", R.drawable.cannautplace, "https://www.google.com/maps/place/Connaught+Place,+New+Delhi,+Delhi+110001/@28.6289017,77.2065322,15z/data=!3m1!4b1!4m5!3m4!1s0x390cfd37b741d057:0xcdee88e47393c3f1!8m2!3d28.6304203!4d77.2177216",
                "Set in the heart of National Capital and popularly known as CP, Connaught Place is considered as the most expensive commercial markets in the world. It is popular for housing showrooms of national and international brands, luxurious hotels and flea markets. The equinoctial sundial, Jantar Mantar, and Gurudwara Bangla Sahib featuring a reflecting pool, are extremely popular among tourists visiting Connaught Place. Notably, the commercial area got its name from Prince Arthur, 1st Duke of Connaught and Strathearn."));

        shoppingPlace.add(new Place("Dilli Haat", "10:00 am to 10:00 pm", "INA, New Delhi", R.drawable.dillihaat, "https://www.google.com/maps/place/Dilli+haat+INA/@28.5733233,77.2053586,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce2630d16739d:0xf353c316c564a004!8m2!3d28.5734068!4d77.2077203",
                "An outdoor marketplace located near INA Market, Dilli Haat is spread over 6 acres with 62 stalls presenting handicrafts and ethnic cuisine from various parts of India. It offers a traditional rural ambience where visitors can admire the rich Indian culture and shop for items suitable to their modern-day requirements. Moreover, Dilli Haat organizes many cultural events, including dance and music performances, and aims to preserve the heritage of India."));

        shoppingPlace.add(new Place("Cyber Hub", "Most of the dining venues remain open till midnight", "Cyber City Rapid Metro Station, Gurgaon", R.drawable.cyberhub, "https://www.google.com/maps/place/DLF+CyberHub/@28.495179,77.0869248,17z/data=!3m1!4b1!4m5!3m4!1s0x390d19386394df05:0x2f2805b9b4942a41!8m2!3d28.495179!4d77.0891135",
                "If there is one place in NCR that all fun seekers swear by, it’s Cyber Hub Gurgaon. It is an integrated food and entertainment destination with multiple offices, mainly occupying the higher floors of the buildings within the complex. Along the promenade that makes its way through these buildings are an array of dining options including restaurants, bars & pubs, cafes, bakeries, dessert places, and so on. Places like Smaaash and The People and Co. lift the entertainment quotient even further. There are a few retail outlets as well, along with an amphitheatre for events and promotional activities."));

        shoppingPlace.add(new Place("Chandni Chowk", "Most shops remain open between 10:00 AM and 7:00 PM on all days except Mondays", "Chandni Chowk Metro Station", R.drawable.chandnichowl, "https://www.google.com/maps/place/Chandni+Chowk,+New+Delhi,+Delhi/@28.6513744,77.2228826,15z/data=!3m1!4b1!4m5!3m4!1s0x390cfd1a88dcc559:0x24fa43c081dbe51!8m2!3d28.6505331!4d77.230337",
                "Chandni Chowk is translated as Moonlight Street. This iconic area in Delhi houses one of the oldest markets in the city. You can buy everything you want at wholesale prices here. The hustle and bustle of the street, the colourful and quaint stores, and the constant banter between buyers and sellers are experiences you should not miss. Chandni Chowk has about 1500+ shops."));

        shoppingPlace.add(new Place("Lajpat Nagar Central Market", "9:00 AM to 10:00 PM (Tuesdays to Sundays)", "Lajpat Nagar Metro Station", R.drawable.lajpatmarket, "https://www.google.com/maps/place/Lajpat+Market/@28.5680047,77.2413703,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce3b287e47851:0x156b3aba780e12f7!8m2!3d28.5679995!4d77.2435724",
                "The Lajpat Nagar is one of the most crowded residential and commercial areas in Delhi and people flock here to visit the Central Market. You can buy branded and non-branded goods at very low prices and there are hundreds of shops to choose from. You can easily spend up to half a day here shopping to your heart’s content."));

        shoppingPlace.add(new Place("Sarojini Nagar Market", "9:00 AM to 10:00 PM (Tuesdays to Sundays)", "INA metro station", R.drawable.sarojinimarket, "https://www.google.com/maps/place/Sarojini+Nagar+Market,+Sarojini+Nagar,+New+Delhi,+Delhi+110023/@28.5769069,77.1940743,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce28041e265eb:0xc243cd66d586a451!8m2!3d28.5772672!4d77.1963216",
                "Sarojini Nagar is a famous neighbourhood of South West Delhi and an atypical shopping spot where you can get hundreds of items with your pocket money itself. It is located very close to Safdarjung Airport and before it got the name Sarojini Nagar it was called Vinay Nagarand and later its name was changed to Sarojini Nagar. The colony is filled with Safdarjung Enclave, South Extension, Laxmibai Nagar, Nauroji Nagar, Chanakyapuri and Netaji Nagar. This is one of the most vibrant places in Delhi to buy various items like clothes, accessories, shoes, fabrics etc."));

        shoppingPlace.add(new Place("Khan Market", "It is open on all days from 10:00 am to 12:00 midnight except on Sundays", "Khan Market Metro Station", R.drawable.khanmarket, "https://www.google.com/maps/place/Khan+Market/@28.6001554,77.2247701,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce2e83abc927f:0x6601f4fde52a3898!8m2!3d28.599992!4d77.2271776",
                "An old market in Delhi which was established in 1951 is Khan Market, named in honour of Khan Abdul Jabbar Khan. The market was ranked as the costliest retail one in India. Also, it is the most expensive retail high street by real estate firm Cushman and Wakefield. It is a U shaped double storey market complex started with 154 shops and 74 flats. Near to the market, there is Sujan Singh Park- believed to be the first apartment complex in Delhi."));

        shoppingPlace.add(new Place("Paharganj", "11:00 am to 09:00 pm (except Mondays)", "Metro Gate 1, R.K. Ashram Metro Station", R.drawable.paharganj, "https://www.google.com/maps/place/Paharganj+Market/@28.6480367,77.2107984,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd59d7fd87cb:0xd3a8773fe6fe98d7!8m2!3d28.6480392!4d77.2129744",
                "Yet another famous neighbourhood of Central Delhi is Paharganj. It is located west of the New Delhi Railway Station. During the Mughal period, it was known as Shahganj or King’s ganj or market place. Paharganj is one of the three administrative subdivisions of the Central Delhi district. It promotes a plethora of hotels, lodges, restaurants, dhabas and a wide variety of shops. A lot of people from domestic as well as international regions come here to spend time with the locals and buy some good items at cheaper rates."));

        shoppingPlace.add(new Place("Janpath Market", "11am to 9pm", "Janpath metro station", R.drawable.janpath, "https://www.google.com/maps/place/Janpath+Market/@28.6290786,77.2165751,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd35732ff587:0xb3489e0fc930becf!8m2!3d28.6290786!4d77.2187638",
                "If shopping has always remained one of your favorite pastime hobbies, Janpath Market of Delhi is something you should never miss on. Being one of the most popular markets of the capital city of Delhi, Janpath Market is highly adored by tourists across the globe. Janpath Market of Delhi is known as a fun-frolic market where you see more foreigners than Indians. Gujarati and Tibetan Market are the two principal streets that combine to represent the whole of Janpath Market. \n"));

        shoppingPlace.add(new Place("Select City Walk Mall", "10 am to 11 pm", "Malviya Nagar metro station", R.drawable.selectcitywalk, "https://www.google.com/maps/place/Select+CITYWALK/@28.5288523,77.2173552,17z/data=!3m2!4b1!5s0x390ce18b1f46ef05:0xd23b80b99ddb1f67!4m5!3m4!1s0x390ce18ac60e4a61:0x81c366c7998e72a3!8m2!3d28.5288523!4d77.2195439",
                "Fan of all things plush? Well, then you must visit the Select City Walk, a vibrant, upscale and the biggest shopping mall in the heart of South Delhi. The chic shopping center is not just another mall where people come only to shop. It’s a place where people come to shop, celebrate, dine, meet, and make memories with their loved ones."));

        shoppingPlace.add(new Place("DLF Promenade Mall", "11 am to 11 pm", "Vasant Vihar", R.drawable.dlfpromenade, "https://www.google.com/maps/place/DLF+Promenade/@28.5423485,77.1541301,17z/data=!3m1!4b1!4m5!3m4!1s0x390d1dce96eb3acd:0xd39b01d0a6ebd44f!8m2!3d28.5423485!4d77.1563188",
                "In addition to being a fashion-forward mall in Delhi, the DLF Promenade is home to various iconic food chains like Nandos, TGIF, The Big Chill and Smoke House Deli where you can satiate your hunger pangs. If you are a movie lover, there is the 7-screen PVR ICON Cinemas with a total seating capacity of 1140. For those who are visiting the mall with kids, there’s Kiddyland, an outdoor play area to keep the little ones occupied. Lastly, there’s an open-air lifestyle space called ‘The Hub’ where one can relax in the company of their friends or family."));

        shoppingPlace.add(new Place("DLF Emporio Mall", "11 am to 9 pm", "Vasant Vihar", R.drawable.dlfemporio, "https://www.google.com/maps/place/DLF+Emporio/@28.5436,77.1546113,17z/data=!3m1!4b1!4m5!3m4!1s0x390d1dced5531f8d:0xf44704514f7d1e1a!8m2!3d28.5434587!4d77.1566955",
                "Known to be one of the most expensive malls in the country, the DLF Emporio is a name synonymous with luxury. The four-storeyed mall with a total retail area of 320,000 sq. ft. offers a unique shopping experience for those who understand the nuances of luxury. There are around 130 brands including 50 international brands like Dior, Kenneth Cole, Burberry, DKNY, Cartier, Louis Vuitton, Giorgio Armani, Salvatore Ferragamo, Hugo Boss, Bottega Veneta, and Versace, to name a few. Besides these, this mall also houses various Indian designers such as Ritu Kumar, Tarun Tahiliani, Nikhil, and Shantanu. "));

        shoppingPlace.add(new Place("Ansal Plaza Mall", "11 am to 11 pm (Mon-Fri) | 11 am to 12 am (Sat-Sun)", "South Extension", R.drawable.ansalplazamall, "https://www.google.com/maps/place/Ansal+Plaza,+Sector+1,+Sector+23,+Gurugram,+Haryana+122017/@28.5114567,77.0397754,17z/data=!3m1!4b1!4m5!3m4!1s0x390d198903c020e1:0xeb0f7dea72ddbb13!8m2!3d28.5114567!4d77.0419641",
                "Situated in Andrews Ganj at Khel Gaon Marg, when Ansal Plaza first opened to the public on 1st November 1999, it was the only major shopping mall in Delhi. Today, despite the opening of several swanky malls in Delhi, Ansal Plaza still draws a lot of crowds. The place may not have fancy brands and movie theatres, but it is a favorite hangout spot of college-goers. One of the reasons for the same is the presence of several colleges in that area, such as the Kamla Nehru Girls College and Gargi College."));

        shoppingPlace.add(new Place("Ambience Mall", "10 am to 10 pm", "Sikanderpur Metro Station", R.drawable.ambiencemall, "https://www.google.com/maps/place/Ambience+Mall,+Gurugram/@28.503641,77.095152,17z/data=!3m1!4b1!4m5!3m4!1s0x390d1938456789c7:0x45a757aa37e73026!8m2!3d28.503641!4d77.0973407",
                "Ambience Mall, Gurgaon is a shopping mall in Gurgaon, Haryana, India. It contains a built-up area of 21 lakhs square feet and a retail (GLA) area of 18 lakhs square feet. Most floors have a shopping area of 860 meters. Ambience Mall has more than 230 stores and food outlets. Its parking space can accommodate about 4000 vehicles. The mall was opened for public in 2007. It has won the Best Shopping Center of the Year and Most Admired Shopping Centre of the Year awards. It is one of India's largest shopping malls and one of the most famous shopping malls in Asia."));

        shoppingPlace.add(new Place("DLF Mall Of India", "10 am to 10 pm", "Noida Sector 18", R.drawable.dlfnoida, "https://www.google.com/maps/place/DLF+Mall+of+India,+Noida/@28.5673409,77.3189416,17z/data=!3m1!4b1!4m5!3m4!1s0x390ce521218557b5:0x45051fcfc696f085!8m2!3d28.5673409!4d77.3211303",
                "Spread over 2 million sq. ft. (GLA), DLF Mall of India is the largest mall in the country. DLF Mall of India has introduced many firsts to the industry; the mall has introduced the unique concept of ‘Zoning’ for the first time in India. As an intelligently zoned mall, DLF Mall of India offers a perfect mix of retail offerings spread across five zones and 6 floors. "));

        shoppingPlace.add(new Place("Pacific Mall", "11 am to 10 pm", "Subhash nagar", R.drawable.pacificmall, "https://www.google.com/maps/place/Pacific+Mall+Tagore+Garden/@28.642372,77.1041903,17z/data=!3m1!4b1!4m5!3m4!1s0x390d0363c4edf747:0x240c75aa3d09de7a!8m2!3d28.642372!4d77.106379",
                "Its convenient location and excellent connectivity, both by public and private transport, make Pacific Mall, Delhi a popular shopping destination in the city. The mall has more than 130 outlets of Indian and international labels. Some of the prominent brands housed in the mall are – Tommy Hilfiger, Promod, ONLY, Mango, UCB, Calvin Klein, Vero Moda, Jack & Jones, and French Connection.  Off late, flea markets are also getting set up in the mall premises. The best part is that these markets are getting a good response from shoppers."));

    }
}