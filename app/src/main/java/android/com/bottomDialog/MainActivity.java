package android.com.bottomDialog;

import android.com.onetoonechat.R;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.marcoscg.dialogsheet.DialogSheet;


public class MainActivity extends AppCompatActivity {


    private ImageView imageView2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_activity);


        imageView2 = findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DialogSheet(MainActivity.this)
                        .setTitle(R.string.app_name)
                        .setMessage("Shahzeb")
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.ok, new DialogSheet.OnPositiveClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Your action
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogSheet.OnNegativeClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Your action
                            }
                        })
                        .setBackgroundColor(Color.WHITE) // Your custom background color
                        .setButtonsColorRes(R.color.colorPrimary)  // Default color is accent
                        .show();

            }
        });

    }
}
