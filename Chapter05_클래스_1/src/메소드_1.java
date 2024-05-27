/*
 *     프로그램 => 묶음(관련된 내용을 묶어서 재사용)
 *     ------
 *     데이터 관리      명령문 관리      출력 관리 
 *     ---------     ---------     --------- 애플리케이션 / 웹 애플리케이션 / 모바일... 
 *                   1) 연산자
 *                   2) 제어문 
 *                   -------- 묶어서 관리 (메소드) 
 *                   메소드 => 결과값 도출 , 어떤 값을 받을 지 
 *                           ---------   -------------
 *                           | 리턴형      | 매개변수 
 *                           -------------------------
 *                            호출 위치 
 *                            ------- + 라이브러리 사용  
 *     1) 한개씩 저장후 관리 
 *        ----- *변수 / 상수 
 *     2) 여러개 동시에 저장후 관리 
 *        ----- 배열 / 클래스 
 *        배열 : 같은 데이터형을 묶어서 관리 
 *        *클래스 : 다른 데이터형을 묶어서 관리
 *     ------------------------ 메모리에 저장 (RAM => 프로그램 종료시 사라진다)
 *     3) 영구적인 저장 장치 
 *        --------------
 *        = 파일 : 보안 취약 
 *        = *** 오라클 (RDBMS)
 *     ------------------------
 *     => 자바 + 오라클 
 *         |    (저장)
 *       데이터 읽어서 => 브라우저 
 *     ------------------------
 *     
 *     브라우저 (자바는 일반 텍스트)    자바        오라클 
 *     ------                    ----       ------
 *     | HTML/CSS/JavaScript     HTML/오라클 
 *       => 오라클 연결할 수 없다 
 *     
 *     -------------------------
 *     ASP => 오라클 => C#
 *     DJango => 오라클 => 파이썬 
 *     -------------------------
 *     자바 => 데이터 관리 
 *            -------- 메모리에 저장 
 *                     -----
 *                      => 어디까지 저장 기간
 *                         => 지역변수 : 메소드 종료와 동시에 사라진다
 *                                => 리턴형 / 매개변수 
 *                         => 전역변수 : 프로그램 종료시까지 사용 
 *                                => 클래스안에 있는 모든 메소드가 
 *                                   메모리 공유 
 *                                   ---------
 *      -------------------------------------------------------
 *      
 *      자바 => 클래스로 시작 => 클래스로 끝
 *      구성요소 
 *      class ClassName
 *      {
 *         -----------------
 *          변수 설정 : 전역변수 => 자동으로 초기화 
 *          static int a;  => 0값 => 클래스 모든 영역에서 사용이 가능 
 *                               => 다른 클래스에서도 사용이 가능 
 *         -----------------
 *          생성자
 *         -----------------
 *          static void display1()
 *          {
 *              변수 => display1()안에서 사용이 가능 
 *          }
 *          static void display2()
 *          {
 *              변수 => display2()안에서 사용이 가능 
 *          }
 *         -----------------
 *         값을 계속 유지 하는 변수 .... 전역변수 
 *         사용후 버린다 .... 지역변수 
 *      }
 *      
 *      ==> 클래스 구성 제작 
 *          -------------
 *          1. 데이터 보호 : 캡슐화 
 *          2. 재사용 : 상속 
 *          3. 수정 , 추가 : 다형성 (오버라이딩,오버로딩) 
 *          ----------------------- 객체 지향 프로그램의 3대 특성 
 *          
 *          클래스의 종류 
 *          ----------
 *          일반 클래스 / 추상 /인터페이스 / 내부 클랫 / 익명의 클래스 / 지역클래스 / 멤버클래스
 *          
 *          프로그램이 종료하지 않게 (비종료) : 예외처리 
 *          
 *          
 *       ==> 라이브러리 
 *     
 */
/*
 *   1. package => 한번만 사용이 가능 
 *      import java.util.*;
 *             --------- 패키지 
 *      import ....
 *      class는 한개에 대한 정보 
 *      --------------------
 *       예) 10000개 레시피 
 *            => 한개 저장 공간을 10000개 할당 
 *   2. class ClassName
 *      {
 *         -------------------
 *          변수 목록
 *          -------
 *            지역변수
 *            --------- 전역변수  
 *            멤버변수 : 각각 따로 변수 => new 저장 (새로운 메모리에 저장)
 *            공유변수 : static => 자동 메모리 할당 
 *            ---------
 *         -------------------
 *          생성자 
 *         -------------------
 *          메소드 
 *          {
 *             변수 목록
 *             ....
 *             ....
 *          }
 *          main()
 *          {
 *             
 *          }
 *         -------------------
 *      }
 */
public class 메소드_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}