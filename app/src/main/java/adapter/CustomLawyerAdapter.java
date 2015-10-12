
package adapter;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.LayoutInflater;


import com.example.istiaqhaq.legistify.R;

import java.util.ArrayList;

import model.Lawyer;


/**
 * Created by Istiaq Haq on 07-Oct-15.
 */

public class CustomLawyerAdapter extends ArrayAdapter<Lawyer> {
    private final Activity context;
    private final ArrayList<Lawyer> list;
    private int lastPosition = -1;

    public CustomLawyerAdapter(Activity context, ArrayList<Lawyer> list) {
        super(context, R.layout.lawyerdetails, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.lawyerdetails, null, true);

        TextView name_txt = (TextView) rowView.findViewById(R.id.lawyerName);
        name_txt.setText(list.get(position).getName());

        TextView expertise_txt = (TextView) rowView.findViewById(R.id.lawyerExpertise);
        ArrayList<String> expertiseList = new ArrayList<String>();
        if(list.get(position).getNotary() == "true") {
            expertiseList.add("Notary");
        }
        if(list.get(position).getProperty() == "true") {
            expertiseList.add("Property");
        }
        if(list.get(position).getDivorce() == "true") {
            expertiseList.add("Divorce");
        }
        if(list.get(position).getMatrimonial() == "true") {
            expertiseList.add("Matrimonial");
        }
        if(list.get(position).getCriminal() == "true") {
            expertiseList.add("Criminal");
        }
        if(list.get(position).getFamily() == "true") {
            expertiseList.add("Family");
        }
        if(list.get(position).getCivil() == "true") {
            expertiseList.add("Civil");
        }
        if(list.get(position).getConsumer() == "true") {
            expertiseList.add("Consumer");
        }

        String delimiter = "Lawyer For ";
        StringBuilder newString = new StringBuilder();
        for (String expertise : expertiseList) {
            newString.append(delimiter).append(expertise);
            delimiter = ", ";
        }

        expertise_txt.setText(newString);

        TextView contact_txt = (TextView) rowView.findViewById(R.id.lawyerContact);
        contact_txt.setText(list.get(position).getContact());

        TextView address_txt = (TextView) rowView.findViewById(R.id.lawyerAddress);
        address_txt.setText(list.get(position).getAddress() + ", " + list.get(position).getCity() + ", " + list.get(position).getState());

        Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        rowView.startAnimation(animation);
        lastPosition = position;

        return rowView;
    }
}

