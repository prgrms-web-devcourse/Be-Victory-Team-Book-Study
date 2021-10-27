
# Ch4. 자바가 확장한 객체 지향


## abstract 키워드 - 추상 메소드와 추상 클래스

- 추상메소드 : 선언부는 있는데 구현부가 없는 메소드를 말한다.

- 추상클래스 : 추상메소드를 하나라도 갖고있는 클래스는 반드시 Abstract class로 선언한다.

  ⇒ 추상 클래스는 인스턴스, 즉 객체를 만들 수 없는 클래스가 된다.

  ⇒ 실수로 추상 클래스로 인스턴스를 만들지 못하게 할때, 하위 클래스에 강제적으로 Override 할 메소드를 필요로 할때 만든다.



## 생성자

> 반환값이 없고 클래스명과 같은 이름을 가진 메소드를 객체를 생성하는 메소드라고 해서 **객체 생성자 메소드** 라고 한다.

⇒ 따로 생성자를 선언하지 않으면 컴파일 과정에서 자바 컴파일러가 알아서 기본 생성자를 만들어준다.



⇒ 인자가 있는 생성자를 하나라도 만든다면 자바는 기본 생성자를 만들어 주지 않기 때문에 개발자가 선언해줘야 한다.



## 클래스 생성 시의 실행 블록, static 블록


> 클래스가 static 영역에 배치될때 실행되는 코드 블록이 있다. 바로 static 블록이다.




⇒ static 블록에서 사용할 수 있는 속성과 메소드는 당연히 static 멤버이다. 객체 멤버는 클래스가 static 영역에 자리잡은 후에 객체 생성자를 통해 heap 에 생성된다. 클래스의 **static 블록이 실행되고 있을때에는 해당 클래스의 객체는 존재하지 않기 때문에 static 블록에서는 객체 멤버에 접근할 수 없다**.



설명을 쉽게 하기위해 앞에서는 프로그램이 시작될때 모든 패키지와 모든 클래스가 T메모리의 스태틱 영역에 로딩된다고 설명했다.

실제로는 **해당 패키지 또는 클래스가 처음으로 사용될때** 스태틱 영역에 로딩된다.



i.e. Junit5 의 @BeforeAll



⇒ 인스턴스 블록은 {} 인스턴스를 생성할때마다 실행되는데, 생성자 코드가 실행되기 전에 실행된다.



## final 키워드

- final 클래스 : 상속을 허락하지 않겠다는 의미의 클래스

- final 변수 : 변경 불가능한 상수. 선언시 or 객체 생성자 or 인스턴스 블록 안에서 최초 한번만 초기화가 가능하다.

- final 메소드 : Override 를 금지하는 메소드.



## instanceof 연산자

> 만들어진 객체가 특정 클래스의 인스턴스인지 물어보는 연산자이다.




⇒ 이 연산자가 강력하기는 하지만 객체 지향 설계 5원칙 가운데 LSP(리스코프 치환 원칙) 를 어기는 코드에서 자주 나타난다.



**⇒ 하위 객체로 치환 되더라도 상위 클래스로 선언된 기능은 아무 문제 없이 되어야 하기 때문에**.



## package 키워드

> package 키워드는 네임스페이스(이름공간)을 만들어주는 역할을 한다.



## interface 키워드와 implements 키워드

- 인터페이스는 public abstract 메소드와 public static 상수만 가질 수 있다.

  ⇒ 이 때문에 각 메소드와 변수에 따로 선언하지 않아도 컴파일 시에, public abstract 와 public static final을 붙여준다.



## this 키워드

> 객체가 자기 자신을 지칭할 때 쓰는 키워드이다.




⇒ 지역 변수와 속성(객체 변수, 정적 변수) 의 이름이 같은 경우 지역 변수가 우선한다.



⇒ 객체 변수와 이름이 같은 지역 변수가 있는 경우 객체 변수를 사용하려면 this를 접두사로 사용한다.



⇒ 정적 변수와 이름이 같은 지역변수가 있는 경우 정적 변수를 사용하려면 클래스명을 접두사로 사용한다.



## super 키워드

> 단일 상속만을 지원하는 자바에서 super는 바로 위 상위 클래스의 인스턴스를 지칭하는 키워드이다.



## 예비 고수를 위한 한마디

⇒ 여러가지 객체를 만들었을때 메모리 낭비를 방지 하기 위해 클래스의 메소드를 static으로 바꾸고 static 영역에서 관리한다구?




```java
public class ThisKeyWord {
    public void checkThis() {
        System.out.println("ThisKeyWord.checkThis invoked");
    }
}

public class ThisKeyWord {
    public static void checkThis(ThisKeyWord keyWord) {
        System.out.println("ThisKeyWord.checkThis invoked");
    }
}
```

```java
public class Driver {

    public static void main(String[] args) {
        ThisKeyWord this1 = new ThisKeyWord();
        this1.checkThis();
    }
}

public class Driver {

    public static void main(String[] args) {
        ThisKeyWord this1 = new ThisKeyWord();
        ThisKeyWord.checkThis(this1);
    }
}
```



⇒ 그럼 싱글톤으로 있다는 건가? [답변글](https://www.notion.so/_-Chapter4-9e58b60d6ee946a9a3bb5ce5540cecff)