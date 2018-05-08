<<<<<<< HEAD
package com.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import com.example.dan.chestnutegg.R;
import com.example.dan.chestnutegg.TicketActivity;
import com.service.SMSToDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Context.NOTIFICATION_SERVICE;

public class SMSBroadcastReceiver extends BroadcastReceiver {
    public SMSBroadcastReceiver() {
    }

    private static final String action = "android.provider.Telephony.SMS_RECEIVED";

    String mobile;
    String content;
    String time;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        if (intent.getAction().equals(action)) {

            Object[] pduses = (Object[]) intent.getExtras().get("pdus");
            mobile = "";
            content = "";
            time = "";
            System.out.println(pduses.length);
            for (Object pdus : pduses) {
                byte[] pdusmessage = (byte[]) pdus;
                SmsMessage sms = SmsMessage.createFromPdu(pdusmessage);
                mobile = sms.getOriginatingAddress();// 发送短信的手机号码
                content = sms.getMessageBody(); // 短信内容
                Date date = new Date(sms.getTimestampMillis());// 发送日期
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                time = format.format(date); // 得到发送时间
            }
            Toast.makeText(context, context.getResources().getString(R.string.app_name), Toast.LENGTH_LONG).show();
            String show = "发送者:" + mobile + " 内容:" + content + "      时间:" + time;
            Log.i("context",show);
            Toast.makeText(context, show, Toast.LENGTH_LONG).show();
        }
        //Log.e("TAG","拦截短信");

        abortBroadcast();

        sendSmsNotice(context,mobile,content);

        //service
        Intent intent_SMSToDatabase = new Intent(context, SMSToDatabase.class);
        intent_SMSToDatabase.putExtra("content", content);
        context.startService(intent_SMSToDatabase);
        //Log.i("service", "service begin: ");

    }


    public void sendSmsNotice(Context context, String mobile,String content){

        //点击通知进入ShortMessage这个activity
        Intent smsintent = new Intent(context,TicketActivity.class);
        Intent []i = new Intent[1];
        i[0] = smsintent;
        PendingIntent pi = PendingIntent.getActivities(context,0, i,0);

        //发送通知
        NotificationManager manager = (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("你收到"+mobile+"的短信")
                .setContentText(content)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi) //点击通知返回到activity
                .setAutoCancel(true) //点击通知后自动取消
                .build();
        manager.notify(1,notification);
    }

}
=======
package com.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import com.example.dan.chestnutegg.R;
import com.example.dan.chestnutegg.TicketActivity;
import com.service.SMSToDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Context.NOTIFICATION_SERVICE;

public class SMSBroadcastReceiver extends BroadcastReceiver {
    public SMSBroadcastReceiver() {
    }

    private static final String action = "android.provider.Telephony.SMS_RECEIVED";

    String mobile;
    String content;
    String time;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        if (intent.getAction().equals(action)) {

            Object[] pduses = (Object[]) intent.getExtras().get("pdus");
            mobile = "";
            content = "";
            time = "";
            System.out.println(pduses.length);
            for (Object pdus : pduses) {
                byte[] pdusmessage = (byte[]) pdus;
                SmsMessage sms = SmsMessage.createFromPdu(pdusmessage);
                mobile = sms.getOriginatingAddress();// 发送短信的手机号码
                content = sms.getMessageBody(); // 短信内容
                Date date = new Date(sms.getTimestampMillis());// 发送日期
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                time = format.format(date); // 得到发送时间
            }
            Toast.makeText(context, context.getResources().getString(R.string.app_name), Toast.LENGTH_LONG).show();
            String show = "发送者:" + mobile + " 内容:" + content + "      时间:" + time;
            Log.i("context",show);
            Toast.makeText(context, show, Toast.LENGTH_LONG).show();
        }
        //Log.e("TAG","拦截短信");

        abortBroadcast();

        sendSmsNotice(context,mobile,content);

        //service
        Intent intent_SMSToDatabase = new Intent(context, SMSToDatabase.class);
        intent_SMSToDatabase.putExtra("content", content);
        context.startService(intent_SMSToDatabase);
        //Log.i("service", "service begin: ");

    }


    public void sendSmsNotice(Context context, String mobile,String content){

        //点击通知进入ShortMessage这个activity
        Intent smsintent = new Intent(context,TicketActivity.class);
        Intent []i = new Intent[1];
        i[0] = smsintent;
        PendingIntent pi = PendingIntent.getActivities(context,0, i,0);

        //发送通知
        NotificationManager manager = (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("你收到"+mobile+"的短信")
                .setContentText(content)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi) //点击通知返回到activity
                .setAutoCancel(true) //点击通知后自动取消
                .build();
        manager.notify(1,notification);
    }

}
>>>>>>> 增加图片识别功能
