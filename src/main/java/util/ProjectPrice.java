package util;

import java.time.LocalDate;

public class ProjectPrice {
    private long projectId;
    private String clientName;
    private LocalDate startDate;
    private LocalDate finishDate;
    private long durationMonth;
    private float projectP;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public long getDurationMonth() {
        return durationMonth;
    }

    public void setDurationMonth(long durationMonth) {
        this.durationMonth = durationMonth;
    }

    public float getProjectP() {
        return projectP;
    }

    public void setProjectP(float projectP) {
        this.projectP = projectP;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "projectId=" + projectId +
                ", clientName='" + clientName + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", durationMonth=" + durationMonth +
                ", projectP=" + projectP +
                '}';
    }
}
