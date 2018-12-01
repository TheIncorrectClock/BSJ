package com.theincorrectclock.bsj;

class Pair<E1, E2> {

    private E1 first;
    private E2 second;

    static <E1, E2> Pair<E1, E2> pair(E1 first, E2 second) {
        return new Pair<>(first, second);
    }

    private Pair(E1 first, E2 second) {
        this.first = first;
        this.second = second;
    }

    E1 getFirst() {
        return first;
    }

    E2 getSecond() {
        return second;
    }
}
