import net.minecraft.client.option.KeyBinding;
import java.lang.reflect.Constructor;

public class Probe {
    public static void main(String[] args) {
        for (Constructor<?> c : KeyBinding.class.getConstructors()) {
            System.out.println(c.toString());
        }
    }
}
