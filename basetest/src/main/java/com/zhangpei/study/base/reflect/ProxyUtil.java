package com.zhangpei.study.base.reflect;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

// 代理类生成工具
public class ProxyUtil {

    /**
     * @param target
     * @return
     */
    public static Object newProxyInstance(Object target) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 整个代理对象的java内容
        String content = "";
        // 包路径
        String packageContent = "package com.zhangpei.study.base.reflect;";
        // 获取对象接口类
        Class targetInfo = target.getClass().getInterfaces()[0];
        String targetInfoName = targetInfo.getSimpleName();
        // 代理对象中导入类路径
        String importContent = "import " + targetInfo.getName() + ";";
        // 代理对象class定义
        String classContent = "public class $Proxy implements " + targetInfoName + "{";

        // 代理对象无参构造私有
        String fieldContent = "private " + targetInfoName + " target;";
        // 有参构造
        String construterContent = "public $Proxy(" + targetInfoName + " target){"
                + "this.target = target;}";

        // 所有声明方法
        Method[] methods = targetInfo.getDeclaredMethods();
        String methodsContent = "";

        // 生成方法
        for (Method method : methods) {
            String methodName = method.getName();
            Class returnType = method.getReturnType();
            Class<?>[] parameterTypes = method.getParameterTypes();
            String argsContent = "";
            String argsNames = "";
            int i = 0;
            for (Class<?> parameterType : parameterTypes) {
                String simpleName = parameterType.getSimpleName();
                argsContent += simpleName + " p" + i + ",";
                argsNames += "p" + i + ",";
                i++;
            }

            if (argsContent.length() > 0) {
                argsContent = argsContent.substring(0, argsContent.lastIndexOf(",") - 1);
                argsNames = argsNames.substring(0, argsNames.lastIndexOf(",") - 1);

            }
            if (returnType.getSimpleName().equals("void")) {
                methodsContent += "public " + returnType.getSimpleName() + " " + methodName + "(" + argsContent + "){"
                        + "System.out.println(\"log log log \");"
                        + "target." + methodName + "(" + argsNames + ");}";
            } else {
                methodsContent += "public " + returnType.getSimpleName() + " " + methodName + "(" + argsContent + "){"
                        + "System.out.println(\"log log log \");"
                        + "return target." + methodName + "(" + argsNames + ");}";
            }


        }

        // 内容拼接
        content = packageContent + importContent + classContent + fieldContent + construterContent + methodsContent + "}";


        // 生成java代理类java文件
        File file = new File("D:\\work\\workspace\\study\\src\\main\\java\\com\\zhangpei\\study\\base\\reflect\\$Proxy.java");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(content);
        fileWriter.flush();
        fileWriter.close();

        // 编译文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileManager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units);
        task.call();
        fileManager.flush();
        fileManager.close();

        // 从classLoader中获取文件
        URL[] urls = new URL[]{new URL("file:d:\\\\")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class aClass = urlClassLoader.loadClass("com.zhangpei.study.base.reflect.$Proxy");

        // 实例化对象
        Constructor constructor = aClass.getConstructor(targetInfo);
        Object proxy = constructor.newInstance(target);

        return proxy;
    }

}
