package com.hisun.kont.mx;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Jaap
 */
public class CmdTask {

    /**
     * XSD文件存放目录
     */
    static String xsdDir = "C:\\Users\\cyan\\Desktop\\test\\camt";
    /**
     * JavaBean生成目录
     */
    static String pkgDir = "C:\\Users\\cyan\\Desktop\\test\\camtdto";
    /**
     * JavaBean包名
     */
    static String pkg = "tttt";
    /**
     * Cmd命令行
     */
    static String taskCommand;

    static List<Class> list = Arrays.asList(String.class, Byte.class, Short.class, Integer.class, Long.class,
            Character.class, Double.class, Float.class, Boolean.class);

    public static void main(String[] args) {
        try {
            // 将XSD转换成JavaBean
            List<File> xsdFiles = getXsdFilePath(new File(xsdDir), new ArrayList<>());
            for (File file : xsdFiles) {
                exchangeXsdToJavaBeanByCmd(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dealFeild(Field[] field, Map<String, Object> map) {
        for (Field fed : field) {
            Class<?> type = fed.getType();
//            if (fed.getGenericType()==) {
//            } else
            if (type == XMLGregorianCalendar.class) {
                XmlElement xmlElement = fed.getAnnotation(XmlElement.class);
                String name = xmlElement.name();
                map.put(name, LocalDateTime.class.getName());
            } else if (!list.contains(type)) {
                dealFeild(type.getDeclaredFields(), map);
            } else {
                String parameterType = type.getTypeName();
                fed.setAccessible(true);
                XmlElement xmlElement = fed.getAnnotation(XmlElement.class);
                String name = xmlElement.name();
                map.put(name, parameterType);
            }
        }
    }

    private static List<File> getXsdFilePath(File file, List<File> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            for (File f : files) {
                getXsdFilePath(f, list);
            }
        } else if (file.isFile() && file.getName().endsWith(".xsd")) {
            list.add(file);
        }
        return list;
    }

    private static void exchangeXsdToJavaBeanByCmd(File file) throws IOException {
        String filePathName = file.getPath();
        StringBuilder pkgStr = new StringBuilder(pkg);
        String[] splitXsdPath = filePathName.substring(xsdDir.length()).split("\\\\");
        for (int i = 0; i < splitXsdPath.length - 1; i++) {
            if (splitXsdPath[i] != null && splitXsdPath[i].length() > 0) {
                pkgStr.append(".");
                pkgStr.append(splitXsdPath[i]);
            }
        }
        pkgStr.append(".");
        String[] splitMsgNmId = file.getName().substring(0, file.getName().length() - 4).split("\\.");
        for (String s : splitMsgNmId) {
            pkgStr.append(s);
        }
        taskCommand = "xjc -nv -xmlschema -npa " + filePathName + " -d " + pkgDir + " -p " + pkgStr + " -encoding UTF-8";
        File f = new File(pkgDir);
        if (!f.exists()) {
            boolean b = f.mkdirs();
            if (!b) {
                throw new RuntimeException("创建文件夹失败");
            }
        }
        // int exitVal;
        Process process = Runtime.getRuntime().exec(taskCommand);
        // Runtime.exec()创建的子进程公用父进程的流，不同平台上，父进程的stream buffer可能被打满导致子进程阻塞，从而永远无法返回。
        // 针对这种情况，我们只需要将子进程的stream重定向出来即可。
        new ReadCmdStreamThread(process.getInputStream(), "INFO").start();
        new ReadCmdStreamThread(process.getErrorStream(), "ERR").start();
        // exitVal = process.waitFor();
        // if (exitVal != 0) {
        //     throw new RuntimeException("cmd任务执行失败");
        // }
    }

    static class ReadCmdStreamThread extends Thread {
        InputStream is;
        String printType;

        ReadCmdStreamThread(InputStream is, String printType) {
            this.is = is;
            this.printType = printType;
        }

        @Override
        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(printType + ">" + line);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
