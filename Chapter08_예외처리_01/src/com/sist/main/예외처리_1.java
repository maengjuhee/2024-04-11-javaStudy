package com.sist.main;
/*
 *     8장 => 263p
 *     => 예외처리
 *        = 최적화 : 실행 속도
 *        = 가독성 : 보기 편하게 => 쉽게
 *        = 견고성 : 프로그램이 비정상 종료가 안되게
 *          ---- 예외처리 (에러를 사전에 방지 => 비정상 종료를 방지하는 프로그램) 
 *          예외처리는 여기에 해당 돼
 *     => 자바
 *        에러 ====>  수정이 불가능한 에러 (메모리가 부족, 쓰레드 충돌) 
 *        예외처리 =>  소스상에서 수정이 가능한 에러 (파일명 오류, URL 주소 오류...)
 *        에러가 발생하는 요소
 *        --------------
 *        1. 사용자의 입력 부주의 : 잘못된 입력이 있는 경우 (정수인데 => 문자열 입력한다거나)
 *           -------------- if(조건문 처리) => 유효성 검사
 *        2. 프로그래머의 실수 : 배열의 범위 초과, 반복 수행 ... 클래스 메모리 할당이 없는 상태에서 사용
 *                          변수의 초기화가 없는 상태 ..., 잘못된 입력
 *      => 예외처리
 *            = 사전에 에러 방지
 *            = 비정상 종료를 방지하고 => 정상 상태 유지
 *            = 예외처리 => 에러발생 시 에러부분을 건너뛴다
 *              --------------------------------- 에러를 수정해주는 건 아니다
 *      => 예외처리 방법
 *        -----------------------------------
 *         = 예외 복구 : try ~ catch
 *                    ---    -----
 *                  정상수행    에러발생시 처리 => 복구
 *         = 예외 회피 : 처리하지 않고 => 예외 발생시 시스템에 의해 처리
 *                     메소드 뒤에 첨부
 *                     메소드() throws 예외처리
 *        -----------------------------------
 *         = 임의 발생 : 테스트용으로 주로 사용 => 프로그램이 정상적인지 확인
 *                     throw => 에러를 일부러 발생 => 확인 (견고한 프로그램인지)
 *         = 사용자 정의 예외 : 자바에서 지원하지 않는 예외처리가 존재 => 필요시 직접 예외처리를 만들어서 사용
 *      => 예외처리의 상속도 => 처리하는 순서가 존재
 *                       Object
 *                         |
 *                      Throwable : 에러 처리 최상위 클래스
 *                         |
 *               ---------------------------------------------------
 *               |                                                 |
 *            Error                                             Exception
 *           => 처리가 불가능                                      => 처리가 가능 (소스상)    
 *           => 종료 후에 다시 시작                                 => 0으로 나누는 경우
 *                                                             => URL주소가 틀리다, IP가 틀리다, 파일이 틀리다
 *                                                             
 *                          처리가 가능한 에러 => 예외처리
 *                            Exception
 *                                |
 *              ----------------------------------------------
 *              |                                             |
 *         (checkedException)                       (uncheckedException)
 *        => 컴파일시에 예외처리를 확인                   => 컴파일시에 예외를 확인하지 않는다
 *        => 반드시 예외처리를 한 후에 사용                => 필요시에 예외처리를 한다
 *        **=> java.io : 파일                       => 사용자 입력을 받는 경우
 *                                                   ---------
 *        **=> java.sql : 오라클 연결                 => 실행 시 에러
 *        => java.lang : 쓰레드 관련                  => java
 *        **=> java.net : 네트워크 
 *        => 오픈 API : Jsoup
 *        **=> 웹(네트워크) => 반드시 예외처리
 *        => javac
 *        => 9장 라이브러리 => 자바에서 지원하는 클래스의 집합
 *           ----------------------------------
 *           => java.lang, java.util, java.io
 *           => java.net, java.sql
 *           -----------------------------------
 *           => javax.http.servlet.=> 웹관련 => JSP
 *                                         3버전 => 4,5버전 출시
 *     =>Front : 자바스크립트 중심 (JavaScript => Jquery, Ajax, NodeJS, VueJs, ReactJS)
 *                             ----------                          --------------    
 *                              | TypeScript                        | NextJS
 *                                -------------------------------
 *     =>Back : 프로그램 언어(자바) => JSP , MVC , Spring , Spring-Boot
 *                        ----    데이터베이스 (오라클, MySql, Mariadb)
 *                                -------------------------------
 *         | AI => 파이썬, 머신러닝, 딥러닝
 *                 ---- 데이터 분석 ==> 넘파일 / 판다스/ MatPlotLib(시각화) => seabon
 *     => 과정 : Back-End
 *        
 *     CheckedException
 *     ----------------반드시 예외처리를 해서 사용한다 (컴파일시에 예외처리가 되어 있는지 확인)
 *            |
 *         FileNotException
 *         IOException
 *         ----------------  파일과 관련
 *         SQLException
 *         ---------------- SQL(오라클 연동)
 *         URLMalfomedException
 *         --------------------- URL(network)
 *         ClassNotFoundException
 *           Class.fomNaㅡe() => 클래스명으로 메모리 할당
 *         ----------------------
 *         InterrupedException
 *           Thread.sleep() => 충돌
 *           => 쓰레드는 프로그램안에서 여러개의 프로그램을 동시에 실행
 *         ----------------------- 쓰레드 관련
 *         
 *      UncheckedException : 필요시에만 예외처리를 한다 => 예외처리르 생략할 수 있다
 *                           => 지금까지 사용한 클래스 (생략을 한거지 안 썼던게 아니야) 
 *              |
 *          ArrayIndexOutOfBoundsException => 배열범위 초과
 *          ClassCastException => 클래스 형변환
 *          ArithmeticException => 산술 오류 => 0으로 나누는 경우
 *          NullPointerException => 메모리할당이 없는 상태에서 객체 사용시 ...
 *          -------------------- String, 윈도우 관련
 *                               ------ 멤버변수 선언시 => 자동 초기화 => null, 크롤링 => 데이터가 없는 경우
 *                               
 *          예외처리 상속도
 *          ----------
 *           Object : 최상위 클래스
 *              |
 *          Throwable
 *              |
 *       ---------------------
 *       |                   |
 *     Error               Exception
 *                           |
 *             ------------------------------------
 *             |                                  | => 예외처리선택
 *         IOException                      RuntimeException : 실행시 에러 => 필요시에는 예외처리한다
 *         SQLException                           |
 *         => 반드시 예외처리 (필수)              ArrayIndexOutOfBoundsException
 *                                          ClassCastException
 *         *** 프로그램 제작
 *             1. 설계 => 벤치마킹 (웹, 게임, ...) => 모방 =>  새로운 내용을 만든다
 *                => 영화 (영화가 종료==> 어디를 갈까?)
 *                => 캠핑장 => 레시피
 *                           ----
 *                => 자격증 => 교재 추천
 *                => 어렵게 작동 (예약 => 단순하게 만든다)
 *             2. 변수 설정 => 초기화 필요 여부
 *                => 생성자 (인스턴스)
 *                => static => static 블록을 이용한다
 *                => 사이트 화면에 출력된 데이터를 확인 => 필요시 데이터 설계
 *             3. 기능 설정 => 메소드 => 메뉴, 버튼, 입력 ...
 *                ---------------
 *                = 예상되는 에러를 추출 => 예외처리 처리를 한다 => 프로그램의 종료 방지
 *                  --------------
 *          *** 예외처리는 실무 => 한개 (상위 클래스를 이용하는 경우가 많다)
 *              상속도 => 상속을 내리는 클래스는 하위 클래스의 예외를 포함하고 있다
 *              =>  한번에 처리가 가능하다
 *              
 *              예)
 *               -----------------------------------------------------------------
 *                 배열을 선언 => ArrayIndexOfBoundsException
 *                 정수 입력을 받아서 => 정수가 입력이 안된 경우 => NumberFormatException
 *                 나누기 한다 => ArithmeticException
 *               -----------------------------------------------------------------
 *                => 나눠서 잡는다
 *                => 통합해서 잡는다
 *                
 *                try
 *                {
 *                    배열을 선언
 *                    정수 입력
 *                    나누기
 *                    ==========> 평상시에 코딩 => 실행 가능한 프로그램을 서술
 *                }catch(ArrayIndexOfBoundsException) => 다중 조건
 *                {
 *                }catch(NumberFormatException)
 *                {
 *                }catch(ArithmeticException) 
 *                {
 *                }
 *                
 *                try
 *                {
 *                    배열을 선언
 *                    정수 입력
 *                    나누기
 *                    ==========> 평상시에 코딩 => 실행 가능한 프로그램을 서술
 *                }catch(RuntimeException) => 다중 조건
 *                {
 *                }
 *                
 *                try
 *                {
 *                    배열을 선언
 *                    정수 입력
 *                    나누기
 *                    ==========> 평상시에 코딩 => 실행 가능한 프로그램을 서술
 *                }catch(Exception) => 다중 조건
 *                {
 *                }
 *                
 *                try
 *                {
 *                    배열을 선언
 *                    정수 입력
 *                    나누기
 *                    ==========> 평상시에 코딩 => 실행 가능한 프로그램을 서술
 *                }catch(Throwable) => 다중 조건
 *                {
 *                }
 *                
 *                => 위로 올라갈수록 => 예외처리 기능을 많이 가지고 있다
 *                                  ----------------------- 예외처리 기능을 포함한다
 *                   // 잘모르면 상위 클래스 쓰면 웬만한 오류는 잡아줄 것
 *                   
 *        1. 예외처리의 형식
 *           ------ 에러가 발생시에 건너뛰는 역할
 *                              ------ 에러를 처리해주는 것은 아니다
 *           try  => 모든 소스는 try 안에 들어있어
 *           {
 *              정상수행을 할 수 있는 소스
 *              ----- 평상시 코딩 => 일부러 에러발생하지 않는다
 *              1. 에러가 없는 경우 => try에서 종료
 *              2. 에러가 있는 경우 => 해당 에러를 등록한 catch를 찾는다
 *           }catch(예외처리클래스)
 *           {
 *                에러 발생시에 복구하는 위치
 *           }
 *           소스 코딩을 수행
 *           
 *           try
 *           {
 *              문장 1
 *              문장 2
 *              문장 3
 *              문장 4
 *              문장 5
 *              => 오류가 없는 경우 => 1,2,3,4,5
 *              
 *           }catch(예외처리) => 에러 발생 시 처리하는 부분 (에러가 없는 경우에는 catch는 수행하지 않는다)
 *           {
 *              문장 6
 *           }
 *           문장 7 => 7,8,프로그램 종료
 *           문장 8
 *           프로그램 종료
 *           
 *           try
 *           {
 *              문장 1
 *              문장 2
 *              문장 3 => 에러 발생 => catch로 이동  ----- => 예외처리를 하지 않는 경우에는 종료
 *              문장 4
 *              문장 5                          ------ 건너뛴다
 *           }catch(예외처리) 
 *           {
 *              문장 6 => 에러 발생 시 처리하는 부분 (에러가 없는 경우에는 catch는 수행하지 않는다)
 *           }
 *           문장 7 => 7,8,프로그램 종료
 *           문장 8
 *           프로그램 종료
 *              
 *           => 1,2,6,7,8,프로그램 종료
 *           
 *           try절 : 정상수행이 가능한 소스 코딩을 하는 부분 => 모든 프로그램 소스가 서술
 *           ==> 1개만 설정
 *           catch절 : try 수행중에 에러가 발생하는 처리 => 복구
 *           ==> 여러개 사용이 가능
 *           ==> 에러발생시 1개의 catch만 수행 => 다중 조건문과 비슷
 *               ----------------------- 찾아서 처리하는 역할 => JVM
 *               
 *           ==> 소스 전체를 예외처리
 *           try
 *           {
 *           }catch()
 *           {
 *           }
 *           ==> 예상되는 부분만 에외처리가 가능
 *           문장
 *           문장
 *           try
 *           {
 *                문장 => 자주 에러가 발생하는 부분
 *           }catch(Exception)
 *           {
 *           }
 *           
 *        
 */
class A
{
	
}
class B extends A
{
	
}

public class 예외처리_1 {
    String name; //null =>  모든 클래스는 null값으로 초기화
    // null은 데이터가 없는 상태(주소가 없는 상태) => 클래스에서만 발생
    public void display()
    {
    	name=name.substring(0,1);  // 값이 없는데 자르라고 해서 오류가 나는 경우
    	System.out.println(name);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /* int[] arr=new int[2];
        arr[0]=10;
        arr[2]=20; // 에러발생 부분 => 인덱스 범위 초과 =>  종료 => 비정상 종료 => Output창 => 에러
        System.out.println(arr[0]+","+arr[1]);*/
		
		/*A a=new B();
		// => 메소드를 A가 가지고 있는 메소드 호출
		B b=(B)a;*/
		
		//System.out.println(10/0);
		예외처리_1 a=new 예외처리_1();
	}

}
