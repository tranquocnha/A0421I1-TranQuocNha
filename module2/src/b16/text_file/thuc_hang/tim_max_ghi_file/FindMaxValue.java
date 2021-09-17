package b16.text_file.thuc_hang.tim_max_ghi_file;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers){
        int max=numbers.get(0);
        for (int i=0;i<numbers.size();i++){
            if (max<numbers.get(i)){
                max=numbers.get(i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\b16\\text_file\\thuc_hang\\tim_max_ghi_file\\number.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\b16\\text_file\\thuc_hang\\tim_max_ghi_file\\resut12.txt", maxValue);
    }
}
