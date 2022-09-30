package helper;


import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeHelper {
    public static Long toEpochSecond(LocalDateTime localDateTime)
    {
        return localDateTime.atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }
}
