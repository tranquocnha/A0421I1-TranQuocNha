package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo {

        public static int countMinutes(String str)
        {
            String[] times = str.split("-");

            int minutes = 0;

            String dayNight1 = times[0].substring(times[0].length() - 2);

            String dayNight2 = times[1].substring(times[1].length() - 2);

            if(!dayNight1.equals(dayNight2))
                minutes = 720;

            String hour1 = times[0].substring(0, times[0].indexOf(":"));

            String hour2 = times[1].substring(0, times[1].indexOf(":"));

            String minute1 = times[0].substring(times[0].indexOf(":") + 1, times[0].length() - 2);

            String minute2 = times[1].substring(times[1].indexOf(":") + 1, times[1].length() - 2);

            int time1 = Integer.parseInt(hour1) * 60 + Integer.parseInt(minute1);

            int time2 = Integer.parseInt(hour2) * 60 + Integer.parseInt(minute2);

            minutes += time2 - time1;

            if(Integer.signum(minutes) == -1)
                return 1440+minutes;

            return minutes;
        }

        public static void main(String[] args)
        {
            System.out.println(countMinutes("9:30am-10:31pm"));
//
//            System.out.println(countMinutes("1:00-11:00"));
//
//            System.out.println(countMinutes("12:30-12:00"));
//
//            System.out.println(countMinutes("1:23-1:08"));
        }
    }

