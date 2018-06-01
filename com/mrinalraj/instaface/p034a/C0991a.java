package com.mrinalraj.instaface.p034a;

import android.os.Bundle;
import android.support.v7.app.C0551c;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.joaquimley.faboptions.FabOptions;
import com.mrinalraj.instaface.R;

public class C0991a extends C0551c implements TextWatcher, OnClickListener, OnKeyListener {
    public EditText f3264m;
    public Button f3265n;
    public TextView f3266o;
    public TextView f3267p;
    public TextView f3268q;
    public FabOptions f3269r;

    public void m5250a(String str, String str2) {
        this.f3268q.setText(str);
        this.f3267p.setText(str2);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onClick(View view) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_search);
        this.f3265n = (Button) findViewById(R.id.search_btn);
        this.f3264m = (EditText) findViewById(R.id.search_text);
        this.f3266o = (TextView) findViewById(R.id.error);
        this.f3267p = (TextView) findViewById(R.id.description);
        this.f3268q = (TextView) findViewById(R.id.title_search);
        this.f3269r = (FabOptions) findViewById(R.id.fab_options);
        this.f3265n.setOnClickListener(this);
        this.f3264m.setSingleLine();
        this.f3264m.setOnKeyListener(this);
        this.f3264m.addTextChangedListener(this);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
