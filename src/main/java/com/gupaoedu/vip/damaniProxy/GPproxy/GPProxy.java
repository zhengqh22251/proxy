package com.gupaoedu.vip.damaniProxy.GPproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author：zhengqh
 * @date 2020/2/9 14:39
 **/
public class GPProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h) throws IOException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
       //动态生成原代码 .java文件
        String src = generateSrc(interfaces);

        //2、Java文件输出磁盘
        String filePath = GPProxy.class.getResource("").getPath();
//           System.out.println(filePath);
        File f = new File(filePath + "$Proxy0.java");
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //3、把生成的.java文件编译成.class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
        Iterable iterable = manage.getJavaFileObjects(f);

        JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
        task.call();
        manage.close();

        //4、编译生成的.class文件加载到JVM中来
        Class proxyClass =  loader.findClass("$Proxy0");
        Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
        f.delete();

        //5、返回字节码重组以后的新的代理对象
        return c.newInstance(h);

    }


    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.gupaoedu.vip.damaniProxy.GPproxy;"+ln);
        sb.append("import com.gupaoedu.vip.Person;\n" +ln+
                "import java.lang.reflect.*;\n"+ln);

        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("GPInvocationHandler h;" + ln);
        sb.append("public $Proxy0(GPInvocationHandler h) { " + ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);

         for (Method m:interfaces[0].getMethods()){
              sb.append("public "+m.getReturnType().getName() +" "+m.getName()+"(){"+ln);
              sb.append(" try {\n" +
                      " Method m =" +interfaces[0].getName()+".class.getMethod(\""+m.getName()+ "\",new Class[]{});"+ln +
                      " this.h.invoke(this,m,null);"+ln+
                      "        } catch (Throwable e) {\n" +
                      "            e.printStackTrace();\n" +
                      "        }");
              sb.append("}"+ln);
         }
        sb.append("}"+ln);
        return  sb.toString();
    }
}
