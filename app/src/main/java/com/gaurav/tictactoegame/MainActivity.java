package com.gaurav.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText plyr1;
    public EditText plyr2;

    public Spinner difficulty;
    public CharSequence player1 = "Player 1";
    public CharSequence player2 = "Player 2";

    public CharSequence cloneplayer2;
    boolean player1ax = true;
    boolean selectedSinglePlayer;
    String selectedPlayerClicked="";
    boolean easy = true;
    boolean medium = false;
    boolean hard = false;
    boolean impossible = false;
    public CheckBox p1x, p1o, p2x, p2o, singleplayer, twoplayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

        plyr1 = (EditText) findViewById(R.id.playerone);
        plyr2 = (EditText) findViewById(R.id.playertwo);

        singleplayer = (CheckBox) findViewById(R.id.splayer);
        twoplayer = (CheckBox) findViewById(R.id.tplayer);

        singleplayer.setOnClickListener(checkboxClickListener);
        twoplayer.setOnClickListener(checkboxClickListener);

        plyr1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                player1 = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        plyr2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                player2 = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    View.OnClickListener checkboxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean checked = ((CheckBox) view).isChecked();
            if (checked) {
                switch (view.getId()) {

                    case R.id.splayer:
                        twoplayer.setChecked(false);
                        selectedSinglePlayer = true;
                        cloneplayer2 = player2;
                        plyr2.setText("CPU");
                        selectedPlayerClicked="true";
                        plyr1.setImeOptions(EditorInfo.IME_ACTION_DONE);
                        plyr1.setImeActionLabel("DONE", EditorInfo.IME_ACTION_DONE);


                        //difficulty.setEnabled(true);
                        break;
                    case R.id.tplayer:
                        singleplayer.setChecked(false);
                        selectedSinglePlayer = false;
                        selectedPlayerClicked="true";
                        plyr2.setText(cloneplayer2);
                        plyr1.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                        plyr1.setImeActionLabel("NEXT", EditorInfo.IME_ACTION_NEXT);
                        //difficulty.setEnabled(false);
                        break;
                }

            } else {
                switch (view.getId()) {

                    case R.id.splayer:
                        twoplayer.setChecked(true);
                        selectedSinglePlayer = false;
                        selectedPlayerClicked="true";
                        plyr2.setText(cloneplayer2);
                      //  difficulty.setEnabled(false);
                        plyr1.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                        plyr1.setImeActionLabel("NEXT", EditorInfo.IME_ACTION_NEXT);
                        break;
                    case R.id.tplayer:
                        singleplayer.setChecked(true);
                        selectedSinglePlayer = true;
                        selectedPlayerClicked="true";
                        plyr2.setText("CPU");
                        plyr1.setImeOptions(EditorInfo.IME_ACTION_DONE);
                        plyr1.setImeActionLabel("DONE", EditorInfo.IME_ACTION_DONE);
                        //difficulty.setEnabled(true);
                        break;
                }

            }

        }
    };

    public void startgame(View view) {

        if(selectedPlayerClicked.equalsIgnoreCase("true")){


        if (!selectedSinglePlayer)
            if (player2.length() == 0)
                player2 = "player 2";
        if (player1.length() == 0)
            player1 = "player 1";

        CharSequence[] players = {player1, player2};
        Intent i = new Intent(this, GameLogicPage.class);
        i.putExtra("easy", easy);
        i.putExtra("medium", medium);
        i.putExtra("hard", hard);
        i.putExtra("impossible", impossible);
        i.putExtra("playersnames", players);
        i.putExtra("player1ax", player1ax);
        i.putExtra("selectedsingleplayer", selectedSinglePlayer);
        startActivity(i);
        }else {
           // Toast.makeText(this, "Please Choose the Single Player or Two Player to Proceed", Toast.LENGTH_SHORT).show();
            String Info = "Please Choose the Single Player or Two Player to Proceed";
            ShowInfoAlert(Info);
        }
    }

    private void ShowInfoAlert(String info) {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.info_alert);
        dialog.setCancelable(false);

        dialog.show();

        final Button Okay = dialog.findViewById(R.id.ok_button);
        final TextView Msg = dialog.findViewById(R.id.info_msg);
        Msg.setText(info);
        Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dialog.dismiss();
            }
        });

    }


}