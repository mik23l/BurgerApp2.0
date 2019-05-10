package com.example.michaela.burgerapp20;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class SummaryActivity extends AppCompatActivity {

    public static final String GENDER = "gender";
    public static final String AGE = "age";
    public static final String WEIGHT = "weight";
    public static final String HEIGHT_F = "height_f";
    public static final String HEIGHT_I = "height_i";
    public static final String PROFILE_TAKEN = "profile_t";
    public static final String PROFILE_GALL = "profil_g";

    ImageView chickenItem;
    ImageView chickjrItem;
    ImageView spicychickItem;
    ImageView cheeseburgItem;
    ImageView doubcheeseItem;
    ImageView bcncheeseItem;
    ImageView bcndoubcheeseItem;
    ImageView friesItem;
    ImageView onionrItem;
    ImageView vanillaItem;
    ImageView cokeItem;
    ImageView dietcokeItem;
    ImageView drpepItem;
    ImageView spriteItem;
    ImageView iceeItem;

    TextView chickenDes;
    TextView chickjrDes;
    TextView spicychickDes;
    TextView cheeseburgDes;
    TextView doubcheeseDes;
    TextView bcncheeseDes;
    TextView bcndoubcheeseDes;
    TextView friesDes;
    TextView onionrDes;
    TextView vanillaDes;
    TextView cokeDes;
    TextView dietcokeDes;
    TextView drpepDes;
    TextView spriteDes;
    TextView iceeDes;

    TextView chickenCal;
    TextView chickjrCal;
    TextView spicychickCal;
    TextView cheeseburgCal;
    TextView doubcheeseCal;
    TextView bcncheeseCal;
    TextView bcndoubcheeseCal;
    TextView friesCal;
    TextView onionrCal;
    TextView vanillaCal;
    TextView cokeCal;
    TextView dietcokeCal;
    TextView drpepCal;
    TextView spriteCal;
    TextView iceeCal;

    TextView gender;
    TextView age;
    TextView weight;
    TextView height;
    TextView bmr;
    TextView ordercals;
    TextView suggcals;
    TextView moreless;
    ImageView profilePic;

    String chicken;
    String chickjr;
    String spicychick;
    String cheeseburg;
    String doubcheese;
    String bcncheese;
    String bcndoubcheese;
    String fries;
    String onionr;
    String vanilla;
    String coke;
    String dietcoke;
    String drpep;
    String sprite;
    String icee;

    int totalordercal=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        chickenItem=(ImageView)findViewById(R.id.chickenItem);
        chickjrItem=(ImageView)findViewById(R.id.chickjrItem);
        spicychickItem=(ImageView)findViewById(R.id.spicychickItem);
        cheeseburgItem=(ImageView)findViewById(R.id.cheeseburgItem);
        doubcheeseItem=(ImageView)findViewById(R.id.doubcheeseItem);
        bcncheeseItem=(ImageView)findViewById(R.id.bcncheeseItem);
        bcndoubcheeseItem=(ImageView)findViewById(R.id.bcndoubcheeseItem);
        friesItem=(ImageView)findViewById(R.id.friesItem);
        onionrItem=(ImageView)findViewById(R.id.onionrItem);
        vanillaItem=(ImageView)findViewById(R.id.vanillaItem);
        cokeItem=(ImageView)findViewById(R.id.cokeItem);
        dietcokeItem=(ImageView)findViewById(R.id.dietcokeItem);
        drpepItem=(ImageView)findViewById(R.id.drpepItem);
        spriteItem=(ImageView)findViewById(R.id.spriteItem);
        iceeItem=(ImageView)findViewById(R.id.iceeItem);

        chickenDes=(TextView)findViewById(R.id.chickenDes);
        chickjrDes=(TextView)findViewById(R.id.chickjrDes);
        spicychickDes=(TextView)findViewById(R.id.spicychickDes);
        cheeseburgDes=(TextView)findViewById(R.id.cheeseburgDes);
        doubcheeseDes=(TextView)findViewById(R.id.doubcheeseDes);
        bcncheeseDes=(TextView)findViewById(R.id.bcncheeseDes);
        bcndoubcheeseDes=(TextView)findViewById(R.id.bcndoubcheeseDes);
        friesDes=(TextView)findViewById(R.id.friesDes);
        onionrDes=(TextView)findViewById(R.id.onionrDes);
        vanillaDes=(TextView)findViewById(R.id.vanillaDes);
        cokeDes=(TextView)findViewById(R.id.cokeDes);
        dietcokeDes=(TextView)findViewById(R.id.dietcokeDes);
        drpepDes=(TextView)findViewById(R.id.drpepDes);
        spriteDes=(TextView)findViewById(R.id.spriteDes);
        iceeDes=(TextView)findViewById(R.id.iceeDes);

        chickenCal=(TextView)findViewById(R.id.chickenCal);
        chickjrCal=(TextView)findViewById(R.id.chickjrCal);
        spicychickCal=(TextView)findViewById(R.id.spicychickCal);
        cheeseburgCal=(TextView)findViewById(R.id.cheeseburgCal);
        doubcheeseCal=(TextView)findViewById(R.id.doubcheeseCal);
        bcncheeseCal=(TextView)findViewById(R.id.bcncheeseCal);
        bcndoubcheeseCal=(TextView)findViewById(R.id.bcndoubcheeseCal);
        friesCal=(TextView)findViewById(R.id.friesCal);
        onionrCal=(TextView)findViewById(R.id.onionrCal);
        vanillaCal=(TextView)findViewById(R.id.vanillaCal);
        cokeCal=(TextView)findViewById(R.id.cokeCal);
        dietcokeCal=(TextView)findViewById(R.id.dietcokeCal);
        drpepCal=(TextView)findViewById(R.id.drpepCal);
        spriteCal=(TextView)findViewById(R.id.spriteCal);
        iceeCal=(TextView)findViewById(R.id.iceeCal);

        gender=(TextView)findViewById(R.id.gender);
        age=(TextView)findViewById(R.id.age);
        weight=(TextView)findViewById(R.id.weight);
        height=(TextView)findViewById(R.id.height);
        bmr=(TextView)findViewById(R.id.bmr);
        ordercals=(TextView)findViewById(R.id.ordercals);
        suggcals=(TextView)findViewById(R.id.suggcals);
        moreless=(TextView)findViewById(R.id.moreless);
        profilePic=(ImageView)findViewById(R.id.profilePic);

        Intent intent = getIntent();
        chicken = intent.getStringExtra("chickenVal");
        chickjr = intent.getStringExtra("chickjrVal");
        spicychick = intent.getStringExtra("spicychickVal");
        cheeseburg = intent.getStringExtra("cheeeseburgVal");
        doubcheese = intent.getStringExtra("doubcheeseVal");
        bcncheese = intent.getStringExtra("bcncheeseVal");
        bcndoubcheese = intent.getStringExtra("bcndoubcheeseVal");
        fries = intent.getStringExtra("friesVal");
        onionr = intent.getStringExtra("onionrVal");
        vanilla = intent.getStringExtra("vanillaVal");
        coke = intent.getStringExtra("cokeVal");
        dietcoke = intent.getStringExtra("dietcokeVal");
        drpep = intent.getStringExtra("drpepVal");
        sprite = intent.getStringExtra("spriteVal");
        icee = intent.getStringExtra("iceeVal");

        if (chicken.equals("yes")) {
            chickenItem.setVisibility(View.VISIBLE);
            chickenDes.setVisibility(View.VISIBLE);
            chickenCal.setVisibility(View.VISIBLE);
            totalordercal += 170;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (chickjr.equals("yes")) {
            chickjrItem.setVisibility(View.VISIBLE);
            chickjrDes.setVisibility(View.VISIBLE);
            chickjrCal.setVisibility(View.VISIBLE);
            totalordercal += 450;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (spicychick.equals("yes")) {
            spicychickItem.setVisibility(View.VISIBLE);
            spicychickDes.setVisibility(View.VISIBLE);
            spicychickCal.setVisibility(View.VISIBLE);
            totalordercal += 390;
            ordercals.setText(Integer.toString(totalordercal));
        }

        if (cheeseburg.equals("yes")) {
            cheeseburgItem.setVisibility(View.VISIBLE);
            cheeseburgDes.setVisibility(View.VISIBLE);
            cheeseburgCal.setVisibility(View.VISIBLE);
            totalordercal += 280;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (doubcheese.equals("yes")) {
            doubcheeseItem.setVisibility(View.VISIBLE);
            doubcheeseDes.setVisibility(View.VISIBLE);
            doubcheeseCal.setVisibility(View.VISIBLE);
            totalordercal += 390;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (bcncheese.equals("yes")) {
            bcncheeseItem.setVisibility(View.VISIBLE);
            bcncheeseDes.setVisibility(View.VISIBLE);
            bcncheeseCal.setVisibility(View.VISIBLE);
            totalordercal += 320;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (bcndoubcheese.equals("yes")) {
            bcndoubcheeseItem.setVisibility(View.VISIBLE);
            bcndoubcheeseDes.setVisibility(View.VISIBLE);
            bcndoubcheeseCal.setVisibility(View.VISIBLE);
            totalordercal += 400;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (fries.equals("yes")) {
            friesItem.setVisibility(View.VISIBLE);
            friesDes.setVisibility(View.VISIBLE);
            friesCal.setVisibility(View.VISIBLE);
            totalordercal += 380;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (onionr.equals("yes")) {
            onionrItem.setVisibility(View.VISIBLE);
            onionrDes.setVisibility(View.VISIBLE);
            onionrCal.setVisibility(View.VISIBLE);
            totalordercal += 150;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (vanilla.equals("yes")) {
            vanillaItem.setVisibility(View.VISIBLE);
            vanillaDes.setVisibility(View.VISIBLE);
            vanillaCal.setVisibility(View.VISIBLE);
            totalordercal += 140;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (coke.equals("yes")) {
            cokeItem.setVisibility(View.VISIBLE);
            cokeDes.setVisibility(View.VISIBLE);
            cokeCal.setVisibility(View.VISIBLE);
            totalordercal += 140;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (dietcoke.equals("yes")) {
            dietcokeItem.setVisibility(View.VISIBLE);
            dietcokeDes.setVisibility(View.VISIBLE);
            dietcokeCal.setVisibility(View.VISIBLE);
            totalordercal += 0;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (drpep.equals("yes")) {
            drpepItem.setVisibility(View.VISIBLE);
            drpepDes.setVisibility(View.VISIBLE);
            drpepCal.setVisibility(View.VISIBLE);
            totalordercal += 140;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (sprite.equals("yes")) {
            spriteItem.setVisibility(View.VISIBLE);
            spriteDes.setVisibility(View.VISIBLE);
            spriteCal.setVisibility(View.VISIBLE);
            totalordercal += 140;
            ordercals.setText(Integer.toString(totalordercal));
        }
        if (icee.equals("yes")) {
            iceeItem.setVisibility(View.VISIBLE);
            iceeDes.setVisibility(View.VISIBLE);
            iceeCal.setVisibility(View.VISIBLE);
            totalordercal += 110;
            ordercals.setText(Integer.toString(totalordercal));
        }
        onCalculate();
    }

    static final int UPDATE_REQUEST_CODE = 1;
    protected void onUpdate (View view) {
        Intent updateIntent = new Intent(this, ConfigActivity.class);
        startActivityForResult(updateIntent, UPDATE_REQUEST_CODE);
    }

    String up_gender = "female";
    String up_age = "22";
    String up_weight = "123";
    String up_heightf = "5";
    String up_heighti = "3";

    Bitmap profile_taken = null;
    Bitmap profile_pick = null;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UPDATE_REQUEST_CODE && resultCode == RESULT_OK) {
            up_gender=data.getStringExtra(SummaryActivity.GENDER);
            up_age=data.getStringExtra(SummaryActivity.AGE);
            up_weight=data.getStringExtra(SummaryActivity.WEIGHT);
            up_heightf=data.getStringExtra(SummaryActivity.HEIGHT_F);
            up_heighti=data.getStringExtra(SummaryActivity.HEIGHT_I);
            profile_taken=data.getParcelableExtra(SummaryActivity.PROFILE_TAKEN);

            String image_path = data.getStringExtra(SummaryActivity.PROFILE_GALL);

            if (profile_taken != null) {
                profilePic.setImageBitmap(profile_taken);
            }
            else if (image_path != null) {
                Uri pickedImage = Uri.parse(image_path);
                InputStream inputStream;
                try {
                    inputStream = getContentResolver().openInputStream(pickedImage);
                    profile_pick = BitmapFactory.decodeStream(inputStream);
                    profilePic.setImageBitmap(profile_pick);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            gender.setText(up_gender);
            age.setText(up_age);
            weight.setText(up_weight + " lb");
            height.setText(up_heightf + "' " + up_heighti + "\"");

            onCalculate();
        }
    }

    protected void onCalculate() {
        int eatcal;

        double weigh_kg = ((Double.valueOf(up_weight))*0.453592)*10;
        double heighF_cm = (Double.valueOf(up_heightf))*30.48;
        double heighI_cm = (Double.valueOf(up_heighti))*2.54;
        double heigh_total = (heighF_cm + heighI_cm)*6.25;
        double age_y = (Double.valueOf(up_age))*5;

        double BMR_f = (weigh_kg) + (heigh_total) - (age_y) - 161;
        double BMR_m = (weigh_kg) + (heigh_total) - (age_y) + 5;

        int bmr_f = Integer.valueOf((int) Math.round(BMR_f));
        int bmr_m = Integer.valueOf((int) Math.round(BMR_m));

        if (up_gender.equals("female")) {
            bmr.setText(Integer.toString(bmr_f));

            eatcal = bmr_f - totalordercal;
            if (eatcal > 0) {
                suggcals.setText(Integer.toString(eatcal) + " ");
                moreless.setText("more");
            }
            else if (eatcal < 0) {
                eatcal = Math.abs(eatcal);
                suggcals.setText(Integer.toString(eatcal) + " ");
                moreless.setText("less");
            }
        }
        else if (up_gender.equals("male")) {
            bmr.setText(Integer.toString(bmr_m));

            eatcal = bmr_m - totalordercal;
            if (eatcal > 0) {
                suggcals.setText(Integer.toString(eatcal) + " ");
                moreless.setText("more");
            }
            else if (eatcal < 0) {
                eatcal = Math.abs(eatcal);
                suggcals.setText(Integer.toString(eatcal) + " ");
                moreless.setText("less");
            }
        }
    }
}
