package ru.tsc.sberTask;

public class CustomDataOut<E> {
    private E data;

    public CustomDataOut(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}