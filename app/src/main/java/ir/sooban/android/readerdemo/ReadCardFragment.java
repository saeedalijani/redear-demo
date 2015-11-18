package ir.sooban.android.readerdemo;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/**
 * Created by rajabzz on 7/7/15.
 */
public class ReadCardFragment extends Fragment {


    private int frequency = 44100;
    private int channelConfiguration = AudioFormat.CHANNEL_IN_MONO;
    private int audioEncoding = AudioFormat.ENCODING_PCM_16BIT;
    private int bufferSize;
    private AudioRecord audioRecord;
    private int silenceLevel = 500; //arbitrary level below which we consider "silent"
    private int minLevel = silenceLevel; //adaptive minimum level, should vary with each swipe.
    private double smoothing = 0.1;
    private double minLevelCoeff = 0.5;
    private boolean recording = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        IntentFilter receiverFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
//        HeadsetStateReceiver receiver = new HeadsetStateReceiver();
//        getActivity().registerReceiver(receiver, receiverFilter);

        bufferSize = AudioRecord.getMinBufferSize(frequency, channelConfiguration, audioEncoding)*2;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/irsans.ttf");
        View v = inflater.inflate(R.layout.read_card_fragment, container, false);

        TextView textView = (TextView) v.findViewById(R.id.read_card_textView);
        textView.setTypeface(typeface);

        TextView errorTextView = (TextView) v.findViewById(R.id.read_card_errorTextView);
        errorTextView.setTypeface(typeface);
        errorTextView.setVisibility(View.INVISIBLE);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                monitor();
//            }
//        }, 500);
        new ListenTask().execute();
    }

    private void startRecording() {
        if (audioRecord == null)
            audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
                    frequency, channelConfiguration,
                    audioEncoding, bufferSize);

        audioRecord.startRecording();
        recording = true;
    }

    private void monitor() {
        short[] buffer = new short[bufferSize];
        boolean silent = true;
        short bufferVal;
        boolean effectivelySilent;
        startRecording();
        int found;
        int quorum = 5; //number of non-silent samples to find before we begin recording.
        int bufferReadResult = 0;
        while(silent && recording){
            bufferReadResult = audioRecord.read(buffer, 0, bufferSize);
            found = 0;
            for (int i = 0; i < bufferReadResult; i++){
                bufferVal = buffer[i];
                //debug(TAG, "monitor val:"+bufferVal+", found:"+found);
                effectivelySilent =Math.abs(bufferVal) < silenceLevel;
                if (silent && !effectivelySilent){
                    found++;
                    if (found > quorum){
                        silent = false;
                    }
                }else{ //need non-silent samples to be next to each other.
                    found = 0;
                }
            }
        }
        if (!silent){
            recordData(buffer, bufferReadResult);
//            int timeInMilliSec = 1500;
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if (audioRecord != null) {
//                        audioRecord.stop();
//                        audioRecord.release();
//                        audioRecord = null;
//                    }
//                    Intent i = new Intent(getActivity(), EnterPassActivity.class);
//                    startActivity(i);
//
//                }
//            }, timeInMilliSec);
        }
    }

    private void recordData(short[] initialBuffer, int initialBufferSize){
        Message msg = Message.obtain();
        // Create a DataOutputStream to write the audio data
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        short bufferVal;
        short[] buffer = new short[bufferSize];
        boolean effectivelySilent;
        int silenceAtEndThreshold = frequency; //get one second of (near) silence
        int silentSamples = 0;
        int maxSamples = frequency * 10;
        int totalSamples = 0;
        boolean done = false; //have we recorded 1 second of silence
        int bufferReadResult = 0;
        try{
            //copy stuff from intialBuffer to dos.
            for (int i = 0; i < initialBufferSize; i++){
                dos.writeShort(initialBuffer[i]);
            }
            int nonSilentAtEndFound = 0;
            int quorum = 5;
            while(!done && recording && totalSamples < maxSamples){
                bufferReadResult = audioRecord.read(buffer, 0, bufferSize);
                for (int i = 0; i < bufferReadResult; i++){
                    bufferVal = buffer[i];
                    effectivelySilent =Math.abs(bufferVal) < silenceLevel;
                    dos.writeShort(buffer[i]);
                    if (effectivelySilent){
                        nonSilentAtEndFound = 0;
                        silentSamples++;
                        if (silentSamples > silenceAtEndThreshold){
                            done = true;
                        }
                    }else{
                        nonSilentAtEndFound++;
                        if (nonSilentAtEndFound > quorum){ //filter out noise blips
                            silentSamples = 0;
                        }
                    }
                    totalSamples++;
                }

            }
            dos.close();

            Intent i = new Intent(getActivity(), EnterPassActivity.class);
            startActivity(i);

            if (!recording){
                return;
            }

            //reportResult(processData(getSamples(audioBytes)));

        }catch(Exception e){
            e.printStackTrace();
            stopRecording();
        }

    }

    private void stopRecording(){
        if (audioRecord != null){
            audioRecord.stop();
            audioRecord.release();
            audioRecord = null;
        }
        recording = false;
    }

    private class ListenTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            monitor();
            return null;
        }
    }
}
