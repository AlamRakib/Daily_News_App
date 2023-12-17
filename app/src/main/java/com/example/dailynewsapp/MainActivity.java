package com.example.dailynewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;


    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);


        createTable();



        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);


    }

    private  class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View MyView  = layoutInflater.inflate(R.layout.sample_view, viewGroup, false);

            ImageView imageView = MyView.findViewById(R.id.imageItemCoverId);
            TextView textViewCategory = MyView.findViewById(R.id.itemtag);
            TextView textViewTitle = MyView.findViewById(R.id.itemTitle);
            TextView textViewDescription = MyView.findViewById(R.id.itemDes);
            LinearLayout linearLayout = MyView.findViewById(R.id.layIteam);


            HashMap<String,String> hashMap = arrayList.get(position);
            String category = hashMap.get("Category");
            String CoverImage = hashMap.get("image_ulr");
            String Title = hashMap.get("Title");
            String Description = hashMap.get("Description");


            Picasso.get()
                    .load(CoverImage)
                    .placeholder(R.drawable.baseline_image_24)
                    .into(imageView);

            textViewCategory.setText(category);
            textViewTitle.setText(Title);
            textViewDescription.setText(Description);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            textViewCategory.setBackgroundColor(color);






            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    NewsDetailsActivity.TITLE = Title;
                    NewsDetailsActivity.DESCRIPTION = Description;

                    Bitmap bitmap = ( (BitmapDrawable) imageView.getDrawable() ).getBitmap();
                    NewsDetailsActivity.MyBitmap = bitmap;

                    Intent myIntent = new Intent(MainActivity.this,NewsDetailsActivity.class);
                    startActivity(myIntent);
                }
            });



            return MyView;
        }
    }


    private  void createTable(){

        hashMap = new HashMap<>();
        hashMap.put("Category","Sports");
        hashMap.put("image_ulr","https://phantom-marca.unidadeditorial.es/0138f12bc2b0eb12c67061b66e647d1e/crop/72x0/2044x1315/resize/660/f/webp/assets/multimedia/imagenes/2023/12/08/17020722973192.png");
        hashMap.put("Title","সতর্ক করে দেওয়া হলো রোনালদোকে");
        hashMap.put("Description","গত মৌসুমে ইংলিশ প্রিমিয়ার লিগের ম্যাচ শেষে এক দর্শকের ফোন আছাড় মেরে ভেঙে ফেলার ফেলার ঘটনার জন্য ক্রিস্তিয়ানো রোনালদোকে সতর্ক করে দিয়েছে পুলিশ। বিতর্কিত ঘটনাটির আনুষ্ঠানিক সমাপ্তিও ঘটল এর মধ্য দিয়ে।\n" +
                "\n" +
                "গত এপ্রিলে এভারটনের বিপক্ষে ম্যানচেস্টা ইউনাইডের হেরে যাওয়ার ম্যাচের পর ওই কাণ্ড ঘটান রোনালদো। সামাজিক যোগাযোগ মাধ্যমে তখন ছড়িয়ে পড়া ভিডিও ক্লিপে দেখা যায়, পায়ে চোট নিয়ে খুঁড়িয়ে খুঁড়িয়ে মাঠ থেকে বেরিয়ে টানেলে ঢোকার ঠিক আগে হাত বাড়িয়ে কিছু একটায় সজোরে চাপড় দেন রোনালদো। প্রত্যক্ষদর্শীদের বরাতে রয়টার্স জানায়, এক দর্শকের ফোনে আঘাত করেন তিনি, ফোনটি আছড়ে পড়ে মাটিতে।.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Category","Sports");
        hashMap.put("image_ulr","https://www.fcbarcelona.com/fcbarcelona/photo/2018/07/04/934e2451-30ab-4c8e-9deb-91819da8a0b5/PWoyZTrw.jpg");
        hashMap.put("Title","শিশুদের সঙ্গে মেসি-নেইমারদের ফুটবল আনন্দ");
        hashMap.put("Description","আগের দিন জাপানে পৌঁছে পরদিন মাঠে নেমে পড়ল পিএসজির তারকাসমৃদ্ধ স্কোয়াড। গতানুগতিক কোনো অনুশীলনের জন্য অবশ্য নয়, নামলেন তারা টোকিওর ‘কিডস সকার ক্লিনিকে’। এতদিন টিভিতে যাদের খেলা দেখে হাততালি দিয়েছে, হৈ-হুল্লোড় করেছে, সেইসব তারকাদের খুব কাছে পাওয়াটা এইসব ক্ষুদে ফুটবলারদের জন্য তো স্বপ্ন সত্যি হয়ে ধরা দেওয়ার মতোই। মেসি-নেইমার-এমবাপেরাও খুব উপভোগ করলেন সময়টা। ছোট্ট শিশুদের সঙ্গে কাটালেন আনন্দঘন একটা দিন।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Category","Sports");
        hashMap.put("image_ulr","https://imgresizer.eurosport.com/unsafe/1200x0/filters:format(jpeg)/origin-imgresizer.eurosport.com/2023/02/19/3561584-72540848-2560-1440.jpg");
        hashMap.put("Title","এবার শিরোপা জিতবে বার্সা, নিশ্চিত লেভানদোভস্কি");
        hashMap.put("Description","সবশেষ মৌসুমটি কেটেছে হতাশায়। একটি শিরোপাও ঘরে তুলতে পারেনি বার্সেলোনা। কাতালান ক্লাবটির এবারের লিগেও শুরুটা হয়েছে পয়েন্ট হারিয়ে। তবে সমর্থকদের আশার কথা শোনালেন রবের্তো লেভানদোভস্কি। পোলিশ তারকার দৃঢ় বিশ্বাস, চলতি মৌসুমে শিরোপা জিতবে বার্সেলোনা।\n" +
                "\n" +
                "লা লিগায় গত মৌসুমে একটা সময় তো শীর্ষ চারে থাকাই বার্সেলোনার জন্য হয়ে উঠেছিল বেশ কঠিন। শেষ পর্যন্ত তারা মৌসুম শেষ করতে পারে দুইয়ে থেকে। লিগ শিরোপা জেতে রিয়াল মাদ্রিদ। কোপা দেল রে, স্প্যানিশ সুপার কাপেও সাফল্য ধরা দেয়নি তাদের হাতে।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Category","Sports");
        hashMap.put("image_ulr","https://imgresizer.eurosport.com/unsafe/1200x0/filters:format(jpeg)/origin-imgresizer.eurosport.com/2023/04/26/3693054-75151008-2560-1440.jpg");
        hashMap.put("Title","উয়েফা বর্ষসেরার লড়াইয়ে বেনজেমা-কোর্তোয়া-ডে ব্রুইনে");
        hashMap.put("Description","গত মৌসুমে দুর্দান্ত পারফরম্যান্সের স্বীকৃতিস্বরূপ উয়েফার বর্ষসেরা ফুটবলারের লড়াইয়ে শীর্ষ তিনে জায়গা পেয়েছেন করিম বেনজেমা। সেখানে তার সঙ্গী রিয়াল মাদ্রিদ সতীর্থ থিবো কোর্তোয়া ও ম্যানচেস্টার সিটির কেভিন ডে ব্রুইনে।\n" +
                "\n" +
                "পুরস্কারটির লড়াইয়ে থাকাদের তালিকা শুক্রবার প্রকাশ করেছে ইউরোপিয়ান ফুটবলের নিয়ন্তা সংস্থা উয়েফা। আগামী ২৫ অগাস্ট চ্যাম্পিয়ন্স লিগের ২০২২-২৩ মৌসুমের ড্র অনুষ্ঠানে বিজয়ী ঘোষণা করা হবে।\n" +
                "\n" +
                "পুরো মৌসুমে ঘরোয়া ও আন্তর্জাতিক ফুটবলে পারফরম্যান্সের বিচারে পুরস্কারটি দেওয়া হয়ে থাকে।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Category","Sports");
        hashMap.put("image_ulr","https://estaticos-cdn.prensaiberica.es/clip/2998cb87-dbff-42ba-b2f3-aefc67694d0b_alta-libre-aspect-ratio_default_0.jpg");
        hashMap.put("Title","অভিষেকে গোলের পর দি মারিয়ার চোটের বিষাদ");
        hashMap.put("Description","নতুন ক্লাবের হয়ে শুরুটা অম্ল-মধুর হলো আনহেল দি মারিয়ার। ইউভেন্তুসের হয়ে অভিষেকেই গোলের দেখা পেলেন আর্জেন্টাইন এই অ্যাটাকিং মিডফিল্ডার। কিন্তু পরে আবার তাকে মাঠ ছাড়তে হলো চোট পেয়ে।\n" +
                "\n" +
                "ইতালিয়ান ক্লাবটি মঙ্গলবার এক বিবৃতিতে জানায়, ঊরুর পেশির চোটে অন্তত ১০ দিন মাঠের বাইরে থাকতে হবে দি মারিয়াকে। এরপর তার চোট পরিস্থিতি পরীক্ষা করে পরবর্তী সিদ্ধান্ত নেওয়া হবে।\n" +
                "\n" +
                "সাস্সুয়োলোর বিপক্ষে সোমবারের ম্যাচ দিয়ে এবারের সেরি আ মৌসুম শুরু করে ইউভেন্তুস। ঘরের মাঠে প্রতিপক্ষকে ৩-০ গোলে হারায় তুরিনের দলটি।");
        arrayList.add(hashMap);




    }





}