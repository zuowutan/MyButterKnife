package tzw.com.mybutterknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tzw on 2017/9/28.
 * 模仿ButterKnife 的点击事件
 */
@Target(ElementType.METHOD) //设置当前注解的使用范围  这里需注意 使用范围在方法上！！！
@Retention(RetentionPolicy.RUNTIME)
public @interface OnClick {
//    同理，绑定的是View ID
    int value() ;
}
