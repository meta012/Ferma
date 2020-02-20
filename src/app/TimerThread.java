package app;

import java.util.Timer;
import java.util.Date;
import java.util.Calendar;

/**
 * A timer to calculate farmers salary and farm tax expenses periodically
 *
 */
public class TimerThread {
    private final Timer timer;
    private final int month;
    private final int day;
    private final int hour;
    private final int minute;


    public TimerThread(int month, int day, int hour, int minute) {
        timer = new Timer();
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        timer.schedule(new TimerThreadRun(timer), 5*1000); //setTime()

    }

    public Date setTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, day);
        calendar.set(Calendar.MINUTE, hour);
        calendar.set(Calendar.SECOND, minute);
        calendar.set(Calendar.MONTH, month);
        return calendar.getTime();
    }
}