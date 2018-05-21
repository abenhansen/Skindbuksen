import java.util.Calendar;
import java.util.GregorianCalendar;

public class Kalender {
    private GregorianCalendar greg = new GregorianCalendar();
    // cur == current
    private int curDay = greg.get(Calendar.DAY_OF_MONTH);
    private int curMonth = greg.get(Calendar.MONTH);
    private int curYear = greg.get(Calendar.YEAR);

    public String[]
    getDays() {
        String days[] = new String
                [greg.getMaximum(Calendar.DAY_OF_WEEK) - greg.getMinimum(Calendar.DAY_OF_WEEK) + 1];
        greg.set(Calendar.DAY_OF_WEEK, 1);

        for (int i = 0; i < days.length; i++) {
            greg.roll(Calendar.DAY_OF_WEEK, true);
        }
        return days;
    }

    public void decrement(){
        greg.add(Calendar.MONTH, -1);
    }

    public void increment(){
        greg.add(Calendar.MONTH, 1);
    }

    public String getMonthAsString() {
        return String.valueOf(greg.get(Calendar.MONTH)+1).length() == 1 ? "0"+String.valueOf(greg.get(Calendar.MONTH)+1) : String.valueOf(greg.get(Calendar.MONTH)+1);
    }

    public String getYearAsString() {
        return String.valueOf(greg.get(Calendar.YEAR));
    }

    public String getFullTodayAsString() {
        return curDay+"-"+(curMonth+1 < 10 ? "0"+(curMonth+1) : curMonth+1)+"-"+(curDay < 10 ? "0" + curDay : curDay);
    }

    public void goToToday() {
        greg.set(curYear, curMonth, curDay);
    }

    public int getCurDay() {
        return curDay;
    }

    public void setCurDay(int day) {
        greg.set(Calendar.DAY_OF_MONTH, day);
    }

    public int getCurMonth() {
        return curMonth;
    }

    public void setCurMonth(int month) {
        greg.set(Calendar.MONTH, month);
    }

    public int setCurYear() {
        return curYear;
    }

    public void setCurYear(int year) {
        greg.set(Calendar.YEAR, year);
    }
}