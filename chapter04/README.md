# 04. 자바가 확장한 객체 지향

이번 장에서는 자바가 객체 지향을 확장하기 위해 사용하는 키워드와 개념을 살펴본다.

## abstract 키워드 - 추상 메서드와 추상 클래스

추상 메서드?

- 선언부는 있는데 구현부가 없는 메서드를 말한다.
- 물론 추상 메서드 없이도 추상 클래스를 선언할 수는 있다.

추상 메서드 사용 목적

- 추상 메소드가 포함된 클래스를 상속받는 자식 클래스가 반드시 추상 메소드를 구현하도록 하기 위함입니다.
- 중복되는 부분이나 공통적인 부분은 미리 다 만들어진 것을 사용하고, 이를 받아 사용하는 쪽에서는 자신에게 필요한 부분만을 재정의하여 사용함으로써 생산성이 향상되고 배포 등이 쉬워지기 때문

추상 클래스?

- 하나 이상의 추상 메소드를 포함하는 클래스를 가리켜 추상 클래스
- 추상 클래스에 추상 메소드로 선언해 놓으면, 이 클래스를 상속받는 모든 클래스에서는 이 추상 메소드를 반드시 재정의해야 함.

## 생성자

생성자?

- 반환값이 없고 클래스명과 같은 이름을 가진 메서드를 객체를 생성하는 메서드라고 하여 객체 생성자 메서드(생성자)라고 함.

특징

- 생성자를 생략하면 컴파일 과정에서 자바 컴파일러가 알아서 기본 만들어 줌.

## 클래스 생성 시의 실행 블록, static 블록

```java
public class ClassName {
  static {
    System.out.println("이런 블럭 보신적 있나용~?");
  }
}
```

클래스가 스태틱 영역에 배치될 때 실행되는 코드 블록.

스태틱 영역에 한번 올라가면?

- 프로그램이 종료되기 전까지는 해당 메모리를 반환할 수 없다.
- 하지만 최대한 늦게 로딩(Lazy Loading) 함으로써 메모리 사용을 최대한 늦춘다.

> ### JUnit의 `@BeforeClass` 와 Static Initializer
>
> Static Initializer는 JUnit이 아닌 JVM에 의해 호출 된다. 만약 예외가 static initializer 내부에서 발생된다면 테스트 프레임워크는 예외를 처리하고 보고하는 작업을 못 한다. 더 나아가 static initializer의 호출 시간은 `@BeforeClass` 메서드와 비교하여 잘 정의되지 않는다. static initializer는 정적 속성, 정적 메서드 또는 생성자 중 하나의 접근과 같은 첫 번째 실제 사용 시 클래스 로더당 한 번만 실행된다. 때론 이게 언제가 될지 가늠하기 어려울 때가 있다. (그래서 static initializer는 미래에 복잡한 버그를 야기할 수 있다.)
>
> 반면에 `@BeforeClass`는 각 클래스의 테스트 코드가 실행되기 전 실행된다. 클래스가 상속에 기반한 테스트와 같이 다른 테스트의 대상이 되는 경우 static initializer는 이 클래스를 사용하여 첫 번째 테스트에서만 실행된다. 이것은 우리가 결코 원하지 않는 것에 따라 우리의 test order를 만들었다는 것을 의미한다.
>
> 두 옵션 사이의 의미론적 차이는 테스트를 위해 @Before 또는 생성자를 사용하는 것보다 더 크다. final argument에 따라 주석의 문서적 가치에 대해 생각해보라. 그것은 우리의 의도를 더 읽기 쉽게 만든다.
>
> 이 규칙의 유일한 예외는 불변의 상수일 것이다. 컴파일 시간 상수를 반영하고 코드를 간결하게 유지하기 위해 선언내에서 초기화해야 한다. 값이 아무리 변덕스럽다 해도 정적 값을 전혀 사용해서는 안 된다. 다시 말하지만, 테스트에서 변경되는 mutable 값은 피해야 할 테스트에 순서 의존성을 도입한다.
>
> 그래서, `@BeforeClass`를 사용해라!
>
> 참고 : [@BeforeClass vs static{}](https://stackoverflow.com/questions/15493189/beforeclass-vs-static)
>
> +) JUnit의 실행 순서를 자세히 살펴보면 `static block` -> `@Parameter` -> `@BeforeClass` -> `Before` ->  `@Test` 식으로 흘러간다.

> ### Initializing Instance Members

## final 키워드

### 1. final과 클래스

클래스에 final이 붙어있다면 상속을 허락하지 않겠다.

### 2. final과 변수

변수에 final이 붙어있다면 변경을 허락하지 않는 상수.

### 3. final과 메서드

오버라이딩을 금지한다.

## instanceof 연산자

만들어진 객체가 특정 클래스의 인스턴스인지 물어보는 연산자.

객체 지향 설계 5원칙 가운데 LSP(리스코프 치환 원칙)를 어기는 코드에서 주로 나타나는 연산자이기 때문에 리팩토링의 대상이 된다.

> ### 왜?
>
> LSP는 OCP(개방폐쇄원칙)을 받쳐주는 다형성에 관한 원칙을 제공한다. 상위 타입의 객체를 하위 타입의 객체로 치환해도 상위 타입을 사용하는 프로그램은 정상적으로 동작해야 한다.
>
> 그래서 `instanceof` 연산자는 타입을 확인하는 기능을 사용하기 때문에 LSP 원칙이 깨지는 주요 현상이다.

> ### LSP Example
>
> before)
>
> ```java
> public class Coupon {
>     public int calcuateDiscountAmount(Item item) {
>         if (item instanceof SpecialItem) // LSP 위반
>             return 0;
>         
>         return item.getPrice() * discountRate;
>     }
> }
> ```
>
> 
>
> after)
>
> ```java
> public class Item {
>     public boolean isDiscountAvailable() {
>         return true;
>     }
> }
> 
> public class SpecialItem extends Item {
>     // 하위 타입에서 알맞게 오버라이딩
>     @Override
>     public boolean isDiscountAvailable() {
>         return false;
>     }
> }
> 
> public class Coupon {
>     public int calcuateDiscountAmount(Item item) {
>         if (!item.isDiscountAvailable()) // instanceof 연산자 제거
>             return 0;
>         
>         return item.getPrice() * discountRate;
>     }
> }
> ```

인터페이스의 구현 관계에서도 동일하게 적용됨.

## package 키워드

네임스페이스를 만들어주는 역할.

## interface 키워드와 implements 키워드

인터페이스는 public 추상 메서드와 public 정적 상수만 가질 수 있다.

```java
interface InterfaceName {
  double PI = 3.141516;
  final double absouteZeroPoint = -2123.13;
  
  void hello();
}

// 동일
interface InterfaceName {
  public static final double PI = 3.141516;
  public static final double absouteZeroPoint = -2123.13;
  
  public abstract void hello();
}
```

자바가 알아서 붙여줌.

- 생략보단 명확하게 하여 모두가 읽기 쉬운 코드로 만드는 것이 중요하다.

### +) 람다

자바 7, 8에 자바에 함사형 언어 특성을 수용하였음.

쉽게 말해, 람다는 변수를 저장할 수 있는 로직.

디폴트 메서드라고 하는 객체 구상 메서드와 정적 추상 메서드를 지원할 수 있게 언어 스펙이 바뀜.

## this 키워드

자기 자신을 지칭할 때 쓰는 키워드.

## super 키워드

상위 클래스의 인스턴스를 지칭하는 키워드.



