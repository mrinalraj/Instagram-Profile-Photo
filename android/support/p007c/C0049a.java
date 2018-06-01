package android.support.p007c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class C0049a {
    private static final Set<File> f137a = new HashSet();
    private static final boolean f138b = C0049a.m135a(System.getProperty("java.vm.version"));

    private static final class C0046a {
        private static Object[] m120a(Object obj, ArrayList<File> arrayList, File file) {
            return (Object[]) C0049a.m138b(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
        }

        private static void m121b(ClassLoader classLoader, List<? extends File> list, File file) {
            Object obj = C0049a.m137b(classLoader, "pathList").get(classLoader);
            C0049a.m139b(obj, "dexElements", C0046a.m120a(obj, new ArrayList(list), file));
        }
    }

    private static final class C0047b {
        private static Object[] m123a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            return (Object[]) C0049a.m138b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }

        private static void m124b(ClassLoader classLoader, List<? extends File> list, File file) {
            Object obj = C0049a.m137b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            C0049a.m139b(obj, "dexElements", C0047b.m123a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Object obj2;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field a = C0049a.m137b(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr = (IOException[]) a.get(obj);
                if (iOExceptionArr == null) {
                    obj2 = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    Object obj3 = new IOException[(arrayList.size() + iOExceptionArr.length)];
                    arrayList.toArray(obj3);
                    System.arraycopy(iOExceptionArr, 0, obj3, arrayList.size(), iOExceptionArr.length);
                    obj2 = obj3;
                }
                a.set(obj, obj2);
            }
        }
    }

    private static final class C0048c {
        private static void m126b(ClassLoader classLoader, List<? extends File> list) {
            int size = list.size();
            Field a = C0049a.m137b(classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) a.get(classLoader));
            Object[] objArr = new String[size];
            Object[] objArr2 = new File[size];
            Object[] objArr3 = new ZipFile[size];
            Object[] objArr4 = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                stringBuilder.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                objArr[previousIndex] = absolutePath;
                objArr2[previousIndex] = file;
                objArr3[previousIndex] = new ZipFile(file);
                objArr4[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            a.set(classLoader, stringBuilder.toString());
            C0049a.m139b((Object) classLoader, "mPaths", objArr);
            C0049a.m139b((Object) classLoader, "mFiles", objArr2);
            C0049a.m139b((Object) classLoader, "mZips", objArr3);
            C0049a.m139b((Object) classLoader, "mDexs", objArr4);
        }
    }

    private static File m127a(Context context, File file, String str) {
        File file2 = new File(file, "code_cache");
        try {
            C0049a.m132a(file2);
        } catch (IOException e) {
            file2 = new File(context.getFilesDir(), "code_cache");
            C0049a.m132a(file2);
        }
        File file3 = new File(file2, str);
        C0049a.m132a(file3);
        return file3;
    }

    public static void m130a(Context context) {
        Log.i("MultiDex", "Installing application");
        if (f138b) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
        } else if (VERSION.SDK_INT < 4) {
            throw new RuntimeException("MultiDex installation failed. SDK " + VERSION.SDK_INT + " is unsupported. Min SDK version is " + 4 + ".");
        } else {
            try {
                ApplicationInfo b = C0049a.m136b(context);
                if (b == null) {
                    Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                C0049a.m131a(context, new File(b.sourceDir), new File(b.dataDir), "secondary-dexes", "");
                Log.i("MultiDex", "install done");
            } catch (Throwable e) {
                Log.e("MultiDex", "MultiDex installation failure", e);
                throw new RuntimeException("MultiDex installation failed (" + e.getMessage() + ").");
            }
        }
    }

    private static void m131a(Context context, File file, File file2, String str, String str2) {
        synchronized (f137a) {
            if (f137a.contains(file)) {
                return;
            }
            f137a.add(file);
            if (VERSION.SDK_INT > 20) {
                Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + VERSION.SDK_INT + ": SDK version higher than " + 20 + " should be backed by " + "runtime with built-in multidex capabilty but it's not the " + "case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
            }
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (classLoader == null) {
                    Log.e("MultiDex", "Context class loader is null. Must be running in test mode. Skip patching.");
                    return;
                }
                try {
                    C0049a.m140c(context);
                } catch (Throwable th) {
                    Log.w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
                }
                File a = C0049a.m127a(context, file2, str);
                C0049a.m133a(classLoader, a, C0053c.m144a(context, file, a, str2, false));
            } catch (Throwable e) {
                Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e);
            }
        }
    }

    private static void m132a(File file) {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }

    private static void m133a(ClassLoader classLoader, File file, List<? extends File> list) {
        if (!list.isEmpty()) {
            if (VERSION.SDK_INT >= 19) {
                C0047b.m124b(classLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                C0046a.m121b(classLoader, list, file);
            } else {
                C0048c.m126b(classLoader, list);
            }
        }
    }

    static boolean m135a(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        Log.i("MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    private static ApplicationInfo m136b(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (Throwable e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    private static Field m137b(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    private static Method m138b(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static void m139b(Object obj, String str, Object[] objArr) {
        Field b = C0049a.m137b(obj, str);
        Object[] objArr2 = (Object[]) b.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b.set(obj, objArr3);
    }

    private static void m140c(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                }
            }
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
            }
        }
    }
}
