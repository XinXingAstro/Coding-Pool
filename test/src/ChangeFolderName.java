import java.io.File;

public class ChangeFolderName {
    public static void main(String[] args) {
        String path = "D:\\Repositories\\Coding-Pool\\Leetcode";
        File root = new File(path);
        File[] listFiles = root.listFiles();
        String newPath = path + "\\src";
        File src = new File(newPath);
        src.mkdir();
        for (File f : listFiles) {
            f.renameTo(new File(path + "\\src\\"+ f.getName()));
        }
    }
}
