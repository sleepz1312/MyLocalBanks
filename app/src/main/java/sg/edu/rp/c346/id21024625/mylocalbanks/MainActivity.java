package sg.edu.rp.c346.id21024625.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button dbs;
    Button ocbc;
    Button uob;

    String buttonClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.buttonDBS);
        registerForContextMenu(dbs);
        ocbc = findViewById(R.id.buttonOCBC);
        registerForContextMenu(ocbc);
        uob = findViewById(R.id.buttonUOB);
        registerForContextMenu(uob);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");

        if(v == dbs) {
            buttonClicked = "dbs";
        } else if(v == ocbc) {
            buttonClicked = "ocbc";
        } else {
            buttonClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (buttonClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            } else if (item.getItemId() == 2) {
                boolean color = false;
                dbs.setTextColor(Integer.parseInt("red"));
                return true;

            } else if (buttonClicked.equalsIgnoreCase("ocbc")) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.ocbc.com"));
                    startActivity(intent);

                    return true; //menu item successfully handled
                } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                    //code for action
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                    startActivity(intentCall);

                    return true;  //menu item successfully handled
                } else if (item.getItemId() == 2) {
                    boolean color = false;
                    ocbc.setTextColor(Integer.parseInt("red"));
                    return true;
                }
            }else if (buttonClicked.equalsIgnoreCase("uob")) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.uob.com.sg"));
                    startActivity(intent);

                    return true; //menu item successfully handled
                } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                    //code for action
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                    startActivity(intentCall);
                }

                return true;  //menu item successfully handled
            } else if (item.getItemId() == 2) {
                boolean color = false;
                uob.setTextColor(Integer.parseInt("red"));
                return true;
            }

            return super.onContextItemSelected(item); //pass menu item to the superclass implementation
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;

        } else if (id == R.id.chineseSelection) {
            dbs.setText("????????????");
            ocbc.setText("????????????");
            uob.setText("????????????");
            return true;

        } else {
            dbs.setText("Error translation");
            ocbc.setText("Error translation");
            uob.setText("Error translation");

        }

        return super.onOptionsItemSelected(item);
    }
}