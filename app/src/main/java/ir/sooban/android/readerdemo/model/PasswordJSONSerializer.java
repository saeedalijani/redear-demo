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
public class PasswordJSONSerializer {
    private Context mContext;
    private String mFilename;
    public PasswordJSONSerializer(Context c, String f) {
        mContext = c;
        mFilename = f;
    }

    public void saveCrimes(Password pass)
            throws JSONException, IOException {
        JSONObject jsonObject = pass.toJSON();
        Writer writer = null;
        try {
            OutputStream out = mContext
                    .openFileOutput(mFilename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(jsonObject.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
