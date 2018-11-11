package tech.zebrabg.roadsigns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleCardGroupA extends AppCompatActivity {

    Button next;
    Button previous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_card_groupa);



        final Intent intent = getIntent();
        final int position = intent.getIntExtra("position", 0);

        ItemTemplateAllCardsGroupA exampleItem = DataCollection
                .getData(this)
                .get(position);


        int imageRes = exampleItem.getImageResource();
        String line1 = exampleItem.getTextTitle();
        String line2 = exampleItem.getmTextDescription();

        ImageView imageView = findViewById(R.id.image_activity2);
        imageView.setImageResource(imageRes);

        TextView textView1 = findViewById(R.id.text1_activity2);
        textView1.setText(line1);

        TextView textView2 = findViewById(R.id.text2_activity2);
        textView2.setText(line2);

        Button next = (Button) findViewById(R.id.next);
        if(position == 0) {
            next.setText("КЪМ A2");
        }
        if(position == 1){
            next.setText("КЪМ A3");
        }
        if(position == 2){
            next.setText("КЪМ A4");
        }
        if(position == 3){
            next.setText("КЪМ A5");
        }
        if(position == 4){
            next.setText("КЪМ A6");
        }
        if(position == 5){
            next.setText("КЪМ A7");
        }
        if(position == 6){
            next.setText("КЪМ A8");
        }
        if(position == 7){
            next.setText("КЪМ A9");
        }if(position == 8){
            next.setText("КЪМ A10");
        }
        if(position == 9) {
            next.setText("КЪМ A1");
        }

        Button previous = (Button) findViewById(R.id.previous);
        if(position == 0) {
            previous.setText("КЪМ A10");
        }
        if(position == 1){
            previous.setText("КЪМ A1");
        }
        if(position == 2){
            previous.setText("КЪМ A2");
        }
        if(position == 3){
            previous.setText("КЪМ A3");
        }
        if(position == 4){
            previous.setText("КЪМ A4");
        }
        if(position == 5){
            previous.setText("КЪМ A5");
        }
        if(position == 6){
            previous.setText("КЪМ A6");
        }
        if(position == 7){
            previous.setText("КЪМ A7");
        }if(position == 8){
            previous.setText("КЪМ A8");
        }
        if(position == 9) {
            previous.setText("КЪМ A9");
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleCardGroupA.this, SingleCardGroupA.class);
                if (position <= 8) {
                    intent.putExtra("position", position + 1);
                    startActivity(intent);
                } else
                    intent.putExtra("position", 0);
                startActivity(intent);

            }

        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleCardGroupA.this, SingleCardGroupA.class);
                if (position >= 1) {
                    intent.putExtra("position", position - 1);
                    startActivity(intent);
                    finish();

                } else
                    intent.putExtra("position", 9);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);


            }

        });
    }
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(SingleCardGroupA.this,AllCardsGroupA.class);
        startActivity(intent);
        finish();

    }
}
