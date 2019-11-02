package mape.pattern.p06.observer;

public class Runner {

    private static final String NY_POST = "NY Post";
    private static final String INDEPENDENT = "Independent";

    public static void main(String[] args) {
        final Post post = new Post();
        final Subscriber john_carter = new Subscriber("John Carter");
        post.addSubscriber(NY_POST, john_carter);
        post.addSubscriber(NY_POST, new Subscriber("Anonymous"));
        post.addSubscriber(NY_POST, new Subscriber("Ivan Ivanov"));
        post.addSubscriber(INDEPENDENT, john_carter);
        post.addSubscriber(INDEPENDENT, new Subscriber("Petrov"));

        post.obtain(NY_POST);
        post.obtain(INDEPENDENT);
        post.removeSubscriber(NY_POST, john_carter);
        post.obtain(NY_POST);
    }
}
