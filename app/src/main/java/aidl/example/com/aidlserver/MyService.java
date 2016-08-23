package aidl.example.com.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import com.example.aidl.IMyAidlInterface;

public class MyService extends Service {

    public class MyServiceImpl extends IMyAidlInterface.Stub {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
                               double aDouble, String aString) throws RemoteException {

        }

        public String helloAndroidAIDL(String name) throws RemoteException {
            Log.d("aidl", "helloAndroidAIDL heard from : " + name);
            return "Rust: Service01 return value successfully!";
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyServiceImpl();// 返回内部类实例
    }
}