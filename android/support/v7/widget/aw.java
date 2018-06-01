package android.support.v7.widget;

import android.support.v7.widget.C0817f.C0816b;
import java.util.List;

class aw {
    final C0782a f2521a;

    interface C0782a {
        C0816b mo781a(int i, int i2, int i3, Object obj);

        void mo782a(C0816b c0816b);
    }

    public aw(C0782a c0782a) {
        this.f2521a = c0782a;
    }

    private void m4370a(List<C0816b> list, int i, int i2) {
        C0816b c0816b = (C0816b) list.get(i);
        C0816b c0816b2 = (C0816b) list.get(i2);
        switch (c0816b2.f2731a) {
            case 1:
                m4372c(list, i, c0816b, i2, c0816b2);
                return;
            case 2:
                m4374a(list, i, c0816b, i2, c0816b2);
                return;
            case 4:
                m4375b(list, i, c0816b, i2, c0816b2);
                return;
            default:
                return;
        }
    }

    private int m4371b(List<C0816b> list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((C0816b) list.get(size)).f2731a != 8) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }

    private void m4372c(List<C0816b> list, int i, C0816b c0816b, int i2, C0816b c0816b2) {
        int i3 = 0;
        if (c0816b.f2734d < c0816b2.f2732b) {
            i3 = -1;
        }
        if (c0816b.f2732b < c0816b2.f2732b) {
            i3++;
        }
        if (c0816b2.f2732b <= c0816b.f2732b) {
            c0816b.f2732b += c0816b2.f2734d;
        }
        if (c0816b2.f2732b <= c0816b.f2734d) {
            c0816b.f2734d += c0816b2.f2734d;
        }
        c0816b2.f2732b = i3 + c0816b2.f2732b;
        list.set(i, c0816b2);
        list.set(i2, c0816b);
    }

    void m4373a(List<C0816b> list) {
        while (true) {
            int b = m4371b(list);
            if (b != -1) {
                m4370a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    void m4374a(List<C0816b> list, int i, C0816b c0816b, int i2, C0816b c0816b2) {
        int i3;
        C0816b c0816b3;
        int i4 = 0;
        if (c0816b.f2732b < c0816b.f2734d) {
            i3 = (c0816b2.f2732b == c0816b.f2732b && c0816b2.f2734d == c0816b.f2734d - c0816b.f2732b) ? 1 : 0;
        } else if (c0816b2.f2732b == c0816b.f2734d + 1 && c0816b2.f2734d == c0816b.f2732b - c0816b.f2734d) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (c0816b.f2734d < c0816b2.f2732b) {
            c0816b2.f2732b--;
        } else if (c0816b.f2734d < c0816b2.f2732b + c0816b2.f2734d) {
            c0816b2.f2734d--;
            c0816b.f2731a = 2;
            c0816b.f2734d = 1;
            if (c0816b2.f2734d == 0) {
                list.remove(i2);
                this.f2521a.mo782a(c0816b2);
                return;
            }
            return;
        }
        if (c0816b.f2732b <= c0816b2.f2732b) {
            c0816b2.f2732b++;
            c0816b3 = null;
        } else if (c0816b.f2732b < c0816b2.f2732b + c0816b2.f2734d) {
            c0816b3 = this.f2521a.mo781a(2, c0816b.f2732b + 1, (c0816b2.f2732b + c0816b2.f2734d) - c0816b.f2732b, null);
            c0816b2.f2734d = c0816b.f2732b - c0816b2.f2732b;
        } else {
            c0816b3 = null;
        }
        if (i3 != 0) {
            list.set(i, c0816b2);
            list.remove(i2);
            this.f2521a.mo782a(c0816b);
            return;
        }
        if (i4 != 0) {
            if (c0816b3 != null) {
                if (c0816b.f2732b > c0816b3.f2732b) {
                    c0816b.f2732b -= c0816b3.f2734d;
                }
                if (c0816b.f2734d > c0816b3.f2732b) {
                    c0816b.f2734d -= c0816b3.f2734d;
                }
            }
            if (c0816b.f2732b > c0816b2.f2732b) {
                c0816b.f2732b -= c0816b2.f2734d;
            }
            if (c0816b.f2734d > c0816b2.f2732b) {
                c0816b.f2734d -= c0816b2.f2734d;
            }
        } else {
            if (c0816b3 != null) {
                if (c0816b.f2732b >= c0816b3.f2732b) {
                    c0816b.f2732b -= c0816b3.f2734d;
                }
                if (c0816b.f2734d >= c0816b3.f2732b) {
                    c0816b.f2734d -= c0816b3.f2734d;
                }
            }
            if (c0816b.f2732b >= c0816b2.f2732b) {
                c0816b.f2732b -= c0816b2.f2734d;
            }
            if (c0816b.f2734d >= c0816b2.f2732b) {
                c0816b.f2734d -= c0816b2.f2734d;
            }
        }
        list.set(i, c0816b2);
        if (c0816b.f2732b != c0816b.f2734d) {
            list.set(i2, c0816b);
        } else {
            list.remove(i2);
        }
        if (c0816b3 != null) {
            list.add(i, c0816b3);
        }
    }

    void m4375b(List<C0816b> list, int i, C0816b c0816b, int i2, C0816b c0816b2) {
        Object obj;
        Object obj2 = null;
        if (c0816b.f2734d < c0816b2.f2732b) {
            c0816b2.f2732b--;
            obj = null;
        } else if (c0816b.f2734d < c0816b2.f2732b + c0816b2.f2734d) {
            c0816b2.f2734d--;
            obj = this.f2521a.mo781a(4, c0816b.f2732b, 1, c0816b2.f2733c);
        } else {
            obj = null;
        }
        if (c0816b.f2732b <= c0816b2.f2732b) {
            c0816b2.f2732b++;
        } else if (c0816b.f2732b < c0816b2.f2732b + c0816b2.f2734d) {
            int i3 = (c0816b2.f2732b + c0816b2.f2734d) - c0816b.f2732b;
            obj2 = this.f2521a.mo781a(4, c0816b.f2732b + 1, i3, c0816b2.f2733c);
            c0816b2.f2734d -= i3;
        }
        list.set(i2, c0816b);
        if (c0816b2.f2734d > 0) {
            list.set(i, c0816b2);
        } else {
            list.remove(i);
            this.f2521a.mo782a(c0816b2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }
}
