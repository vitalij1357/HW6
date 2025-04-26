package util;

public class MaxProjectClient {
    private String name;
    private long id;
    private long projectCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(long projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectClient{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", projectCount=" + projectCount +
                '}';
    }
}
