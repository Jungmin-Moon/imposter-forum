package threadfiles;

import java.time.LocalDate;

public class User_Threads {
    private String threadName;
    private LocalDate dateCreated;
    private String startedBy;


    public User_Threads(String threadName, LocalDate date, String startedBy) {
        this.threadName = threadName;
        dateCreated = date;
        this.startedBy = startedBy;
    }

    public String getName() {
        return threadName;
    }

    public String getWhoStarted() {
        return startedBy;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

}
