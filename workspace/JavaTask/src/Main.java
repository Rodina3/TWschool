import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//    //case 1:出现异常
//    public static void main(String[] args) {
//        String s = JOptionPane.showInputDialog("请输入整数");
//        System.out.println("转换字符串\"" + s + "\"为整数:");
//        int k = Integer.parseInt(s);
//        System.out.println(k);
//        System.out.println("我是程序的末尾！");
//    }


//    //case 2:try...catch捕获异常
//    public static void main(String[] args) {
//        int k = 0;
//        String s = JOptionPane.showInputDialog("请输入整数");
//        System.out.println("转换字符串\"" + s + "\"为整数:");
//        try {
//            k = Integer.parseInt(s);
//        } catch (NumberFormatException e) {
//            System.out.println("toString():" + e.toString());
//            System.out.println("getMessage():" + e.getMessage());
//            System.out.println("你输入的不是整数！");
//        }
//        System.out.println("我是程序的末尾");
//    }


//    //case 3:编译时异常
//    public static void main(String[] args) {
//        int k = 1 / 0;
////        try{
////            int k=1/0;
////
////        } catch (ArithmeticException e) {
////            System.out.println("除数不能为0");
////        }
//        System.out.println("我是程序的末尾！");
//    }

//    //case 4:运行时异常
//    static String str;
//    public static void main(String[] args) {
//        try {
//            int x = 8 / 0;
//        } catch (ArithmeticException e) {
//            System.out.println(e.toString());
//        }
//
//        try {
//            int y[] = new int[2];
//            System.out.println(y[2]);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e.toString());
//        }
//
//        try {
//            String s = "abc";
//            System.out.println(s.charAt(3));
//        } catch (StringIndexOutOfBoundsException e) {
//            System.out.println(e.toString());
//        }
//
//        try {
//            System.out.println(str.length());
//        } catch (NullPointerException e) {
//            System.out.println(e.toString());
//        }
//        System.out.println("以上是常见的运行时异常的情况！");
//    }


//    //case 5:try...catch..finally
//    public static void main(String[] args) throws FileNotFoundException {
//        BufferedReader buf=null;
//        String fileContent = "这是文件1.txt的内容:\n";
//        try {
//            buf = new BufferedReader(new FileReader("./1.txt"));
//            String line = null;
//            while ((line = buf.readLine() )!= null) {
//                fileContent += line + "\n";
//            }
//        } catch (FileNotFoundException ioe1) {
//            System.out.println(ioe1.toString());
//
//        } catch (IOException ioe2) {
//            ioe2.printStackTrace();
//        } finally {
//            System.out.println("不管是否有异常，finally块都执行，在这里关闭流！");
//            try {
//                if (buf != null)
//                    buf.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(fileContent);
//    }

}
