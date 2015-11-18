package ir.sooban.android.readerdemo;

import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ir.sooban.android.readerdemo.model.Service;
import ir.sooban.android.readerdemo.model.ServiceLab;

public class ServicesListFragment extends ListFragment {
    private ArrayList<Service> mServices;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mServices = ServiceLab.getInstance(getActivity()).getServices();
        ServiceAdapter adapter = new ServiceAdapter(mServices);
        setListAdapter(adapter);

    }

    private class ServiceAdapter extends ArrayAdapter<Service> {

        public ServiceAdapter(ArrayList<Service> services) {
            super(getActivity(), 0, services);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.service_list_item, null);
            }

            Service s = getItem(position);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.service_list_item_textView);
            titleTextView.setText(s.getTitle());
            Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");
            titleTextView.setTypeface(typeface);
            return convertView;
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Service s = ((ServiceAdapter)getListAdapter()).getItem(position);

        switch (s.getId()) {
            case ServiceLab.SERVICE_ID_BALANCE:

                break;

            case ServiceLab.SERVICE_ID_LAST_TRANSACTION:

                break;

            case ServiceLab.SERVICE_ID_TRANSFER:
                Intent transferIntent = new Intent(getActivity(), MoneyTransferActivity.class);
                startActivity(transferIntent);
                break;

            case ServiceLab.SERVICE_ID_PAY_BILLS:

                break;

            case ServiceLab.SERVICE_ID_BUY_CHARGE:

                break;

            case ServiceLab.SERVICE_ID_CHANGE_PASS:
                Intent changePassIntent = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivity(changePassIntent);
                break;
        }
    }
}
