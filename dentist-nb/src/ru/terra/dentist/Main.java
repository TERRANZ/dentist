package ru.terra.dentist;

/**
 *
 * @author terranz
 */
public class Main
{

    public static void main(String[] args)
    {
	StarterThread st = new StarterThread();
	Thread t = new Thread(st);
	t.start();
    }
}
