package model;

public class WTDocument {

    private String documentNumber; //ex. D1101
    private String documentName; //ex. Gear Drawing
    private DocumentType documentType; 
    private String revision; //ex. A, B, C, AA, etc.
    private LifecycleState lifecycleState;

    public WTDocument(String documentNumber,
            String documentName,
            DocumentType documentType,
            String revision,
            LifecycleState lifecycleState) {

        this.documentNumber = documentNumber;
        this.documentName = documentName;
        this.documentType = documentType;
        this.revision = revision;
        this.lifecycleState = lifecycleState;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getDocumentName() {
        return documentName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public String getRevision() {
        return revision;
    }

    public LifecycleState getLifecycleState() {
        return lifecycleState;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-15s | %-25s | %-15s | %-8s | %-15s |",
                documentNumber,
                documentName,
                documentType,
                revision,
                lifecycleState);
    }
}