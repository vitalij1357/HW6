package util;

import java.time.LocalDate;

public class LongestProject {
    private long id;
    private long clientId;
    private LocalDate startDate;
    private LocalDate finishDate;
    private long projectDuration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public long getProjectDuration() {
        return projectDuration;
    }

    public void setProjectDuration(long projectDuration) {
        this.projectDuration = projectDuration;
    }

    @Override
    public String toString() {
        return "LongestProject\n{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", projectDuration=" + projectDuration +
                '}';
    }
}
