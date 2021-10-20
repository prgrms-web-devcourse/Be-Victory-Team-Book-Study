package QnA.LSP_ISP.interfaces;

public interface JobGettable {
    void preparePortfolio();

    default void doMyBest() {
        System.out.println("취준생은 항상 최선을 다한다.");
    }
}
