package training.classloader;

import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * @author ping zhang
 * @date
 */
public class HelloClassLoader extends ClassLoader{


    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<?> hello = new HelloClassLoader().findClass("Hello");
        Object o = hello.newInstance();
        Method declaredMethod = hello.getDeclaredMethod("hello", null);
        declaredMethod.invoke(o, null);
    }

    @SneakyThrows
    @Override
    protected Class<?> findClass(String name)  {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("Hello.xlass");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = resourceAsStream.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        byte[] bytes = out.toByteArray();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

}
