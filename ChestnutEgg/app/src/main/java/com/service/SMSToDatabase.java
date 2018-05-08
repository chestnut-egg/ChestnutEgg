<<<<<<< HEAD
package com.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import com.sql.modal.Ticket;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SMSToDatabase extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.service.action.FOO";
    private static final String ACTION_BAZ = "com.service.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.service.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.service.extra.PARAM2";

    public SMSToDatabase() {
        super("SMSToDatabase");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SMSToDatabase.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SMSToDatabase.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String order_number = "";
        String train_number = "";
        String departure_date = "";
        String departure_time = "";
        String departure_place = "";
        String destination_time = "";
        String destination_place = "";
        String seat_number = "";

        Log.i("service", "servicing");

        String content = intent.getStringExtra("content");
        //Log.i("service", content);

        try{

            if(content.length()>8){
                Log.i("service", content.substring(0,6));
                if(content.substring(0,6).equals("【铁路客服】")){

                    for(int i=0;i<content.length();i++){

                        if(content.charAt(i) == '单'){
                            for(int j=i+1;j<content.length();j++){
                                if(content.charAt(j) == ',')
                                    break;
                                else
                                    order_number += content.charAt(j);
                            }
                        }

                        if(content.charAt(i) == '购'){
                            for(int j=i+1;j<content.length();j++){
                                if(content.charAt(j) == '日'){
                                    departure_date += content.charAt(j);
                                    break;
                                }
                                else
                                    departure_date += content.charAt(j);
                            }
                        }

                        if(content.charAt(i) == '日'){
                            for(int j=i+1;j<content.length();j++){
                                if(content.charAt(j) == '次')
                                    break;
                                else
                                    train_number += content.charAt(j);
                            }
                        }

                        if(content.charAt(i) == '次'){
                            for(int j=i+1;j<content.length();j++){
                                if(content.charAt(j) == ',')
                                    break;
                                else
                                    seat_number += content.charAt(j);
                            }
                        }

                    }

                    for(int i=content.length()-1;i>0;i--){

                        if(content.charAt(i) == '开'){
                            for(int j=i-1;j>0;j--){
                                if(content.charAt(j) == '站'){
                                    StringBuffer departure_time2 = new StringBuffer(departure_time);//将String类型转化为StringBuffer类型
                                    departure_time2.reverse();//StringBuffer类的成员方法reverse可以倒置字符串
                                    departure_time = departure_time2.toString();//转化为String类型
                                    break;
                                }
                                else
                                    departure_time += content.charAt(j);
                            }
                        }

                        if(content.charAt(i) == '站'){
                            for(int j=i-1;j>0;j--){
                                if(content.charAt(j) == ','){
                                    StringBuffer departure_place2 = new StringBuffer(departure_place);//将String类型转化为StringBuffer类型
                                    departure_place2.reverse();//StringBuffer类的成员方法reverse可以倒置字符串
                                    departure_place = departure_place2.toString();//转化为String类型
                                    departure_place += "站";
                                    break;
                                }
                                else
                                    departure_place += content.charAt(j);
                            }
                        }

                    }

                }
            }


            Log.i("service", "for end");


            Log.i("order_number", order_number);
            Log.i("departure_date", departure_date);
            Log.i("train_number", train_number);
            Log.i("seat_number", seat_number);
            Log.i("departure_time", departure_time);
            Log.i("departure_place", departure_place);

            new Ticket(order_number,train_number,departure_date,departure_time,departure_place,"","",seat_number,1).save();

            Log.i("service", "已经存入数据库");

        }catch (Exception e){

            Log.e("service", "数据库操作有误");

        }


/*        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
*/

    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("service", "onDestroy: ");
    }

}
=======
package com.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import com.sql.modal.Ticket;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SMSToDatabase extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.service.action.FOO";
    private static final String ACTION_BAZ = "com.service.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.service.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.service.extra.PARAM2";

    public SMSToDatabase() {
        super("SMSToDatabase");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SMSToDatabase.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SMSToDatabase.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String order_number = "";
        String train_number = "";
        String departure_date = "";
        String departure_time = "";
        String departure_place = "";
        String destination_time = "";
        String destination_place = "";
        String seat_number = "";

        Log.i("service", "servicing");

        String content = intent.getStringExtra("content");
        //Log.i("service", content);

        try{

            if(content.length()>8){
                Log.i("service", content.substring(0,6));
                if(content.substring(0,6).equals("【铁路客服】")){

                    for(int i=0;i<content.length();i++){

                        if(content.charAt(i) == '单'){
                            for(int j=i+1;j<content.length();j++){
                                if(content.charAt(j) == ',')
                                    break;
                                else
                                    order_number += content.charAt(j);
                            }
                        }

                        if(content.charAt(i) == '购'){
                            for(int j=i+1;j<content.length();j++){
                                if(content.charAt(j) == '日'){
                                    departure_date += content.charAt(j);
                                    break;
                                }
                                else
                                    departure_date += content.charAt(j);
                            }
                        }

                        if(content.charAt(i) == '日'){
                            for(int j=i+1;j<content.length();j++){
                                if(content.charAt(j) == '次')
                                    break;
                                else
                                    train_number += content.charAt(j);
                            }
                        }

                        if(content.charAt(i) == '次'){
                            for(int j=i+1;j<content.length();j++){
                                if(content.charAt(j) == ',')
                                    break;
                                else
                                    seat_number += content.charAt(j);
                            }
                        }

                    }

                    for(int i=content.length()-1;i>0;i--){

                        if(content.charAt(i) == '开'){
                            for(int j=i-1;j>0;j--){
                                if(content.charAt(j) == '站'){
                                    StringBuffer departure_time2 = new StringBuffer(departure_time);//将String类型转化为StringBuffer类型
                                    departure_time2.reverse();//StringBuffer类的成员方法reverse可以倒置字符串
                                    departure_time = departure_time2.toString();//转化为String类型
                                    break;
                                }
                                else
                                    departure_time += content.charAt(j);
                            }
                        }

                        if(content.charAt(i) == '站'){
                            for(int j=i-1;j>0;j--){
                                if(content.charAt(j) == ','){
                                    StringBuffer departure_place2 = new StringBuffer(departure_place);//将String类型转化为StringBuffer类型
                                    departure_place2.reverse();//StringBuffer类的成员方法reverse可以倒置字符串
                                    departure_place = departure_place2.toString();//转化为String类型
                                    departure_place += "站";
                                    break;
                                }
                                else
                                    departure_place += content.charAt(j);
                            }
                        }

                    }

                }
            }


            Log.i("service", "for end");


            Log.i("order_number", order_number);
            Log.i("departure_date", departure_date);
            Log.i("train_number", train_number);
            Log.i("seat_number", seat_number);
            Log.i("departure_time", departure_time);
            Log.i("departure_place", departure_place);

            new Ticket(order_number,train_number,departure_date,departure_time,departure_place,"","",seat_number,1).save();

            Log.i("service", "已经存入数据库");

        }catch (Exception e){

            Log.e("service", "数据库操作有误");

        }


/*        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
*/

    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("service", "onDestroy: ");
    }

}
>>>>>>> 增加图片识别功能
