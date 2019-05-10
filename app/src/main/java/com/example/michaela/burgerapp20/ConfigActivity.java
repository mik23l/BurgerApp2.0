package com.example.michaela.burgerapp20;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ConfigActivity extends AppCompatActivity {

    ImageView profileImage;
    RadioButton male;
    RadioButton female;
    EditText age_y;
    EditText weight_lb;
    EditText height_f;
    EditText height_in;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        profileImage=(ImageView)findViewById(R.id.profileImage);
        male=(RadioButton)findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);
        age_y=(EditText)findViewById(R.id.age_y);
        weight_lb=(EditText)findViewById(R.id.weight_lb);
        height_f=(EditText)findViewById(R.id.height_f);
        height_in=(EditText)findViewById(R.id.height_in);
        update=(Button)findViewById(R.id.update);
    }

    protected void onProfileImage(View view) {
        showPictureDialog();
    }

    private void showPictureDialog() {
        AlertDialog.Builder picureDialog = new AlertDialog.Builder(this);
        picureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {"Select from gallery", "Capture from camera"};
        picureDialog.setItems(pictureDialogItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        fromGallery();
                        break;
                    case 1:
                        takePhoto();
                        break;
                }
            }
        });
        picureDialog.show();
    }

    static int GALLERY;
    public void fromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        galleryIntent.setType("image/*");
        CAMERA = 0;
        GALLERY = 1;
        startActivityForResult(galleryIntent, GALLERY);
    }

    static int CAMERA;
    protected void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        CAMERA = 1;
        GALLERY = 0;
        startActivityForResult(intent, CAMERA);
    }

    Bitmap profileImageBitmap = null;
    Bitmap profileGall = null;

    Uri pickedImage = null;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            profileImageBitmap = (Bitmap) extras.get("data");
            profileImage.setImageBitmap(profileImageBitmap);
        }
        else if (requestCode == GALLERY && resultCode == RESULT_OK) {
            pickedImage = data.getData();
            InputStream inputStream;
            try {
                inputStream = getContentResolver().openInputStream(pickedImage);
                profileGall = BitmapFactory.decodeStream(inputStream);
                profileImage.setImageBitmap(profileGall);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    String genderStr = "";
    String ageStr = "";
    String weightStr = "";
    String heightFStr = "";
    String heightIStr = "";

    public void onGender(View view) {
        if(view.getId() == male.getId()) {
            genderStr = "male";
        }
        else if (view.getId() == female.getId()) {
            genderStr = "female";
        }
    }

    protected void onUpdate(View view) {
        ageStr=age_y.getText().toString();
        weightStr=weight_lb.getText().toString();
        heightFStr=height_f.getText().toString();
        heightIStr=height_in.getText().toString();
        finish();
    }

    @Override
    public void finish() {
        if (genderStr.equals("")||ageStr.equals("") || weightStr.equals("") || heightFStr.equals("") || heightIStr.equals("")) {
            Toast.makeText(this,"Please update your information", Toast.LENGTH_LONG).show();
        }
        else if (Integer.parseInt(ageStr) < 1 || Integer.parseInt(ageStr) > 115) {
            Toast.makeText(this,"Please enter a valid age", Toast.LENGTH_LONG).show();
        }
        else if (Integer.parseInt(weightStr) < 1) {
            Toast.makeText(this,"Please enter a valid weight", Toast.LENGTH_LONG).show();
        }
        else if (Integer.parseInt(heightFStr) < 1 || Integer.parseInt(heightFStr) > 10) {
            Toast.makeText(this,"Please enter a valid height", Toast.LENGTH_LONG).show();
        }
        else {
            Intent data = new Intent();
            data.putExtra(SummaryActivity.GENDER, genderStr);
            data.putExtra(SummaryActivity.AGE, ageStr);
            data.putExtra(SummaryActivity.WEIGHT, weightStr);
            data.putExtra(SummaryActivity.HEIGHT_F, heightFStr);
            data.putExtra(SummaryActivity.HEIGHT_I, heightIStr);
            if (profileImageBitmap != null) {
                data.putExtra(SummaryActivity.PROFILE_TAKEN, profileImageBitmap);
            }
            else if (pickedImage != null) {
                data.putExtra(SummaryActivity.PROFILE_GALL,pickedImage.toString());
            }
            setResult(RESULT_OK, data);
            super.finish();
        }
    }
}
