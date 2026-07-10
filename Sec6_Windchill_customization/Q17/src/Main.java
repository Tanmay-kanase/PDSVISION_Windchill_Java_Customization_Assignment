import java.util.ArrayList;
import java.util.List;

class Part {
    private String id;
    private String state;

    public Part(String id, String state) {
        this.id = id;
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Document {
    private String id;

    public Document(String id) {
        this.id = id;
    }
}

class ChangeNotice {
    private String id;
    private List<Part> affectedParts;
    private List<Document> affectedDocuments;

    public ChangeNotice(String id) {
        this.id = id;
        this.affectedParts = new ArrayList<>();
        this.affectedDocuments = new ArrayList<>();
    }

    public void addPart(Part part) {
        affectedParts.add(part);
    }

    public void addDocument(Document doc) {
        affectedDocuments.add(doc);
    }

    public void printImpactSummary() {
        int releasedCount = 0;
        int inWorkCount = 0;

        for (Part part : affectedParts) {
            if ("Released".equalsIgnoreCase(part.getState())) {
                releasedCount++;
            } else if ("In Work".equalsIgnoreCase(part.getState())) {
                inWorkCount++;
            }
        }

        System.out.println("Change Notice: " + id);
        System.out.println("Affected Parts: " + affectedParts.size());
        System.out.println("Affected Documents: " + affectedDocuments.size());
        System.out.println("Released Parts: " + releasedCount);
        System.out.println("In Work Parts: " + inWorkCount);
    }
}

public class Main {
    public static void main(String[] args) {
        ChangeNotice cn = new ChangeNotice("CN-001");

        cn.addPart(new Part("PART-101", "Released"));
        cn.addPart(new Part("PART-102", "In Work"));
        cn.addPart(new Part("PART-103", "In Work"));

        cn.addDocument(new Document("DOC-201"));
        cn.addDocument(new Document("DOC-202"));

        cn.printImpactSummary();
    }
}