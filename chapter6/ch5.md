# Ch6. 스프링이 사랑한 디자인 패턴

생성일: 2021년 10월 29일 오후 2:48

## 프롤로그

- 객체 지향 4대 원칙 (캡!상추다) → 요리도구
- 객체 지향 설계 원칙 (SOLID) → 요리도구 사용법
- 디자인 패턴 → 레시피

  > 하나의 요리에 표준화된 요리법이 있듯이 프로그램을 작성하다 보면 비슷 비슷한 상황에 직면하게 되는 경우가 많은데, 그러한 상황에서 **이전의 많은 개발자들이 고민하고 정제한 사실 상의 표준 설계 패턴**이 있다.


- 스프링 프레임워크는 현재 그리고 앞으로도 가장 각광받을 것으로 여겨지는 개발 프레임워크다.

  > 자바 엔터프라이즈 개발을 편하게 해주는 오픈소스 경량급 애플리케이션 프레임워크


⇒ 디자인 패턴은 **객체 지향의 특성 중 상속(extends), 인터페이스(implements), 합성(객체를 속성으로 사용) 을 이용한다. 이 세가지 방식 외에 다른 방식은 없다**. 그러나 보니 여러 디자인 패턴이 비슷해 보일 수 있으니 집중해서 살펴보자.

## 1. 어댑터 패턴 - Adapter Pattern

> 충전기의 경우 휴대폰을 직접 전원 콘센트에 연결할 수 없기 때문에 충전기가 핸드폰과 전원 콘센트 사이에서 둘을 연결해주는 변환기의 역할을 수행해준다.


i.e.

JDBC와 JRE는 `개방 폐쇄 원칙(OCP)`을 지켜서 어댑터 패턴을 사용하여 개발된 인터페이스이다.

```java
public class ClientWithAdapter {

    public static void main(String[] args) {
        MyJDBC myOracleAdapter = new MyOracleAdapter();
        MyJDBC yourSQLAdapter = new YourSQLAdapter();

        myOracleAdapter.getConnection();    // 오라클 커넥션 가져옵니다.
        yourSQLAdapter.getConnection();     // SQL 커넥션 가져옵니다.
    }
}
```

```java
public class MyOracleAdapter implements MyJDBC{

    MyOracle myOracle = new MyOracle();  // 진짜 서비스를 실행할 객체

    @Override
    public void getConnection() {
        myOracle.getOracleConnection();
    }
}
```

```java
public class YourSQLAdapter implements MyJDBC {

    YourSQL yourSQL = new YourSQL();   // 진짜 서비스를 실행할 객체

    @Override
    public void getConnection() {
        yourSQL.getYourSQLConnection();
    }
}
```

⇒ 어댑터 객체 안에 **속성으로 서비스를 실행할 객체**를 가지고 있고 그 속성을 참조하여 기능을 실행한다.

> 호출당하는 쪽의 메소드를 **호출하는 쪽의 코드에 대응하도록 중간에 변환기를 통해** 호출하는 패턴


## 2. 프록시 패턴 - Proxy Pattern

> 프록시는 대리자, 대변인이라는 뜻을 가진 단어다. 대리자/대변인 이라고 하면 다른 누군가를 대신해 그 역할을 수행하는 존재를 말한다.


i.e.

인터페이스를 중간에 두고 타이어를 여러개로 교체할 수 있었던 `의존 역전 원칙(DIP)` 과 `개방 폐쇄 원칙(OCP)`이 모두 적용된 설계 패턴이다.

```java
public class ProxyService implements MyService {

    MyService service;

    @Override
    public String runSomething() {
        System.out.println("프록시로 감쌌습니다.");

        service = new RealService();
        return service.runSomething();   // 실제 서비스
    }
}
```

```java
public class ClientWithProxy {

    public static void main(String[] args) {
        MyService service = new ProxyService();
        System.out.println(service.runSomething());
    }
}
```

⇒ 프록시 패턴의 경우, **실제 서비스 객체가 가진 메소드와 같은 이름의 메소드(runSomething)**를 사용하는데, **이를 위해 인터페이스를 사용한다**. 인터페이스를 사용하면서 서비스 객체가 들어갈 자리에 대리자 객체를 대신 투입해 클라이언트 쪽에서는 실제 서비스 객체를 통해 메소드를 호출하고 반환값을 받는지, 대리자 객체를 통해 메소드를 호출하고 반환값을 받는지 전혀 모르게 처리할 수도 있다.

> 제어흐름을 조정하거나 다른 로직을 수행하기 위한 목적으로 중간에 대리자를 두는 패턴


## 3. 데코레이터 패턴 - Decorator Pattern

> 데코레이터 패턴은 프록시 패턴과 구현 방법이 같다. 다만 프록시 패턴은 반환값을 조작하지 않고 그대로 전달하는 반면 데코레이터 패턴은 도장, 장식과 같은 의미와 맞게 반환값에 장식을 덧입힌다.


i.e.

```java
public class DecoratorService implements MyService {

    MyService service;
    @Override
    public String runSomething() {
        System.out.println("호출에 대한 장식이 주목적, 클라이언트 반환 결과에 장식을 더하여 전달");

        service = new RealService();
        return "가미된 " + service.runSomething();
    }
}
```

```java
public class ClientWithDecorator {

    public static void main(String[] args) {
        MyService service = new DecoratorService();
        System.out.println(service.runSomething());
    }
}
```

> 메소드 호출의 반환값에 변화를 주기 위해 중간에 장식자를 두는 패턴
>

## 4. 싱글턴 패턴 - Singleton Pattern

> 불필요한 자원을 사용하지 않기 위해 여러개의 인스턴스가 있을 필요가 없는 경우(커넥션 풀, 스레드 풀, 디바이스 설정 객체 등) 에 **인스턴스를 하나만 만들어** 사용하기 위한 패턴

- new를 실행할 수 없도록 생성자에 private 접근 제어자를 지정한다.
- 유일한 단일 객체를 반환할 수 있는 정적 메소드가 필요하다.
- 유일한 단일 객체를 참조할 정적 참조 변수가 필요하다.

i.e.

```java
public class LazyInitialization {
 
    private static LazyInitialization instance;
 
    private LazyInitialization(){}
     
    public static LazyInitialization getInstance(){
        if(instance == null){
            instance = new LazyInitialization();
        }
        return instance;
    }
 
}
```

⇒ 이 방식은 Thread-Safe 하지 않다.

```java
public class ThreadSafeLazyInitialization{
 
    private static ThreadSafeLazyInitializationinstance;
 
    private ThreadSafeLazyInitialization(){}
     
    public static synchronized ThreadSafeLazyInitializationgetInstance(){
        if(instance == null){
            instance = new ThreadSafeLazyInitialization();
        }
        return instance;
    }
 
}
```

⇒ 이 방식은 Thread-Safe 하긴 하지만 스레드가 여러개 일경우 lock, unlock 현상때문에 성능이 저하된다.

```java
package chapter6.singleton;

public class DoubleCheckInitialization {

    private volatile static DoubleCheckInitialization instance;

    private DoubleCheckInitialization() {}

    public static DoubleCheckInitialization getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckInitialization.class) {
                if(instance == null)
                    instance = new DoubleCheckInitialization();
            }
        }
        return instance;
    }
}
```

⇒ volatile 키워드를 사용하는데, 이는 Main Memory에서 값을 읽어옴으로써 각 쓰레드마다 CPU cache 에서 변화되는 값을 다르게 읽어오는 것을 방지한다.

⇒ 사실 코드가 복잡하고 성능도 좋지 않다고 한다.

```java
public class LazyHolderInitialization {
    private LazyHolderInitialization() {};

    private static class LazyHolder {
        private static final LazyHolderInitialization instance = new LazyHolderInitialization();
    }

    public static LazyHolderInitialization getInstance() {
        return LazyHolder.instance;
    }
}
```

⇒ 내부 클래스인 LazyHolder 클래스는 getInstance를 호출할때 static memory에 로드되며 Thread-safe 하면서 성능이 좋다

⇒ Inner class의 필드는 final로 지정하여 다시 할당되지 않게 한다.

⇒ 싱글톤 사용시 **클래스 로더가 2종류이면, 2개의 인스턴스가 만들어진다**.

⇒ 스프링에서의 싱글톤은 context 1개당 싱글톤 1개 이기 때문에 context 범위를 생각하여 생성을 해야 한다.

참조

[싱글턴 패턴(Singleton Pattern)](https://webdevtechblog.com/%EC%8B%B1%EA%B8%80%ED%84%B4-%ED%8C%A8%ED%84%B4-singleton-pattern-db75ed29c36)

## 5. 템플릿 메소드 패턴 - Template Method Pattern

> 상위 클래스의 견본 메소드에서 하위 클래스가 오버라이딩한 메소드를 호출하는 패턴


i.e.

```java
public abstract class Animal {

    public final void playWithOwner() {
        System.out.println("귀염둥이 이리온");
        play();
        runSomething();
        System.out.println("잘했어!!");
    }

    protected abstract void play();

    void runSomething() {
        System.out.println("꼬리 살랑 살랑~");
    }
}
```

```java
public class Dog extends Animal {

    @Override
    public void play() {
        System.out.println("멍멍!!!");
    }

    @Override
    //Hook (갈고리) 메소드 오버라이딩
    public void runSomething() {
        System.out.println("멍멍!! 꼬리 살랑살랑");
    }

}
```

```java
public class Cat extends Animal {
    @Override
    protected void play() {
        System.out.println("냐옹 냐옹~~");
    }
    
}
```

```java
귀염둥이 이리온
멍멍!!!
멍멍!! 꼬리 살랑살랑
잘했어!!
----------
귀염둥이 이리온
냐옹 냐옹~~
꼬리 살랑 살랑~
잘했어!!
```

⇒ 이처럼 상위 클래스에 **공통 로직을 수행하는 템플릿 메소드**와 하위 클래스에 오버라이딩을 강제하는 추상 메소드 또는 선잭적으로 오버라이딩할 수 있는 훅(Hook) 메소드를 두는 패턴을 템플릿 메소드 패턴이라고 한다.

⇒ `DIP 원칙`을 사용한다.

## 6. 팩토리 메소드 패턴 - Factory Method Pattern

> 팩토리 메소드는 객체를 생성 반환하는 메소드를 말한다. 여기에 패턴이 붙으면 **하위 클래스에서 팩토리 메소드를 오버라이딩해서 객체를 반환하게 하는 것을 의미**한다.
>

i.e.

```java
public class Driver {
    public static void main(String[] args) {
        Animal doong = new Dog();
        Animal sosa = new Cat();

        //팩토리 메소드 사용
        AniamlToy tennisball = doong.getToy();
        AniamlToy catTower = sosa.getToy();

        tennisball.identity();
        catTower.identity();
    }
}
```

```java
public abstract class Animal {
    abstract AniamlToy getToy();
}
```

⇒ `DIP 원칙`을 사용한다.

> 오버라이드된 메소드가 객체를 반환하는 패턴
>

## 7. 전략 패턴 - Strategy Pattern

- 전략 메소드를 가진 전략 객체
- 전략 객체를 사용하는 컨텍스트(전략 객체의 사용자/소비자)
- 전략 객체를 생성해 컨텍스트에 주입하는 클라이언트(제3자, 전략 객체의 공급자)

i.e. 군인이 있다고 상상해보자. 그리고 그 군인이 사용할 무기는 전략이 되고, 무기를 사용하는 군인은 컨텍스트, 그리고 무기를 보급해주는 보급장교는 제 3자, 즉 클라이언트가 된다.

```java
public class Soldier {
    void runContext(MyStrategy strategy) {
        System.out.println("전투 시작");
        strategy.runStrategy();
        System.out.println("전투 종료");
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        MyStrategy strategy = null;
        Soldier soldier = new Soldier();

        strategy = new Gun();
        soldier.runContext(strategy);

        strategy = new Sword();
        soldier.runContext(strategy);

        strategy = new Bow();
        soldier.runContext(strategy);
    }
}
```

⇒ 전략 패턴은 디자인 **패턴의 꽃이라고 할 정도로 다양한 곳에서 다양한 문제 상황의 해결책**으로 사용된다.

⇒ 그리고 혹시나 템플릿 메소드 패턴과 유사하다는 느낌이 든다면, 제대로 본것이다. **같은 문제의 해결책**으로 **상속을 이용하는 템플릿 메소드 패턴**과 **객체 주입을 통한 전략 패턴** 중에서 선택/적용 할 수 있다.

⇒ `OCP(개방 폐쇄 원칙)` 과 `DIP(의존 역전 원칙)`이 적용되었다.

> 클라이언트가 전략을 생성해 전략을 실행한 컨텍스트에 주입하는 패턴
>

## 8. 템플릿 콜백 패턴 - Template Callback Pattern (견본/회신 패턴)

> 템플릿 콜백 패턴은 전략 패턴의 변형으로, 스프링 3대 프로그래밍 모델 중 하나인 DI(의존성 주입)에서 사용하는 특별한 형태의 전략 패턴이다.
전략패턴과 모든 것이 동일한데 **전략을 익명 내부 클래스로 정의해서 사용한다**는 특징이 있다.
>

i.e.

```java
public class Client {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.runContext(new MyStrategy() {
            @Override
            public void runStrategy() {
                System.out.println("총초초초오오옹!!!");
            }
        });

        soldier.runContext(new MyStrategy() {
            @Override
            public void runStrategy() {
                System.out.println("카카라칼 쉥쉥엥잉~~");
            }
        });# Ch6. 스프링이 사랑한 디자인 패턴

생성일: 2021년 10월 29일 오후 2:48

## 프롤로그

- 객체 지향 4대 원칙 (캡!상추다) → 요리도구
- 객체 지향 설계 원칙 (SOLID) → 요리도구 사용법
- 디자인 패턴 → 레시피

  > 하나의 요리에 표준화된 요리법이 있듯이 프로그램을 작성하다 보면 비슷 비슷한 상황에 직면하게 되는 경우가 많은데, 그러한 상황에서 **이전의 많은 개발자들이 고민하고 정제한 사실 상의 표준 설계 패턴**이 있다.


- 스프링 프레임워크는 현재 그리고 앞으로도 가장 각광받을 것으로 여겨지는 개발 프레임워크다.

  > 자바 엔터프라이즈 개발을 편하게 해주는 오픈소스 경량급 애플리케이션 프레임워크


⇒ 디자인 패턴은 **객체 지향의 특성 중 상속(extends), 인터페이스(implements), 합성(객체를 속성으로 사용) 을 이용한다. 이 세가지 방식 외에 다른 방식은 없다**. 그러나 보니 여러 디자인 패턴이 비슷해 보일 수 있으니 집중해서 살펴보자.

## 1. 어댑터 패턴 - Adapter Pattern

> 충전기의 경우 휴대폰을 직접 전원 콘센트에 연결할 수 없기 때문에 충전기가 핸드폰과 전원 콘센트 사이에서 둘을 연결해주는 변환기의 역할을 수행해준다.


i.e.

JDBC와 JRE는 `개방 폐쇄 원칙(OCP)`을 지켜서 어댑터 패턴을 사용하여 개발된 인터페이스이다.

```java
public class ClientWithAdapter {

    public static void main(String[] args) {
        MyJDBC myOracleAdapter = new MyOracleAdapter();
        MyJDBC yourSQLAdapter = new YourSQLAdapter();

        myOracleAdapter.getConnection();    // 오라클 커넥션 가져옵니다.
        yourSQLAdapter.getConnection();     // SQL 커넥션 가져옵니다.
    }
}
```

```java
public class MyOracleAdapter implements MyJDBC{

    MyOracle myOracle = new MyOracle();  // 진짜 서비스를 실행할 객체

    @Override
    public void getConnection() {
        myOracle.getOracleConnection();
    }
}
```

```java
public class YourSQLAdapter implements MyJDBC {

    YourSQL yourSQL = new YourSQL();   // 진짜 서비스를 실행할 객체

    @Override
    public void getConnection() {
        yourSQL.getYourSQLConnection();
    }
}
```

⇒ 어댑터 객체 안에 **속성으로 서비스를 실행할 객체**를 가지고 있고 그 속성을 참조하여 기능을 실행한다.

> 호출당하는 쪽의 메소드를 **호출하는 쪽의 코드에 대응하도록 중간에 변환기를 통해** 호출하는 패턴


## 2. 프록시 패턴 - Proxy Pattern

> 프록시는 대리자, 대변인이라는 뜻을 가진 단어다. 대리자/대변인 이라고 하면 다른 누군가를 대신해 그 역할을 수행하는 존재를 말한다.


i.e.

인터페이스를 중간에 두고 타이어를 여러개로 교체할 수 있었던 `의존 역전 원칙(DIP)` 과 `개방 폐쇄 원칙(OCP)`이 모두 적용된 설계 패턴이다.

```java
public class ProxyService implements MyService {

    MyService service;

    @Override
    public String runSomething() {
        System.out.println("프록시로 감쌌습니다.");

        service = new RealService();
        return service.runSomething();   // 실제 서비스
    }
}
```

```java
public class ClientWithProxy {

    public static void main(String[] args) {
        MyService service = new ProxyService();
        System.out.println(service.runSomething());
    }
}
```

⇒ 프록시 패턴의 경우, **실제 서비스 객체가 가진 메소드와 같은 이름의 메소드(runSomething)**를 사용하는데, **이를 위해 인터페이스를 사용한다**. 인터페이스를 사용하면서 서비스 객체가 들어갈 자리에 대리자 객체를 대신 투입해 클라이언트 쪽에서는 실제 서비스 객체를 통해 메소드를 호출하고 반환값을 받는지, 대리자 객체를 통해 메소드를 호출하고 반환값을 받는지 전혀 모르게 처리할 수도 있다.

> 제어흐름을 조정하거나 다른 로직을 수행하기 위한 목적으로 중간에 대리자를 두는 패턴


## 3. 데코레이터 패턴 - Decorator Pattern

> 데코레이터 패턴은 프록시 패턴과 구현 방법이 같다. 다만 프록시 패턴은 반환값을 조작하지 않고 그대로 전달하는 반면 데코레이터 패턴은 도장, 장식과 같은 의미와 맞게 반환값에 장식을 덧입힌다.


i.e.

```java
public class DecoratorService implements MyService {

    MyService service;
    @Override
    public String runSomething() {
        System.out.println("호출에 대한 장식이 주목적, 클라이언트 반환 결과에 장식을 더하여 전달");

        service = new RealService();
        return "가미된 " + service.runSomething();
    }
}
```

```java
public class ClientWithDecorator {

    public static void main(String[] args) {
        MyService service = new DecoratorService();
        System.out.println(service.runSomething());
    }
}
```

> 메소드 호출의 반환값에 변화를 주기 위해 중간에 장식자를 두는 패턴
>

## 4. 싱글턴 패턴 - Singleton Pattern

> 불필요한 자원을 사용하지 않기 위해 여러개의 인스턴스가 있을 필요가 없는 경우(커넥션 풀, 스레드 풀, 디바이스 설정 객체 등) 에 **인스턴스를 하나만 만들어** 사용하기 위한 패턴

- new를 실행할 수 없도록 생성자에 private 접근 제어자를 지정한다.
- 유일한 단일 객체를 반환할 수 있는 정적 메소드가 필요하다.
- 유일한 단일 객체를 참조할 정적 참조 변수가 필요하다.

i.e.

```java
public class LazyInitialization {
 
    private static LazyInitialization instance;
 
    private LazyInitialization(){}
     
    public static LazyInitialization getInstance(){
        if(instance == null){
            instance = new LazyInitialization();
        }
        return instance;
    }
 
}
```

⇒ 이 방식은 Thread-Safe 하지 않다.

```java
public class ThreadSafeLazyInitialization{
 
    private static ThreadSafeLazyInitializationinstance;
 
    private ThreadSafeLazyInitialization(){}
     
    public static synchronized ThreadSafeLazyInitializationgetInstance(){
        if(instance == null){
            instance = new ThreadSafeLazyInitialization();
        }
        return instance;
    }
 
}
```

⇒ 이 방식은 Thread-Safe 하긴 하지만 스레드가 여러개 일경우 lock, unlock 현상때문에 성능이 저하된다.

```java
package chapter6.singleton;

public class DoubleCheckInitialization {

    private volatile static DoubleCheckInitialization instance;

    private DoubleCheckInitialization() {}

    public static DoubleCheckInitialization getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckInitialization.class) {
                if(instance == null)
                    instance = new DoubleCheckInitialization();
            }
        }
        return instance;
    }
}
```

⇒ volatile 키워드를 사용하는데, 이는 Main Memory에서 값을 읽어옴으로써 각 쓰레드마다 CPU cache 에서 변화되는 값을 다르게 읽어오는 것을 방지한다.

⇒ 사실 코드가 복잡하고 성능도 좋지 않다고 한다.

```java
public class LazyHolderInitialization {
    private LazyHolderInitialization() {};

    private static class LazyHolder {
        private static final LazyHolderInitialization instance = new LazyHolderInitialization();
    }

    public static LazyHolderInitialization getInstance() {
        return LazyHolder.instance;
    }
}
```

⇒ 내부 클래스인 LazyHolder 클래스는 getInstance를 호출할때 static memory에 로드되며 Thread-safe 하면서 성능이 좋다

⇒ Inner class의 필드는 final로 지정하여 다시 할당되지 않게 한다.

⇒ 싱글톤 사용시 **클래스 로더가 2종류이면, 2개의 인스턴스가 만들어진다**.

⇒ 스프링에서의 싱글톤은 context 1개당 싱글톤 1개 이기 때문에 context 범위를 생각하여 생성을 해야 한다.

참조

[싱글턴 패턴(Singleton Pattern)](https://webdevtechblog.com/%EC%8B%B1%EA%B8%80%ED%84%B4-%ED%8C%A8%ED%84%B4-singleton-pattern-db75ed29c36)

## 5. 템플릿 메소드 패턴 - Template Method Pattern

> 상위 클래스의 견본 메소드에서 하위 클래스가 오버라이딩한 메소드를 호출하는 패턴


i.e.

```java
public abstract class Animal {

    public final void playWithOwner() {
        System.out.println("귀염둥이 이리온");
        play();
        runSomething();
        System.out.println("잘했어!!");
    }

    protected abstract void play();

    void runSomething() {
        System.out.println("꼬리 살랑 살랑~");
    }
}
```

```java
public class Dog extends Animal {

    @Override
    public void play() {
        System.out.println("멍멍!!!");
    }

    @Override
    //Hook (갈고리) 메소드 오버라이딩
    public void runSomething() {
        System.out.println("멍멍!! 꼬리 살랑살랑");
    }

}
```

```java
public class Cat extends Animal {
    @Override
    protected void play() {
        System.out.println("냐옹 냐옹~~");
    }
    
}
```

```java
귀염둥이 이리온
멍멍!!!
멍멍!! 꼬리 살랑살랑
잘했어!!
----------
귀염둥이 이리온
냐옹 냐옹~~
꼬리 살랑 살랑~
잘했어!!
```

⇒ 이처럼 상위 클래스에 **공통 로직을 수행하는 템플릿 메소드**와 하위 클래스에 오버라이딩을 강제하는 추상 메소드 또는 선잭적으로 오버라이딩할 수 있는 훅(Hook) 메소드를 두는 패턴을 템플릿 메소드 패턴이라고 한다.

⇒ `DIP 원칙`을 사용한다.

## 6. 팩토리 메소드 패턴 - Factory Method Pattern

> 팩토리 메소드는 객체를 생성 반환하는 메소드를 말한다. 여기에 패턴이 붙으면 **하위 클래스에서 팩토리 메소드를 오버라이딩해서 객체를 반환하게 하는 것을 의미**한다.
>

i.e.

```java
public class Driver {
    public static void main(String[] args) {
        Animal doong = new Dog();
        Animal sosa = new Cat();

        //팩토리 메소드 사용
        AniamlToy tennisball = doong.getToy();
        AniamlToy catTower = sosa.getToy();

        tennisball.identity();
        catTower.identity();
    }
}
```

```java
public abstract class Animal {
    abstract AniamlToy getToy();
}
```

⇒ `DIP 원칙`을 사용한다.

> 오버라이드된 메소드가 객체를 반환하는 패턴
>

## 7. 전략 패턴 - Strategy Pattern

- 전략 메소드를 가진 전략 객체
- 전략 객체를 사용하는 컨텍스트(전략 객체의 사용자/소비자)
- 전략 객체를 생성해 컨텍스트에 주입하는 클라이언트(제3자, 전략 객체의 공급자)

i.e. 군인이 있다고 상상해보자. 그리고 그 군인이 사용할 무기는 전략이 되고, 무기를 사용하는 군인은 컨텍스트, 그리고 무기를 보급해주는 보급장교는 제 3자, 즉 클라이언트가 된다.

```java
public class Soldier {
    void runContext(MyStrategy strategy) {
        System.out.println("전투 시작");
        strategy.runStrategy();
        System.out.println("전투 종료");
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        MyStrategy strategy = null;
        Soldier soldier = new Soldier();

        strategy = new Gun();
        soldier.runContext(strategy);

        strategy = new Sword();
        soldier.runContext(strategy);

        strategy = new Bow();
        soldier.runContext(strategy);
    }
}
```

⇒ 전략 패턴은 디자인 **패턴의 꽃이라고 할 정도로 다양한 곳에서 다양한 문제 상황의 해결책**으로 사용된다.

⇒ 그리고 혹시나 템플릿 메소드 패턴과 유사하다는 느낌이 든다면, 제대로 본것이다. **같은 문제의 해결책**으로 **상속을 이용하는 템플릿 메소드 패턴**과 **객체 주입을 통한 전략 패턴** 중에서 선택/적용 할 수 있다.

⇒ `OCP(개방 폐쇄 원칙)` 과 `DIP(의존 역전 원칙)`이 적용되었다.

> 클라이언트가 전략을 생성해 전략을 실행한 컨텍스트에 주입하는 패턴
>

## 8. 템플릿 콜백 패턴 - Template Callback Pattern (견본/회신 패턴)

> 템플릿 콜백 패턴은 전략 패턴의 변형으로, 스프링 3대 프로그래밍 모델 중 하나인 DI(의존성 주입)에서 사용하는 특별한 형태의 전략 패턴이다.
전략패턴과 모든 것이 동일한데 **전략을 익명 내부 클래스로 정의해서 사용한다**는 특징이 있다.
>

i.e.

```java
public class Client {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.runContext(new MyStrategy() {
            @Override
            public void runStrategy() {
                System.out.println("총초초초오오옹!!!");
            }
        });

        soldier.runContext(new MyStrategy() {
            @Override
            public void runStrategy() {
                System.out.println("카카라칼 쉥쉥엥잉~~");
            }
        });

        soldier.runContext(new MyStrategy() {
            @Override
            public void runStrategy() {
                System.out.println("독끼!!!도도도끼끼끼끾");
            }
        });
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.runContext("총초초초오오옹!!!");

        soldier.runContext("카카라칼 쉥쉥엥잉~~");

        soldier.runContext("독끼!!!도도도끼끼끼끾");
    }
}

public class Soldier {
    void runContext(String sound) {
        System.out.println("전투 시작");
        executeWeapon(sound).runStrategy();
        System.out.println("전투 종료");
    }
    
    private MyStrategy executeWeapon(String sound) {
        return new MyStrategy() {
            @Override
            public void runStrategy() {
                System.out.println(sound);
            }
        };
    }
}
```

⇒ 리팩토링을 하게 되면 **전략을 생성하는 코드가 컨텍스트 안으로 들어오게 된다**.

⇒ 전략 패턴과 동일하게 `OCP(개방 폐쇄 원칙)` 과 `DIP(의존 역전 원칙)`이 적용되었다.

> 전략을 익명 내부 클래스로 구현한 전략 패턴

        soldier.runContext(new MyStrategy() {
            @Override
            public void runStrategy() {
                System.out.println("독끼!!!도도도끼끼끼끾");
            }
        });
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.runContext("총초초초오오옹!!!");

        soldier.runContext("카카라칼 쉥쉥엥잉~~");

        soldier.runContext("독끼!!!도도도끼끼끼끾");
    }
}

public class Soldier {
    void runContext(String sound) {
        System.out.println("전투 시작");
        executeWeapon(sound).runStrategy();
        System.out.println("전투 종료");
    }
    
    private MyStrategy executeWeapon(String sound) {
        return new MyStrategy() {
            @Override
            public void runStrategy() {
                System.out.println(sound);
            }
        };
    }
}
```

⇒ 리팩토링을 하게 되면 **전략을 생성하는 코드가 컨텍스트 안으로 들어오게 된다**.

⇒ 전략 패턴과 동일하게 `OCP(개방 폐쇄 원칙)` 과 `DIP(의존 역전 원칙)`이 적용되었다.

> 전략을 익명 내부 클래스로 구현한 전략 패턴