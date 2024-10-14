package com.example.recyclelist2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private String[] Details;
    private ImageView img;
    private TextView textView;
    private String[] detals2;
    private int[] images2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent() ;
        int index = intent.getIntExtra("place", 0);
        initTextArray();
        initImgArray();
        textView=findViewById(R.id.textView);
        textView.setText(textView.getText().toString()+index);
        img=findViewById(R.id.imageView2);
        for (int i=0;i<6;i++){
            if(i==index){
                img.setImageResource(images2[i]);
                textView.setText(Details[i]);
            }
        }
    }
    private void initImgArray() {
        images2=new int[6];
        images2[0]=R.drawable.aliceinbordeland;
        images2[1]=R.drawable.breakingbad;
        images2[2]=R.drawable.strangerthings;
        images2[3]=R.drawable.prisonbreak;
        images2[4]=R.drawable.vikings;
        images2[5]=R.drawable.wensday;
    }
    private void initTextArray(){
         Details=new String[6];
        Details[0]="Synopsis Arisu—a listless, jobless and video-game-obsessed young man—suddenly finds himself in a strange, emptied-out version of Tokyo in which he and his friends must compete in dangerous games in order to survive. In this strange world, Arisu meets Usagi, a young woman who's navigating the games alone";
        Details[1]= "Breaking Bad follows Walter White, a struggling, frustrated high school chemistry teacher from Albuquerque, New Mexico who becomes a crime lord in the local methamphetamine drug trade, driven to provide for his family financially after being diagnosed with inoperable lung cancer.";
        Details[2]= " Set in the 1980s, the series centers around the residents of the fictional small town of Hawkins, Indiana, as they are plagued by a hostile alternate dimension known as the Upside Down, after a nearby human experimentation facility opens a gateway between Earth and the Upside Down.";
        Details[3]= " Lincoln Burrows is convicted of a murder he did not commit, and now he is awaiting his execution on Fox River Prison. Michael Schofield, his only brother will do anything to get him out. By deliberately causing a crime that will get Michael put on the same prison as his brother, he plans to break them both out.";
        Details[4]= "The Vikings were raiders, pirates, traders, explorers, and colonizers during the 9th to 11th century. They often traveled by sea from Scandinavia and took control of areas of Europe and beyond.";
        Details[5]= " Follows Wednesday Addams' years as a student, when she attempts to master her emerging psychic ability, thwart a killing spree, and solve the mystery that embroiled her parents. A sleuthing, supernaturally infused mystery charting Wednesday Addams' years as a student at Nevermore Academy";
    }

}