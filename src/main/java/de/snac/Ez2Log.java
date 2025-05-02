package de.snac;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.IllegalFormatException;

public class Ez2Log {

    public static<T> void info(@NotNull T clazz, @NotNull String log, @NotNull Object... format) {
        log(clazz.getClass(), log, LogLevel.INFO, null, null, format);
    }
    public static void info(@NotNull Class<?> clazz, @NotNull String log, @NotNull Object... format) {
        log(clazz, log, LogLevel.INFO, null, null, format);
    }

    public static<T> void warn(@NotNull T clazz, @NotNull String log, @NotNull Object... format) {
        log(clazz.getClass(), log, LogLevel.WARNING, null, null, format);
    }
    public static void warn(@NotNull Class<?> clazz, @NotNull String log, @NotNull Object... format) {
        log(clazz, log, LogLevel.WARNING, null, null, format);
    }

    public static<T> void error(@NotNull T clazz, @NotNull String log, @NotNull Object... format) {
        log(clazz.getClass(), log, LogLevel.ERROR, null, null, format);
    }
    public static void error(@NotNull Class<?> clazz, @NotNull String log, @NotNull Object... format) {
        log(clazz, log, LogLevel.ERROR, null, null, format);
    }
    public static void error(@NotNull Class<?> clazz, @NotNull String log, @NotNull Throwable throwable, @NotNull Object... format) {
        log(clazz, log, LogLevel.ERROR, throwable, null, format);
    }
    public static<T> void error(@NotNull T clazz, @NotNull String log, @NotNull Throwable throwable, @NotNull Object... format) {
        log(clazz.getClass(), log, LogLevel.ERROR, throwable, null, format);
    }

    public static<T> void log(T clazz, @NotNull String log, @NotNull LogLevel level, @Nullable Throwable throwable, @Nullable PrintStream steam, @NotNull Object... format) {
        log(clazz.getClass(), log, level, throwable, steam, format);
    }
    public static void log(@Nullable Class<?> clazz, @NotNull String log, @NotNull LogLevel level, @Nullable Throwable throwable, @Nullable PrintStream steam, @NotNull Object... format) {
        LocalDateTime time = LocalDateTime.now();
        int hours = time.getHour();
        int minutes = time.getMinute();
        int seconds = time.getSecond();
        int milli = time.getNano()/1000;

        try {
            log = String.format(log, format);
        } catch (IllegalFormatException e) {
            log += " [log-message formatting failed]";
        }

        if (steam == null) {
            steam = level.fail ? System.err : System.out;
        }

        String message = String.format("[LOGGER/%s/%s/%d:%d:%d:%d] %s %s", level.name(), Thread.currentThread().getName(), hours, minutes, seconds, milli,
                clazz == null ? "" : clazz.getSimpleName() + ":", log);

        steam.println(message);
        if (throwable != null) {
            throwable.printStackTrace(steam);
        }
    }

    public enum LogLevel {
        INFO(false),
        WARNING(true),
        ERROR(true);

        final boolean fail;
        LogLevel(boolean fail) {
            this.fail = fail;
        }
    }
}
