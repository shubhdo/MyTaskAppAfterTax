package user.shubham.mytaskapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Top extends Fragment {

   EditText amount;
    EditText person;
 TextView result;
    public Top() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_top, container, false);
        amount= (EditText) view.findViewById(R.id.editText);
        person= (EditText) view.findViewById(R.id.editText2);
        result= (TextView) view.findViewById(R.id.textView3);

        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final String amount1=amount.getText().toString();
                final String person1 = person.getText().toString();
                    int amountText= Integer.parseInt(amount1);
                if (!person1.equals("")) {
                    int personText= Integer.parseInt(person1);

                    String display = "Rs " + (float) amountText / personText + " per person";
                    result.setText(display);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
              }
        });
person.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        final String amount1=amount.getText().toString();
        final String person1 = person.getText().toString();
        int amountText= Integer.parseInt(amount1);
        if (!person1.equals("")) {
            int personText= Integer.parseInt(person1);

            String display = "Rs " + (float) amountText / personText + " per person";
            result.setText(display);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});



        return view ;
    }




}
