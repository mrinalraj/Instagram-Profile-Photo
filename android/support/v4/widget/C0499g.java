package android.support.v4.widget;

import android.widget.ListView;

public class C0499g extends C0482a {
    private final ListView f1245f;

    public C0499g(ListView listView) {
        super(listView);
        this.f1245f = listView;
    }

    public void mo381a(int i, int i2) {
        C0500h.m2421a(this.f1245f, i2);
    }

    public boolean mo382e(int i) {
        return false;
    }

    public boolean mo383f(int i) {
        ListView listView = this.f1245f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
