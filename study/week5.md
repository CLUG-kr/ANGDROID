# 📢 (5주차) 스터디 일지

> #### 작성자 : 신요한
>
> #### 작성 날짜 : 2021.11.09
>
> #### 참여자 : 신요한, 이지현, 김성윤

## ✅ 이번주 공부 내용 : 네트워킹

### ▶️ 스레드 이해하기

 #### ▶️ 용어 및 개념 정리
* 스레드(thread): 어떤 프로세스 내에 실행되는 흐름의 단위, 메모리 리소스에 접근한다.
 * 기본적으로 메인스레드에서만 메모리 리소스에 접근한다.(멀티스레드를 사용할 때 사용자가 직접 제어코드를 넣어줘야 함) 
 * 멀티 스레드에서는 메인 스레드 외에 메모리 접근 불가능
 * 메인 스레드가 아닌 스레드에서 UI 개체 직접 접근하기 위해선 핸들러 객체를 사용해야 한다.
  * 핸들러 객체 원리: 링크주소: https://www.boostcourse.org/mo316/lecture/259216?isDesc=false

* Async Task 이용하기: 
 * (핸들러 객체 사용의 단점): message 객체의 코드가 장황해서 해석하기 어려울 수 있다.
 * (대안) Async Task는 하나의 클래스 안에 스레드가 동작하는 부분과 UI가 접근하는 부분을 모두 담을 수 있으므로 좀더 사용하기 쉽다.

 *  ##### 원리:
 AsyncTask 클래스를 상속받아 클래스를 정의할 때는, 다음과 같은 메소드들을 정의해준다.
1. doInBackground()

AsyncTask를 시작하면 자동으로 실행되는 코드 부분 (Thread 부분)

 

2. onProgressUpdate()

AsyncTask가 동작하는 중간중간 상태를 업데이트 하는 부분 (주로 UI 업데이트에 사용)

 

3. onPostExecute()

AsyncTask가 종료되면(doInBackground 코드가 모두 실행되면) 실행되는 부분

 

위의 함수들이 호출되는 과정을 간단히 살펴보자.

 

처음 AsyncTask가 시작되면 doInBackground 내부의 코드가 실행된다.

코드를 실행하는 중 doInBackground 내부에서 중간중간 업데이트를 위해 publishProgress() 함수를 호출하면 onProgressUpdate가 실행되어 UI 부분을 업데이트 하는 등의 필요한 기능을 수행한다.

마지막으로 doInBackground 내부의 코드가 모두 실행되면 onPostExecute() 함수가 호출된다.

 

따라서 각각의 파라미터는 다음과 같이 전달된다.

 

- onCreate()

task.execute(String) → doInBackground(String)

 

- doInBackground()

publishProgress(Integer) → onProgressUpdate(Integer)

return value(Integer) → onPostExecute(Integer)

 
 * 참고: https://www.boostcourse.org/mo316/lecture/17087?isDesc=false
        https://ju-hy.tistory.com/63 
        
>





 #### ▶️ 실습 과정
* 스레드를 만드는 방법 두가지: 스레드 클래스를 만들어서 정의하기 , 스레드를 상속하여 만들기
 * 1. 스레드 클래스를 만들어서 정의하기 : 실습

 * 2. 스레드를 상속하여 만들기 : 실습

 
* Async Task를 사용해보기: 실습(x)

* Q n A: 

 
* 심화 :  




### ▶️ 소켓 사용하기


 #### ▶️ 이론 공부 

 * 소켓:
 (의미)서버와 클라이언트를 연결해주는 방식
 (방법) 서버 소켓과 클라이언트 소켓을 만들고 서로 연결해준다.

  * 서버소켓:
  - ServerSocket 클래스 이용
  - accept함수 호출하면  클라이언트 접속대기상태
  - accept함수 이후의 코드는 클라이언트 접속 후 동작함
  (while문을 사용하는 이유임)

  * 데이터 보내고 받기:
  - 스트림 객체 사용하기:
   + ObjectOutputStream:
    - 데이터 보낼 때
    - WriteObject 메소드 사용해서 보냄 

   + ObjectinputStream:
   데이터 받을 때 
    - readObject 메소드 사용해서 보냄
 
 * 클라이언트 소켓:
 - ClientSocket 클래스 이용
 - 서버 소켓과 반대로 작동 (데이터를 요청하고 받는 순서)
 - 
  


* 주의사항

 * manifest xml 파일에 INTERNET 권한 설정 해야한다.
 * 포트번호는 서버소켓과 동일한 번호를 사용해야 한다.

* 참고:
소켓통신과 http 통신의 차이: https://kotlinworld.com/75






 #### ▶️ 실습 과정

1. 서버소켓을 액티비티에서 만들고 클라이언트 소켓과 연결 뒤  log값 확인하기:

- 참고:
IO exception과 try- catch 문: 




2. 스레드와 핸들러를 이용하여 서버가 클라이언트에게 데이터를 UI 객체에 전달하기:
 - trouble:
 setText 메소드에서 에러가 발생해 UI에 데이터 전달이 안되었다.



3. 서버소켓을 서비스에서 만들어 데이터를 UI객체에 전달해보기 :
 - 





### ▶️ 웹으로 요청하기

#### 1) HTTP 통신 이해하기
(의미)웹상에서 주고받을 수 있는 프로토콜(통신규약)
(방법)주로 TCP/UDP를 사용하고 80번 포트를 사용한다.
- (소켓 통신과 비교)
공통점: 
소켓통신은 서버소켓과 클라이언트 소켓을 만들어 같은 포트로 연결하여 컴퓨터간 연결을 가능하게 한다. HTTP의 내부 구조도 소켓통신으로 연결이 이루어져있다.
차이점: 
HTTP 요청/응답에는 각각 정해진 포멧이 있으며 그 규칙을 따라야만
통신이 가능하다.
Http 통신은 클라이언트의 요청이 있어야만 하지만, 소켓 통신은 클라이언트와 서버 모두 요청과 응답을 보낼 수 있다. 
참고자료: http와 소켓통신의 차이: https://hwanine.github.io/network/Socket-Http/








- Http 요청/응답의 구조
  기본 요구사항
   1. 시작줄에는 실행되어야 할 요청, 또는 요청 수행에 대한 성공/실패가 기록
   2. 옵션으로 HTTP 헤더 세트가 들어가 있다. 여기에 요청에 대한 설명/메시지   본문에대한 설명이 들어 있다.
   3. 요청에 대한 모든 메타 정보가 전송되었음을 알리는 빈 줄이 삽입된다.
   4. HTTP 메시지의 시작줄과 HTTP 헤더를 묶어서 요청 헤드(head)라고 하고, 이와 반대로 HTTP 메시지의 페이로드는 본문(body)라고 한다.
   * 참고자료: HTTP 메시지:  https://developer.mozilla.org/ko/docs/Web/HTTP/Messages
   - 정리
   HTTP 통신은 소켓이라는 연결 위에 데이터가 요청/응답하는 포멧을 정한 것이다.
   HTTP 메시지는 크게 헤더와 바디로 구분된다.
   바디에 원하는 데이터를 넣을 수가 있다.
- 실습:
  O