
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
    private int startCount;
    private int count;
    private int stepNumber;

    /**
     * @param context
     * @param list Lawyer Array List
     * @param startCount the initial number of views to show
     * @param stepNumber the number of additional views to show with each expansion
     */
    public CustomLawyerAdapter(Activity context, ArrayList<Lawyer> list, int startCount, int stepNumber) {
        super(context, R.layout.lawyerdetails, list);
        this.context = context;
        this.list = list;
        this.startCount = Math.min(startCount, list.size());
        this.count = this.startCount;
        this.stepNumber = stepNumber;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.lawyerdetails, null, true);

        TextView name_txt = (TextView) rowView.findViewById(R.id.lawyerName);
        name_txt.setText(list.get(position).getName());

        TextView expertise_txt = (TextView) rowView.findViewById(R.id.lawyerExpertise);
        ArrayList<String> expertiseList = new ArrayList<String>();
        if(list.get(position).getNotary().equals("true")) {
            expertiseList.add("Notary");
        }
        if(list.get(position).getProperty().equals("true")) {
            expertiseList.add("Property");
        }
        if(list.get(position).getDivorce().equals("true")) {
            expertiseList.add("Divorce");
        }
        if(list.get(position).getMatrimonial().equals("true")) {
            expertiseList.add("Matrimonial");
        }
        if(list.get(position).getCriminal().equals("true")) {
            expertiseList.add("Criminal");
        }
        if(list.get(position).getFamily().equals("true")) {
            expertiseList.add("Family");
        }
        if(list.get(position).getCivil().equals("true")) {
            expertiseList.add("Civil");
        }
        if(list.get(position).getConsumer().equals("true")) {
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

        /*Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        rowView.startAnimation(animation);
        lastPosition = position;*/

        return rowView;
    }

    /**
     * Show more views, or the bottom
     * @return true if the entire data set is being displayed, false otherwise
     */
    public boolean showMore(){
        if(count == list.size()) {
            return true;
        }else{
            count = Math.min(count + stepNumber, list.size()); //don't go past the end
            notifyDataSetChanged(); //the count size has changed, so notify the super of the change
            return endReached();
        }
    }

    /**
     * @return true if then entire data set is being displayed, false otherwise
     */
    public boolean endReached(){
        return count == list.size();
    }

    /**
     * Sets the ListView back to its initial count number
     */
    public void reset(){
        count = startCount;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return count;
    }
}

