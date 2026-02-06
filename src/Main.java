import java.util.stream.IntStream;
import java.lang.Runnable;

public class Main implements Runnable {
    private String name;

    public static void main(String[] args) {
        IntStream.range(0, 10).forEach((int i) -> new Thread(
                new Main("Thread" + i)).start()
        );
    }

    public Main(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public void run() {
        LazyInitializedSingleton ls = LazyInitializedSingleton.getInstance();
        System.out.printf("%s: %s%n", this.getName(), ls.hashCode());
    }
}