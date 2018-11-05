package android.com.onetoonechat;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends AppCompatActivity {

    // https://stackoverflow.com/questions/5068711/how-we-can-display-pound-and-euro-symbol-in-android-textview
    String euro = "\u20ac";

    String pound = "\u00a3";

//    tvAmount.setText(euro);
//   tvCurrency.setText(pound);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);


        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("Hello" + euro);
//        textView2.setPaintFlags(textView2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

//        textView2.setBackground(getResources().getDrawable(R.drawable.test));


        // textview left middle and end color

//        final SpannableString text = new SpannableString("Hello stackOverflow");
//        text.setSpan(new RelativeSizeSpan(1.5f), text.length() - "stackOverflow".length(), text.length(),
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        text.setSpan(new ForegroundColorSpan(Color.RED), 3, text.length() - 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        textView2.setText(text);


        SpannableString styledString

                = new SpannableString("Large\n\n"     // index 0 - 5
                + "Bold\n\n"          // index 7 - 11
                + "Underlined\n\n"    // index 13 - 23
                + "Italic\n\n"        // index 25 - 31
                + "Strikethrough\n\n" // index 33 - 46
                + "Colored\n\n"       // index 48 - 55
                + "Highlighted\n\n"   // index 57 - 68
                + "K Superscript\n\n" // "Superscript" index 72 - 83
                + "K Subscript\n\n"   // "Subscript" index 87 - 96
                + "Url\n\n"           //  index 98 - 101
                + "Clickable\n\n");   // index 103 - 112


        // make the text twice as large
        styledString.setSpan(new RelativeSizeSpan(2f), 0, 5, 0);

        // make text bold
        styledString.setSpan(new StyleSpan(Typeface.BOLD), 7, 11, 0);

        // underline text
        styledString.setSpan(new UnderlineSpan(), 13, 23, 0);

        // make text italic
        styledString.setSpan(new StyleSpan(Typeface.ITALIC), 25, 31, 0);

        styledString.setSpan(new StrikethroughSpan(), 33, 46, 0);

        // change text color
        styledString.setSpan(new ForegroundColorSpan(Color.GREEN), 48, 55, 0);

        // highlight text
        styledString.setSpan(new BackgroundColorSpan(Color.CYAN), 57, 68, 0);

        // superscript
        styledString.setSpan(new SuperscriptSpan(), 72, 83, 0);
        // make the superscript text smaller
        styledString.setSpan(new RelativeSizeSpan(0.5f), 72, 83, 0);

        // subscript
        styledString.setSpan(new SubscriptSpan(), 87, 96, 0);
        // make the subscript text smaller
        styledString.setSpan(new RelativeSizeSpan(0.5f), 87, 96, 0);

        // url
        styledString.setSpan(new URLSpan("http://www.google.com"), 98, 101, 0);

        // clickable text
        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                // We display a Toast. You could do anything you want here.
                Toast.makeText(Test.this, "Clicked", Toast.LENGTH_SHORT).show();

            }
        };

        styledString.setSpan(clickableSpan, 103, 112, 0);


        // Give the styled string to a TextView
        TextView textView = new TextView(this);

        // this step is mandated for the url and clickable styles.
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        // make it neat
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.WHITE);

        textView.setText(styledString);

        setContentView(textView);


    }
}
