package com.geek.ugadai;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastClass extends Toast {
    Context context;
    public ToastClass(Context context) {
        super(context);
        this.context = context;
    }
   public void showToast(String text){
       Toast toast;
       toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
       toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
       toast.show();
   }
}
