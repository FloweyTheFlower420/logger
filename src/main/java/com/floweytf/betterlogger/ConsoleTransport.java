package com.floweytf.betterlogger;

public class ConsoleTransport extends Transport {
    public ConsoleTransport(int level) {
        super(System.out, level);
    }

    public ConsoleTransport(int level, PostOutTransform p) {
        super(System.out, level, p);
    }
}
