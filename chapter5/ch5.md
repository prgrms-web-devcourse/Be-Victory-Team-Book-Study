# Ch5. 객체 지향 설계 5원칙 - SOLID


## 프롤로그

객체 지향 설계 5원칙은 **객체지향 언어라는 도구를 도구의 용도에 맞게 사용할 수 있는 방법**이다.

- SRP(Single Responsibility Principle) : 단일 책임 원칙
- OCP(Open Closed Principle) : 개방 폐쇄 원칙
- LSP(Liskov Substitution Principle) : 리스코프 치환 원칙
- ISP(Interface Segragation Principle) : 인터페이스 분리 원칙
- DIP(Dependency Inversion Principle) : 의존 역전 원칙

⇒ 이 원칙들은 **응집도는 높이고(High Cohesion), 결합도는 낮추라(Loose Coupling)는 고전 원칙을 객체 지향 관점에서 재정립한 것**이라고 할 수 있다.

> SOLID는 객체 지향 프로그램을 구성하는 속성, 메소드, 클래스 ,객체, 패키지, 모듈, 라이브러리, 프레임워크, 아키텍쳐 등 다양한 곳에 다양하게 적용되는 것이기에 막상 SOLID가 적용됐는지 아닌지 애매모호하거나 보는 사람의 관점에 따라 다르게 해석될 수 잇는 소지가 있음을 밝혀둔다. SOLID 자체는 제품이 아닌 개념이기에 그렇다.
>

[객체지향 개발 5대 원리: SOLID](https://www.nextree.co.kr/p6960/)

## SRP - 단일 책임 원칙

> 어떤 클래스를 변경해야 하는 이유는 오직 하나뿐이어야 한다.
> 
> 로버트 C.마틴


Man 이라는 class 에 남자친구의 역할, 아들의 역할, 사원의 역할, 소대원의 역할이 모두 들어가 있으면 객체 지향 적으로 '나쁜 냄새' 가 난다고 표현한다.

이런 경우에 **역할(책임, 기능) 을 분리하라는 것이 단일 책임 원칙**이다.

BoyFriend , Son, Staff, Soldier 의 클래스로 분리할 수 있다.

⇒ 여기서는 클래스의 분할에 대해서만 이야기했지만 단일 책임 원칙은 **속성, 메소드, 패키지, 모듈, 컴포넌트, 프레임워크 등에도 적용할 수 있는 개념**이다.

i.e. 안좋은 예시

```java
public class Dog {

    final static boolean MALE = true;
    final static boolean FEMALE = false;

    boolean sex;

    void 소변보다() {
        if(sex == MALE) {
            System.out.println("다리를 들고 소변본다.");
        } else {
            System.out.println("앉아서 소변본다.");
        }
    }
}
```

⇒ 메소드가 단일 책임 원칙을 지키지 않았을 경우 나타나는 **대표적인 냄새가 바로 분기 처리를 위한 if 문**이다.

⇒ 단일 책임 원칙과 **가장 관계가 깊은 객제지향 4대 특성은 바로 [모델링 과정을 담당하는 추상화](https://www.notion.so/Ch3-34116333388043a590d0101ae1644d24)임**을 알 수 있다. 애플리케이션의 경계를 정하고 추상화를 통해 클래스들을 선별하고 속성과 메소드를 설계할 때 반드시 단일 책임 우너칙을 고려하는 습관을 들이자.

## OCP - 개방 폐쇄 원칙

> 소프트웨어 엔티티(클래스, 모듈, 함수 등)는 확장에 대해서는 열려 있어야 하지만 변경에 대해서는 닫혀 있어야 한다.
>
> 로버트 C.마틴

⇒ 자신의 확장에는 열려 있고 주변의 변화에는 대해서는 닫혀 있어야 한다.

i.e.

- 사람이 **자동차**를 바꿨다고 해서 **액셀을 밟고 브레이크를 밟는 것이 바뀌지 않듯이**, 자동차 라는 중간에 인터페이스를 두면 **아반떼를 타든, 벤츠를 타든** 자신은 확장할 수 있고 변화에는 폐쇄되어 있을 수 있다.
- **JDBC**를 사용하는 클라이언트는 데이터베이스가 오라클에서  MySQL로 바뀌더라도 Connection을 설정하는 부분 외에는 따로 수정할 필요가 없다. **Connection 설정 부분을 별도의 설정 파일로 분리해두면 클라이언트 코드는 단 한 줄도 변경할 필요가 없다**.
- 자바 개발자는 작성하고 있는 소스코드가 윈도우에서 구동될지, 리눅스에서 구동될지에 대해서는 걱정하지 않는다. **각 운영체제별 JVM과 목적파일(.class)이 있기에** 개발자는 다양한 구동 환경에 대해서는 걱정하지 않고 본인이 작업하고 있는 개발 PC에 설치된 JVM에서 구동되는 코드만 작성하면 된다.
  개발자가 **작성한 소스코드는 운영체제의 변화에 닫혀 있고, 각 운영체재별 JVM은 확장에 열려 있는 구조가 되는 것이다**.

```java
public class Customer {

    public static void main(String[] args) {
        var sellingPerson = new SellingPerson();
        var securityPerson = new SecurityPerson();
        var cleaningPerson = new CleaningPerson();
        var boss = new Boss();
        buy(sellingPerson);
        buy(securityPerson);
        buy(cleaningPerson);
        buy(boss);
    }

    static void buy(Selling sellingPerson) {
        sellingPerson.sell();
    }
}
```

## LSP - 리스코프 치환 원칙

> 서브 타입은 언제나 자신의 기반 타입(base type)으로 교체할 수 있어야 한다.
>
> 로버트 C.마틴

⇒ 상속에 대해 설명하면서 객체 지향에서의 **상속은 조직도나 계층도가 아닌 분류도가 되어야 한다**고 했다.

- 하위 클래스 **is a kind of** 상위 클래스 - 하위 분류는 상위 분류의 한 종류다.
- 구현 클래스 **is able to** 인터페이스 - 구현 분류는 인터페이스 할 수 있어야 한다.

⇒ 하위 클래스의 인스턴스는 상위형 객체 참조 변수에 대입해 상위 클래스의 인스턴스 역할을 하는데 문제가 없어야 한다.

```java
public class Driver {

    public static void main(String[] args) {
        sayNameAndSchool(new HighSchoolStudent("빅토리" , "서울고"));
        sayNameAndSchool(new UniversityStudent("빅토리" , "서울대"));
    }
    
    static void sayNameAndSchool(Student student) {
        student.goToSchool();
    }
}
```

i.e.

고래가 포유류 또는 동물의 역할을 하는 것은 전혀 문제가 되지 않는다.

[리스코프 치환 원칙 - 위키백과, 우리 모두의 백과사전](https://ko.wikipedia.org/wiki/%EB%A6%AC%EC%8A%A4%EC%BD%94%ED%94%84_%EC%B9%98%ED%99%98_%EC%9B%90%EC%B9%99)

## ISP - 인터페이스 분리 원칙

> 클라이언트는 자신이 사용하지 않는 메소드에 의존 관계를 맺으면 안된다.
>
> 로버트 C.마틴

⇒ 단일 책임 원칙에서 남자 클래스를 토막내서 하나의 역할만 하는 다수의 클래스로 분할 하였다. 꼭 그방법 뿐일까?

i.e.

남자 클래스를 토막내는 것이 아니라 다중 인격화(?)시켜서 여자친구를 만날때는 **남자친구 역할만 할 수 있게 인터페이스로 제한하고 어머니와 있을때에는 아들 인터페이스로 제한**한다.

```java
public class Driver {

    public static void main(String[] args) {
        var man = new Man();
        behaveLikeBoyFriend(man);
        behaveLikeSoldier(man);
        behaveLikeSon(man);
        behaveLikeStaff(man);
    }

    static void behaveLikeSon(Son son) {
        son.안마하기();
        son.효도하기();
    }

    static void behaveLikeBoyFriend(BoyFriend boyFriend) {
        boyFriend.기념일챙기기();
        boyFriend.키스하기();
    }

    static void behaveLikeStaff(Staff staff) {
        staff.아부하기();
        staff.출근하기();
    }

    static void behaveLikeSoldier(Soldier soldier) {
        soldier.구보하기();
        soldier.사격하기();
    }

}
```

⇒ [상위 클래스는 풍성할수록 좋고 인터페이스는 작을수록 좋다고 한 이유를 살펴보자](https://www.notion.so/_-Chapter3-1bbcd1b6632944d8a2e67c76a39f312c)

## DIP - 의존 역전 원칙

> 고차원 모듈은 저차원 모듈에 의존하면 안된다. 이 두 모듈 모두 다른 추상화된 것에 의존해야 한다.
추상화 된것은 구체적인 것에 의존하면 안된다. 구체적인 것이 추상화된 것에 의존해야 한다.
자주 변경되는 구체(Concrete) 클래스에 의존하지 마라.
>
> 로버트 C.마틴

![E4E222D9-3C6B-4F14-A434-9FA38607FCC8](https://user-images.githubusercontent.com/43133800/138990290-12ab9309-2881-48cb-a069-3da56dace2ec.png)


의존이 역전된(화살표 방향이 바뀜) 사진(Dependency Inversion)

⇒ OCP(개방 폐쇄 원칙)과 비슷한 설명이 들어갈 수 있다. 이처럼 하나의 해결책을 찾으면 그 안에 여러 설계 원칙이 녹아있는 경우가 많다.

⇒ **자신보다 변하기 쉬운 것에 의존하던 것을 추상화된 인터페이스나 상위 클래스를 두어** 변하기 쉬운 것의 변화에 영향 받지 않게 하는 것이 의존 역전 원칙이다.

i.e.

```java
public class Driver {
    public static void main(String[] args) {
        Car.goHome(new BestDriver(), new SnowTire());
        Car.goHome(new WorstDriver(), new NormalTire());
    }
}
```

```java
public class Car {
    static void goHome(Driver driver, Tire tire) {
        driver.drive();
        tire.roll();
    }
}
```

> 인간보다는 신을, 아이보다는 어른을, 부하직원보다는 상사에게 의지하게 되는데 바로 **신이 인간보다, 어른이 아이보다, 상사가 부하 직원보다 변할 가능성이 적기** 때문이다.
상위 틀래스, 인터페이스, 추상 클래스 일수록 변하지 않을 가능성이 높기 때문에 하위 클래스나 구체 클래스가 아닌 **상위 클래스, 인터페이스, 추상 클래스를 통해 의존하라는 것이 바로 의존 역전 원칙**이다.
>

## 정리 - 객체 지향 세계와 SOLID

> SOLID를 이야기할때 빼놓을 수 없는 것이 SoC이다. SoC은 관심사의 분리(Separation Of Concerns)의 머릿글자다.
**관심이 같은 것끼리는 하나의 객체 안으로 또는 친한 객체**로 모으고, 관심이 다른 것은 가능한 한 따로 떨어져 서로 영향을 주지 않도록 분리하라는 것이다.
>

**SOLID 원칙을 적용하면 소스 파일의 개수는 더 많아지지만 원칙을 적용함으로써 얻는 혜택에 비하면 늘어나는 소스 파일 개수에 대한 부담은 충분히 감수하고도 남을 만 하다.**


추천도서
- Head First Design Patterns (한빛미디어, 2005)
- 토비의 스프링 3.1 (에이콘출판, 2012)
- 도메인 주도 설계란 무엇인가? (인사이트, 2011)
- 도메인 주도 설계 (위키북스, 2011)