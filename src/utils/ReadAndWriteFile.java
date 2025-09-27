package utils;

import model.entity.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    // ghi file
    public static void writeListStringToCSV(String filePath, List<String> list,boolean append) throws IOException {
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file,append);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String line:list){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }
    // đọc file
    public static List<String> readFileCSV(String filePath) throws IOException {
        List<String> stringList = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;

        while ((line= bufferedReader.readLine())!=null){
            stringList.add(line);
        }

        bufferedReader.close();
        fileReader.close();
        return  stringList;
    }
    public static List<Employee> readFileBinary(String filePath) throws IOException, ClassNotFoundException {
        List<Employee> studentList = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            studentList = (List<Employee>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }catch (EOFException e){
            System.out.println("file chưa có dữ liệu");
        }
        return studentList;
    }
}

