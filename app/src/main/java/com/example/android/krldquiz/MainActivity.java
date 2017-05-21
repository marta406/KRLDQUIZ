package com.example.android.krldquiz;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.textOff;
import static android.R.attr.textOn;
import static android.R.attr.x;
import static com.example.android.krldquiz.R.id.songbunRB;

public class MainActivity extends AppCompatActivity {
    /**
     * This variable contains number of points, for each question user can gain 1 point.
     */
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * @return overall points that user gained.
     */
    public int checkAnswerSystem() {
        points = 0;
        RadioButton songbunRB = (RadioButton) findViewById(R.id.songbunRB);
        /**
         * If statement that checks if user gave a right answer to question about ascribed status system.
         */
        if (songbunRB.isChecked()) {
            points++;
        }
/**
 * If statement that that checks if user gave a right answer to question about flag.
 */
        RadioButton northKoreaFlagRB = (RadioButton) findViewById(R.id.northKoreaFlagRB);
        if (northKoreaFlagRB.isChecked()) {
            points++;
        }
/**
 * If statement that checks if user gave a right answer to question about capital city.
 */
        RadioButton pyongyangRB = (RadioButton) findViewById(R.id.pyongyangRB);
        if (pyongyangRB.isChecked()) {
            points++;
        }
/**
 * If statement that checks if user gave a right answer to question about rivers. It gives 1 point only when user check both - Tumen and Yalu.
 */
        if (isCheckedYaluRiver() && isCheckedTumenRiver() && !(isCheckedGeumRiver()) && !(isCheckedNakdongRiver())) {
            points++;
        }
/**
 * If statement that checks if user gave a right answer to question about supreme leader.
 */
        if (!(isSwitchOff())) {
            points++;
        }
/**
 * If statement that checks if user gave a right answer to question about year of death of Kim Jong-il.
 */
        if (dateOfDeath().equals("2011")) {
            points++;
        }

        return points;
    }

    /**
     * @param number contain a number of points.
     * Method that display message in a certain TextView with id scoreSummary. Message is different depend of score that user obtained and number of stars he/she gave for this quiz.
     */
    public void display(int number) {
        TextView textView = (TextView) findViewById(R.id.scoreSummary);
        if (points >= 5) {
            textView.setText(getString(R.string.summary2) + number + "/6" + getString(R.string.great) + "\n" + getString(R.string.rated) + stars() + "/3");
        } else {
            textView.setText(getString(R.string.summary2) + number + "/6" + "\n" + getString(R.string.rated) + stars() + "/3");
        }
    }

    /**
     * Method that will run when button "submit" is clicked. It will check number of points, display it in a TextView and in a short Toast Message.
     */
    public void submit(View view) {
        points = checkAnswerSystem();
        display(points);
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.summary2) + points + "/6";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * @return year that user typed in question about year of death of Kim Jong-il.
     **/
    public String dateOfDeath() {
        EditText editText = (EditText) findViewById(R.id.questionAboutYear);
        String date = editText.getText().toString();
        return date;
    }

    /**
     * @return answer true/false - depend on users choice. True when radiobutton with id "r1" is checked.
     **/
    public boolean isCheckedYaluRiver() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.yaluRiver);
        boolean a = checkBox.isChecked();
        return a;
    }

    /**
     * @return answer true/false - depend on users choice. True when radiobutton with id "tumenRiver" is checked.
     **/
    public boolean isCheckedTumenRiver() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.tumenRiver);
        boolean b = checkBox.isChecked();
        return b;
    }

    /**
     * @return answer true/false - depend on users choice. True when radiobutton with id "nakdongRiver" is checked.
     **/
    public boolean isCheckedNakdongRiver() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.nakdongRiver);
        boolean c = checkBox.isChecked();
        return c;
    }

    /**
     * @return answer true/false - depend on users choice. True when radiobutton with id "geumRiver" is checked.
     **/
    public boolean isCheckedGeumRiver() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.geumRiver);
        boolean d = checkBox.isChecked();
        return d;
    }

    /**
     * @return answer true/false - depend on users choice. True when switch is off.
     **/
    public boolean isSwitchOff() {
        Switch aSwitch = (Switch) findViewById(R.id.president);
        boolean e = aSwitch.isChecked();
        return e;
    }

    /**
     * @return number of stars that user gave to this quiz.
     **/
    public int stars() {
        RatingBar stars = (RatingBar) findViewById(R.id.stars);
        float numberOfStars = stars.getRating();
        int numberOfStarsInt = Math.round(numberOfStars);
        return numberOfStarsInt;
    }
}




