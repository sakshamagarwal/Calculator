package com.example.saksham.contacts;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Human sheldon = new Human("Sheldon Cooper", R.drawable.sheldon, "+91-9876543210");
        Human walter = new Human("Walter White", R.drawable.walter, "+91-9020241491");
        Human bruce = new Human("Bruce Wayne", R.drawable.bruce, "+91-8900456711");
        Human rachel = new Human("Rachel Zane", R.drawable.rachel, "+91-8977897723");
        Human annalise = new Human("Annalise Keating", R.drawable.annalise, "+91-8979870899");
        Human phoebe = new Human("Phoebe Buffay", R.drawable.phoebe, "+91-7789065543");
        Human harvey = new Human("Harvey Specter", R.drawable.harvey, "+91-8987898799");
        Human sherlock = new Human("Sherlock Holmes", R.drawable.sherlock, "+91-9899938411");

        List<Human> contacts_list = new ArrayList<Human>();
        contacts_list.add(sheldon);
        contacts_list.add(walter);
        contacts_list.add(bruce);
        contacts_list.add(rachel);
        contacts_list.add(annalise);
        contacts_list.add(phoebe);
        contacts_list.add(harvey);
        contacts_list.add(sherlock);


        LinearLayout contactsContainer = (LinearLayout)findViewById(R.id.contacts_container);

        for (Human h: contacts_list) {
            RelativeLayout rl = (RelativeLayout)getLayoutInflater().inflate(R.layout.contact, null);
            final String contact_number = h.getContact();
            rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact_number));
                    startActivity(intent);
                }
            });
            TextView name = (TextView)rl.findViewById(R.id.name);
            name.setText(h.getName());
            TextView number = (TextView)rl.findViewById(R.id.number);
            number.setText(h.getContact());
            ImageView contactDP = (ImageView)rl.findViewById(R.id.contact_image);
            contactDP.setImageResource(h.getImageId());
            contactsContainer.addView(rl);
        }
    }

}
