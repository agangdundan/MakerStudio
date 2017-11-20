package cn.it.phw.ms.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 反射工具类
 *
 * @author phw
 */
public class ReflectionHelper {

    private static final Logger logger = LogManager.getLogger(ReflectionHelper.class);

    /**
     * 根据传入的属性名来获取对象的属性
     *
     * @param obj       要操作的对象
     * @param fieldName 传入的属性名
     * @return 对象的属性
     */
    public static Field getFieldByFieldName(Object obj, String fieldName) throws NoSuchFieldException {

        for (Class<?> superClass = obj.getClass();
                superClass != Object.class; superClass = superClass.getSuperclass()) {
            return superClass.getDeclaredField(fieldName);
        }
        return null;
    }

    /**
     * 根据传入的属性名来获取对象的属性值
     * @param obj 要操作的对象
     * @param fieldName 传入的属性名
     * @return 属性值
     * @throws SecurityException
     * @throws NoSuchFieldException 传入的属性未找到
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object getValueByFieldName(Object obj, String fieldName) throws SecurityException, NoSuchFieldException,
            IllegalArgumentException, IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if (field != null) {
            if (field.isAccessible()) {
                value = field.get(obj);
            } else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    /**
     * 根据传入的属性来设置对象的属性值
     * @param obj 要操作的对象
     * @param fieldName 要操作的属性
     * @param value 要设置的属性值
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setValueByFieldName(Object obj, String fieldName, Object value)
            throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        Field field = obj.getClass().getDeclaredField(fieldName);
        if (field.isAccessible()) {
            field.set(obj, value);
        } else {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible(false);
        }
    }

    /**
     * 获得定义类时声明的基类(父类)的泛型参数的类型
     * @param clazz 子类class
     * @param index 基类层级(继承了多少次)
     * @return 父类的类型
     */
    public static Class getSuperClassGenericType(final Class clazz, final int index){
        Type genericType = clazz.getGenericSuperclass();
        if(!(genericType instanceof ParameterizedType)){
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genericType).getActualTypeArguments();


        if(index>=params.length || index < 0){
            logger.warn("Index:"+index+",size of "+clazz.getSimpleName()+"'s Parameterize Type:"+params.length);
            return Object.class;
        }
        if(!(params[index] instanceof Class)){
            return Object.class;
        }
        return (Class)params[index];
    }


    /**
     * Test
     *
     * @param args args
     */
    public static void main(String[] args) {

        BaseEntity entity = new BaseEntity();
        entity.setCreate_time(System.currentTimeMillis());

        try {
            Field field = getFieldByFieldName(entity, "create_time");
            System.out.println(field.getName());

            Long obj = (Long) getValueByFieldName(entity, "create_time");
            System.out.println(obj);

            Class<?> clazz = getSuperClassGenericType(BaseEntity.class, 1);
            System.out.println(clazz.getSimpleName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
