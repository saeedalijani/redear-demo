package ir.sooban.android.readerdemo.model;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by rajabzz on 7/9/15.
 */
public class Password {
    public static String JSON_PASS = "pass";
    private static final String FILENAME = "crimes.json";

    private String mFilename;
    private static Password mInstance;

    private String mPass;
    private Context mAppContext;

    public static Password getInstance(Context context, String pass) {
        if (mInstance == null) {
            mInstance = new Password(context, pass);
        }

        return mInstance;
    }

    private Password(Context c, String newPass) {
        mPass = newPass;
        mAppContext = c.getApplicationContext();
    }

    public void setPass(String pass) {
        this.mPass = pass;
    }

    public String getPass() {
        return mPass;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_PASS, mPass);
        return json;
    }

    public void savePass()
            throws JSONException, IOException {
        JSONObject jsonObject = this.toJSON();
        Writer writer = null;
        try {
            OutputStream out = mAppContext
                    .openFileOutput(mFilename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(jsonObject.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    @Override
    public String toString() {
        return mPass;
    }
}
