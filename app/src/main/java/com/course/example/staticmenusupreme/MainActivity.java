package com.course.example.staticmenusupreme;

import androidx.appcompat.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.image);
        img.setImageResource(R.drawable.trek);

        registerForContextMenu(img);

        //show logo on action bar and hide title
        ActionBar actionBar = getSupportActionBar();          //create ActionBar object
        actionBar.setLogo(R.drawable.droid);           //set logo
        actionBar.setDisplayUseLogoEnabled(true);      //allow logo to be displayed
        actionBar.setDisplayShowHomeEnabled(true);     //allow app icon on Action Bar
        actionBar.setDisplayShowTitleEnabled(false);  //app title not shown

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu2, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Uri uri;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.web:
                uri = Uri.parse("http://www.bentley.edu");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                return true;

            case R.id.maps:
                uri = Uri.parse("geo:0,0?q=175 Forest Street waltham ma");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);}
                return true;

            case R.id.dialer:
                uri = Uri.parse("tel:7818912000");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                return true;

            case R.id.email:
                uri = Uri.parse("mailto:hbentley@bentley.edu");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                return true;

            case R.id.save:
                //noop
                return true;

            case R.id.exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Uri uri;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.web:
                uri = Uri.parse("http://www.bentley.edu");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                return true;

            case R.id.maps:
                uri = Uri.parse("geo:0,0?q=175 Forest Street waltham ma");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);}
                return true;

            case R.id.dialer:
                uri = Uri.parse("tel:7818912000");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                return true;

            case R.id.email:
                uri = Uri.parse("mailto:hbentley@bentley.edu");
                startActivity(new Intent(Intent.ACTION_SENDTO, uri));
                return true;

            case R.id.save:
                //noop
                return true;

            case R.id.exit:
                finish();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}