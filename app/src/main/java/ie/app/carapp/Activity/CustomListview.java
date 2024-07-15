package ie.app.carapp.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ie.app.carapp.R;
import ie.app.carapp.models.Car;


public class CustomListview extends ArrayAdapter<Car>{


    private Context        context;
    public List<Car>        cars = null;
    private ArrayList<Car> arrayList;



    public CustomListview(Context context, ArrayList<Car> cars) {
        super(context, R.layout.layout, cars);
        this.context = context;
        this.cars = cars;

    }
    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Car getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        }

        TextView Cmodel = convertView.findViewById(R.id.textViewModel);
        TextView Ccolour = convertView.findViewById(R.id.textViewColour);
        TextView CYear = convertView.findViewById(R.id.textViewYear);
        TextView CMake = convertView.findViewById(R.id.textViewMake);

        final Car s= (Car) this.getItem(position);

        Cmodel.setText(s.getCarname());
        Ccolour.setText(s.getCarColour());
        CYear.setText(s.getCarYear());
        CMake.setText(s.getCarMake());


        return convertView;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        cars.clear();
        if (charText.length() == 0) {
            cars.addAll(arrayList);
        }
        else{

            for (Car cl : arrayList)
            {
                if (cl.getCarname().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    cars.add(cl);
                }
            }
        }
        notifyDataSetChanged();
        }

    }


