package android.example.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mscore1;
    private int mscore2;
    private TextView mscoreText1;
    private TextView mscoreText2;
    static final String State_Score_1 = "Team 1 Score";
    static final String State_Score_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the textviews by id
        mscoreText1=findViewById(R.id.score_1);
        mscoreText2=findViewById(R.id.score_2);
        if(savedInstanceState != null){
            mscore1 =savedInstanceState.getInt(State_Score_1);
            mscore2 =savedInstanceState.getInt(State_Score_2);

            //set the score text views
            mscoreText1.setText(String.valueOf(mscore1));
            mscoreText2.setText(String.valueOf(mscore2));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        //change the label of the menu based on the state  of the app
        int nightMode =AppCompatDelegate.getDefaultNightMode();
        if(nightMode ==AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode) {
            //get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //set the theme mode for the restarted activity
            if(nightMode ==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            }else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            //Recreate the activity for the theme to change
            recreate();
        }
        return true;
    }

    public void decreaseScore(View view) {
        //get the Id of the button that was clicked
        int viewID =view.getId();
        switch(viewID){
            case R.id.decreaseteam1:
                mscore1--;
                mscoreText1.setText(String.valueOf(mscore1));
                break;

            case R.id.decreaseteam2:
                mscore2--;
                mscoreText2.setText(String.valueOf(mscore2));
        }
    }

    public void increaseScore(View view) {
        //get the id
        int viewID =view.getId();
        switch(viewID){
            case R.id.increaseTeam1:
                mscore1++;
                mscoreText1.setText(String.valueOf(mscore1));
                break;

            case R.id.increaseTeam2:
                mscore2++;
                mscoreText2.setText(String.valueOf(mscore2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores.
        outState.putInt(State_Score_1,mscore1);
        outState.putInt(State_Score_2,mscore2);
        super.onSaveInstanceState(outState);

    }
}
