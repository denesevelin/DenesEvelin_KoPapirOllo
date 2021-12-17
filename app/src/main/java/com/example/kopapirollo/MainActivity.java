package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonRock, buttonPaper, buttonScissors;
    private ImageView imageYou, imageComputer;
    private TextView textResultYouNumber, textResultComputerNumber;
    private Random random;
    private int randomNumber;
    private int youScores = 0;
    private int computerScores = 0;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        buttonRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView img = (ImageView) findViewById(R.id.imageYou);
                img.setImageResource(R.drawable.rock);
                random();

                if (randomNumber == 2){
                    Toast.makeText(MainActivity.this, "Ezt a kört a számítógép nyerte", Toast.LENGTH_SHORT).show();
                    computerScores++;
                    textResultComputerNumber.setText(String.valueOf(computerScores));
                }else if (randomNumber == 3){
                    Toast.makeText(MainActivity.this, "Ezt a kört te nyerted", Toast.LENGTH_SHORT).show();
                    youScores++;
                    textResultYouNumber.setText(String.valueOf(youScores));
                } else {
                    Toast.makeText(MainActivity.this, "Ez a kör döntetlen", Toast.LENGTH_SHORT).show();
                }
                finalResult();
            }
        });

        buttonPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView img = (ImageView) findViewById(R.id.imageYou);
                img.setImageResource(R.drawable.paper);
                random();

                if (randomNumber == 3){
                    Toast.makeText(MainActivity.this, "Ezt a kört a számítógép nyerte", Toast.LENGTH_SHORT).show();
                    computerScores++;
                    textResultComputerNumber.setText(String.valueOf(computerScores));
                }else if (randomNumber == 1){
                    Toast.makeText(MainActivity.this, "Ezt a kört te nyerted", Toast.LENGTH_SHORT).show();
                    youScores++;
                    textResultYouNumber.setText(String.valueOf(youScores));
                } else {
                    Toast.makeText(MainActivity.this, "Ez a kör döntetlen", Toast.LENGTH_SHORT).show();
                }
                finalResult();
            }
        });

        buttonScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView img = (ImageView) findViewById(R.id.imageYou);
                img.setImageResource(R.drawable.scissors);
                random();
                if (randomNumber == 1){
                    Toast.makeText(MainActivity.this, "Ezt a kört a számítógép nyerte", Toast.LENGTH_SHORT).show();
                    computerScores++;
                    textResultComputerNumber.setText(String.valueOf(computerScores));
                }else if (randomNumber == 2){
                    Toast.makeText(MainActivity.this, "Ezt a kört te nyerted", Toast.LENGTH_SHORT).show();
                    youScores++;
                    textResultYouNumber.setText(String.valueOf(youScores));
                } else {
                    Toast.makeText(MainActivity.this, "Ez a kör döntetlen", Toast.LENGTH_SHORT).show();
                }
                finalResult();
            }
        });

    }

    public void init(){
        buttonRock = findViewById(R.id.buttonRock);
        buttonPaper = findViewById(R.id.buttonPaper);
        buttonScissors = findViewById(R.id.buttonScissors);
        imageYou = findViewById(R.id.imageYou);
        imageComputer = findViewById(R.id.imageComputer);
        textResultYouNumber = findViewById(R.id.textResultYouNumber);
        textResultComputerNumber = findViewById(R.id.textResultComputerNumber);
        AlertDialogCreate();

    }

    public void random(){
        random = new Random();
        randomNumber = random.nextInt(3)+1;
        switch (randomNumber){
            case 1:
                imageComputer.setImageResource(R.drawable.rock);
                break;
            case 2:
                imageComputer.setImageResource(R.drawable.paper);
                break;
            case 3:
                imageComputer.setImageResource(R.drawable.scissors);
                break;
        }
    }

    private void finalResult(){
        if (youScores == 3){
            alertDialog.setTitle("Győzelem");
            alertDialog.create();
            alertDialog.show();

        }else if (computerScores == 3){
            alertDialog.setTitle("Vereség");
            alertDialog.create();
            alertDialog.show();
        }
    }

    public void AlertDialogCreate(){
        alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setMessage("Szeretne új játékot járszani?");
        alertDialog.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                finish();
            }
        });
        alertDialog.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                reset();
            }
        });
        alertDialog.setCancelable(false); //új kód
    }

    public void reset(){
        randomNumber = random.nextInt(3)+1;
        youScores = 0;
        computerScores = 0;
        textResultYouNumber.setText(String.valueOf(youScores));
        textResultComputerNumber.setText(String.valueOf(computerScores));

    }
}