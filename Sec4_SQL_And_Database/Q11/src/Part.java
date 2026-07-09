
public class Part {
    private int partId;
    private String partNumber;
    private String partName;
    private String revision;
    private String state;
    private String createdBy;
    private java.sql.Timestamp createdDate;

    // Constructor
    public Part(int partId, String partNumber, String partName, String revision,
            String state, String createdBy, java.sql.Timestamp createdDate) {
        this.partId = partId;
        this.partNumber = partNumber;
        this.partName = partName;
        this.revision = revision;
        this.state = state;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return String.format(
                "Part [ID=%d, Number=%s, Name=%s, Rev=%s, LifecycleState=%s]",
                partId, partNumber, partName, revision, state);
    }
}
