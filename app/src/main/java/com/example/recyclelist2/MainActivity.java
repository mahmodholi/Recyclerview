package com.example.recyclelist2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements StoneAdapter.ItemSelected{

    private Button button;
    private TextView textView;
    private RecyclerView recyclerView;
    private StoneAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Stone> stones;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initImgArray();
        initStonesArray();
        myAdapter=new StoneAdapter(MainActivity.this,stones);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setAdapter(myAdapter);
            }
        });
    }

    private void initImgArray() {
        images=new int[6];
        images[0]=R.drawable.aliceinbordeland;
        images[1]=R.drawable.breakingbad;
        images[2]=R.drawable.strangerthings;
        images[3]=R.drawable.prisonbreak;
        images[4]=R.drawable.vikings;
        images[5]=R.drawable.wensday;
    }

    private void initViews() {
        button=findViewById(R.id.btnShowList);
        recyclerView=findViewById(R.id.list);
        textView=findViewById(R.id.txtDetails);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initStonesArray() {
        stones=new ArrayList<>();
        String[] st=new String[6];
        st[0]="alice in bordeland";
        st[1]="braking bad" ;
        st[2]= "stranger things";
        st[3]="prison break" ;
        st[4]="vikings" ;
        st[5]= "wensday";
        for (String s:st)
        {
            stones.add(new Stone(s));
        }
        for (int i=0;i<images.length;i++
        ) {
            stones.get(i).setImg(images[i]);
        }

    }

    @Override
    public void onItemClicked(int Index) {
        String[] Details=new String[6];
        Details[0]="Synopsis Arisu—a listless, jobless and video-game-obsessed young man—suddenly finds himself in a strange, emptied-out version of Tokyo in which he and his friends must compete in dangerous games in order to survive. In this strange world, Arisu meets Usagi, a young woman who's navigating the games alone";
        Details[1]= "Breaking Bad follows Walter White, a struggling, frustrated high school chemistry teacher from Albuquerque, New Mexico who becomes a crime lord in the local methamphetamine drug trade, driven to provide for his family financially after being diagnosed with inoperable lung cancer.";
        Details[2]= " Set in the 1980s, the series centers around the residents of the fictional small town of Hawkins, Indiana, as they are plagued by a hostile alternate dimension known as the Upside Down, after a nearby human experimentation facility opens a gateway between Earth and the Upside Down.";
        Details[3]= " Lincoln Burrows is convicted of a murder he did not commit, and now he is awaiting his execution on Fox River Prison. Michael Schofield, his only brother will do anything to get him out. By deliberately causing a crime that will get Michael put on the same prison as his brother, he plans to break them both out.";
        Details[4]= "The Vikings were raiders, pirates, traders, explorers, and colonizers during the 9th to 11th century. They often traveled by sea from Scandinavia and took control of areas of Europe and beyond.";
        Details[5]= " Follows Wednesday Addams' years as a student, when she attempts to master her emerging psychic ability, thwart a killing spree, and solve the mystery that embroiled her parents. A sleuthing, supernaturally infused mystery charting Wednesday Addams' years as a student at Nevermore Academy";
        textView.setText(Details[Index]);
        Intent intent;
        intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("place",Index);
        startActivity(intent);
    }
}