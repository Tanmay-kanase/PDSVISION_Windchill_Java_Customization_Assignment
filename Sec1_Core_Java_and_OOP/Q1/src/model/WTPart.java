package model;

import java.util.ArrayList;
import java.util.List;

public class WTPart {

    private String partNumber; //ex. P1001
    private String partName; //ex. Gear Assembly
    private String revision; //ex. A , B ,C, AA, BBB etc. 
    private LifecycleState lifecycleState;
    private List<WTDocument> associatedDocuments;

    public WTPart(String partNumber,
            String partName,
            String revision,
            LifecycleState lifecycleState) {

        this.partNumber = partNumber;
        this.partName = partName;
        this.revision = revision;
        this.lifecycleState = lifecycleState;
        this.associatedDocuments = new ArrayList<>();
    }

    public void addDocument(WTDocument document) {
        if (document != null) {
            associatedDocuments.add(document);
        }
    }

    public List<WTDocument> getAssociatedDocuments() {
        return associatedDocuments;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-12s | %-20s | %-8s | %-15s |",
                partNumber,
                partName,
                revision,
                lifecycleState);
    }
}