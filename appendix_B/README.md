# 부록 B. 자바 8 람다와 인터페이스 스펙 변화

날짜: 2021년 11월 15일

기업 환경 변화와 프로그래머들의 요구를 반영하기 위해 자바 8은 언어적으로 많은 변화를 맞이했다.

특히 함수형 프로그래밍을 위한 람다의도입이 두드러진다. 람다의 개념과 이를 지원하기 위해 변화된 인터페이스 스펙 부분을 살펴본다.

## B1. 람다가 도입된 이유

- 빅데이터의 분석 및 활용을 위해 프로그래머들에게 병렬화 기술이 필요했다.
- 점차 규모가 커져만 가는 데이터를 처리하기 위한 방법이 필요했고, 자바 8에서는 병렬화를 위해 컬렉션을 강화했고, 이러한 컬렉션을 더 효율적으로 사용하기 위해 스트림을 강화했다.
  - 스트림을 효율적으로 사용하기 위해 함수형 프로그래밍이,
  - 함수형 프로그래밍을 사용하기 위해 람다가
  - 람다를 사용하기 위해 인터페이스의 변화가 수반됐다.
- 람다를 지원하기 위한 인터페이스를 함수형 인터페이스라고 한다.

## B2. 람다란 무엇인가?

람다 함수는 함수형 프로그래밍 언어에서 사용되는 개념으로 **익명 함수**라고도 한다. Java 8 부터 지원되며, 불필요한 코드를 줄이고 가독성을 향상시키는 것을 목적으로 두고있다.

- 특징
  - 기존에는 코드 블록을 위해 메서드를, 다시 메서드를 사용하기 위해 익명 객체를 만들거나 하는식이었다.
  ```java
  public class Main {
  	public static void main(String[] args) {
  		Mytest mt = new MyTest();

  		Runnable r = mt;

  		r.run();
  	}
  }

  class MyTest implements Runnable {
  	@Override
  	public void run() {
  		System.out.println("Hello Lambda!!");
  	}
  }
  ```
  - 코드 블록인 람다를 메서드의 인자나 반환값으로 사용할 수 있게 됐다.
  ```java
  // CASE1 : 익명 객체 생성하는 방법
  public class Main {
  	public static void main(String[] args) {
  		Runnable r = new Runnable() {
  			@Override
  			public void run() {
  				System.out.println("Hello Lambda!!");
  			}
  		}
  		r.run();
  	}
  }
  ```
  ```java
  // CASE2 : Lambda
  public class Main {
  	public static void main(String[] args) {
  		Runnable r = () -> System.out.println("Hello Lambda!!");
  		r.run();
  	}
  }
  ```
  - Runnable 타입으로 참조 변수 r을 만들고 있으니 `new Runnable()` 은 컴파일러가 알아낼 수 있다. 따라서 굳이 코드로 작성할 필요가 없어졌으며 `new Runnable()`이 사라질 수 있었다.
  - Runnable 인터페이스가 가진 추상 메서드가 run() 메서드가 단 하나이기 때문에 단순하게 `public void run()`이 `()` 로 변했다.

## B3. 함수형 인터페이스

위 처럼 추상 메서드를 하나만 갖는 인터페이스를 자바 8부터는 함수형 인터페이스라고 한다. 이런 함수형 인터페이스만을 람다식으로 변경할 수 있다.

```java
@FunctionalInterface
public interface MyFunctionalInterface {
	public abstract int runSomething(int count);
}

// 사용
MyFunctionalInterface mfi = (int a) -> { return a * a; };
int result = mfi.runSomething(2);
```

## B4. 메서드 호출 인자로 람다 사용

람다식을 함수형 인터페이스의 참조 변수에 저장해서 사용했다. 람다식을 변수에 저장하는 것이 가능하다면 당연히 메서드의 인자로도 사용할 수 있다.

```java
@FunctionalInterface
public interface MyFunctionalInterface {
	public abstract int runSomething(int count);
}

// 사용
class My {
	public static void main(String[] args) {
		MyFunctionalInterface mfi = a ->  a * a;

		doIt(mfi);
		// 또는
		doIt(a -> a * a); // 람다식을 한 번만 사용한다면 굳이 변수에 할당할 필요도 없다.
	}
	public static void doIt(MyFunctionalInterface mfi) {
		System.out.println(mfi.runSomething(5));
	}
}
```

## B5. 메서드 반환값으로 람다 사용

```java
// 사용
class My {
	public static void main(String[] args) {
		MyFunctionalInterface mfi = todo();

		int result = mfi.runSomething();
	}
	public static MyFunctionalInterface todo() {
		return num -> num * num;
	}
}
```

## B6. 자바 8 API에서 제공하는 함수형 인터페이스

사용자 정의 함수형 인터페이스를 만들어 사용했다. 자바 8 API 에서 많이 쓸 것이라고 예상되는 함수형 인터페이스를 미리 java.util.function 패키지와 여러 패키지에서 제공하고 있다.

[자바 8 API에서 제공하는 대표적 함수형 인터페이스](https://www.notion.so/da41780bc55040989db2ac46ed25d555)

## B7. 컬렉션 스트림에서 람다 사용

람다는 다양한 용도가 있지만 그 중에서도 컬렉션 스트림을 위한 기능에 크게 초점이 맞춰져 있다.

```java
Integer[] ages = {20, 21, 23, 25, 26, 27, 28, 29};
Arrays.stream(ages) // 기존 배열을 이용해 스트림 을 얻는다.
	.filter(age -> age < 20) // Predicate 함수형 인터페이스를 filter 메서드의 인자로 제공하면 된다.
	.forEach(ages -> System.out.println("Age : " + age)); // 전달된 인자를 소비하는 함수형 인터페이스
```

이를 통해 How가 아닌 What만을 지정하여 **함수형 프로그래밍의 장점인 선언적 프로그래밍을 활용할 수 있다.**

(_"어떻게 하라"_ 보다는 _"무엇을 원한다"_ 라고 선언하는 것과 같다)

또한 스트림은 메서드 체인 패턴을 이용해 최종 연산이 아닌 모든 중간 연산은 다시 스트림을 반환해 코드를 간략하게 작성할 수 있다.

스트림은 고객의 요구를 선언적으로 코딩할 수 있는 힘을 준다.

- 고객은 해당 코드가 무슨 일을 하는지 파악하기 쉽고
- 의사소통 내용 자체가 그대로 코드로 구현되는 것이 선언적 프로그래밍의 장점

## B8. 메서드 레퍼런스와 생성자 레퍼런스

메서드 레퍼런스란 람다식을 이용해 인자를 아무런 가공 없이 그대로 출력할 수 있는 형식이다.

```java
Integer[] ages = {20, 21, 23, 25, 26, 27, 28, 29};

Arrays.stream(ages)
	.filter(age -> age < 20)
	.forEach(System.out::println); // <- 메서드 래퍼런스 사용
```

[메서드 레퍼런스 유형](https://www.notion.so/2c90476ec822499c8994f0a7403d5ca2)

### 생성자 레퍼런스

```java
클래스::new

Supplier<MyClass> factory = MyClass::new;
MyClass m1 = factory.get();
MyClass m2 = factory.get();
```

## B9. 인터페이스의 디폴트 메서드와 정적 메서드

자바 8 이전에는 인터페이스가 가질 수 있는 멤버는 다음과 같다.

- 정적 상수
- 추상 인스턴스 메서드

자바 8 에서는 인터페이스에 큰 변화가 생겼다.

- 정적 상수
- 추상 인스턴스 메서드
- **(추가) 구체 인스턴스 메서드 - 디폴트 메서드**
- **(추가) (구체) 정적 메서드**

인터페이스도 구체 인스턴스 메서드, 즉 몸체를 가진 인스턴스 메서드를 가질 수 있게 되었다.

```java
@FunctionalInterface
public interface MyFunctionalInterface {
	// 정적 상수
	public static final int CONSTANT = 1;

	// 추상 인스턴스 메서드
	public abstract int runSomething(int count);


	// (추가) 구체 인스턴스 메서드 - 디폴트 메서드
	public default void concreteInstanceMethod() {
		System.out.println("this is default method");
	}

	// (추가) (구체) 정적 메서드
	public static void concreateStaticMethod() {
		System.out.println("정적 메서드 - 구체 정적 메서드");
	}
}
```

인터페이스의 스펙 변화를 통해 람다가 가능해졌고, 연쇄적으로 더 강화된 컬렉션 API를 사용할 수 있게 되었고 함수형 프로그래밍이 가능해졌다.

### 인터페이스에 디폴트 메서드와 정적메서드를 추가한 이유

- 컬렉션 API를 강화하려면 컬렉션의 공통 조상인 Collection의 슈퍼 인터페이스인 Iterable 인터페이스에 많은 변화가 필요했다.
- 인터페이스에 변화를 주게 되면, 즉 새로운 추상 인스턴스 메서드를 추가하게 되면 기존에 해당 인터페이스를 구현한 모든 사용자 정의 클래스는 이를 추가적으로 구현해야만 했다.
- 이는 자바 6, 7로 만들어진 많은 프로그래밍들이 자바 8 기반 JVM에서 구동될 수 있게 디폴트 메서드라고 하는 새로운 개념을 인터페이스 스펙에 추가한 것.
- 디폴트 메서드와 정적 메서드의 도입으로 기존에 작성한 프로그램들도 아무런 사이드 이펙트 없이 자바 8 JVM에서 구동된다.
- 향후 만들어지는 프로그램들도 인터페이스 스펙에 추가된 디폴트 메서드와 정적 메서드로부터 많은 혜택을 받을 수 있을 것이다.

## B10. 정리

```java
람다 = 변수에 저장 가능한 로직
```

람다가 메서드의 역할을 하게 됨으로써, 객체 메서드나 정적 메서드 안에 구현하지 않아도 됨.

- 디자인 패턴에서는 로직을 사용하기 위해 메서드를 구성하고 해당 메서드를 사용하기 위해 클래스를 선언하는 절차들이 있었다.
- 람다를 이용한다면, DI의 핵심이라고 할 수 있는 템플릿 콜백 패턴에 람다를 적용하면 편해진다.

+) 빅데이터 자원을 위해 병렬화를 하고 병렬화 지원을 위해 스트림을 사용한다고 했었다.

- 이때 사용하는 것은 `parallelStream()` 이고, 병렬 스트림을 지원하는 컬렉션에서 `stream()` method 대신 `parallelStream()` 을 사용하면 스트림을 병렬로 처리할 수 있다.
