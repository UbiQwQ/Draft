package reflect.base;

import common.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @program: draft
 * @description: Java 反射 Fields相关
 * @author: atong
 * @create: 2021-01-26 15:44
 */
public class Fields {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        Class c = User.class;

        //getField 不能得到私有属性
        Field nameField = c.getField("name");
        Field staField = c.getField("sta");
        //getDeclaredField 可获取所有属性
        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);

        //反射创建对象
        Object o = c.newInstance();
        //反射set
        nameField.set(o, "atong");
        //反射get
        System.out.println(nameField.get(o));
        System.out.println("==============================");
        ageField.set(o, 19);
        System.out.println(ageField.get(o));
        System.out.println("==============================");
        //静态变量, 对象参数可以是null,当然写成o也可以
        staField.set(null,66L);
        System.out.println(staField.get(null));
        System.out.println("==============================");


        //反射获取字段信息
        getFields(c);
    }

    public static void getFields (Class cl)  {
        /**
         * getDeclaredFields
         * Returns an array of {@code Field} objects reflecting all the fields
         * declared by the class or interface represented by this
         * {@code Class} object.
         * This includes public, protected, default (package) access, and private fields,
         * but excludes inherited[遗传的;继承权的] fields.
         *
         * <p> If this {@code Class} object represents a class or interface with no
         * declared fields, then this method returns an array of length 0.
         *
         * <p> If this {@code Class} object represents an array type, a primitive
         * type, or void, then this method returns an array of length 0.
         *
         * <p> The elements in the returned array are not sorted and are not in any
         * particular order.
         */
        Field[] declaredFields = cl.getDeclaredFields();
        for (Field field : declaredFields) {
            //方法返回一个Class对象，用于标识此Field对象所表示的字段的声明类型。
            Class<?> type = field.getType();
            //方法返回此Field对象表示的字段的名称。
            String name = field.getName();
            //返回Field修饰符
            String modifiers = Modifier.toString(field.getModifiers());

            System.out.println("Fields Type = " + type);
            System.out.println("Fields Name = " + name);
            System.out.println("Fields modifiers = " + modifiers);

            //sout
            if (modifiers.length()>0) {
                System.out.print(modifiers + "  ");
            }
            System.out.println(type.getName()+" "+ name+ ";");
            System.out.println("==============================");
        }
    }
}
