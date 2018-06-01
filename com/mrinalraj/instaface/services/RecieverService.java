package com.mrinalraj.instaface.services;

import android.content.Context;
import android.content.Intent;
import android.support.v4.p013b.C0273d;

public class RecieverService extends C0273d {
    public void onReceive(Context context, Intent intent) {
        C0273d.m1381a(context, new Intent(context, ClipBoardService.class));
    }
}
