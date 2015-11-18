package ir.sooban.android.readerdemo.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

import ir.sooban.android.readerdemo.R;

/**
 * Created by rajabzz on 7/6/15.
 */
public class ServiceLab {

    public static final int SERVICE_ID_BALANCE = 0;
    public static final int SERVICE_ID_LAST_TRANSACTION = 1;
    public static final int SERVICE_ID_TRANSFER = 2;
    public static final int SERVICE_ID_PAY_BILLS = 3;
    public static final int SERVICE_ID_BUY_CHARGE = 4;
    public static final int SERVICE_ID_CHANGE_PASS = 5;


    private static ServiceLab instance;
    private Context mContext;
    private ArrayList<Service> mServices;

    private ServiceLab(Context c) {
        mContext = c;
        mServices = new ArrayList<>();

        addServicesToList();
    }

    public static ServiceLab getInstance(Context c) {
        if (instance == null) {
            instance = new ServiceLab(c.getApplicationContext());
        }
        return instance;
    }

    public ArrayList<Service> getServices() {
        return mServices;
    }

    public Service getService(int id) {
        for (Service service: mServices) {
            if (service.getId() == id)
                return service;
        }
        return null;
    }

    private void addServicesToList() {
        mServices.add(new Service(R.string.service_name_getBalance, SERVICE_ID_BALANCE));
        mServices.add(new Service(R.string.service_name_getLastTransactions, SERVICE_ID_LAST_TRANSACTION));
        mServices.add(new Service(R.string.service_name_transferMoney,  SERVICE_ID_TRANSFER));
        mServices.add(new Service(R.string.service_name_payBills,  SERVICE_ID_PAY_BILLS));
        mServices.add(new Service(R.string.service_name_buyCharge,  SERVICE_ID_BUY_CHARGE));
        mServices.add(new Service(R.string.service_name_changePass, SERVICE_ID_CHANGE_PASS));
    }
}
