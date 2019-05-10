package com.example.michaela.burgerapp20;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String chickenVal;
    public static String chickjrVal;
    public static String spicychickVal;
    public static String cheeeseburgVal;
    public static String doubcheeseVal;
    public static String bcncheeseVal;
    public static String bcndoubcheeseVal;
    public static String friesVal;
    public static String onionrVal;
    public static String vanillaVal;
    public static String cokeVal;
    public static String dietcokeVal;
    public static String drpepVal;
    public static String spriteVal;
    public static String iceeVal;

    CheckBox chickenCheck;
    CheckBox chickjrCheck;
    CheckBox spicychickCheck;
    CheckBox cheeeseburgCheck;
    CheckBox doubcheeseCheck;
    CheckBox bcncheeseCheck;
    CheckBox bcndoubcheeseCheck;
    CheckBox friesCheck;
    CheckBox onionrCheck;
    CheckBox vanillaCheck;
    CheckBox cokeCheck;
    CheckBox dietcokeCheck;
    CheckBox drpepCheck;
    CheckBox spriteCheck;
    CheckBox iceeCheck;

    Button tosummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chickenCheck=(CheckBox)findViewById(R.id.chickenCheck);
        chickjrCheck=(CheckBox)findViewById(R.id.chickjrCheck);
        spicychickCheck=(CheckBox)findViewById(R.id.spicychickCheck);
        cheeeseburgCheck=(CheckBox)findViewById(R.id.cheeseburgCheck);
        doubcheeseCheck=(CheckBox)findViewById(R.id.doubcheeseCheck);
        bcncheeseCheck=(CheckBox)findViewById(R.id.bcncheeseCheck);
        bcndoubcheeseCheck=(CheckBox)findViewById(R.id.bcndoubcheeseCheck);
        friesCheck=(CheckBox)findViewById(R.id.friesCheck);
        onionrCheck=(CheckBox)findViewById(R.id.onionrCheck);
        vanillaCheck=(CheckBox)findViewById(R.id.vanillaCheck);
        cokeCheck=(CheckBox)findViewById(R.id.cokeCheck);
        dietcokeCheck=(CheckBox)findViewById(R.id.dietcokeCheck);
        drpepCheck=(CheckBox)findViewById(R.id.drpepCheck);
        spriteCheck=(CheckBox)findViewById(R.id.spriteCheck);
        iceeCheck=(CheckBox)findViewById(R.id.iceeCheck);

        tosummary=(Button)findViewById(R.id.tosummary);
        tosummary.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SummaryActivity.class);
        if(chickenCheck.isChecked()) {
            intent.putExtra("chickenVal","yes");
        }
        else {
            intent.putExtra("chickenVal","no");
        }
        if(chickjrCheck.isChecked()) {
            intent.putExtra("chickjrVal","yes");
        }
        else {
            intent.putExtra("chickjrVal","no");
        }
        if(spicychickCheck.isChecked()) {
            intent.putExtra("spicychickVal","yes");
        }
        else {
            intent.putExtra("spicychickVal","no");
        }
        if(cheeeseburgCheck.isChecked()) {
            intent.putExtra("cheeeseburgVal","yes");
        }
        else {
            intent.putExtra("cheeeseburgVal","no");
        }
        if(doubcheeseCheck.isChecked()) {
            intent.putExtra("doubcheeseVal","yes");
        }
        else {
            intent.putExtra("doubcheeseVal","no");
        }
        if(bcncheeseCheck.isChecked()) {
            intent.putExtra("bcncheeseVal","yes");
        }
        else {
            intent.putExtra("bcncheeseVal","no");
        }
        if(bcndoubcheeseCheck.isChecked()) {
            intent.putExtra("bcndoubcheeseVal","yes");
        }
        else {
            intent.putExtra("bcndoubcheeseVal","no");
        }
        if(friesCheck.isChecked()) {
            intent.putExtra("friesVal","yes");
        }
        else {
            intent.putExtra("friesVal","no");
        }
        if(onionrCheck.isChecked()) {
            intent.putExtra("onionrVal","yes");
        }
        else {
            intent.putExtra("onionrVal","no");
        }
        if(vanillaCheck.isChecked()) {
            intent.putExtra("vanillaVal","yes");
        }
        else {
            intent.putExtra("vanillaVal","no");
        }
        if(cokeCheck.isChecked()) {
            intent.putExtra("cokeVal","yes");
        }
        else {
            intent.putExtra("cokeVal","no");
        }
        if(dietcokeCheck.isChecked()) {
            intent.putExtra("dietcokeVal","yes");
        }
        else {
            intent.putExtra("dietcokeVal","no");
        }
        if(drpepCheck.isChecked()) {
            intent.putExtra("drpepVal","yes");
        }
        else {
            intent.putExtra("drpepVal","no");
        }
        if(spriteCheck.isChecked()) {
            intent.putExtra("spriteVal","yes");
        }
        else {
            intent.putExtra("spriteVal","no");
        }
        if(iceeCheck.isChecked()) {
            intent.putExtra("iceeVal","yes");
        }
        else {
            intent.putExtra("iceeVal","no");
        }
        startActivity(intent);
    }

    protected void onOnlineMenu(View view) {
        String nugsURL="https://www.bk.com/menu-item/chicken-nuggets";
        String chickjrURL="https://www.bk.com/menu-item/chicken-jr";
        String spicyURL="https://www.bk.com/menu-item/spicy-chicken-jr";
        String cheeseURL="https://www.bk.com/menu-item/cheeseburger";
        String doubcheeURL="https://www.bk.com/menu-item/double-cheeseburger";
        String bcncheeURL="https://www.bk.com/menu-item/bacon-cheeseburger";
        String bcndoubURL="https://www.bk.com/menu-item/bacon-double-cheeseburger";
        String friesURL="https://www.bk.com/menu-item/french-fries";
        String onionURL="https://www.bk.com/menu-item/onion-rings";
        String vanilURL="https://www.bk.com/menu-item/vanilla-soft-serve";
        String cokeURL="https://www.bk.com/menu-item/coca-cola%C2%AE";
        String dietURL="https://www.bk.com/menu-item/diet-coke";
        String dpURL="https://www.bk.com/menu-item/dr-pepper";
        String spriteURL="https://www.bk.com/menu-item/sprite";
        String iceeURL="https://www.bk.com/menu-item/frozen-fanta-cherry-icee";

        Intent intent=new Intent(Intent.ACTION_VIEW);

        if(view.getId() == R.id.chickenImage) {
            intent.setData(Uri.parse(nugsURL));
        }
        else if(view.getId() == R.id.chickjrImage) {
            intent.setData(Uri.parse(chickjrURL));
        }
        else if(view.getId() == R.id.spicychickImage) {
            intent.setData(Uri.parse(spicyURL));
        }
        else if(view.getId() == R.id.cheeeseburgImage) {
            intent.setData(Uri.parse(cheeseURL));
        }
        else if(view.getId() == R.id.doubcheeseImage) {
            intent.setData(Uri.parse(doubcheeURL));
        }
        else if(view.getId() == R.id.bcncheeseImage) {
            intent.setData(Uri.parse(bcncheeURL));
        }
        else if(view.getId() == R.id.bcndoubcheeseImage) {
            intent.setData(Uri.parse(bcndoubURL));
        }
        else if(view.getId() == R.id.friesImage) {
            intent.setData(Uri.parse(friesURL));
        }
        else if(view.getId() == R.id.onionrImage) {
            intent.setData(Uri.parse(onionURL));
        }
        else if(view.getId() == R.id.vanillaImage) {
            intent.setData(Uri.parse(vanilURL));
        }
        else if(view.getId() == R.id.cokeImage) {
            intent.setData(Uri.parse(cokeURL));
        }
        else if(view.getId() == R.id.dietcokeImage) {
            intent.setData(Uri.parse(dietURL));
        }
        else if(view.getId() == R.id.drpepImage) {
            intent.setData(Uri.parse(dpURL));
        }
        else if(view.getId() == R.id.spriteImage) {
            intent.setData(Uri.parse(spriteURL));
        }
        else if(view.getId() == R.id.iceeImage) {
            intent.setData(Uri.parse(iceeURL));
        }
        startActivity(intent);
    }
}
