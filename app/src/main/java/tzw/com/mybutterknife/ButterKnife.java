package tzw.com.mybutterknife;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * Created by tzw on 2017/9/28.
 * 自定义ButterKnife类
 */
public class ButterKnife {
    public static void bind(Activity activity) {
        try {
            bindView(activity);
            bindOnClick(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 绑定view
     * @param activity
     * @throws Exception
     */
    private static void bindView(Activity activity) throws Exception {
        //1 获取外部传进来Activity的字节码
        Class<? extends Activity> aClass = activity.getClass();
        //2 获取activity中的变量！！！注意，这里返回的是数组，是所有的字段！！！
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field field : declaredFields){
            //允许暴力反射
            field.setAccessible(true);
            //3 获取变量上的自定义BindView注解
            BindView annotation = field.getAnnotation(BindView.class);
            if(annotation != null){
                //4 获取注解上的值
                int id = annotation.value();
                //5 通过ID获取控件
                View view = activity.findViewById(id);
                //6 将控件赋值给变量
                field.set(activity,view);
            }else{

            }
        }
    }

    /**
     * 绑定点击事件
     * @param activity
     */
    private static void bindOnClick(final Activity activity) {
        //1 获取字节码对象
        Class<? extends Activity> aClass = activity.getClass();
        //2 获取所有的方法 返回的是方法数组
        Method[] declaredMethods = aClass.getDeclaredMethods();
        //3 遍历所有的方法
        for(final Method method : declaredMethods){
            method.setAccessible(true);
            //4 获取方法上的注解
            OnClick annotation = method.getAnnotation(OnClick.class);
            if(annotation != null){
//                获取点击事件的View ID值
                int id = annotation.value();
                View view = activity.findViewById(id);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
//                            这里才是调用方法的关键，在传进来的activity上调用
//                            注意，这里的null是从外部传进来的，这里可以拓展
                            method.invoke(activity,null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }else {

            }
        }


    }

}
