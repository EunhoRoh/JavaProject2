import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SearchService {

    BufferedReader br;

    public void searchBy(List<DataManage> list, String keyword) throws IOException {

        if(keyword.equals("name")){
            System.out.println("검색할 이름을 입력하세요");
            br = new BufferedReader(new InputStreamReader(System.in));
            String name = br.readLine();

            for( DataManage d : list ){
                if( d.getName().equals(name) ){
                    System.out.println(d.toString());
                }
            }
        }
        else {
            System.out.println("이름을 잘 못 입력했습니다.");
        }
    }
}