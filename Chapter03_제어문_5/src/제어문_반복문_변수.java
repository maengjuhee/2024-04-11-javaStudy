
public class 제어문_반복문_변수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i; // 변수 사용시에는 반드시 for 밖에 설정
		for(i=1;i<=10;i++) // i<=10 i=10, i<=10 i=11 종료
        {
        	System.out.print(i+" ");
        }
         // i변수는 메모리에서 삭제
        System.out.println("i="+i);
	}

}
