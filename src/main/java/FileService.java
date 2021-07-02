import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileService {

    public ArrayList<DataManage> readFile(){

        ArrayList<DataManage> list = new ArrayList<>();

        try{

            // bufferedReader, FileReader 사용
            //파일 객체 생성
            File file = new File("schedule.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);

            int i = 0;
            String line = "";
            while((line = bufReader.readLine()) != null){  //.readLine()은 끝에 개행문자를 읽지 않는다.

                StringTokenizer st = new StringTokenizer(line , "/");

                String name = st.nextToken().trim();
                String part = st.nextToken().trim();
                String exercise = st.nextToken().trim();
                int numOfSets = Integer.parseInt(st.nextToken().trim());
                int reps = Integer.parseInt(st.nextToken().trim());
                int weight = Integer.parseInt(st.nextToken().trim());
                String regDate = st.nextToken().trim();

                list.add(new DataManage(i, regDate, name, part, exercise, numOfSets, reps, weight));
                i++;
            }
            bufReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("schedule.txt 파일이 존재하지 않습니다.");
        }catch(IOException e){
            System.out.println(e);
        }

        return list;
    }

    public void saveFile(ArrayList<DataManage> list) {

        try {

            // fileUtils 사용
            File file = new File("schedule.txt");
            FileUtils.write(file, "", false);
            for (DataManage d: list) {
                FileUtils.write (file,d.getName() + " / " + d.getPart() + " / " + d.getExercise() + " / " + d.getNumOfSets()
                        + " / " + d.getReps()  + " / " + d.getWeight() + " / " + d.getRegiDate()+ "\n", true);
            }
            // fileUtils 사용
        }catch (FileNotFoundException e) {
            System.out.println("schedule.txt 파일이 존재하지 않습니다.");
        }catch(IOException e){
            System.out.println(e);
        }
    }
}