import com.googlecode.htmlcompressor.compressor.ClosureJavaScriptCompressor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Supplier;

import static com.google.javascript.jscomp.CompilationLevel.ADVANCED_OPTIMIZATIONS;

public class Bug {

    public static void main(final String... args) {
        final var compress = new ClosureJavaScriptCompressor(ADVANCED_OPTIMIZATIONS);
        compress.compress("boe");

        final Object[] objects = fillArray(new Object[10], Object::new);
    }

    public static <T> T[] fillArray(final T[] array, final Supplier<T> generator) {
        for (int i = 0; i < array.length; i++) array[i] = generator.get();
        return array;
    }

}
