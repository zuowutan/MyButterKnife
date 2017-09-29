package tzw.com.mybutterknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tzw on 2017/9/28.
 * 模仿ButterKnife 绑定View
 */
@Target(ElementType.FIELD)//设置当前注解的使用范围  变量
@Retention(RetentionPolicy.RUNTIME)//当前注解生命时长 虚拟机
public @interface BindView {
//    控件的资源ID是int值 所以用int去表示
    int value();
}
