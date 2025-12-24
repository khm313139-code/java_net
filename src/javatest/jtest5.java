package javatest;

/*
[문항5]  해당 배열 중 2개의 결과값이 나오도록 코드를 작성합니다.
1. nate.com의 메일을 가진 사용자 이름만 출력하는 배열값
2. 서울 지역에 살고 있는 사용자 이름만 출력하는 배열값
{
{"honggi","hong@nate.com","서울"},
{"kangkamchan","kangch@nate.com","강원"},
{"leesoonsin","leesoonsin@nate.com","서울"},
{"jangbg","jbg3030@naver.com","서울"},
{"leedo1742","leedo@nate.com","대구"},
{"hansk_36","hansk_36@gmail.com","대전"},
{"tejongking","kings_korea@naver.com","전북"},   
{"anjk3634","anjk@gmail.com","제주도"}
}
*/
import java.util.ArrayList;

public class jtest5 {

    public static void main(String[] args) {

        String[][] arr1 = {
            {"honggi","hong@nate.com","서울"},
            {"kangkamchan","kangch@nate.com","강원"},
            {"leesoonsin","leesoonsin@nate.com","서울"},
            {"jangbg","jbg3030@naver.com","서울"},
            {"leedo1742","leedo@nate.com","대구"},
            {"hansk_36","hansk_36@gmail.com","대전"},
            {"tejongking","kings_korea@naver.com","전북"},
            {"anjk3634","anjk@gmail.com","제주도"}
        };

        // 2차원 ArrayList 변환
        ArrayList<ArrayList<String>> all = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            ArrayList<String> al = new ArrayList<>();
            for (int j = 0; j < arr1[i].length; j++) {
                al.add(arr1[i][j]);
            }
            all.add(al);
        }

        // nate.com 
        StringBuilder sb = new StringBuilder();
        // 서울
        StringBuilder sb1 = new StringBuilder(); 
        
        for (int i = 0; i < all.size(); i++) {
            String email = all.get(i).get(1);
            String area  = all.get(i).get(2);

            if (email.contains("nate.com")) {
                sb.append(all.get(i).get(0)); // id
                sb.append(", ");
            }
            if (area.equals("서울")) {
            	sb1.append(all.get(i).get(0));
            	sb1.append(", ");
            }
        }

        // 마지막 ", " 제거 부분
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        if (sb1.length() > 0) {
            sb1.setLength(sb1.length() - 2);
        }
        
        System.out.println("1. nate.com의 메일을 가진 사용자 이름만 출력하는 배열값: " + sb.toString());
        
        System.out.println("2. 서울 지역에 살고 있는 사용자 이름만 출력하는 배열값: " + sb1.toString());
        
    }
}
