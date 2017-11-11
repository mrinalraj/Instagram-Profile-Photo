package com.mrinalraj.instaprofilephoto.services;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.mrinalraj.instaprofilephoto.CToast;
import com.mrinalraj.instaprofilephoto.R;
import com.mrinalraj.instaprofilephoto.activity.search;
import com.txusballesteros.bubbles.BubbleLayout;
import com.txusballesteros.bubbles.BubblesManager;

/**
 * Created by mrinal on 11/12/2017.
 */

public class ClipBoardService extends Service {

    ClipboardManager clipMan;
    String[] words;
    private BubblesManager bubblesManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        bubblesManager = new BubblesManager.Builder(this)
                .setTrashLayout(R.layout.bubble_trash)
                .build();

        bubblesManager.initialize();
        clipMan = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        clipMan.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                clipboard();
            }
        });
        super.onCreate();
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public void clipboard(){
        ClipData clipData=clipMan.getPrimaryClip();
        if(clipData!=null && clipData.getItemAt(0)!=null) {
            ClipData.Item clipitem = clipData.getItemAt(0);
            String clipStringg = clipitem.getText().toString();
            String profileLink = "www.instagram.com/";
            String postLink = "www.instagram.com/p/";
            words = clipStringg.split("/");
            if (clipStringg.contains(profileLink) && !words[3].equals("p")) {
                BubbleLayout bubbleLayout = (BubbleLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.bubble_layout,null);
                bubbleLayout.setShouldStickToWall(true);
                bubblesManager.addBubble(bubbleLayout,0,60);
                final CToast toast = new CToast(getApplicationContext());
                toast.make("See Profile Photo");
                toast.show();

                bubbleLayout.setOnBubbleClickListener(new BubbleLayout.OnBubbleClickListener() {
                    @Override
                    public void onBubbleClick(BubbleLayout bubbleLayout) {
                        ClipData clipD = clipMan.getPrimaryClip();
                        clipD = ClipData.newPlainText("text", "");
                        clipMan.setPrimaryClip(clipD);
                        toast.cancel();
                        bubblesManager.removeBubble(bubbleLayout);
                        Intent search = new Intent(getApplicationContext(), search.class)
                                .putExtra("service",words[3].trim())
                                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(search);
                    }
                });
            }
        }
    }
}
