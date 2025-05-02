# Ez2log

Ez2log is a simple and lightweight logging library for Java. It provides essential logging functionality such as time-stamped logs, customizable log levels, and optional error handling, all with minimal dependencies.

This library is perfect for small projects, quick prototypes, or anyone who wants a straightforward logging solution without the complexity of larger logging frameworks.

## Features

- **Simple API**: Easy-to-use methods for logging messages with different log levels (`INFO`, `WARNING`, `ERROR`).
- **Basic Formatting Support**: Log messages support standard Java string formatting using `String.format`.
- **Throwable Support**: Allows logging exceptions where needed.
- **Thread & Timestamp Information**: Each log message includes the current thread and timestamp for better tracking.
- **Custom PrintStream (Advanced)**: The base `log(...)` method allows specifying a custom `PrintStream` if needed.
- **Minimal Dependencies**: Only requires Java 8 or higher. No additional libraries are needed.

## Installation

To include Ez2log in your project, you can use [JitPack](https://jitpack.io/).

### Gradle

Add the following to your `build.gradle`:

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.AC1original:Ez2log:main-SNAPSHOT'
}
```

### Maven

Add the following to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.AC1original</groupId>
        <artifactId>Ez2log</artifactId>
        <version>main-SNAPSHOT</version>
    </dependency>
</dependencies>
```

## Usage

### Logging an `INFO` message:

```java
Logger.info(this, "This is an info log message");
```

### Logging a `WARNING` message:

```java
Logger.warn(this, "This is a warning log message");
```

### Logging an `ERROR` message:

```java
Logger.error(this, "This is an error log message");
```

### Logging with formatting:

```java
Logger.info(MyClass.class, "User %s has logged in", username);
```

### Logging with a Throwable:

```java
Logger.error(this, "An error occurred", throwable);
```

## Advanced

If you want to log with a custom `PrintStream`, you can use the base `log(...)` method directly:

```java
Logger.log(this, "Custom output stream", LogLevel.INFO, null, myPrintStream);
```

Note: This feature is only available via the generic `log(...)` method, not through `info(...)`, `warn(...)`, or `error(...)`.

## 🤝 Contributing

Feel free to fork this repository, make improvements, and submit a pull request!


## 📬 Contact

For questions or suggestions, feel free to [contact me on Discord](https://discord.com/users/872921450691067924/).

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.