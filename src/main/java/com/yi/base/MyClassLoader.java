package com.yi.base;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private String rootPath;

    public MyClassLoader(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException("找不到类");
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String name) {
        String path = rootPath + File.separator + name.replace(".", File.separator) + ".class";
        try {
            InputStream in = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = in.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            System.out.println("类找不到");
        } catch (IOException e) {
            System.out.println("读取类信息失败");
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = new MyClassLoader("D:\\documents\\codes\\temp\\java");
        loader.loadClass("Test");
    }

}
